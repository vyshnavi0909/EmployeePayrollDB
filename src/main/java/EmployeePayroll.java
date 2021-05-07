import java.sql.*;
import java.util.Enumeration;

public class EmployeePayroll {

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Payroll Database");
        String url = "jdbc:mysql://127.0.0.1:3306/payroll_service";
        String user = "vyshu";
        String password = "vyshu@11";
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded");
        }catch (ClassNotFoundException e){
            throw new IllegalStateException("Cannot find the driver in the classpath", e);
        }

        listDrivers();

        try {
            System.out.println("Connecting to database: " + url);
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection is successful!! ");
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

    }

    private static void listDrivers() {
        Enumeration<Driver> driverList = DriverManager.getDrivers();
        while (driverList.hasMoreElements()){
            Driver driverClass = (Driver) driverList.nextElement();
            System.out.println(" " + driverClass.getClass().getName());
        }

    }
}
