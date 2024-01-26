import java.util.Scanner;

public class Sierpinski {

    private static char[][] triangle;

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

        for (int i = 0; i < (side * 2) - 1; i+=2) {
            triangle[side - 1][i] = '*';
        }
    }

    public static void printTriangle() {
        for (int row = 0; row < triangle.length; row++) {
            for (int col = 0; col < triangle[0].length; col++) {
                System.out.print(triangle[row][col] + " ");
            }
            System.out.println("");
        }
    }

    public static void makeSierpinski() {
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        makeTriangle(sc);
        printTriangle();
    }
}