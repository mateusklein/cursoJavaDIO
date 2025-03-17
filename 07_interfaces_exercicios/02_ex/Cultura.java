public record Cultura(Double valor) implements Imposto {
    private static final String NAME = "Imposto sobre cultura";
    
    @Override
    public String getName() { 
        return NAME;
    }

    @Override
    public Double getValor(){
        return valor * 0.04;
    }
}