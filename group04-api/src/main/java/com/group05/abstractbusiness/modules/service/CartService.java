// package com.group05.abstractbusiness.modules.service;

// import java.util.Optional;
// import java.util.UUID;

// import org.modelmapper.ModelMapper;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.HttpStatusCode;
// import org.springframework.stereotype.Service;
// import org.springframework.web.server.ResponseStatusException;

// import com.group05.abstractbusiness.helper.DTO.CartDTO;
// import com.group05.abstractbusiness.helper.DTO.CartReturn;
// import com.group05.abstractbusiness.modules.model.Cart;
// import com.group05.abstractbusiness.modules.model.Business.ProdutoFisico;
// import com.group05.abstractbusiness.modules.model.Person.Users.User;
// import com.group05.abstractbusiness.modules.repository.CartRepository;
// import com.group05.abstractbusiness.modules.repository.Business.ProdutoFisicoRepository;
// import com.group05.abstractbusiness.modules.repository.Person.UserRepository;

// import jakarta.transaction.Transactional;

// @Service
// public class CartService {
        
//     @Autowired
//     private CartRepository repository;
//     @Autowired
//     private ProdutoFisicoRepository productRepository;
//     @Autowired
//     private UserRepository userRepository;

//     private ModelMapper mapper = new ModelMapper();

//     public CartReturn findbyId(UUID id){
//         return mapper.map(this.repository.findById(id).orElseThrow(
//             ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cart com o id [ "+ id + " ] não encontrado")), CartReturn.class);
//     }

//     @Transactional                                           // Só persiste o dado caso passe todas as informações
//     public CartReturn create(UUID idUser) {
//         Optional<User> user = userRepository.findById(idUser);
//         if(user.isPresent()){
//             Cart cart = new Cart();
//             user.get().setId(idUser);
//             cart.setUser(user.get());
//             cart.setProducts(null);
//             return mapper.map(this.repository.save(cart), CartReturn.class);
//         }else{
//             throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user de id [ " + idUser + " ] não encontrado " );
//         }
//     }

//     public CartReturn addProduct(UUID idCart,UUID idProduct){
//         CartReturn cart = findbyId(idCart);
//         Optional<ProdutoFisico> produto = productRepository.findById(idProduct);
//         if(produto.isPresent()){
        
//         if(cart.getProducts().containsKey(idProduct))
//             cart.getProducts().put(produto.get().getID(), (cart.getProducts().get(idProduct) + 1));
//         else
//             cart.getProducts().put(produto.get().getID(),1);
        
//         return mapper.map(this.repository.save(mapper.map(
//             cart, Cart.class)), CartReturn.class);
//         }else{
//             throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Produto de id [ " + idProduct + " ] não encontrado");
//         }
//     }

//     public void delete(UUID id){
//         if(this.repository.existsById(id)){
//             repository.deleteById(id);
//         }
//         else{
//             throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cart com id [ " + id + " ] não encontrado");
//         }
//     }
// }
