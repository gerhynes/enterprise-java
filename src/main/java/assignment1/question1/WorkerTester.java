package assignment1.question1;

public class WorkerTester {
    public static void main(String[] args) {
        Worker jane = new Worker("Jane", 20, 25, null);
        Worker john = new Worker("John", 20, 45, jane);
        Workaholic bill = new Workaholic("Bill", 20, 25);

        john.work();
        jane.work();
        bill.work();

        System.out.println(john.info());
        System.out.println(jane.info());
        System.out.println(bill.info());
    }
}
