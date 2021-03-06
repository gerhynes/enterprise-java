package assignment1.question1;

class Worker {
    // Variables
    public static final int RETIREMENT_AGE = 65;
    private String name = "";
    private int age = 0;
    private float earned = 0.0f;
    private float hourlyIncome = 0.0f;
    private Worker coWorker = null;
    private int hoursWorked = 1600;

    // Default constructor
    public Worker() {
        this.name = "";
        this.hourlyIncome = 0.0f;
        this.age = 0;
        this.coWorker = null;
    }

    // Overloaded constructor
    public Worker(String name, float hourlyIncome, int age, Worker coWorker) {
        this.name = name;
        this.hourlyIncome = hourlyIncome;
        this.age = age;
        this.coWorker = coWorker;
    }

    // Getter and setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getHourlyIncome() {
        return hourlyIncome;
    }

    public void setHourlyIncome(float hourlyIncome) {
        this.hourlyIncome = hourlyIncome;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    // Calculate hours worked
    public void work() {
        while(this.age++ < RETIREMENT_AGE)
            work(hoursWorked);
    }

    // Calculate total earnings and delegate work if coworker available
    public void work(int hours) {
        for(int i = 1; i <= hours; i++) {
            earned += hourlyIncome;
            if(coWorker != null && i % 5 == 0)
                delegate(1); // delegate work from time to time
        }
    }

    // Delegate work to coworker
    private void delegate(int hours) {
        coWorker.work(hours);
    }

    // Access worker info
    public String info() {
        return name + " earned " + earned;
    }

    // main method for testing purposes
    public static void main(String[] args) {
        // Instantiate worker and workaholic instances
        Worker jane = new Worker("Jane", 20, 25, null);
        Worker john = new Worker("John", 20, 45, jane);
        Workaholic bill = new Workaholic("Bill", 20, 25);

        // Generate hours worked
        john.work();
        jane.work();
        bill.work();

        // Display worker info
        System.out.println(john.info());
        System.out.println(jane.info());
        System.out.println(bill.info());
    }
}
