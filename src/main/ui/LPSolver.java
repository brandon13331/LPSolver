package ui;

import java.util.Scanner;

public class LPSolver {
    private Scanner scanner;

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
            } else
                break;
        }
    }
}
