import java.time.OffsetDateTime;
import java.util.Scanner;


public class Operadores {
    public static void main (String[] args){
        /*
         
        
            =    ->     atribuição
            ==   ->     comparação de igualdade
            >=   ->     maior igual
            >    ->     maior
            <=   ->     menor igual
            <    ->     menor
            !=   ->     diferente de
            +    ->     soma
            -    ->     subtracao
            *    ->     multiplicacao
            /    ->     divisão
            %%   ->     resto da divisão
            |    ->     or
            &    ->     and
            ^    ->     xor (numeros iguais retorna 0)
            ~    ->     negacao (complemento)
            <<   ->     left shift (empurra para a esquerda)
            >>   ->     right shift (empurra para a direita), caso o número seja negativo completa com 1
            >>>  ->     direita não sinalizada, o bit de sinal será 0
          
          
         */


        
        var scanner = new Scanner(System.in);
        System.out.println("Quanto é 2+2?");
        var result = scanner.nextInt();
        var isRight = result==4;
        var isWrong = result!=4;
        System.out.printf("O resultado é 4, você acertou ? (%s)", isRight);
        System.out.printf("\nO resultado é 4, você acertou (usando !) ? (%s)", !isWrong);

        System.out.println("\nQuantos anos você tem?");
        var age = scanner.nextInt();
        var canDrive = age > 17;
        canDrive = age >= 18;
        var canDriveN = age < 18;
        canDriveN = age <= 17;
        System.out.println("\nVocê é emancipado (utilize true ou false)?");
        var isEmancipated = scanner.nextBoolean();
        System.out.printf("Você pode dirigir ? (%s)", canDrive || (isEmancipated && age >= 16));
        System.out.printf("\nVocê pode dirigir (usando <18) ? (%s)", !canDriveN || (isEmancipated && age >= 16));

        System.out.println("\nInforme o primeiro numero");
        var num1 = scanner.nextFloat();
        System.out.println("\nInforme o segundo numero");
        var num2 = scanner.nextFloat();
        System.out.printf("\n%s + %s = %s", num1, num2, num1 + num2);
        System.out.printf("\n%s - %s = %s", num1, num2, num1 - num2);
        System.out.printf("\n%s * %s = %s", num1, num2, num1 * num2);
        System.out.printf("\n%s / %s = %s", num1, num2, num1 / num2);
        System.out.printf("\n%s %% %s = %s", num1, num2, num1 % num2);
        System.out.printf("\nRaiz de %s = %s", num1, Math.sqrt(num1));
        System.out.printf("\n%s elevado a %s = %s", num1, num2, Math.pow(num1, num2));


        var value = 5;
        // value = value + 12;
        value += 12;
        value -= 12;
        value *= 12;
        value /= 12;

        value = 50;
        // value++ só passa a valer na proxima linha
        // ++ value passa a valer na linha atual
        System.out.println(value++);
        System.out.println(value);
        System.out.println(++value);
        System.out.println(value);
        

        var value1 = 53;
        var binary1 = Integer.toBinaryString(value1);
        System.out.printf("\nPrimeiro número da operação %s (representação em binário %s)", value1, binary1);
        var value2 = 2;
        var binary2 = Integer.toBinaryString(value2);
        System.out.printf("\nSegundo número da operação %s (representação em binário %s)", value2, binary2);
        var resultOr = value1 | value2;
        var binaryResultOr = Integer.toBinaryString(resultOr);
        var resultAnd = value1 & value2;
        var binaryResultAnd = Integer.toBinaryString(resultAnd);
        System.out.printf("\n%s | %s = %s (representacao binaria %s)", value1, value2, resultOr, binaryResultOr);
        System.out.printf("\n%s | %s = %s (representacao binaria %s)", value1, value2, resultAnd, binaryResultAnd);
        System.out.printf("\n%s ^ %s = %s (representacao binaria %s)", value1, value2, value1 ^ value2, Integer.toBinaryString(value1 ^ value2));
        System.out.printf("\n~%s = %s (representacao binaria %s)", value1, ~value1, Integer.toBinaryString(~value1));
        System.out.printf("\n%s << %s = %s (representacao binaria %s)", value1, value2, value1 << value2, Integer.toBinaryString(value1 << value2));
        System.out.printf("\n%s >> %s = %s (representacao binaria %s)", value1, value2, value1 >> value2, Integer.toBinaryString(value1 >> value2));
        System.out.printf("\n%s >>> %s = %s (representacao binaria %s)", value1, value2, value1 >>> value2, Integer.toBinaryString(value1 >>> value2));
        

        // EXERCÍCIOS
        // RECEBE O ANO DE NASCIMENTO E RETORNA A IDADE
        var baseYear = OffsetDateTime.now().getYear();
        System.out.println("\nInforme seu nome");
        var nome = scanner.next();
        System.out.println("\nEm qual ano você nasceu?");
        var ano = scanner.nextInt();
        var age0 = baseYear - ano;
        System.out.printf("\nOlá %s, sua idade é %s", nome, age0);

        //RECEBE O TAMANHO DO LADO DE UM QUADRADO E CALCULA A AREA
        System.out.println("\nInforme o tamanho do lado do quadrado");
        var lado = scanner.nextInt();
        System.out.printf("\nÁrea do quadrado: %s", lado * lado);

        //RECEBE AS DIMENSOES (ALTURA E LARGURA) E CALCULA A AREA DE UM RETANGULO
        System.out.println("\nInforme a largura do retangulo");
        var largura = scanner.nextInt();
        System.out.println("\nInforme a altura do retangulo");
        var altura = scanner.nextInt();
        System.out.printf("\nÁrea do retangulo: %s", largura * altura);


        System.out.println("\nInforme nome da primeira pessoa");
        var nome1 = scanner.next();
        System.out.println("\nEm qual ano nasceu?");
        var ano1 = scanner.nextInt();
        var age1 = baseYear - ano1;
        System.out.println("\nInforme nome da segunda pessoa");
        var nome2 = scanner.next();
        System.out.println("\nEm qual ano nasceu?");
        var ano2 = scanner.nextInt();
        var age2 = baseYear - ano2;
        System.out.printf("\nOlá %s e %s, a diferença de idade entre vocês é %s", nome1, nome2, Math.abs(age1-age2));

    }
}
