package br.com.dio;
import br.com.dio.custom.frame.MainFrame;
import br.com.dio.custom.panel.MainPanel;
import br.com.dio.custom.mscreen.MainScreen;


import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class UIMain {
    public static void main(String[] args) {
        var mainScrren = new MainScreen();
        mainScrren.buildMainScreen();

    }
}
