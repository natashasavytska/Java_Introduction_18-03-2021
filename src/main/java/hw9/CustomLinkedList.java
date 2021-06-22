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
    public boolean addAll(Collection<String> strColl) {
        for (String s : strColl) {
            add(s);
        }
        return true;
    }

    @Override
    public boolean delete(int index) {
        checkIfIndexIsCorrect(index);
        Node nodeToBeRemoved = findNodeByIndex(index);
        removeNode(nodeToBeRemoved);
        return true;
    }

    private void checkIfIndexIsCorrect(int index) {
        if (index >= size || index < 0) {
            throw new OutOfListException("Index " + index + " is out of members of the list.");
        }
    }

    private void removeNode(Node toRemove) {
        if (toRemove.equals(head)) {
            head = head.next;
            head.previous = null;
        } else if (toRemove.equals(tail)) {
            tail = tail.previous;
            tail.next = null;
        } else {
            Node previousNode = toRemove.previous;
            Node nextNode = toRemove.next;
            createLinksBetweenNodes(previousNode, nextNode);
        }
        size--;
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
        Node currentNode = head;

        if (str == null) {
            for (int i = 0; i < size; i++) {
                if (currentNode.element == null) {
                    removeNode(currentNode);
                    return true;
                } else {
                    currentNode = currentNode.next;
                }
            }
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (currentNode.element != null && currentNode.element.equals(str)) {
                removeNode(currentNode);
                return true;
            } else {
                currentNode = currentNode.next;
            }
        }
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
        Node currentNode = head;
        if (str == null) {
            for (int i = 0; i < size; i++) {
                if (currentNode.element == null) {
                    return true;
                } else {
                    currentNode = currentNode.next;
                }
            }
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (currentNode.element != null && currentNode.element.equals(str)) {
                return true;
            } else {
                currentNode = currentNode.next;
            }
        }
        return false;
    }

    @Override
    public boolean clear() {
        Node currentNode = head;
        for (int i = 0; i < size; i++) {
            currentNode.element = null;
            currentNode.previous = null;
            Node tmp = currentNode.next;
            currentNode.next = null;
            currentNode = tmp;
        }
        head = null;
        tail = null;
        size = 0;
        return true;
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
    public boolean compare(Collection<String> coll) {
        if (!(coll.size() == this.size)) {
            return false;
        }
        Node currentNode = head;
        for (String s : coll) {
            if (s.equals(currentNode.element)) {
                currentNode = currentNode.next;
            } else {
                return false;
            }
        }
        return true;
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
