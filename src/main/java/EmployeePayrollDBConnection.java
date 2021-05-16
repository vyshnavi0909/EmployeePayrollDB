import java.sql.*;

public class EmployeePayrollDBConnection {

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Payroll Database");
        String url = "jdbc:mysql://127.0.0.1:3306/payroll_service";
        String user = "vyshu";
        String password = "vyshu@11";
        String sql = "SELECT * FROM employee_payroll;";

        Connection connection;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE employee_payroll SET basic_pay = 3000000 WHERE name='Vyshnavi';");
            Statement statement1 = connection.createStatement();
            ResultSet resultSet = statement1.executeQuery(sql);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            while (resultSet.next()){
                System.out.println("{ ");
                for (int i = 1 ; i < resultSetMetaData.getColumnCount(); i++){
                    String columnValue = resultSet.getString(i);
                    System.out.print( "   " + resultSetMetaData.getColumnName(i) + ": " +columnValue + ",");
                }
                System.out.println("\n}");
            }
            connection.close();
        }catch (ClassNotFoundException | SQLException e){
            throw new IllegalStateException("Cannot find the driver in the classpath", e);
        }
    }
}
