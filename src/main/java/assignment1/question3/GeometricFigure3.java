package assignment1.question3;

abstract class GeometricFigure3 {
    // Variables
    public static final double PI = 3.141592653;
    private boolean filled;

    // Default constructor
    public GeometricFigure3() {
        filled = false;
    }

    // Can be ignored for this example
    public boolean isFilled() {
        return filled;
    }

    // Can be ignored for this example
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    // To be overridden in GenericCircle
    public void display() {
        System.out.println("This is some geometric figure.");
    }

    // To be implemented in GenericCircle
    public abstract NumberDouble calcArea();
}