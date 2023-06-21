package com.group05.abstractbusiness.helper.DTO.Stock;

import java.util.List;

import com.group05.abstractbusiness.helper.DTO.Business.ProductPhyRes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class StockPhyRes extends StockRes {
    
    String address;

    List<ProductPhyRes> produtosFisicos;

}
