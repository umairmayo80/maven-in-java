package dev.umair.smpa;


import java.sql.*;

public class App {
    public static void main(String[] args) throws SQLException {
        // JDBC connection parameters
        String url = "jdbc:mysql://localhost:3306/university";
        String username = "root";
        String password = "password";
        String query = "select * from EngineeringStudents";


        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //to check if the external connector is successfully inlcuded as library or not
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        try {
            // Establish the database connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Use the connection to perform database operations
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);


            while(resultSet.next()){
                System.out.print(resultSet.getRow()+":");
                //as we have six columns
                for(int i =1; i<=6; i++){
                    System.out.print(resultSet.getString(i)+",");
                }
                System.out.println();
            }

            // Close the connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
}
