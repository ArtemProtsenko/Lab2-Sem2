import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main
{
    static boolean isNumber(String string)
    {
        return string.matches("^-?\\d+$");
    }

    static int[][] createMatrix(int min, int max, int width, int height)
    {
        int[][] matrix = new int[height][width];

        for(int i = 0; i < height; i++)
        {
            for(int j = 0; j < width; j++)
            {
                matrix[i][j] = ThreadLocalRandom.current().nextInt(min, max + 1);
            }
        }

        return matrix;
    }

    static void printMatrix(int[][] matrix)
    {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.print("\n");
        }
    }

    static int matrixElement(int[][] matrixA, int[][] matrixB, int curX, int curY)
    {
        int elem = 0;

        for(int i = 0; i < matrixB.length; i++)
        {
            elem += (matrixA[curY][i] * matrixB[i][curX]);
        }

        return elem;
    }

    static int maxElemFromCol(int[][] matrix, int curX)
    {
        int maxElem = matrix[0][curX];
        for(int i = 1; i < matrix.length; i++)
        {
            if(maxElem < matrix[i][curX])
            {
                maxElem = matrix[i][curX];
            }
        }

        return maxElem;
    }

    public static void main(String[] args)
    {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("C5 = " + 24 % 5 + ", C = A * B.");
        System.out.println("C7 = " + 24 % 7 + ", elements type - int.");
        System.out.println("C11 = " + 24 % 11 + ", 'Обчислити суму найбільших елементів кожного стовпця матриці'.");

        System.out.print("Enter width of matrix A: ");
        String strWidthA = myScanner.nextLine();

        System.out.print("Enter height of matrix A: ");
        String strHeightA = myScanner.nextLine();

        System.out.print("Enter min of matrix A: ");
        String strMinA = myScanner.nextLine();

        System.out.print("Enter max of matrix A: ");
        String strMaxA = myScanner.nextLine();

        System.out.print("Enter width of matrix B: ");
        String strWidthB = myScanner.nextLine();

        System.out.print("Enter height of matrix B: ");
        String strHeightB = myScanner.nextLine();

        System.out.print("Enter min of matrix B: ");
        String strMinB = myScanner.nextLine();

        System.out.print("Enter max of matrix B: ");
        String strMaxB = myScanner.nextLine();

        if (isNumber(strMinA) && isNumber(strMaxA) && isNumber(strMinB) && isNumber(strMaxB) && isNumber(strWidthA) &&
                isNumber(strHeightA) && isNumber(strWidthB) && isNumber(strHeightB))
        {
            int minA = Integer.parseInt(strMinA);
            int maxA = Integer.parseInt(strMaxA);
            int widthA = Integer.parseInt(strWidthA);
            int heightA = Integer.parseInt(strHeightA);
            int minB = Integer.parseInt(strMinB);
            int maxB = Integer.parseInt(strMaxB);
            int widthB = Integer.parseInt(strWidthB);
            int heightB = Integer.parseInt(strHeightB);

            if(minA > maxA || minB > maxB)
            {
                System.out.println("Error: Impossible range.");
            }
            else if(widthA <= 0 || heightA <= 0 || widthB <= 0 || heightB <= 0)
            {
                System.out.println("Error: Width or height is less than 0.");
            }
            else
            {
                int[][] matrixA = createMatrix(minA, maxA, widthA, heightA);
                int[][] matrixB = createMatrix(minB, maxB, widthB, heightB);
                int[][] matrixC = new int[heightA][widthB];

                System.out.println("Matrix A:");
                printMatrix(matrixA);
                System.out.println("Matrix B:");
                printMatrix(matrixB);

                if(widthA == heightB)
                {
                    for(int i = 0; i < matrixC.length; i++)
                    {
                        for(int j = 0; j < matrixC[i].length; j++)
                        {
                            matrixC[i][j] = matrixElement(matrixA, matrixB, j, i);
                        }
                    }

                    System.out.println("C = A * B");
                    System.out.println("Matrix C:");
                    printMatrix(matrixC);

                    for(int i = 0; i < matrixC.length; i++)
                    {
                        int maxElem = maxElemFromCol(matrixC, i);
                        System.out.println("Max element in column " + (i + 1) + " is: " + maxElem);
                    }
                }
                else
                {
                    System.out.println("Error: Operation 'A * B' is impossible with this matrix.");
                }
            }
        }
        else
        {
            System.out.println("Error: Input is not a number.");
        }

    }
}