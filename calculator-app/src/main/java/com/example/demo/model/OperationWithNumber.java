package com.example.demo.model;

public class OperationWithNumber {
    private Operation operation;
    private double num2;

    public OperationWithNumber(Operation operation, double number) {
		this.operation = operation;
		this.num2 = number;
	}

    public Operation getOperation() {
        return operation;
    }

	public double getNum2() {
		return num2;
	}
}
