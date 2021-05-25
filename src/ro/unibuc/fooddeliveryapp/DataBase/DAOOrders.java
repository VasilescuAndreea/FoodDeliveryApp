package ro.unibuc.fooddeliveryapp.DataBase;

import ro.unibuc.fooddeliveryapp.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOOrders {
    private static Connection dbConnection;
    private static DAOOrders daoOrders;

    private DAOOrders(){
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
        final String query = "CREATE TABLE IF NOT EXISTS Orders (\n" +
                "Id INT PRIMARY KEY , \n" +
                "RestaurantID INT NOT NULL, \n" +
                "DriverID INT NOT NULL, \n" +
                "UserID INT NOT NULL, \n" +
                "Order_Date DATE NOT NULL, \n " +
                "FOREIGN KEY (RestaurantID) references Restaurants(id),\n " +
                "FOREIGN KEY (DriverID) references Drivers(id), \n" +
                "FOREIGN KEY(UserID) references Users(id))";
        try  {
            Statement statement = dbConnection.createStatement();
            statement.execute(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DAOOrders getDAOOrders(){
        if(daoOrders == null)
            daoOrders = new DAOOrders();
        return daoOrders;
    }

    private Orders mapToOrders(ResultSet resultSet) throws SQLException {
        Interogations interogations = new Interogations();
        Restaurants restaurants = (Restaurants) interogations.getRestaurantsById(resultSet.getInt(2));
        Drivers drivers = (Drivers) interogations.getUser(resultSet.getInt(3));
        Users users = (Users) interogations.getUser(resultSet.getInt(4));
        Date date  = (Date) (resultSet.getDate(5));
        Orders orders = new Orders(resultSet.getInt(1), restaurants, drivers, users, date);
        return orders;
    }

    public void read(){
        final String query = "SELECT Id, RestaurantID, DriverID, UserID, Order_Date FROM Orders";
        try{
            Statement statement = dbConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Admin.orders.add(mapToOrders(resultSet));
            }
        } catch (SQLException exception) {
            throw new RuntimeException("Something went wrong while tying to get all Orders: ");
        }

    }

    public void write(Orders orders) {
        final String query = "INSERT into Orders(Id, RestaurantID, DriverID, UserID, Order_Date ) VALUES(?,?,?,?,?)";
        try {

            PreparedStatement preparedStatement = dbConnection.prepareStatement(query, Statement.NO_GENERATED_KEYS);
            preparedStatement.setInt(1, orders.getId());
            preparedStatement.setInt(2, orders.getRestaurant().getId());
            preparedStatement.setInt(3, orders.getDriver().getId());
            preparedStatement.setInt(4, orders.getUsers().getId());
            preparedStatement.setDate(5, (Date) orders.getDate());
            preparedStatement.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}


