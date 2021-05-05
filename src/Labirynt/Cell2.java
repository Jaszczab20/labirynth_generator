package Labirynt;

import java.util.ArrayList;
import java.util.Random;

public class Cell2 {
    int row;
    int col;
    boolean[] walls = {true, true, true, true};
    boolean visited = false;
    ArrayList<Cell2> neighbours;

    public Cell2(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void setWall(boolean wall, int index) {
        this.walls[index] = wall;
    }

    public Cell2 checkNegative (int row, int col,Cell2[][] celllist ) {
        if (col -1 < 0 || row - 1 < 0 || col+1> celllist.length || row-1 > celllist.length) {
            System.out.println("ALARM");
        } else {
            Cell2 top = celllist[row][col - 1];
            Cell2 right = celllist[row + 1][col];
            Cell2 bottom = celllist[row][col + 1];
            Cell2 left = celllist[row - 1][col];
        }
    }

    public Cell2 checkNeighbours(Cell2[][] celllist) {

//        Cell2 top = celllist[row][col - 1];
//        Cell2 right = celllist[row + 1][col];
//        Cell2 bottom = celllist[row][col + 1];
//        Cell2 left = celllist[row - 1][col];
            System.out.println(celllist.length);
            this.checkNegative(row, col, celllist);

            return new Cell2(0,0);
//        if (!top.visited && top != null) {
//            neighbours.add(top);
//        }
//
//        if (!right.visited && right != null) {
//            neighbours.add(right);
//        }
//
//        if (!bottom.visited && bottom != null) {
//            neighbours.add(bottom);
//        }
//
//        if (!left.visited && left != null) {
//            neighbours.add(left);
//        }
//
//        if (neighbours.size() > 0) {
//            Random random = new Random();
//            return neighbours.get(random.nextInt(neighbours.size()));
//        } else return null;



    }

}
