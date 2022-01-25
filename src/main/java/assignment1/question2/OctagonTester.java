package assignment1.question2;

public class OctagonTester {
    public static void main(String[] args) {
        // Initialize octagons
        Octagon octagon1 = new Octagon(12);
        Octagon octagon2 = new Octagon(15);

        // Print octagon values
        octagon1.writeToConsole();
        octagon2.writeToConsole();

        // Update side from user input
        octagon2.updateFromConsole();

        // Print updated octagon values
        octagon2.writeToConsole();

        // Compare octagon areas
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
