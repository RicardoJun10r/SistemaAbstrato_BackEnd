package com.group05.abstractbusiness.helper.mapper.Transaction;

import java.util.Optional;

import org.mapstruct.factory.Mappers;

import com.group05.abstractbusiness.helper.DTO.transaction.TransactionLossDTO;
import com.group05.abstractbusiness.helper.DTO.transaction.TransactionLossReturn;
import com.group05.abstractbusiness.modules.model.Transaction.TransactionLoss;

public abstract class TransactionLossMapper {
    public static final TransactionLossMapper INSTACE = Mappers.getMapper(TransactionLossMapper.class);

    public abstract TransactionLoss toTransactionIn(TransactionLossDTO transaction);
    public abstract TransactionLoss toTransactionIn(TransactionLossReturn transaction);

    public abstract TransactionLossDTO toTransactionDTO(TransactionLoss transactionIn);
    public abstract TransactionLossReturn toTransactionReturn(TransactionLoss transactionIn);
    public abstract TransactionLossDTO toTransactionDTO(Optional<TransactionLoss> transactionIn);
    public abstract TransactionLossReturn toTransactionReturn(Optional<TransactionLoss> transactionIn);
}
