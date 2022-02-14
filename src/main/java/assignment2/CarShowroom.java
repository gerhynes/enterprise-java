package assignment2;

import java.util.ArrayList;

public class CarShowroom {
    // Variables
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

    // Check if there are cars in the showroom
    public Boolean isEmpty(){
        // Use ArrayList's built-in isEmpty() method
        return this.cars.isEmpty();
    }

    // Check if the showroom is full
    public Boolean isFull (){
        return this.cars.size() == this.capacity;
    }

    // Sell a car to the showroom
    public synchronized void addCar(Car car) {
        this.cars.add(car);
    }

    // Buy a car from the showroom
    public synchronized Car takeCar() {
        return this.cars.remove(0);
    }
}
