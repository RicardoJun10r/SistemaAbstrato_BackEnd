package com.group05.abstractbusiness.modules.service.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

import com.group05.abstractbusiness.modules.model.Person.Supplier;
import com.group05.abstractbusiness.modules.repository.Person.SupplierRepository;


@Service
public class SupplierService {
    
    @Autowired
    private SupplierRepository repository;

    public Supplier findbyId(UUID id){
        Optional<Supplier> suppliers = this.repository.findById(id);
        return suppliers.orElseThrow( ()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "user não econtrado pelo  id ->" + id));
    }

    public List<Supplier> findbyName(String name){
        List<Supplier> suppliers = repository.findByNameContainingIgnoreCase(name);
        if (suppliers.isEmpty()){
            throw new RuntimeException("Pessoa não encontrada " + name + " " + Supplier.class.getClass());
        }else{
            return suppliers;
        }
    }

    @Transactional                                                              // Só persiste o dado caso passe todas as informações
    public Supplier createSupplier(Supplier supplier) {
        return this.repository.save(supplier);
    }

    @Transactional
    public Supplier updateSupplier(Supplier supplier){
        Supplier newObj = findbyId(supplier.getId());
        newObj.setName(supplier.getName());
        return this.repository.save(newObj);
    } 

    public void deleteSupplier(UUID id){
        try {
            this.repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possivel excluir pois possui dados relacionados");
        }
    }
}
