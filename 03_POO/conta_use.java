import java.util.Scanner;

public class conta_use {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var myaccount = new conta(1000f);
        
        Integer opcao;
        do{
            System.out.println("====================MENU PRINCIPAL=====================");
            System.out.println("1-Consultar saldo\n2-Consultar cheque\n3-Depositar dinheiro\n4-Sacar dinheiro\n5-Pagar boleto\n6-Verificar se a conta está utilizando cheque especial\n0-Sair");
            System.out.println("=======================================================");
            System.out.println("Selecione uma opcao:");
            opcao = scanner.nextInt();

            while(opcao < 0 || opcao > 6){
                System.out.println("Opcao invalida, escolha entre 0 e 6");
                opcao = scanner.nextInt();
            }

            Float valor;
            switch (opcao) {
                case 1:
                    System.out.println("\n");
                    System.out.println("========CONSULTA SALDO=========");
                    myaccount.getSaldo();
                    System.out.println("\n===============================");
                    System.out.println("\n");
                    break;
                case 2:
                    System.out.println("\n");
                    System.out.println("========CONSULTA CHEQUE========");
                    myaccount.getCheque();
                    System.out.println("\n===============================");
                    System.out.println("\n");
                    break;
                case 3:
                    System.out.println("\n");
                    System.out.println("==========================DEPÓSITO=========================");
                    System.out.println("Valor de depósito:");
                    valor = scanner.nextFloat();
                    myaccount.depositaDinheiro(valor);
                    System.out.println("\n===========================================================");
                    System.out.println("\n");
                    break;
                case 4:
                    System.out.println("\n");
                    System.out.println("\n========================SAQUE==============================");
                    System.out.println("Valor de saque:");
                    valor = scanner.nextFloat();
                    myaccount.sacaDinheiro(valor);
                    System.out.println("\n===========================================================");
                    System.out.println("\n");
                    break;
                case 5:
                    System.out.println("\n");
                    System.out.println("\n==========================PAGAR BOLETO=====================");
                    System.out.println("Digite o valor do boleto:");
                    valor = scanner.nextFloat();
                    myaccount.pagaBoleto(valor);
                    System.out.println("\n===========================================================");
                    System.out.println("\n");
                    break;
                case 6:
                    System.out.println("\n");
                    System.out.println("========VERIFICA USO CHEQUE==========");
                    myaccount.getUsandoCheque();
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
