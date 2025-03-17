import java.util.Scanner;

public class main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int option = -1;
        GeometricForm geometricForm;
        while (option != 4) {
            System.out.println("Escolha a forma geométrica para calcular a área");
            System.out.println("1 - Quadrado");
            System.out.println("2 - Retangulo");
            System.out.println("3 - Círculo");
            System.out.println("4 - Sair do programa");
            option = scanner.nextInt();
            while(option<1 || option > 4){
                System.out.println("Opção inválida, digite novamente entre 1 a 4");
                option = scanner.nextInt();
            }
            switch (option) {
                case 1:
                    geometricForm = createSquare();
                    break;
                case 2:
                    geometricForm = createRectangle();
                    break;
                case 3:
                    geometricForm = createCircle();
                    break;
                default:

                    continue;
            }
            System.out.println("O resultado do cálculo da área final doi de "+ geometricForm.getArea());
        }
    }

    private static GeometricForm createSquare(){
        System.out.println("Informe o tamamnho dos lados:");
        var side = scanner.nextDouble();
        return new Square(side);
    }

    private static GeometricForm createRectangle(){
        System.out.println("Informe a base:");
        var base = scanner.nextDouble();
        System.out.println("Informe a altura:");
        var height = scanner.nextDouble();
        return new Rectangle(height, base);
    }

    private static GeometricForm createCircle(){
        System.out.println("Informe o raio:");
        var radius = scanner.nextDouble();
        return new Circle(radius);
    }
}
