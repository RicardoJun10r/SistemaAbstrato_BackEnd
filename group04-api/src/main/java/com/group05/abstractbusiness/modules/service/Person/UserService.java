package com.group05.abstractbusiness.modules.service.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.server.ResponseStatusException;

import com.group05.abstractbusiness.helper.DTO.Business.ProdutoFisicoDTO;
import com.group05.abstractbusiness.helper.DTO.person.user.UserLogin;
import com.group05.abstractbusiness.helper.DTO.person.user.UserPOST;
import com.group05.abstractbusiness.helper.DTO.person.user.UserPUT;
import com.group05.abstractbusiness.helper.DTO.person.user.UserReturn;
import com.group05.abstractbusiness.helper.mapper.UserMapper;
import com.group05.abstractbusiness.modules.model.Business.ProdutoFisico;
import com.group05.abstractbusiness.modules.model.Person.User;
import com.group05.abstractbusiness.modules.repository.Business.ProdutoFisicoRepository;
import com.group05.abstractbusiness.modules.repository.Person.UserRepository;
import com.group05.abstractbusiness.modules.service.Business.ProdutoFisicoService;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;

    @Autowired
    private ProdutoFisicoService productService;

    ModelMapper model = new ModelMapper();

    public User authenticate(UserLogin user){
        try {
            Optional<User> aux = repository.findByLogin(user.getLogin());
            if(aux.isEmpty()){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,"user não encontrado");
            } else {
                if(aux.get().getPassword().equals(user.getPassword()))
                    return aux.get();
                else
                    throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"Senha errada");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public UserReturn findbyId(UUID id){
        try {
            if(repository.findById(id).isEmpty()){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,"user não encontrado");
            }else{
                UserReturn user = model.map(repository.findById(id).get(), UserReturn.class);
                return user;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public List<UserReturn> findbyName(String name){
        if (this.repository.findByNameContainingIgnoreCase(name).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Pessoa não encontrada " + name + " " + User.class.getClass());
        }else{
            List<UserReturn> users = new ArrayList<>();
            for(int i = 0; i < this.repository.findByNameContainingIgnoreCase(name).size();i++){
            users.add(i, model.map(this.repository.findByNameContainingIgnoreCase(name).get(i), UserReturn.class));
            }
            return users;
        }
    }

    public UserReturn findbyUsername(String username){
        if (this.repository.findByLogin(username).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Pessoa não encontrada " + username + " " + User.class.getClass());
        }else{
            return model.map(repository.findByLogin(username).get(), UserReturn.class);
        }
    }

    public boolean createProduct(ProdutoFisicoDTO produto, UUID idSuplier){
        boolean result = false;
        try {
            ProdutoFisico aux = model.map(produto, ProdutoFisico.class);
            ProdutoFisico aux2 = productService.create(aux, idSuplier);
            if(aux2 == null)
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Produto não criado");
            else
                result = true;
        } catch (ResponseStatusException e) {
            return false;
        }
        return result;
    }

    @Transactional                                           // Só persiste o dado caso passe todas as informações
    public UserReturn createUser(UserPOST user) {
        return model.map(this.repository.save(model.map(user, User.class)), UserReturn.class);
    }

    @Transactional
    public UserReturn updateUser(UserPUT user){
        //TO-DO utilizar metodo findbyId da propria classe.
        User userFind = this.repository.findById(user.getId())
        .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "User com o id [ "+ user.getId() + " ] não encontrado"));
        
        // Validando password
        if(userFind.getPassword().equals(user.getPassword())){
            userFind.setName(user.getName());               // Atualizando Nome
            userFind.setLogin(user.getLogin());             // Atualizando Login
            return model.map(this.repository.save(userFind), UserReturn.class);
        }else{
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, "Password incorreto");
        }
    } 


    public void deleteUser(UUID id){
        if(this.repository.existsById(id)){
            repository.deleteById(id);
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User com id [ " + id + " ] não encontrado");
        }
    }
}
