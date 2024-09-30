package org.example;

import java.util.Scanner;

public final class CalculatorMenu {

    private static final Scanner scanner = new Scanner(System.in);

    private CalculatorMenu() {
    }

    public static CalculatorModel readMenuChoice() {
        int choice = readIntValues(showMenu());
        return new CalculatorModel(choice);
    }

    public static void readExpressionNumberValues(CalculatorModel calculatorModel) {
        calculatorModel.setFirstNumber(readDoubleValues("Bitte geben Sie die erste Zahl ein:"));
        calculatorModel.setSecondNumber(readDoubleValues("Bitte geben Sie die zweite Zahl ein:"));
    }

    public static void decideForNextCalculation() {
        if (!readCharAndDecide("Möchten Sie eine weitere Berechnung durchführen? (j/n)")) {
            throw new CalculatorException("Taschenrechner beendet.", true);
        }
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

    private static String showMenu() {
        return "Wählen Sie eine Operation: " + System.lineSeparator()
                + "1 - Addition " + System.lineSeparator()
                + "2 - Subtraktion " + System.lineSeparator()
                + "3 - Multiplikation " + System.lineSeparator()
                + "4 - Division " + System.lineSeparator()
                + "5 - Modulo " + System.lineSeparator()
                + "0 - Beenden";
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

    private static int readIntValues(String message) {
        System.out.println(message);
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

