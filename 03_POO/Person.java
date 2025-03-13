import java.time.OffsetDateTime;

public class Person {
    private String name;

    private int age;

    public Person(String name){
        this.name = name;
        this.age = 1;
    }

    private int incAgeVar = OffsetDateTime.now().getYear(); 


    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    private static String teste;


    public static void setTeste(String teste_param){
        teste = teste_param;
    }

    public static String getTeste(){
        return teste;
    }


    public void incAge(){
        if(this.incAgeVar >= OffsetDateTime.now().getYear()) return;

        this.age += 1;
        this.incAgeVar = OffsetDateTime.now().getYear();
    }
}
