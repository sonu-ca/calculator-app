package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CalculationRequest;
import com.example.demo.model.ChainedCalculationRequest;
import com.example.demo.service.CalculatorService;
import com.example.demo.validation.ValidateRequest;

@RestController
@RequestMapping("/rest/v1")
public class CalculatorController {

	@Autowired
    private CalculatorService calculatorService;
	
	@Autowired
	private ValidateRequest validateRequest;

    @PostMapping("/calculate")
    public ResponseEntity<Double> calculate(@RequestBody CalculationRequest calculationRequest) {
    	validateRequest.validate(calculationRequest);
        double result = calculatorService.calculate(calculationRequest.getOperation(), calculationRequest.getNum1(), calculationRequest.getNum2());
        return new ResponseEntity<Double>(result, new HttpHeaders(), HttpStatus.OK);
    }
    
    @PostMapping("/calculate/chain")
    public ResponseEntity<Double> calculateChain(@RequestBody ChainedCalculationRequest chainedCalculationRequest) {
    	validateRequest.validate(chainedCalculationRequest);
        double result = calculatorService.chainCalculate(chainedCalculationRequest.getInitialValue(), chainedCalculationRequest.getOperations());
        return new ResponseEntity<Double>(result, new HttpHeaders(), HttpStatus.OK);
    }
}
 