package ro.unibuc.fooddeliveryapp.DataBase;

import ro.unibuc.fooddeliveryapp.Admin;
import ro.unibuc.fooddeliveryapp.Drivers;
import ro.unibuc.fooddeliveryapp.Restaurants;
import ro.unibuc.fooddeliveryapp.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOUsers {
    private static Connection dbConnection;
    private static DAOUsers daoUsers;

    private DAOUsers(){
        try{
            if (dbConnection == null || dbConnection.isClosed()){
//                incarca driverul din mysql
                Class.forName("com.mysql.cj.jdbc.Driver");
                dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:8889/FoodDeliveryApp", "root", "root");
                createTable();
            }
        }catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }


    private void createTable() {
        final String query = "CREATE TABLE IF NOT EXISTS Users (\n" +
                "id INT PRIMARY KEY , \n" +
                "userName VARCHAR(64) NOT NULL, \n" +
                "birthDate DATE NOT NULL, \n" +
                "adress VARCHAR(128) NOT NULL)";
        try  {
            Statement statement = dbConnection.createStatement();
            statement.execute(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        public static DAOUsers getDaoUsers(){
        if(daoUsers == null)
            daoUsers = new DAOUsers();
        return daoUsers;
    }

    private Users mapToUsers(ResultSet resultSet) throws SQLException {
        Users users = new Users(resultSet.getInt(1), resultSet.getString(2), resultSet.getDate(3), resultSet.getString(4));
        return users;
    }

    public void read(){
        final String query = "SELECT * FROM Users WHERE id NOT IN (SELECT d.id from Drivers d)";
        try{
            Statement statement = dbConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Admin.users.add(mapToUsers(resultSet));
            }
        } catch (SQLException exception) {
            throw new RuntimeException("Something went wrong while tying to get all Users: ");
        }
    }

    public void write(Users users) {

        final String query = "INSERT into Users(Id, userName, BirthDate, Adress) VALUES(?,?,?,?)";
        try {


            PreparedStatement preparedStatement = dbConnection.prepareStatement(query, Statement.NO_GENERATED_KEYS);
            preparedStatement.setInt(1, users.getId());
            preparedStatement.setString(2, users.getUserName());
            preparedStatement.setDate(3, users.getBirthDate());
            preparedStatement.setString(4, users.getAdress());
            preparedStatement.execute();

        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
