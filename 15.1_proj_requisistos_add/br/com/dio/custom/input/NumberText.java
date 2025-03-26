package br.com.dio.custom.input;

import br.com.dio.Square;

import java.awt.Dimension;
import java.awt.Font;
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
        this.setFont(new Font("Arial", Font.PLAIN, 20));
        this.setHorizontalAlignment(CENTER);
        this.setDocument(new NumberTextLimit());
        this.setEnabled(!square.getSquareFixoPos(posicao));

        if(square.getSquareFixoPos(posicao)){
            this.setText(square.getSquarePos(posicao).toString());
        }
        
        // Corrigido: A classe anônima DocumentListener agora implementa corretamente os métodos
        this.getDocument().addDocumentListener(new DocumentListener() {
            private void changeSpace(){
                if(getText().isEmpty()){
                    square.setSquarePos(posicao, null);
                    return;
                }
                square.setSquarePos(posicao, Integer.parseInt(getText()));
            }
            
            @Override
            public void insertUpdate(final DocumentEvent e){  // Mudado de private para public
                changeSpace();
            }

            @Override
            public void removeUpdate(final DocumentEvent e){  // Mudado de private para public
                changeSpace();
            }

            @Override
            public void changedUpdate(final DocumentEvent e){  // Mudado de private para public
                changeSpace();
            }
        });
    }
}
