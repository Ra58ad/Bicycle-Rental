package com.ra58ad.bicyclerentalsystem;

import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

//Connection class Adapter
public class DBConnection{

    private static DBConnection _instance;
    private static Connection connection;
    
    //
    private DBConnection(){
    }
    
    
    public static DBConnection getInstance(){
            if (_instance == null){
                _instance = new DBConnection();
                return _instance;
            } else {
                return _instance;
        }
    }
    
    public Connection getConnection(Config config){
        if (connection == null){
            try {
                connection = DriverManager.getConnection(config.getDB(), config.getUser(), config.getPass());
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(new JFrame(), "Database connection failed (welcome): " + e.getMessage());
                System.exit(1);
            }
            return connection;
        } else {
            return connection;
        }
    }
    
    public Connection getConnection(){
        if (connection == null){
            try {
                connection = DriverManager.getConnection("bicycle_rental_system", "ramo", "ra58ad");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(new JFrame(), "Database connection failed (welcome): " + e.getMessage());
                System.exit(1);
            }
            return connection;
        } else {
            return connection;
        }
    }
    
    // public void prepare(String query){
    //     try {
    //         statement = connection.prepareStatement(query);
    //     } catch (SQLException | NumberFormatException ex) {
    //         JOptionPane.showMessageDialog(new JFrame(), "Insert failed: " + ex.getMessage());
    //     }
    // }
    // Violates SRP; create new class
}
