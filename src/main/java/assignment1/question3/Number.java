package assignment1.question3;

abstract class Number {
    abstract double getNumber();

    // main method for testing purposes
    public static void main(String[] args) {
        // Initialize circles
        GenericCircle genericCircle1 = new GenericCircle<NumberDouble>(new NumberDouble(6.9));
        GenericCircle genericCircle2 = new GenericCircle<NumberInt>(new NumberInt(6));

        // Calculate circle areas
        NumberDouble area1 = genericCircle1.calcArea();
        NumberDouble area2 = genericCircle2.calcArea();

        // Display circle areas
        genericCircle1.display();
        genericCircle2.display();
    }
}
