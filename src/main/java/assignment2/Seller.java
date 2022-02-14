package assignment2;

import java.util.concurrent.atomic.AtomicInteger;

public class Seller implements Runnable{
    // variables
    private static AtomicInteger sellerID = new AtomicInteger();
    private static AtomicInteger totalSellers = new AtomicInteger();
    private static AtomicInteger totalSales = new AtomicInteger();
    private Car car;
    private CarShowroom carShowroom;

    // default constructor
    public Seller(CarShowroom carShowroom){
        this.carShowroom = carShowroom;
        this.car = new Car();
        this.carShowroom.addCar(this.car);
    }

    @Override
    public void run(){
        // Assign new sellerID
        sellerID.incrementAndGet();
        System.out.println("A new seller #" + sellerID + " just appeared.");

        synchronized (carShowroom) {
            while (carShowroom.isFull()){
                System.out.println("Seller " + sellerID + " is trying to sell a car, but the showroom is full.");
                try {
                    // wait for space in carShowroom
                    carShowroom.wait();
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // add car to carShowroom
            carShowroom.addCar(car);

            // increment totalSellers
            totalSellers.incrementAndGet();
            // increment totalSales
            totalSales.incrementAndGet();

            System.out.println("Seller " + sellerID + " sold their " +car.toString() + " to the showroom.");
            System.out.println("This is sale number " + totalSales);

            // notify other threads
            carShowroom.notify();
        }
    }
}
