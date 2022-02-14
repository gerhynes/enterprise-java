package assignment2;

import java.util.concurrent.atomic.AtomicInteger;

public class Seller implements Runnable{
    // Variables
    private static int sellerID;
    private static AtomicInteger totalSellers = new AtomicInteger(0);
    private static AtomicInteger totalSales = new AtomicInteger(0);
    private Car car;
    private CarShowroom carShowroom;

    // Default constructor
    public Seller(CarShowroom carShowroom){
        this.carShowroom = carShowroom;
        this.car = new Car();
    }

    @Override
    public void run(){
        // Increment totalSellers and assign new sellerID
        sellerID = totalSellers.incrementAndGet();
        System.out.println("A new seller #" + sellerID + " just appeared.");

        // Make these operations thread safe
        synchronized (carShowroom) {
            // Ensure seller can't sell while carShowroom is full
            while (carShowroom.isFull()){
                System.out.println("Seller " + sellerID + " is trying to sell a car, but the showroom is full.");
                try {
                    // Wait for space in carShowroom
                    carShowroom.wait();
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Sell car to carShowroom
            carShowroom.addCar(car);

            // Increment totalSales
            totalSales.incrementAndGet();

            System.out.println("Seller " + sellerID + " sold their " +car.toString() + " to the showroom.");
            System.out.println("This is sale number " + totalSales + ".");

            // Notify other threads
            carShowroom.notify();
        }
    }
}
