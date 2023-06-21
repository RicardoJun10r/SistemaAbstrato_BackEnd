package com.group05.abstractbusiness.helper.DTO.Stock;

import java.util.List;

import com.group05.abstractbusiness.helper.DTO.Business.ProductIntRes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class StockIntRes extends StockRes {
    
    List<ProductIntRes> produtosFisicos;

}
