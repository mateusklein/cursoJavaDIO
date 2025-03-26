package br.com.dio;
import java.util.*;

public class Square {
    public static final  int MAX_NUM = 9;
    public List<Integer> square = new ArrayList<>();
    public List<Boolean> squareFixo = new ArrayList<>();

    public Square() {
        //CRIANDO UMA LISTA COM 9 POSICOES
        for (int i = 0; i < MAX_NUM; i++) {
            square.add(null);
            squareFixo.add(false);
        }
    }

    public static int getMaxNum() {
        return MAX_NUM;
    }


    public List<Integer> getSquare() {
        return square;
    }


    public void setSquare(List<Integer> square) {
        if (square.size() == MAX_NUM) {
            this.square = square;
        } else {
            throw new IllegalArgumentException("A lista deve ter exatamente " + MAX_NUM + " elementos.");
        }
    }


    public Integer getSquarePos(int i) {
        if(i>=0 && i<MAX_NUM){
            return square.get(i);
        }else{
            throw new IndexOutOfBoundsException("Índice fora dos limites permitidos.");
        }
    }


    public void setSquarePos(int i, Integer num) {
        if(i>=0 && i<MAX_NUM){
            square.set(i, num);
        }else{
            throw new IndexOutOfBoundsException("Índice fora dos limites permitidos.");
        }
    }


    public List<Boolean> getSquareFixo() {
        return squareFixo;
    }


    public void setSquareFixo(List<Boolean> squareFixo) {
        if (squareFixo.size() == MAX_NUM) {
            this.squareFixo = squareFixo;
        } else {
            throw new IllegalArgumentException("A lista deve ter exatamente " + MAX_NUM + " elementos.");
        }
    }

    public Boolean getSquareFixoPos(int i) {
        if(i>=0 && i<MAX_NUM){
            return squareFixo.get(i);
        }else{
            throw new IndexOutOfBoundsException("Índice fora dos limites permitidos.");
        }
    }

    public void setSquareFixoPos(int i, Boolean num) {
        if(i>=0 && i<MAX_NUM){
            squareFixo.set(i, num);
        }else{
            throw new IndexOutOfBoundsException("Índice fora dos limites permitidos.");
        }
    }


    //FUNÇÃO PARA VERIFICAR SE HÁ UM ERRO NO SQUARE (NUMEROS REPETIDOS)
    public Boolean verErro(){
        for(int i=0; i<MAX_NUM-1; i++){
            Integer num = square.get(i);
            if(num != null && square.contains(num)){
                return true;
            }
        }
        return false;
    }


    //FUNÇÃO QUE VERIFICA SE HÁ VAZIO DENTRO DO SQUARE
    public Boolean verVazio(){
        if(square.contains(null)){
            return true;
        }
        return false;
    }


    
}
