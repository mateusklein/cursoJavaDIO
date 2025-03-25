import java.util.ArrayList;
import java.util.List;

import javax.swing.text.StyledEditorKit.BoldAction;

public class Game {
    public static final int MAX_NUM = 9;
    public List<Square> squares = new ArrayList<>();
    public String status;

    public Game(){
        this.status = "Não iniciado";
    }


    //INICIA O GAME COM OS 9 SQUARES E SEM ERROS
    public void iniciarGame(){
        squares.clear();
        //CRIANDO UMA LISTA COM 9 QUADRADOS
        for (int i = 0; i < MAX_NUM; i++) {
            squares.add(new Square());
        }
        status = "Iniciado, sem erros";
    }


    public String getStatus() {
        return status;
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


    //remove todos os números que foram digitados pelo usuário mantendo os fixos
    public void limpar(){
        Square squareAtual;
        for(int i=0; i<MAX_NUM;i++){
            squareAtual = squares.get(i);
            for(int j=0; j<MAX_NUM; j++){
                if(!squareAtual.getSquareFixoPos(j)){
                    squareAtual.setSquarePos(j, " ");
                }
            }
        }
    }


    //PRINTA O GAME
    public void printarGame() {
        System.out.print("    "); // Espaço para alinhar os números da horizontal
        for (int i = 0; i < 9; i++) {
            
            if(i==2 || i==5){
                System.out.print(i + "   "); // Índices da horizontal
            }else{
                System.out.print(i + " "); // Índices da horizontal
            }
        }
        System.out.println("\n    -------------------------");
    
        for (int linhaQuadrado = 0; linhaQuadrado < 3; linhaQuadrado++) {
            for (int linha = 0; linha < 3; linha++) {
                int indiceVertical = linhaQuadrado * 3 + linha; // Índice da vertical
                System.out.print(indiceVertical + " | "); // Índices da vertical
    
                for (int colunaQuadrado = 0; colunaQuadrado < 3; colunaQuadrado++) {
                    int quadradoIndex = linhaQuadrado * 3 + colunaQuadrado; 
                    for (int coluna = 0; coluna < 3; coluna++) {
                        int posicaoIndex = linha * 3 + coluna;
                        System.out.print(squares.get(quadradoIndex).getSquarePos(posicaoIndex) + " ");
                    }
                    System.out.print("| ");
                }
                System.out.println();
            }
            System.out.println("    -------------------------");
        }
    }

    //PRINTA OS FIXOS DO GAME (EM TRUE OU FALSE)
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
                        if(squares.get(quadradoIndex).getSquareFixoPos(posicaoIndex)){
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

    //FUNÇÃO PARA ADICIONAR UM NÚMERO DADO UMA POSIÇÃO VERTICAL E HORIZONTAL
    public void colocarNumero(String num, int vertical, int horizontal){
        int posSquare = (vertical/3) * 3 + (horizontal/3);
        int posInterna = (vertical%3) * 3 + (horizontal%3);
        
        if(squares.get(posSquare).getSquareFixoPos(posInterna)){
            System.out.println("Não é possível colocar um número na posição passada pois se trata de um fixo");
        }else if(!squares.get(posSquare).getSquarePos(posInterna).equals(" ")){
            System.out.println("Já possui um numero onde deseja colocar, favor remover antes de tentar novamente");
        }else if(squares.get(posSquare).getSquare().contains(num)){
            System.out.println("Já possui o mesmo numero no square que deseja colocar");
        }else{
            squares.get(posSquare).setSquarePos(posInterna, num);
            System.out.println("Número "+ num + " inserido na posição");
            if(!verVazios() && !verErros()){
                status = "Completo, sem erros";
            }else if(!verVazios() && verErros()){
                status = "Completo, com erros";
            }else if(verVazios() && verErros()){
                status = "Incompleto, com erros";
            }else{
                status = "Incompleto, sem erros";
            }
        }
    }


    //REMOVE UM NÚMERO DO GAME DADO A SUA POSIÇÃO HORIZONTAL E VERTICAL
    public void removerNumero(int vertical, int horizontal){
        int posSquare = (vertical/3) * 3 + (horizontal/3);
        int posInterna = (vertical%3) * 3 + (horizontal%3);
        
        if(squares.get(posSquare).getSquareFixoPos(posInterna)){
            System.out.println("Não é possível remover um número na posição passada pois se trata de um fixo");
        }else if(squares.get(posSquare).getSquarePos(posInterna).equals(" ")){
            System.out.println("Como o espaço estava vazio não foi necessário a remoção");
        }else{
            squares.get(posSquare).setSquarePos(posInterna, " ");
            System.out.println("Número removido na posição");
            if(!verVazios() && !verErros()){
                status = "Completo, sem erros";
            }else if(!verVazios() && verErros()){
                status = "Completo, com erros";
            }else if(verVazios() && verErros()){
                status = "Incompleto, com erros";
            }else{
                status = "Incompleto, sem erros";
            }
        }
    }


    //COLOCA UM NÚMERO FIXO NO JOGO
    public void colocarFixo(String num, int vertical, int horizontal){
        int posSquare = (vertical/3) * 3 + (horizontal/3);
        int posInterna = (vertical%3) * 3 + (horizontal%3);
    
        squares.get(posSquare).setSquarePos(posInterna, num);
        squares.get(posSquare).setSquareFixoPos(posInterna, true);
    }




    //VERIFICA EM TODOS OS SQUARES SE HÁ VAZIO
    public Boolean verVazios(){
        for(int i=0; i<MAX_NUM; i++){
            if(squares.get(i).verVazio()){
                return true;
            }
        }
        return false;
    }


    //FUNÇÃO AUXILIAR PARA SABER EM QUAL SQUARE ESTAMOS DADO UMA VERTICAL E HORIZONTAL
    public Integer posSquare(int vertical, int horizontal){
        return (vertical/3) * 3 + (horizontal/3);
    }

    //FUNÇÃO AUXILIAR PARA SABER A POSIÇÃO INTERNA DADO UMA VERTICAL E HORIZONTAL
    public Integer posInterna(int vertical, int horizontal){
        return (vertical%3) * 3 + (horizontal%3);
    }


    //PASSA POR CADA SQUARE VERIFICANDO SE HÁ ERRO DENTRO DELES
    public Boolean verErroSquares(){
        for(int i=0; i<MAX_NUM; i++){
            if(squares.get(i).verErro()){
                return true;
            }
        }
        return false;
    }



    //PASSA POR TODAS AS HORIZONTAIS VERIFICANDO SE HÁ ERRO NELAS
    public Boolean verErroHor() {
        for (int horizontal = 0; horizontal < MAX_NUM; horizontal++) {
            List<String> valoresVistos = new ArrayList<>();
            for (int vertical = 0; vertical < MAX_NUM; vertical++) {
                String comparador = squares.get(posSquare(vertical, horizontal)).getSquarePos(posInterna(vertical, horizontal));
                if (!comparador.equals(" ")) {
                    if (valoresVistos.contains(comparador)) {
                        return true;
                    }
                    valoresVistos.add(comparador);
                }
            }
        }
        return false; 
    }

    //PASSA POR TODAS AS VERTICAIS VERIFICANDO SE HÁ ERRO NELAS
    public Boolean verErroVert() {
        for (int vertical = 0; vertical < MAX_NUM; vertical++) {
            List<String> valoresVistos = new ArrayList<>();
            for (int horizontal = 0; horizontal < MAX_NUM; horizontal++) {
                String comparador = squares.get(posSquare(vertical, horizontal)).getSquarePos(posInterna(vertical, horizontal));
                if (!comparador.equals(" ")) {
                    if (valoresVistos.contains(comparador)) {
                        return true;
                    }
                    valoresVistos.add(comparador);
                }
            }
        }
        return false; 
    }


    //VERIFICA TANTO NAS VERTICAIS E HORIZONTAIS QUANTO DENTRO DOS SQUARES SE TEM ERRO
    public Boolean verErros(){
        //passa por cada square verificando se há erro dentro deles
        if(verErroSquares()){
            return true;
        }
        //passa tanto pelas verticais quanto nas horizontais, verificando se há erro nelas
        if(verErroHor() || verErroVert()){
            return true;
        }
        return false;
    }

    //RETORNA SE O JOGO ESTÁ PRONTO PARA SER FINALIZADO (SEM ERROS E SEM VAZIOS)
    public Boolean finishGame(){
        //passa por cada square verificando se há vazio dentro deles
        if(verVazios()){
            System.out.println("Ainda há espaços para serem preenchidos, não é possível finalizar");
            return false;
        }
        //VERIFICA SE HÁ ERRO DENTRO DO GAME
        if(verErros()){
            System.out.println("Há erros no game, não é possível finalizar");
            return false;
        }
        System.out.println("Jogo pronto para ser encerrado!");
        return true;
    }
    

}
