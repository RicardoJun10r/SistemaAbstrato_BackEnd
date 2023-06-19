package com.group05.abstractbusiness.modules.service.Person;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group05.abstractbusiness.error.Exception.ResourceBadRequest;
import com.group05.abstractbusiness.error.Exception.ResourceNotAcceptable;
import com.group05.abstractbusiness.error.Exception.ResourceNotFoundException;
import com.group05.abstractbusiness.helper.DTO.person.supplier.SupplierDTO;
import com.group05.abstractbusiness.helper.DTO.person.supplier.SupplierRes;
import com.group05.abstractbusiness.modules.model.Person.Suppliers.Supplier;
import com.group05.abstractbusiness.modules.repository.Person.SupplierRepository;
import com.group05.abstractbusiness.utils.Validator.EmailAndPasswordValidator;

@Service
public class SupplierService {
    
    @Autowired
    private SupplierRepository supplierRepository;

    private ModelMapper mapper = new ModelMapper();

    @Transactional
    public SupplierRes createSupplier(SupplierDTO supplierDTO) {

        if(EmailAndPasswordValidator.verifyEmail(supplierDTO.getEmail())){
            if(supplierRepository.findByEmail(supplierDTO.getEmail()).isPresent()){
                throw new ResourceNotAcceptable("Supplier já existe!");
            }
            return mapper.map(supplierRepository.save(mapper.map(supplierDTO, Supplier.class)), SupplierRes.class);
        }
        throw new ResourceBadRequest("Verifique o e-mail de supplier!");
    }

    public Optional<Supplier> findSupplierByEmail(String email){
        
        Optional<Supplier> supplier = supplierRepository.findByEmail(email);

        if(supplier.isPresent()) return supplier;

        throw new ResourceNotFoundException("Supplier not found!");

    }

}
