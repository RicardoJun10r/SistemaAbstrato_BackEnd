package com.group05.abstractbusiness.helper.DTO.Business;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoFisicoDTO {
    
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

    private Float weight;

    private Float height;

    private Float width;

    private Integer quantidade;
}
