package org.capgemini.blue_harvest.transactionservice.controller;

import org.capgemini.blue_harvest.transactionservice.constant.TransactionConstants;
import org.capgemini.blue_harvest.transactionservice.model.ResponseTemplate;
import org.capgemini.blue_harvest.transactionservice.model.TransactionRequest;
import org.capgemini.blue_harvest.transactionservice.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<ResponseTemplate> createTransaction(@RequestBody TransactionRequest transactionRequest) {
    	return new ResponseEntity<>(new ResponseTemplate(TransactionConstants.TRANSACTION_CREATE_SUCCESS_MESSAGE,HttpStatus.CREATED.toString(),transactionService.createTransaction(transactionRequest)),HttpStatus.CREATED);
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<ResponseTemplate> getTransactionById(@PathVariable("accountId") int accountId) {
    	return new ResponseEntity<>(new ResponseTemplate(TransactionConstants.TRANSACTION_FETCHED_SUCCESS_MESSAGE,HttpStatus.OK.toString(),transactionService.getTransactionByAccountId(accountId)),HttpStatus.OK);
    }
}