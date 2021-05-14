package hw3;

public class Task2_3_4 {
    public static void main(String[] args) {

        int n = 5;
        int factorial = 1;

        //Task2
        if (n == 0) {
            factorial = 0;
        }
        for (int i = 1; i <= n; i++) {
            factorial = factorial * i;
        }
        System.out.println("Task2 : " + n + "! = " + factorial);

        //Task3
        int i = 1;
        factorial = 1;
        if (n == 0) {
            factorial = 0;
        }
        while (i <= n) {
            factorial = factorial * i++;
        }
        System.out.println("Task3 : " + n + "! = " + factorial);

        //Task4
        i = 1;
        factorial = 1;
        if (n == 0) {
            factorial = 0;
        }
        do {
            factorial = factorial * i++;
        } while (i <= n);
        System.out.println("Task4 : " + n + "! = " + factorial);

    }
}
