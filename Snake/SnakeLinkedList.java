package Snake;
import java.util.Scanner;

public class SnakeLinkedList {
    private int left;
    private int right;
    private int top;
    private int bottom;
    private int r = 4; //Row for the original posotion of apple
    private int c = 5; //column for the original position of apple
    private static int score;
    private static char[][] game;
    private static SnakeLinkedList snakeGame = new SnakeLinkedList(0, 40, 0, 20, null,null);

    private SnakeNode head;
    private SnakeNode tail;

    //constructor 

    public SnakeLinkedList(int left, int right, int top, int bottom, SnakeNode head, SnakeNode tail) {
        this.left = left;
        this.right = right;
        this.top = top;
        this.bottom = bottom;
        this.head = head;
        this.tail = tail;
        this.game = new char[bottom - top][right - left];
    }

    //Getters + setters 

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

    public void setHead(SnakeNode s) //edited it a bittttt 
    {
        if(head == null)
        {
            head = s;
            tail = s;
        }
        head = s;
    }

    public void setTail(SnakeNode s) //added it
     {
        tail = s;
    }


    // helper methods 

    public void addAtEnd(SnakeNode s) {
        SnakeNode curr = head;
        while (curr.getNext() != null) {
            curr = curr.getNext();
        }
        curr.setNext(s);
        s.setPrev(curr);
        snakeGame.setTail(s); //added that
    }

    public void printList() {
        SnakeNode curr = head;
        while (curr.getNext() != null) {
            System.out.print("[" + curr.getRow() + ", " + curr.getCol() + "] -> ");
            curr = curr.getNext();
        }
        System.out.println("[" + curr.getRow() + ", " + curr.getCol() + "]");
    }

    public void printGame() //made some changes here 
    {
        SnakeNode currNode = head;
        
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

        if(snakeGame.spawnApple(r,c)) //added that
        {
             r = (int)(Math.random()*18+1);
             c = (int)(Math.random()*38+1);
             score++;
             snakeGame.spawnApple(r,c);
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

    public void move(String direction) {
        SnakeNode currNode = head;

        while (currNode.getNext() != null) {
            currNode = currNode.getNext();
        }

        currNode.getPrev().setNext(null);

        SnakeNode temp = null;

        if (direction.toLowerCase().equals("right")) {
            temp = new SnakeNode(head.getRow(), head.getCol() + 1);
        } else if (direction.toLowerCase().equals("up")) {
            temp = new SnakeNode(head.getRow() - 1, head.getCol());
        } else if (direction.toLowerCase().equals("left")) {
            temp = new SnakeNode(head.getRow(), head.getCol() - 1);
        } else if (direction.toLowerCase().equals("down")) {
            temp = new SnakeNode(head.getRow() + 1, head.getCol());
        }
        
        head.setPrev(temp);
        temp.setNext(head);
        head = temp;
    }

    public boolean spawnApple(int row, int col) //also grows the snake.......but it has an error i cant figure out
    {
        game[row][col] = 'o';

        if(head.getRow() == row && head.getCol() == col)
        {
            System.out.println(tail.getRow() + " " + tail.getCol());
            SnakeNode newNode = new SnakeNode(tail.getRow(),tail.getCol());
            snakeGame.addAtEnd(newNode);
            game[row][col] = ' ';
            return true;
        
        }
        return false;
    }

    public boolean terminateGame() // works more or less! (atleast as far as ive tried)
    {
        if(head.getRow() == 0 || head.getRow() == 19 || head.getCol() == 0 || head.getCol()==39)
        {
            System.out.println("You hit the boundary, game over :(");
            System.out.println("Your final score is: " + score + "! Good job :)");
            return true;
        }

        SnakeNode currentNode = head.getNext();

            while(currentNode!= null)
            {
                if(head.getRow() == currentNode.getRow() && head.getCol() == currentNode.getCol())
                {
                    System.out.println("You hit yourself, game over :(");
                    System.out.println("Your final score is: " + score + "! Good job :)");
                    return true;
                }
                currentNode = currentNode.getNext();

            }
        return false;
    }

    

    //main method
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        String input = "";

    
        SnakeNode node = new SnakeNode(((snakeGame.getBottom() - snakeGame.getTop()) / 2) - 1, ((snakeGame.getRight() - snakeGame.getLeft()) / 2) - 1);
        SnakeNode node2 = new SnakeNode(((snakeGame.getBottom() - snakeGame.getTop()) / 2) - 1, ((snakeGame.getRight() - snakeGame.getLeft()) / 2) - 2);
        SnakeNode node3 = new SnakeNode(((snakeGame.getBottom() - snakeGame.getTop()) / 2) - 1, ((snakeGame.getRight() - snakeGame.getLeft()) / 2) - 3);

        snakeGame.setHead(node);
        snakeGame.addAtEnd(node2);
        snakeGame.addAtEnd(node3);

        boolean endGame = false;
         
        while (!(input.equals("-1")) && !endGame) {
            System.out.println("Input a direction (wasd): ");
            input = sc.nextLine();

            switch (input) {
                case("w"):
                    snakeGame.move("up");
                    break;
                case("a"):
                    snakeGame.move("left");
                    break;
                case("s"):
                    snakeGame.move("down");
                    break;
                case("d"):
                    snakeGame.move("right");
                    break;
            }

            snakeGame.printGame();
            System.out.println("\nCurrent Score: " + score); //added that
            endGame = snakeGame.terminateGame();
        }
    }
}
