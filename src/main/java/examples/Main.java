package examples;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Random;


// processcontent is a volatile variable so not thread safe
// cpu cycles are wasted in intvortor as it waits to be processed

public class Main {

    private Deque<DataClass> dataDump = new ArrayDeque<>();

    public static void main(String[] args) {
        Main m = new Main();

        m.add( CreateDataClass(1, 10));
        m.add( CreateDataClass(2, 9));
        m.add( CreateDataClass(3, 8));
        m.add( CreateDataClass(4, 7));
        m.engage();
    }

    private void engage() {
        while (dataDump.size() > 0) {
            DataClass dc = dataDump.remove();

            Thread DataProcessorThread = new Thread(new DataProcessor(dc));
            Thread IntvertorrThread = new Thread(new Intvertor(dc));

            DataProcessorThread.start();
            IntvertorrThread.start();
        }

    }

    public void add(DataClass dc) {
        dataDump.add(dc);

    }

    private static DataClass   CreateDataClass(int id, int length) {

        DataClass dc =  new DataClass(id, length);
        return dc;
    }

    private static class DataClass {
        private int id;
        private int length;
        private String invData;

        // this will be the shared resource that both classes feed off
        private volatile String stringProcess;


        public DataClass(int id, int length) {
            this.id = id;
            this.length = length;
        }

        public int getLength() {
            return length;
        }
        public int getId() {
            return id;
        }

        @Override
        public String toString() {
            return "DataClass [id=" + id + ", length=" + length + ", invData=" + invData + ", stringProcess="
                    + stringProcess + "]";
        }

        public void setStringProcess(String stringProcess) {
            System.out.println(stringProcess);
            this.stringProcess = stringProcess;
        }


        public void setinvData(String invData) {
            this.invData = invData;
        }
    }


    static class Intvertor implements Runnable{
        private DataClass dataclass;

        private Intvertor(DataClass dc) {
            this.dataclass = dc;
        }

        @Override
        public void run() {
            synchronized (dataclass) {
                String stringData = dataclass.stringProcess;

                while (stringData == null){
                    try {
                        dataclass.wait();
                    } catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
                String intData = convertData(stringData);
                dataclass.setinvData(intData);
                System.out.println(dataclass.toString());
            }

//            while(true) {
//                String stringData = dataclass.stringProcess;
//                if (stringData !=  null) {
//                    String intData = convertData(stringData);
//                    dataclass.setinvData(intData);
//                    System.out.println(dataclass.toString());
//                    break;
//                }else {
//                    System.out.println(dataclass.getId() + " not created yet");
//                }
//            }
        }

        static  String convertData(String d) {
            StringBuilder buffer;
            buffer =  new StringBuilder(10);

            char[] ca = d.toCharArray();
            for(char c : ca) {
                int temp = (int) c;
                buffer.append(" " + temp);
            }
            System.out.println("string has been processed");
            return buffer.toString();
        }

    }


    static class DataProcessor implements Runnable{
        // this method will do some work on the data generated for this class.
        private DataClass dataclass;

        public DataProcessor(DataClass dc) {
            this.dataclass = dc;
        }

        // perform some manipulation on the data
        public void run() {
            synchronized (dataclass){
            // method that generates  random characters
            String stringProcess = ConstructClass.generateData(dataclass.getLength());
            dataclass.setStringProcess(stringProcess);
            dataclass.notify();
            }
        }
    }
}

class ConstructClass {
    static // utility class
    String generateData(int Length) {

        StringBuilder buffer;

        Random rand = new Random();

        buffer =  new StringBuilder(Length);

        int leftlimit = 97; // letter "a"
        int rightlimit = 122; // letter "z"

        for(int i = 0; i< Length;) {
            int randomLimitInt = leftlimit + (int) (rand.nextFloat()*
                    (rightlimit - leftlimit + 1));

            int variable = rand.nextInt(1100);
            if(variable == 100) {
                buffer.append((char) randomLimitInt);
                i++;}
        }
        return buffer.toString();
    }

}
