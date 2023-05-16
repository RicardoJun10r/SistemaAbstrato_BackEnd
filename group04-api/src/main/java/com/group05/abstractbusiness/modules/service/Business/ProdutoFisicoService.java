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

import jakarta.transaction.Transactional;

@Service
public class ProdutoFisicoService {
    
    @Autowired
    private ProdutoFisicoRepository produtoFisicoRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    ModelMapper mapper = new ModelMapper();

    public ProdutoFisico create(ProdutoFisico produto, UUID idSupplier){
        try {
            Optional<Supplier> supplier = supplierRepository.findById(idSupplier);
            Optional<ProdutoFisico> p = produtoFisicoRepository.findByNome(produto.getNome());
            if(supplier.isPresent()){
                produto.setSupplier(supplier.get());
                if(p.isEmpty()){
                    ModelMapper mapper = new ModelMapper();
                    return mapper.map(produtoFisicoRepository.save(produto), ProdutoFisico.class);
                } else {
                    throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"Produto já existe");
                }
            }else{
                throw new ResponseStatusException(HttpStatus.NOT_FOUND," Fornecedor não encontrado ");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ProdutoFisicoDTO findById(UUID id){
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
        try {
            if(!produtoFisicoRepository.findByNomeContainingIgnoreCase(name).isEmpty()){
            ProdutoFisicoDTO dto = mapper.map(produtoFisicoRepository.findByNome(name).get(), ProdutoFisicoDTO.class);
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
        try {
            if(!produtoFisicoRepository.findAll().isEmpty()){
                List<ProdutoFisico> produtos = produtoFisicoRepository.findAll();
                List<ProdutoFisicoDTO> dto = new ArrayList<>();
                for(ProdutoFisico aux : produtos){
                    dto.add(mapper.map(aux, ProdutoFisicoDTO.class));
                }
                return dto;
                } else{
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto fisico  não encontrado");
                }
            }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<ProdutoFisicoDTO> findByBrand(String brand){
        try {
            if(!produtoFisicoRepository.findByBrand(brand).isEmpty()){
                List<ProdutoFisico> produtos = produtoFisicoRepository.findByBrand(brand);
                List<ProdutoFisicoDTO> dto = new ArrayList<>();
                for(ProdutoFisico aux : produtos){
                    dto.add(mapper.map(aux, ProdutoFisicoDTO.class));
                }
                return dto;
                } else{
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto fisico não encontrado");
                }
            }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<ProdutoFisicoDTO> findByCategory(String category){
        try {
            if(!produtoFisicoRepository.findByCategory(category).isEmpty()){
                List<ProdutoFisico> produtos = produtoFisicoRepository.findByCategory(category);
                List<ProdutoFisicoDTO> dto = new ArrayList<>();
                for(ProdutoFisico aux : produtos){
                    dto.add(mapper.map(aux, ProdutoFisicoDTO.class));
                }
                return dto;
                } else{
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto fisico  não encontrado");
                }
            }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<ProdutoFisicoDTO> findBySubcategory(String subcategory){
        try {
            if(!produtoFisicoRepository.findBySubCategory(subcategory).isEmpty()){
                List<ProdutoFisico> produtos = produtoFisicoRepository.findBySubCategory(subcategory);
                List<ProdutoFisicoDTO> dto = new ArrayList<>();
                for(ProdutoFisico aux : produtos){
                    dto.add(mapper.map(aux, ProdutoFisicoDTO.class));
                }
                return dto;
                } else{
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto fisico não encontrado");
                }
            }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Transactional
    public ProdutoFisicoDTO updateProduto(ProdutoFisico produto){
        //TO-DO utilizar metodo findbyId da propria classe.
        ProdutoFisico produtoFind = this.produtoFisicoRepository.findById(produto.getID())
        .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto com o id [ "+ produto.getID() + " ] não encontrado"));
        
        // Validando produto
        if(produtoFind.getNome().equals(produto.getNome()) && produtoFind.getBrand().equals(produto.getBrand())){
            produtoFind.setBrand(produto.getBrand());
            produtoFind.setCategory(produto.getCategory());
            produtoFind.setDescricao(produto.getDescricao());
            produtoFind.setStatus(produto.getStatus());
            produtoFind.setPreco(produto.getPreco());
            produtoFind.setSubCategory(produto.getSubCategory());
            produtoFind.setWeight(produto.getWeight());
            produtoFind.setHeight(produto.getHeight());
            produtoFind.setWidth(produto.getWidth());
            produtoFind.setQuantidade(produto.getQuantidade());
            produtoFind.setStock(produto.getStock());
            return mapper.map(this.produtoFisicoRepository.save(produtoFind), ProdutoFisicoDTO.class);
        }else{
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, "Produto não compativel");
        }
    } 
    public String deletar(UUID id){
        produtoFisicoRepository.deleteById(id);
        return "Produto Fisico: [ " + id + " ] deletado";
    }
}
