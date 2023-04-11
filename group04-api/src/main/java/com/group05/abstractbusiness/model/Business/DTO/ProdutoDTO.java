package com.group05.abstractbusiness.model.Business.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDTO {

    private UUID iD;
    
    private String nome;
    
    private String descricao;
    
    private Boolean status;
    
    private Double custo;
    
    private Double preco;
    
    private String brand;
    
    private String category;
    
    private String subCategory;
    
    private String image;
    
    private LocalDate createdAt;
    
    private LocalDate updatedAt;
    
    private LocalDate deletedAt;

    private String fileUrl;

    private String fileType;

    private Double fileSize;

    private Integer downloadCount;

    private LocalDateTime expiryDate;

    private Float weight;

    private Float height;

    private Float width;

    private String imageUrl;

    private String author;

    private String publisher;

    private String isbn;

    private int pages;

    private int edition;
    
}
