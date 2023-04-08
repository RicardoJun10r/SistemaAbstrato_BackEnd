package com.group05.abstractbusiness.model.Business.services;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Service {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true)
	private UUID id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "status")
	private String status;

	@Column(name = "costBudget")
	private double costBudget;

	@Column(name = "hourPrice")
	private double hourPrice;

	@Column(name = "durationService")
	private int durationService;

	@Column(name = "finalPrice")
	private double finalPrice;

	public Service() {
	}

	public Service(UUID id, String name, String description, String status, double costBudget, double hourPrice,
			int durationService, double finalPrice) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.status = status;
		this.costBudget = costBudget;
		this.hourPrice = hourPrice;
		this.durationService = durationService;
		this.finalPrice = finalPrice;
	}

}
