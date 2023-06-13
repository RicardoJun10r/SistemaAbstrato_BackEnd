package com.group05.abstractbusiness.helper.DTO.Business.Teste;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class ProductIntRes extends ProductRes{
    
    String author;

    String publisher;

    String isbn;

    int pages;

    int edition;

}
