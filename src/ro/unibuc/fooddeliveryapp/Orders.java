package ro.unibuc.fooddeliveryapp;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.Math.max;

public final class Orders {
    @NotNull
    final Restaurants restaurant;
    final Drivers driver;
    final Users users;
    final Date date;
    final int id;
    private static int userCounter = 0;

    public Orders(@NotNull Restaurants restaurant, Drivers driver, Users users, Date date) {
        this.restaurant = restaurant;
        this.driver = driver;
        this.users = users;
        this.date = date;
        userCounter++;
        this.id = userCounter;
    }

    public Orders(final int id, @NotNull Restaurants restaurant, @NotNull Drivers driver, @NotNull Users users, @NotNull Date date) {
        this.restaurant = restaurant;
        this.driver = driver;
        this.users = users;
        this.date = date;
        this.id = id;
        userCounter = max(userCounter, id);
    }


    public int getId() {
        return id;
    }

    public @NotNull Restaurants getRestaurant() {
        return restaurant;
    }

    public Drivers getDriver() {
        return driver;
    }

    public Users getUsers() {
        return users;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "restaurant='" + restaurant + '\'' +
                ", driver='" + driver + '\'' +
                ", users='" + users + '\'' +
                ", date=" + date +
                ", id=" + id +
                '}';
    }

    public String csvParser() {
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return id + ", " + restaurant.id + ", " + driver.id + ", " + users.id + ", " + simpleDateFormat.format(date);
    }
}
