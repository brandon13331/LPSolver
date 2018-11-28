package ui;

import model.Dictionary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LPSolver {
    private Scanner scanner;
    private int numNBVar;
    private int numBVar;
    private int eVar;
    private int lVar;
    private List<List<Double>> basicVariables = new ArrayList<>();
    private List<Double> objectiveFunction = new ArrayList<>();
    private Dictionary dictionary = new Dictionary();

    public static void main(String[] args) {
        new LPSolver();
    }

    private LPSolver() {
        int operation;
        scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Simplex Method");
            operation = scanner.nextInt();
            if (operation == 1) {
                setUp();
            } else
                break;
        }
    }

    private void setUp() {
        System.out.println("Enter the number of nonbasic variables");
        numNBVar = scanner.nextInt();

        System.out.println("Enter the number of basic variables");
        numBVar = scanner.nextInt();

        for (int x = 1 + numBVar; x <= numBVar * 2; x++) {
            System.out.println("X" + x + " =");
            List<Double> basicVariable = new ArrayList<>();
            basicVariable.add((double) x);

            System.out.println("Enter the RHS value of constraint " + (x - numBVar));
            double rhs = scanner.nextDouble();
            basicVariable.add(rhs);

            for (int y = 1; y <= numNBVar; y++) {
                System.out.println("Enter the coefficient of X" + y);
                double coefficient = -scanner.nextDouble();
                basicVariable.add(coefficient);
            }
            for (int y = 0; y < numBVar; y++) {
                basicVariable.add(0.0);
            }
            basicVariables.add(basicVariable);
        }
        System.out.println("Setting up the slack variables...");

        for (int i = 1; i <= numNBVar; i++) {
            System.out.println("Enter the coefficient of X" + i);
            double coefficient = scanner.nextInt();
            objectiveFunction.add(coefficient);
        }
        for (int i = 0; i < numBVar; i++) {
            objectiveFunction.add(0.0);
        }
        eVar = getIndexOfMaxValue(objectiveFunction) + 1;
        objectiveFunction.add(0, 0.0);

        List<Double> eVarCoefficients = new ArrayList<>();
        for (int i = 0; i < numBVar; i++) {
            List<Double> list = basicVariables.get(i);
            eVarCoefficients.add(list.get(eVar + 1));
        }
        for (int i = 0; i < eVarCoefficients.size(); i++) {
            double eVarCoefficient = eVarCoefficients.get(i);
            double rhs = basicVariables.get(i).get(0);
            eVarCoefficient = eVarCoefficient / rhs;
            eVarCoefficients.set(i, eVarCoefficient);
        }
        lVar = getIndexOfMinValue(eVarCoefficients) + numBVar + 1;

        dictionary.setBasicVariables(basicVariables);
        dictionary.setObjectiveFunction(objectiveFunction);
        System.out.println("Setting up the initial dictionary...");
    }

    private int getIndexOfMaxValue(List<Double> list) {
        double max = list.get(1);
        for (int i = 2; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }
        return list.indexOf(max);
    }

    private int getIndexOfMinValue(List<Double> list) {
        return list.indexOf(Collections.min(list));
    }
}
