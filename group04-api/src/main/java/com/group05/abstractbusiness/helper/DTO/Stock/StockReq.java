package com.group05.abstractbusiness.helper.DTO.Stock;

import java.util.List;

import org.springframework.stereotype.Component;

import com.group05.abstractbusiness.helper.DTO.Business.ProductRes;
import com.group05.abstractbusiness.modules.model.Person.Users.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@Component
@AllArgsConstructor
@NoArgsConstructor
public class StockReq {
    
    String name;
    
    String address;

    User user;

}
