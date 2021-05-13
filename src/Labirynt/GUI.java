package Labirynt;

//import net.miginfocom.swt.MigLayout;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GUI {
    private JFrame frame;
    private JPanel panel;
//    private String size;
    private BorderLayout layout;
    private String[] diff_levels = {"Trudny", "Sredni","łatwy"};



    public GUI () {
//        layout = new BorderLayout();
        frame = new JFrame();
        panel = new JPanel();
        rightBox pan = new rightBox();
        pan.configure();

        frame.setSize(800,800);

        panel.setSize(new Dimension(300, 300));
        frame.add(pan , BorderLayout.EAST);

        JLabel title = new JLabel("Generator Labiryntów");

        title.setPreferredSize(new Dimension(2,100));
        title.setFont(new Font("Verdana", Font.PLAIN, 22));
        frame.add(title,BorderLayout.NORTH);
//        frame.add(b2,BorderLayout.SOUTH);
//        frame.add(new JButton("Generuj Labirynt"),BorderLayout.EAST);
        ImagePanel imgPan = new ImagePanel(System.getProperty("user.dir") + File.separator + "labiryntpng.png");
//        imgPan.setBackground(Color.BLUE);
        imgPan.setSize(30, 30);
        frame.add(imgPan,BorderLayout.CENTER);
//        frame.add(b5,BorderLayout.CENTER);


//        panel.add(new JButton("Generuj Labirynt"));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Generator Labiryntów");
//        frame.pack();
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


            JButton button = new JButton("Generuj Labirynt");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent h) {
                    LabirynthGrid b = new LabirynthGrid(size_value);

                    System.out.println("tutaj nowe okno z generatorem labiryntów");
                }
            });

            JLabel size = new JLabel("Wymiary");

            JLabel diff_level = new JLabel("Poziom Trudności");

            JButton load_labirynth = new JButton("Wczytaj labirynt");
            load_labirynth.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("tutaj otworzy się ookno z przeglądaniem plików");
                }
            });

            JSpinner input_size = new JSpinner(model);
            input_size.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    size_value = (Integer) input_size.getValue();
                    System.out.println(size_value);
                }
            });


            JComboBox levels_list = new JComboBox(diff_levels);
            levels_list.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
//                    Integer b =;
                    selected_level = diff_levels[levels_list.getSelectedIndex()];
                     System.out.println(selected_level);
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



