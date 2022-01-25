package assignment1.question1;

public class Workaholic extends Worker {
    public static final int RETIREMENT_AGE = 65;
    public static final int OVERTIME = 500;
    private String name = null;
    private int age = 0;
    private float earned = 0.0f;
    private float hourlyIncome = 0.0f;

    // Default constructor
    public Workaholic(){
        this.name = null;
        this.hourlyIncome = 0.0f;
        this.age = 0;
    }

    // Overloaded constructor
    public Workaholic(String name, float hourlyIncome, int age) {
        this.name = name;
        this.hourlyIncome = hourlyIncome;
        this.age = age;
    }

    // Generate hours worked
    @Override
    public void work() {
        while (age++ < RETIREMENT_AGE)
            work(2000);
    }

    // Calculate total earnings
    @Override
    public void work(int hours) {
        // hours and OVERTIME can be combined as hourlyIncome is the same for both
        int totalHoursWorked = hours + OVERTIME;
        for (int i = 1; i <= totalHoursWorked; i++) {
            earned += hourlyIncome;
        }
    }

    // Access workaholic info
    public String info() {
        return name + " earned " + earned;
    }
}
