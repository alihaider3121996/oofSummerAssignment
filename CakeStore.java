/*
 * Class Name:    CakeStore
 *
 * Student Number:       Khawab raghuvanshi - 20444727
 * 
 * Class Description:       Describe your class here
 *
 */

import java.util.*;
import java.io.*;

public class CakeStore 
{

    //Do not edit attributes
    private Scanner keyboard;
    private DeliveryVehicle deliveryVehicle;
    private int totalEggs;
    private int totalSugarGrams;
    private int totalFlourGrams;
    private int totalMilkMilliLitres;
    private Cake cake1;
    private Cake cake2;
    private Cake cake3;

    //Only edit name and student number in this method
    public static void main(String[] args) throws IOException 
    {
        CakeStore cakeStore = new CakeStore();
        System.out.println("***Khawab raghuvanshi - 20444727");
        System.out.println("***   Cake Store   ***");
        cakeStore.run();
    }

    //Do not edit this method
    public CakeStore() 
    {
        keyboard = new Scanner(System.in);
        deliveryVehicle = null;
        totalEggs = 0;
        totalSugarGrams = 0;
        totalFlourGrams = 0;
        totalMilkMilliLitres = 0;
        cake1 = null;
        cake2 = null;
        cake3 = null;
    }

    //Do not edit this method
    public void run() throws IOException 
    {
        if (loadCakesFromFile()) 
        {
            int choice = -1;
            while (choice != 0) 
            {
                displayMenu();
                System.out.print("Enter choice >> ");
                choice = keyboard.nextInt();
                System.out.println();
                keyboard.nextLine();
                process(choice);
            }
        } 
        else 
        {
            System.out.println("Cakes could not be loaded from file");
        }
    }

    //Do not edit this method
    private boolean loadCakesFromFile() throws IOException 
    {
        boolean fileExists = false;
        System.out.print("Enter name of cake file: ");
        File cakeFile = new File(keyboard.nextLine());

        if (cakeFile.exists()) 
        {
            fileExists = true;
            Scanner cakeFileScanner = new Scanner(cakeFile);
            for (int i = 0; i < 3; i++) 
            {
                String cakeName = cakeFileScanner.nextLine();
                int cakeEggs = cakeFileScanner.nextInt();
                int cakeSugarGrams = cakeFileScanner.nextInt();
                int cakeFlourGrams = cakeFileScanner.nextInt();
                int cakeMilkMilliLitres = cakeFileScanner.nextInt();
                cakeFileScanner.nextLine();

                if (i == 0) 
                {
                    cake1 = new Cake(cakeName, cakeEggs, cakeSugarGrams, cakeFlourGrams, cakeMilkMilliLitres);
                } 
                else if (i == 1) 
                {
                    cake2 = new Cake(cakeName, cakeEggs, cakeSugarGrams, cakeFlourGrams, cakeMilkMilliLitres);
                } 
                else 
                {
                    cake3 = new Cake(cakeName, cakeEggs, cakeSugarGrams, cakeFlourGrams, cakeMilkMilliLitres);
                }
            }
        }
        return (fileExists);
    }

    //Do not edit this method
    private void displayMenu() 
    {
        System.out.println();
        System.out.println("~~~ CAKE MENU ~~~");
        System.out.println("1. Add Order");
        System.out.println("2. Dispatch Vehicle");
        System.out.println("3. Add Delivery Vehicle");
        System.out.println("4. Add Delivery Driver to Vehicle");
        System.out.println("5. Order Stock");
        System.out.println("6. Display Stock");
        System.out.println("7. Display Cakes");
        System.out.println("8. Display Delivery Vehicle");
        System.out.println("9. Display Total Number of Orders");
        System.out.println("0. Quit");
    }

    //Do not edit this method
    private void process(int choice) 
    {
        if (choice == 1) 
        {
            addOrder();
        } 
        else if (choice == 2) 
        {
            dispatchVehicle();
        } 
        else if (choice == 3) 
        {
            addDeliveryVehicle();
        } 
        else if (choice == 4) 
        {
            addDeliveryDriverToVehicle();
        } 
        else if (choice == 5) 
        {
            orderStock();
        } 
        else if (choice == 6) 
        {
            displayStock();
        } 
        else if (choice == 7) 
        {
            displayCakes();
        } 
        else if (choice == 8) 
        {
            displayDeliveryVehicle();
        } 
        else if (choice == 9) 
        {
            displayTotalNumberOfOrders();
        }
    }

    private void addOrder() 
    {
        if (deliveryVehicle == null) 
        {
            System.out.println("No delivery vehicle available");
        } 
        else if (deliveryVehicle.getNumOrdersOnBoard() == 3) 
        {
            System.out.println("Delivery vehicle already full");
        } 
        else 
        {
            printCakeMenu();
            System.out.print("Which cake would you like>> ");
            int selectedNumber = keyboard.nextInt();
            if (selectedNumber == 1 || selectedNumber == 2 || selectedNumber == 3) 
            {
                Cake selectedCake = null;
                if (selectedNumber == 1) 
                {
                    selectedCake = cake1;
                }
                if (selectedNumber== 2)
                {
                    selectedCake = cake2;
                }
                if (selectedNumber == 3)
                {
                    selectedCake = cake3;
                }
                if(selectedCake.getEggs()<=totalEggs && selectedCake.getSugarGrams()<=totalSugarGrams 
                        && selectedCake.getFlourGrams()<=totalFlourGrams && 
                        selectedCake.getMilkMilliLitres()<=totalMilkMilliLitres)
                {
                    totalEggs = totalEggs - selectedCake.getEggs();
                    totalSugarGrams = totalSugarGrams - selectedCake.getSugarGrams();
                    totalFlourGrams = totalFlourGrams - selectedCake.getFlourGrams();
                    totalMilkMilliLitres = totalMilkMilliLitres - selectedCake.getMilkMilliLitres();
                    
                    Scanner stringKeyboard = new Scanner(System.in);
                    System.out.println("Your destination address: ");
                    String address = stringKeyboard.nextLine();
                    Order newOrder = new Order(address, selectedCake);
                    deliveryVehicle.addOrder(newOrder);
                    System.out.println("Order has been added to delivery vehicle.");
                }
                else
                {
                    System.out.println("You don't have enough ingridients left to make the cake.");
                }
            } 
            else 
            {
                System.out.println("User has entered an invalid value");
            }
        }

    }

    private void printCakeMenu() 
    {
        System.out.println("1- "+cake1.getName());
        System.out.println("2- "+cake2.getName());
        System.out.println("3- "+cake3.getName());
    }

    private void dispatchVehicle() 
    {
        if(deliveryVehicle!=null)
        {
            if(deliveryVehicle.hasDriver()==true && deliveryVehicle.getNumOrdersOnBoard()!=0)
            {
                System.out.println(deliveryVehicle.makeDelivery());
            }
            else
            {
                System.out.println("Delivery cannot be dispatched.");
            }
        }
        else
        {
            System.out.println("Delivery vehicle not available.");
       }

    }

    private void addDeliveryVehicle() 
    {
        if(deliveryVehicle!=null)
        {
            System.out.println("Delivery vehile already added.");
        }
        else
        {
            System.out.println("Vehicle ID>> ");
            int vehicleId = keyboard.nextInt();
            deliveryVehicle = new DeliveryVehicle(vehicleId);
            System.out.println("Delivery Vehicle Added.");         
        }
    }

    private void addDeliveryDriverToVehicle() 
    {
        if(deliveryVehicle!=null)
        {
            if(deliveryVehicle.hasDriver()==true)
            {
                System.out.println("Driver is available already.");
            }
            else
            {
                System.out.println("Add Driver name: ");
                String DriverName = keyboard.nextLine();
                Driver driver = new Driver(DriverName);
                deliveryVehicle.setDriver(driver);
                System.out.println("Driver added successfully.");
            }
        }
        else
        {
            System.out.println("Delivery Vehicle not added");
        }

    }

    private void orderStock() 
    {
        displayStock();
        System.out.print("Add sugar(grams)>> ");
        totalSugarGrams = totalSugarGrams + keyboard.nextInt();
        System.out.print("Add flour(grams)>> ");
        totalFlourGrams = totalFlourGrams + keyboard.nextInt();
        System.out.print("Add eggs>> ");
        totalEggs = totalEggs + keyboard.nextInt();
        System.out.print("Add MilkMiliLitre>> ");
        totalMilkMilliLitres = totalMilkMilliLitres + keyboard.nextInt();   
    }

    private void displayStock() 
    {
        System.out.println("Total eggs: "+totalEggs);
        System.out.println("Total flour in grams: "+totalFlourGrams);
        System.out.println("Total sugar in grams: "+totalSugarGrams);
        System.out.println("Total Milk MiliLitres: "+totalMilkMilliLitres);
               
    }

    private void displayCakes() 
    {
        System.out.println("CAKE-1 \n"+cake1.toString());
        System.out.println("CAKE-2 \n"+cake2.toString());
        System.out.println("CAKE-3 \n"+cake3.toString());
    }

    private void displayDeliveryVehicle() 
    {
        if(deliveryVehicle!=null)
        {
            System.out.println("Deliver Vehicle Details \n"+deliveryVehicle.toString());
        }
        else
        {
            System.out.println("Delivery vehicle not available.");
        }
    }

    private void displayTotalNumberOfOrders() 
    {
        System.out.println("Total orders : "+Order.getTotalNumOfOrders());
    }
}
