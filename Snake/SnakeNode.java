package Snake;
public class SnakeNode {
    private SnakeNode next;
    private SnakeNode prev;
    private int row;
    private int col;

    public SnakeNode(int row, int col) {
        this.row = row;
        this.col = col;
        next = null;
        prev = null;
    }

    public SnakeNode getNext() {
        return next;
    }

    public void setNext(SnakeNode s) {
        next = s;
    }

    public SnakeNode getPrev() {
        return prev;
    }

    public void setPrev(SnakeNode s) {
        prev = s;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int num) {
        row = num;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int num) {
        col = num;
    }
}
