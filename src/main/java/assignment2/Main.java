package assignment2;

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
                // instantiate buyer and seller objects
               Buyer buyer = new Buyer(carShowroom);
               Seller seller = new Seller(carShowroom);

               // instantiate buyer and seller threads
               Thread buyerThread = new Thread(buyer);
               Thread sellerThread = new Thread(seller);

               // start threads
               buyerThread.start();
               sellerThread.start();
            }
        }
    }
}
