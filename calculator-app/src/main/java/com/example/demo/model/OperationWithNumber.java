package com.example.demo.model;

public class OperationWithNumber {
    private Operation operation;
    private double num2;

    public OperationWithNumber(Operation operation, double number) {
		this.operation = operation;
		this.num2 = number;
	}

	// Getters and setters
    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

	public double getNum2() {
		return num2;
	}

	public void setNum2(double num2) {
		this.num2 = num2;
	}

}
