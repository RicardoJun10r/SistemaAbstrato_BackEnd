package com.group05.abstractbusiness.helper.DTO.person.customer;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CustomerPJDTO extends CustomerDTO {
    
    String CNPJ;

    String company;

}
