public non-sealed class Manager extends Employee {
    private String login;
    private String password;
    private Double comission;

    
    public Manager(String code, String name, String address, Integer age, double salary, String login, String password, Double comission) {
        super(code, name, address, age, salary);
        this.login = login;
        this.password = password;
        this.comission = comission;
    }

    @Override
    public String getCode(){
        return "MN" + super.getCode();
    }

    public Manager(){
        
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Double getComission() {
        return comission;
    }
    public void setComission(Double comission) {
        this.comission = comission;
    }


    //SOBRESCRITA USANDO O CODIGO QUE ELE JA TEM (NA CLASSE PAI -> COMO O MÉTODO É ABSTRATO AQUI É OBRIGADO A IMPLEMENTAR):
    @Override
    public Double getFullSalary() {
        return this.salary + this.comission;
    }


    
    
}
