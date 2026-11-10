package com.example.projectbd.CLASS;

import java.sql.*;

public class DatabaseConnection {
    public static Connection databaseLink;

    public static Connection getConnection()
    {
        String databaseName = "postgres";
        String user = "RBS";
        String password = "123";
        String url = "jdbc:postgresql://localhost:5432/" + databaseName;

        try {
            Class.forName("org.postgresql.Driver");
            databaseLink = DriverManager.getConnection(url,user,password);
        }
        catch (ClassNotFoundException e)
        {
            System.err.println("PostgreSQL Driver gk ada");
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            System.err.println("Koneksi database gk bisa");
            e.printStackTrace();
        }
        return databaseLink;
    }

    public static Statement getStatement() throws SQLException{
        return getConnection().createStatement();
    }
}
