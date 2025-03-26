package br.com.dio.service;
import java.util.*;


public class boardService {
    public static final  int MAX_NUM = 9;

    private final Game game;

    public boardService(final Game game){
        iniciarGame(game);
    }

    public Square getSquare(){
        return this.game.getSquares();
    }

    public void reset(){
        this.game.limpar();
    }

    public Boolean hasErro(){
        this.game.verErros();
    }

    public String getStatus(){
        return game.getStatus();
    }

    public Boolean isFinished(){
        return game.finishGame();
    }


    //INICIA O GAME COM OS 9 SQUARES E SEM ERROS
    public void iniciarGame(Game game){
        game.squares.clear();
        //CRIANDO UMA LISTA COM 9 QUADRADOS
        for (int i = 0; i < MAX_NUM; i++) {
            game.squares.add(new Square());
        }
        game.status = "Iniciado, sem erros";
    }


}
