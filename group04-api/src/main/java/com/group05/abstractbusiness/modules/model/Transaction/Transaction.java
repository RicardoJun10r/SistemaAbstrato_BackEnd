package com.group05.abstractbusiness.modules.model.Transaction;

import java.sql.Timestamp;

import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;


import com.group05.abstractbusiness.modules.model.Cart;
import com.group05.abstractbusiness.utils.Enums.TipoTransacao;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", length = 1, discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("T")
@Data
@EqualsAndHashCode
@Entity
public abstract class Transaction{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true)
	private UUID id;

	@Column(name = "transaction_date", nullable = false)
	@Temporal(value = TemporalType.TIMESTAMP)               // Tipo do valor de data, poderia ser DATE invés de TIMESTAMP
    @DateTimeFormat(pattern = "dd/MM/yyyy")                 // Padrão da data
	private Timestamp transactionDate;

	@ManyToOne(targetEntity = Cart.class)
	@JoinColumn(name = "cart_id", nullable = false)
	private Cart cart;

	@Column(name = "value", nullable = false)
	private Double value;

	@Column(name = "discount")
	private int discount;

	@Column(name = "tipo_transacao")
	private TipoTransacao transactionType;

	protected Transaction(){}

	protected Transaction(Double value, int discount, Cart cart){
		this.value = value;
		this.discount = discount;
		this.cart = cart;
	}
	// Anotação para que o metodo seja executado antes da prescrição no BD, para salvar a registerDate sempre com o horario atual
	@PrePersist
    public void onCreate() {
        this.transactionDate = new Timestamp(System.currentTimeMillis());
    }
}
