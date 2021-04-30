package hw9;

public class CustomLinkedListDemo {

    public static void main(String[] args) {

        CustomCollection list = new CustomLinkedList();
        list.add("First element");
        list.add("Second element");
        list.add("Third element");

        String[] list2 = new String[2];
        list2[0] = null;
        list2[1] = "arrayElement2";

        list.addAll(list2);
        System.out.println(list.size());
        System.out.println(list);
        System.out.println(list.get(2));


    }
}
