package keywords;

public class Client {
    //PARA TER ACESSO A UM ATRBIUTO PROTECTED: OU VOCÊ TEM HERANÇA OU ESTÁ NO MESMO PACKAGE
    //PRIVATE É MAIS RESTRITIVO: NADA DE FORA PODE ACESSAR
    //STATIC -> perde a questão do this
    //FINAL -> uma vez declarada não pode ser alterada
    protected String name;
    protected static String staticname;
    protected Integer age;

    public String getName() {
        return name;
    }

    public String getStaticName() {
        return staticname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStaticName(String name) {
        staticname = name;
    }

    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

}
