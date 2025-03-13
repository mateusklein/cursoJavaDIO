import java.util.Scanner;

public class pet_use {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var myPetMachine = new petMachine();
        var myPet = new Pet("Exemplo");
        
        Integer opcao;
        do{
            System.out.println("====================MENU PRINCIPAL=====================");
            System.out.println("1-Dar banho\n2-Abastecer agua\n3-Abastecer shampoo\n4-Verificar nivel agua\n5-Verificar nivel shampoo\n6-Verificar se tem pet no banho\n7-Colocar pet na maquina\n8-Retirar pet da maquina\n9-Limpar maquina\n0-Sair");
            System.out.println("=======================================================");
            System.out.println("Selecione uma opcao:");
            opcao = scanner.nextInt();
            char dir;

            while(opcao < 0 || opcao > 10){
                System.out.println("Opcao invalida, escolha entre 0 e 9");
                opcao = scanner.nextInt();
            }

            Float valor;
            switch (opcao) {
                case 1:
                    System.out.println("\n");
                    System.out.println("========DAR BANHO=========");
                    myPetMachine.takeAShower();
                    System.out.println("\n===============================");
                    System.out.println("\n");
                    break;
                case 2:
                    System.out.println("\n");
                    System.out.println("========ABASTECER AGUA========");
                    myPetMachine.addWater();
                    System.out.println("\n===============================");
                    System.out.println("\n");
                    break;
                case 3:
                    System.out.println("\n");
                    System.out.println("==========================ABASTECER SHAMPOO=========================");
                    myPetMachine.addShampoo();
                    System.out.println("\n===========================================================");
                    System.out.println("\n");
                    break;
                case 4:
                    System.out.println("\n");
                    System.out.println("\n========================VERIFICAR AGUA==============================");
                    System.out.println("Nível da água: "+ myPetMachine.getAgua()+"L");
                    System.out.println("\n===========================================================");
                    System.out.println("\n");
                    break;
                case 5:
                    System.out.println("\n");
                    System.out.println("\n==========================VERIFICAR SHAMPOO=====================");
                    System.out.println("Nível da shampoo: "+ myPetMachine.getShampoo()+"L");
                    System.out.println("\n===========================================================");
                    System.out.println("\n");
                    break;
                case 6:
                    System.out.println("\n");
                    System.out.println("========VERIFICAR SE TEM PET NO BANHO==========");
                    String msg = myPetMachine.hasPet() ? "Há outro pet" : "Não há outro pet no banho";
                    System.out.println(msg);
                    System.out.println("\n=====================================");
                    System.out.println("\n");
                    break;
                case 7:
                    System.out.println("\n");
                    System.out.println("========COLOCAR PET NA MAQUINA==========");
                    System.out.println("Informe o nome do pet:");
                    String name = scanner.next();
                    myPet = new Pet(name);
                    myPetMachine.setPet(myPet);
                    System.out.println("\n=====================================");
                    System.out.println("\n");
                    break;
                case 8:
                    System.out.println("\n");
                    System.out.println("========RETIRAR PET DA MAQUINA==========");
                    myPetMachine.removePet();
                    System.out.println("\n=====================================");
                    System.out.println("\n");
                    break;
                case 9:
                    System.out.println("\n");
                    System.out.println("========LIMPAR MAQUINA==========");
                    myPetMachine.wash();
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
