package com.ra58ad.bicyclerentalsystem.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class RegisterUser {
    
    public boolean registerUser(String name, String email, String phone, String password, Connection conn){
        String sql = "INSERT INTO renter (full_name, email, phone, password, registered_at) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, phone);
            stmt.setString(4, password);
            stmt.setDate(5, java.sql.Date.valueOf(LocalDate.now()));
            stmt.executeUpdate();
            return true;
        } catch (SQLException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Insert failed: " + ex.getMessage());
            return false;
        }
    }
}
