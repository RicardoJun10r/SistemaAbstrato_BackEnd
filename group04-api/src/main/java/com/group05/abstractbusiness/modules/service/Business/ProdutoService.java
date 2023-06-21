package com.group05.abstractbusiness.modules.service.Business;

import java.util.UUID;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group05.abstractbusiness.error.Exception.ResourceBadRequest;
import com.group05.abstractbusiness.helper.DTO.Business.ProductRes;
import com.group05.abstractbusiness.modules.model.Business.factory.ProdutoFactory;
import com.group05.abstractbusiness.utils.Enums.TipoProduto;

import jakarta.transaction.Transactional;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoFisicoService produtoFisicoService;

    @Autowired
    private ProdutoDigitalService produtoDigitalService;

    @Autowired
    private ProdutoIntelectualService produtoIntelectualService;

    @Transactional
    public ProductRes createProduct(TipoProduto tipoProduto, ProdutoFactory produtoFactory, String emailSupplier){
        
        switch (tipoProduto) {
            case FISICO:
                return produtoFisicoService.createProduct(produtoFactory, emailSupplier);

            case DIGITAL:
                return produtoDigitalService.createProduct(produtoFactory);

            case INTELECTUAL:
                return produtoIntelectualService.createProduct(produtoFactory);
        
            default:
                throw new ResourceBadRequest("Cheque o tipo do produto");
        }

    }

    public List<ProductRes> findAll(TipoProduto tipoProduto){

        switch (tipoProduto) {
            case FISICO:
                return produtoFisicoService.findAll();

            case DIGITAL:
                return produtoDigitalService.findAll();

            case INTELECTUAL:
                return produtoIntelectualService.findAll();
        
            default:
                throw new ResourceBadRequest("Cheque o tipo de produto");
        }

    }

    public ProductRes findById(TipoProduto tipoProduto, UUID id){

        switch (tipoProduto) {
            case FISICO:
                return produtoFisicoService.findById(id);

            case DIGITAL:
                return produtoDigitalService.findById(id);

            case INTELECTUAL:
                return produtoIntelectualService.findById(id);
        
            default:
                throw new ResourceBadRequest("Cheque o tipo de produto");
        }

    }

    public ProductRes findByName(TipoProduto tipoProduto, String name){

        switch (tipoProduto) {
            case FISICO:
                return produtoFisicoService.findByName(name);

            case DIGITAL:
                return produtoDigitalService.findByName(name);

            case INTELECTUAL:
                return produtoIntelectualService.findByName(name);
        
            default:
                throw new ResourceBadRequest("Cheque o tipo de produto");
        }

    }

    public List<ProductRes> findByBrand(TipoProduto tipoProduto, String brand){
        
        switch (tipoProduto) {
            case FISICO:
                return produtoFisicoService.findByBrand(brand);

            case DIGITAL:
                return produtoDigitalService.findByBrand(brand);

            case INTELECTUAL:
                return produtoIntelectualService.findByBrand(brand);
        
            default:
                throw new ResourceBadRequest("Cheque o tipo de produto");
        }

    }

    public List<ProductRes> findByCategory(TipoProduto tipoProduto, String category){

        switch (tipoProduto) {
            case FISICO:
                return produtoFisicoService.findByCategory(category);

            case DIGITAL:
                return produtoDigitalService.findByCategory(category);

            case INTELECTUAL:
                return produtoIntelectualService.findByCategory(category);
        
            default:
                throw new ResourceBadRequest("Cheque o tipo de produto");
        }
        
    }

    public List<ProductRes> findBySubcategory(TipoProduto tipoProduto, String subcategory){

        switch (tipoProduto) {
            
            case FISICO:
                return produtoFisicoService.findBySubcategory(subcategory);

            case DIGITAL:
                return produtoDigitalService.findBySubcategory(subcategory);

            case INTELECTUAL:
                return produtoIntelectualService.findBySubcategory(subcategory);
        
            default:
                throw new ResourceBadRequest("Cheque o tipo de produto");
        }

    }

    @Transactional
    public ProductRes updateProdutos(TipoProduto tipoProduto, UUID id, ProdutoFactory produtoAtualizado){

        switch (tipoProduto) {
            case FISICO:
                return produtoFisicoService.updateProdutos(id, produtoAtualizado);

            case DIGITAL:
                return produtoDigitalService.updateProdutos(id, produtoAtualizado);

            case INTELECTUAL:
                return produtoIntelectualService.updateProdutos(id, produtoAtualizado);
        
            default:
                throw new ResourceBadRequest("Cheque o tipo de produto");
        }

    }

    public String deletar(TipoProduto tipoProduto, UUID id){

        switch (tipoProduto) {
            case FISICO:
                return produtoFisicoService.deletar(id);

            case DIGITAL:
                return produtoDigitalService.deletar(id);

            case INTELECTUAL:
                return produtoIntelectualService.deletar(id);
        
            default:
                throw new ResourceBadRequest("Cheque o tipo de produto");
        }

    }
    
}
