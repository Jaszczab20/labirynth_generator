package Labirynt;

import java.util.ArrayList;
import java.util.Random;

public class Cell {
    private int row;
    private int col;
    private boolean[] walls = {true, true, true, true};
    boolean visited = false;
    ArrayList<Cell> neighbours = new ArrayList<>();

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public boolean[] getWalls() {
        return walls;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setWalls(boolean[] walls) {
        this.walls = walls;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
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

    public Cell checkNext(Cell[][] celllist){
        Cell bottom;
        Cell right;

        if (col < celllist.length -1) {
            bottom = celllist[row][col + 1];
//        }else {
//            bottom = celllist[row][col + 1]; //checkNegative(row,col+1, celllist);
//        }
            neighbours.add(bottom);
//            System.out.println("Bottom added");
        }
        if (row < celllist.length - 1) {
            right = celllist[row + 1][col]; //checkNegative(row + 1,col, celllist);
            neighbours.add(right);
//            System.out.println("Right added");
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

}
