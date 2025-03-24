import java.util.ArrayList;
import java.util.List;

public class Game {
    public static final int MAX_NUM = 9;
    public List<Square> squares = new ArrayList<>();

    public Game() {
        //CRIANDO UMA LISTA COM 9 QUADRADOS
        for (int i = 0; i < MAX_NUM; i++) {
            squares.add(new Square());
        }
    }

    public void printarGame() {
        System.out.println("-------------------------");
        for (int linhaQuadrado = 0; linhaQuadrado < 3; linhaQuadrado++) {
            for (int linha = 0; linha < 3; linha++) {
                System.out.print("| ");
                for (int colunaQuadrado = 0; colunaQuadrado < 3; colunaQuadrado++) {
                    int quadradoIndex = linhaQuadrado * 3 + colunaQuadrado; 
                    for (int coluna = 0; coluna < 3; coluna++) {
                        int posicaoIndex = linha * 3 + coluna;
                        System.out.print(squares.get(quadradoIndex).getPosList(posicaoIndex) + " ");
                    }
                    System.out.print("| ");
                }
                System.out.println();
            }
            System.out.println("-------------------------");
        }
    }


    public void printarGameFixo() {
        System.out.println("-------------------------");
        for (int linhaQuadrado = 0; linhaQuadrado < 3; linhaQuadrado++) {
            for (int linha = 0; linha < 3; linha++) {
                System.out.print("| ");
                for (int colunaQuadrado = 0; colunaQuadrado < 3; colunaQuadrado++) {
                    int quadradoIndex = linhaQuadrado * 3 + colunaQuadrado; 
                    for (int coluna = 0; coluna < 3; coluna++) {
                        int posicaoIndex = linha * 3 + coluna;
                        var tf = "";
                        if(squares.get(quadradoIndex).getPosfixoList(posicaoIndex)){
                            tf = "T";
                        }else{
                            tf = "F";
                        }
                        System.out.print(tf + " ");
                    }
                    System.out.print("| ");
                }
                System.out.println();
            }
            System.out.println("-------------------------");
        }
    }


    public void colocarNumero(String num, int vertical, int horizontal){
        int posSquare = (vertical/3) * 3 + (horizontal/3);
        int posInterna = (vertical%3) * 3 + (horizontal%3);
        
        if(squares.get(posSquare).getPosfixoList(posInterna)){
            System.out.println("Não é possível colocar um número na posição passada pois se trata de um fixo");
        }else{
            squares.get(posSquare).setPosList(posInterna, num);
            System.out.println("Número "+ num + " inserido na posição");
        }

    }

    public void colocarFixo(String num, int vertical, int horizontal){
        int posSquare = (vertical/3) * 3 + (horizontal/3);
        int posInterna = (vertical%3) * 3 + (horizontal%3);
    
        squares.get(posSquare).setPosList(posInterna, num);
        squares.get(posSquare).setPosfixoList(posInterna, true);

    }




    public static int getMaxNum() {
        return MAX_NUM;
    }

    public List<Square> getSquares() {
        return squares;
    }


    public Square getSquare(int index) {
        if(index >= 0 && index < MAX_NUM){
            return squares.get(index);
        }else {
            throw new IndexOutOfBoundsException("Índice fora dos limites permitidos.");
        }
    }

    public void setSquares(List<Square> squares) {
        if(squares.size() == MAX_NUM){
            this.squares = squares;
        }else {
            throw new IllegalArgumentException("A lista deve ter exatamente " + MAX_NUM + " elementos.");
        }        
    }
    

}
