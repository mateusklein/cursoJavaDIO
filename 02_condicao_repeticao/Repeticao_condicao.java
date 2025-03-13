import java.util.Scanner;


public class Repeticao_condicao {
    public static void main (String[] args){
        
        var scanner = new Scanner(System.in);
        /* 
        System.out.println("Informe sua idade:");
        var idade = scanner.nextInt();
        System.out.println("Você é emancipado? (s/n)");
        var isEmancipated = scanner.next().equalsIgnoreCase("s");

        var canDrive = (idade > 18) || (idade>=16 && isEmancipated);
        var msg = "Não pode dirigir";
        if (canDrive){ 
            msg = "Você pode dirigir \n";
        }

        System.out.println(msg);

        
        // USANDO ELVIS OPERATOR
        // SE FOR TRUE EXECUTA ANTES DO :
        // CASO FOR FALSE EXECUTA APÓS O :
        var msg2 = canDrive ? 
            "Você pode dirigir\n":
            "Você não pode dirigir\n";

        System.out.println(msg2);



        
        System.out.println("Escolha um número de 1 a 7");
        var option = scanner.nextInt();
        switch (option) {
            case 1:
            case 7:
                System.out.println("Fim de semana");
                break;  
            case 2:
                System.out.println("Segunda");
                break;
            case 3:
                System.out.println("Terca");
                break;
            case 4:
                System.out.println("Quarta");
                break;
            case 5:
                System.out.println("Quinta");
                break;
            case 6:
                System.out.println("Sexta");
                break;         
            default:
                System.out.println("Opcao invalida");
                break;
        }


        switch (option) {
            case 1,7 -> System.out.println("Fim de semana");
            case 2 -> System.out.println("Segunda");
            case 3 -> System.out.println("Terca");
            case 4 -> System.out.println("Quarta");
            case 5 -> System.out.println("Quinta");
            case 6 -> System.out.println("Sexta");
            default -> System.out.println("Opcao invalida");
        }
        */

        System.out.println("\n============================================");
        System.out.println("\n============USANDO FOR======================");
        System.out.println("\n============================================");
        
        for (var i = 1; i <= 100; i++) {
            System.out.printf("%s\n", i);

            if(i==100){
                System.out.printf("FIM DA EXECUCAO\n");
            }
        }

        for (var arg : args) {
            System.out.printf(arg);
        }

        for (;;) {
            System.out.println("Digite um nome:");
            var name = scanner.next();

            if (name.equalsIgnoreCase("exit")) break;
        }

        System.out.println("\n============================================");
        System.out.println("\n=============USANDO WHILE===================");
        System.out.println("\n============================================");

        var name = "";
        while (!name.equalsIgnoreCase("exit")){
            System.out.println("\ninforme o nome:");
            name = scanner.next();
        }

        System.out.println("\n============================================");
        System.out.println("\n============USANDO DO WHILE=================");
        System.out.println("\n============================================");

        name = "exit";
        do{
            System.out.println("\ninforme o nome:");
            name = scanner.nextLine();
        }while(!name.equalsIgnoreCase("exit"));
    }
}
