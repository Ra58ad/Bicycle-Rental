// package com.ra58ad.bicyclerentalsystem.domain;

// public class Authenticate {

//     public boolean authenticate(String table, String email, String password) {
//         try {
//             String sql = "SELECT * FROM " + table + " WHERE email=? AND password=?";
//             PreparedStatement ps = db.getConnection().prepareStatement(sql);
//             ps.setString(1, email);
//             ps.setString(2, password);
//             ResultSet rs = ps.executeQuery();
//             boolean found = rs.next();
//             rs.close();
//             ps.close();
//             return found;
//         } catch (Exception ex) {
//             ex.printStackTrace();
//             return false;
//         }
//     }

// }
