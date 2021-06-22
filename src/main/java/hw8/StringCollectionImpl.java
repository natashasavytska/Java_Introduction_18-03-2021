package hw8;

import hw10.myIterator.MyIterator;
import hw10.myIterator.MyIteratorImpl;

import java.util.Arrays;
import java.util.Objects;

public class StringCollectionImpl implements StringCollection {

    private int indexOfNextFreeCell = 0;
    private int internalArrayLength = 10;
    private String[] internalArray = new String[10];


    @Override
    public boolean add(String str) {
        if (indexOfNextFreeCell >= internalArrayLength - 1) {
            expandInternalArray();
        }
        addElementToInternalArray(str, indexOfNextFreeCell);
        return true;
    }

    @Override
    public boolean add(int index, String str) {
        if (indexOfNextFreeCell >= internalArrayLength - 1) {
            expandInternalArray();
        }
        if (indexOfNextFreeCell + 1 - index >= 0)
            System.arraycopy(internalArray, index, internalArray, index + 1, indexOfNextFreeCell + 1 - index);
        internalArray[index] = str;
        indexOfNextFreeCell++;
        return true;
    }

    @Override
    public boolean delete(String str) {
        for (int i = 0; i < indexOfNextFreeCell; i++) {
            if (internalArray[i].equals(str)) {
                internalArray[i] = null;
                for (int j = i; j < indexOfNextFreeCell - 1; j++) {
                    internalArray[i] = internalArray[i + 1];
                }
                internalArray[indexOfNextFreeCell] = null;
                indexOfNextFreeCell--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(int index) {
        internalArray[index] = null;
        if (indexOfNextFreeCell - (index + 1) >= 0) {
            System.arraycopy(internalArray, index + 1, internalArray, index + 1 - 1, indexOfNextFreeCell - (index + 1));
            indexOfNextFreeCell--;
            return true;
        }

        return false;
    }

    @Override
    public String get(int index) {
        return internalArray[index];
    }

    @Override
    public boolean contain(String str) {
        for (int i = 0; i < indexOfNextFreeCell; i++) {
            if (internalArray[i].equals(str)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(StringCollection str) {
        if ((str == null) || (str.size() != indexOfNextFreeCell)) {
            return false;
        }
        for (int i = 0; i < indexOfNextFreeCell; i++) {
            if (!Objects.equals(internalArray[i], str.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean clear() {
        internalArray = null;
        indexOfNextFreeCell = 0;
        internalArray = new String[10];
        return true;
    }

    @Override
    public int size() {
        return indexOfNextFreeCell;
    }

    @Override
    public MyIterator iterator() {
        return new MyIteratorImpl(this);
    }

    private void expandInternalArray() {
        int desiredCapacity = internalArray.length * 2;
        internalArrayLength = desiredCapacity;
        internalArray = Arrays.copyOf(internalArray, desiredCapacity);
    }

    private void addElementToInternalArray(String element, int index) {
        internalArray[index] = element;
        indexOfNextFreeCell++;
    }

    @Override
    public String toString() {
        return Arrays.toString(internalArray);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringCollectionImpl that = (StringCollectionImpl) o;
        return indexOfNextFreeCell == that.indexOfNextFreeCell && Arrays.equals(internalArray, that.internalArray);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(indexOfNextFreeCell);
        result = 31 * result + Arrays.hashCode(internalArray);
        return result;
    }

}
