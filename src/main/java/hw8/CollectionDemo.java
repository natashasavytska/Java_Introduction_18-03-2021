package hw8;

public class CollectionDemo {

    public static void main(String[] args) {

        StringCollection myCollection = new StringCollectionImpl();
        StringCollection collectionToCompare = new StringCollectionImpl();

        myCollection.add("Hello");
        myCollection.add("Hello1");
        myCollection.add(null);

//        myCollection.add("Hello3");
//        myCollection.add("Hello4");
//        myCollection.add("Hello5");
//        myCollection.add("Hello6");
//        myCollection.add("Hello7");
//        myCollection.add("Hello8");
//        myCollection.add("Hello9");
//        myCollection.add("Hello10");
//        myCollection.add("Hello11");
//        myCollection.add("Hello12");
//        myCollection.add("Hello13");
//        myCollection.add("Hello14");
//        myCollection.add("Hello15");
//        myCollection.add("Hello16");
//        myCollection.add("Hello17");
//        myCollection.add("Hello18");

        collectionToCompare.add("Hello");
        collectionToCompare.add("Hello1");
        collectionToCompare.add(null);


//        System.out.println(myCollection);
//        System.out.println(myCollection.size());
//        myCollection.add(3,"hgjgj");
//        myCollection.delete("Hello4");
//        myCollection.delete(1);
//        System.out.println(myCollection);
//        System.out.println(myCollection.size());
//        System.out.println(myCollection.contain("Hello1"));

        System.out.println(myCollection.equals(collectionToCompare));
//        myCollection.clear();
//        System.out.println(myCollection);
    }

}
