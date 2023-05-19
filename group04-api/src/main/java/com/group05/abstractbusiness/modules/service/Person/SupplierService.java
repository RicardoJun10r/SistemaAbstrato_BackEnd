package com.group05.abstractbusiness.modules.service.Person;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

import com.group05.abstractbusiness.helper.DTO.person.supplier.SupplierDTO;
import com.group05.abstractbusiness.helper.DTO.person.supplier.SupplierReturn;
import com.group05.abstractbusiness.modules.model.Person.Supplier;
import com.group05.abstractbusiness.modules.repository.Person.SupplierRepository;


@Service
public class SupplierService {
    
    @Autowired
    private SupplierRepository repository;

    private ModelMapper mapper = new ModelMapper();

    public SupplierReturn findbyId(UUID id){
        return mapper.map(this.repository.findById(id).orElseThrow(
            ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "user não econtrado pelo  id ->" + id)), SupplierReturn.class);
    }

    public List<SupplierReturn> findbyName(String name){
        if (this.repository.findByNameContainingIgnoreCase(name).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrada " + name + " " + Supplier.class.getClass());
        }else{
            List<SupplierReturn> suppliers = new ArrayList<>();
            for(int i = 0; i <  this.repository.findByNameContainingIgnoreCase(name).size();i++){
                suppliers.add(i, mapper.map(this.repository.findByNameContainingIgnoreCase(name).get(i), SupplierReturn.class));
            }
            return suppliers;
        }
    }

    public List<SupplierReturn> findbyEmail(String email){
        if (this.repository.findByEmail(email).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrada ");
        }else{
            List<SupplierReturn> suppliers = new ArrayList<>();
            for(int i = 0; i <  this.repository.findByEmail(email).size();i++){
                suppliers.add(i, mapper.map(this.repository.findByEmail(email).get(i), SupplierReturn.class));
            }
            return suppliers;
        }
    }

    public List<SupplierReturn> findbyPhone(String phone){
        if (this.repository.findByPhone(phone).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrada ");
        }else{
            List<SupplierReturn> suppliers = new ArrayList<>();
            for(int i = 0; i <  this.repository.findByPhone(phone).size();i++){
                suppliers.add(i, mapper.map(this.repository.findByPhone(phone).get(i), SupplierReturn.class));
            }
            return suppliers;
        }
    }

    @Transactional                                                              // Só persiste o dado caso passe todas as informações
    public Supplier createSupplier(SupplierDTO supplier) {
        if(repository.findByEmail(supplier.getEmail()).isEmpty()){
            return this.repository.save(mapper.map(supplier, Supplier.class));
        }else{
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, "Supplier já existente com esse email");
        }
    }

    @Transactional
    public SupplierReturn updateSupplier(UUID id, SupplierDTO supplier){
        Supplier newObj = this.repository.findById(id).orElseThrow(
            ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Supplier com id [ " + id  + " ] não encontrado"));
        newObj.setName(supplier.getName());
        newObj.setAddress(supplier.getAddress());
        newObj.setEmail(supplier.getEmail());
        newObj.setPhone(supplier.getPhone());
        return mapper.map(this.repository.save(newObj), SupplierReturn.class);
        } 

    public void deleteSupplier(UUID id){
        try {
            this.repository.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Não é possivel excluir pois possui dados relacionados");
        }
    }
}
