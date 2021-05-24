package ro.unibuc.fooddeliveryapp;

import org.jetbrains.annotations.NotNull;

import java.sql.Date;

public class Users {
    @NotNull
    protected String userName;
    protected final int id;
    protected final Date birthDate;
    protected String adress;
    private static int userCounter = 0;

    public Users(@NotNull String userName, Date birthDate, String adress) {
        this.userName = userName;
        this.birthDate = birthDate;
        this.adress = adress;
        userCounter++;
        this.id = userCounter;
    }


    public void setUserName(@NotNull String userName) {
        this.userName = userName;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public @NotNull String getUserName() {
        return userName;
    }

    public int getId() {
        return id;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getAdress() {
        return adress;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userName='" + userName + '\'' +
                ", id=" + id +
                ", birthDate=" + birthDate +
                ", adress='" + adress + '\'' +
                '}';
    }
}
