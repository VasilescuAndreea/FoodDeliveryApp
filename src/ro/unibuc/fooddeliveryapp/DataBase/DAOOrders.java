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
                "UsersID INT NOT NULL, \n" +
                "Order_Date DATE NOT NULL, \n " +
                "FOREIGN KEY (RestaurantID) references Restaurants(id),\n " +
                "FOREIGN KEY(UsersID) references Users(id))";
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
        final String query = "SELECT * FROM Restaurants WHERE id = ?";
        Interogations interogations = new Interogations();
        Restaurants restaurants = (Restaurants) interogations.getRestaurantsById(resultSet.getInt(2));
        Drivers drivers = (Drivers) interogations.getUser(resultSet.getInt(3));
        Users users = (Users) interogations.getUser(resultSet.getInt(4));
        Date date  = (Date) (resultSet.getDate(5));
        Orders orders = new Orders(resultSet.getInt(1), restaurants, drivers, users, date);
        return orders;
    }

    public void read(){
        List<Orders> Orders  = new ArrayList<>();
        final String query = "SELECT * FROM Orders";
        try{
            Statement statement = dbConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Orders.add(mapToOrders(resultSet));
            }
        } catch (SQLException exception) {
            throw new RuntimeException("Something went wrong while tying to get all Orders: ");
        }

    }

    public void write(Orders orders) {
        final String query = "INSERT into Orders(Id, Driver, User, Date ) VALUES(?,?,?,?)";
        try {

            PreparedStatement preparedStatement = dbConnection.prepareStatement(query, Statement.NO_GENERATED_KEYS);
            preparedStatement.setInt(1, orders.getId());
            preparedStatement.setInt(2, orders.getDriver().getId());
            preparedStatement.setInt(3, orders.getUsers().getId());
            preparedStatement.setDate(4, orders.getDate());
            preparedStatement.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}


