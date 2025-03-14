public non-sealed class Salesman extends Employee {
    private Double percentPerSold;

    private Double souldAmount;

    public Salesman(String code, String name, String address, Integer age, double salary, Double percentPerSold, Double souldAmount) {
        super(code, name, address, age, salary);
        this.percentPerSold = percentPerSold;
        this.souldAmount = souldAmount;
    }

    public Double getSouldAmount() {
        return souldAmount;
    }

    public void setSouldAmount(Double souldAmount) {
        this.souldAmount = souldAmount;
    }

    @Override
    public String getCode(){
        return "SL" + super.getCode();
    }

    public Salesman(){
        
    }


    public Double getPercentPerSold() {
        return percentPerSold;
    }

    public void setPercentPerSold(Double percentPerSold) {
        this.percentPerSold = percentPerSold;
    }   

    //SOBRESCRITA USANDO O CODIGO QUE ELE JA TEM (NA CLASSE PAI -> COMO O MÉTODO É ABSTRATO AQUI É OBRIGADO A IMPLEMENTAR):
    @Override
    public Double getFullSalary(){
        return this.salary + ((souldAmount + percentPerSold)/100);
    }
}
