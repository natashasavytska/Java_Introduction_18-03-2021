package hw8;

import hw10.myIterator.MyIterator;
import hw10.myIterator.MyIteratorImpl;

public interface StringCollection {

    boolean add(String str);

    boolean add(int index, String str);

    boolean delete(String str);

    boolean delete(int index);

    String get(int index);

    boolean contain(String str);

    boolean equals(StringCollection str);

    boolean clear();

    int size();

    MyIterator iterator();
}
