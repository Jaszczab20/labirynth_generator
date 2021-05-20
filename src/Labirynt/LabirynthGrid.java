package Labirynt;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Stack;

public class LabirynthGrid {
    Integer size;
    Cell[][] cellist ;
    Cell[][] cellList;
    Cell current;
    Cell next;
    Stack<Cell> stack = new Stack<>();
    JFrame frame2;

    public LabirynthGrid(Integer size) {
        this.size = size;
        frame2 = new JFrame();
        JPanel solve_panel = new JPanel();
        JButton solve = new JButton("Rozwiąż labirynt");
        JButton save = new JButton("Zapisz Labirynt");
        cellist = new Cell[size][size];
        cellList = new Cell[size][size];
        frame2.setSize(800,800);
        this.createCanvas();
        this.current = cellList[0][0];
        kwadrat kw = new kwadrat(size);


        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent l) {
                Container c = frame2.getContentPane();
                BufferedImage im = new BufferedImage(c.getWidth(), c.getHeight(), BufferedImage.TYPE_INT_ARGB);
                c.paint(im.getGraphics());
                try {
                    ImageIO.write(im, "PNG", new File("shot.png"));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        solve_panel.add(save);
        solve_panel.add(solve, BorderLayout.NORTH);


        frame2.add(kw, BorderLayout.CENTER);
        frame2.add(solve_panel, BorderLayout.SOUTH);
        frame2.setLocationRelativeTo(null);

        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame2.setTitle("Generator Labiryntów");
        frame2.setVisible(true);

    }


    public void createExit() {
        cellList[size-1][size-1].walls[1] = false;
    }


    class kwadrat extends JPanel {
        int size;


        public kwadrat(int size) {
            this.size = size;
        }

        public void paintComponent(Graphics g) {
            Integer value = (Integer) 770 / size;
            for (int b = 0; b < size; b++) {
                for (int i = 0; i < size; i++) {

                    if (cellList[i][b].walls[0]) {
                        g.drawPolyline(new int[]{i * value, i * value + value}, new int[]{b * value, b * value}, 2);
                    }
                    if (cellList[i][b].walls[1]) {
                        g.drawPolyline(new int[]{i * value + value, i * value + value}, new int[]{b * value, b * value + value}, 2);
                    }
                    if (cellList[i][b].walls[2]) {
                        g.drawPolyline(new int[]{i * value + value, i * value}, new int[]{b * value + value, b * value + value}, 2);
                    }
                    if (cellList[i][b].walls[3]) {
                        g.drawPolyline(new int[]{i * value, i * value}, new int[]{b * value + value, b * value}, 2);
                    }

                    if (cellList[i][b].visited) {
//                        g.fillRect(i * value, b*value, value, value);
//                        g.clearRect(i * value, b*value, value, value);

                    }
                }
            }
            current.visited = true;
//            g.fillRect(current.row, current.col, value, value);
            next = current.checkNeighbours(cellList);

            if (next != null) {
                next.visited = true;

                stack.push(current);

                removeWalls(current, next);

                current = next;

                SwingUtilities.updateComponentTreeUI(frame2);
            } else if (stack.size() > 0) {

                current = stack.pop();

               System.out.println(stack.size());

               if (stack.size() == 0) {
                   createExit();
               }

             SwingUtilities.updateComponentTreeUI(frame2);
            }

        }

    }

    public void createCanvas() {
        for (int b = 0; b < size; b++) {
            for (int i = 0; i < size; i++) {
                cellList[i][b] = new Cell(i, b);
            }
        }

    }



    public void removeWalls(Cell a, Cell b) {
        int x = a.row - b.row;

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
