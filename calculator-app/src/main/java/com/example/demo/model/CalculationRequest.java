package com.example.demo.model;

public class CalculationRequest {
	private Operation operation;
	private double num1;
	private double num2;

	public CalculationRequest(Operation operation, double num1, double num2) {
		this.operation = operation;
		this.num1 = num1;
		this.num2 = num2;
	}

	public Operation getOperation() {
		return operation;
	}

	public double getNum1() {
		return num1;
	}

	public double getNum2() {
		return num2;
	}

}
