package ro.unibuc.fooddeliveryapp.DataBase;

import ro.unibuc.fooddeliveryapp.Drivers;
import ro.unibuc.fooddeliveryapp.Restaurants;
import ro.unibuc.fooddeliveryapp.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAODrivers {
    private static Connection dbConnection;
    private static DAODrivers daoDrivers;

    private DAODrivers() {
        try {
            if (dbConnection == null || dbConnection.isClosed()) {
//                incarca driverul din mysql
                Class.forName("com.mysql.cj.jdbc.Driver");
                dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:8889/FoodDeliveryApp", "root", "root");
                createTable();
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    private void createTable() {
        final String query = "CREATE TABLE IF NOT EXISTS Drivers (\n" +
                "id INT PRIMARY KEY , \n" +
                "mainVechicle VARCHAR(128) NOT NULL, \n" +
                "FOREIGN KEY (id) references Users(id))";
        // Users pentru ca e numele tabelei din baza de date
        try {
            Statement statement = dbConnection.createStatement();
            statement.execute(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DAODrivers getDAODriver() {
        if (daoDrivers == null)
            daoDrivers = new DAODrivers();
        return daoDrivers;
    }

    private Drivers mapToDrivers(ResultSet resultSet) throws SQLException {
        Drivers drivers = new Drivers(resultSet.getInt(1), resultSet.getString(2), resultSet.getDate(3), resultSet.getString(4), resultSet.getString(5));
        return drivers;
    }

    public void read() {
        List<Drivers> Drivers = new ArrayList<>();
        final String query = "SELECT * FROM Drivers";
        try {
            Statement statement = dbConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Drivers.add(mapToDrivers(resultSet));
            }
        } catch (SQLException exception) {
            throw new RuntimeException("Something went wrong while tying to get all Drivers: ");
        }
    }

    public void write(Drivers drivers) {
        final String query = "INSERT into Drivers(Id, mainVehicle) VALUES(?,?)";
        try {

            PreparedStatement preparedStatement = dbConnection.prepareStatement(query, Statement.NO_GENERATED_KEYS);
            preparedStatement.setInt(1, drivers.getId());
            preparedStatement.setString(2, drivers.getMainVehicle());
            preparedStatement.execute();

        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }

//        final String query2 = "INSERT into Users(Id, userName, BirthDate, adress) VALUES(?,?,?,?)";
//        try {
//
//            PreparedStatement preparedStatement2 = dbConnection.prepareStatement(query2, Statement.NO_GENERATED_KEYS);
//            preparedStatement2.setInt(1, Users.getId());
//            preparedStatement2.setString(2, Users.());
//            preparedStatement2.setDate(3, Users.);
//            preparedStatement2.execute();
//
//        }catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
    }
}


