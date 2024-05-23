package org.capgemini.blue_harvest.transactionservice.controller;

import org.capgemini.blue_harvest.transactionservice.constant.APIConstants;
import org.capgemini.blue_harvest.transactionservice.constant.TransactionConstants;
import org.capgemini.blue_harvest.transactionservice.model.ResponseTemplate;
import org.capgemini.blue_harvest.transactionservice.model.TransactionRequest;
import org.capgemini.blue_harvest.transactionservice.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(APIConstants.API_VERSION_1 + APIConstants.API_TRANSACTION_SERVICE)
public class TransactionController {

	private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);

	@Autowired
	private TransactionService transactionService;

	@PostMapping
	public ResponseEntity<ResponseTemplate> createTransaction(@RequestBody TransactionRequest transactionRequest) {
		logger.info(TransactionConstants.TRANSACTION_FETCH_REQUEST_MESSAGE, transactionRequest.getAccountId());
		ResponseEntity<ResponseTemplate> responseEntity = new ResponseEntity<>(
				new ResponseTemplate(TransactionConstants.TRANSACTION_CREATE_SUCCESS_MESSAGE,
						HttpStatus.CREATED.value(), transactionService.createTransaction(transactionRequest)),
				HttpStatus.CREATED);
		logger.info(TransactionConstants.TRANSACTION_CREATE_SUCCESS_MESSAGE, transactionRequest.getAccountId());
		return responseEntity;
	}

	@GetMapping(APIConstants.API_GET_ACCOUNT_TRANSACTIONS)
	public ResponseEntity<ResponseTemplate> getTransactionById(
			@RequestParam(APIConstants.REQUEST_PARAM_ACCOUNT_ID) int accountId) {
		logger.info(TransactionConstants.TRANSACTION_FETCH_REQUEST_MESSAGE , accountId);
		ResponseEntity<ResponseTemplate> responseEntity = new ResponseEntity<>(
				new ResponseTemplate(TransactionConstants.TRANSACTION_FETCHED_SUCCESS_MESSAGE, HttpStatus.OK.value(),
						transactionService.getTransactionByAccountId(accountId)),
				HttpStatus.OK);
		logger.info(TransactionConstants.TRANSACTION_FETCHED_SUCCESS_MESSAGE, accountId);
		return responseEntity;
	}
}
