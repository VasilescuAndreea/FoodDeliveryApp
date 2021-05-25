package ro.unibuc.fooddeliveryapp;

import java.io.*;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;


public class DriversList {
    static DriversList instance = null;
    final PrintStream fout;

    public void readData() throws IOException {
        final String file = "Drivers.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] s = line.replaceAll(" ", "").split(",");
                int id = Integer.parseInt(s[0]);
                Date date = Admin.parseDate(s[1]);
                Drivers drivers = new Drivers(id, s[0], date, s[2], s[3]);
                Admin.users.add(drivers);
            }
        } catch (FileNotFoundException e) {
            //Some error logging
            e.printStackTrace();
        }
    }

    private DriversList() throws IOException {
        fout = new PrintStream(new FileOutputStream("Drivers.csv", true));
        readData();
    }

    public void writeData(Drivers drivers) {
        fout.println(drivers.csvParser());
    }

    public static DriversList getInstance() {
        if (instance == null) {
            try {
                instance = new DriversList();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }
}