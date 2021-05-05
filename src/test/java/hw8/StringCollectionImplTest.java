package hw8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCollectionImplTest {

    @Test
    void successfullyAdd() {
        StringCollection list = new StringCollectionImpl();
        list.add("hgj1");
        assertEquals(1, list.size());
    }

    @Test
    void expandIfListIsLoaded() {
        int numberOfAddedElements = 15;
        StringCollection list = createListOfElements(numberOfAddedElements);
        assertEquals(numberOfAddedElements, list.size());
    }

    @Test
    void successfullyAddByIndex() {
        int index = 15;
        int numberOfAddedElements = 20;
        StringCollection list = createListOfElements(numberOfAddedElements);
        String s = "added element";
        list.add(index, s);
        assertEquals(numberOfAddedElements + 1, 21);
        assertEquals(s, list.get(index));
    }

    @Test
    void deleteString() {
        StringCollection list = new StringCollectionImpl();
        String s = "added element";
        list.add(s);
        assertTrue(list.delete(s));
        assertEquals(0, list.size());
        assertFalse(list.contain(s));
    }

    @Test
    void deleteByIndex() {
        StringCollection list = new StringCollectionImpl();
        String s = "added element";
        list.add(s);
        assertTrue(list.delete(0));
        assertEquals(0, list.size());
        assertFalse(list.contain(s));
    }

    @Test
    void get() {
        StringCollection list = createListOfElements(15);
        assertEquals("number3", list.get(3));
    }

    @Test
    void contain() {
        StringCollection list = createListOfElements(20);
        assertTrue(list.contain("number3"));
        assertFalse(list.contain("Number0"));
    }

    @Test
    void equals() {
        assertTrue(createListOfElements(3).equals(createListOfElements(3)));
    }

    @Test
    void clear() {
        StringCollection list = createListOfElements(20);
        assertTrue(list.clear());
        assertEquals(0, list.size());
    }

    @Test
    void size() {
        StringCollection list = new StringCollectionImpl();
        assertEquals(0, list.size());
        list.add("hello");
        assertEquals(1, list.size());
        list.delete(0);
        assertEquals(0, list.size());
    }

    private StringCollection createListOfElements(int numberOfElements) {
        StringCollection list = new StringCollectionImpl();
        for (int i = 0; i < numberOfElements; i++) {
            list.add("number" + i);
        }
        return list;
    }

}