/*
Crie uma hierarquia de classes para tratar os tipos de ingresso que podem ser comercializados em um cinema. O ingresso deve 
ter um valor, nome do filme e informar se é dublado ou legendado. A partir desse ingresso devem ser criados os tipos Meia entrada 
e ingresso família. Cada ingresso deve ter um método que retorna o seu valor real ( baseado no valor informado na criação do ingresso) 
para os de meia entrada o seu valor deve ser de metade do valor, para os ingressos família deve-se retornar o valor multiplicado pelo
número de pessoas e fornecer um desconto de 5% quando o número de pessoas for maior que 3.
*/


public non-sealed class Familia extends Ingresso{
    private Integer qtdPessoas;

    public Familia(Double valor, String filme, char dubladoLegend, Integer qtdPessoas){
        super(valor, filme, dubladoLegend);
        this.qtdPessoas = qtdPessoas;
    }

    public Familia(){

    }

    public Integer getQtdPessoas() {
        return qtdPessoas;
    }

    public void setQtdPessoas(Integer qtdPessoas) {
        this.qtdPessoas = qtdPessoas;
    }

    //@Override 
    public double getValorTotal() {
        double total = this.valor * this.qtdPessoas;
        
        if (this.qtdPessoas > 3) { 
            total *= 0.95;  
        }

        return total;
    }

}
