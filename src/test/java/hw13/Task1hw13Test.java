package hw13;

import org.junit.jupiter.api.Test;

import java.util.List;

import static hw13.Task1hw13.calculateAverage;
import static org.junit.jupiter.api.Assertions.*;

class Task1hw13Test {

    @Test
    void calculateAverageTest() {

        List<Integer> list = List.of(2, 5, 3, 0, 9);
        double sum = 0;
        for (int num : list) {
            sum = sum + num;
        }
        double ans = sum / list.size();
        assertEquals(ans, calculateAverage(list));

    }
}