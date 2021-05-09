package ro.unibuc.fooddeliveryapp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Interogations implements Admin{
    @Override
    public Orders getOrdersById(int id){
        for(Orders order: orders )
        {
            if(order.getId() == id)
                return order;
        }
        return null;
    }

    @Override
    public Restaurants getRestaurantsById(int id){
        for(Restaurants restaurant: restaurants )
        {
            if(restaurant.getId() == id)
                return restaurant;
        }
        return null;
    }

    @Override
    public Users getUser(int id){
        for(Users user: users )
        {
            if(user.getId() == id)
                return user;
        }
        return null;
    }

    @Override
    public void addOrders(Scanner in) {
        System.out.println("To place a new order please enter the following:");
        System.out.println("Restaurant name");
        String restaurant = in.next();
        System.out.println("Driver name");
        String driver = in.next();
        System.out.println("Username");
        String user = in.next();
        System.out.println("Date yyyy-mm-dd");
        Date date =  parseDate(in);

        Orders order = new Orders(restaurant, driver, user, date);
        orders.add(order);
    }

    @Override
    public void addDrivers(Scanner in) {
        System.out.println("To add a new driver please enter the following:");
        System.out.println("Username");
        String username = in.next();
        System.out.println("Date of birth");
        Date birthDate =  parseDate(in);
        System.out.println("Adress");
        String adress = in.next();

        Drivers driver = new Drivers(username, birthDate, adress);
        users.add(driver);
    }

    @Override
    public void addRestaurant(Scanner in) {
        System.out.println("To add a new restaurant please enter the following:");
        System.out.println("Name");
        String name = in.next();
        System.out.println("Adress");
        String adress = in.next();
        System.out.println("Phone number");
        String phoneNumber = in.next();

        Restaurants restaurant = new Restaurants(name, adress, phoneNumber);
        restaurants.add(restaurant);
    }

    @Override
    public void addUsers(Scanner in) {
        System.out.println("To add a new user please enter the following: ");
        System.out.println("Username");
        String userName = in.next();
        System.out.println("Birthday yyyy-mm-dd");
        Date birthDate =  parseDate(in);
        System.out.println("Adress");
        String adress = in.next();

        Users user = new Users(userName, birthDate, adress);
        users.add(user);
    }

    public void case1() throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        File file = new File("Timestamp.csv");
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter writer = new BufferedWriter(fr);
        writer.write("New driver has been added: " + formatter.format(date));
        writer.newLine();
        writer.close();
        fr.close();
    }

    public void case2() throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        File file = new File("Timestamp.csv");
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter writer = new BufferedWriter(fr);
        writer.write("New order has been added: " + formatter.format(date));
        writer.newLine();
        writer.close();
        fr.close();
    }

    public void case3() throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        File file = new File("Timestamp.csv");
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter writer = new BufferedWriter(fr);
        writer.write("New restaurant has been added: " + formatter.format(date));
        writer.newLine();
        writer.close();
        fr.close();
    }

    public void case4() throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        File file = new File("Timestamp.csv");
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter writer = new BufferedWriter(fr);
        writer.write("New user has been added: " + formatter.format(date));
        writer.newLine();
        writer.close();
        fr.close();
    }

    public void case5() throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        File file = new File("Timestamp.csv");
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter writer = new BufferedWriter(fr);
        writer.write("Somebody asked to view their order: " + formatter.format(date));
        writer.newLine();
        writer.close();
        fr.close();
    }

    public void case6() throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        File file = new File("Timestamp.csv");
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter writer = new BufferedWriter(fr);
        writer.write("Somebody asked to view a specific restautant: " + formatter.format(date));
        writer.newLine();
        writer.close();
        fr.close();
    }

    public void case7() throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        File file = new File("Timestamp.csv");
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter writer = new BufferedWriter(fr);
        writer.write("Somebody asked to view informations of a specific user : " + formatter.format(date));
        writer.newLine();
        writer.close();
        fr.close();
    }

    public void case8() throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        File file = new File("Timestamp.csv");
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter writer = new BufferedWriter(fr);
        writer.write("Somebody asked to all available restaurant: " + formatter.format(date));
        writer.newLine();
        writer.close();
        fr.close();
    }

    public void case9() throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        File file = new File("Timestamp.csv");
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter writer = new BufferedWriter(fr);
        writer.write("Somebody asked to view all users: " + formatter.format(date));
        writer.newLine();
        writer.close();
        fr.close();
    }

    public void case10() throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        File file = new File("Timestamp.csv");
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter writer = new BufferedWriter(fr);
        writer.write("Somebody asked to view all orders: " + formatter.format(date));
        writer.newLine();
        writer.close();
        fr.close();
    }
}



