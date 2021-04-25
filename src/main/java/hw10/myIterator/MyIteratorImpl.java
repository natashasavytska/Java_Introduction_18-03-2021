package hw10.myIterator;

import hw8.StringCollection;


public class MyIteratorImpl implements MyIterator {

    StringCollection collection;
    private int index = 0;
    boolean usedNext = false;

    @Override
    public boolean hasNext() {
        return index < collection.size();
    }

    @Override
    public String next() throws NoNextElementException {
        if (hasNext()) {
            String element = collection.get(index);
            index++;
            usedNext = true;
            return element;
        } else {
            throw new NoNextElementException();
        }
    }

    @Override
    public void remove() throws WrongStateException {
        if (index >= 1 && usedNext) {
            collection.delete(index - 1);
            usedNext = false;
        } else {
            throw new WrongStateException();
        }
    }

    public MyIteratorImpl(StringCollection collection) {
        this.collection = collection;
    }
}
