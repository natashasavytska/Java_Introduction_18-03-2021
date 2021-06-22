package hw3;

public class Task8 {
    public static void main(String[] args) {
        int[] array = new int[10];
        int counter = 0;
        for (int i = 1; counter < 10; i += 2) {
            array[counter] = i;
            System.out.print(array[counter++]);
            if (counter == 10) {
                break;
            }
            System.out.print(", ");
        }
    }
}
