package com.group05.abstractbusiness.helper.DTO.Business.Teste;

import java.time.LocalDate;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class ProductDigRes extends ProductRes{
    
    String fileUrl;

    String fileType;

    Double fileSize;

    Integer downloadCount;

    LocalDate expiryDate;

}
