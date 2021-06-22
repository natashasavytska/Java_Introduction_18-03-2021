package hw13;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class Task3hw13 {
    public static void main(String[] args) {

        List<String> list = List.of("mama", "Mama", "maman", "MAMA", "cola", "coLA", "gajsk", "adsd");

        System.out.println(filterAndSortList(list, 4));
    }

    public static List<String> filterAndSortList(List<String> list, int length) {
        Predicate<String> lengthIsN = (s -> s.length() == length);
        Predicate<String> lowerCase = (s -> s.equals(s.toLowerCase()));
        return list.stream()
                .filter(lengthIsN)
                .filter(lowerCase)
                .sorted()
                .collect(Collectors.toList());
    }
}
