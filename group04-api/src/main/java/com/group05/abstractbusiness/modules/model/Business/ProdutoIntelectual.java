package com.group05.abstractbusiness.modules.model.Business;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.group05.abstractbusiness.modules.model.Stock.StockProducts;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "intelectualPd_tb")
@Getter
@Setter
@Valid
public class ProdutoIntelectual extends Produto {
    
    @Column(name = "author")
    private String author;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "pages")
    private int pages;

    @Column(name = "edition")
    private int edition;

    @Column(name = "tipo")
    private final String TIPO = "INTE";

    @JsonBackReference
    @ManyToOne
    private StockProducts stock;

    public ProdutoIntelectual(UUID iD, String nome, String descricao, Boolean status, Double custo, Double preco,
            String brand, String category, String subCategory, String image, LocalDate createdAt,
            LocalDate updatedAt, LocalDate deletedAt, String author, String publisher, String isbn, int pages,
            int edition) {
        super(iD, nome, descricao, status, custo, preco, brand, category, subCategory, image, createdAt, updatedAt,
                deletedAt);
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.pages = pages;
        this.edition = edition;
    }

    public ProdutoIntelectual(String author, String publisher, String isbn, int pages, int edition) {
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.pages = pages;
        this.edition = edition;
    }

    public ProdutoIntelectual(){}

}
