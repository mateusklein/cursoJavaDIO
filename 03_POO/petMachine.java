public class petMachine {
    Integer MAX_AGUA = 30;
    Integer MAX_SHAMPOO = 10;
    Integer GASTO_SHAMPOO_BANHO = 2;
    Integer GASTO_AGUA_BANHO = 2;
    Integer GASTO_AGUA_LIMPEZA = 3; 
    Integer GASTO_SHAMPOO_LIMPEZA = 1;

    private boolean clean;
    private int water;
    private int shampoo;

    private Pet pet;

    public petMachine(){
        water = 30;
        shampoo = 10;
        clean = true;
        pet = null;
    }

    public void takeAShower(){
        if(this.pet == null){
            System.out.println("Coloque o pet na maquina para iniciar o banho");
            return;
        }
        if(this.water <= GASTO_AGUA_BANHO && this.shampoo <=GASTO_SHAMPOO_BANHO){
            System.out.println("Quantidade de agua e/ou shampoo insuficiente");
            return;
        }
        this.water -= GASTO_AGUA_BANHO;
        this.shampoo -= GASTO_SHAMPOO_BANHO; 
        pet.setClean(true);
        System.out.println("O pet " + pet.getName() + " está limpo");
    }
    

    public void addWater(){
        if(water == MAX_AGUA){
            System.out.println("A capacidade de agua da maquina está no maximo");
            return;
        }
        water += 2;
        System.out.println("Adicionado 2L de agua na máquina");
    }

    public void addShampoo(){
        if(water == MAX_SHAMPOO){
            System.out.println("A capacidade de shampoo da maquina está no maximo");
            return;
        }
        shampoo += 2;
        System.out.println("Adicionado 2L de shampoo na máquina");
    }

    public Integer getShampoo(){
        return shampoo;
    }


    public Integer getAgua(){
        return water;
    }

    public boolean hasPet(){
        return pet != null;
    }

    public void setPet(Pet pet){
        if(!this.clean){
            System.out.println("A máquina está suja, para colocar um pet é necessário limpar");
            return;
        }
        if(hasPet()){
            System.out.println("O pet "+ this.pet.getName() + " está na máquina nesse momento");
            return;
        }
        this.pet = pet; 
        System.out.println("O pet "+ pet.getName() + " foi colocado na máquina");
    }

    public void removePet(){
        if(this.pet == null){
            System.out.println("Não tem nenhum pet na maquina");
            return;
        }
        this.clean = this.pet.isClean(); // se o pet sair limpo, maquina estará limpa, caso sair sujo, a maquina estará suja
        System.out.println("O pet "+ this.pet.getName() + " foi retirado da maquina");
        this.pet = null; 
    }


    public void wash(){
        if(this.water <= GASTO_AGUA_LIMPEZA && this.shampoo <=GASTO_SHAMPOO_LIMPEZA){
            System.out.println("Quantidade de agua e/ou shampoo insuficiente");
            return;
        }
        this.water -= GASTO_AGUA_LIMPEZA;
        this.shampoo -= GASTO_SHAMPOO_LIMPEZA;
        this.clean = true;
    }
}
