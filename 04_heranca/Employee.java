public sealed abstract class Employee permits Manager, Salesman{
    //ABSTRACT -> PERMITE QUE OUTRAS CLASSES SEJAM HERDADAS A PARTIR DESSA
    //FINAL -> PROIBE QUE TENHA "FILHOS"
    //SEALED -> DELIMITA AS CLASSES QUE PODERÃO SER GERADAS A PARTIR DELA USANDO O PERMIT
    //QUANDO ESTÁ COMO SEALED AS CLASSES GERADAS A PARTIR DELA DEVERÃO SER NON-SEALED, SEALED OU FINAL
    protected String code;
    protected String name;
    protected String address;
    protected Integer age;
    protected Double salary;
    //PROTECTED -> NÃO PERMITE ACESSO DE FORA DA SUA CLASSE A MENOS QUE A CLASSE QUE ESTEJA TENTANDO FAZER ACESSO ESTEJA HERDANDO ESSA CLASSE


    public Employee(String code, String name, String address, Integer age, Double salary) {
        this.code = code;
        this.name = name;
        this.address = address;
        this.age = age;
        this.salary = salary;
    }

    public Employee(){

    }

    public Double getSalary() {
        return salary;
    }
    public void setSalary(Double salary) {
        this.salary = salary;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }


    //A IMPLEMENTAÇÃO DESSE TIPO DE MÉTODO SE TORNA RESPONSABILIDADE DE QUEM ESTÁ HERDANDO ELE
    public abstract Double getFullSalary();
    
    
    //SOBRECARGA DE MÉTODO (TAMBÉM PODE SER ASSINADO NAS CLASSES FILHAS):
    public Double getFullSalary(double extra) {
        return this.getFullSalary() + extra;
    }
    
}
