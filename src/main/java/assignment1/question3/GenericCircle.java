package assignment1.question3;

public class GenericCircle<T extends Number> extends GeometricFigure3 {
    // Variables
    private T radius;

    // Overloaded constructor
    public GenericCircle(T radius) {
        this.radius = radius;
    }

    // Updated calcArea method
    public NumberDouble calcArea() {
        double areaAsDouble = radius.getNumber() * radius.getNumber() * PI;
        NumberDouble areaAsNumberDouble = new NumberDouble(areaAsDouble);
        return areaAsNumberDouble;
    }

    // Overrides display method in GeometricFigure3
    @Override
    public void display() {
        System.out.println("Circle with radius " + radius.getNumber() + " and area: " + calcArea().getNumber());
    }
}