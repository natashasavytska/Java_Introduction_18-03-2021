package hw3;

public class Task5 {
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);

        if (n == 0) {
           int result = 1;
        }
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * x;
        }
        System.out.println(result);
    }
}
