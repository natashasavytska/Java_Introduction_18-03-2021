package hw10.myIterator;

import hw8.StringCollectionImpl;

public class MyIteratorDemo {

    public static void main(String[] args) {

        StringCollectionImpl myCollection = new StringCollectionImpl();
        myCollection.add("Hello1");
        myCollection.add("Hello2");
        myCollection.add("Hello3");
        myCollection.add("Hello4");
        myCollection.add("Hello5");
        myCollection.add("Hello6");
        myCollection.add("Hello7");

        System.out.println(myCollection.size());
        MyIterator iter = myCollection.iterator();
//        iter.remove();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
        iter.remove();

//        for (int i = 0; i < 10; i++) {
//            System.out.println(iter.next());
//
//        }
        System.out.println(myCollection.size());
    }
}

