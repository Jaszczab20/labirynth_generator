package Labirynt;

import java.util.ArrayList;
import java.util.Random;

public class Cell2 {
    int row;
    int col;
    boolean[] walls = {true, true, true, true};
    boolean visited = false;
    ArrayList<Cell2> neighbours = new ArrayList<>();

    public Cell2(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void setWall(boolean wall, int index) {
        this.walls[index] = wall;
    }

    public Cell2 checkNegative (int row, int col,Cell2[][] celllist ) {
        if (col < 0 || row  < 0 || col > celllist.length -1 || row > celllist.length - 1) {
            return null;
        } else {
             return celllist[row][col];

        }
    }



    public Cell2 checkNeighbours(Cell2[][] celllist) {


          Cell2 top = checkNegative(row, col-1, celllist);

          Cell2 right = checkNegative(row + 1,col, celllist);

          Cell2 bottom = checkNegative(row,col+1, celllist);

          Cell2 left = checkNegative(row-1, col, celllist);


        if (top != null && !top.visited) {
            neighbours.add(top);
        }

        if (right != null && !right.visited) {
            neighbours.add(right);
        }

        if (bottom != null && !bottom.visited) {
            neighbours.add(bottom);
        }

        if (left != null && !left.visited) {
            neighbours.add(left);
        }

        if (neighbours.size() > 0) {
            Random random = new Random();
            Cell2 ret = neighbours.get(random.nextInt(neighbours.size()));
            neighbours.clear();
            return ret;
        } else {
            return null;
        }



    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
