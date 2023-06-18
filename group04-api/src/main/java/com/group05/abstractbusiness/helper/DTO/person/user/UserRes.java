package com.group05.abstractbusiness.helper.DTO.person.user;

import java.time.LocalDate;
import java.util.List;

import com.group05.abstractbusiness.helper.DTO.person.supplier.SupplierRes;
import com.group05.abstractbusiness.modules.model.Person.Customer;
import com.group05.abstractbusiness.modules.model.Stock.StockDigital;
import com.group05.abstractbusiness.modules.model.Stock.StockFisico;
import com.group05.abstractbusiness.modules.model.Stock.StockIntelectual;

import lombok.Data;

@Data
public class UserRes {
    
    String name;

    String email;

    LocalDate registerDate;

    List<StockFisico> stockFisicos;

    List<StockDigital> stockDigitais;

    List<StockIntelectual> stockIntelectuais;

    List<SupplierRes> suppliers;

    List<Customer> customers;

}
