package com.group05.abstractbusiness.controller.Business.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.group05.abstractbusiness.model.Business.services.Service;
import com.group05.abstractbusiness.service.Business.services.ServiceService;

@RestController
public class ServiceController {

	@Autowired
	private ServiceService serviceService;

	@GetMapping("/{service}")
	public ResponseEntity<Service> create(@PathVariable Service service) {
		Service newService = serviceService.create(service);
		return ResponseEntity.ok().body(newService);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Service> findById(@PathVariable UUID id) {
		Service service = serviceService.findById(id);
		return ResponseEntity.ok().body(service);
	}

	@GetMapping("/{service}")
	public ResponseEntity<Service> update(@PathVariable Service service) {
		Service newService = serviceService.update(service);
		return ResponseEntity.ok().body(newService);
	}

}
