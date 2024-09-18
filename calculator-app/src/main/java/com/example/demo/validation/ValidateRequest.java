package com.example.demo.validation;

import org.springframework.stereotype.Component;

import com.example.demo.exceptionhandling.CalculatorException;
import com.example.demo.model.CalculationRequest;
import com.example.demo.model.ChainedCalculationRequest;
import com.example.demo.model.Operation;
import com.example.demo.model.OperationWithNumber;

@Component
public class ValidateRequest {

	// for validating single calculation request
	public void validate(CalculationRequest request) {
		if (request == null) {
			throw new CalculatorException("Calculation request cannot be null");
		}
		validateOperation(request.getOperation(), request.getNum2());
	}

	// for validating chained calculation request
	public void validate(ChainedCalculationRequest request) {
		if (request == null) {
			throw new CalculatorException("Chained calculation request cannot be null");
		}
		if (request.getOperations() == null || request.getOperations().length == 0) {
			throw new CalculatorException("Operations list cannot be null or empty");
		}

		  // Validate each operation in the chain
        for (int i = 0; i < request.getOperations().length; i++) {
            OperationWithNumber operationWithNumber = request.getOperations()[i];
            validateOperation(operationWithNumber.getOperation(), operationWithNumber.getNum2(), i);
        }
	}

	// Private reusable method for validating a single operation
	private void validateOperation(Operation operation, double num2) {
		if (operation == null) {
			throw new NullPointerException("Operation cannot be null");
		}
		if (Operation.DIVIDE.equals(operation) && num2 == 0) {
			throw new ArithmeticException("Cannot divide by zero");
		}
	}
	
    // Overloaded method for chained operations to provide index-specific error messages
    private void validateOperation(Operation operation, double num2, int index) {
        if (operation == null) {
            throw new NullPointerException("Operation at index " + index + " cannot be null");
        }
        if (operation.equals(Operation.DIVIDE) && num2 == 0) {
            throw new ArithmeticException("Cannot divide by zero at index " + index);
        }
    }

}
