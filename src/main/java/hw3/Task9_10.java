package hw3;

import java.util.Arrays;

public class Task9_10 {
    public static void main(String[] args) {
        int[] array = {2, 5, 6, 4, 5, 2, 9, 8, 9};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        System.out.print("Min element(s): ");
        int index = 0;
        while (array[index] == array[0]) {
            System.out.print(array[index++] + " ");
        }
        System.out.println();
        System.out.print("Max element(s): ");
        index = array.length-1;
        while (array[index] == array[array.length-1]) {
            System.out.print(array[index--] + " ");
        }
    }
}
