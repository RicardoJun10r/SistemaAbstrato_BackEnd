package com.group05.abstractbusiness.helper.mapper.Transaction;

import java.util.Optional;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.group05.abstractbusiness.helper.DTO.transaction.TransactionOutDTO;
import com.group05.abstractbusiness.helper.DTO.transaction.TransactionOutReturn;
import com.group05.abstractbusiness.modules.model.Transaction.TransactionOut;

@Mapper(componentModel = "spring")
public abstract class TransactionOutMapper{
    public static final TransactionOutMapper INSTACE = Mappers.getMapper(TransactionOutMapper.class);

    public abstract TransactionOut toTransactionOut(TransactionOutDTO transaction);
    public abstract TransactionOut toTransactionOut(TransactionOutReturn transaction);

    public abstract TransactionOutDTO toTransactionDTO(TransactionOut transactionIn);
    public abstract TransactionOutReturn toTransactionReturn(TransactionOut transactionIn);
    public abstract TransactionOutDTO toTransactionDTO(Optional<TransactionOut> transactionIn);
    public abstract TransactionOutReturn toTransactionReturn(Optional<TransactionOut> transactionIn);
}
