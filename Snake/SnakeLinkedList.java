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
        while (curr.getNext() != null) {
            curr = curr.getNext();
        }
        curr.setNext(s);
        s.setPrev(curr);
    }

    public void printList() {
        SnakeNode curr = head;
        while (curr.getNext() != null) {
            System.out.print("[" + curr.getRow() + ", " + curr.getCol() + "] -> ");
            curr = curr.getNext();
        }
        System.out.println("[" + curr.getRow() + ", " + curr.getCol() + "]");
    }

    public void printGame() {
        SnakeNode currNode = head;
        char[][] game = new char[bottom - top][right - left];

        for (int row = 0; row < game.length; row++) {
            for (int col = 0; col < game[0].length; col++) {
                if (col == left || col == (right - 1)) {
                    game[row][col] = '|';
                } else if (row == top || row == (bottom - 1)) {
                    game[row][col] = '-';
                } else {
                    game[row][col] = ' ';
                }
            }
        }

        while (currNode != null) {
            game[currNode.getRow()][currNode.getCol()] = '*';
            currNode = currNode.getNext();
        }

        for (int row = 0; row < game.length; row++) {
            for (int col = 0; col < game[0].length; col++) {
                System.out.print(game[row][col] + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        SnakeLinkedList snakeGame = new SnakeLinkedList(0, 40, 0, 20, null);
        SnakeNode node = new SnakeNode((snakeGame.getBottom() - snakeGame.getTop()) / 2, (snakeGame.getRight() - snakeGame.getLeft()) / 2);
        SnakeNode node2 = new SnakeNode(((snakeGame.getBottom() - snakeGame.getTop()) / 2) - 1, (snakeGame.getRight() - snakeGame.getLeft()) / 2);
        SnakeNode node3 = new SnakeNode(((snakeGame.getBottom() - snakeGame.getTop()) / 2) - 1, ((snakeGame.getRight() - snakeGame.getLeft()) / 2) - 1);
        snakeGame.setHead(node);
        snakeGame.addAtEnd(node2);
        snakeGame.addAtEnd(node3);
        snakeGame.printList();
        snakeGame.printGame();
    }
}
