package br.com.dio.custom.frame;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JFrame;

import java.awt.Dimension;

public class MainFrame extends JFrame{
    public MainFrame(final Dimension dimension, final JPanel mainPanel){
        super("Sudoku");
        this.setSize(dimension);
        this.setPreferredSize(dimension);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.add(mainPanel);
    }
}
