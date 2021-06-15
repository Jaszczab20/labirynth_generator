package Labirynt;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImagePanel extends JPanel {


        private BufferedImage image;

        public ImagePanel(String path) {
            try {
                image = ImageIO.read(new File(path));
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 30, 30, this);
        }

    @Override
    public void setBackground(Color bg) {
        super.setBackground(bg);
    }
}
