package br.com.dio;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        var opcao = 1;
        Game game = new Game();
        int vert;
        int hor;
        int num;
        Boolean erro;
        do{
            Scanner scanner = new Scanner(System.in);
            System.out.println("1 - Iniciar novo jogo");
            System.out.println("2 - Colocar novo número");
            System.out.println("3 - Remover um número");
            System.out.println("4 - Verificar jogo");
            System.out.println("5 - Verificar status do jogo");
            System.out.println("6 - Limpar todos os números digitados");
            System.out.println("7 - Finalizar jogo");
            System.out.println("0 - Sair");
            System.out.println("Escolha uma das opções:");
            opcao = scanner.nextInt();
            erro = true;


            switch (opcao) {
                case 1:
                    System.out.println("=========INICIANDO NOVO JOGO=============");
                    iniciarJogo(game);
                    System.out.println("=========================================");
                    break;
                case 2:
                    if(game.getStatus().equals("Não iniciado")){
                        System.out.println("Game ainda não iniciado, precisa iniciar para ativar essa função");
                    }else{
                        System.out.println("=========COLOCANDO UM NÚMERO=============");                   
                        do{
                            System.out.println("Digite o número (de 1 a 9), a sua posição vertical e horizontal (de 0 a 8) separados por vírgula - EXEMPLO: 2, 0, 3");
                            var entrada = scanner.next();
                            List<String> lista = Arrays.asList(entrada.split(","));
                            while(lista.size()!=3){
                                System.out.println("Número de entradas menor ou excedido, digite novamente");
                                entrada = scanner.next();
                                lista = Arrays.asList(entrada.split(","));
                            }
                            num = Integer.parseInt(lista.get(0));
                            vert = Integer.parseInt(lista.get(1));
                            hor = Integer.parseInt(lista.get(2));
                            
                            if(num<1 || num>9 || vert<0 || vert>8 || hor<0 || hor>8){
                                System.out.println("Número deve estar entre 1 e 9 / horizontal e vertical entre 0 e 8, tente novamente");
                            }else{
                                erro=false;
                            }
                        }while (erro == true);
                        game.colocarNumero(num, vert, hor);
                        System.out.println("=========================================");
                    }
                    break;
                case 3:
                    if(game.getStatus().equals("Não iniciado")){
                        System.out.println("Game ainda não iniciado, precisa iniciar para ativar essa função");
                    }else{
                        System.out.println("=========REMOVENDO UM NÚMERO=============");
                        do{
                            System.out.println("Digite a sua posição vertical e horizontal (de 0 a 8) separados por vírgula - EXEMPLO: 2, 0, 3");
                            var entrada = scanner.next();
                            List<String> lista = Arrays.asList(entrada.split(","));
                            while(lista.size()!=2){
                                System.out.println("Número de entradas menor ou excedido, digite novamente");
                                entrada = scanner.next();
                                lista = Arrays.asList(entrada.split(","));
                            }
                            vert = Integer.parseInt(lista.get(0));
                            hor = Integer.parseInt(lista.get(1));

                            if(vert<0 || vert>8 || hor<0 || hor>8){
                                System.out.println("Vertical/orizontal deve estar entre 0 e 8, tente novamente");
                            }else{
                                erro=false;
                            }
                        }while (erro == true);
                        game.removerNumero(vert, hor);
                        System.out.println("=========================================");
                    }
                    break;
                case 4:
                    if(game.getStatus().equals("Não iniciado")){
                        System.out.println("Game ainda não iniciado, precisa iniciar para ativar essa função");
                    }else{
                        System.out.println("===========VERIFICAR JOGO================");
                        game.printarGame();
                        System.out.println("=========================================");
                    }
                    break;
                case 5:
                    System.out.println("===========VERIFICAR STATUS===============");
                    System.out.println(game.getStatus());
                    System.out.println("=========================================");
                    break;
                case 6:
                    if(game.getStatus().equals("Não iniciado")){
                        System.out.println("Game ainda não iniciado, precisa iniciar para ativar essa função");
                    }else{
                        System.out.println("==========LIMPAR OS NÚMEROS==============");
                        game.limpar();
                        System.out.println("Jogo limpo:");
                        game.printarGame();
                        System.out.println("=========================================");
                    }
                    break;
                case 7:
                    if(game.getStatus().equals("Não iniciado")){
                        System.out.println("Game ainda não iniciado, precisa iniciar para ativar essa função");
                    }else{
                        System.out.println("===========FINALIZAR O JOGO===============");
                        game.finishGame();
                        System.out.println("=========================================");
                    }
                    break;
                case 0:
                    System.out.println("=============SAIR DO JOGO================");
                    if(game.getStatus().equals("Não iniciado")){
                        System.out.println("Você encerrou sem iniciar o jogo");
                    }else{
                        System.out.println("Você encerrou o jogo dessa maneira:");
                        game.printarGame();
                    }
                    System.out.println("=========================================");
                    break;
                default:
                    break;
            }
        }while(opcao!=0);
    }


    public static Game iniciarJogo(Game game){
        game.iniciarGame();
        /*
        //USANDO NÚMEROS DO EXEMPLO:
        game.colocarFixo(9,0,0);
        game.colocarFixo(5,0,1);
        game.colocarFixo(8,0,2);
        game.colocarFixo(6,2,2);
        game.colocarFixo(2,1,3);
        game.colocarFixo(5,1,4);
        game.colocarFixo(6,1,5);
        game.colocarFixo(2,0,7);
        game.colocarFixo(4,1,7);
        game.colocarFixo(5,2,6);
        game.colocarFixo(1,2,7);
        game.colocarFixo(7,2,8);
        game.colocarFixo(6,3,0);
        game.colocarFixo(7,4,0);
        game.colocarFixo(8,4,1);
        game.colocarFixo(4,4,2);


        game.colocarFixo(3,3,3);
        game.colocarFixo(7,3,4);
        game.colocarFixo(8,3,5);
        game.colocarFixo(4,5,3);
        game.colocarFixo(2,5,4);
        game.colocarFixo(9,5,5);
        

        game.colocarFixo(9,4,6);
        game.colocarFixo(3,4,7);
        game.colocarFixo(2,4,8);
        game.colocarFixo(8,5,8);
        
        game.colocarFixo(4,6,0);
        game.colocarFixo(9,6,1);
        game.colocarFixo(2,6,2);
        game.colocarFixo(6,7,1);
        game.colocarFixo(1,8,1);

        game.colocarFixo(5,7,3);
        game.colocarFixo(8,7,4);
        game.colocarFixo(1,7,5);

        game.colocarFixo(1,6,6);
        game.colocarFixo(7,8,6);
        game.colocarFixo(6,8,7);
        game.colocarFixo(3,8,8);
        */


        
        //USANDO NUMEROS RANDOM, A CADA VEZ QUE O USUÁRIO REINICIAR PODE SER UM JOGO DIFERENTE
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

        return game;
    }
}
