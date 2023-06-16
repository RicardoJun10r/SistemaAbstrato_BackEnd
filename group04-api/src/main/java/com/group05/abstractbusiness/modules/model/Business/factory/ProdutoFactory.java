package com.group05.abstractbusiness.modules.model.Business.factory;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.group05.abstractbusiness.modules.model.Business.Produto;
import com.group05.abstractbusiness.modules.model.Business.ProdutoDigital;
import com.group05.abstractbusiness.modules.model.Business.ProdutoFisico;
import com.group05.abstractbusiness.modules.model.Business.ProdutoIntelectual;
import com.group05.abstractbusiness.modules.model.Person.Supplier;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class ProdutoFactory implements AbstractFactoryProduto {

    private UUID ID;

    private String name;
    
    private String description;
    
    private Boolean status;
    
    private Double cost;
    
    private Double price;
    
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

    private LocalDate expiryDate;

    private Float weight;

    private Float height;

    private Float width;

    private Integer quantity;
    
    private Supplier supplier;

    private String author;

    private String publisher;

    private String isbn;

    private Integer pages;

    private Integer edition;

    public ProdutoFactory(UUID iD, String nome, String descricao, Boolean status, Double custo, Double preco,
            String brand, String category, String subCategory, String image, LocalDate createdAt,
            LocalDate updatedAt, LocalDate deletedAt, String author, String publisher, String isbn, Integer pages,
            Integer edition) {
        this.ID = iD;
        this.name = nome;
        this.description = descricao;
        this.status = status;
        this.cost = custo;
        this.price = preco;
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
            Integer quantidade, Supplier supplier) {
        this.ID = iD;
        this.name = nome;
        this.description = descricao;
        this.status = status;
        this.cost = custo;
        this.price = preco;
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
        this.quantity = quantidade;
        this.supplier = supplier;
    }

    public ProdutoFactory(UUID iD, String nome, String descricao, Boolean status, Double custo, Double preco,
            String brand, String category, String subCategory, String image, LocalDate createdAt,
            LocalDate updatedAt, LocalDate deletedAt, String fileUrl, String fileType, Double fileSize,
            Integer downloadCount, LocalDate expiryDate) {
        this.ID = iD;
        this.name = nome;
        this.description = descricao;
        this.status = status;
        this.cost = custo;
        this.price = preco;
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
        return new ProdutoFisico(ID, name, description, status, cost, price, brand, category, subCategory, 
        image, createdAt, updatedAt, deletedAt, weight, height, width, quantity, supplier);
    }

    @Override
    public Produto criarDigital() {
        return new ProdutoDigital(ID, name, description, status, cost, price, brand, category, subCategory, image, 
        createdAt, updatedAt, deletedAt, fileUrl, fileType, fileSize, downloadCount, expiryDate);
    }

    @Override
    public Produto criarIntelectual() {
        return new ProdutoIntelectual(ID, name, description, status, cost, price, brand, category, subCategory, 
        image, createdAt, updatedAt, deletedAt, author, publisher, isbn, pages, edition);
    }
}
