package Labirynt;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GUI {
    private JFrame frame;
    private JPanel panel;
    private BorderLayout layout;
    public GUI () {
        layout = new BorderLayout();
        frame = new JFrame();
        panel = new JPanel();
        frame.setSize(800,800);
//        frame.add(panel);
//        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
//        panel.setLayout(new BorderLayout(20,20));
//        frame.add(new JButton("CLIck"));
//        layout.addLayoutComponent(new JButton("eghre"), BorderLayout.NORTH);
//        panel.setBackground(Color.BLACK);
//        panel.setLayout(layout);
        frame.add(panel);
        JLabel title=new JLabel("Generator Labiryntów", SwingConstants.CENTER);
        title.setPreferredSize(new Dimension(2,100));
        title.setFont(new Font("Verdana", Font.PLAIN, 22));
        JButton b2=new JButton("SOUTH");;
        JButton b3=new JButton("EAST");;
        JButton b4=new JButton("WEST");;
        JButton b5=new JButton("CENTER");;

        frame.add(title,BorderLayout.NORTH);
        frame.add(b2,BorderLayout.SOUTH);
        frame.add(new JButton("Generuj Labirynt"),BorderLayout.EAST);
        ImagePanel imgPan = new ImagePanel(System.getProperty("user.dir") + File.separator + "labiryntpng.png");
        imgPan.setBackground(Color.BLUE);
        imgPan.setSize(30, 30);
        frame.add(imgPan,BorderLayout.CENTER);
//        frame.add(b5,BorderLayout.CENTER);


        panel.add(new JButton("Generuj Labirynt"));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Generator Labiryntów");
//        frame.pack();
        frame.setVisible(true);

    }






        public static void main(String[] args) {
        GUI g = new GUI();
    }
}



