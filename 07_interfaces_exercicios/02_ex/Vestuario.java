public record Vestuario(Double valor) implements Imposto {
    private static final String NAME = "Imposto sobre vestuario";
    
    @Override
    public String getName() { 
        return NAME;
    }

    @Override
    public Double getValor(){
        return valor * 0.025;
    }
}