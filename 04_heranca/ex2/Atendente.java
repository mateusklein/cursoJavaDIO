public non-sealed class Atendente extends Usuarios{
    private Double qtdCaixa;
    

    public Atendente(String nome, String email, String senha, Boolean isAdm, Double qtdCaixa) {
        super(nome,email,senha,isAdm);
        this.qtdCaixa = qtdCaixa;
    }

    public Atendente(){

    }

    public void receberPagamentos(Double qtdCaixa){
        this.qtdCaixa += qtdCaixa;
    }

    public void fecharCaixa(){
        System.out.printf("Total do caixa fechado por %s: %s\n", this.nome, this.qtdCaixa);
    }
    

    @Override
    public Boolean getIsAdm(){
        return false;
    }



    public Double getQtdCaixa() {
        return qtdCaixa;
    }



    public void setQtdCaixa(Double qtdCaixa) {
        this.qtdCaixa = qtdCaixa;
    }
}
