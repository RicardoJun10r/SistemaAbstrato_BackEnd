package com.group05.abstractbusiness.helper.DTO.transaction;


import lombok.Data;

@Data
public class TransactionOutDTO {
    Double value;
    int discount;
    String customer;
}
