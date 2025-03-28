import java.io.IOException;

import persistence.*;

public class Main {
    public static void main(String[] args) throws IOException{
        FilePersistence persistence = new IOFilePersistence("user.csv");
        System.out.println("===================================");
        System.out.println(persistence.write("Jorge;jorge@jorge.com;15/01/1990;"));
        System.out.println(persistence.write("Maria;maria@gmail.com;15/06/1995;"));
        System.out.println(persistence.write("Mateus;Mateus@outlook.com;15/02/1993;"));
        System.out.println(persistence.write("Carlos;Carlos@outlook.com;18/010/1992;"));
        System.out.println("===================================");
        System.out.println(persistence.findAll());
        System.out.println("===================================");
        System.out.println(persistence.findBy("Maria;"));
        System.out.println("===================================");
        System.out.println(persistence.findBy("Mateus@"));
        System.out.println("===================================");
        System.out.println(persistence.findBy("15/01/1990"));
        System.out.println("===================================");
        System.out.println(persistence.remove("Mateus"));
        System.out.println("===================================");
        System.out.println(persistence.remove("15/01/1990"));
        System.out.println("===================================");
        System.out.println(persistence.findAll());
        System.out.println("===================================");
        System.out.println(persistence.replace("Maria", "MariaAlterado;maria@email.com;15/06/1993"));
        System.out.println("===================================");
        System.out.println(persistence.findAll());
    }
}
