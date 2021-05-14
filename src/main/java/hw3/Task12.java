package hw3;

public class Task12 {
    public static void main(String[] args) {
        int[] array = {4, -5, 0, 6, 8};
        double sum = 0;
        for (int i : array) {
            sum = sum + i;
        }
        System.out.println("Среднее арифметическое элементов массива = " + sum / array.length);
    }
}
