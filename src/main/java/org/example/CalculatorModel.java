package org.example;

public class CalculatorModel {

    private double firstNumber;

    private double secondNumber;

    private Double result;

    private boolean isMenuCheck;

    private int choice;

    public CalculatorModel(int choice) {
        this.choice = choice;
    }

    public boolean isMenuCheck() {
        return isMenuCheck;
    }

    public void setMenuCheck(boolean menuCheck) {
        isMenuCheck = menuCheck;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
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

