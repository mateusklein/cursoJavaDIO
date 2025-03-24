import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import domain.*;

public class main {
    public static void main(String[] args) {
        /* 
        var value1 = Stream.generate(() -> new Random().nextInt())
        .limit(5)
        .toArray(Integer[]::new);

        for(var v:value1){
            System.out.println(v);
        }

        System.out.println("=====================");


        var value2 = IntStream.generate(() -> new Random().nextInt())
        .limit(5)
        .toArray();

        for(var v:value2){
            System.out.println(v);
        }


        System.out.println("=====================");


        var value = Stream.of("Maria", "Joao", "Marcio", "Luana", "Leandro", "Marcia")
        .filter(name -> name.endsWith("a"))
        .toList();

        System.out.println(value);

        List<String> debugValues = new ArrayList<>();
        value = Stream.of("Maria", "Joao", "Marcio", "Luana", "Leandro", "Marcia")
        .peek(debugValues::add)
        .filter(name -> name.endsWith("a"))
        .toList();


        System.out.println(debugValues);

        */

        List<User> users = new ArrayList<>(generateUsers());

        //PARA ORDENAR:
        //users.sort(Comparator.comparing(User::name));

        var values = users.stream()
        .filter(u -> u.contacts().size() >= 2)
        .toList();

        values.forEach(System.out::println);

        System.out.println("=============================");

        var values2 = users.stream()
        .filter(u -> u.contacts() == null || u.contacts().isEmpty())
        .toList();
        
        values2.forEach(System.out::println);


        System.out.println("=============================");

        var values3 = users.stream()
        .filter(u -> u.contacts().stream().anyMatch(c -> c.type() == ContactType.EMAIL))
        .toList();
        
        values3.forEach(System.out::println);


        System.out.println("=============================");

        var values4 = users.stream()
        .flatMap(u -> u.contacts().stream())
        .filter(c -> c.type() == ContactType.EMAIL)
        .sorted(Comparator.comparing(Contacts::description))
        .toList();
        
        values4.forEach(System.out::println);


        System.out.println("=============================");
        
        System.out.println("=======EMAILS===========");
        var values5 = users.stream()
        .flatMap(u -> u.contacts().stream())
        .filter(c -> c.type() == ContactType.EMAIL)
        .map(c -> String.format("{description: '%s', 'type': '%s'}", c.description(), c.type()))
        .toList();
        
        values5.forEach(System.out::println);

        System.out.println("=======NÚMEROS==========");
        var values6 = users.stream()
        .flatMap(u -> u.contacts().stream())
        .filter(c -> c.type() == ContactType.PHONE)
        .map(c -> String.format("{description: '%s', 'type': '%s'}", c.description(), c.type()))
        .toList();
        
        values6.forEach(System.out::println);


        System.out.println("============MAP==============");
        var values7 = users.stream()
        .filter(c -> c.sex() == Sex.FEMALE)
        .collect(Collectors.toMap(User::name, user -> user));
        
        values7.forEach((key, value) -> System.out.printf("key: %s | value: %s \n", key, value));
    
    }


    private static List<User> generateUsers(){
        var contacts1 = List.of(
            new Contacts("(19)91245-1234", ContactType.PHONE),
            new Contacts("joao@gmail.com", ContactType.EMAIL)
        );
        var contacts2 = List.of(
            new Contacts("(21)91255-9875", ContactType.PHONE)
        );
        var contacts3 = List.of(
            new Contacts("lucas@outlook.com", ContactType.EMAIL)
        );
        var contacts4 = List.of(
            new Contacts("andreia@outlook.com", ContactType.EMAIL),
            new Contacts("andreia@gmail.com", ContactType.EMAIL)
        );
        var contacts5 = List.of(
            new Contacts("(31)98909-2345", ContactType.PHONE),
            new Contacts("(31)97764-1255", ContactType.PHONE)
        );
        var user1 = new User("Joao", 26, Sex.MALE, new ArrayList<>(contacts1));
        var user2 = new User("Maria", 28, Sex.FEMALE, new ArrayList<>(contacts2));
        var user3 = new User("Lucas", 19, Sex.MALE, new ArrayList<>(contacts3));
        var user4 = new User("Andreia", 40, Sex.FEMALE, new ArrayList<>(contacts4));
        var user5 = new User("Vitor", 38, Sex.MALE, new ArrayList<>(contacts5));
        var user6 = new User("Bruna", 36, Sex.FEMALE, new ArrayList<>());

        return List.of(user1, user2, user3, user4, user5, user6);
    }
}
