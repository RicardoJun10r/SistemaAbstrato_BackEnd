package com.group05.abstractbusiness.modules.service.Business;

import java.util.Optional;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.group05.abstractbusiness.error.Exception.ResourceBadRequest;
import com.group05.abstractbusiness.error.Exception.ResourceNotAcceptable;
import com.group05.abstractbusiness.error.Exception.ResourceNotFoundException;
import com.group05.abstractbusiness.helper.DTO.Business.ProductReturn;
import com.group05.abstractbusiness.helper.DTO.Business.ProdutoFisicoDTO;
import com.group05.abstractbusiness.helper.DTO.Business.Teste.ProductDigRes;
import com.group05.abstractbusiness.helper.DTO.Business.Teste.ProductIntRes;
import com.group05.abstractbusiness.helper.DTO.Business.Teste.ProductPhyRes;
import com.group05.abstractbusiness.helper.DTO.Business.Teste.ProductRes;
import com.group05.abstractbusiness.modules.model.Business.Produto;
import com.group05.abstractbusiness.modules.model.Business.ProdutoDigital;
import com.group05.abstractbusiness.modules.model.Business.ProdutoFisico;
import com.group05.abstractbusiness.modules.model.Business.ProdutoIntelectual;
import com.group05.abstractbusiness.modules.model.Business.factory.ProdutoFactory;
import com.group05.abstractbusiness.modules.repository.Business.ProdutoDigitalRepository;
import com.group05.abstractbusiness.modules.repository.Business.ProdutoFisicoRepository;
import com.group05.abstractbusiness.modules.repository.Business.ProdutoIntelectualRepository;
import com.group05.abstractbusiness.modules.service.Person.SupplierService;
import com.group05.abstractbusiness.utils.Enums.TipoProduto;

import jakarta.transaction.Transactional;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoFisicoRepository produtoFisicoRepository;

    @Autowired
    private ProdutoDigitalRepository produtoDigitalRepository;

    @Autowired
    private ProdutoIntelectualRepository produtoIntelectualRepository;

    @Autowired
    private SupplierService supplierService;

    private ModelMapper mapper = new ModelMapper();

    private Random random = new Random();

    @Transactional
    public ProductRes createProduct(TipoProduto tipoProduto, ProdutoFactory produtoFactory, String emailSupplier){
        
        verifyProduct(tipoProduto, produtoFactory.getName());



        switch (tipoProduto) {
            case FISICO:
            {
                
                produtoFactory.setSupplier(this.supplierService.findSupplierByEmail(emailSupplier));
                return mapper.map(produtoFisicoRepository.save(mapper.map(produtoFactory.criarFisco(), ProdutoFisico.class)), ProductPhyRes.class);
            }

            case DIGITAL:
            {

                return mapper.map(produtoDigitalRepository.save(mapper.map(produtoFactory.criarDigital(), ProdutoDigital.class)), ProductDigRes.class);
            }

            case INTELECTUAL:
            {
                
                return mapper.map(produtoIntelectualRepository.save(mapper.map(produtoFactory.criarIntelectual(), ProdutoIntelectual.class)), ProductIntRes.class);
            }
        
            default:
                throw new ResourceBadRequest("Cheque os dados");
        }

    }

    // public void setCodigo(ProdutoFactory produtoFactory){

    //     while(true){
    //             Long aux = random.nextLong(0, Long.MAX_VALUE);
    //             if(findCodigo(aux)){
    //                 task.setCodigo(aux);
    //                 break;
    //             }
    //         }

    // }


    // private Boolean findCodigo(Long codigo){
    //     List<Tasks> tareafas = taskRepository.findAll();

    //     if(tareafas == null) return true;

    //     Iterator<Tasks> iterator = tareafas.iterator();

    //     while(iterator.hasNext()){
    //         Tasks tasks = iterator.next();
    //         if(tasks.getCodigo().equals(codigo)) return false;
    //     }

    //     return true;
    // }

    private void verifyProduct(TipoProduto tipoProduto, String nome){

        switch (tipoProduto) {
            case FISICO:
                Optional<ProdutoFisico> p = produtoFisicoRepository.findByName(nome);
                if(!p.isEmpty()) throw new ResourceNotAcceptable("Produto já existe");
                break;
            case DIGITAL:
                Optional<ProdutoDigital> d = produtoDigitalRepository.findByName(nome);
                if(!d.isEmpty()) throw new ResourceNotAcceptable("Produto já existe");
                break;
            case INTELECTUAL:
                Optional<ProdutoIntelectual> i = produtoIntelectualRepository.findByName(nome);
                if(!i.isEmpty()) throw new ResourceNotAcceptable("Produto já existe");
                break;
            default:
                break;
        }

    }

    public List<ProductRes> findAll(TipoProduto tipoProduto){

        switch (tipoProduto) {
            case FISICO:
                return produtoFisicoRepository.findAll().stream().map(
                    produto -> mapper.map(produto, ProductPhyRes.class)
                ).collect(Collectors.toList());

            case DIGITAL:
                return produtoDigitalRepository.findAll().stream().map(
                    produto -> mapper.map(produto, ProductDigRes.class)
                ).collect(Collectors.toList());

            case INTELECTUAL:
                return produtoIntelectualRepository.findAll().stream().map(
                    produto -> mapper.map(produto, ProductIntRes.class)
                ).collect(Collectors.toList());
        
            default:
                throw new ResourceBadRequest("Cheque o tipo de produto");
        }

    }

    public ProductRes findById(TipoProduto tipoProduto, UUID id){

        switch (tipoProduto) {
            case FISICO:
            {
                Optional<ProdutoFisico> produto = produtoFisicoRepository.findById(id);
                if(produto.isPresent()) return mapper.map(produto, ProductPhyRes.class);
                else throw new ResourceNotFoundException("Produto não encontrado!");
            }

            case DIGITAL:
            {
                Optional<ProdutoDigital> produto = produtoDigitalRepository.findById(id);
                if(produto.isPresent()) return mapper.map(produto, ProductDigRes.class);
                else throw new ResourceNotFoundException("Produto não encontrado!");
            }

            case INTELECTUAL:
            {
                Optional<ProdutoIntelectual> produto = produtoIntelectualRepository.findById(id);
                if(produto.isPresent()) return mapper.map(produto, ProductIntRes.class);
                else throw new ResourceNotFoundException("Produto não encontrado!");
            }
        
            default:
                throw new ResourceBadRequest("Cheque o tipo de produto");
        }

    }

    public ProductRes findByName(TipoProduto tipoProduto, String name){

        switch (tipoProduto) {
            case FISICO:
            {
                Optional<ProdutoFisico> produto = produtoFisicoRepository.findByName(name);
                if(produto.isPresent()) return mapper.map(produto, ProductPhyRes.class);
                else throw new ResourceNotFoundException("Produto não encontrado!");
            }

            case DIGITAL:
            {
                Optional<ProdutoDigital> produto = produtoDigitalRepository.findByName(name);
                if(produto.isPresent()) return mapper.map(produto, ProductDigRes.class);
                else throw new ResourceNotFoundException("Produto não encontrado!");
            }

            case INTELECTUAL:
            {
                Optional<ProdutoIntelectual> produto = produtoIntelectualRepository.findByName(name);
                if(produto.isPresent()) return mapper.map(produto, ProductIntRes.class);
                else throw new ResourceNotFoundException("Produto não encontrado!");
            }
        
            default:
                throw new ResourceBadRequest("Cheque o tipo de produto");
        }

    }

    public List<ProductRes> findByBrand(TipoProduto tipoProduto, String brand){
        
        switch (tipoProduto) {
            case FISICO:
                return produtoFisicoRepository.findByBrand(brand).stream().map(
                    produto -> mapper.map(produto, ProductPhyRes.class)
                ).collect(Collectors.toList());

            case DIGITAL:
                return produtoDigitalRepository.findByBrand(brand).stream().map(
                    produto -> mapper.map(produto, ProductDigRes.class)
                ).collect(Collectors.toList());

            case INTELECTUAL:
                return produtoIntelectualRepository.findByBrand(brand).stream().map(
                    produto -> mapper.map(produto, ProductIntRes.class)
                ).collect(Collectors.toList());
        
            default:
                throw new ResourceBadRequest("Cheque o tipo de produto");
        }

    }

    public List<ProductRes> findByCategory(TipoProduto tipoProduto, String category){

        switch (tipoProduto) {
            case FISICO:
                return produtoFisicoRepository.findByCategory(category).stream().map(
                    produto -> mapper.map(produto, ProductPhyRes.class)
                ).collect(Collectors.toList());

            case DIGITAL:
                return produtoDigitalRepository.findByCategory(category).stream().map(
                    produto -> mapper.map(produto, ProductDigRes.class)
                ).collect(Collectors.toList());

            case INTELECTUAL:
                return produtoIntelectualRepository.findByCategory(category).stream().map(
                    produto -> mapper.map(produto, ProductIntRes.class)
                ).collect(Collectors.toList());
        
            default:
                throw new ResourceBadRequest("Cheque o tipo de produto");
        }
        
    }

    public List<ProductRes> findBySubcategory(TipoProduto tipoProduto, String subcategory){
        switch (tipoProduto) {
            case FISICO:
                return produtoFisicoRepository.findBySubCategory(subcategory).stream().map(
                    produto -> mapper.map(produto, ProductPhyRes.class)
                ).collect(Collectors.toList());

            case DIGITAL:
                return produtoDigitalRepository.findBySubCategory(subcategory).stream().map(
                    produto -> mapper.map(produto, ProductDigRes.class)
                ).collect(Collectors.toList());

            case INTELECTUAL:
                return produtoIntelectualRepository.findBySubCategory(subcategory).stream().map(
                    produto -> mapper.map(produto, ProductIntRes.class)
                ).collect(Collectors.toList());
        
            default:
                throw new ResourceBadRequest("Cheque o tipo de produto");
        }
    }

    @Transactional
    public ProdutoFisicoDTO updateProduto(TipoProduto tipoProduto, ProdutoFisico produto){

        switch (tipoProduto) {
            case FISICO:

            case DIGITAL:

            case INTELECTUAL:
        
            default:
                throw new ResourceBadRequest("Cheque o tipo de produto");
        }

    }

    public String deletar(UUID id){
        produtoFisicoRepository.deleteById(id);
        return "Produto Fisico: [ " + id + " ] deletado";
    }
}
