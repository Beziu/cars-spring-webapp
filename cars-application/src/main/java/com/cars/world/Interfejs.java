package com.cars.world;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.cars.world.domain.Car;

public class Interfejs {

    static Scanner sc = new Scanner(System.in);
    
    static CarDAO carDAO = new CarDAO();

    public static void main(String[] args) {
        String userChose;
        do {
            System.out.println();
            System.out.println("Chose, what do you want, and press enter:");
            System.out.println("[1] Add new car");
            System.out.println("[2] Show all cars");
            System.out.println("[x] Exit");
            userChose = getUserInput();
            if (userChose.equals("1")) {
                dodajKota();
            } else if (userChose.equals("2")) {
                showCars();
            }
        } while (!userChose.equalsIgnoreCase("x"));
        
    }

    private static void showCars() {
        System.out.println();
        System.out.println("#########################################################");
        System.out.println("######                  CARS LIST                  ######");
        System.out.println("#########################################################");

        Car car;
        for (int i = 0; i < carDAO.getCars().size(); i++) {
            car = carDAO.getCars().get(i);
            System.out.println(i + ": " + car.getName());
        }
        System.out.println();
        Pattern wzorzecNumeru = Pattern.compile("[0-9]+");
        String numberEntered;
        do {
            System.out.print("Which car do you want? ");
            numberEntered = getUserInput();
        } while (!wzorzecNumeru.matcher(numberEntered).matches());

        Integer numberCar = Integer.parseInt(numberEntered);
        if (carDAO.getCars().size()>numberCar) {
            Car chosenCar = carDAO.getCars().get(numberCar);
            System.out.println("Chosen car is: " + chosenCar.getName()
                    + ", costs: " + chosenCar.getPrice()
                    + ", production date is: " + chosenCar.getProductionDate().toString()
                    + ", and engine is: " + chosenCar.getEngine());
        } else {
            System.out.println("Sorry, wrong number. Try again.");
        }

    }

    private static void dodajKota() {
        System.out.println();
        System.out.println("#########################################################");
        System.out.println("######                  ADD A CAR                  ######");
        System.out.println("#########################################################");
        Car car = new Car();
        System.out.print("Podaj imię kota: ");
        car.setName(getUserInput());

        Pattern datePattern = Pattern.compile("[0-9]{4}.[0-1]?[0-9].[0-3]?[0-9]");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        String productionDateEntered;
        do {
            System.out.print("Give a production date in format: RRRR.MM.DD: ");
            productionDateEntered = getUserInput();
            if (datePattern.matcher(productionDateEntered).matches()) {
                try {
                    car.setProductionDate(sdf.parse(productionDateEntered));
                } catch (ParseException pe) {
                    System.out.println("Wrong format od date! Example is: 2014.01.05");
                }
            }
        } while (car.getProductionDate() == null);
        
        Pattern pricePattern = Pattern.compile("[0-9]+(\\.[0-9]+)?");
        String priceEntered;
        do {
            System.out.print("Podaj wagę kota: ");
            priceEntered = getUserInput();
            
            if (pricePattern.matcher(priceEntered).matches()) {
                car.setPrice(Float.valueOf(priceEntered));
            }
        } while (car.getPrice() == null);

        System.out.print("Please give a engine type: ");
        car.setEngine(getUserInput());

        carDAO.addCar(car);
        
        System.out.println("Thank you, entered successful!");

    }

    public static String getUserInput() {
        return sc.nextLine().trim();
    }

}
