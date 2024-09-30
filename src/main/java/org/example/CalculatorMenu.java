package org.example;

import java.util.Scanner;

public final class CalculatorMenu {

    private static final Scanner scanner = new Scanner(System.in);

    private CalculatorMenu() {
    }

    public static void showMenu() {
        System.out.println("Wählen Sie eine Operation:");
        System.out.println("1 - Addition");
        System.out.println("2 - Subtraktion");
        System.out.println("3 - Multiplikation");
        System.out.println("4 - Division");
        System.out.println("5 - Potenz (x^y)");
        System.out.println("6 - Modulo");
        System.out.println("0 - Beenden");
    }

    public static CalculatorModel readChoiceAndNumberValues() {
        int choice = readIntValues();
        if (choice == 0) {
            return new CalculatorModel();
        }
        var firstNumber = readDoubleValues("Bitte geben Sie die erste Zahl ein:");
        var secondNumber = readDoubleValues("Bitte geben Sie die zweite Zahl ein:");
        return new CalculatorModel(firstNumber, secondNumber, choice);
    }

    public static CalculatorModel decideForNextCalculation(CalculatorModel calculatorModel) {
        if (calculatorModel.isCancelCalculation()) {
            return calculatorModel;
        }
        calculatorModel.setCancelCalculation(readCharAndDecide("Möchten Sie eine weitere Berechnung durchführen? (j/n)"));
        return calculatorModel;
    }

    public static void decideForShowAllResults(CalculatorModel calculatorModel) {
        ResultHolder.presentAndHoldResult(calculatorModel);
        if (readCharAndDecide("Möchten Sie alle Ergebnisse ansehen? (j/n)")) {
            ResultHolder.showAllResults();
        }
    }

    public static void closeScanner() {
        scanner.close();
    }

    private static boolean readCharAndDecide(String message) {
        System.out.println(message);
        try {
            var charAt = scanner.nextLine().charAt(0);
            return charAt == 'j';
        } catch (RuntimeException e) {
            throw new CalculatorException(e.toString(), false);
        }
    }

    private static int readIntValues() {
        try {
            String nextLine = scanner.nextLine();
            return Integer.parseInt(nextLine);
        } catch (RuntimeException e) {
            throw new CalculatorException(e.toString(), false);
        }
    }

    private static double readDoubleValues(String message) {
        System.out.println(message);
        try {
            String nextLine = scanner.nextLine();
            return Double.parseDouble(nextLine);
        } catch (RuntimeException e) {
            throw new CalculatorException(e.toString(), false);
        }
    }

}
