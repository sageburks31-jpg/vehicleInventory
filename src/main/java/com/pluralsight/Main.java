package com.pluralsight;

import java.util.*;

public class Main {

    static Scanner scanner=new Scanner(System.in);

    static Vehicle[] vehicles={new Vehicle(101121,"Ford Explorer","Red",45000,13500,true),
            new Vehicle(101122,"Toyota Camry","Blue",60000,11000,true),
            new Vehicle(101123,"Chevrolet Malibu","Black",50000,9700,true),
            new Vehicle(101124,"Honda Civic","White",70000,7500,true),
            new Vehicle(101125,"Subaru Outback","Green",55000,14500,true),
            new Vehicle(101126,"Jeep Wrangler","Yellow",30000,16000,true),
            new Vehicle(),new Vehicle(),new Vehicle(),new Vehicle(),new Vehicle(),new Vehicle(),new Vehicle(),
            new Vehicle(),new Vehicle(),new Vehicle(),new Vehicle(),new Vehicle(),new Vehicle(),new Vehicle()};

    static int vehicleCount=vehicles.length;
    static int activeVehicleCount=6;

    public static void main(String[] args) {
        mainDisplay();
    }

    public static void mainDisplay(){
        System.out.print("""
                What do you want to do?
                1 - List all vehicles
                2 - Search by make/model
                3 - Search by price range
                4 - Search by color
                5 - Add a vehicle
                6 - Quit
                Enter your command:""");
        int commandEntered = scanner.nextInt();
        scanner.nextLine();
        switch (commandEntered){
            case (1)-> listAllVehicles();
            case (2)-> findVehiclesByMakeModel();
            case (3)-> findVehiclesByPriceRange();
            case (4)-> findVehiclesByColor();
            case (5)-> addVehicleToList();
            case (6)-> System.out.print("Program has been ended.");
            default -> {
                System.out.println("Error! invalid command, Please enter a valid command.");
                mainDisplay();
            }
        }
    }

    private static void listAllVehicles() {
        System.out.println("Vehicles in current register:");
        for (Vehicle vehicle: vehicles){
            if (!vehicle.isVehicleExist()) {
                break;
            } else {
                System.out.printf("""
                
                vehicleId: %d
                makeModel: %s
                color: %s
                odometerReading: %d
                price: %.2f
                
                """, vehicle.getVehicleId(), vehicle.getMakeModel(),
                        vehicle.getColor(), vehicle.getOdometerReading(),
                        vehicle.getPrice());
            }
        }
        System.out.print("Enter (R)eturn to return to main menu: ");
        String commandEntered = scanner.nextLine().toLowerCase();
        boolean correctAnswer = false;

        while (!correctAnswer) {
            if (commandEntered.equals("r") || commandEntered.equals("return")) {
                mainDisplay();
                correctAnswer=true;
            }else {
                System.out.println("Error! invalid command, Please enter a valid command.");
            }
        }
    }

    public static void addVehicleToList(){
        Vehicle vehiclespace=null;
        int vehicleIndexKey=0;
        for (Vehicle vehicle: vehicles){
            if (!vehicle.isVehicleExist()){
                vehiclespace=vehicle;
                break;
            }
            vehicleIndexKey++;
        }
        if (vehiclespace==null) {
            System.out.println("current register is full. total vehicles in register: " + vehicleCount);
            mainDisplay();
        } else {
            System.out.println("Space in register found");
            System.out.println("enter vehicleId: ");
            vehicles[vehicleIndexKey].setVehicleId(scanner.nextInt());
            scanner.nextLine();
            System.out.println("enter makeModel: ");
            vehicles[vehicleIndexKey].setMakeModel(scanner.nextLine());
            System.out.println("enter color: ");
            vehicles[vehicleIndexKey].setColor(scanner.nextLine());
            System.out.println("enter odometerReading: ");
            vehicles[vehicleIndexKey].setOdometerReading(scanner.nextInt());
            scanner.nextLine();
            System.out.println("enter price: ");
            vehicles[vehicleIndexKey].setPrice(scanner.nextInt());
            scanner.nextLine();
            activeVehicleCount++;
            vehicles[vehicleIndexKey].setVehicleExist(true);
            displayVehicle(vehicles[vehicleIndexKey]);
        }
    }

    public static void findVehiclesByColor(){
        Vehicle vehicleFound = null;
        System.out.print("Please enter Color here ->: ");
        String Color=scanner.nextLine();

        for (Vehicle vehicle: vehicles){
            if (vehicle.getColor().equals(Color)){
                vehicleFound=vehicle;
                break;
            }
        }
        if (vehicleFound == null) {
            System.out.println("Vehicle not found in current register");
            mainDisplay();
        } else {
            displayVehicle(vehicleFound);
        }
    }

    public static void findVehiclesByPriceRange(){
        Vehicle vehicleFound = null;
        System.out.print("Please enter PriceRange here ->: ");
        double PriceRange=scanner.nextDouble();
        scanner.nextLine();

        for (Vehicle vehicle: vehicles){
            if (vehicle.getPrice()==PriceRange){
                vehicleFound=vehicle;
                break;
            }
        }
        if (vehicleFound == null) {
            System.out.println("Vehicle not found in current register");
            mainDisplay();
        } else {
            displayVehicle(vehicleFound);
        }
    }

    public static void findVehiclesByMakeModel(){
        Vehicle vehicleFound = null;
        System.out.print("Please enter MakeModel here ->: ");
        String MakeModel=scanner.nextLine();

        for (Vehicle vehicle: vehicles){
            if (vehicle.getMakeModel().equals(MakeModel)){
                vehicleFound=vehicle;
                break;
            }
        }
        if (vehicleFound == null) {
            System.out.println("Vehicle not found in current register");
            mainDisplay();
        } else {
            displayVehicle(vehicleFound);
        }
    }

    public static void displayVehicle(Vehicle vehicleFound) {
        System.out.printf("""
                Vehicle found in current register
                vehicleId: %d
                makeModel: %s
                color: %s
                odometerReading: %d
                price: %.2f
                Enter (R)eturn to return to main menu:%s""",
                vehicleFound.getVehicleId(),vehicleFound.getMakeModel(),
                vehicleFound.getColor(),vehicleFound.getOdometerReading(),
                vehicleFound.getPrice()," ");

        String commandEntered = scanner.nextLine().toLowerCase();
        boolean correctAnswer = false;

        while (!correctAnswer) {
            if (commandEntered.equals("r") || commandEntered.equals("return")) {
                mainDisplay();
                correctAnswer=true;
            }else {
                System.out.println("Error! invalid command, Please enter a valid command.");
            }
        }
    }

}