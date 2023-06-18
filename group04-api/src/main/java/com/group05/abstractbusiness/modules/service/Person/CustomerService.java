// package com.group05.abstractbusiness.modules.service.Person;

// import org.modelmapper.ModelMapper;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;
// import org.springframework.web.server.ResponseStatusException;
// import java.util.*;

// import com.group05.abstractbusiness.helper.DTO.person.customer.CustomerDTO_PF;
// import com.group05.abstractbusiness.helper.DTO.person.customer.CustomerReturn_PF;
// import com.group05.abstractbusiness.modules.model.Person.Customer;
// import com.group05.abstractbusiness.modules.repository.Person.CustomerRepository;

// @Service
// public class CustomerService {
    
//     @Autowired
//     private CustomerRepository repository;

//     private ModelMapper mapper = new ModelMapper();

//     public CustomerReturn_PF findbyId(UUID id){
//         return mapper.map(
//         (this.repository.findById(id).orElseThrow( 
//             ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "user não econtrado pelo  id [ " + id + " ]"))), CustomerReturn_PF.class);
//     }

//     public CustomerReturn_PF findbyCpf(String cpf){
//         return mapper.map(this.repository.findByCpf(cpf).orElseThrow( 
//             ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "user não econtrado pelo  id [ " + cpf + " ]")), CustomerReturn_PF.class);
//     }


//     public List<CustomerReturn_PF> findbyName(String name){
//         if (this.repository.findByNameContainingIgnoreCase(name).isEmpty()){
//             throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhuma pessoa encontrada com o nome -> " + name + " " + Customer.class.getClass());
//         }else{
//             List<CustomerReturn_PF> suppliers = new ArrayList<>();
//             for(int i = 0; i <  this.repository.findByNameContainingIgnoreCase(name).size();i++){
//                 suppliers.add(i, mapper.map(this.repository.findByNameContainingIgnoreCase(name).get(i), CustomerReturn_PF.class));
//             }
//             return suppliers;
//         }
//     }

//     @Transactional                                                              // Só persiste o dado caso passe todas as informações
//     public Customer createCustomerPF(CustomerDTO_PF customer) {
//         return this.repository.save(mapper.map(customer, Customer.class));
//     }

//     @Transactional
//     public CustomerReturn_PF updateCustomerPF(UUID id,CustomerDTO_PF customer){
//         Customer newObj = this.repository.findById(id).orElseThrow(
//             ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Supplier com id [ " + id  + " ] não encontrado"));
//         newObj.setName(customer.getName());
//         newObj.setAddress(customer.getAddress());
//         newObj.setEmail(customer.getEmail());
//         newObj.setPhone(customer.getPhone());
//         newObj.setCpf_cnpj(customer.getCpf());
//         return mapper.map(this.repository.save(newObj), CustomerReturn_PF.class);
//     } 

//     public void deleteCustomerPF(UUID id){
//         try {
//             this.repository.deleteById(id);
//         } catch (Exception e) {
//             throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Não é possivel excluir pois possui dados relacionados");
//         }
//     }
// }
