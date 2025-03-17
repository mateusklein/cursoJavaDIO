import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int option = -1;
        Redes rede;
        String origem;
        String destino;
        String msg;

        while (option != 5) {
            System.out.println("Escolha o tipo de comunicação");
            System.out.println("1 - SMS");
            System.out.println("2 - EMAIL");
            System.out.println("3 - REDES SOCIAIS");
            System.out.println("4 - WHATSAPP");
            System.out.println("5 - Sair do programa");

            // Lendo a opção corretamente
            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer após nextInt()
            } else {
                System.out.println("Entrada inválida! Digite um número entre 1 e 5.");
                scanner.next(); // Descarta a entrada inválida
                continue;
            }

            // Validação da opção
            if (option < 1 || option > 5) {
                System.out.println("Opção inválida, digite novamente entre 1 e 5");
                continue;
            }

            if (option == 5) {
                System.out.println("Saindo do programa...");
                break;
            }

            // Captura de entrada baseada na opção
            System.out.println("Digite seu identificador (número, email ou nome):");
            origem = scanner.nextLine();
            System.out.println("Digite o destinatário:");
            destino = scanner.nextLine();
            System.out.println("Agora digite a mensagem:");
            msg = scanner.nextLine();

            // Instanciando a classe correta
            switch (option) {
                case 1:
                    rede = new Sms(msg, origem, destino);
                    break;
                case 2:
                    rede = new Email(msg, origem, destino);
                    break;
                case 3:
                    rede = new Redessociais(msg, origem, destino);
                    break;
                case 4:
                    rede = new Whatsapp(msg, origem, destino);
                    break;
                default:
                    continue;
            }

            System.out.println(rede.getMsg());
        }

        scanner.close(); // Fecha o scanner para evitar vazamentos de recursos
    }
}
