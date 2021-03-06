package ro.unibuc.fooddeliveryapp;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Scanner;

public interface Admin {
    //Drivers extends Users
    Orders getOrdersById(int id);

    Restaurants getRestaurantsById(int id);

    Users getUser(int id);

    Orders addOrders(Scanner in);

    Drivers addDrivers(Scanner in);

    Restaurants addRestaurant(Scanner in);

    Users addUsers(Scanner in);


    ArrayList<Orders> orders = new ArrayList<>();
    ArrayList<Restaurants> restaurants = new ArrayList<>();
    ArrayList<Users> users = new ArrayList<>();

    default Date parseDate(Scanner in) {
        try {
            String date = in.next();
            java.util.Date d = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            return new Date(d.getTime());
        } catch (ParseException e) {
            return null;
        }
    }

    static Date parseDate(String date) {
        try {
            //parsarea datei
            java.util.Date d = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            return new Date(d.getTime());
        } catch (ParseException e) {
            return null;
        }
    }
}
