/**
 * The objective of our program is to draw a Sierpinski's Triangle with a predetermined depth but customizable length, using recursion. 
 * @author Jay Motamarry 
 * @author Vanshika Sharma
 * @since  Jan 30th, 2024
 * 
 * Static variables used: 
 * char[][] triangle - to draw the triangle 
 * int depth - to determine the number of iterations of the recursive method.
 * 
 * Helper Method 'drawHorizontalLine' takes in three ints as its parameters to draw a horizontal line
 * @param row    an int that gives the value of the row of the triangle where a horizontal line should be drawn.
 * @param col    an int that gives the value of the column of the triangle where a horizontal line should be drawn.
 * @param length an int that gives the value of the length of the horizontal line. 
 * @return void  it changes the static variable 'triangle' and makes a horizontal line of '*' as required.
 * 
 * Helper Method 'makeTriangle' makes a triangle using the 'drawHorizontalLine' method.
 * @param   sc    a Scanner, to be able to get the input of the length of the triangle from the user.
 * @return  void  it changes the static variable 'triangle' and makes a triangle with '*' as required.\
 * 
 * Helper Method 'printTriangle' prints out the triangle to the user as an output.
 * @return void   displays an image of a triangle to the user in the console/terminal/output area. 
 * 
 * Recursive method 'makeSierpinski' edits the static variable 'triangle' to make a Sierpinski's triangle, using recursion.
 * @param depth         an int that determines the iterations of the Sierpinski's triangle.
 * @param sideLength    an int that determines the length of the inner triangles.
 * @param botLeftRow    an int that determines the start row of drawing the recursive, inner triangles.
 * @param botLeftCol    an int that determines the start column of drawing the recursive, inner triangles.
 * @return boolean       the method returns a boolean to determine when the Sierpinski triangle is finished.
 * */



import java.util.Scanner;

public class Sierpinski {
    
    private static char[][] triangle;
    private static final int DEPTH = 3;

    public static void drawHorizontalLine(int row, int col, int length) {
        for (int i = 0; i < length; i+=2) {
            triangle[row - 1][col + i] = '*';
        }
    }

    public static void makeTriangle(Scanner sc) {
        int side;

        System.out.print("Input a side length for the triangle (should be even): ");
        side = Integer.parseInt(sc.nextLine());

        triangle = new char[side][side * 2 - 1];

        for (int row = 0; row < side; row++) {
            for (int col = 0; col < (side * 2 - 1); col++) {
                triangle[row][col] = ' ';
            }
        }

        for (int row = 0; row < side; row++) {
            triangle[row][(side * 2 - 1) / 2 + row] = '*';
            triangle[row][(side * 2 - 1) / 2 - row] = '*';
        }

        drawHorizontalLine(triangle.length, 0, triangle[0].length);
    }

    public static void printTriangle() {
        for (int row = 0; row < triangle.length; row++) {
            for (int col = 0; col < triangle[0].length; col++) {
                System.out.print(triangle[row][col] + " ");
            }
            System.out.println("");
        }
    }

    public static boolean makeSierpinski(int depth, int sideLength, int botLeftRow, int botLeftCol) {
        sideLength /= 2;

        for (int i = 0; i < sideLength; i++) {
            triangle[botLeftRow - i - 1][botLeftCol + sideLength * 2 + i] = '*';
            triangle[botLeftRow - i - 1][botLeftCol + sideLength * 2 - 2 - i] = '*';
        }

        drawHorizontalLine(botLeftRow - sideLength, botLeftCol + sideLength, sideLength * 2);

        if (depth == DEPTH) {
            return true;
        }

        makeSierpinski(depth + 1, sideLength, botLeftRow, botLeftCol);
        makeSierpinski(depth + 1, sideLength, botLeftRow, botLeftCol + sideLength * 2);
        return makeSierpinski(depth + 1, sideLength, botLeftRow - sideLength, botLeftCol + sideLength);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        makeTriangle(sc);
        makeSierpinski(0, triangle.length, triangle.length, 0);
        printTriangle();

        sc.close(); 
    }
}