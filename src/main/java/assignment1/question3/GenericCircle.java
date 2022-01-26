package assignment1.question3;

public class GenericCircle<T extends Number> extends GeometricFigure3 {
    private T radius;

    // Overloaded constructor
    public GenericCircle(T radius) {
        this.radius = radius;
    }

    // Updated calcArea method
    public NumberDouble calcArea() {
        return radius * radius * Math.PI;
    }

    // Print circle information
    public void display() { // overrides method display() in superclass
        System.out.println("This is a circle with radius " + radius);
    }
}
