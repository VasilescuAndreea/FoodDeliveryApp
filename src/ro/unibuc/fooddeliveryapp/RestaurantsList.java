package ro.unibuc.fooddeliveryapp;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RestaurantsList {
    static RestaurantsList instance = null;
    final PrintStream fout;

    private void readData() throws IOException {
        final String file = "Restaurants.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] s = line.replaceAll(" ", "").split(",");
                int id = Integer.parseInt(s[0]);
                Restaurants restaurants = new Restaurants(id, s[0], s[1], s[2]);
                Admin.restaurants.add(restaurants);
            }
        } catch (FileNotFoundException e) {
            //Some error logging
            e.printStackTrace();
        }
    }

    public void writeData(Restaurants restaurant) {
        fout.println(restaurant.csvParser());
    }

    private RestaurantsList() throws IOException {
        fout = new PrintStream(new FileOutputStream("Restaurants.csv", true));
        readData();
    }

    public static RestaurantsList getInstance() {
        if (instance == null) {
            try {
                instance = new RestaurantsList();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }
}
