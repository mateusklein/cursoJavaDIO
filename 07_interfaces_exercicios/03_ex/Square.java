public record Square(Double side) implements GeometricForm {
    @Override
    public Double getArea(){
        return side * side; 
    }
}
