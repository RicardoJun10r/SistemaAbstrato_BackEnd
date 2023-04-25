package com.group05.abstractbusiness.modules.repository.Transaction.TransactionFisico;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group05.abstractbusiness.modules.model.Transaction.TransactionOut;

public interface TransactionOutFRepository extends JpaRepository<TransactionOut, UUID> {

}
