package assignment1.question1;

class Worker {
    public static final int RETIREMENT_AGE = 65;
    private String name = null;
    private int age = 0;
    private float earned = 0.0f;
    private float hourlyIncome = 0.0f;
    private Worker coWorker = null;

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

    public void work() {
        while(age++ < RETIREMENT_AGE)
            work(1600);
    }

    public void work(int hours) {
        for(int i = 1; i<=hours; i++) {
            earned += hourlyIncome;
            if(coWorker!=null && i%5==0)
                delegate(1); // from time to time
        }
    }

    private void delegate(int hours) {
        coWorker.work(hours);
    }

    public String info() {
        return name + " earned " + earned;
    }
}
