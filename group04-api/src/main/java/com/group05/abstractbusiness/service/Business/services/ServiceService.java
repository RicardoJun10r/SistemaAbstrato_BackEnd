package com.group05.abstractbusiness.service.Business.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.group05.abstractbusiness.model.Business.services.Service;
import com.group05.abstractbusiness.repository.Business.services.ServiceRepository;

@org.springframework.stereotype.Service
public class ServiceService {

	@Autowired
	private ServiceRepository serviceRepository;

	@Transactional
	public Service create(Service service) {
		return serviceRepository.save(service);
	}

	public Service findById(UUID id) {
		// return serviceRepository.findById(id);
		Optional<Service> service = serviceRepository.findById(id);
		return service.orElseThrow(
				() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Servico nao encontrado pelo id " + id));

	}

	@Transactional
	public Service update(Service service) {
		return serviceRepository.save(service);
	}

	public void delete(UUID id) {
		serviceRepository.deleteById(id);
	}

}
