package com.group05.abstractbusiness.modules.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.group05.abstractbusiness.modules.model.Business.ProdutoFisico;
import com.group05.abstractbusiness.modules.model.Person.User;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@Entity
@Table(name = "cart")
@NoArgsConstructor 
public class Cart {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private UUID id;

    @ElementCollection
    @CollectionTable(name = "cart_products", joinColumns = @JoinColumn(name = "cart_id"))
    @MapKeyJoinColumn(name = "product_id")
	@Column(name = "quantity")
	private Map<ProdutoFisico, Integer> products;                           //Map para guardar produto e quantidade de produto no carrinho
    //TO-DO Adicionar vendendor

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
    @NotEmpty
	private User user;

	public Cart(UUID id) {
		this.id = id;
    }

    //Metodo que adiciona produto, se já existir no carrinho aumenta a quantidade
    public void addProduct(ProdutoFisico product, int quantity) {
        if (products.containsKey(product)) {
            int currentQuantity = products.get(product);
            products.put(product, currentQuantity + quantity);
        } else {
            products.put(product, quantity);
        }
    }
    //Metodo que remove produto, se já existir no carrinho diminui a quantidade
    public void removeProduct(ProdutoFisico product, int quantity) {
        if (products.containsKey(product)) {
            int currentQuantity = products.get(product);
            if (quantity >= currentQuantity) {
                products.remove(product);
            } else {
                products.put(product, currentQuantity - quantity);
            }
        }
    }

/*    //Metodo que retorna produtos no carrinho
    public List<ProdutoFisico> getProducts() {
        return new ArrayList<>(products.keySet());
    }*/

    //Metodo que retorna quantidade especifica de produtos no carrinho
    public int getQuantity(ProdutoFisico product) {
        return products.getOrDefault(product, 0);
    }

}