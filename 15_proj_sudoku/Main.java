public class Main {
    public static void main(String[] args) {
        var game = new Game();

        game.colocarFixo("9",0,0);
        game.colocarFixo("5",0,1);
        game.colocarFixo("8",0,2);
        game.colocarFixo("6",2,2);
        game.colocarFixo("2",1,3);
        game.colocarFixo("5",1,4);
        game.colocarFixo("6",1,5);
        game.colocarFixo("2",0,7);
        game.colocarFixo("4",1,7);
        game.colocarFixo("5",2,6);
        game.colocarFixo("1",2,7);
        game.colocarFixo("7",2,8);
        game.colocarFixo("6",3,0);
        game.colocarFixo("7",4,0);
        game.colocarFixo("8",4,1);
        game.colocarFixo("4",4,2);


        game.colocarFixo("3",3,3);
        game.colocarFixo("7",3,4);
        game.colocarFixo("8",3,5);
        game.colocarFixo("4",5,3);
        game.colocarFixo("2",5,4);
        game.colocarFixo("9",5,5);
        

        game.colocarFixo("9",4,6);
        game.colocarFixo("3",4,7);
        game.colocarFixo("2",4,8);
        game.colocarFixo("8",5,8);
        
        game.colocarFixo("4",6,0);
        game.colocarFixo("9",6,1);
        game.colocarFixo("2",6,2);
        game.colocarFixo("6",7,1);
        game.colocarFixo("1",8,1);

        game.colocarFixo("5",7,3);
        game.colocarFixo("8",7,4);
        game.colocarFixo("1",7,5);

        game.colocarFixo("1",6,6);
        game.colocarFixo("7",8,6);
        game.colocarFixo("6",8,7);
        game.colocarFixo("3",8,8);

        



        game.printarGame();
        game.printarGameFixo();
    }
}
