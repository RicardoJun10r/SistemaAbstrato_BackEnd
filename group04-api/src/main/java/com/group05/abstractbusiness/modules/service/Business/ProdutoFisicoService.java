package com.group05.abstractbusiness.modules.service.Business;

import java.util.Optional;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.group05.abstractbusiness.helper.DTO.Business.ProdutoFisicoDTO;
import com.group05.abstractbusiness.modules.model.Business.ProdutoFisico;
import com.group05.abstractbusiness.modules.model.Person.Supplier;
import com.group05.abstractbusiness.modules.repository.Business.ProdutoFisicoRepository;
import com.group05.abstractbusiness.modules.repository.Person.SupplierRepository;

@Service
public class ProdutoFisicoService {
    
    @Autowired
    private ProdutoFisicoRepository produtoFisicoRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    public ProdutoFisico create(ProdutoFisico produto, UUID idSupplier){
        Optional<Supplier> supplier = supplierRepository.findById(idSupplier);
        if(supplier.isPresent()){
            produto.setSupplier(supplier.get());
            ModelMapper mapper = new ModelMapper();
            return mapper.map(produtoFisicoRepository.save(produto), ProdutoFisico.class);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND," Fornecedor não encontrado ");
        }
    }

    public ProdutoFisicoDTO findById(UUID id){
        ModelMapper mapper = new ModelMapper();
        try {
            if(produtoFisicoRepository.findById(id).isPresent()){
            ProdutoFisicoDTO dto = mapper.map(produtoFisicoRepository.findById(id).get(), ProdutoFisicoDTO.class);
            return dto;
            } else{
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto fisico com id [" + id + " ] não encontrado");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ProdutoFisicoDTO findByName(String name){
        ModelMapper mapper = new ModelMapper();
        try {
            if(!produtoFisicoRepository.findByNomeContainingIgnoreCase(name).isEmpty()){
            ProdutoFisicoDTO dto = mapper.map(produtoFisicoRepository.findByNomeContainingIgnoreCase(name), ProdutoFisicoDTO.class);
            return dto;
            } else{
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto fisico com o nome [" + name + " ] não encontrado");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<ProdutoFisicoDTO> findAll(){
        ModelMapper mapper = new ModelMapper();
        try {
            if(!produtoFisicoRepository.findAll().isEmpty()){
                List<ProdutoFisico> produtos = produtoFisicoRepository.findAll();
                List<ProdutoFisicoDTO> dto = new ArrayList<>();
                for(ProdutoFisico aux : produtos){
                    dto.add(mapper.map(aux, ProdutoFisicoDTO.class));
                }
                return dto;
                } else{
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto fisico com id [" + id + " ] não encontrado");
                }
            }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<ProdutoFisicoDTO> findByBrand(String brand){
        ModelMapper mapper = new ModelMapper();
        try {
            if(!produtoFisicoRepository.findByBrand(brand).isEmpty()){
                List<ProdutoFisico> produtos = produtoFisicoRepository.findByBrand(brand);
                List<ProdutoFisicoDTO> dto = new ArrayList<>();
                for(ProdutoFisico aux : produtos){
                    dto.add(mapper.map(aux, ProdutoFisicoDTO.class));
                }
                return dto;
                } else{
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto fisico com id [" + id + " ] não encontrado");
                }
            }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<ProdutoFisicoDTO> findByCategory(String category){
        ModelMapper mapper = new ModelMapper();
        try {
            if(!produtoFisicoRepository.findByCategory(category).isEmpty()){
                List<ProdutoFisico> produtos = produtoFisicoRepository.findByCategory(category);
                List<ProdutoFisicoDTO> dto = new ArrayList<>();
                for(ProdutoFisico aux : produtos){
                    dto.add(mapper.map(aux, ProdutoFisicoDTO.class));
                }
                return dto;
                } else{
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto fisico com id [" + id + " ] não encontrado");
                }
            }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<ProdutoFisicoDTO> findBySubcategory(String subcategory){
        ModelMapper mapper = new ModelMapper();
        try {
            if(!produtoFisicoRepository.findBySubCategory(subcategory).isEmpty()){
                List<ProdutoFisico> produtos = produtoFisicoRepository.findBySubCategory(subcategory);
                List<ProdutoFisicoDTO> dto = new ArrayList<>();
                for(ProdutoFisico aux : produtos){
                    dto.add(mapper.map(aux, ProdutoFisicoDTO.class));
                }
                return dto;
                } else{
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto fisico com id [" + id + " ] não encontrado");
                }
            }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String deletar(UUID id){
        produtoFisicoRepository.deleteById(id);
        return "Produto Fisico: [ " + id + " ] deletado";
    }
}
