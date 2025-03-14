/*
Crie uma hierarquia de classes para tratar os tipos de ingresso que podem ser comercializados em um cinema. O ingresso deve 
ter um valor, nome do filme e informar se é dublado ou legendado. A partir desse ingresso devem ser criados os tipos Meia entrada 
e ingresso família. Cada ingresso deve ter um método que retorna o seu valor real ( baseado no valor informado na criação do ingresso) 
para os de meia entrada o seu valor deve ser de metade do valor, para os ingressos família deve-se retornar o valor multiplicado pelo
número de pessoas e fornecer um desconto de 5% quando o número de pessoas for maior que 3.
*/


public sealed abstract class Ingresso permits Meia, Familia{
    protected Double valor;
    protected String filme;
    protected char dubladoLegend;

    public Ingresso(Double valor, String filme, char dubladoLegend) {
        this.valor = valor;
        this.filme = filme;
        this.dubladoLegend = dubladoLegend;
    }

    public Ingresso(){

    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getFilme() {
        return filme;
    }

    public void setFilme(String filme) {
        this.filme = filme;
    }

    public char getDubladoLegend() {
        return dubladoLegend;
    }

    public void setDubladoLegend(char dubladoLegend) {
        this.dubladoLegend = dubladoLegend;
    }

    

}
