package com.group05.abstractbusiness.model.Business.factory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.group05.abstractbusiness.model.Business.Produto;
import com.group05.abstractbusiness.model.Business.ProdutoDigital;
import com.group05.abstractbusiness.model.Business.ProdutoFisico;
import com.group05.abstractbusiness.model.Business.ProdutoIntelectual;

import lombok.Getter;
import lombok.Setter;

/**
 *  FACTORY de produtos INTELECTUAIS
 */
@Component
@Getter
@Setter
public class ProdutoFactory implements AbstractFactoryProduto {

    private UUID ID;
    
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

    public ProdutoFactory(UUID iD, String nome, String descricao, Boolean status, Double custo, Double preco,
            String brand, String category, String subCategory, String image, LocalDate createdAt,
            LocalDate updatedAt, LocalDate deletedAt, String author, String publisher, String isbn, int pages,
            int edition) {
        this.ID = iD;
        this.nome = nome;
        this.descricao = descricao;
        this.status = status;
        this.custo = custo;
        this.preco = preco;
        this.brand = brand;
        this.category = category;
        this.subCategory = subCategory;
        this.image = image;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.pages = pages;
        this.edition = edition;
    }

    public ProdutoFactory(UUID iD, String nome, String descricao, Boolean status, Double custo, Double preco,
            String brand, String category, String subCategory, String image, LocalDate createdAt,
            LocalDate updatedAt, LocalDate deletedAt, Float weight, Float height, Float width,
            String imageUrl) {
        this.ID = iD;
        this.nome = nome;
        this.descricao = descricao;
        this.status = status;
        this.custo = custo;
        this.preco = preco;
        this.brand = brand;
        this.category = category;
        this.subCategory = subCategory;
        this.image = image;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        this.weight = weight;
        this.height = height;
        this.width = width;
        this.imageUrl = imageUrl;
    }

    public ProdutoFactory(UUID iD, String nome, String descricao, Boolean status, Double custo, Double preco,
            String brand, String category, String subCategory, String image, LocalDate createdAt,
            LocalDate updatedAt, LocalDate deletedAt, String fileUrl, String fileType, Double fileSize,
            Integer downloadCount, LocalDateTime expiryDate) {
        this.ID = iD;
        this.nome = nome;
        this.descricao = descricao;
        this.status = status;
        this.custo = custo;
        this.preco = preco;
        this.brand = brand;
        this.category = category;
        this.subCategory = subCategory;
        this.image = image;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        this.fileUrl = fileUrl;
        this.fileType = fileType;
        this.fileSize = fileSize;
        this.downloadCount = downloadCount;
        this.expiryDate = expiryDate;
    }

    public ProdutoFactory(){}

    @Override
    public Produto criarFisco() {
        return new ProdutoFisico(ID, nome, descricao, status, custo, preco, brand, category, subCategory, 
        image, createdAt, updatedAt, deletedAt, weight, height, width, imageUrl);
    }

    @Override
    public Produto criarDigital() {
        return new ProdutoDigital(ID, nome, descricao, status, custo, preco, brand, category, subCategory, image, 
        createdAt, updatedAt, deletedAt, fileUrl, fileType, fileSize, downloadCount, expiryDate);
    }

    @Override
    public Produto criarIntelectual() {
        return new ProdutoIntelectual(ID, nome, descricao, status, custo, preco, brand, category, subCategory, 
        image, createdAt, updatedAt, deletedAt, author, publisher, isbn, pages, edition);
    }

}
