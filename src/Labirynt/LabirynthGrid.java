package Labirynt;

import javax.swing.*;
import java.awt.*;

public class LabirynthGrid {
    private JFrame frame;
    Cell[][] cellist;

    public LabirynthGrid(Integer size) {
        frame = new JFrame();
        cellist = new Cell[size][size];
        frame.setSize(800,800);
        frame.add(new kwadrat(size), BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Generator Labiryntów");
        frame.setVisible(true);
    }


    class kwadrat extends JPanel {
        int size;


        public kwadrat(int size) {
            this.size = size;
        }

        public void paintComponent(Graphics g) {
            Integer value = (Integer) 600/size;
            System.out.println(value);
            for (int b = 0; b< size; b++) {
                for (int i = 0; i < size; i++) {
                    cellist[i][b] = new Cell();
//                    g.drawRect(i * value, b*value, value, value);
                    g.drawPolyline(new int[]{i*value,i * value + value,i * value, i*value+value}, new int[]{b*value,b * value, b*value - value, b*value-value}, 4);
                }
            }

        }
    }
}
