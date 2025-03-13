


public class record_ex {
    public static void main(String[] args) {
        var person = new Person_record("João");
        System.out.println(person);
        System.out.println(person.name());
        System.out.println(person.age());

        System.out.println(person.getInfo());

        //VALORES NÃO PODEM SER ALTERADOS, UMA VEZ QUE INSTANCIOU
        //OBJETOS IMUTÁVEIS, É COMO SE CRIASSE UMA INSTANCIA FINAL
    }
}
