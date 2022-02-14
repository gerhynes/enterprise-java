package assignment2;

import java.util.concurrent.atomic.AtomicInteger;

public class Buyer implements Runnable{
    // variables
    private static int buyerID;
    private static AtomicInteger totalBuyers = new AtomicInteger(0);
    private static AtomicInteger totalPurchases = new AtomicInteger(0);
    private CarShowroom carShowroom;

    // Default constructor
    public Buyer(CarShowroom carShowroom){
        this.carShowroom = carShowroom;
    }

    @Override
    public void run(){
        // Increment totalBuyers and assign new buyerID
        buyerID = totalBuyers.incrementAndGet();
        System.out.println("A new buyer #" + buyerID + " just appeared.");

        // Make these operations thread safe
        synchronized (carShowroom){
            // Ensure buyer can't buy when there are no cars in carShowroom
            while(carShowroom.isEmpty()){
                System.out.println("Buyer #" + buyerID + " wants to buy a car but the showroom is empty.");
                try {
                    // Wait for cars to be added to carShowroom
                    carShowroom.wait();
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Buy car from carShowroom
            Car car = carShowroom.takeCar();

            // Increment total purchases
            totalPurchases.incrementAndGet();

            System.out.println("Buyer #" + buyerID + " bought a " + car.toString() + " from the showroom.");
            System.out.println("This is purchase number " + totalPurchases + ".");

            // Notify other threads
            carShowroom.notify();
        }
    }
}
