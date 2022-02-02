package assignment2;

public class Car {
    static final String[] COLOURS = {"red", "blue", "black", "green", "silver"};
    private String registration;
    private int saleValue;
    private String colour;

    public Car(){
        this.registration = "";
        this.saleValue = (int) ((Math.random() * (20000 - 1000)) + 1000);
        this.colour = COLOURS[randomNumber(COLOURS.length -1, 0)];
        this.registration = generateRegistration();
    }

    public String generateRegistration(){
        String[] years = {"10", "15", "22", "19", "14"};
        String[] counties = {"G", "D", "W", "MO", "c"};
        String year = years[randomNumber(years.length - 1, 0)];
        String county = counties[randomNumber(counties.length -1, 0)];
        int sequence = randomNumber(99999, 10000);
        return year + county + sequence;
    }

    public int randomNumber (int max, int min) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    @Override
    public String toString() {
        return colour + " car with registration " + registration + " worth €" + saleValue;
    }
}
