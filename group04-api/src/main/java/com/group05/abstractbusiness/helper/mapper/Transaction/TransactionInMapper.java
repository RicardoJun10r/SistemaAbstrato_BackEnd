package com.group05.abstractbusiness.helper.mapper.Transaction;

import java.util.Optional;

import org.mapstruct.factory.Mappers;

import com.group05.abstractbusiness.helper.DTO.person.transaction.TransactionInDTO;
import com.group05.abstractbusiness.helper.DTO.person.transaction.TransactionInReturn;
import com.group05.abstractbusiness.modules.model.Transaction.TransactionIn;

public abstract class TransactionInMapper {
    public static final TransactionInMapper INSTACE = Mappers.getMapper(TransactionInMapper.class);

    public abstract TransactionIn toTransactionIn(TransactionInDTO transaction);
    public abstract TransactionIn toTransactionIn(TransactionInReturn transaction);

    public abstract TransactionInDTO toTransactionDTO(TransactionIn transactionIn);
    public abstract TransactionInReturn toTransactionReturn(TransactionIn transactionIn);
    public abstract TransactionInDTO toTransactionDTO(Optional<TransactionIn> transactionIn);
    public abstract TransactionInReturn toTransactionReturn(Optional<TransactionIn> transactionIn);

}
