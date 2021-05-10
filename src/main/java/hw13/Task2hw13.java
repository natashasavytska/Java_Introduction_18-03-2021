package hw13;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;


public class Task2hw13 {

    public static void main(String[] args) {

        List<String> list = List.of("one", "two", "three", "four", "five");

        System.out.println(createListWithUpperCase(list));

    }

    @AllArgsConstructor
    @Getter
    static class Pair {
        String lowerCase;
        String upperCase;

        @Override
        public String toString() {
            return lowerCase + ":" + upperCase;
        }
    }

    public static List<Pair> createListWithUpperCase(List<String> list) {
        return list
                .stream()
                .map(s -> new Pair(s, s.toUpperCase()))
                .collect(Collectors.toList());
    }
}
