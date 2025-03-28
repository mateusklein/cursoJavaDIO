import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import javax.xml.validation.Validator;

import br.com.dio.dao.UserDAO;
import br.com.dio.model.UserModel;
import br.com.dio.exception.*;
import br.com.dio.validator.UserValidator;
import java.time.*;
import java.time.format.*;

public class Main {

    private static UserDAO dao = new UserDAO();
    private final static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        while(true){
            System.out.println("\nCadastro de usuários, selecione a operação:");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Buscar por identificador");
            System.out.println("5 - Listar");
            System.out.println("6 - Sair");     
            var userInput = scanner.nextInt();
            var selectedOption = MenuOption.values()[userInput-1];
            switch (selectedOption) {
                case MenuOption.SAVE:
                    System.out.println("============SALVAR===========");
                    try{
                        var user = dao.save(requestToSave());
                        System.out.printf("Usuário salvo %s", user);
                    }catch(CustomException ex){
                        System.out.println(ex.getMessage());
                        ex.printStackTrace();
                    }
                    System.out.println("\n=============================");
                    break;
                case MenuOption.UPDATE:
                    System.out.println("============UPDATE===========");
                    try{
                        var user = dao.update(requestToUpdate());
                        System.out.printf("Usuário atualizado %s", user);
                    }catch(UserNotFoundException | EmptyStorageException ex){
                        System.out.println(ex.getMessage());
                    }catch(ValidatorException ex){  
                        System.out.println(ex.getMessage());
                        ex.printStackTrace();
                    }finally{//ele sempre é executado independente de cair no try ou catch
                        System.out.println("\n===============================");
                    }
                    System.out.println("\n===============================");              
                    break;
                case MenuOption.DELETE:
                    System.out.println("============DELETE===========");
                    try{
                        dao.delete(requestId());
                        System.out.println("Usuário deletado");
                    }catch(UserNotFoundException | EmptyStorageException ex){
                        System.out.println(ex.getMessage());
                    }finally{//ele sempre é executado independente de cair no try ou catch
                        System.out.println("\n===============================");
                    }
                    break;
                case MenuOption.FIND_BY_ID:
                    System.out.println("============PROCURAR===========");
                    try{
                        var id = requestId();
                        var users = dao.findById(id);
                        System.out.printf("Usuário com id %s : %s", id, users);
                    }catch(UserNotFoundException | EmptyStorageException ex){
                        System.out.println(ex.getMessage());
                    }finally{//ele sempre é executado independente de cair no try ou catch
                        System.out.println("\n===============================");
                    }
                    System.out.println("\n===============================");
                    break;
                case MenuOption.FIND_ALL:
                    System.out.println("============LISTAR===========");
                    var users2 = dao.findAll();
                    System.out.printf("Usuários cadastrados:");
                    users2.forEach(System.out::println);
                    System.out.println("\n================================");
                    break;
                case MenuOption.EXIT:
                    System.exit(0);;
                    break;
                default:
                    break;
            }
            
        }
    }

    private static UserModel requestToSave(){
        System.out.println("Informe o nome do usuário:");
        var name = scanner.next();
        System.out.println("Informe o email do usuário:");
        var email = scanner.next();
        System.out.println("Informe a data de nascimento do usuário:");
        var birthday = scanner.next();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthdayConvert = LocalDate.parse(birthday, formatter);
        
        return validateInputs(0, name, email, birthdayConvert);
    }

    private static UserModel validateInputs(final long id, final String name, final String email, final LocalDate birthday) throws ValidatorException{
        var user = new UserModel(0, name, email, birthday);

        try{
            UserValidator.verifyModel(user);
        }catch(ValidatorException ex){
            throw new CustomException("O seu usuário contém erros " + ex.getMessage(), ex);            
        }
        
        return user;
    }

    private static UserModel requestToUpdate(){
        System.out.println("Informe o identificador do usuário:");
        var id = scanner.nextLong();
        System.out.println("Informe o nome do usuário:");
        var name = scanner.next();
        System.out.println("Informe o email do usuário:");
        var email = scanner.next();
        System.out.println("Informe a data de nascimento do usuário:");
        var birthday = scanner.next();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthdayConvert = LocalDate.parse(birthday, formatter);
        return validateInputs(0, name, email, birthdayConvert);
    }


    private static long requestId(){
        System.out.println("Informe o identificador do usuário:");
        return scanner.nextLong();
    }

    
}
