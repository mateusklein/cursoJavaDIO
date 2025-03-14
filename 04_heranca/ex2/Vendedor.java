public non-sealed class Vendedor extends Usuarios {

    private Integer qtdVendas;

    public Vendedor(String nome, String email, String senha, Boolean isAdm, Integer qtdVendas) {
        super(nome,email,senha, isAdm);
        this.qtdVendas = qtdVendas;
    }

    public Vendedor(){
        
    }

    public void realizarVenda(){
        qtdVendas++;
        System.out.printf("O vendedor %s realizou uma venda\n", this.nome);
    }

    public void consultarVendas(){
        System.out.printf("Quantidade total de vendas realizadas por %s: %s\n", this.nome, this.qtdVendas);
    }

    @Override
    public Boolean getIsAdm(){
        return false;
    }

    public Integer getQtdVendas() {
        return qtdVendas;
    }

    public void setQtdVendas(Integer qtdVendas) {
        this.qtdVendas = qtdVendas;
    }
    

}
