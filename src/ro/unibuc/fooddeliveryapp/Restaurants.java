package ro.unibuc.fooddeliveryapp;

import org.jetbrains.annotations.NotNull;

public class Restaurants {
    @NotNull
    protected String name;
    protected final int id;
    protected String adress;
    protected String phoneNumber;
    private static int userCounter = 0;


    public Restaurants(@NotNull String name, String adress, String phoneNumber) {
        this.name = name;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
        userCounter++;
        this.id = userCounter;
    }

    public int getId() {
        return id;
    }

    public @NotNull String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Restaurants{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", adress='" + adress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
