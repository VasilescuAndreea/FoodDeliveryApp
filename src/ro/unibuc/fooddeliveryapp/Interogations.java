package ro.unibuc.fooddeliveryapp;

import ro.unibuc.fooddeliveryapp.DataBase.DAODrivers;
import ro.unibuc.fooddeliveryapp.DataBase.DAOOrders;
import ro.unibuc.fooddeliveryapp.DataBase.DAORestaurants;
import ro.unibuc.fooddeliveryapp.DataBase.DAOUsers;

import javax.print.DocFlavor;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.Scanner;

public class Interogations implements Admin {
    @Override
    public Orders getOrdersById(int id) {
        for (Orders order : orders) {
            if (order.getId() == id)
                return order;
        }
        return null;
    }

    @Override
    public Restaurants getRestaurantsById(int id) {
        for (Restaurants restaurant : restaurants) {
            if (restaurant.getId() == id)
                return restaurant;
        }
        return null;
    }

    @Override
    public Users getUser(int id) {
        for (Users user : users) {
            if (user.getId() == id)
                return user;
        }
        return null;
    }

    @Override
    public Orders addOrders(Scanner in) {
        System.out.println("To place a new order please enter the following:");
        System.out.println("Restaurant id");
        int restaurantId = Integer.parseInt(in.next());
        System.out.println("Driver id");
        int driverId = Integer.parseInt(in.next());
        System.out.println("UserId");
        int userId = Integer.parseInt(in.next());
        System.out.println("Date yyyy-mm-dd");
        Date date = parseDate(in);

        Orders order = new Orders(getRestaurantsById(restaurantId), (Drivers) getUser(driverId), getUser(userId), date);
        DAOOrders.getDAOOrders().write(order);
        orders.add(order);
        return order;
    }

    @Override
    public Drivers addDrivers(Scanner in) {
        System.out.println("To add a new driver please enter the following:");
        System.out.println("Username");
        String username = in.next();
        System.out.println("Date of birth");
        Date birthDate = parseDate(in);
        System.out.println("Adress");
        String adress = in.next();
        System.out.println("Permis");
        String permis = in.next();

        Drivers driver = new Drivers(username, birthDate, adress, permis);
        DAODrivers.getDAODriver().write(driver);
        users.add(driver);
        return driver;
    }

    @Override
    public Restaurants addRestaurant(Scanner in) {
        System.out.println("To add a new restaurant please enter the following:");
        System.out.println("Name");
        String name = in.next();
        System.out.println("Adress");
        String adress = in.next();
        System.out.println("Phone number");
        String phoneNumber = in.next();

        Restaurants restaurant = new Restaurants(name, adress, phoneNumber);
        DAORestaurants.getDaoRestaurants().write(restaurant);
        restaurants.add(restaurant);
        return restaurant;
    }

    @Override
    public Users addUsers(Scanner in) {
        System.out.println("To add a new user please enter the following: ");
        System.out.println("Username");
        String userName = in.next();
        System.out.println("Birthday yyyy-mm-dd");
        Date birthDate = parseDate(in);
        System.out.println("Adress");
        String adress = in.next();

        Users user = new Users(userName, birthDate, adress);
        DAOUsers.getDaoUsers().write(user);
        users.add(user);
        return user;
    }

}



