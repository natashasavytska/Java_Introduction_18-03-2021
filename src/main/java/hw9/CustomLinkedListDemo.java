package hw9;

import java.util.ArrayList;
import java.util.List;

public class CustomLinkedListDemo {

    public static void main(String[] args) {

        CustomCollection list = new CustomLinkedList();
        list.add("First element");
        list.add("Second element");
        list.add("Third element");

        List <String> listToCompare = new ArrayList<>();
        listToCompare.add("First element");
        listToCompare.add("Second element");
        listToCompare.add("Third element");
//        listToCompare.add("Third element");

        String[] list2 = new String[2];
        list2[0] = null;
        list2[1] = "arrayElement2";

        System.out.println(list.compare(listToCompare));

//        list.addAll(list2);
//        System.out.println(list.contains("First element"));
//        System.out.println(list.contains(null));

//        System.out.println(list.size());
//        System.out.println(list);
//        list.delete("Second element");
//        list.delete(1);
//        list.delete(null);
//        System.out.println(list);
//        System.out.println(list.size());
//        list.clear();
//        System.out.println(list);
//        System.out.println(list.size());



    }
}
