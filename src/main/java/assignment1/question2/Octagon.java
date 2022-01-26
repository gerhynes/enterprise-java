package assignment1.question2;

import java.util.Scanner;

public class Octagon extends GeometricFigure2 implements ConsoleIO, ComparableGeometricFigure<GeometricFigure2> {
    private double side = 0.0;
    private double area = 0.0;

    // Default constructor
    public Octagon(){
        this.side = 0.0;
        this.area = 0.0;
    }

    // Overloaded constructor
    public Octagon(double side){
        this.side = side;
        this.area = calcArea();
    }

    // Getters and Setters
    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    // Implements calcArea from GeometricFigure2
    public double calcArea(){
        // Area of regular octagon = 2 × (side length)² × (1 + sqrt(2))
        return 2 * (side * side) * (1 + Math.sqrt(2)) ;
    }

    // Implements updateFromConsole from ConsoleIO
    public void updateFromConsole(){
        // Initialize scanner
        Scanner scanner = new Scanner(System.in);

        // Take in new value and update
        System.out.println("Enter a value for one side of the Octagon: ");
        double newSide = scanner.nextInt();
        setSide(newSide);

        // Alert user to update
        System.out.println("Octagon updated");

        // Close scanner to prevent memory leak
        scanner.close();
    }

    // Implements writeToConsole from ConsoleIO
    public void writeToConsole(){
        System.out.println("Octagon: side = " + side + " area = " + calcArea());
    }

    // Implements compareTo from ComparableGeometricFigure
    // TODO make sure compareTo only works for Octagons
    @Override
    public int compareTo(GeometricFigure2 otherFigure) {
        if(area > otherFigure.calcArea()){
            return 1;
        } else if (area < otherFigure.calcArea()){
            return -1;
        } else {
            return 0;
        }
    }
}
