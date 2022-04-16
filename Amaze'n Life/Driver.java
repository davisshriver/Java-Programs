// Class: AmazingLife
// Assignment 2, Amazing Life - Part 2
// Davis Shriver
// 11/5/20
// The program receives input from the user that is read into an array and ran through Conway's Game of Life.
// The user picks how many generations are computed and how big they are.
// The user can pick "Silent" if they only wish to see the first and last generations and final maze.
// or "Verbose" if they wish to see all the generations and maze steps.

import java.util.*;

public class Driver  {


    public static void main(String[] args) throws EmptyStackException {
        String outputType;
        String temp;
        char tempChar;

        int numberofRows, numberofColumns;
        int numberofGenerations = 0;
        int genCounter;
        int[][] firstGen;
        int[][] currentGen;
        int[][] printArray;
        int[][] printFirst;

        Scanner input = new Scanner(System.in);

        // Welcome message and input for output type, array size, and amount of generations
        System.out.println("Welcome to Amazing Life - Part 2!");
        System.out.print("Silent (S) or Verbose (V) input?: ");

        outputType = input.next();

        System.out.print("How many generations should be simulated?: ");
        numberofGenerations = input.nextInt();

        System.out.println("What are the dimensions of the world?");
        System.out.print("Rows: ");
        numberofRows = input.nextInt();


        System.out.print("Columns: ");
        numberofColumns = input.nextInt();


        // Creation of Game of Life object and Arrays
        GameofLife gol = new GameofLife(numberofRows, numberofColumns);

        firstGen = new int[numberofRows + 2][numberofColumns + 2];
        currentGen = new int[numberofRows + 2][numberofColumns + 2];
        printArray = new int[numberofRows][numberofColumns];
        printFirst = new int[numberofRows][numberofColumns];
        int mRows = numberofRows + 2;
        int mCol = numberofColumns + 2;

        // Reading in the numbers, changing them to integers, and reading them into FirstGen Array.
        for(int i = 1; i <= numberofRows; i++)    {
            System.out.print("Line " + i + " of the board: ");
            temp = input.next();

            int h = 0;
            for(int j = 1; j <= numberofColumns; j++)    {

                tempChar = temp.charAt(h);

                firstGen[i][j] = Integer.parseInt(String.valueOf(tempChar));
                h++;
            }
        }
        System.out.println(" ");

        // Copies firstGen to currentGen
        for(int i = 0; i < numberofRows; i++)    {
            for(int j = 0; j < numberofColumns; j++)  {
                currentGen[i][j] = firstGen[i][j];
            }
        }

        // Copies firstGen to printFirst
        int h = 1;
        for(int i = 0; i < (numberofRows); i++) {

            int k = 1;
            for(int j = 0; j < (numberofColumns); j++)  {
                printFirst[i][j] = firstGen[h][k];
                k++;
            }
            h++;
        }

        // Counts cells neighbors and returns alive or dead (0 or 1) to replace current element;
        for(genCounter = 0; genCounter < numberofGenerations; genCounter++) {

            if(genCounter == 0) {
                System.out.println("First Generation");
                for (int[] row : printFirst) {
                    System.out.println(Arrays.toString(row));
                }
                System.out.println(" ");
            }

            for (int i = 1; i < numberofRows; i++) {
                for (int j = 1; j < numberofColumns; j++) {
                    int nCount = gol.countNeighbors(firstGen, i, j);
                    currentGen[i][j] = gol.AliveorDead(firstGen, i, j, nCount);
                }
            }

            // Copying new array to CurrentGen
            for (int k = 0; k < numberofRows; k++) {
                for (int l = 0; l < numberofColumns; l++) {
                    firstGen[k][l] = currentGen[k][l];
                }
            }

            if ("V".equals(outputType) && genCounter != 17) {
                for (int[] row : currentGen) {
                    System.out.println(Arrays.toString(row));
                }
                System.out.println(" ");
            }
        }

        // Copies currentArray to printArray (Which is the proper size)
        h = 1;
        for(int i = 0; i < numberofRows; i++)    {

            int k = 1;
            for(int j = 0; j < numberofColumns; j++)  {
                printArray[i][j] = currentGen[h][k];
                k++;
            }
            h++;
        }

        // Output

        System.out.println("Final Generation");
        for (int[] row : printArray) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println(" ");

        Maze myMaze = new Maze(mRows, mCol);
        encompass(currentGen, mRows, mCol);
        myMaze.Move(currentGen, outputType);

        System.out.println("Solved Maze");

        int printMaze[][] = new int[numberofRows][numberofColumns];

        // Copying currentGen to printMaze

        h = 1;
        for(int i = 0; i < numberofRows; i++)    {
            int k = 1;
            for(int j = 0; j < numberofColumns; j++)  {
                printMaze[i][j] = currentGen[h][k];
                k++;
            }
            h++;
        }

        // Final Maze
        myMaze.printMaze(currentGen);
//        for (int[] row : printMaze) {
//            System.out.println(Arrays.toString(row));
//        }
        System.out.println(" ");

        System.out.println("- represents an open space.");
        System.out.println("# represents a wall.");
        System.out.println("* represents the current position.");
        System.out.println("X represents a blocked off area that was backtracked.");
        System.out.println("/ represents an added border.");

    }

    // Method to encompass the array with a border of 8s
    static void encompass(int arr[][], int erows, int ecolumns)    {
        for (int i = 0; i < erows; i++) {
            arr[i][0] = 8;
            arr[i][ecolumns - 1] = 8;
        }
        for (int i = 0; i < ecolumns; i++) {
            arr[0][i] = 8;
            arr[erows - 1][i] = 8;
        }
    }

}
