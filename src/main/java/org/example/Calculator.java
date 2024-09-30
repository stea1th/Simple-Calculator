package org.example;

public class Calculator {

    public static void main(String[] args) {
        boolean isTrue = true;
        while (isTrue) {
            try {
                CalculatorModel calculatorModel = CalculatorMenu.readMenuChoice();
                CalculationProcessor.checkMenuChoice(calculatorModel);
                CalculatorMenu.readExpressionNumberValues(calculatorModel);
                calculatorModel = CalculationProcessor.calculateResult(calculatorModel);
                CalculatorMenu.decideForShowAllResults(calculatorModel);
                CalculatorMenu.decideForNextCalculation();
            } catch (CalculatorException e) {
                System.out.println("<<< Exception: " + e.getMessage());
                if (e.isFatal()) {
                    isTrue = false;
                    CalculatorMenu.closeScanner();
                }
            }
        }
    }
}
