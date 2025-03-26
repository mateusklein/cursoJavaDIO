package br.com.dio.custom.panel;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Dimension;

public class MainPanel extends JPanel{
    public MainPanel(final Dimension dimension){
        this.setSize(dimension);
        this.setPreferredSize(dimension);
    }
}
