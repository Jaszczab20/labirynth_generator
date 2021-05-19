package Labirynt;

import java.util.ArrayList;
import java.util.Random;

public class Cell {
    int row;
    int col;
    boolean[] walls = {true, true, true, true};
    boolean visited = false;
    ArrayList<Cell> neighbours = new ArrayList<>();

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void setWall(boolean wall, int index) {
        this.walls[index] = wall;
    }

    public Cell checkNegative (int row, int col, Cell[][] celllist ) {
        if (col < 0 || row  < 0 || col > celllist.length -1 || row > celllist.length - 1) {
            return null;
        } else {
             return celllist[row][col];

        }
    }



    public Cell checkNeighbours(Cell[][] celllist) {


          Cell top = checkNegative(row, col-1, celllist);

          Cell right = checkNegative(row + 1,col, celllist);

          Cell bottom = checkNegative(row,col+1, celllist);

          Cell left = checkNegative(row-1, col, celllist);


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
            Cell ret = neighbours.get(random.nextInt(neighbours.size()));
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
