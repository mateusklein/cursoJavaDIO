package br.com.dio;

import br.com.dio.ui.MainMenu;

public class Main {
    public static void main(String[] args) {
        try {
            new MainMenu().execute();
        } catch (Exception e) {
            System.out.println("Erro ao executar o menu principal: " + e.getMessage());
            e.printStackTrace();
        }
    }
}