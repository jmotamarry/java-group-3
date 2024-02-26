package Hanoi;

public class Node {
    int size;
    Node next;

    public Node(int size) {
        this.size = size;
        next = null;
    }

    public int getSize() {
        return size;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
