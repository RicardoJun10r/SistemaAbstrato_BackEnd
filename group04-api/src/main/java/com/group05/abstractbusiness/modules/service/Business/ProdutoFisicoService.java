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
import com.group05.abstractbusiness.helper.DTO.Business.ProductPhyRes;
import com.group05.abstractbusiness.helper.DTO.Business.ProductRes;
import com.group05.abstractbusiness.modules.model.Business.Produto;
import com.group05.abstractbusiness.modules.model.Business.ProdutoFisico;
import com.group05.abstractbusiness.modules.model.Business.factory.ProdutoFactory;
import com.group05.abstractbusiness.modules.repository.Business.ProdutoFisicoRepository;
import com.group05.abstractbusiness.modules.service.Person.SupplierService;

import jakarta.transaction.Transactional;

@Service
public class ProdutoFisicoService {
    
    @Autowired
    private ProdutoFisicoRepository produtoFisicoRepository;

    @Autowired
    private SupplierService supplierService;

    private ModelMapper mapper = new ModelMapper();

    @Transactional
    public ProductRes createProduct(ProdutoFactory produtoFactory, String emailSupplier){
        
        verifyProduct(produtoFactory.getName());
        
        produtoFactory.setSupplier(this.supplierService.findSupplierByEmail(emailSupplier).get());
        
        ProdutoFisico produtoFisico = produtoFisicoRepository.save(mapper.map(produtoFactory.criarFisico(), ProdutoFisico.class));
        
        return mapper.map(produtoFisico, ProductPhyRes.class);

    }

    private void verifyProduct(String nome){
        Optional<ProdutoFisico> p = produtoFisicoRepository.findByName(nome);
        if(p.isPresent()) throw new ResourceNotAcceptable("Produto já existe");
    }

    public List<ProductRes> findAll(){
        return produtoFisicoRepository.findAll().stream().map(
            produto -> mapper.map(produto, ProductPhyRes.class)
        ).collect(Collectors.toList());
    }

    public ProductRes findById(UUID id){

        Optional<ProdutoFisico> produto = produtoFisicoRepository.findById(id);
        if(produto.isPresent()) return mapper.map(produto, ProductPhyRes.class);
        else throw new ResourceNotFoundException("Produto não encontrado!");

    }

    public ProductRes findByName(String name){

        Optional<ProdutoFisico> produto = produtoFisicoRepository.findByName(name);
        if(produto.isPresent()) return mapper.map(produto, ProductPhyRes.class);
        else throw new ResourceNotFoundException("Produto não encontrado!");

    }

    public List<ProductRes> findByBrand(String brand){
 
        return produtoFisicoRepository.findByBrand(brand).stream().map(
            produto -> mapper.map(produto, ProductPhyRes.class)
        ).collect(Collectors.toList());

    }

    public List<ProductRes> findByCategory(String category){

        return produtoFisicoRepository.findByCategory(category).stream().map(
            produto -> mapper.map(produto, ProductPhyRes.class)
        ).collect(Collectors.toList());

    }

    public List<ProductRes> findBySubcategory(String subcategory){

        return produtoFisicoRepository.findBySubCategory(subcategory).stream().map(
            produto -> mapper.map(produto, ProductPhyRes.class)
        ).collect(Collectors.toList());

    }

    @Transactional
    public ProductRes updateProdutos(UUID id, ProdutoFactory produtoAtualizado){

        Optional<ProdutoFisico> produto = this.produtoFisicoRepository.findById(id);

        updateProduto(produto.get(), produtoAtualizado);

        updateProdutoFisico(produto.get(), produtoAtualizado);

        return mapper.map(this.produtoFisicoRepository.save(produto.get()), ProductPhyRes.class);

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

    private void updateProdutoFisico(ProdutoFisico produtoFisico, ProdutoFactory produto){

        if(produto.getWeight() != null){
            produtoFisico.setWeight(produto.getWeight());
        }

        if(produto.getHeight() != null){
            produtoFisico.setHeight(produto.getHeight());
        }

        if(produto.getWidth() != null){
            produtoFisico.setWidth(produto.getWidth());
        }

        if(produto.getQuantity() != null){
            produtoFisico.setQuantity(produto.getQuantity());
        }

    }

    public String deletar(UUID id){
        produtoFisicoRepository.deleteById(id);
        return "Produto Fisico: [ " + id + " ] deletado";
    }

}
