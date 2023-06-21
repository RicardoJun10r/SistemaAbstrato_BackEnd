package com.group05.abstractbusiness.modules.service.Person;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group05.abstractbusiness.error.Exception.ResourceBadRequest;
import com.group05.abstractbusiness.error.Exception.ResourceConditionFailed;
import com.group05.abstractbusiness.error.Exception.ResourceNotAcceptable;
import com.group05.abstractbusiness.error.Exception.ResourceNotFoundException;
import com.group05.abstractbusiness.helper.DTO.Stock.StockDTO;
import com.group05.abstractbusiness.helper.DTO.Stock.StockReq;
import com.group05.abstractbusiness.helper.DTO.Stock.StockRes;
import com.group05.abstractbusiness.helper.DTO.person.customer.CustomerDTO;
import com.group05.abstractbusiness.helper.DTO.person.customer.CustomerPFDTO;
import com.group05.abstractbusiness.helper.DTO.person.customer.CustomerPJDTO;
import com.group05.abstractbusiness.helper.DTO.person.customer.CustomerRes;
import com.group05.abstractbusiness.helper.DTO.person.supplier.SupplierDTO;
import com.group05.abstractbusiness.helper.DTO.person.supplier.SupplierRes;
import com.group05.abstractbusiness.helper.DTO.person.user.UserReq;
import com.group05.abstractbusiness.helper.DTO.person.user.UserRes;
import com.group05.abstractbusiness.helper.DTO.person.user.UserUpdate;
import com.group05.abstractbusiness.modules.model.Person.IPerson;
import com.group05.abstractbusiness.modules.model.Person.Customers.CustomerFactory;
import com.group05.abstractbusiness.modules.model.Person.Customers.CustomerPF;
import com.group05.abstractbusiness.modules.model.Person.Customers.CustomerPJ;
import com.group05.abstractbusiness.modules.model.Person.Suppliers.Supplier;
import com.group05.abstractbusiness.modules.model.Person.Users.User;
import com.group05.abstractbusiness.modules.repository.Person.UserRepository;
import com.group05.abstractbusiness.modules.service.Stock.StockDigitalService;
import com.group05.abstractbusiness.modules.service.Stock.StockFisicoService;
import com.group05.abstractbusiness.modules.service.Stock.StockIntelectualService;
import com.group05.abstractbusiness.utils.Enums.TipoCostumer;
import com.group05.abstractbusiness.utils.Enums.TipoProduto;
import com.group05.abstractbusiness.utils.Validator.EmailAndPasswordValidator;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    // @Autowired
    // private ProdutoService productService;

    @Autowired
    private StockFisicoService stockFisicoService;

    @Autowired
    private StockDigitalService stockDigitalService;

    @Autowired
    private StockIntelectualService stockIntelectualService;

    // @Autowired
    // private CartService cartService;

    // @Autowired
    // private TransactionOutService transactionService;

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private CustomerService customerService;

    private ModelMapper mapper = new ModelMapper();

    @Transactional
    public UserRes createUser(UserReq userReq){

        if(userRepository.findByEmail(userReq.getEmail()).isPresent()) throw new ResourceNotAcceptable("User já existe");

        if(EmailAndPasswordValidator.verifyPassword(userReq.getPassword()) && EmailAndPasswordValidator.verifyEmail(userReq.getEmail())){
            
            return mapper.map(userRepository.save(mapper.map(userReq, User.class)), UserRes.class);

        }

        throw new ResourceBadRequest("Cheque e-mail ou senha");

    }

    public UserRes findUserByEmail(String email){
        return mapper.map(findUser(email).get() , UserRes.class);
    }

    private Optional<User> findUser(String email){

        Optional<User> user = userRepository.findByEmail(email);

        if(user.isPresent()) return user;

        throw new ResourceNotFoundException("User não encontrado!");

    }

    @Transactional
    public UserRes updateUser(UserUpdate userUpdate){

        if(EmailAndPasswordValidator.verifyPassword(userUpdate.getOldPassword())){

            User user = this.findUser(userUpdate.getOldEmail()).get();
        
            if(user.getPassword().equals(userUpdate.getOldPassword())){
                checkAndUpdate(user, userUpdate);
                return mapper.map(this.userRepository.save(user), UserRes.class);
            }
            throw new ResourceConditionFailed( "E-mail ou senha errado!");
        }
        throw new ResourceBadRequest( "Cheque e-mail ou senha!");

    }

    private void checkAndUpdate(User oldUser, UserUpdate newUser){
        if(newUser.getNewEmail() != null && !newUser.getNewEmail().isEmpty()){
            oldUser.setEmail(newUser.getNewEmail());
        }
        if (newUser.getName() != null && !newUser.getName().isEmpty()){
            oldUser.setName(newUser.getName());
        }
    }

    @Transactional
    public UserRes updatePassword(UserUpdate userUpdate){

        if(EmailAndPasswordValidator.verifyPassword(userUpdate.getOldPassword()) && EmailAndPasswordValidator.verifyPassword(userUpdate.getNewPassword())){

            User user = this.findUser(userUpdate.getOldEmail()).get();
            
            if(userUpdate.getOldPassword().equals(user.getPassword())){
                user.setPassword(userUpdate.getNewPassword());
                return mapper.map(this.userRepository.save(user), UserRes.class);
            } 
            throw new ResourceConditionFailed( "E-mail ou senha errado!");
        }
        throw new ResourceBadRequest( "Cheque e-mail ou senha!");

    }

    @Transactional
    public String deleteUser(UserReq userReq){

        if(EmailAndPasswordValidator.verifyEmail(userReq.getEmail()) && EmailAndPasswordValidator.verifyPassword(userReq.getPassword())){
            
            User user = this.findUser(userReq.getEmail()).get();
            
            if(userReq.getPassword().equals(user.getPassword())){
                this.userRepository.deleteById(user.getId());
                return "Usuário deletado: [ " + user.getName() + " ]";
            }

            throw new ResourceConditionFailed("E-mail ou senha errado!");
        } 
        throw new ResourceBadRequest("Cheque e-mail ou senha!");

    }

    @Transactional
    public SupplierRes createSupplier(String email, SupplierDTO supplierDTO){

        if(EmailAndPasswordValidator.verifyEmail(email)){
            
            User user = this.findUser(email).get();

            supplierDTO.setUser(user);

            SupplierRes supplierRes = supplierService.createSupplier(supplierDTO);

            user.getSuppliers().add(supplierService.findSupplierByEmail(supplierRes.getEmail()).get());

            userRepository.save(user);

            return supplierRes;
            
        }

        throw new ResourceBadRequest("Cheque e-mail ou senha!");

    }

    public List<SupplierRes> findAllSupplier(String email){

        if(EmailAndPasswordValidator.verifyEmail(email)){
            
            User user = this.findUser(email).get();

            List<SupplierRes> suppliers = user.getSuppliers().stream().map(
                supplier -> mapper.map(supplier, SupplierRes.class)
            ).collect(Collectors.toList());
    
            return suppliers;
            
        }

        throw new ResourceBadRequest("Cheque e-mail ou senha!");
    }

    public SupplierRes findSupplier(String supplierEmail){

        if(EmailAndPasswordValidator.verifyEmail(supplierEmail)){
            
            Supplier supplier = supplierService.findSupplierByEmail(supplierEmail).get();

            return mapper.map(supplier, SupplierRes.class);

        }

        throw new ResourceBadRequest("Cheque e-mail ou senha!");
    }

    @Transactional
    public CustomerRes createCustomer(String email, TipoCostumer tipo, CustomerFactory customerFactory){

        if(EmailAndPasswordValidator.verifyEmail(email)){
            
            User user = this.findUser(email).get();

            customerFactory.setUser(user);

            CustomerRes customerRes = customerService.createCustomer(tipo, customerFactory);

            if(tipo == TipoCostumer.PJ){
                user.getCustomersPJ().add((CustomerPJ) customerService.findCustomerByEmail(tipo, customerRes.getEmail()));
            } else{
                user.getCustomersPF().add((CustomerPF) customerService.findCustomerByEmail(tipo, customerRes.getEmail()));
            }

            userRepository.save(user);

            return customerRes;
            
        }

        throw new ResourceBadRequest("Cheque e-mail ou senha!");

    }

    public List<CustomerDTO> findAllCustomer(TipoCostumer tipo, String email){

        if(EmailAndPasswordValidator.verifyEmail(email)){
            
            User user = this.findUser(email).get();

            if(tipo == TipoCostumer.PJ){
                
                return user.getCustomersPJ().stream().map(
                    cutomer -> mapper.map(cutomer, CustomerPJDTO.class)
                ).collect(Collectors.toList());

            } else {
                return user.getCustomersPF().stream().map(
                    cutomer -> mapper.map(cutomer, CustomerPFDTO.class)
                ).collect(Collectors.toList());
            }

            
        }

        throw new ResourceBadRequest("Cheque e-mail ou senha!");
    }

    public IPerson findCustomer(TipoCostumer tipo, String customerEmail){
        return customerService.findCustomerByEmail(tipo, customerEmail);
    }

    public StockRes createStock(String email, TipoProduto tipoProduto, StockReq stockDTO){

        User user = findUser(email).get();

        stockDTO.setUser(user);

        switch (tipoProduto) {
            case FISICO:
                {
                    StockRes stockRes = stockFisicoService.createStock(stockDTO);
                    user.getStockFisicos().add(stockFisicoService.findById(stockRes.getId()));
                    return stockRes;
                }
            case DIGITAL:
                {
                    StockRes stockRes = stockDigitalService.createStock(stockDTO);
                    user.getStockDigitais().add(stockDigitalService.findById(stockRes.getId()));
                    return stockRes;
                }
            case INTELECTUAL:
                {
                    StockRes stockRes = stockDigitalService.createStock(stockDTO);
                    user.getStockIntelectuais().add(stockIntelectualService.findById(stockRes.getId()));
                    return stockRes;
                }
            default:
                throw new ResourceBadRequest("Cheque o tipo do estoque!");
        }

    }

    @SuppressWarnings("unchecked")
    private <T> StockRes findStock(List<?> sList, UUID stock){
        Iterator<?> iterator = sList.iterator();
        while(iterator.hasNext()){
            T stockRes = (T) iterator.next();
            if(((StockRes) stockRes).getId().equals(stock)) return mapper.map(stockRes, StockRes.class);
        }
        throw new ResourceNotFoundException("Stock não encontrado!");
    }

    public StockRes findStock(String email, TipoProduto tipoProduto, UUID idStock){

        User user = findUser(email).get();

        switch (tipoProduto) {
            case FISICO:
                {
                    return findStock(user.getStockFisicos(), idStock);
                }
            case DIGITAL:
                {
                    return findStock(user.getStockDigitais(), idStock);
                }
            case INTELECTUAL:
                {
                    return findStock(user.getStockIntelectuais(), idStock);
                }
            default:
                throw new ResourceBadRequest("Cheque o tipo do estoque!");
        }

    }

    public List<StockRes> findAllStock(String email, TipoProduto tipoProduto){

        User user = findUser(email).get();

        switch (tipoProduto) {
            case FISICO:
                {
                    return user.getStockFisicos().stream().map(
                        stock -> mapper.map(stock, StockRes.class)).collect(Collectors.toList());
                }
            case DIGITAL:
                {
                    return user.getStockDigitais().stream().map(
                        stock -> mapper.map(stock, StockRes.class)).collect(Collectors.toList());
                }
            case INTELECTUAL:
                {
                    return user.getStockIntelectuais().stream().map(
                        stock -> mapper.map(stock, StockRes.class)).collect(Collectors.toList());
                }
            default:
                throw new ResourceBadRequest("Cheque o tipo do estoque!");
        }

    }

}
