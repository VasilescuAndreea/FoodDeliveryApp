package ro.unibuc.fooddeliveryapp;

import ro.unibuc.fooddeliveryapp.DataBase.DAODrivers;
import ro.unibuc.fooddeliveryapp.DataBase.DAOOrders;
import ro.unibuc.fooddeliveryapp.DataBase.DAORestaurants;
import ro.unibuc.fooddeliveryapp.DataBase.DAOUsers;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        UsersList usersList = UsersList.getInstance();
        DriversList driversList = DriversList.getInstance();
        RestaurantsList restaurantsList = RestaurantsList.getInstance();
        OrdersList ordersList = OrdersList.getInstance();
        LoggingCsv loggingCsv = LoggingCsv.getInstance();
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
                        Drivers drivers = interogations.addDrivers(in);
                        loggingCsv.case1();
                        driversList.writeData(drivers);
                        break;

                    case 2:
                        System.out.println("You choose to add an order");
                        Orders orders = interogations.addOrders(in);
                        ordersList.writeData(orders);
                        loggingCsv.case2();
                        break;
                    case 3:
                        System.out.println("You choose to add a restaurant");
                        Restaurants restaurants = interogations.addRestaurant(in);
                        restaurantsList.writeData(restaurants);
                        loggingCsv.case3();
                        break;
                    case 4:
                        System.out.println("You choose to add an user");
                        Users users = interogations.addUsers(in);
                        usersList.writeData(users);
                        loggingCsv.case4();
                        break;
                    case 5:
                        System.out.println("Write order number");
                        System.out.println(interogations.getOrdersById(in.nextInt()).toString());
                        loggingCsv.case5();
                        break;
                    case 6:
                        System.out.println("Write restaurant ID ");
                        System.out.println(interogations.getRestaurantsById(in.nextInt()).toString());
                        loggingCsv.case6();
                        break;
                    case 7:
                        System.out.println("Write user ID ");
                        System.out.println(interogations.getUser(in.nextInt()).toString());
                        loggingCsv.case7();
                        break;
                    case 8:
                        System.out.println("The available restaurants are");
                        System.out.println(Admin.restaurants.toString());
                        loggingCsv.case8();
                        break;
                    case 9:
                        System.out.println("All users");
                        System.out.println(Admin.users.toString());
                        loggingCsv.case9();
                        break;
                    case 10:
                        System.out.println("All orders");
                        System.out.println(Admin.orders.toString());
                        loggingCsv.case10();
                        break;
                    default:
                        System.out.println("The option is invalid!");
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Type your option or -1 to leave");
            foo = in.nextInt();
        }
        System.out.println(" Have a nice day! ");
    }
}
