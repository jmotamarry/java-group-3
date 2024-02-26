package Hanoi;

public class Stack {
    int length;
    Node head;

    public Stack() {
        length = 0;
        head = null;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void push(int size) {
        Node tempNode = new Node(size);

        if (head == null) {
            length += 1;
            head = tempNode;
        } else {
            tempNode.setNext(head);
            length += 1;
            head = tempNode;
        }
    }

    public int pop() {
        if (head == null) {
            throw new IllegalStateException("You can not pop from an empty stack.");
        } else {
            int data = head.getSize();
            head = head.getNext();
            length -= 1;
            return data;
        }
    }

    public int peek() {
        if (head == null) {
            throw new IllegalStateException("You can not pop from an empty stack.");
        } else {
            return head.getSize();
        }
    }

    public int length() {
        return length;
    }

    public boolean move(Stack s) {
        if (s.length() == 0) {
            s.push(pop());
            return true;
        }
        else if (s.peek() < peek()) {
            System.out.println("You can not move to this pole.");
            return false;
        }
        s.push(pop());
        return true;
    }

    public static void main(String[] args) {
        Stack leftPole = new Stack();
        Stack middlePole = new Stack();
        Stack rightPole = new Stack();

        leftPole.push(6);
        leftPole.push(4);
        leftPole.push(2);

        leftPole.move(middlePole);
        leftPole.move(middlePole);
    }
}
