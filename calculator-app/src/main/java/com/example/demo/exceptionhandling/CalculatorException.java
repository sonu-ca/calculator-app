package com.example.demo.exceptionhandling;


public class CalculatorException extends RuntimeException {

	private static final long serialVersionUID = -93793273111513511L;

	public CalculatorException() {
        super();
    }

    public CalculatorException(String message) {
        super(message);
    }

    public CalculatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public CalculatorException(Throwable cause) {
        super(cause);
    }
}

