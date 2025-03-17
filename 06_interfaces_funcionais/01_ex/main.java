import keywords.*;
    
public class main {
    public static void main(String[] args) {
        var user = new Client();
        user.setName("NAME");
        user.setStaticName("STATICNAME");

        var user2 = new Client();
        System.out.println(user.getName());
        System.out.println(user.getStaticName());
        System.out.println("================");
        System.out.println(user2.getName());
        System.out.println(user2.getStaticName()); //aqui nem setou mas como o atributo é estático ele define para todas instâncias

    }
}
