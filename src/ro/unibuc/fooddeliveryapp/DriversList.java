package ro.unibuc.fooddeliveryapp;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class DriversList {
    private ArrayList<Drivers> driversList  = new ArrayList<>();
    public List<String[]> readData() throws IOException {
        int count = 0;
        String file = "Drivers.csv";
        List<String[]> content = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                content.add(line.split(","));
            }
        } catch (FileNotFoundException e) {
            //Some error logging
            e.printStackTrace();
        }
        return content;
    }
}