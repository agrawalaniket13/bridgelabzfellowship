package com.bridgelabz;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeePayrollDBService {
    public enum StatementType {
        PREPARED_STATEMENT, STATEMENT
    }

    private PreparedStatement employeePayrollDataStatement;
    private static EmployeePayrollDBService employeePayrollDBService;

    private EmployeePayrollDBService() {

    }

    public static EmployeePayrollDBService getInstance() {
        if (employeePayrollDBService == null)
            employeePayrollDBService = new EmployeePayrollDBService();
        return employeePayrollDBService;
    }

    /**
     * @return employee data list which is read from database
     */
    public List<EmployeePayrollData> readData() {
        String sql = "SELECT * FROM employee_payroll_details;";
        return this.getEmployeePayrollDataUsingSQLQuery(sql);
    }

    /**
     * Prepared statement for retrieving employee data
     */
    private void preparedStatementForEmployeeData() {
        try {
            Connection connection = this.getConnection();
            String sql = "Select * from employee_payroll_details WHERE name = ?";
            employeePayrollDataStatement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param name
     * @return employee payroll list using prepared statement
     */
    public List<EmployeePayrollData> getEmployeePayrollData(String name) {
        List<EmployeePayrollData> employeePayrollList = null;
        if (this.employeePayrollDataStatement == null)
            this.preparedStatementForEmployeeData();
        try {
            employeePayrollDataStatement.setString(1, name);
            ResultSet resultSet = employeePayrollDataStatement.executeQuery();
            employeePayrollList = this.getEmployeePayrollData(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeePayrollList;

    }

    /**
     * @param sql query
     * @return employee payroll list
     */
    public List<EmployeePayrollData> getEmployeePayrollDataUsingSQLQuery(String sql){
        List<EmployeePayrollData> employeePayrollList = new ArrayList<EmployeePayrollData>();
        try(Connection connection = this.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            employeePayrollList = this.getEmployeePayrollData(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeePayrollList;
    }

    private List<EmployeePayrollData> getEmployeePayrollData(ResultSet resultSet) {
        List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double salary = resultSet.getDouble("salary");
                LocalDate startDate = resultSet.getDate("start").toLocalDate();
                employeePayrollList.add(new EmployeePayrollData(id, name, salary, startDate));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeePayrollList;
    }

    public int updateEmployeeData(String name, double salary, StatementType type) {
        switch (type) {
            case STATEMENT:
                return this.updateDataUsingStatement(name, salary);
            case PREPARED_STATEMENT:
                return this.updateDataUsingPreparedStatement(name, salary);
            default:
                return 0;
        }
    }

    private int updateDataUsingStatement(String name, double salary) {
        String sql = String.format("UPDATE employee_payroll_details SET salary = %.2f where name = '%s';", salary, name);
        try (Connection connection = this.getConnection();) {
            Statement statement = connection.createStatement();
            return statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private int updateDataUsingPreparedStatement(String name, double salary) {
        String sql = "UPDATE employee_payroll_details SET salary = ? WHERE NAME = ?";
        try (Connection connection = this.getConnection();) {
            PreparedStatement preparedStatementUpdate = connection.prepareStatement(sql);
            preparedStatementUpdate.setDouble(1, salary);
            preparedStatementUpdate.setString(2, name);
            return preparedStatementUpdate.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * @param date1
     * @param date2
     * @return employee list in given date range
     */
    public List<EmployeePayrollData> getEmployeesInGivenDateRangeDB(String date1, String date2) {
        String sql = String.format("SELECT * FROM employee_payroll_details where start between '%s' AND '%s';", date1, date2);
        return this.getEmployeePayrollDataUsingSQLQuery(sql);
    }


    public Map<String, Double> getAverageSalaryByGender() {
        String sql = "SELECT gender,AVG(salary) FROM employee_payroll_details GROUP BY gender;";
        Map<String,Double> genderToAvgSalaryMap = new HashMap<String, Double>();
        try(Connection connection = this.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                String gender = resultSet.getString("gender");
                double salary = resultSet.getDouble("AVG(salary)");
                genderToAvgSalaryMap.put(gender, salary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return genderToAvgSalaryMap;
    }

    public EmployeePayrollData addEmployeeToPayrollUC7(String name, double salary, LocalDate startDate, String gender) {
        int employeeId = -1;
        EmployeePayrollData employeePayrollData = null;
        String sql = String.format("INSERT INTO employee_payroll_details (name,gender,salary,start) VALUES ('%s','%s','%s','%s')", name,
                gender, salary, Date.valueOf(startDate));
        try(Connection connection = this.getConnection()){
            Statement statement = connection.createStatement();
            int rowAffected = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if(rowAffected==1) {
                ResultSet resultSet = statement.getGeneratedKeys();
                if(resultSet.next()) employeeId =  resultSet.getInt(1);
            }
            employeePayrollData = new EmployeePayrollData(employeeId, name, salary, startDate);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeePayrollData;
    }

    public EmployeePayrollData addEmployeeToPayroll(String name, double salary, LocalDate startDate, String gender) {
        int employeeId = -1;
        Connection connection = null;
        EmployeePayrollData employeePayrollData = null;
        try {
            connection = this.getConnection();
            connection.setAutoCommit(false);
        }catch(SQLException e) {
            e.printStackTrace();
        }
        try(Statement statement = connection.createStatement()){
            String sql = String.format("INSERT INTO employee_payroll_details (name,gender,salary,start) VALUES ('%s','%s','%s','%s')", name,
                    gender, salary, Date.valueOf(startDate));
            int rowAffected = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if(rowAffected==1) {
                ResultSet resultSet = statement.getGeneratedKeys();
                if(resultSet.next()) employeeId =  resultSet.getInt(1);
            }
        } catch (SQLException e) {
            try {
                connection.rollback();
                return employeePayrollData;
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }

        try(Statement statement = connection.createStatement()){
            double deductions = salary*0.2;
            double taxablePay = salary-deductions;
            double tax = taxablePay*0.1;
            double netPay = salary - tax;
            String sql =  String.format("INSERT INTO payroll(employee_id,basic_pay,deductions,taxable_pay,tax,net_pay) VALUES"
                    + "( %s, %s, %s ,%s, %s, %s)",employeeId,salary,deductions,taxablePay,tax,netPay);
            int rowAffected = statement.executeUpdate(sql);
            if(rowAffected == 1) {
                employeePayrollData = new EmployeePayrollData(employeeId,name,salary,startDate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        try {
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(connection!=null)
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
        return employeePayrollData;
    }

    private Connection getConnection() throws SQLException {
        String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
        String userName = "root";
        String password = "root";
        Connection connection;
        System.out.println("Connecting to database: " + jdbcURL);
        connection = DriverManager.getConnection(jdbcURL, userName, password);
        System.out.println("Connection successful: " + connection);
        return connection;
    }
}
