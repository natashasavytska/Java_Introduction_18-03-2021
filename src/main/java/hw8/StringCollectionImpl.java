package hw8;

import java.util.Arrays;

public class StringCollectionImpl implements StringCollection {

    private int indexOfNextFreeCell = 0;
    private int internalArrayLength = 10;
    private String[] internalArray = new String[10];


    @Override
    public boolean add(String str) {
        if (indexOfNextFreeCell < internalArrayLength - 1) {
            addElementToInternalArray(str, indexOfNextFreeCell);
            return true;
        } else {
            expandInternalArray();
            addElementToInternalArray(str, indexOfNextFreeCell);
        }
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
        if (indexOfNextFreeCell - (index + 1) >= 0)
            System.arraycopy(internalArray, index + 1, internalArray, index + 1 - 1, indexOfNextFreeCell - (index + 1));
        indexOfNextFreeCell--;
        return true;
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
    public boolean equals(String[] str) {
        return Arrays.equals(internalArray, str);
    }

    @Override
    public boolean clear() {
        internalArray = null;
        internalArray = new String[10];
        return true;
    }

    @Override
    public int size() {
        return indexOfNextFreeCell;
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
}
