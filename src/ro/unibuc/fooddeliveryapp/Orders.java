package ro.unibuc.fooddeliveryapp;
import org.jetbrains.annotations.NotNull;
import java.util.Date;

public class Orders {
    @NotNull
    protected final String restaurant;
    protected final String driver;
    protected final String users;
    protected final Date date;

    public Orders(@NotNull String restaurant, String driver, String users, Date date) {
        this.restaurant = restaurant;
        this.driver = driver;
        this.users = users;
        this.date = date;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public String getDriver() {
        return driver;
    }

    public String getUsers() {
        return users;
    }

    public Date getDate() {
        return date;
    }
}
