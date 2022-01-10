// Class: GameofLife
// Assignment 2, Amazing Life - Part 1
// Davis Shriver
// 10/25/20
// This class contains the countNeighbours and AliveorDead methods

class GameofLife {

    int rows, count, columns;

    GameofLife(int numberofRows, int numberofColumns) {
        rows = numberofRows;
        columns = numberofColumns;
    }

    // Counts neighbors and makes a new array with neighbor count
    public int countNeighbors(int[][] arr, int row, int column) {

        int i = row;
        int j = column;
        count = 0;

        count += arr[i - 1][j - 1];
        count += arr[i][j - 1];
        count += arr[i + 1][j - 1];
        count += arr[i - 1][j];
        count += arr[i + 1][j];
        count += arr[i - 1][j + 1];
        count += arr[i][j + 1];
        count += arr[i + 1][j + 1];

        return count;

    }

    // 1. If a cell is occupied but has no more than one occupied neighbor,then it is empty in the next generation.
    // 2. If a cell is occupied and has four or more occupied neighbors,then it is empty in the next generation.
    // 3. An occupied cell with either two or three occupied neighbors remains occupied in the next generation.
    // 4. An empty cell is occupied in the next generation if it has exactly three occupied neighbors.
    // 5. All changes in occupancy take place at the same time, so a cell that will become empty may influence another cell to become occupied.
    public int AliveorDead(int[][] fGen, int i, int j, int count)   {
        int value = fGen[i][j];

        int num = 0;

        if(value == 1) {
            // 1. If a cell is occupied but has no more than one occupied neighbor,then it is empty in the next generation.
            if (count <= 1) {
                num = 0;
            }
            // 2. If a cell is occupied and has four or more occupied neighbors,then it is empty in the next generation.
            else if (count > 3) {
                num = 0;
            }
            // 3. An occupied cell with either two or three occupied neighbors remains occupied in the next generation.
            else if (count > 1 && count < 4) {
                num = 1;
            }
        }
        // 4. An empty cell is occupied in the next generation if it has exactly three occupied neighbors.
        if(value == 0 && count == 3)   {
            num = 1;
        }
        return num;
    }

}
