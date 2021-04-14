package hw8;

public interface StringCollection {

    boolean add(String str);

    boolean add(int index, String str);

    boolean delete(String str);

    boolean delete(int index);

    String get(int index);

    boolean contain(String str);

    boolean equals(String[] str);

    boolean clear();

    int size();
}
