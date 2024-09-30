package org.example;

public final class CalculationProcessor {

    private CalculationProcessor() {
    }

    public static void checkMenuChoice(CalculatorModel calculatorModel) {
        calculatorModel.setMenuCheck(true);
        calculateResult(calculatorModel);
        calculatorModel.setMenuCheck(false);
    }

    public static CalculatorModel calculateResult(CalculatorModel calculatorModel) {
        return switch (calculatorModel.getChoice()) {
            case 0 -> finishCalculator();
            case 1 -> addition(calculatorModel);
            case 2 -> subtraktion(calculatorModel);
            case 3 -> multiplikation(calculatorModel);
            case 4 -> division(calculatorModel);
            case 5 -> modulo(calculatorModel);
            default -> retryCalculation();
        };
    }

    private static CalculatorModel addition(CalculatorModel calculatorModel) {
        if (calculatorModel.isMenuCheck()) {
            return calculatorModel;
        }
        var result = calculatorModel.getFirstNumber() + calculatorModel.getSecondNumber();
        calculatorModel.setResult(result);
        return calculatorModel;
    }

    private static CalculatorModel subtraktion(CalculatorModel calculatorModel) {
        if (calculatorModel.isMenuCheck()) {
            return calculatorModel;
        }
        var result = calculatorModel.getFirstNumber() - calculatorModel.getSecondNumber();
        calculatorModel.setResult(result);
        return calculatorModel;
    }

    private static CalculatorModel multiplikation(CalculatorModel calculatorModel) {
        if (calculatorModel.isMenuCheck()) {
            return calculatorModel;
        }
        var result = calculatorModel.getFirstNumber() * calculatorModel.getSecondNumber();
        calculatorModel.setResult(result);
        return calculatorModel;
    }

    private static CalculatorModel division(CalculatorModel calculatorModel) throws ArithmeticException {
        if (calculatorModel.isMenuCheck()) {
            return calculatorModel;
        }
        var firstNumber = calculatorModel.getFirstNumber();
        if (firstNumber == 0) {
            throw new CalculatorException("Teilung durch Null ist nicht erlaubt", false);
        }
        var result = firstNumber / calculatorModel.getSecondNumber();
        calculatorModel.setResult(result);
        return calculatorModel;
    }

    private static CalculatorModel modulo(CalculatorModel calculatorModel) throws ArithmeticException {
        if (calculatorModel.isMenuCheck()) {
            return calculatorModel;
        }
        var secondNumber = calculatorModel.getSecondNumber();
        if (secondNumber == 0) {
            throw new CalculatorException("Modulo durch Null ist nicht möglich", false);
        }
        var result = calculatorModel.getFirstNumber() % secondNumber;
        calculatorModel.setResult(result);
        return calculatorModel;
    }

    private static CalculatorModel finishCalculator() {
        throw new CalculatorException("Taschenrechner beendet.", true);
    }

    private static CalculatorModel retryCalculation() {
        throw new CalculatorException("Ungültige Auswahl. Bitte wählen Sie eine Zahl zwischen 0 und 6.", false);
    }
}
