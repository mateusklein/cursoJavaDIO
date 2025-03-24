import java.nio.file.OpenOption;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import calc.*;

import calc.Operation;

public class main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        int operationOption;
        Operation selectedOption = null;
        do{
            System.out.println("Informe o númerio da operação que deseja realizar (1-sum, 2-subtraction, 0-sair)");
            operationOption = scanner.nextInt();
            while (operationOption > 2 || operationOption < 0) {
                System.out.println("Escolha uma opcao válida (1-sum, 2-subtracao)");
                operationOption = scanner.nextInt();      
            }
            if(operationOption!=0){
                selectedOption = Operation.values()[operationOption-1];
                System.out.println("Operação de " + selectedOption );
                System.out.println("Informe os números que serão usados separados por vírgula (ex:1,2,3,4):");
                var numbers = scanner.next();
                var numberArray = Arrays.stream(numbers.split(",")).mapToLong(Long::parseLong).toArray();
                var result = selectedOption.getOperationCallback().exec(numberArray);

                System.out.println("O resultado da operação é: \n"+ result);

            }
        }while(operationOption != 0);
    }
}
