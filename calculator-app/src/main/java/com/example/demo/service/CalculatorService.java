package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.model.Operation;
import com.example.demo.model.OperationWithNumber;
import com.example.demo.operations.AddOperation;
import com.example.demo.operations.DivideOperation;
import com.example.demo.operations.MultiplyOperation;
import com.example.demo.operations.OperationInterface;
import com.example.demo.operations.SubtractOperation;

@Service
public class CalculatorService {

	private final Map<Operation, OperationInterface> operationMap = new HashMap<>();

	// Registering operations in the map for easy extensibility.
	// New operations can be added without modifying existing code.
	public CalculatorService() {
		operationMap.put(Operation.ADD, new AddOperation());
		operationMap.put(Operation.SUBTRACT, new SubtractOperation());
		operationMap.put(Operation.MULTIPLY, new MultiplyOperation());
		operationMap.put(Operation.DIVIDE, new DivideOperation());
	}

	public double calculate(Operation operation, double num1, double num2) {
		OperationInterface strategy = operationMap.get(operation);
		if (strategy == null) {
			throw new UnsupportedOperationException("Operation not supported");
		}
		return strategy.apply(num1, num2);
	}

	public double chainCalculate(double initialValue, OperationWithNumber[] operations) {
		double result = initialValue;
		for (OperationWithNumber operation : operations) {
			result = calculate(operation.getOperation(), result, operation.getNum2());
		}
		return result;
	}

}
