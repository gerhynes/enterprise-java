package assignment2;

import java.util.concurrent.atomic.AtomicInteger;

public class Buyer implements Runnable{
    private static int buyerID;
    private static AtomicInteger totalBuyers;
    private static AtomicInteger totalPurchases;
    private CarShowroom carShowroom;

    public Buyer(CarShowroom carShowroom){
        this.carShowroom = carShowroom;
    }

    @Override
    public void run(){
        // Assign new buyerID
        this.buyerID++;
        System.out.println("A new buyer #" + buyerID + " just appeared.");

        synchronized (carShowroom){
            while(carShowroom.isEmpty()){
                System.out.println("Buyer #" + buyerID + " wants to buy a car but the showroom is empty.");
                carShowroom.wait();
                // wait
            }

            Car car = carShowroom.takeCar();
            carShowroom.notifyAll();
            System.out.println("Buyer #" + buyerID + " bought a " + car.toString());
        }
    }
}
