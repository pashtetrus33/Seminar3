import java.util.Iterator;

public class Main2 {
    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();

        myLinkedList.add(5);
        myLinkedList.add(8);
        myLinkedList.add(2);
        myLinkedList.add(23);
        myLinkedList.add(456);
        myLinkedList.add(0);
        myLinkedList.add(-34);

        for (Integer item : myLinkedList) {
            System.out.println(item);
        }

        System.out.println("LinkedList size: " + myLinkedList.size());

        myLinkedList.deleteNodeAt(5);
        myLinkedList.forEach(System.out::println);
    }
}

class MyLinkedList<E> implements Iterable<E> {

    private Node<E> head;
    private int size = 0;

    MyLinkedList() {
    }

    public int size() {
        return size;
    }

    private static class Node<E> {

        private E data;
        private Node<E> nextNode;


        public Node(E data) {
            this.data = data;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node<E> getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node<E> nextNode) {
            this.nextNode = nextNode;
        }

        boolean isNext() {
            return nextNode != null;
        }
    }

    public void add(E data) {
        Node<E> newNode = new Node<E>(data);
        if (this.head == null) {
            head = newNode;
        } else {
            Node<E> currentNode = head;
            while (currentNode.getNextNode() != null) {
                currentNode = currentNode.getNextNode();
            }
            currentNode.setNextNode(newNode);
        }
        size++;
    }

    public void deleteNodeAt(int index) {
        Node<E> node = head;
        for (int i = 0; i < index - 1; i++) {
            node = node.getNextNode();
        }
        node.setNextNode(node.getNextNode().getNextNode());
    }

    @Override
    public String toString() {
        if (head != null) {
            StringBuilder stringBuilder = new StringBuilder();
            Node currentNode = head;
            while (currentNode.getNextNode() != null) {
                stringBuilder.append(currentNode.getData());
                currentNode = currentNode.getNextNode();
            }
            stringBuilder.append(currentNode.getData());
            return stringBuilder.toString();
        }
        return "List is empty!";
    }

    @Override
    public Iterator<E> iterator() {
        return new MyListIterator(head);
    }

    private class MyListIterator implements Iterator<E> {
        private Node<E> current;
        private boolean isFirst = true;

        public MyListIterator(Node<E> node) {
            this.current = node;
        }


        @Override
        public boolean hasNext() {
            if (size == 1 && isFirst) return true;
            return current.isNext();
        }

        @Override
        public E next() {
            if (isFirst) isFirst = false;
            else current = current.nextNode;
            return current.getData();
        }
    }
}

