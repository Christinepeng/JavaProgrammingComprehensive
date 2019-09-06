package Hw7;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class CustomerDB {
    private static final String DATABASE_URL = "jdbc:derby:/Users/pengyiying/GoogleDrive/UCSC/Spring_2019/Java_Programming_Comprehensive/others/JavaProgrammingComprehensivelib/BineetDB";

    private List<Customer> customerList;
    private Connection connection;
    private Statement statement;

    public CustomerDB() {
        customerList = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(DATABASE_URL);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Customer> getCustomerList() {
        final String SELECT_QUERY = "SELECT * FROM Customers ORDER BY Customers.EmailAddress";
        try {
            ResultSet resultSet = statement.executeQuery(SELECT_QUERY);

            while (resultSet.next()) {
                String email = resultSet.getString("EmailAddress");
                String firstName = resultSet.getString("FirstName");
                String lastName = resultSet.getString("LastName");

                System.out.println(String.format("%-25s %-15s %-15s", email, firstName, lastName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customerList;
    }

    public void addCustomer(Customer customer) {
        String INSERT_QUERY = "INSERT INTO Customers " +
                "(EmailAddress, FirstName, LastName) " +
                "VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_QUERY);
            ps.setString(1, customer.getEmailAddress());
            ps.setString(2, customer.getFirstName());
            ps.setString(3, customer.getLastName());
            ps.executeUpdate();

            System.out.println("JDBC Test was added to the database.\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delCustomer(String email) {
        String DELETE_QUERY =
                "DELETE FROM Customers " +
                        "WHERE EmailAddress = ?";
        try {
            PreparedStatement ps =
                    connection.prepareStatement(DELETE_QUERY);
            ps.setString(1,email);
            ps.executeUpdate();

            System.out.println("JDBC Test was deleted from the database.\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}