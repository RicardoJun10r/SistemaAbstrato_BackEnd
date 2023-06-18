package com.group05.abstractbusiness.modules.service.Business;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group05.abstractbusiness.error.Exception.ResourceNotAcceptable;
import com.group05.abstractbusiness.error.Exception.ResourceNotFoundException;
import com.group05.abstractbusiness.helper.DTO.Business.ProductDigRes;
import com.group05.abstractbusiness.helper.DTO.Business.ProductRes;
import com.group05.abstractbusiness.modules.model.Business.Produto;
import com.group05.abstractbusiness.modules.model.Business.ProdutoDigital;
import com.group05.abstractbusiness.modules.model.Business.factory.ProdutoFactory;
import com.group05.abstractbusiness.modules.repository.Business.ProdutoDigitalRepository;

import jakarta.transaction.Transactional;

@Service
public class ProdutoDigitalService {
    
    @Autowired
    private ProdutoDigitalRepository produtoDigitalRepository;

    private ModelMapper mapper = new ModelMapper();

    @Transactional
    public ProductRes createProduct(ProdutoFactory produtoFactory){
        
        verifyProduct(produtoFactory.getName());
        
        ProdutoDigital produtoDigital = produtoDigitalRepository.save(mapper.map(produtoFactory.criarDigital(), ProdutoDigital.class));
        
        return mapper.map(produtoDigital, ProductDigRes.class);

    }

    private void verifyProduct(String nome){
        Optional<ProdutoDigital> p = produtoDigitalRepository.findByName(nome);
        if(p.isPresent()) throw new ResourceNotAcceptable("Produto já existe");
    }

    public List<ProductRes> findAll(){
        return produtoDigitalRepository.findAll().stream().map(
            produto -> mapper.map(produto, ProductDigRes.class)
        ).collect(Collectors.toList());
    }

    public ProductRes findById(UUID id){

        Optional<ProdutoDigital> produto = produtoDigitalRepository.findById(id);
        if(produto.isPresent()) return mapper.map(produto, ProductDigRes.class);
        else throw new ResourceNotFoundException("Produto não encontrado!");

    }

    public ProductRes findByName(String name){

        Optional<ProdutoDigital> produto = produtoDigitalRepository.findByName(name);
        if(produto.isPresent()) return mapper.map(produto, ProductDigRes.class);
        else throw new ResourceNotFoundException("Produto não encontrado!");

    }

    public List<ProductRes> findByBrand(String brand){
 
        return produtoDigitalRepository.findByBrand(brand).stream().map(
            produto -> mapper.map(produto, ProductDigRes.class)
        ).collect(Collectors.toList());

    }

    public List<ProductRes> findByCategory(String category){

        return produtoDigitalRepository.findByCategory(category).stream().map(
            produto -> mapper.map(produto, ProductDigRes.class)
        ).collect(Collectors.toList());

    }

    public List<ProductRes> findBySubcategory(String subcategory){

        return produtoDigitalRepository.findBySubCategory(subcategory).stream().map(
            produto -> mapper.map(produto, ProductDigRes.class)
        ).collect(Collectors.toList());

    }

    @Transactional
    public ProductRes updateProdutos(UUID id, ProdutoFactory produtoAtualizado){

        Optional<ProdutoDigital> produtoDigital = this.produtoDigitalRepository.findById(id);

        updateProduto(produtoDigital.get(), produtoAtualizado);

        updateProdutoDigital(produtoDigital.get(), produtoAtualizado);

        return mapper.map(this.produtoDigitalRepository.save(produtoDigital.get()), ProductDigRes.class);

    }

    private void updateProduto(Produto produto, ProdutoFactory produtoFactory){

        if(produtoFactory.getName() != null && !produtoFactory.getName().isEmpty()){
            produto.setName(produtoFactory.getName());
        }

        if(produtoFactory.getDescription() != null && !produtoFactory.getDescription().isEmpty()){
            produto.setDescription(produtoFactory.getDescription());
        }

        if(produtoFactory.getStatus() != null){
            produto.setStatus(produtoFactory.getStatus());
        }

        if(produtoFactory.getCost() != null){
            produto.setCost(produtoFactory.getCost());
        }

        if(produtoFactory.getPrice() != null){
            produto.setPrice(produtoFactory.getPrice());
        }

        if(produtoFactory.getBrand() != null && !produtoFactory.getBrand().isEmpty()){
            produto.setBrand(produtoFactory.getBrand());
        }

        if(produtoFactory.getCategory() != null && !produtoFactory.getCategory().isEmpty()){
            produto.setCategory(produtoFactory.getCategory());
        }

        if(produtoFactory.getSubCategory() != null && !produtoFactory.getSubCategory().isEmpty()){
            produto.setSubCategory(produtoFactory.getSubCategory());
        }

        if(produtoFactory.getImage() != null && !produtoFactory.getImage().isEmpty()){
            produto.setImage(produtoFactory.getImage());
        }

        if(produtoFactory.getUpdatedAt() != null){
            produto.setUpdatedAt(produtoFactory.getUpdatedAt());
        }

    }

    private void updateProdutoDigital(ProdutoDigital produtoDigital, ProdutoFactory produto){

        if(produto.getFileUrl() != null && !produto.getFileUrl().isEmpty()){
            produtoDigital.setFileUrl(produto.getFileUrl());
        }

        if(produto.getFileType() != null && !produto.getFileType().isEmpty()){
            produtoDigital.setFileType(produto.getFileType());
        }

        if(produto.getFileSize() != null){
            produtoDigital.setFileSize(produto.getFileSize());
        }

        if(produto.getExpiryDate() != null){
            produtoDigital.setExpiryDate(produto.getExpiryDate());
        }

    }

    public String deletar(UUID id){
        produtoDigitalRepository.deleteById(id);
        return "Produto Fisico: [ " + id + " ] deletado";
    }

}
