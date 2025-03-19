import java.util.Scanner;
import enumeration.*;

public class main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var option = -1;
        while (option!=5) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Soma");
            System.out.println("2 - Subtracao");
            System.out.println("3 - Multiplicacao");
            System.out.println("4 - Divisão");
            System.out.println("5 - Sair");
            option = scanner.nextInt();


            var selectedOption = OperationEnum.values()[option-1];
            System.out.println(selectedOption);


            System.out.println("Informe o primeiro valor");
            var value1 = scanner.nextInt();
            System.out.println("Informe o segundo valor");
            var value2 = scanner.nextInt();

            var result = selectedOption.getCalculate().apply(value1, value2);

            System.out.printf("%s %s %s = %s", value1, selectedOption.getSymbol() ,value2, result);
        }


    }
}
