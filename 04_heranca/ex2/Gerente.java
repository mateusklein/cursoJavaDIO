public non-sealed class Gerente extends Usuarios {

    public Gerente(String nome, String email, String senha, Boolean isAdm) {
        super(nome,email,senha, isAdm);
    }

    public Gerente(){

    }

    public void gerarRelatorioFinan(){
        System.out.printf("O gerente %s está gerando um relatório financeiro\n", this.nome);
    }

    public void consultarVendas(){
        System.out.printf("O gerente %s está consultando as vendas\n", this.nome);
    }

    

    @Override
    public Boolean getIsAdm(){
        return true;
    }


}

