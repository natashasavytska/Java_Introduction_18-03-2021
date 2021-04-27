package hw2;

public class Task2 {
    public static void main(String[] args) {
        double sum = 0;
        for (String s : args) {
            sum += Double.valueOf(s);
        }
        System.out.println("Arithmetic mean = " + sum / args.length);
    }
}
