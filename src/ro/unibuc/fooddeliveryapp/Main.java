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
                switch (foo) {
                    case 1:
                        System.out.println("You choose to add a driver");
                        interogations.addDrivers(in);
                        interogations.case1();
                        break;

                    case 2:
                        System.out.println("You choose to add an order");
                        interogations.addOrders(in);
                        interogations.case2();
                        break;
                    case 3:
                        System.out.println("You choose to add a restaurant");
                        interogations.addRestaurant(in);
                        interogations.case3();
                        break;
                    case 4:
                        System.out.println("You choose to add an user");
                        interogations.addUsers(in);
                        interogations.case4();
                        break;
                    case 5:
                        System.out.println("Write order number");
                        System.out.println(interogations.getOrdersById(in.nextInt()).toString());
                        interogations.case5();
                        break;
                    case 6:
                        System.out.println("Write restaurant ID ");
                        System.out.println(interogations.getRestaurantsById(in.nextInt()).toString());
                        interogations.case6();
                        break;
                    case 7:
                        System.out.println("Write user ID ");
                        System.out.println(interogations.getUser(in.nextInt()).toString());
                        interogations.case7();
                        break;
                    case 8:
                        System.out.println("The available restaurants are");
                        System.out.println(Admin.restaurants.toString());
                        interogations.case8();
                        break;
                    case 9:
                        System.out.println("All users");
                        System.out.println(Admin.users.toString());
                        interogations.case9();
                        break;
                    case 10:
                        System.out.println("All orders");
                        System.out.println(Admin.orders.toString());
                        interogations.case10();
                        break;
                    default:
                        System.out.println("The option is invalid!");
                        break;
                }
            } catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("Type your option");
            foo = in.nextInt();
        }
        System.out.println("Have a nice day!");
    }
}
