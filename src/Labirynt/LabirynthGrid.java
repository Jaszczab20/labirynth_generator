package Labirynt;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Stack;

public class LabirynthGrid {
    Integer size;
    Cell[][] cellist ;
    Cell2[][] cell2list;
    Cell2 current;
    Cell2 next;
    Stack<Cell2> stack = new Stack<>();

    public LabirynthGrid(Integer size) {
        this.size = size;
        JFrame frame2 = new JFrame();
        cellist = new Cell[size][size];
        cell2list = new Cell2[size][size];
        frame2.setSize(800,800);
        this.createCanvas();
        this.current = cell2list[0][0];

        frame2.add(new kwadrat(size), BorderLayout.CENTER);
        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame2.setTitle("Generator Labiryntów");
        frame2.setVisible(true);
    }


    class kwadrat extends JPanel {
        int size;


        public kwadrat(int size) {
            this.size = size;
        }

        public void paintComponent(Graphics g) {
            Integer value = (Integer) 600 / size;
//            System.out.println(value);
            for (int b = 0; b < size; b++) {
                for (int i = 0; i < size; i++) {
//                    System.out.println(cellist[i][b]);
//                    g.drawPolyline(new int[]{i * value, i * value + value, i * value + value, i * value, i * value},
//                            new int[]{b * value, b * value, b * value + value, b * value + value, b * value}, 5);
//                    if (cell2list[i][b].walls[0]) {
//                        g.drawPolyline(new int[]{i * value, i * value + value}, new int[]{b * value, b * value}, 2);
//                    }
//                    if (cell2list[i][b].walls[1]) {
//                        g.drawPolyline(new int[]{i * value + value, i * value + value}, new int[]{b * value, b * value + value}, 2);
//                    }
//                    if (cell2list[i][b].walls[2]) {
//                        g.drawPolyline(new int[]{i * value + value, i * value}, new int[]{b * value + value, b * value + value}, 2);
//                    }
//                    if (cell2list[i][b].walls[3]) {
//                        g.drawPolyline(new int[]{i * value, i * value}, new int[]{b * value + value, b * value}, 2);
//                    }
                    if (cell2list[i][b].walls[0]) {
                        g.drawPolyline(new int[]{i * value, i * value + value}, new int[]{b * value, b * value}, 2);
                    }
                    if (cell2list[i][b].walls[1]) {
                        g.drawPolyline(new int[]{i * value + value, i * value + value}, new int[]{b * value, b * value + value}, 2);
                    }
                    if (cell2list[i][b].walls[2]) {
                        g.drawPolyline(new int[]{i * value + value, i * value}, new int[]{b * value + value, b * value + value}, 2);
                    }
                    if (cell2list[i][b].walls[3]) {
                        g.drawPolyline(new int[]{i * value, i * value}, new int[]{b * value + value, b * value}, 2);
                    }

                    if (cell2list[i][b].visited) {
//                        g.fillRect(i * value, b*value, value, value);
//                        g.clearRect(i * value, b*value, value, value);

                    }
                }
            }
            current.visited = true;
//            g.fillRect(current.row, current.col, value, value);
            next = current.checkNeighbours(cell2list);
            System.out.println(next);
//            if (next == null) {
//                stack.pop();
//            }
            System.out.println("next");
            if (next != null) {
                next.visited = true;

                stack.push(current);
//                for (Cell2 ne: current.neighbours) {
//                    System.out.println(ne.col);
//                    System.out.println(ne.row);
//                }
                System.out.println(current.neighbours);

                removeWalls(current, next);

                current = next;
//                try {
//                    Thread.sleep(300);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                repaint();
//                revalidate();
            } else if (stack.size() > 0) {
                System.out.println("hello");
                System.out.println(stack.size());
                System.out.println(current);

                current = stack.pop();

//                current.printC();
                System.out.println(current);
//                System.out.println(current.row);
//                System.out.println(current.col);
//                stack.removeLast();
               System.out.println(stack.size());
                revalidate();
            }

        }

    }

    public void createCanvas() {
        for (int b = 0; b < size; b++) {
            for (int i = 0; i < size; i++) {
                cellist[i][b] = new Cell();
                cell2list[i][b] = new Cell2(i, b);
            }
        }

    }



    public void removeWalls(Cell2 a, Cell2 b) {
        int x = a.row - b.row;
//        System.out.println("remove");
        if (x == 1) {
            a.walls[3] = false;
            b.walls[1] = false;
        } else if (x == -1) {
            a.walls[1] = false;
            b.walls[3] = false;
        }

        int y = a.col - b.col;
        if (y == 1) {
            a.walls[0] = false;
            b.walls[2] = false;
        } else if (y == -1) {
            a.walls[2] = false;
            b.walls[0] = false;
        }

    }

}
