package assignment2;

public class Car {
    // Variables
    static final String[] COLOURS = {"red", "blue", "black", "green", "silver"};
    private String registration;
    private int saleValue;
    private String colour;

    // Default constructor
    public Car(){
        this.saleValue = (int) ((Math.random() * (20000 - 1000)) + 1000);
        this.colour = COLOURS[randomNumber(COLOURS.length - 1, 0)];
        this.registration = generateRegistration();
    }

    // Generate random registration per car
    public String generateRegistration(){
        String[] years = {"182", "151", "221", "191", "142"};
        String[] counties = {"G", "D", "W", "MO", "c"};
        String year = years[randomNumber(years.length - 1, 0)];
        String county = counties[randomNumber(counties.length - 1, 0)];
        int sequence = randomNumber(99999, 10000);
        return year + "-" + county + "-" + sequence;
    }

    // Utility method to generate random number
    public int randomNumber (int max, int min) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    @Override
    public String toString() {
        return colour + " car with registration " + registration + " worth €" + saleValue;
    }
}
