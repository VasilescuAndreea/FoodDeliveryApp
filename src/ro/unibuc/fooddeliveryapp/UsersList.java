package ro.unibuc.fooddeliveryapp;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class UsersList {
    static UsersList instance = null;
    final PrintStream fout;

    private void readData() throws IOException {
        final String file = "Users.csv";
        try {
            Scanner fin = new Scanner(new FileInputStream("Users.csv"));
            while (fin.hasNext()) {
                String[] s = fin.nextLine().replaceAll(" ", "").split(",");
                int id = Integer.parseInt(s[0]);
                Date date = Admin.parseDate(s[1]);
                Users users = new Users(id, s[0], date, s[2]);
                Admin.users.add(users);
            }
        } catch (FileNotFoundException e) {
            //Some error logging
            e.printStackTrace();
        }
    }

    private UsersList() throws IOException {
        fout = new PrintStream(new FileOutputStream("Users.csv", true));
        readData();
    }

    public void writeData(Users users) {
        fout.println(users.csvParser());
    }

    public static UsersList getInstance() {
        if (instance == null) {
            try {
                instance = new UsersList();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }
}