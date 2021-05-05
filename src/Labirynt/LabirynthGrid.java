package Labirynt;

import javax.swing.*;
import java.awt.*;

public class LabirynthGrid {
    private JFrame frame;
    Integer size;
    Cell[][] cellist ;
    Cell2[][] cell2list;
    Cell2 current;
    Cell2 next;

    public LabirynthGrid(Integer size) {
        this.size = size;
        frame = new JFrame();
        cellist = new Cell[size][size];
        cell2list = new Cell2[size][size];
        frame.setSize(800,800);
        this.createCanvas();
        this.current = cell2list[0][0];
        current.visited = true;
        next = current.checkNeighbours(cell2list);
        if (next != null) {
            next.visited = true;
            current = next;
        }
        frame.add(new kwadrat(size), BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Generator Labiryntów");
        frame.setVisible(true);
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
                        g.fillRect(i * value, b*value, value, value);

                    }
                }
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

}
