public record Saude(Double valor) implements Imposto {
    private static final String NAME = "Imposto sobre saude";
    
    @Override
    public String getName() { 
        return NAME;
    }

    @Override
    public Double getValor(){
        return valor * 0.015;
    }
}
