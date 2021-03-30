package ro.unibuc.fooddeliveryapp;


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

    public Restaurants getRestaurantsById(int id){
        for(Restaurants restaurant: restaurants )
        {
            if(restaurant.getId() == id)
                return restaurant;
        }
        return null;
    }

    public Users getUser(int id){
        for(Users user: users )
        {
            if(user.getId() == id)
                return user;
        }
        return null;
    }

    public void addOrders(Scanner in) {
        String restaurant = in.next();
        String driver = in.next();
        String user = in.next();
        Date date =  parseDate(in);

        Orders orders = new Orders(restaurant, driver, user, date);
    }

    public void addDrivers(Scanner in) {
        String username = in.next();
        Date birthDate =  parseDate(in);
        String adress = in.next();

        Drivers drivers = new Drivers(username, birthDate, adress);
    }

    public void addRestaurant(Scanner in) {
        String name = in.next();
        String adress = in.next();
        String phoneNumber = in.next();

        Restaurants restaurants = new Restaurants(name, adress, phoneNumber);
    }

    public void addUsers(Scanner in) {
        String userName = in.next();
        Date birthDate =  parseDate(in);
        String adress = in.next();

        Users users = new Users(userName, birthDate, adress);
    }

}
