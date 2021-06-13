package Labirynt;

import java.util.ArrayList;
import java.util.Random;

public class Cell {
    private int row;
    private int col;
    private boolean[] walls = {true, true, true, true};
    boolean visited = false;
    boolean visitedb = false;
    ArrayList<Cell> neighbours = new ArrayList<>();
    ArrayList<Cell> neighbourspath = new ArrayList<>();

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
    public Cell checkWalls(Cell[][] celllist) {
        Cell top = checkNegative(row, col - 1, celllist);

        Cell right = checkNegative(row + 1, col, celllist);

        Cell bottom = checkNegative(row, col + 1, celllist);

        Cell left = checkNegative(row - 1, col, celllist);
        if (top != null && !top.visitedb && celllist[row][col].getWalls()[0] && top.getWalls()[2]) {
            neighbourspath.add(top);
        }

        if (right != null && !right.visitedb && celllist[row][col].getWalls()[1] && right.getWalls()[3]) {
            neighbourspath.add(right);
        }

        if (bottom != null && !bottom.visitedb && celllist[row][col].getWalls()[2] && bottom.getWalls()[0]) {
            neighbourspath.add(bottom);
        }

        if (left != null && !left.visitedb && celllist[row][col].getWalls()[3] && left.getWalls()[1]) {
            neighbourspath.add(left);
        }
        if (neighbourspath.size() > 0) {
            System.out.println(neighbourspath);
            Random random = new Random();
            Cell ret = neighbourspath.get(random.nextInt(neighbourspath.size()));
            neighbourspath.clear();
            //System.out.println(ret.getRow());
            return ret;

        } else {
            return null;
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
            neighbours.add(bottom);
        }

        if (row < celllist.length - 1) {
            right = celllist[row + 1][col];
            neighbours.add(right);
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
