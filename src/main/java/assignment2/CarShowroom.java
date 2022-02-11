package assignment2;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class CarShowroom {
    private int capacity = 5;
    private ArrayList<Car> cars = new ArrayList<Car>();


    public CarShowroom(){

    }

    public Boolean isEmpty(){
        // use ArrayList's built-in isEmpty() method
        return this.cars.isEmpty();
    }

    public Boolean isFull (){
        return this.cars.size() == this.capacity;
    }

    public void addCar(Car car) {
        this.cars.add(car);
    }

    public Car takeCar(){
        return cars.remove(0);
    }
}
