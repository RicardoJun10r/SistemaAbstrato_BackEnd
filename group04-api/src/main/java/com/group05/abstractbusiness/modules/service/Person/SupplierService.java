package com.group05.abstractbusiness.modules.service.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

import com.group05.abstractbusiness.helper.DTO.person.supplier.SupplierDTO;
import com.group05.abstractbusiness.helper.DTO.person.supplier.SupplierReturn;
import com.group05.abstractbusiness.helper.mapper.SupplierMapper;
import com.group05.abstractbusiness.modules.model.Person.Supplier;
import com.group05.abstractbusiness.modules.repository.Person.SupplierRepository;


@Service
public class SupplierService {
    
    @Autowired
    private SupplierRepository repository;

    public SupplierReturn findbyId(UUID id){
        this.repository.findById(id).orElseThrow( ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "user não econtrado pelo  id ->" + id));
        return SupplierMapper.INSTACE.toSupplierReturnOptional(this.repository.findById(id));
    }

    public List<SupplierReturn> findbyName(String name){
        if (this.repository.findByNameContainingIgnoreCase(name).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrada " + name + " " + Supplier.class.getClass());
        }else{
            List<SupplierReturn> suppliers = new ArrayList<>();
            for(int i = 0; i <  this.repository.findByNameContainingIgnoreCase(name).size();i++){
                suppliers.add(i, SupplierMapper.INSTACE
                .toSupplierReturn(this.repository.findByNameContainingIgnoreCase(name).get(i)));
            }
            return suppliers;
        }
    }

    @Transactional                                                              // Só persiste o dado caso passe todas as informações
    public Supplier createSupplier(SupplierDTO supplier) {
        return this.repository.save(SupplierMapper.INSTACE.toSupplier(supplier));
    }

    @Transactional
    public SupplierReturn updateSupplier(UUID id, SupplierDTO supplier){
        if(repository.findById(id).isPresent()){
        Supplier newObj = SupplierMapper.INSTACE.toSupplier(findbyId(id));
        newObj.setName(supplier.getName());
        newObj.setAddress(supplier.getAddress());
        newObj.setEmail(supplier.getEmail());
        newObj.setPhone(supplier.getPhone());
        return SupplierMapper.INSTACE.toSupplierReturn(this.repository.save(newObj));
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Supplier com id [ " + id + " ] não encontrado");
        }
    } 

    public void deleteSupplier(UUID id){
        try {
            this.repository.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Não é possivel excluir pois possui dados relacionados");
        }
    }
}
