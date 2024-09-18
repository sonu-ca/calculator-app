package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.exceptionhandling.CalculatorException;
import com.example.demo.model.CalculationRequest;
import com.example.demo.model.ChainedCalculationRequest;
import com.example.demo.model.Operation;
import com.example.demo.model.OperationWithNumber;
import com.example.demo.validation.ValidateRequest;

import static org.junit.jupiter.api.Assertions.*;

class ValidateRequestTest {

	private ValidateRequest validateRequest;

	@BeforeEach
	void setUp() {
		validateRequest = new ValidateRequest();
	}

	// Test Case 1: Null CalculationRequest
	@Test
	void shouldThrowExceptionForNullCalculationRequest() {
		Exception exception = assertThrows(CalculatorException.class, () -> {
			validateRequest.validate((CalculationRequest) null);
		});
		assertEquals("Calculation request cannot be null", exception.getMessage());
	}

	// Test Case 2: Null Operation in CalculationRequest
	@Test
	void shouldThrowExceptionForNullOperationInCalculationRequest() {
		CalculationRequest request = new CalculationRequest(null, 5, 3);

		Exception exception = assertThrows(NullPointerException.class, () -> {
			validateRequest.validate(request);
		});
		assertEquals("Operation cannot be null", exception.getMessage());
	}

	// Test Case 3: Division by zero in CalculationRequest
	@Test
	void shouldThrowExceptionForDivisionByZeroInCalculationRequest() {
		CalculationRequest request = new CalculationRequest(Operation.DIVIDE, 5, 0);

		Exception exception = assertThrows(ArithmeticException.class, () -> {
			validateRequest.validate(request);
		});

		assertEquals("Cannot divide by zero", exception.getMessage());
	}

	// Test Case 4: Null ChainedCalculationRequest
	@Test
	void shouldThrowExceptionForNullChainedCalculationRequest() {
		Exception exception = assertThrows(CalculatorException.class, () -> {
			validateRequest.validate((ChainedCalculationRequest) null);
		});

		assertEquals("Chained calculation request cannot be null", exception.getMessage());
	}

	// Test Case 5: Empty operations list in ChainedCalculationRequest
	@Test
	void shouldThrowExceptionForEmptyOperationsListInChainedCalculationRequest() {
		ChainedCalculationRequest request = new ChainedCalculationRequest(5, new OperationWithNumber[0]);

		Exception exception = assertThrows(CalculatorException.class, () -> {
			validateRequest.validate(request);
		});

		assertEquals("Operations list cannot be null or empty", exception.getMessage());
	}

	// Test Case 6: Null operation in chained calculation
	@Test
	void shouldThrowExceptionForNullOperationInChainedCalculationRequest() {
		OperationWithNumber[] operations = new OperationWithNumber[] { new OperationWithNumber(Operation.ADD, 5),
				new OperationWithNumber(null, 3) };
		ChainedCalculationRequest request = new ChainedCalculationRequest(10, operations);

		Exception exception = assertThrows(NullPointerException.class, () -> {
			validateRequest.validate(request);
		});
		assertEquals("Operation at index 1 cannot be null", exception.getMessage());
	}

	// Test Case 7: Division by zero in chained calculation
	@Test
	void shouldThrowExceptionForDivisionByZeroInChainedCalculationRequest() {
		OperationWithNumber[] operations = new OperationWithNumber[] { new OperationWithNumber(Operation.ADD, 5),
				new OperationWithNumber(Operation.DIVIDE, 0) };
		ChainedCalculationRequest request = new ChainedCalculationRequest(10, operations);

		Exception exception = assertThrows(ArithmeticException.class, () -> {
			validateRequest.validate(request);
		});

		assertEquals("Cannot divide by zero at index 1", exception.getMessage());
	}

	// Test Case 8: Successful validation of chained calculation
	@Test
	void shouldPassForValidChainedCalculationRequest() {
		OperationWithNumber[] operations = new OperationWithNumber[] { new OperationWithNumber(Operation.ADD, 5),
				new OperationWithNumber(Operation.MULTIPLY, 2), new OperationWithNumber(Operation.DIVIDE, 5) };
		ChainedCalculationRequest request = new ChainedCalculationRequest(10, operations);

		assertDoesNotThrow(() -> validateRequest.validate(request));
	}
}
