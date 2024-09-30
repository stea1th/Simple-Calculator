package org.example;

import java.util.HashSet;

public final class ResultHolder {

    private final static HashSet<Double> resultSet = new HashSet<>();

    private ResultHolder() {
    }

    public static void presentAndHoldResult(CalculatorModel calculatorModel) {
        Double result = calculatorModel.getResult();
        if (result != null) {
            System.out.println("Das Ergebnis ist: " + result);
            persistResult(result);
        }
    }

    public static void showAllResults() {
        System.out.println("Alle Ergebnisse:");
        resultSet.forEach(System.out::println);
    }

    private static void persistResult(Double result) {
        if (resultSet.contains(result)) {
            System.out.println("Dieses Ergebnis wurde bereits berechnet.");
        } else {
            resultSet.add(result);
            System.out.println("Das Ergebnis wurde erfolgreich gespeichert.");
        }
    }
}
