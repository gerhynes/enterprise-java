package assignment1.question2;

import java.util.Scanner;

public class Octagon extends GeometricFigure2 implements ConsoleIO, ComparableGeometricFigure<Octagon> {
    // Variables
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
    // Uses area calculation specific to regular octagons
    public double calcArea(){
        // Area of regular octagon = 2 × (side length)² × (1 + sqrt(2))
        return 2 * (side * side) * (1 + Math.sqrt(2)) ;
    }

    // Implements updateFromConsole from ConsoleIO
    // Updates length of octagon side based off user input
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
    // Print octagon side length and total area
    public void writeToConsole(){
        System.out.println("Octagon: side = " + side + " area = " + calcArea());
    }

    // Implements compareTo from ComparableGeometricFigure
    // Compares current octagon with other octagon based on total area
    @Override
    public int compareTo(Octagon otherOctagon) {
        if(area > otherOctagon.calcArea()){
            return 1;
        } else if (area < otherOctagon.calcArea()){
            return -1;
        } else {
            return 0;
        }
    }

    // main method for testing purposes
    public static void main(String[] args) {
        // Initialize octagons
        Octagon octagon1 = new Octagon(12);
        Octagon octagon2 = new Octagon(15);

        // Print octagon values
        octagon1.writeToConsole();
        octagon2.writeToConsole();

        // Update octagon side length from user input
        octagon2.updateFromConsole();

        // Print updated octagon values
        octagon2.writeToConsole();

        // Compare octagon areas and print result
        int result = octagon1.compareTo(octagon2);
        if(result == 1){
            System.out.println("octagon1 has the larger area");
        } else if (result == -1) {
            System.out.println("octagon2 has the larger area");
        } else {
            System.out.println("Both octagons have the same area");
        }
    }
}
