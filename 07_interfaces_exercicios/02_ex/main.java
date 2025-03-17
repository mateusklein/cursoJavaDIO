import java.util.Scanner;

public class main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int option = -1;
        Double valor;
        Imposto imposto;
        while (option != 5) {
            System.out.println("Escolha o tipo de imposto");
            System.out.println("1 - Alimentacao");
            System.out.println("2 - Saude");
            System.out.println("3 - Vestuario");
            System.out.println("4 - Cultura");
            System.out.println("5 - Sair do programa");
            option = scanner.nextInt();
            while(option<1 || option > 5){
                System.out.println("Opção inválida, digite novamente entre 1 a 4");
                option = scanner.nextInt();
            }
            System.out.println("Digite o valor do produto:");
            valor = scanner.nextDouble();
            switch (option) {
                case 1:
                    imposto = new Alimentacao(valor);
                    break;
                case 2:
                    imposto = new Saude(valor);
                    break;
                case 3:
                    imposto = new Vestuario(valor);
                    break;
                case 4:
                    imposto = new Cultura(valor);
                    break;  
                default:

                    continue;
            }
            System.out.println("O " + imposto.getName() + " cobrado foi de R$"+ imposto.getValor());
        }
    }
}
