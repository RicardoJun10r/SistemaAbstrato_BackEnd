package com.group05.abstractbusiness.model.Business.services;

import com.group05.abstractbusiness.model.Business.Produto;

public abstract class ServiceDecorator {

	private Service service;

	public ServiceDecorator(Produto produto) {

	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

}
