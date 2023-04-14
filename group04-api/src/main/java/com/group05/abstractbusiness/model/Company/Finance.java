/*
package com.group05.abstractbusiness.model.Company;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.group05.abstractbusiness.model.Transaction.Transaction;

public class Finance {
    
    private List<Transaction> transactions; // atributo para armazenar uma lista de transações

    public Finance() {
        this.transactions = new ArrayList<Transaction>(); // inicializa a lista de transações
    }

    public List<Transaction> getTransactions() { // método para retornar a lista de transações
        return this.transactions;
    }

    public void addTransaction(Transaction transaction) { // método para adicionar uma transação à lista
        this.transactions.add(transaction);
    }

    public void removeTransaction(Transaction transaction) { // método para remover uma transação da lista
        this.transactions.remove(transaction);
    }

    public void clearTransactions() { // método para limpar a lista de transações
        this.transactions.clear();
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Finance)) {
            return false;
        }
        Finance finance = (Finance) o;
        return Objects.equals(transactions, finance.transactions);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(transactions);
    }

}
*/