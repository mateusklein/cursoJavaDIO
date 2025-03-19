import java.util.HashMap;
import java.util.Map;
import domain.*;
import java.util.TreeMap;
import java.util.LinkedHashMap;

public class main {
    public static void main(String[] args) {
        Map<String, User> users = new HashMap<>();

        users.put("joao@joao.com", new User("Joao", 22));
        users.put("maria@maria.com", new User("Maria", 32));
        users.put("juca@juca.com", new User("Juca", 19));
        users.put("leo@leo.com", new User("leo", 22));

        System.out.println("=========MÉTODO KEYSET E VALUESSET=========");
        System.out.println(users.keySet());
        System.out.println(users.values());

        System.out.println("=========MÉTODO CONTAINS=========");
        System.out.println(users.containsKey("marcos@marcos.com"));
        System.out.println(users.containsValue(new User("Marcos", 40)));
        System.out.println(users.containsKey("joao@joao.com"));
        System.out.println(users.containsValue(new User("Maria", 32)));


        System.out.println("=========MÉTODO REMOVE========");
        System.out.println(users.remove("joao@joao.com"));
        System.out.println(users.remove("leo@leo.com", new User("leo", 22)));



        System.out.println("=========MÉTODO REPLACE=========");
        System.out.println(users.replace("maria@maria.com", new User("MariaNovo", 22)));
        System.out.println(users);



        System.out.println("=========MÉTODO GET=========");
        System.out.println(users.get("maria@maria.com"));


        System.out.println("=========MÉTODO ISEMPTY=========");
        System.out.println(users.isEmpty());


        System.out.println("=========MÉTODO MERGE=========");
        users.merge("maria@maria.com", new User("", -1), (user, user2) -> {
            System.out.println(user);
            System.out.println(user2);
            return user2;
        });
        System.out.println(users);



        System.out.println("=========MÉTODO SIZE=========");
        System.out.println(users.size());

        //ESTRUTURA DE MAPA
        Map<String, User> users2 = new TreeMap<>();
        users2.put("joao@joao.com", new User("Joao", 22));
        users2.put("maria@maria.com", new User("Maria", 32));
        users2.put("juca@juca.com", new User("Juca", 19));
        users2.put("leo@leo.com", new User("leo", 22));

        System.out.println("=========DADOS INSERIDOS COM TREEMAP=========");
        System.out.println(users2);



        //ESTRUTURA DE LISTA LINKADA
        Map<String, User> users3 = new LinkedHashMap<>();
        users3.put("joao@joao.com", new User("Joao", 22));
        users3.put("maria@maria.com", new User("Maria", 32));
        users3.put("juca@juca.com", new User("Juca", 19));
        users3.put("leo@leo.com", new User("leo", 22));

        System.out.println("=========DADOS INSERIDOS COM LINKEDHASMAP=========");
        System.out.println(users3);

    }
}
