package ro.unibuc.fooddeliveryapp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Interogations interogations = new Interogations();
        System.out.println("To add a new driver please press 1");
        System.out.println("To place an order please press 2");
        System.out.println("To add a new restaurant please press 3");
        System.out.println("To add a new user please press 4");
        System.out.println("To view your order please press 5");
        System.out.println("To view a specific restaurant please press 6");
        System.out.println("To view a specific user please press 7");
        System.out.println("To view all the available restaurants please press 8");
        System.out.println("To view all users please press 9");
        System.out.println("To view all orders please press 10");

        int foo = in.nextInt();

        while (foo > 0) {
            try {
                if (foo == 1) {
                    System.out.println("You choose to add a driver");
                    interogations.addDrivers(in);
                }
                else if (foo == 2) {
                    System.out.println("You choose to add an order");
                    interogations.addOrders(in);
                }
                else if (foo == 3) {
                    System.out.println("You choose to add a restaurant");
                    interogations.addRestaurant(in);
                }
                else if (foo == 4) {
                    System.out.println("You choose to add an user");
                    interogations.addUsers(in);
                }
                else if (foo == 5) {
                    System.out.println("Write order number");
                    System.out.println(interogations.getOrdersById(in.nextInt()).toString());
                }
                else if (foo == 6) {
                    System.out.println("Write restaurant ID ");
                    System.out.println(interogations.getRestaurantsById(in.nextInt()).toString());
                }
                else if (foo == 7) {
                    System.out.println("Write user ID ");
                    System.out.println(interogations.getUser(in.nextInt()).toString());
                }
                else if (foo == 8) {
                    System.out.println("The available restaurants are");
                    System.out.println(Admin.restaurants.toString());
                }
                else if (foo == 9) {
                    System.out.println("All users");
                    System.out.println(Admin.users.toString());
                }
                else if (foo == 10) {
                    System.out.println("All orders");
                    System.out.println(Admin.orders.toString());
                }
            } catch (Exception e){
                System.out.println(e.toString());
            }
            foo = in.nextInt();
        }
    }
}
