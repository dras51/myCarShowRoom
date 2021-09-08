package cars;

import java.util.ArrayList;

public class ShowRoom {
    private ArrayList<Car> cars = new ArrayList<Car>();

    //addCar
    public String addCar(Car car) {
        this.cars.add(car);
        return car.name + " Added successfully";
    }

    //getAllCars
    public ArrayList<Car> getAllCars() {
        return cars;
    }


    //getSingleCar
//    public Car getSingleCar(int carIndex) {
//        return this.cars.get(carIndex);
//    }

    public String getSingleCar(int carIndex) {
        try {
            Car car = this.cars.get(carIndex);
            return "Car Number: " + car.id + "\nCar Name: " + car.name + "\nCar Manufacturer: " + car.manufacturer + "\nCar Type: " + car.type;

        } catch (Exception ex) {
            return "Unable to find car. Please try again with a valid car index!!!";
        }

    }




    //removeCar
    public String removeCar(int carIndex) {
        try {
            cars.remove(carIndex);
        } catch (Exception ex) {
            return "Unable to remove specified car";
        }
        return "car removed successfully";
    }
}
