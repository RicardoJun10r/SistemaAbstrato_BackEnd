package com.group05.abstractbusiness.helper.mapper;

import java.util.Optional;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.group05.abstractbusiness.helper.DTO.person.customer.CustomerDTO_PF;
import com.group05.abstractbusiness.helper.DTO.person.customer.CustomerDTO_PJ;
import com.group05.abstractbusiness.helper.DTO.person.customer.CustomerReturn_PF;
import com.group05.abstractbusiness.helper.DTO.person.customer.CustomerReturn_PJ;
import com.group05.abstractbusiness.modules.model.Person.CustomerPF;
import com.group05.abstractbusiness.modules.model.Person.CustomerPJ;

@Mapper(componentModel = "spring")
public abstract class CustomerMapper {
    public static final CustomerMapper INSTACE = Mappers.getMapper(CustomerMapper.class);


    public abstract CustomerPF toCustomerPF(CustomerDTO_PF customer);
    public abstract CustomerPJ toCustomerPJ(CustomerDTO_PJ customer);

    public abstract CustomerPF toCustomerPF(CustomerReturn_PF customer);
    public abstract CustomerPJ toCustomerPJ(CustomerReturn_PJ customer);

    public abstract CustomerDTO_PF toCustomerDTO(CustomerPF customer);
    public abstract CustomerDTO_PJ toCustomerDTO(CustomerPJ customer);
   
    public abstract CustomerDTO_PF toCustomerDTOOpt_PF(Optional<CustomerPF> customer);
    public abstract CustomerDTO_PJ toCustomerDTOOpt_PJ(Optional<CustomerPJ> customer);

    public abstract CustomerReturn_PF  toCustomerRtn_PF(CustomerDTO_PF customer);
    public abstract CustomerReturn_PJ  toCustomerRtn_PJ(CustomerDTO_PJ customer);

    public abstract CustomerReturn_PF toSupplierCustomerRtnOpt_PF(Optional<CustomerPF> customer);
    public abstract CustomerReturn_PJ toSupplierCustomerRtnOpt_PJ(Optional<CustomerPJ> customer);
}
