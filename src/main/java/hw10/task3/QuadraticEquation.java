package hw10.task3;

import java.util.Scanner;

public class QuadraticEquation {
    private static double a;
    private static double b;
    private static double c;

    public static void main(String[] args) {

        System.out.println("Програма решает уравнение типа  a * x^2 + b * x + c = 0 ");
        inputValues();

        if (a == 0) {
            throw new NotZeroException();
        }

        double discriminant = countDiscriminant(a, b, c);

        if (discriminant == 0) {
            findOneRoot(a, b);
        } else if (discriminant > 0) {
            findTwoRoots(a, b, discriminant);
        } else {
            System.out.println("Уравнение не имеет корней");
        }

    }

    static void inputValues() {
        System.out.println("Введите a (не равняется 0):");
        Scanner inputA = new Scanner(System.in);
        a = inputA.nextDouble();
        System.out.println("Введите b:");
        Scanner inputB = new Scanner(System.in);
        b = inputB.nextDouble();
        System.out.println("Введите c:");
        Scanner inputC = new Scanner(System.in);
        c = inputC.nextDouble();
    }

    static double countDiscriminant(double a, double b, double c) {
        return Math.pow(b, 2) - 4 * a * c;
    }

    static void findOneRoot(double a, double b) {
        double root = (-b) / (2 * a);
        System.out.println("Корень уравнения х = " + root);
    }

    static void findTwoRoots(double a, double b, double D) {
        double root1 = ((-b) + Math.sqrt(D)) / (2 * a);
        double root2 = ((-b) - Math.sqrt(D)) / (2 * a);
        System.out.println("Корни уравнения х1 = " + root1 + ", x2 = " + root2);
    }
}
