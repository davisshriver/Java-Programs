import java.util.Arrays;

public class Maze {
    int rows;
    int f = 0;
    int columns;
    boolean run = true;
    int rpos = 1;
    int cpos = 1;
    DavisStack coordStack = new DavisStack();

    // Default Constructor

    Maze(int row, int col)  {
        rows = row;
        columns = col;
    }

    void Move(int[][] map, String oType)   throws EmptyStackException{

        System.out.println(" ");

        // Checks if entry is blocked
        if(f < 1)    {
            if (map[1][1] == 1)   {
                System.out.println("Entry Blocked!");
                System.exit(0);
            }
            f++;
        }

        int first = 0;

        // Moves until maze or solved or path is blocked
        while(run == true) {


            // Checking for
            if(cpos == (columns - 1))    {
                run = false;
                break;
            }

            map[rpos][cpos] = 3;

            if("S".equals(oType)) {
                // Prints current map
                if(first < 1)   {
                    System.out.println("First Maze");
                    printMaze(map);
                    System.out.println(" ");
                }
            }

            if("V".equals(oType)) {
                // Prints current map
                if(first < 1)   {
                    System.out.println("First Maze");
                }
                printMaze(map);
                System.out.println(" ");
            }

            first++;

            // Check down
            if (map[rpos + 1][cpos] == 0) {
                coordStack.push(rpos);
                coordStack.push(cpos);
                map[rpos][cpos] = 2;

                rpos = rpos + 1;
            }
            // Check Right
            else if (map[rpos][cpos + 1] == 0) {
                coordStack.push(rpos);
                coordStack.push(cpos);
                map[rpos][cpos] = 2;

                cpos = cpos + 1;
            }
            // Check Up
            else if (map[rpos - 1][cpos] == 0) {
                coordStack.push(rpos);
                coordStack.push(cpos);
                map[rpos][cpos] = 2;

                cpos = cpos + 1;

            }
            // Check left
            else if (map[rpos][cpos - 1] == 0) {
                coordStack.push(rpos);
                coordStack.push(cpos);
                map[rpos][cpos] = 2;

                cpos = cpos + 1;

            }
            // Back tracking method and checking for a blocked path
            else    {
                try {
                    map[cpos][rpos] = 3;

                    cpos = (int) coordStack.pop();
                    rpos = (int) coordStack.pop();

                }
                catch(EmptyStackException e)   {
                    System.out.println("No path found!");
                    System.exit(0);
                }
            }

        }
    }
    public void printMaze(int original[][])    {
        char[][] newArr = new char[rows][columns];

        // Copy original values to new array and set the appropriate character
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(original[i][j] == 0)    {
                    newArr[i][j] = '-';
                    continue;
                }
                if(original[i][j] == 1)    {
                    newArr[i][j] = '#';
                    continue;
                }
                if(original[i][j] == 2)    {
                    newArr[i][j] = '.';
                    continue;
                }
                if(original[i][j] == 3)    {
                    newArr[i][j] = '*';
                    continue;
                }
                if(original[i][j] == 8)    {
                    newArr[i][j] = '/';
                    continue;
                }
                if(original[i][j] == 4)    {
                    newArr[i][j] = 'X';
                    continue;
                }
            }
        }
        for (char[] row : newArr) {
            System.out.println(Arrays.toString(row));
        }

    }
}
