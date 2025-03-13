import java.util.Scanner;

public class carro_use {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var mycar = new carro();
        
        Integer opcao;
        do{
            System.out.println("====================MENU PRINCIPAL=====================");
            System.out.println("1-Ligar o carro\n2-Desligar o carro\n3-Aumentar velocidade\n4-Reduzir velocidade\n5-Aumentar marcha\n6-Reduzir marcha\n7-Virar para esquerda/direita\n8-Verificar velocidade e marcha\n0-Sair");
            System.out.println("=======================================================");
            System.out.println("Selecione uma opcao:");
            opcao = scanner.nextInt();
            char dir;

            while(opcao < 0 || opcao > 8){
                System.out.println("Opcao invalida, escolha entre 0 e 8");
                opcao = scanner.nextInt();
            }

            Float valor;
            switch (opcao) {
                case 1:
                    System.out.println("\n");
                    System.out.println("========LIGAR CARRO=========");
                    mycar.ligaCarro();
                    System.out.println("\n===============================");
                    System.out.println("\n");
                    break;
                case 2:
                    System.out.println("\n");
                    System.out.println("========DESLIGAR CARRO========");
                    mycar.desligaCarro();
                    System.out.println("\n===============================");
                    System.out.println("\n");
                    break;
                case 3:
                    System.out.println("\n");
                    System.out.println("==========================AUMENTAR VELOCIDADE=========================");
                    mycar.aumentaVelocidade();
                    System.out.println("\n===========================================================");
                    System.out.println("\n");
                    break;
                case 4:
                    System.out.println("\n");
                    System.out.println("\n========================REDUZIR VELOCIDADE==============================");
                    mycar.reduzVelocidade();
                    System.out.println("\n===========================================================");
                    System.out.println("\n");
                    break;
                case 5:
                    System.out.println("\n");
                    System.out.println("\n==========================AUMENTAR MARCHA=====================");
                    mycar.aumentaMarcha();
                    System.out.println("\n===========================================================");
                    System.out.println("\n");
                    break;
                case 6:
                    System.out.println("\n");
                    System.out.println("========REDUZIR MARCHA==========");
                    mycar.reduzMarcha();
                    System.out.println("\n=====================================");
                    System.out.println("\n");
                    break;
                case 7:
                    System.out.println("\n");
                    System.out.println("========VIRAR PARA ESQUERDA/DIREITA==========");
                    System.out.println("\nDigite para onde deseja virar (E-> esquerda, D->direita)");
                    dir = scanner.next("[eEdD]").toUpperCase().charAt(0);
                    mycar.virarEsqDir(dir);
                    System.out.println("\n=====================================");
                    System.out.println("\n");
                    break;
                case 8:
                    System.out.println("\n");
                    System.out.println("========VERIFICA VELOCIDADE E MARCHA==========");
                    mycar.getMarchaVel();
                    System.out.println("\n=====================================");
                    System.out.println("\n");
                    break;
                case 0:
                    System.out.println("\n");
                    System.out.println("\n===============================");
                    System.out.println("========== BYE :) =============");
                    System.out.println("===============================");
                    System.out.println("\n");
                default:
                    break;
            }

        }while(opcao!=0);
    }
}
