package Labirynt;

public class Cell2 {
    int row;
    int col;
    boolean[] walls = {true, true, true, true};
    boolean visited = false;

    public Cell2(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void setWall(boolean wall, int index) {
        this.walls[index] = wall;
    }
}
