package Hanoi;

import java.util.Scanner;


public class Stack {
    int length;
    Node head;

    private static char[][] game = new char[20][40];
    private static int left = 0;
    private static int right = 40;
    private static int top = 0;
    private static int bottom = 20;

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
            System.out.println("moved!");
            return true;
        }
        else if (s.peek() < peek()) {
            System.out.println("You can not move to this pole.");
            return false;
        }
        s.push(pop());
        return true;
    }

    public boolean terminate()
    {
        if(this.length() == 3 && this.peek() == 3)
        {
            return true;
        }
        return false;
    }

     public void printGame(Stack pole, int size, String name) 
    {
        int poleNum = 0;
        if(name.equals("left"))
        {
            poleNum = 10;
        }
        else if(name.equals("Middle"))
        {
            poleNum = 20;
        }
        else{
            poleNum = 30;
        }
        for (int row = 0; row < game.length; row++) {
            for (int col = 0; col < game[0].length; col++) {
                if (col == left || col == (right - 1) || col == (right/4) || col == (right/2) || col == (right*3/4)) 
                {
                    if(col == (right/4) || col == (right/2) || col == (right*3/4))
                    {
                        game[row][col] = '*';

                        if(row<10 && row != 0)
                        {
                            game[row][col] = ' ';
                        }
                    }
                    else{
                        game[row][col] = '|';
                    }
                } 
                
                else if (row == top || row == (bottom - 1)) 
                {
                    game[row][col] = '-';
                }
                    
                else if (game[row][col] != 'o')
                {
                    game[row][col] = ' ';
                }
            }
        }

        int c = poleNum - size/2;
        while(c < poleNum + size/2+1)
        {
            game[game.length-1-pole.length()][c] = 'o';
            c++;
        }

        for (int row = 0; row < game.length; row++) {
            for (int col = 0; col < game[0].length; col++) {
                System.out.print(game[row][col] + " ");
            }
            System.out.println("");
        }

    }

    public static void main(String[] args) {

        Stack game = new Stack();
        Stack leftPole = new Stack();
        Stack middlePole = new Stack();
        Stack rightPole = new Stack();

        Scanner scan = new Scanner(System.in);

        leftPole.push(7);
        game.printGame(leftPole, 7, "left");
        System.out.println();

        leftPole.push(5);
        game.printGame(leftPole, 5, "left");
        System.out.println();

        leftPole.push(3);
        game.printGame(leftPole, 3, "left");
        System.out.println();


        String input = "";


       /* w while(!rightPole.terminate() && !input.equals("end"))
        {

            System.out.println("select a pole!");
            input = scan.nextLine();

        
        }

        System.out.println("did not enter the loop!");*/

       //end System.out.println(rightPole.length());
        //System.out.println(rightPole.peek());

        leftPole.move(rightPole);
        leftPole.move(middlePole);
        rightPole.move(middlePole);
        leftPole.move(rightPole);
        middlePole.move(leftPole);
        middlePole.move(rightPole);
        leftPole.move(rightPole);

        if(rightPole.terminate())
        {
            System.out.println("works!");
        }

        scan.close();
    }

    //check termination (if it works) - it works hehehe
    //get ur lazy ass to work on correcting the print method (from pole --> reciever pole)

}


