package hw2;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        System.out.println("Введите сумму денежного вклада");
        Scanner inputA = new Scanner(System.in);
        double amount = inputA.nextDouble();
        System.out.println("Введите ставку % годовых");
        Scanner inputB = new Scanner(System.in);
        double interestRate = inputB.nextDouble();
        System.out.println("Введите срок вклада (лет)");
        Scanner inputC = new Scanner(System.in);
        int term = inputC.nextInt();

        if (amount <= 0 || interestRate <= 0 || term <= 0) {
            System.out.println("Проверьте условия депозита. Значения не могут быть <=0");
        } else {
            for (int i = 0; i < term; i++) {
                for (int j = 0; j < 12; j++) {
                    amount = amount * (1 + interestRate / 100 / 12);
                }
                System.out.println("Накопленная сумма за " + (i + 1) + " год(а) = " + amount + " грн");
            }
        }

    }
}