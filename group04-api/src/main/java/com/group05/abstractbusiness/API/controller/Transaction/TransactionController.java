package com.group05.abstractbusiness.API.controller.Transaction;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group05.abstractbusiness.helper.DTO.transaction.TransactionOutDTO;
import com.group05.abstractbusiness.helper.DTO.transaction.TransactionOutReturn;
import com.group05.abstractbusiness.modules.service.Transaction.TransactionOutService;


@RestController
@RequestMapping("/transaction") 
class TransactionController {
    @Autowired
    private TransactionOutService service;

    @PostMapping("/{idCart}")
    public ResponseEntity<TransactionOutReturn> createTransaction(@PathVariable UUID idCart, @RequestBody TransactionOutDTO transaction){
        return new ResponseEntity<>(service.create(idCart, transaction), HttpStatus.OK);
    }

}
