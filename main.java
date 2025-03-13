import java.util.Scanner;


public class Main {
    public static void main (String[] args){
        var scanner = new Scanner(System.in);
        System.out.println("Informe seu nome:");
        var age = scanner.next();
        System.out.println("Informe sua idade:");
        var idade = scanner.nextInt();

        if (idade >= 18){ 
            System.out.println("Bem-vindo\n");
            System.out.println("%s tem %s anos, você pode dirigir\n", nome, age);
        }

        System.out.println("Fim da execução");
    }
}
