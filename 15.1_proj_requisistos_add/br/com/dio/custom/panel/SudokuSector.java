package br.com.dio.custom.panel;
import br.com.dio.custom.input.NumberText;

import java.util.List;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import br.com.dio.custom.input.NumberText;

import java.awt.Dimension;
import java.awt.Color;

public class SudokuSector extends JPanel{
    public SudokuSector(final List<NumberText> textFields){
        var dimension = new Dimension(170,170);
        this.setSize(dimension);
        this.setPreferredSize(dimension);
        this.setBorder(new LineBorder(Color.BLACK, 2, true));
        this.setVisible(true);
        textFields.forEach(this::add);
    }
}
