package hw13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static hw13.Task3hw13.filterAndSortList;
import static org.junit.jupiter.api.Assertions.*;

class Task3hw13Test {

    List<String> list = List.of("totto", "FHGHghhf", "gfhjt", "FGFGR", "troiy");

    @Test
    void isSorted() {
        List<String> listToCompare = List.of("gfhjt","totto","troiy");
        assertEquals(filterAndSortList(list, 5), listToCompare);
    }

    @Test
    void isFilteredByLength() {
        assertEquals(3, filterAndSortList(list,5).size());
    }



}