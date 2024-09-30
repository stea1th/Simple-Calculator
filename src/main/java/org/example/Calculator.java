package org.example;

public class Calculator {

    public static void main(String[] args) {
        boolean weiter = true;
        while (weiter) {
            try {
                CalculatorModel calculatorModel = CalculatorMenu.readChoiceAndNumberValues();
                calculatorModel = CalculationProcessor.calculateResult(calculatorModel);
                CalculatorMenu.decideForShowAllResults(calculatorModel);
                weiter = CalculatorMenu.decideForNextCalculation(calculatorModel).isCancelCalculation();
            } catch (CalculatorException e) {
                System.out.println("<<< Exception: " + e.getMessage());
                boolean fatal = e.isFatal();
                if (fatal) {
                    weiter = false;
                    CalculatorMenu.closeScanner();
                }
            }
        }
    }
}
