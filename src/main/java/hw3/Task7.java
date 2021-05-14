package hw3;

import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        System.out.println("Write the number:");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        for (int i = 0; i <= 10; i++) {
            System.out.println(number + " * " + i + " = " + number * i);
        }
    }
}
