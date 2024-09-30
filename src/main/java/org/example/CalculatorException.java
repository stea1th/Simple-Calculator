package org.example;

public class CalculatorException extends RuntimeException {

    private final boolean isFatal;

    public CalculatorException(String message, boolean isFatal) {
        super(message);
        this.isFatal = isFatal;
    }

    public boolean isFatal() {
        return isFatal;
    }
}
