package com.group05.abstractbusiness.modules.service.Person;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group05.abstractbusiness.error.Exception.ResourceBadRequest;
import com.group05.abstractbusiness.error.Exception.ResourceConditionFailed;
import com.group05.abstractbusiness.error.Exception.ResourceNotAcceptable;
import com.group05.abstractbusiness.error.Exception.ResourceNotFoundException;
import com.group05.abstractbusiness.helper.DTO.person.customer.CustomerRes;
import com.group05.abstractbusiness.helper.DTO.person.supplier.SupplierDTO;
import com.group05.abstractbusiness.helper.DTO.person.supplier.SupplierRes;
import com.group05.abstractbusiness.helper.DTO.person.user.UserReq;
import com.group05.abstractbusiness.helper.DTO.person.user.UserRes;
import com.group05.abstractbusiness.helper.DTO.person.user.UserUpdate;
import com.group05.abstractbusiness.modules.model.Person.Customers.CustomerFactory;
import com.group05.abstractbusiness.modules.model.Person.Customers.CustomerPF;
import com.group05.abstractbusiness.modules.model.Person.Customers.CustomerPJ;
import com.group05.abstractbusiness.modules.model.Person.Users.User;
import com.group05.abstractbusiness.modules.repository.Person.UserRepository;
import com.group05.abstractbusiness.utils.Enums.TipoCostumer;
import com.group05.abstractbusiness.utils.Validator.EmailAndPasswordValidator;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    // @Autowired
    // private ProdutoService productService;

    // @Autowired
    // private StockFisicoService stockService;

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

}
