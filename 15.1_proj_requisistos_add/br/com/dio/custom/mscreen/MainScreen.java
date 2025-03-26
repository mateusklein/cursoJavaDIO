package br.com.dio.custom.mscreen;

import br.com.dio.custom.button.*;
import br.com.dio.Game;
import br.com.dio.custom.panel.MainPanel;
import br.com.dio.custom.frame.MainFrame;

import java.util.*;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class MainScreen {
    private final static Dimension dimension = new Dimension(600,600);

    private final Game game;

    private JButton finishGameButton;
    private JButton checkGameStaButton;
    private JButton resetButton;

    

    public MainScreen(){
        this.game = new Game();
        game.iniciarGame();
        gerGame();
    }


    public void gerGame(){
        Random random = new Random();
        Set<String> numerosGerados = new HashSet<>();
        List<int[]> valoresGerados = new ArrayList<>();

        int qtd = random.nextInt(38) + 1; // Gera um número entre 1 e 38

        while (valoresGerados.size() < qtd) { 
            int num = random.nextInt(9) + 1; //Gera numero entre 1 e 9
            int numHorizontal = random.nextInt(9); // Gera entre 0 e 8
            int numVertical = random.nextInt(9); //Gera entre 0 e 8
            String chave = num + "," + numVertical + "," + numHorizontal;

            if (!numerosGerados.contains(chave)) { 
                numerosGerados.add(chave);
                valoresGerados.add(new int[]{num, numVertical, numHorizontal});
            }
        }

        for (int[] valores : valoresGerados) {
            game.colocarFixo(valores[0], valores[1], valores[2]);
        }
    }

    public void buildMainScreen(){
        JPanel mainPanel = new MainPanel(dimension);
        JFrame mainFrame = new MainFrame(dimension, mainPanel);
        addResetButton(mainPanel);
        addShowGameStatusButton(mainPanel);
        addFinishGameButton(mainPanel);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    private void addResetButton(final JPanel mainPanel){
        JButton resetButton = new ResetButton(e -> {
            var dialogResult = JOptionPane.showConfirmDialog(null,
            "Deseja realmente reiniciar o jogo?",
            "Limpar o jogo", 
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
            if(dialogResult==0){
                game.limpar();
            }
        });
        
        mainPanel.add(resetButton);
    }

    private void addShowGameStatusButton(final JPanel mainPanel){
        JButton checkGameStaButton = new CheckGameStatusButton(e->{
            var hasErros = game.verErros();
            var gameStatus = game.getStatus();
            var message = switch(gameStatus){
                case "Não iniciado" -> "O jogo não foi iniciado";
                case "Iniciado, sem erros" -> "Jogo iniciado porém sem erros";
                case "Completo, sem erros" -> "Jogo está completo, sem erros";
                case "Incompleto, com erros" -> "Jogo está incompleto com erros";
                case "Incompleto, sem erros" -> "Jogo está incompleto sem erros";
                case "Completo, com erros" -> "Jogo está completo com erros";
                default -> "Status desconhecido";
            };
            JOptionPane.showMessageDialog(null, message);
        });
        mainPanel.add(checkGameStaButton);
    }

    private void addFinishGameButton(final JPanel mainPanel) {
        finishGameButton = new FinishGameButton(e -> { 
            if (game.finishGame()) {
                JOptionPane.showMessageDialog(null, "Parabéns, você concluiu o jogo");
                resetButton.setEnabled(false);
                checkGameStaButton.setEnabled(false);
                finishGameButton.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(null, "Seu jogo tem alguma inconsistência, ajuste e tente novamente");
            }
        });
    
        mainPanel.add(finishGameButton);
    }
}
