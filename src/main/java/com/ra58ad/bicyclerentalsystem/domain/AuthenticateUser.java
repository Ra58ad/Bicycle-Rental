package com.ra58ad.bicyclerentalsystem.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AuthenticateUser {

    public boolean authenticateUser(String table, String email, String password, Connection conn) {
        try {
            String query = "SELECT * FROM " + table + " WHERE email=? AND password=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            boolean found = rs.next();
            rs.close();
            ps.close();
            return found;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
