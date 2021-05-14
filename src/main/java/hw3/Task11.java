package hw3;

import java.util.Arrays;

public class Task11 {
    public static void main(String[] args) {
        int[] array = {4, -5, 0, 6, 8};
        int minElement = array[0];
        int indexOfMinElement = 0;
        int maxElement = array[0];
        int indexOfMaxElement = 0;

        System.out.println(Arrays.toString(array));

        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxElement) {
                maxElement = array[i];
                indexOfMaxElement = i;
            } else if (array[i] < minElement) {
                minElement = array[i];
                indexOfMinElement = i;
            }
        }

        array[indexOfMinElement] = maxElement;
        array[indexOfMaxElement] = minElement;

        System.out.println(Arrays.toString(array));
    }
}
