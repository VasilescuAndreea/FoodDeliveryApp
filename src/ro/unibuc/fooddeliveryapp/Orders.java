package ro.unibuc.fooddeliveryapp;
import org.jetbrains.annotations.NotNull;
import java.util.Date;

public class Orders {
    @NotNull
    protected final String restaurant;
    protected final String driver;
    protected final String users;
    protected final Date date;
    protected final int id;
    private static int userCounter = 0;

    public Orders(@NotNull String restaurant, String driver, String users, Date date) {
        this.restaurant = restaurant;
        this.driver = driver;
        this.users = users;
        this.date = date;
        userCounter++;
        this.id = userCounter;
    }

    public int getId() {
        return id;
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
}
