package assignment2;

import java.util.concurrent.atomic.AtomicInteger;

public class Buyer implements Runnable{
    // variables
    private static int buyerID;
    private static AtomicInteger totalBuyers = new AtomicInteger();
    private static AtomicInteger totalPurchases = new AtomicInteger();
    private CarShowroom carShowroom;

    // default consturctor
    public Buyer(CarShowroom carShowroom){
        this.carShowroom = carShowroom;
    }

    @Override
    public void run(){
        // Assign new buyerID
        buyerID++;
        System.out.println("A new buyer #" + buyerID + " just appeared.");

        // Make these operations thread safe
        synchronized (carShowroom){
            while(carShowroom.isEmpty()){
                System.out.println("Buyer #" + buyerID + " wants to buy a car but the showroom is empty.");
                try {
                    // wait for cars to be added to carShowroom
                    carShowroom.wait();
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // remove car from carShowroom
            Car car = carShowroom.takeCar();

            // increment total buyers
            totalBuyers.incrementAndGet();
            // increment total purchases
            totalPurchases.incrementAndGet();

            System.out.println("Buyer #" + buyerID + " bought a " + car.toString());
            System.out.println("This is purchase number " + totalPurchases);

            // notify other threads
            carShowroom.notify();
        }
    }
}
