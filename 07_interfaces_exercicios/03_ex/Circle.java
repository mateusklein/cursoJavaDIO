public record Circle(Double radius) implements GeometricForm {
    private static final Double pi = 3.14; 
    
    @Override
    public Double getArea(){
        return pi * (radius * radius); 
    }
}
