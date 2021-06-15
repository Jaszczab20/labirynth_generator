package Labirynt;

//import net.miginfocom.swt.MigLayout;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GUI {
    private JFrame frame;
    private JPanel panel;
    private String[] diff_levels = {"Łatwy", "Trudny"};
    JFileChooser j;
    ImagePanel imgPan;



    public GUI () {
        frame = new JFrame();
        panel = new JPanel();
        rightBox pan = new rightBox();
        pan.configure();

        frame.setSize(850,800);

        panel.setSize(new Dimension(300, 300));
        frame.add(pan , BorderLayout.EAST);

        JLabel title = new JLabel("Generator Labiryntów");

        title.setPreferredSize(new Dimension(2,100));
        title.setFont(new Font("Verdana", Font.PLAIN, 22));
        frame.add(title,BorderLayout.NORTH);
        imgPan = new ImagePanel(System.getProperty("user.dir") + File.separator + "labiryntpng.png");
        imgPan.setSize(30, 30);
        frame.add(imgPan,BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Generator Labiryntów");
        frame.setVisible(true);

    }


    private class rightBox extends JPanel    {
        public Integer size_value = 40;
        public String selected_level;



        public void configure() {
            setSize(new Dimension(300, 300));
            setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();


            SpinnerModel model =
                    new SpinnerNumberModel(40, //initial value
                            0, //min
                            100, //max
                            10);                //step


            JLabel size = new JLabel("Wymiary");

            JLabel diff_level = new JLabel("Poziom Trudności");

            JButton load_labirynth = new JButton("Wczytaj labirynt");
            load_labirynth.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    File f = new File(System.getProperty("user.dir"));
                    j = new JFileChooser(f, FileSystemView.getFileSystemView());
                    int r = j.showOpenDialog(null);
                    if (r == JFileChooser.APPROVE_OPTION) {
                        Frame fr = new JFrame();
                        String path = j.getSelectedFile().getAbsolutePath();
                        fr.add(new ImagePanel(path));
                        fr.setSize(1000,1000);
                        fr.setVisible(true);
                    }
                }
            });

            JSpinner input_size = new JSpinner(model);
            input_size.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    size_value = (Integer) input_size.getValue();
                }
            });


            JComboBox levels_list = new JComboBox(diff_levels);
            levels_list.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    selected_level = diff_levels[levels_list.getSelectedIndex()];
                }
            });

            JButton button = new JButton("Generuj Labirynt");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent h) {
                    int level = levels_list.getSelectedIndex();
                    LabirynthGrid b = new LabirynthGrid(size_value, level);
                }
            });


            c.insets = new Insets(5,5,5,5);
            c.gridy = 0    ;
            c.gridx = 0;
            add(size,c);
            c.gridy = 1;
            c.gridx = 0;
            add(diff_level, c);
            c.gridy = 0;
            c.gridx=1;
            add(input_size, c);
            c.gridy = 1;
            c.gridx = 1;
            add(levels_list, c);
            c.gridy = 2;
            c.gridx = 0;
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridwidth = 2;

            add(load_labirynth, c);
            c.gridy = 3;
            c.gridx = 0;
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridwidth = 2;
            c.ipady = 40;
            c.insets = new Insets(70,5,5,5);
            add(button, c);
        }




    }



        public static void main(String[] args) {

        SwingUtilities.invokeLater(
                () -> {GUI g = new GUI();}
        );

    }
}



