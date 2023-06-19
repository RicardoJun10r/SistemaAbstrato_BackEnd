package com.group05.abstractbusiness.helper.DTO.person.user;

import java.time.LocalDate;
import java.util.List;

import com.group05.abstractbusiness.helper.DTO.Business.ProductDigRes;
import com.group05.abstractbusiness.helper.DTO.Business.ProductIntRes;
import com.group05.abstractbusiness.helper.DTO.Business.ProductPhyRes;
import com.group05.abstractbusiness.helper.DTO.person.customer.CustomerPFDTO;
import com.group05.abstractbusiness.helper.DTO.person.customer.CustomerPJDTO;
import com.group05.abstractbusiness.helper.DTO.person.supplier.SupplierRes;

import lombok.Data;

@Data
public class UserRes {
    
    String name;

    String email;

    LocalDate registerDate;

    List<ProductPhyRes> stockFisicos;

    List<ProductDigRes> stockDigitais;

    List<ProductIntRes> stockIntelectuais;

    List<SupplierRes> suppliers;

    List<CustomerPFDTO> customerspf;
    
    List<CustomerPJDTO> customerspj;

}
