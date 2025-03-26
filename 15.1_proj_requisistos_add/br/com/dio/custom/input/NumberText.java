package br.com.dio.custom.input;

import br.com.dio.Square;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Font.PLAIN;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import br.com.dio.custom.input.NumberTextLimit;

public class NumberText extends JTextField {
    private final Square square;
    int posicao;

    public NumberText(final Square square, int posicao){
        this.square = square;
        this.posicao = posicao;
        var dimension = new Dimension(50,50);
        this.setSize(dimension);
        this.setPreferredSize(dimension);
        this.setVisible(true);
        this.setFont(new Font("Arial", PLAIN, 20));
        this.setHorizontalAlignment(CENTER);
        this.setDocument(new NumberTextLimit());
        this.setEnabled(!square.getSquareFixoPos(posicao));

        if(square.getSquareFixoPos(posicao)){
            this.setText(square.getSquarePos(posicao).toString());
        }
        this.getDocument().addDocumentListener(new DocumentListener() {
            private void changeSpace(){
                if(getText().isEmpty()){
                    square.setSquarePos(posicao, null);
                    return;
                }
                square.setSquarePos(posicao, Integer.parseInt(getText()));
            }
            
            @Override
            private void insertUpdate(final DocumentEvent e){
                changeSpace();
            }

            @Override
            private void removeUpdate(final DocumentEvent e){
                changeSpace();
            }

            @Override
            private void changeUpdate(final DocumentEvent e){
                changeSpace();
            }
        });
    }
}
