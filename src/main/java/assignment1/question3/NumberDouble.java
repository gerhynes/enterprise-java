package assignment1.question3;

public class NumberDouble extends Number {
    // Variables
    private double value = 0.0;

    // Default constructor
    public NumberDouble(){
        this.value = 0.0;
    }

    // Overloaded constructor
    public NumberDouble(double value){
        this.value = value;
    }

    // Getters and setters
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    // Overrides getNumber from Number
    // Allows access to value stored in NumberDouble
    @Override
    double getNumber() {
        return this.value;
    }
}