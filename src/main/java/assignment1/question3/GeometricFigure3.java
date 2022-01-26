package assignment1.question3;

abstract class GeometricFigure3 {
    public static final double PI = 3.141592653;
    private boolean filled;
    public GeometricFigure3() {
        filled = false;
    }
    public boolean isFilled() {
        return filled;
    }
    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    public void display() {
        System.out.println("This is some geometric figure.");
    }
    public abstract NumberDouble calcArea();
}

