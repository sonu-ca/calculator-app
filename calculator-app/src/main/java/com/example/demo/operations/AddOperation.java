package com.example.demo.operations;

public class AddOperation implements OperationInterface {

	@Override
	public double apply(double num1, double num2) {
		return num1 + num2;
	}

}
