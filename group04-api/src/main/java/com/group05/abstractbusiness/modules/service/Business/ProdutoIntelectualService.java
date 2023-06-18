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
import com.group05.abstractbusiness.helper.DTO.Business.ProductIntRes;
import com.group05.abstractbusiness.helper.DTO.Business.ProductRes;
import com.group05.abstractbusiness.modules.model.Business.Produto;
import com.group05.abstractbusiness.modules.model.Business.ProdutoIntelectual;
import com.group05.abstractbusiness.modules.model.Business.factory.ProdutoFactory;
import com.group05.abstractbusiness.modules.repository.Business.ProdutoIntelectualRepository;

import jakarta.transaction.Transactional;

@Service
public class ProdutoIntelectualService {
    
    @Autowired
    private ProdutoIntelectualRepository produtoIntelectualRepository;

    private ModelMapper mapper = new ModelMapper();

    @Transactional
    public ProductRes createProduct(ProdutoFactory produtoFactory){
        
        verifyProduct(produtoFactory.getName());

        ProdutoIntelectual produtoDigital = produtoIntelectualRepository.save(mapper.map(produtoFactory.criarIntelectual(), ProdutoIntelectual.class));

        return mapper.map(produtoDigital, ProductIntRes.class);

    }

    private void verifyProduct(String nome){
        Optional<ProdutoIntelectual> p = produtoIntelectualRepository.findByName(nome);
        if(p.isPresent()) throw new ResourceNotAcceptable("Produto já existe");
    }

    public List<ProductRes> findAll(){
        return produtoIntelectualRepository.findAll().stream().map(
            produto -> mapper.map(produto, ProductIntRes.class)
        ).collect(Collectors.toList());
    }

    public ProductRes findById(UUID id){

        Optional<ProdutoIntelectual> produto = produtoIntelectualRepository.findById(id);
        if(produto.isPresent()) return mapper.map(produto, ProductIntRes.class);
        else throw new ResourceNotFoundException("Produto não encontrado!");

    }

    public ProductRes findByName(String name){

        Optional<ProdutoIntelectual> produto = produtoIntelectualRepository.findByName(name);
        if(produto.isPresent()) return mapper.map(produto, ProductIntRes.class);
        else throw new ResourceNotFoundException("Produto não encontrado!");

    }

    public List<ProductRes> findByBrand(String brand){
 
        return produtoIntelectualRepository.findByBrand(brand).stream().map(
            produto -> mapper.map(produto, ProductIntRes.class)
        ).collect(Collectors.toList());

    }

    public List<ProductRes> findByCategory(String category){

        return produtoIntelectualRepository.findByCategory(category).stream().map(
            produto -> mapper.map(produto, ProductIntRes.class)
        ).collect(Collectors.toList());

    }

    public List<ProductRes> findBySubcategory(String subcategory){

        return produtoIntelectualRepository.findBySubCategory(subcategory).stream().map(
            produto -> mapper.map(produto, ProductIntRes.class)
        ).collect(Collectors.toList());

    }

    @Transactional
    public ProductRes updateProdutos(UUID id, ProdutoFactory produtoAtualizado){

        Optional<ProdutoIntelectual> produtoIntelectual = this.produtoIntelectualRepository.findById(id);

        updateProduto(produtoIntelectual.get(), produtoAtualizado);

        updateProdutoIntelectual(produtoIntelectual.get(), produtoAtualizado);

        return mapper.map(this.produtoIntelectualRepository.save(produtoIntelectual.get()), ProductIntRes.class);

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

    private void updateProdutoIntelectual(ProdutoIntelectual produtoIntelectual, ProdutoFactory produto){

        if(produto.getAuthor() != null && !produto.getAuthor().isEmpty()){
            produtoIntelectual.setAuthor(produto.getAuthor());
        }

        if(produto.getPublisher() != null && !produto.getPublisher().isEmpty()){
            produtoIntelectual.setPublisher(produto.getPublisher());
        }

        if(produto.getIsbn() != null && !produto.getIsbn().isEmpty()){
            produtoIntelectual.setIsbn(produto.getIsbn());
        }

        if(produto.getPages() != null){
            produtoIntelectual.setPages(produto.getPages());
        }

        if(produto.getEdition() != null){
            produtoIntelectual.setEdition(produto.getEdition());
        }

    }

    public String deletar(UUID id){
        produtoIntelectualRepository.deleteById(id);
        return "Produto Fisico: [ " + id + " ] deletado";
    }
    
}
