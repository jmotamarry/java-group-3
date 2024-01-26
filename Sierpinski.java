import java.util.Scanner;

public class Sierpinski {

    private static char[][] triangle;
    private static final int DEPTH = 1;

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
    }
}