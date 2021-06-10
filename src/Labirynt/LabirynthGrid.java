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
    private Integer size;
    private Cell[][] cellList;
    private Cell current;
    private Cell next;
    private Stack<Cell> stack = new Stack<>();
    private JFrame frame2;
    private Integer level;
    private int easyCol = 0;
    private int easyRow = 0;

    public LabirynthGrid(Integer size, Integer level) {
        this.size = size;
        this.level = level;
        frame2 = new JFrame();
        JPanel solve_panel = new JPanel();
        JButton solve = new JButton("Rozwiąż labirynt");
        JButton save = new JButton("Zapisz Labirynt");
        cellList = new Cell[size][size];
        frame2.setSize(800,800);


        createCanvas(size, cellList);


        this.current = cellList[0][0];
        kwadrat kw = new kwadrat(size);


        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent l) {
                Container c = frame2.getContentPane();
                ImageSave(c);
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

    public Cell[][] getCellList() {
        return cellList;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public void createExit() {
        cellList[size-1][size-1].getWalls()[1] = false;
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

                    if (cellList[i][b].getWalls()[0]) {
                        g.drawPolyline(new int[]{i * value, i * value + value}, new int[]{b * value, b * value}, 2);
                    }
                    if (cellList[i][b].getWalls()[1]) {
                        g.drawPolyline(new int[]{i * value + value, i * value + value}, new int[]{b * value, b * value + value}, 2);
                    }
                    if (cellList[i][b].getWalls()[2]) {
                        g.drawPolyline(new int[]{i * value + value, i * value}, new int[]{b * value + value, b * value + value}, 2);
                    }
                    if (cellList[i][b].getWalls()[3]) {
                        g.drawPolyline(new int[]{i * value, i * value}, new int[]{b * value + value, b * value}, 2);
                    }

//                    if (cellList[i][b].visited) {
//                        g.fillRect(i * value, b*value, value, value);
//                        g.clearRect(i * value, b*value, value, value);

//                    }
                }
            }
            chooseLevel();

        }

    }

    public void createCanvas(Integer size, Cell[][] cells) {
        for (int b = 0; b < size; b++) {
            for (int i = 0; i < size; i++) {
                cells[i][b] = new Cell(i, b);
            }
        }

    }



    public void removeWalls(Cell a, Cell b) {
        int x = a.getRow() - b.getRow();

        if (x == 1) {
            a.setWall(false, 3);
            b.setWall(false, 1);
        } else if (x == -1) {
            a.setWall(false, 1);
            b.setWall(false, 3);
        }

        int y = a.getCol() - b.getCol();
        if (y == 1) {
            a.setWall(false, 0);
            b.setWall(false, 2);
        } else if (y == -1) {
            a.setWall(false, 2);
            b.setWall(false, 0);
        }

    }


    public void ImageSave(Container c) {
        BufferedImage im = new BufferedImage(c.getWidth(), c.getHeight(), BufferedImage.TYPE_INT_ARGB);
        c.paint(im.getGraphics());
        try {
            ImageIO.write(im, "PNG", new File("shot.bmp"));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void chooseLevel(){
        if (level == 0){
//            System.out.println("Easy");
            algorithmLogicEasy();
        }else if (level == 1){
//            System.out.println("Hard");
            algorithmLogicHard();
        }
    }

    public void algorithmLogicEasy () {
        next = current.checkNext(cellList);
        if (next != null) {

            current = cellList[easyRow][easyCol];
            next = current.checkNext(cellList);
//            System.out.println(easyRow + " " + easyCol);
            if (next != null) {
                removeWalls(current, next);
            }

            SwingUtilities.updateComponentTreeUI(frame2);
            easyRow++;

            if (easyRow >= size) {
                easyCol++;
                easyRow = 0;
            }

            createExit();
        }
    }

    public void algorithmLogicHard () {
//        current = cellList[0][0];
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
