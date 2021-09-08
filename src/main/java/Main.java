import cars.Car;
import cars.ShowRoom;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Main {

    ShowRoom showRoom = new ShowRoom();
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Main main = new Main();

        main.showMenu();
    }

    void showMenu() {

        String userInput = "";

        do {
            System.out.println("\nWelcome to the showroom, please choose an activity: ");
            System.out.println("1. Add Car");
            System.out.println("2. View All Cars");
            System.out.println("3. View Single Car");
            System.out.println("4. Remove Car");
            System.out.println("\nEnter Quit to end program....");

            System.out.println("Choose a number:");
            userInput = scanner.nextLine();

            switch (userInput) {
                case "Quit" ,"QUIT", "quit":
                    System.out.println("Exiting Application...");
                    break;
                case "1":
                    addCar();
                    break;
                case "2":
                    viewAllCars();
                    break;
                case "3":
                    viewSingleCar();
                    break;
                default:
                    break;
            }
        } while (!userInput.equalsIgnoreCase("Quit"));

        return;
    }

    void addCar() {
        System.out.println("Add Car");

        Car car = new Car();
        System.out.println("Enter Name:");
        car.name = scanner.nextLine();

        System.out.println("Enter Manufacturer:");
        car.manufacturer = scanner.nextLine();

        System.out.println("Enter Type:");
        car.type = scanner.nextLine();

        car.id = UUID.randomUUID();

        String message = showRoom.addCar(car);

        System.out.println(message);
    }

    void viewAllCars() {
        ArrayList<Car> allCars = showRoom.getAllCars();

        System.out.println("\nAll Available Cars\n");
        System.out.println("Car Name\t Manufacturer\t Car Type");
        for (Car car: allCars) {
            System.out.println(car.name + " \t" + car.manufacturer + " \t" + car.type );
        }

    }

    //Create Method for viewing single car

    void viewSingleCar() {
        //Print Name of method first to show selected method
        System.out.println("View Car");

        //Receive the car id to view from the user
        System.out.println("Please Provide a car ID: ");
        int carIndex = scanner.nextInt();

        //View specified car
        String message = showRoom.getSingleCar(carIndex);
        System.out.println(message);
//        System.out.println("Car Number:" + car.id);
//        System.out.println("Car Name:" + car.name);
//        System.out.println("Car Manufacturer:" + car.manufacturer);
//        System.out.println("Car Type:" + car.type);

        //Print Name of method first to show selected method
        //Receive the car id to view from the user

    }

    void removeCar() {
        System.out.println("Remove Car");
        System.out.println("Please Provide a Car ID");

        int carIndex = scanner.nextInt();

        String message = showRoom.removeCar(carIndex);
        System.out.println(message);
    }

}
