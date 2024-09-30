package org.example;

public final class CalculationProcessor {

    private CalculationProcessor() {
    }

    public static CalculatorModel calculateResult(CalculatorModel calculatorModel) {
        return switch (calculatorModel.getChoice()) {
            case 0 -> finishCalculator(calculatorModel);
            case 1 -> addition(calculatorModel);
            case 2 -> subtraktion(calculatorModel);
            case 3 -> multiplikation(calculatorModel);
            case 4 -> division(calculatorModel);
            case 5 -> modulo(calculatorModel);
            default -> retryCalculation(calculatorModel);
        };
    }

    private static CalculatorModel addition(CalculatorModel calculatorModel) {
        var result = calculatorModel.getFirstNumber() + calculatorModel.getSecondNumber();
        calculatorModel.setResult(result);
        return calculatorModel;
    }

    private static CalculatorModel subtraktion(CalculatorModel calculatorModel) {
        var result = calculatorModel.getFirstNumber() - calculatorModel.getSecondNumber();
        calculatorModel.setResult(result);
        return calculatorModel;
    }

    private static CalculatorModel multiplikation(CalculatorModel calculatorModel) {
        var result = calculatorModel.getFirstNumber() * calculatorModel.getSecondNumber();
        calculatorModel.setResult(result);
        return calculatorModel;
    }

    private static CalculatorModel division(CalculatorModel calculatorModel) throws ArithmeticException {
        var firstNumber = calculatorModel.getFirstNumber();
        if (firstNumber == 0) {
            throw new CalculatorException("Teilung durch Null ist nicht erlaubt", false);
        }
        var result = firstNumber / calculatorModel.getSecondNumber();
        calculatorModel.setResult(result);
        return calculatorModel;
    }

    private static CalculatorModel modulo(CalculatorModel calculatorModel) throws ArithmeticException {
        var secondNumber = calculatorModel.getSecondNumber();
        if (secondNumber == 0) {
            throw new CalculatorException("Modulo durch Null ist nicht möglich", false);
        }
        var result = calculatorModel.getFirstNumber() % secondNumber;
        calculatorModel.setResult(result);
        return calculatorModel;
    }

    private static CalculatorModel finishCalculator(CalculatorModel calculatorModel) {
        System.out.println("Taschenrechner beendet.");
        calculatorModel.setCancelCalculation(true);
        return calculatorModel;
    }

    private static CalculatorModel retryCalculation(CalculatorModel calculatorModel) {
        System.out.println("Ungültige Auswahl. Bitte wählen Sie eine Zahl zwischen 0 und 6.");
        return calculatorModel;
    }
}
