package assignment2;

import java.util.concurrent.atomic.AtomicInteger;

public class Seller implements Runnable{
    private static int sellerID;
    private static AtomicInteger totalSellers;
    private static AtomicInteger totalSales;
    private Car car;
    private CarShowroom carShowroom;

    public Seller(CarShowroom carShowroom){
        this.carShowroom = carShowroom;
        this.car = new Car();
        this.carShowroom.addCar(this.car);
    }

    @Override
    public void run(){
        // Assign new sellerID
        this.sellerID++;
        System.out.println("A new seller #" + id + " just appeared.");
    }
}
