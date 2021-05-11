package hw13;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Task1hw13 {
    public static void main(String[] args) {

        List<Integer> list = List.of(1,2,2,4,23,4,34,123,566,0,4);
        System.out.println(calculateAverage(list));

    }

    public static double calculateAverage(Collection<Integer> list) {

        return list.stream().collect(Collectors.averagingInt(i -> i));
    }

}
