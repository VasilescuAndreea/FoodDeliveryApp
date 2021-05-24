package ro.unibuc.fooddeliveryapp.DataBase;

import ro.unibuc.fooddeliveryapp.Drivers;
import ro.unibuc.fooddeliveryapp.Restaurants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAORestaurants {
    private static Connection dbConnection;
    private static DAORestaurants daoRestaurants;

    private DAORestaurants(){
        try{
            if (dbConnection == null || dbConnection.isClosed()){
//              incarca driverul din mysql
                Class.forName("com.mysql.cj.jdbc.Driver");
                dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:8889/FoodDeliveryApp", "root", "root");
                createTable();
            }
        }catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    private void createTable() {
        final String query = "CREATE TABLE IF NOT EXISTS Restaurants (\n" +
                "id INT PRIMARY KEY , \n" +
                "UserName VARCHAR(64) NOT NULL, \n" +
                "adress VARCHAR(128) NOT NULL, \n"+
                "phone INT(10) NOT NULL)";
        try  {
            Statement statement = dbConnection.createStatement();
            statement.execute(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static DAORestaurants getDaoRestaurants(){
        if(daoRestaurants == null)
            daoRestaurants = new DAORestaurants();
        return daoRestaurants;
    }

    private Restaurants mapToRestaurants(ResultSet resultSet) throws SQLException {
        Restaurants restaurants = new Restaurants(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4));
        return restaurants;
    }

    public void read() {
        List<Restaurants> Restaurants = new ArrayList<>();
        final String query = "SELECT * FROM Restaurants";
        try {
            Statement statement = dbConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Restaurants.add(mapToRestaurants(resultSet));
            }
        } catch (SQLException exception) {
            throw new RuntimeException("Something went wrong while tying to get all Restaurants: ");
        }
    }


    public void write(Restaurants restaurants) {

        final String query = "INSERT into Restaurants(Id, Name, Adress, PhoneNumber) VALUES(?,?,?,?)";
        try {

            PreparedStatement preparedStatement = dbConnection.prepareStatement(query, Statement.NO_GENERATED_KEYS);
            preparedStatement.setInt(1, restaurants.getId());
            preparedStatement.setString(2, restaurants.getName());
            preparedStatement.setString(3, restaurants.getAdress() );
            preparedStatement.setString(4, restaurants.getPhoneNumber());
            preparedStatement.execute();

            }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}









