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
        this.name = "unassigned";
        this.hourlyIncome = 0.0f;
        this.age = 0;
    }

    // Overloaded constructor
    public Workaholic(String name, float hourlyIncome, int age) {
        this.name = name;
        this.hourlyIncome = hourlyIncome;
        this.age = age;
    }

    @Override
    public void work(int hours) {
        for (int i = 1; i <= hours; i++)
            earned += hourlyIncome;
        for (int j = 1; j <= OVERTIME; j++)
            earned += hourlyIncome;
    }

    @Override
    public void work() {
        while (age++ < RETIREMENT_AGE)
            work(2000);
    }

    // info method can be inherited from Worker
}
