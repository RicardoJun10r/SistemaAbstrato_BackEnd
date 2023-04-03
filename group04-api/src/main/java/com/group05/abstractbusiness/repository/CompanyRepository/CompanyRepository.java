package com.group05.abstractbusiness.repository.CompanyRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group05.abstractbusiness.model.Company.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

}
