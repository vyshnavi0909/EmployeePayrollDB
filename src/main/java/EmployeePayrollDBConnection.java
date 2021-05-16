import java.sql.*;

public class EmployeePayrollDBConnection {

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Payroll Database");
        String url = "jdbc:mysql://127.0.0.1:3306/payroll_service";
        String user = "vyshu";
        String password = "vyshu@11";
        String sql = "SELECT * FROM employee_payroll;";
        EmployeePayrollDBConnection employeePayrollDBConnection = new EmployeePayrollDBConnection();
        Connection connection;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            ResultSet  resultSet = statement.executeQuery("SELECT SUM(basic_pay) FROM employee_payroll WHERE gender = 'F' GROUP BY gender;");
            employeePayrollDBConnection.print(resultSet);

            ResultSet resultSet1 = statement.executeQuery("SELECT AVG(basic_pay) FROM employee_payroll WHERE gender = 'F' GROUP BY gender;");
            employeePayrollDBConnection.print(resultSet1);

            ResultSet resultSet2 = statement.executeQuery("SELECT MIN(basic_pay) FROM employee_payroll WHERE gender = 'F' GROUP BY gender;");
            employeePayrollDBConnection.print(resultSet2);

            ResultSet resultSet3 = statement.executeQuery("SELECT MAX(basic_pay) FROM employee_payroll WHERE gender = 'F' GROUP BY gender;");
            employeePayrollDBConnection.print(resultSet3);

            ResultSet resultSet4 = statement.executeQuery("SELECT COUNT(basic_pay) FROM employee_payroll WHERE gender = 'F' GROUP BY gender;");
            employeePayrollDBConnection.print(resultSet4);

            connection.close();
        }catch (ClassNotFoundException | SQLException e){
            throw new IllegalStateException("Cannot find the driver in the classpath", e);
        }
    }

    public void print(ResultSet resultSet) throws SQLException {

        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        while (resultSet.next()){
            System.out.println("{ ");
            for (int i = 1 ; i <= resultSetMetaData.getColumnCount(); i++){
                String columnValue = resultSet.getString(i);
                System.out.print( "   " + resultSetMetaData.getColumnName(i) + ": " +columnValue + ",");
            }
            System.out.println("\n}");
        }
    }
}
