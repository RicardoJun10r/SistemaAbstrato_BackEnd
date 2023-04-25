package com.group05.abstractbusiness.modules.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.group05.abstractbusiness.helper.DTO.CartDTO;
import com.group05.abstractbusiness.helper.DTO.CartReturn;
import com.group05.abstractbusiness.helper.mapper.CartMapper;
import com.group05.abstractbusiness.modules.model.Business.ProdutoFisico;
import com.group05.abstractbusiness.modules.repository.CartRepository;
import com.group05.abstractbusiness.modules.repository.Business.ProdutoFisicoRepository;
import jakarta.transaction.Transactional;

@Service
public class CartService {
        
    @Autowired
    private CartRepository repository;
    @Autowired
    private ProdutoFisicoRepository productRepository;

    public CartReturn findbyId(UUID id){
        return CartMapper.INSTACE.toCartReturn(this.repository.findById(id).orElseThrow(
            ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cart com o id [ "+ id + " ] não encontrado")));
    }

    @Transactional                                           // Só persiste o dado caso passe todas as informações
    public CartReturn create(CartDTO cart) {
        return CartMapper.INSTACE.toCartReturn(this.repository.save(CartMapper.INSTACE.toCart(cart)));
    }

    public CartReturn addProduct(UUID idCart,UUID idProduct){
        CartReturn cart = findbyId(idCart);
        Optional<ProdutoFisico> produto = productRepository.findById(idProduct);
        cart.getProducts().put(produto.get(), (cart.getProducts().getOrDefault(produto, 0) + 1));
        return CartMapper.INSTACE.toCartReturn(this.repository.save(
            CartMapper.INSTACE.toCart(cart)));
    }

    public void delete(UUID id){
        if(this.repository.existsById(id)){
            repository.deleteById(id);
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cart com id [ " + id + " ] não encontrado");
        }
    }
}
