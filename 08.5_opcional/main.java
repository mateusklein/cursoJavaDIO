import java.util.Optional;

public class main {
    public static void main(String[] args) {
        Optional<User> optional = Optional.of(new User("Joao", 18, SexEnum.MALE));

        Optional<User> optional2 = Optional.ofNullable(null);

        Optional<User> optional3 = Optional.of(new User("Joao", 18, SexEnum.MALE));

        System.out.println(optional.get());

        optional2.ifPresentOrElse(
            user ->  System.out.printf("Usuário: %s", user),
            () -> System.out.printf("Não foi informado um usuário")
        );


        optional3.ifPresentOrElse(
            user ->  {System.out.printf("Usuário: %s", user);
                        user = new User("Joao", 32, SexEnum.MALE);
                        System.out.printf("Usuário: %s", user);
            },
            () -> System.out.printf("Não foi informado um usuário")
        );

        //FORÇA UMA EXCESSÃO CASO SEJA NULO
        System.out.println(optional2.orElseThrow());

        
    }


}
