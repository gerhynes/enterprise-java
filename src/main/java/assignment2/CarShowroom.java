package assignment2;

import java.util.ArrayList;


public class CarShowroom {
    // variables
    private int capacity;
    private ArrayList<Car> cars;

    // Default constructor
    public CarShowroom(){
        this.capacity = 5;
        this.cars = new ArrayList<Car>();
    }

    // Getters and setters
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }

    // check if there are cars in the showroom
    public Boolean isEmpty(){
        // use ArrayList's built-in isEmpty() method
        return this.cars.isEmpty();
    }

    // check if the showroom is full
    public Boolean isFull (){
        return this.cars.size() == this.capacity;
    }

    // add a car to the showroom
    public void addCar(Car car) {
        synchronized (cars){
            if(!isFull()){
                this.cars.add(car);
            }
        }
    }

    // take a car from the showroom
    public Car takeCar(){
        synchronized (cars) {
            if(!isEmpty()){
                return this.cars.remove(0);
            }
        }
        return null;
    }
}
