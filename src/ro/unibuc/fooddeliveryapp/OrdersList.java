package ro.unibuc.fooddeliveryapp;
import java.io.*;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
public class OrdersList {
    static OrdersList instance = null;
    final PrintStream fout;

    private void readData() throws IOException {
        final String file = "Orders.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] s = line.replaceAll(" ", "").split(",");
                int id = Integer.parseInt(s[0]);
                int idRestaurant = Integer.parseInt(s[1]);
                int idDriver = Integer.parseInt(s[2]);
                int idUser = Integer.parseInt(s[3]);
                Date date = Admin.parseDate(s[4]);
                Interogations interogations = new Interogations();
                Restaurants restaurants = interogations.getRestaurantsById(idRestaurant);
                Drivers drivers = (Drivers) interogations.getUser(idDriver);
                Users users = interogations.getUser(idUser);
                Orders orders = new Orders(id, restaurants, drivers, users, date);
                Admin.orders.add(orders);
            }
        } catch (FileNotFoundException e) {
            //Some error logging
            e.printStackTrace();
        }
    }

    private OrdersList() throws IOException {
        fout = new PrintStream(new FileOutputStream("Orders.csv", true));
        readData();
    }

    public void writeData(Orders orders) {
        fout.println(orders.csvParser());
    }

    public static OrdersList getInstance() {
        if (instance == null) {
            try {
                instance = new OrdersList();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }
}