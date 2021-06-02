package hw14;

import java.util.*;

public class Homework14 {

    static Map<Integer, String[][]> digitsMap = new HashMap<>();

    public static void main(String[] args) {

        digitsMap.put(1, Digits.ONE);
        digitsMap.put(2, Digits.TWO);
        digitsMap.put(3, Digits.THREE);
        digitsMap.put(4, Digits.FOUR);
        digitsMap.put(5, Digits.FIVE);
        digitsMap.put(6, Digits.SIX);
        digitsMap.put(7, Digits.SEVEN);
        digitsMap.put(8, Digits.EIGHT);
        digitsMap.put(9, Digits.NiNE);
        digitsMap.put(0, Digits.ZERO);

        List<Integer> numbers = new ArrayList<>();
        System.out.println("Enter your numbers (0-9) : ");
        for (int i = 0; i < 5; i++) {
            Scanner scanner = new Scanner(System.in);
            int digit = scanner.nextInt();
            if (digit >= 0 && digit <= 9) {
                numbers.add(digit);
            } else {
                System.out.println("Choose digit from 0 to 9");
            }
        }

        for (int i = 0; i < 7; i++) {
            printLine(numbers, i);
        }
    }


    private static void printLine(List<Integer> numbers, int numberOfLine) {
        for (Integer integer : numbers) {
            for (String character : digitsMap.get(integer)[numberOfLine]) {
                System.out.print(character + " ");
            }
            System.out.print("   ");
        }
        System.out.println();
    }

}
