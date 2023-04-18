package com.group05.abstractbusiness.repository.Transaction;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group05.abstractbusiness.model.Transaction.TransactionOut;

public interface TransactionOutRepository extends JpaRepository<TransactionOut, UUID> {

}
