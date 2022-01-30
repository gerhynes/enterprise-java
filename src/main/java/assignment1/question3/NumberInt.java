package assignment1.question3;

public class NumberInt extends Number {
    // Variables
    private int value = 0;

    // Default constructor
    public NumberInt(){
        this.value = 0;
    }

    // Overloaded constructor
    public NumberInt(int value){
        this.value = value;
    }

    // Getters and setters
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    // Overrides getNumber from Number
    // Allows access to value stored in NumberInt
    @Override
    double getNumber() {
        return this.value;
    }
}