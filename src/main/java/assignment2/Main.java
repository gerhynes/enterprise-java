package assignment2;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        // Initialize carShowroom
        CarShowroom carShowroom = new CarShowroom();

        // run carShowroom for 30 days
        int i = 1;
        while (i <= 30){
            System.out.println("Day " + i + " beginning. There are " + carShowroom.getCars().size() + " cars in the showroom today.");
            i++;

            // Generate between 0 and 3 buyers and sellers per day
            int randomInt = (int) ((Math.random() * (3 - 0)) + 0);

            for (int j = 0; j <= randomInt; j++){
               Buyer buyer = new Buyer(carShowroom);
               Thread buyerThread = new Thread(buyer);
               buyerThread.start();
            }

            for (int j = 0; j <= randomInt; j++){
                Seller seller = new Seller(carShowroom);
                Thread sellerThread = new Thread(seller);
                sellerThread.start();
            }


//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}
