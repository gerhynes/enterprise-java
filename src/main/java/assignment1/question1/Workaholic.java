package assignment1.question1;

public class Workaholic extends Worker {
    // Variables
    public static final int OVERTIME = 500;
    private int hoursWorked = 2000;

    // Default constructor
    public Workaholic(){
        super();
        // ensure hoursWorked includes OVERTIME
        super.setHoursWorked(hoursWorked + OVERTIME);
    }

    // Overloaded constructor
    public Workaholic(String name, float hourlyIncome, int age) {
        super();
        super.setName(name);
        super.setHourlyIncome(hourlyIncome);
        super.setAge(age);
        // ensure hoursWorked includes OVERTIME
        super.setHoursWorked(hoursWorked + OVERTIME);
    }
}
