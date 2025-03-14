/*
Crie uma hierarquia de classes para tratar os tipos de ingresso que podem ser comercializados em um cinema. O ingresso deve 
ter um valor, nome do filme e informar se é dublado ou legendado. A partir desse ingresso devem ser criados os tipos Meia entrada 
e ingresso família. Cada ingresso deve ter um método que retorna o seu valor real ( baseado no valor informado na criação do ingresso) 
para os de meia entrada o seu valor deve ser de metade do valor, para os ingressos família deve-se retornar o valor multiplicado pelonúmero de pessoas e fornecer um desconto de 5% quando o número de pessoas for maior que 3.
*/

public class cinema {
    public static void main(String[] args) {
        printIngresso(new Meia());
        printIngresso(new Familia());
    }

    public static void printIngresso(Ingresso ingresso){
        System.out.printf("================%s==============\n",ingresso.getClass().getCanonicalName());
        switch(ingresso){
            
            case Meia meia ->{
                meia.setValor(20d);
                meia.setFilme("A substancia");
                meia.setDubladoLegend('l');

                System.out.printf("Filme: %s\n", meia.getFilme());
                System.out.printf("Valor real: %s\n", meia.getValor());
                System.out.printf("Valor cobrado: %s\n", meia.getValorTotal());
                System.out.printf("Dublado ou legendado: %s\n", meia.getDubladoLegend());
            }
            case Familia familia ->{
                familia.setValor(25d);
                familia.setFilme("Ainda estou aqui");
                familia.setDubladoLegend('d');
                familia.setQtdPessoas(5);

                System.out.printf("Filme: %s\n", familia.getFilme());
                System.out.printf("Valor real: %s\n", familia.getValor());
                System.out.printf("Valor cobrado: %s\n", familia.getValor());
                System.out.printf("Dublado ou legendado: %s\n", familia.getValorTotal());
                System.out.printf("Quantidade de ingressos (pessoas): %s\n", familia.getQtdPessoas());
            }
        }
        System.out.printf("====================================\n");
    
    }
}
