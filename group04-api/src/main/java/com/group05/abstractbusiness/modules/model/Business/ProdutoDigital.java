package com.group05.abstractbusiness.modules.model.Business;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Valid
@Table(name = "digitalPd_tb")
public class ProdutoDigital extends Produto {

    @Column(name = "file_url")
    private String fileUrl;

    @Column(name = "file_type")
    private String fileType;

    @Column(name = "file_size")
    private Double fileSize;

    @Column(name = "download_count")
    private Integer downloadCount;

    @Column(name = "expiry_date")
    private LocalDateTime expiryDate;

    @Column(name = "tipo")
    private final String TIPO = "DIGI";

    public ProdutoDigital(UUID iD, String nome, String descricao, Boolean status, Double custo, Double preco,
            String brand, String category, String subCategory, String image, LocalDate createdAt,
            LocalDate updatedAt, LocalDate deletedAt, String fileUrl, String fileType, Double fileSize,
            Integer downloadCount, LocalDateTime expiryDate) {
        super(iD, nome, descricao, status, custo, preco, brand, category, subCategory, image, createdAt, updatedAt,
                deletedAt);
        this.fileUrl = fileUrl;
        this.fileType = fileType;
        this.fileSize = fileSize;
        this.downloadCount = downloadCount;
        this.expiryDate = expiryDate;
    }

    public ProdutoDigital(String fileUrl, String fileType, Double fileSize, Integer downloadCount,
            LocalDateTime expiryDate) {
        this.fileUrl = fileUrl;
        this.fileType = fileType;
        this.fileSize = fileSize;
        this.downloadCount = downloadCount;
        this.expiryDate = expiryDate;
    }
    
    public ProdutoDigital(){}

}
