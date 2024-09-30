package org.example;

public class CalculatorModel {

    private double firstNumber;

    private double secondNumber;

    private Double result;

    private boolean cancelCalculation = false;

    private int choice = 0;

    public CalculatorModel() {
    }

    public CalculatorModel(double firstNumber, double secondNumber, int choice) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.choice = choice;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public void setCancelCalculation(boolean cancelCalculation) {
        this.cancelCalculation = cancelCalculation;
    }

    public double getFirstNumber() {
        return firstNumber;
    }

    public double getSecondNumber() {
        return secondNumber;
    }

    public Double getResult() {
        return result;
    }

    public boolean isCancelCalculation() {
        return cancelCalculation;
    }

    public int getChoice() {
        return choice;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }
}
