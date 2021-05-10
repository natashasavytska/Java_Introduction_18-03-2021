package hw13;

import hw13.Task2hw13.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static hw13.Task2hw13.*;
import static org.junit.jupiter.api.Assertions.*;

class Task2hw13Test {

    @Test
    void checkThePair() {
        List<String> list = List.of("one", "two", "three", "four", "five");
        List<Pair> listResult = createListWithUpperCase(list);
        for (Pair p : listResult) {
            assertEquals(p.getLowerCase(), p.getUpperCase().toLowerCase());
            assertEquals(p.getUpperCase(), p.getLowerCase().toUpperCase());
        }
    }
}