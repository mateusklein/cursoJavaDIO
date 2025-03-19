import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.function.Predicate;

import javax.management.ValueExp;

public class main{
    public static void main(String[] args) {
        /*
        //sem tipagem (APRESENTA WARNINGS)
        List test = new ArrayList();
        test.add("a");
        test.add(1);
        test.add(false);
        
        //com tipagem
        List<String> test2 = new ArrayList<>();
        test2.add("Olá");


        //definindo um array com um tamanho específico (nesse caso 2)
        Integer[] codes = new Integer[2];
        codes[0] = 789;
        codes[1] = 852;

        //outra maneira:
        Integer[] codes2 = {123, 321};
        System.out.println(codes2.length);
        System.out.println(codes2[0]);
        System.out.println(codes2[1]);


        List<Integer> codes3 = new ArrayList<>();
        codes3.add(codes[0]);
        codes3.add(codes[1]);
        codes3.forEach(System.out::println);
        


        List<User> users = new ArrayList<>();
        var user = new User(1,"Jão");
        users.add(user);
        users.add(new User(2, "Maria"));
        users.add(new User(3, "Leo"));
        System.out.println(users.contains(user));
        //quando não usamos o método equals o java verifica se o endereço de memória comparado é o mesmo
        //por essa questão esse código irá gerar um false mesmo contendo o objeto
        //após implementar da maneira certa o .equals da true
        System.out.println(users.contains(new User(1, "Jão")));
        System.out.println(new User(1, "Jão").equals(new User(1, "Jão")));
        System.out.println(users.size());
        System.out.println(users.isEmpty());
        System.out.println(users.getFirst());
        System.out.println(users.getLast());

        


        List<Integer> arrayList = new ArrayList<>();

        var arrayStart = OffsetDateTime.now();
        for(Integer i=0; i<100_000_000; i++){
            arrayList.add(i);
        }
        System.out.println(Duration.between(arrayStart, OffsetDateTime.now()).toMillis());

        var vectorStart = OffsetDateTime.now();
        List<Integer> vector = new Vector<>();
        for(Integer i=0; i<100_000_000; i++){
            vector.add(i);
        }
        System.out.println(Duration.between(vectorStart, OffsetDateTime.now()).toMillis());

        var linkedStart = OffsetDateTime.now();
        List<Integer> linked = new LinkedList<>();
        for(Integer i=0; i<100_000_000; i++){
            linked.add(i);
        }
        System.out.println(Duration.between(linkedStart, OffsetDateTime.now()).toMillis());
        */

        Set<User> users = new HashSet<>();

        users.add(new User(1, "Jão"));
        users.add(new User(2, "Maria"));
        users.add(new User(3, "Lucca"));
        users.add(new User(4, "Leo"));
        users.add(new User(4, "Leo"));
        users.add(new User(4, "Leo"));

        System.out.println(new User(1, "Jão").hashCode());
        System.out.println(users.contains(new User(1, "Jão")));
        
        //Não trabalha com duplicidade
        //Não segue a ordem de inserção
        users.forEach(System.out::println);
        users.removeIf(user -> user.getCode() == 2);

        System.out.println(users);
        
        users.removeIf(Predicate.not(user -> user.getCode() == 3));
        System.out.println(users);



        //trabalha com ordenação
        //não aceita duplicados
        Set<User> users2 = new LinkedHashSet<>();

        users2.add(new User(1, "Jão"));
        users2.add(new User(2, "Maria"));
        users2.add(new User(3, "Lucca"));
        users2.add(new User(4, "Leo"));
        users2.add(new User(4, "Leo"));
        users2.add(new User(4, "Leo"));
        System.out.println(users2);


        Set<User> users3 = new TreeSet<>(Comparator.comparingInt(User::getCode).reversed());

        users3.add(new User(1, "Jão"));
        users3.add(new User(3, "Maria"));
        users3.add(new User(2, "Lucca"));
        users3.add(new User(4, "Leo"));
        users3.add(new User(6, "Leo"));
        users3.add(new User(5, "Leo"));
        System.out.println(users3);
    }
}
