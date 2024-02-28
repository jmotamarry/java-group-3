package Hanoi;

import java.util.Scanner;

public class Stack {
   int length;
   Node head;
   String name;


   private static char[][] game = new char[20][40];
   private static int left = 0;
   private static int right = 40;
   private static int top = 0;
   private static int bottom = 20;


   public Stack(String name) {
       length = 0;
       head = null;
       this.name = name;
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
   
   public static void drawDisc(Stack to, int size)
   {
       int poleNumTo = 0;
       if(to.name.equals("left"))
       {
           poleNumTo = 10;
       }
       else if(to.name.equals("middle"))
       {
           poleNumTo = 20;
       }
       else{
           poleNumTo = 30;
       }


       int c = poleNumTo - size/2;
       while(c < poleNumTo + size/2+1)
       {
           game[game.length-1-to.length()][c] = 'o';
           c++;
       }
   }
  
   public static void removeDisc(Stack from, int size)
   {
       int poleNumFrom = 0;
       if(from.name.equals("left"))
       {
           poleNumFrom = 10;
       }
       else if(from.name.equals("middle"))
       {
           poleNumFrom = 20;
       }
       else{
           poleNumFrom = 30;
       }

       int c = poleNumFrom - size/2;
       while(c < poleNumFrom + size/2+1)
       {
           game[game.length-1-from.length()-1][c] = ' ';
           if(c == poleNumFrom)
           {
               game[game.length-1-from.length()][c] = '*';
           }
           c++;
       }


   }
  
   public boolean move(Stack to) {

        int discSize = 0;
      
       if (to.length() == 0) {
           to.push(pop());
           discSize = to.peek();
           System.out.println("moved!");
       }
       else if (to.peek() < peek()) {
           System.out.println("You can not move to this pole.");
           return false;
       }
       else{
           to.push(pop());
           discSize = to.peek();
       }

       drawDisc(to, discSize);
       removeDisc(this, discSize);
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

   public static void printGame()
   {
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


       for (int row = 0; row < game.length; row++) {
           for (int col = 0; col < game[0].length; col++) {
               System.out.print(game[row][col] + " ");
           }
           System.out.println("");
       }


   }


   public static void main(String[] args) {


       Stack game = new Stack("game");
       Stack leftPole = new Stack("left");
       Stack middlePole = new Stack("middle");
       Stack rightPole = new Stack("right");


       Scanner scan = new Scanner(System.in);


       leftPole.push(7);
       drawDisc(leftPole,7);
       leftPole.push(5);
       drawDisc(leftPole,5);
       leftPole.push(3);
       drawDisc(leftPole,3);


       printGame();


       String input = "";
       while(!rightPole.terminate() && !input.equals("end"))
        {
           Stack from = rightPole;
           Stack to = rightPole;


           System.out.println("select a pole to move from!");
           input = scan.nextLine();
           String poleFrom = input;


           System.out.println("select a pole to move to!");
           input = scan.nextLine();
           String poleTo = input;


           if(poleFrom.toLowerCase().equals("left"))
           {
               from = leftPole;
           }
           else if(poleFrom.toLowerCase().equals("middle"))
           {
               from = middlePole;
           }


           if(poleTo.toLowerCase().equals("left"))
           {
               to = leftPole;
           }
           else if(poleTo.toLowerCase().equals("middle"))
           {
               to = middlePole;
           }
           System.out.println("from disc: " + from.peek());
           if(to.head != null)
           {
               System.out.println("to disc: " + to.peek());
           }
           from.move(to);
           printGame();
      
       }


       System.out.println("Yay, congrats you won!!");
       scan.close();
   }

}


