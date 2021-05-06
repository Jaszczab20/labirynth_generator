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

    public void printC() {
        System.out.println("coords");
        System.out.println(row);
        System.out.println(col);
    }



    public Cell2 checkNeighbours(Cell2[][] celllist) {

//        Cell2 top = celllist[row][col - 1];
          Cell2 top = checkNegative(row, col-1, celllist);
//        Cell2 right = celllist[row + 1][col];
          Cell2 right = checkNegative(row + 1,col, celllist);
//        Cell2 bottom = celllist[row][col + 1];
          Cell2 bottom = checkNegative(row,col+1, celllist);
//        Cell2 left = celllist[row - 1][col];
          Cell2 left = checkNegative(row-1, col, celllist);
//            System.out.println(celllist.length);
//            this.checkNegative(row, col, celllist);

        if (top != null && !top.visited) {
//            System.out.println("hello");
            neighbours.add(top);
        }

        if (right != null && !right.visited) {
            neighbours.add(right);
//            System.out.println("hello");
        }

        if (bottom != null && !bottom.visited) {
            neighbours.add(bottom);
//            System.out.println("hello");
        }

        if (left != null && !left.visited) {
            neighbours.add(left);
//            System.out.println("hello");
        }

        if (neighbours.size() > 0) {
//            System.out.println(neighbours.size());
            Random random = new Random();
            return neighbours.get(random.nextInt(neighbours.size()));
        } else {
            System.out.println("NO");
            return null;
        }



    }

}
