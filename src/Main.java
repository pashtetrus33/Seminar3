public class Main {
    public static void main(String[] args) {

        LinkedListBorrowed<Integer> linkedList = new LinkedListBorrowed<>();

        linkedList.add(5);
        linkedList.add(8);
        linkedList.add(2);
        linkedList.add(23);
        linkedList.add(456);
        linkedList.add(0);
        linkedList.add(-34);

        System.out.println("LinkedList size: " + linkedList.size);

        linkedList.forEach(System.out::println);

        for (Integer item: linkedList) {
            System.out.println("Item: " + item);
        }

        LinkedListBorrowed<String> linkedList2 = new LinkedListBorrowed<>();

        linkedList2.add("Milk");
        linkedList2.add("Meat");
        linkedList2.add("Water");
        linkedList2.add("Tea");
        linkedList2.add("Cheese");
        linkedList2.add("Bread");

        System.out.println("LinkedList2 size: " + linkedList2.size);

        System.out.println(linkedList2);
        System.out.println("------------------------------------------------------");

        System.out.println(linkedList2.get(4));

        linkedList2.remove("Water");
        System.out.println("LinkedList2 size: " + linkedList2.size);
        System.out.println(linkedList2);
    }
}








