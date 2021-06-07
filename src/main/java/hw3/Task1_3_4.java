package hw3;

public class Task1_3_4 {
    public static void main(String[] args) {
        // Task 1
        System.out.println("=======Task1======");
        for (int i = 1; i < 100; i += 2) {
            System.out.print(i + " ");
        }

        //Task 3
        System.out.println();
        System.out.println("=======Task3======");
        int i = 1;
        while (i < 100) {
            System.out.print(i + " ");
            i += 2;
        }

        //Task 4
        System.out.println();
        System.out.println("=======Task4======");
        i = 1;
        do {
            System.out.print(i + " ");
            i += 2;
        } while (i < 100);


    }
}
