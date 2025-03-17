

public record Alimentacao(Double valor) implements Imposto {
    private static final String NAME = "Imposto sobre alimentos";
    
    @Override
    public String getName() { 
        return NAME;
    }

    @Override
    public Double getValor(){
        return valor * 0.01;
    }
}