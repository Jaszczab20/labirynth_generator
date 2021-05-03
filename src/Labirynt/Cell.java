package Labirynt;

public class Cell {
    private boolean visited = false;
    private boolean[] walls = {true, true, true, true};

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean[] getWalls() {
        return walls;
    }

    public void setWalls(boolean[] walls) {
        this.walls = walls;
    }
}
