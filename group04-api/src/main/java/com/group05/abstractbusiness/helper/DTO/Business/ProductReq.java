package com.group05.abstractbusiness.helper.DTO.Business;

import java.time.LocalDate;
import com.group05.abstractbusiness.modules.model.Person.Suppliers.Supplier;
import com.group05.abstractbusiness.modules.model.Stock.StockDigital;
import com.group05.abstractbusiness.modules.model.Stock.StockFisico;
import com.group05.abstractbusiness.modules.model.Stock.StockIntelectual;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductReq {

    String name;
    
    String description;
    
    Boolean status;
    
    Double cost;
    
    Double price;
    
    String brand;
    
    String category;
    
    String subCategory;
    
    String image;
    
    String fileUrl;

    String fileType;

    Double fileSize;

    Integer downloadCount;

    LocalDate expiryDate;

    Float weight;

    Float height;

    Float width;

    Integer quantity;
    
    Supplier supplier;

    String author;

    String publisher;

    String isbn;

    Integer pages;

    Integer edition;

    StockFisico stockFisico;

    StockDigital stockDigital;

    StockIntelectual stockIntelectual;

}
