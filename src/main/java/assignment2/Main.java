package assignment2;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        // Initialize carShowroom
        CarShowroom carShowroom = new CarShowroom();

        // run carShowroom for 30 days
        int i = 1;
        while (i <= 30){
            // Notify user of new day in carShowroom
            System.out.println("Day " + i + " beginning. There are " + carShowroom.getCars().size() + " cars in the showroom today.");
            i++;

            // Generate between 0 and 3 buyers and sellers per day
            int randomBuyers = (int) ((Math.random() * (3 - 0)) + 0);
            int randomSellers = (int) ((Math.random() * (3 - 0)) + 0);

            for (int j = 0; j <= randomSellers; j++){
                Seller seller = new Seller(carShowroom);
                Thread sellerThread = new Thread(seller);
                sellerThread.start();
            }

            for (int j = 0; j <= randomBuyers; j++){
                Buyer buyer = new Buyer(carShowroom);
                Thread buyerThread = new Thread(buyer);
                buyerThread.start();
            }

            // Add 1 second delay between days
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
