package com.group05.abstractbusiness.repository.Transaction;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group05.abstractbusiness.model.Transaction.TransactionLoss;

public interface TransactionLossRepository extends JpaRepository<TransactionLoss, UUID> {

}
