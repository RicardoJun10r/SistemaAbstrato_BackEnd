package com.group05.abstractbusiness.modules.service.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.group05.abstractbusiness.error.Exception.ResourceBadRequest;
import com.group05.abstractbusiness.error.Exception.ResourceConditionFailed;
import com.group05.abstractbusiness.error.Exception.ResourceNotAcceptable;
import com.group05.abstractbusiness.error.Exception.ResourceNotFoundException;
import com.group05.abstractbusiness.helper.DTO.CartReturn;
import com.group05.abstractbusiness.helper.DTO.person.supplier.SupplierDTO;
import com.group05.abstractbusiness.helper.DTO.person.user.UserLogin;
import com.group05.abstractbusiness.helper.DTO.person.user.UserPOST;
import com.group05.abstractbusiness.helper.DTO.person.user.UserPUT;
import com.group05.abstractbusiness.helper.DTO.person.user.UserReq;
import com.group05.abstractbusiness.helper.DTO.person.user.UserRes;
import com.group05.abstractbusiness.helper.DTO.person.user.UserReturn;
import com.group05.abstractbusiness.helper.DTO.person.user.UserUpdate;
import com.group05.abstractbusiness.helper.DTO.transaction.TransactionOutDTO;
import com.group05.abstractbusiness.helper.DTO.transaction.TransactionOutReturn;
import com.group05.abstractbusiness.modules.model.Business.ProdutoFisico;
import com.group05.abstractbusiness.modules.model.Business.factory.ProdutoFactory;
import com.group05.abstractbusiness.modules.model.Person.Supplier;
import com.group05.abstractbusiness.modules.model.Person.User;
import com.group05.abstractbusiness.modules.model.Stock.StockFisico;
import com.group05.abstractbusiness.modules.repository.Person.UserRepository;
import com.group05.abstractbusiness.modules.service.CartService;
// import com.group05.abstractbusiness.modules.service.Business.ProdutoService;
// import com.group05.abstractbusiness.modules.service.Stock.StockFisicoService;
import com.group05.abstractbusiness.modules.service.Transaction.TransactionOutService;
import com.group05.abstractbusiness.utils.Enums.TipoProduto;
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

    // @Autowired
    // private SupplierService supplierService;

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

        if(EmailAndPasswordValidator.verifyPassword(userReq.getPassword())){
            
            User user = this.findUser(userReq.getEmail()).get();
            
            if(userReq.getPassword().equals(user.getPassword())){
                this.userRepository.deleteById(user.getId());
                return "Usuário deletado: [ " + user.getName() + " ]";
            }

            throw new ResourceConditionFailed( "E-mail ou senha errado!");
        } 
        throw new ResourceBadRequest( "Cheque e-mail ou senha!");

    }

}
