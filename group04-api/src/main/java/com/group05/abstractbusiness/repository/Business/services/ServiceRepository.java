package com.group05.abstractbusiness.repository.Business.services;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group05.abstractbusiness.model.Business.services.Service;

public interface ServiceRepository extends JpaRepository<Service, UUID> {

}
