package com.group05.abstractbusiness.helper.mapper;

import java.util.Optional;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.group05.abstractbusiness.helper.DTO.person.supplier.SupplierDTO;
import com.group05.abstractbusiness.helper.DTO.person.supplier.SupplierReturn;
import com.group05.abstractbusiness.modules.model.Person.Supplier;

@Mapper(componentModel = "spring")
public abstract class SupplierMapper {
    public static final SupplierMapper INSTACE = Mappers.getMapper(SupplierMapper.class);


    public abstract Supplier toSupplier(SupplierDTO supplier);

    public abstract Supplier toSupplier(SupplierReturn supplier);

    public abstract SupplierDTO toSupplierDTO(Supplier userPost);
   
    public abstract SupplierDTO toSupplierDTOOptional(Optional<Supplier> userPost);

    public abstract SupplierReturn  toSupplierReturn(Supplier userPost);

    public abstract SupplierReturn toSupplierReturnOptional(Optional<Supplier> userPost);

}