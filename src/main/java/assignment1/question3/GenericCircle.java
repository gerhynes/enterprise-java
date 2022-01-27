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
        double areaDouble = radius.getNumber() * radius.getNumber() * PI;
        NumberDouble areaNumberDouble = new NumberDouble(areaDouble);
        return areaNumberDouble;
    }

    // Overrides display method in GeometricFigure3
    @Override
    public void display() {
        System.out.println("This is a circle with radius " + radius.getNumber());
    }
}
