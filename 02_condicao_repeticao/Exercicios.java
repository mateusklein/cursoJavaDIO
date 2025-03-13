import java.util.Scanner;


public class Exercicios {
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
        */

        // RECEBE UM NUMÉRO E CALCULA A TABUADA DE 1 A 10
        System.out.println("================================");
        System.out.println("===========TABUADA==============");
        System.out.println("================================");
        System.out.println("Entre com um número para calcular a tabuada:");
        var number = scanner.nextInt();

        for (var i = 1; i <= 10; i++) {
            System.out.printf("%s * %s = %s\n", number, i, number*i);
        }


        // RECEBE ALTURA E PESO E RETORNE MENSAGEM CONFORME IMC
        System.out.println("================================");
        System.out.println("==============IMC===============");
        System.out.println("================================");

        System.out.println("Entre com a sua altura (em cm):");
        var alt = scanner.nextInt();
        float altfloat = (float) alt;
        altfloat = altfloat / 100;
        System.out.println("Entre com seu peso:");
        var peso = scanner.nextFloat();

        var imc = peso/(altfloat * altfloat);

        if (imc <= 18.5){
            System.out.println("Abaixo do peso");
        }else if(imc <= 24.9){
            System.out.println("Peso ideal");
        }else if(imc <= 29.9){
            System.out.println("Levemente acima do peso");
        }else if(imc <= 34.9){
            System.out.println("Obesidade grau 1");
        }else if(imc <= 39.9){
            System.out.println("Obesidade grau 2 (Severa)");
        }else{
            System.out.println("Obesidade grau 3 (mórbida)");
        }

        // ESCOLHE 2 NÚMEROS (O SEGUNDO MAIOR QUE O PRIMEIRO) E UMA OPCAO ENTRE PAR E IMPAR E RETORNA TODOS OS NÚMEROS DO INTERVALO QUE SEJAM PAR OU IMPAR
        System.out.println("================================");
        System.out.println("===========PAR E IMPAR==========");
        System.out.println("================================");
        System.out.println("Entre com o primeiro numero");
        var num1 = scanner.nextInt();
        System.out.println("Entre com o segundo numero (deve ser maior que o primeiro)");
        var num2 = scanner.nextInt();

        while(num2 < num1){
            System.out.println("O segundo número deve ser maior que o primeiro, informe novamente");
            num2 = scanner.nextInt();
        }

        System.out.println("Escolha uma opcao entre par e impar (0 -> par, 1 -> impar)");
        var opcao = scanner.nextInt();
        while(opcao != 0 && opcao != 1){
            System.out.println("A opcao deve ser 0 ou 1 (0 -> par, 1 -> impar)");
            opcao = scanner.nextInt();
        }

        if(opcao == 1){
            System.out.println("Impares");
            for(var i=num2; i>=num1; i--){
                if((i % 2) > 0){
                    System.out.printf("Número: %s\n", i);
                }
            }
        }
        else{
            System.out.println("Pares\n");
            for(var i=num2; i>=num1; i--){
                if((i % 2) == 0){
                    System.out.printf("Número: %s\n", i);
                }
            }
        }

        // ESCOLHE 1 NÚMERO, PROGRAMA CONTINUA SOLICITANDO NUMEROS ATÉ QUE SEJA INFORMADO UM QUE TENHA RESTO DIFERENTE DE 0 NA DIVISÃO DO PRIMEIRO
        System.out.println("================================");
        System.out.println("========RESTO DA DIVISÃO========");
        System.out.println("================================");
        System.out.println("Entre com o primeiro numero");
        var numEsc = scanner.nextInt();
        int numEsc2;
        var ver = true;

        while(ver){
            System.out.println("\nEntre com o proximo numero");
            numEsc2 = scanner.nextInt();
            if(numEsc2 < numEsc){
                ver = true;
                System.out.println("Escolha um número maior");
                continue;
            }
            else{
                ver = numEsc2 % numEsc == 0;
                System.out.printf("Resto da divisão de %s por %s = %s", numEsc2, numEsc, numEsc2%numEsc);
            }
        }
        System.out.println("ENCERRADO");
    }
}
