package ro.unibuc.fooddeliveryapp;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

public class Drivers extends Users {

    public Drivers(@NotNull String userName, Date birthDate, String adress) {
        super(userName, birthDate, adress);
    }


}
