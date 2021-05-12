package ro.unibuc.fooddeliveryapp;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoggingCsv {
    private static LoggingCsv instance = null;
    private final PrintStream writer;

    public void case1() throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        writer.println("New driver has been added: " + formatter.format(date));
    }

    public void case2() throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        writer.println("New order has been added: " + formatter.format(date));
    }

    public void case3() throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        writer.println("New restaurant has been added: " + formatter.format(date));
    }

    public void case4() throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        writer.println("New user has been added: " + formatter.format(date));
    }

    public void case5() throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        writer.println("Somebody asked to view their order: " + formatter.format(date));
    }

    public void case6() throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        writer.println("Somebody asked to view a specific restautant: " + formatter.format(date));
    }

    public void case7() throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        writer.println("Somebody asked to view informations of a specific user : " + formatter.format(date));
    }

    public void case8() throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        writer.println("Somebody asked to all available restaurant: " + formatter.format(date));
    }

    public void case9() throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        writer.println("Somebody asked to view all users: " + formatter.format(date));
    }

    public void case10() throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        writer.println("Somebody asked to view all orders: " + formatter.format(date));
    }

    private LoggingCsv() throws IOException {
        writer = new PrintStream(new FileOutputStream("logs.csv", true));
    }

    public static LoggingCsv getInstance() {
        if (instance == null) {
            try {
                instance = new LoggingCsv();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }
}
