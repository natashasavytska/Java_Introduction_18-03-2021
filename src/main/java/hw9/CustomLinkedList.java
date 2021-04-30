package hw9;

import java.util.Collection;
import java.util.Objects;

public class CustomLinkedList implements CustomCollection {

    private int size;
    private Node head;
    private Node tail;

    @Override
    public boolean add(String str) {
        if (size == 0) {
            head = new Node(str);
            tail = head;
        } else {
            Node nodeBeforeTail = tail;
            tail = new Node(str);
            createLinksBetweenNodes(nodeBeforeTail, tail);
        }
        size++;
        return true;
    }

    private void createLinksBetweenNodes(Node previous, Node current) {
        previous.next = current;
        current.previous = previous;
    }

    @Override
    public boolean addAll(String[] strArr) {
        for (String s : strArr) {
            add(s);
        }
        return true;
    }

    @Override
    public boolean addAll(Collection strColl) {

        return false;
    }

    @Override
    public boolean delete(int index) {
        return false;
    }

    private void checkIfIndexIsCorrect(int index) {
        if (index >= size || index < 0) {
            throw new OutOfListException("Index " + index + " is out of members of the list.");
        }
    }

    private Node findNodeByIndex(int index) {
        if (index == 0) {
            return head;
        } else if (index == size - 1) {
            return tail;
        }

        Node currentNode;
        if (index < size / 2) {
            currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
        } else {
            currentNode = tail;
            for (int i = size - 1; i > index; i--) {
                currentNode = currentNode.previous;
            }
        }
        return currentNode;
    }

    @Override
    public boolean delete(String str) {
        return false;
    }

    @Override
    public String get(int index) {
        checkIfIndexIsCorrect(index);
        Node currentNode = findNodeByIndex(index);
        return currentNode.element;
    }

    @Override
    public boolean contains(String str) {
        return false;
    }

    @Override
    public boolean clear() {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean trim() {
        return true;
    }

    @Override
    public boolean compare(Collection coll) {
        return false;
    }


    private static class Node {

        Node previous;
        Node next;
        String element;

        public Node(String element) {
            this.element = element;
        }

        @Override
        public String toString() {
            return element;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(previous, node.previous) && Objects.equals(next, node.next) && Objects.equals(element, node.element);
        }

        @Override
        public int hashCode() {
            return Objects.hash(previous, next, element);
        }
    }

    @Override
    public String toString() {
        StringBuilder listOfElements = new StringBuilder();
        Node currentNode = head;
        listOfElements.append("[");
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                listOfElements.append(currentNode);
                currentNode = currentNode.next;
            } else if (i == size - 1) {
                listOfElements.append("; ").append(currentNode);
            } else {
                listOfElements.append("; ").append(currentNode);
                currentNode = currentNode.next;
            }
        }
        listOfElements.append("]");
        return listOfElements.toString();
    }
}
