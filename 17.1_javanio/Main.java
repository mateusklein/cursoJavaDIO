import java.io.IOException;

import persistence.*;

public class Main {
    public static void main(String[] args) throws IOException{
        FilePersistence persistence = new NIOFilePersistence("user.csv");
        System.out.println("==============================");
        System.out.println(persistence.write("bianca;bia@bia.com;22/09/1997"));
        System.out.println(persistence.write("bernardo;bernardo@bernardo.com;30/10/2000"));
        System.out.println(persistence.write("ricardo;ric@gmail.com;19/03/2001"));
        System.out.println("==============================");
        System.out.println(persistence.findAll());
        System.out.println("==============================");
        System.out.println(persistence.findBy("bia"));
        System.out.println("==============================");
        System.out.println(persistence.remove("ricardo"));
        System.out.println("==============================");
        System.out.println(persistence.findAll());
        System.out.println("==============================");
        System.out.println(persistence.remove("joana"));
        System.out.println("==============================");
        System.out.println(persistence.findAll());
        System.out.println("==============================");
        System.out.println(persistence.replace("bianca", "newBianca;bianca@gmail.com;22/09/1997"));
        System.out.println("==============================");
        System.out.println(persistence.findAll());
        
    }
}
