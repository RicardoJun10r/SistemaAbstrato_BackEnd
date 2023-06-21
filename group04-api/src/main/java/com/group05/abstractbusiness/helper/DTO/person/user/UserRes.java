package com.group05.abstractbusiness.helper.DTO.person.user;

import java.time.LocalDate;
import java.util.List;

import com.group05.abstractbusiness.helper.DTO.Stock.StockDigRes;
import com.group05.abstractbusiness.helper.DTO.Stock.StockIntRes;
import com.group05.abstractbusiness.helper.DTO.Stock.StockPhyRes;
import com.group05.abstractbusiness.helper.DTO.person.customer.CustomerPFDTO;
import com.group05.abstractbusiness.helper.DTO.person.customer.CustomerPJDTO;
import com.group05.abstractbusiness.helper.DTO.person.supplier.SupplierRes;

import lombok.Data;

@Data
public class UserRes {
    
    String name;

    String email;

    LocalDate registerDate;

    List<StockPhyRes> stockFisicos;

    List<StockDigRes> stockDigitais;

    List<StockIntRes> stockIntelectuais;

    List<SupplierRes> suppliers;

    List<CustomerPFDTO> customerspf;
    
    List<CustomerPJDTO> customerspj;

}
