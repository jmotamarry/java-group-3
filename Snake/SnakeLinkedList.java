package Snake;

public class SnakeLinkedList {
    private int left;
    private int right;
    private int top;
    private int bottom;

    private SnakeNode head;

    public SnakeLinkedList(int left, int right, int top, int bottom, SnakeNode head) {
        this.left = left;
        this.right = right;
        this.top = top;
        this.bottom = bottom;
        this.head = head;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    public int getTop() {
        return top;
    }

    public int getBottom() {
        return bottom;
    }

    public SnakeNode getHead() {
        return head;
    }

    public void setHead(SnakeNode s) {
        head = s;
    }

    public void addAtEnd(SnakeNode s) {
        SnakeNode curr = head;
        while(curr.getNext() != null) {
            curr = curr.getNext();
        }
        curr.setNext(s);
        s.setPrev(curr);
    }

    public void printList() {
        SnakeNode curr = head;
        while(curr.getNext() != null) {
            System.out.print("[" + curr.getRow() + ", " + curr.getCol() + "] -> ");
            curr = curr.getNext();
        }
        System.out.println("[" + curr.getRow() + ", " + curr.getCol() + "]");
    }

    public static void main(String[] args) {
        SnakeLinkedList snakeGame = new SnakeLinkedList(0, 20, 0, 20, null);
        SnakeNode node = new SnakeNode((snakeGame.getBottom() - snakeGame.getTop()) / 2, (snakeGame.getRight() - snakeGame.getLeft()) / 2);
        SnakeNode node2 = new SnakeNode(((snakeGame.getBottom() - snakeGame.getTop()) / 2) - 1, (snakeGame.getRight() - snakeGame.getLeft()) / 2);
        snakeGame.setHead(node);
        snakeGame.addAtEnd(node2);
        snakeGame.printList();
    }
}
