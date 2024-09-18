package com.example.demo.model;


public class ChainedCalculationRequest {
    private double initialValue;
    private OperationWithNumber[] operations;

    public ChainedCalculationRequest(double number, OperationWithNumber[] operations2) {
		this.initialValue = number;
		this.operations = operations2;
	}

    public double getInitialValue() {
        return initialValue;
    }

    public OperationWithNumber[] getOperations() {
        return operations;
    }

}
