package com.ra58ad.bicyclerentalsystem.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.ra58ad.bicyclerentalsystem.Config;

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
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bicycle_rental_system", "root", "root");
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
