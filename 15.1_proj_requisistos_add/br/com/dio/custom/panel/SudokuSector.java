package br.com.dio.custom.panel;
import br.com.dio.custom.input;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import br.com.dio.custom.input.NumberText;

import java.awt.Dimension;
import java.awt.color.black;

public class SudokuSector extends JPanel{
    public SudokuSector(final List<NumberText> textFields){
        var dimension = new Dimension(170,170);
        this.setSize(dimension);
        this.setPreferredSize(dimension);
        this.setBorder(new LineBorder(black, 2, true));
        this.setVisible(true);
        textFields.forEach(this.add);
    }
}
