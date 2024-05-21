package org.capgemini.blue_harvest.transactionservice.controller;

import org.capgemini.blue_harvest.transactionservice.constant.APIConstants;
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
import java.util.logging.Logger;

@RestController	
@RequestMapping(APIConstants.TRANSACTIONSERVICE_API_BASE_PATH)
public class TransactionController {
    
    private static final Logger logger = Logger.getLogger(TransactionController.class.getName());

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<ResponseTemplate> createTransaction(@RequestBody TransactionRequest transactionRequest) {
        logger.info(TransactionConstants.TRANSACTION_CREATE_REQUEST_MESSAGE );
        ResponseEntity<ResponseTemplate> responseEntity = new ResponseEntity<>(new ResponseTemplate(TransactionConstants.TRANSACTION_CREATE_SUCCESS_MESSAGE, HttpStatus.CREATED.toString(), transactionService.createTransaction(transactionRequest)), HttpStatus.CREATED);
        logger.info(TransactionConstants.TRANSACTION_CREATE_SUCCESS_MESSAGE);
        return responseEntity;
    }

    @GetMapping("/{" + APIConstants.PATH_VARIABLE_ACCOUNT_ID + "}")
    public ResponseEntity<ResponseTemplate> getTransactionById(@PathVariable(APIConstants.PATH_VARIABLE_ACCOUNT_ID) int accountId) {
        logger.info(TransactionConstants.TRANSACTION_FETCH_REQUEST_MESSAGE  + accountId);
        ResponseEntity<ResponseTemplate> responseEntity = new ResponseEntity<>(new ResponseTemplate(TransactionConstants.TRANSACTION_FETCHED_SUCCESS_MESSAGE, HttpStatus.OK.toString(), transactionService.getTransactionByAccountId(accountId)), HttpStatus.OK);
        logger.info(TransactionConstants.TRANSACTION_FETCHED_SUCCESS_MESSAGE);
        return responseEntity;
    }
}
