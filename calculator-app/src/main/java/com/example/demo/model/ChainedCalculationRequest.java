package com.example.demo.model;


public class ChainedCalculationRequest {
    private double initialValue;
    private OperationWithNumber[] operations;

    public ChainedCalculationRequest(double number, OperationWithNumber[] operations2) {
		this.initialValue = number;
		this.operations = operations2;
	}

	// Getters and setters
    public double getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(double initialValue) {
        this.initialValue = initialValue;
    }

    public OperationWithNumber[] getOperations() {
        return operations;
    }

    public void setOperations(OperationWithNumber[] operations) {
        this.operations = operations;
    }
}
