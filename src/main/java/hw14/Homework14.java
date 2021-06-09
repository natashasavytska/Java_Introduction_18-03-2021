package hw14;

import java.util.*;

public class Homework14 {

    static final Map<Integer, String[][]> digitsMap = new HashMap<>();

    public static void main(String[] args) {

        digitsMap.put(1, Digits.ONE);
        digitsMap.put(2, Digits.TWO);
        digitsMap.put(3, Digits.THREE);
        digitsMap.put(4, Digits.FOUR);
        digitsMap.put(5, Digits.FIVE);
        digitsMap.put(6, Digits.SIX);
        digitsMap.put(7, Digits.SEVEN);
        digitsMap.put(8, Digits.EIGHT);
        digitsMap.put(9, Digits.NINE);
        digitsMap.put(0, Digits.ZERO);

        List<Integer> numbers = new ArrayList<>();
        System.out.println("Enter your numbers: ");
        Scanner scanner = new Scanner(System.in);
        String digits = scanner.next();
        String[] digitsArray = digits.split("");
        Arrays.stream(digitsArray)
                .filter(s -> s.matches("\\d+"))
                .mapToInt(Integer::parseInt)
                .forEach(numbers::add);

        int numberOfLines = 7;
        for (int i = 0; i < numberOfLines; i++) {
            printLine(numbers, i, digitsMap);
        }
    }


    private static void printLine(List<Integer> numbers, int numberOfLine, Map<Integer, String[][]> digitsMap) {
        for (Integer integer : numbers) {
            for (String character : digitsMap.get(integer)[numberOfLine]) {
                System.out.print(character + " ");
            }
            System.out.print("   ");
        }
        System.out.println();
    }

}
