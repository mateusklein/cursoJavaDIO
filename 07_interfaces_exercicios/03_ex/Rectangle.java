public record Rectangle(Double height, Double base) implements GeometricForm  {
    @Override
    public Double getArea(){
        return height * base; 
    }
}
