package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.model.Operation;
import com.example.demo.model.OperationWithNumber;
import com.example.demo.service.CalculatorService;

public class CalculatorServiceTest {

	private CalculatorService calculatorService;

	@BeforeEach
	void setUp() {
		calculatorService = new CalculatorService();
	}

	// Happy Path Test Case 1: Test ADD operation
	@Test
	void testAddOperation() {
		double result = calculatorService.calculate(Operation.ADD, 5, 3);
		assertEquals(8, result, "The result of adding 5 and 3 should be 8");
	}

	// Happy Path Test Case 2: Test SUBTRACT operation
	@Test
	void testSubtractOperation() {
		double result = calculatorService.calculate(Operation.SUBTRACT, 10, 4);
		assertEquals(6, result, "The result of subtracting 4 from 10 should be 6");
	}

	// Happy Path Test Case 3: Test MULTIPLY operation
	@Test
	void testMultiplyOperation() {
		double result = calculatorService.calculate(Operation.MULTIPLY, 6, 2);
		assertEquals(12, result, "The result of multiplying 6 and 2 should be 12");
	}

	// Happy Path Test Case 4: Test DIVIDE operation
	@Test
	void testDivideOperation() {
		double result = calculatorService.calculate(Operation.DIVIDE, 10, 2);
		assertEquals(5, result, "The result of dividing 10 by 2 should be 5");
	}

	// Happy Path Test Case 5: Test chain of operations
	@Test
	void testChainCalculate() {
		// Chain: 5 + 3 -> 8 * 2 -> 16 / 4 = 4
		OperationWithNumber[] operations = new OperationWithNumber[] { new OperationWithNumber(Operation.ADD, 3),
				new OperationWithNumber(Operation.MULTIPLY, 2), new OperationWithNumber(Operation.DIVIDE, 4) };
		double result = calculatorService.chainCalculate(5, operations);
		assertEquals(4, result, "The result of the chained operations should be 4");
	}

	// Happy Path Test Case 6: Test chain with a single operation
	@Test
	void testChainCalculateSingleOperation() {
		// Chain: 5 + 5 = 10
		OperationWithNumber[] operations = new OperationWithNumber[] { new OperationWithNumber(Operation.ADD, 5) };
		double result = calculatorService.chainCalculate(5, operations);
		assertEquals(10, result, "The result of the single operation chain should be 10");
	}

	// Happy Path Test Case 7: Test chain with no operations (should return initial
	// value)
	@Test
	void testChainCalculateNoOperations() {
		// No operations, should return initial value
		double result = calculatorService.chainCalculate(10, new OperationWithNumber[0]);
		assertEquals(10, result, "The result should be the initial value when no operations are provided");
	}
}
