package com.ra58ad.bicyclerentalsystem;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import java.util.function.Consumer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public abstract class CustomerWindow extends BRWindow{
    protected ArrayList <String[]> sb = new ArrayList<>();
    protected String[] imgList = {"img_1.png", "img_2.png", "img_3.png", "img_4.png", "img_5.png"};
    protected JPanel bikesOfferedPanel;

    protected void addSampleBikes(Consumer<JLabel> fun) {


        for (String[] bike : sb) {
            String ranImg = imgList[new Random().nextInt(5)];
            JLabel bikeLabel = new JLabel(new ImageIcon(getClass().getResource(ranImg)));
            bikeLabel.setText("<html>Price: " + bike[4]);
            bikeLabel.setForeground(Color.WHITE);
            bikeLabel.setHorizontalTextPosition(SwingConstants.CENTER);
            bikeLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
            bikeLabel.setHorizontalAlignment(SwingConstants.CENTER);
            bikeLabel.setVerticalAlignment(SwingConstants.CENTER);

            bikeLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    fun.accept(bikeLabel);
                }
            });

            bikesOfferedPanel.add(bikeLabel);
        }
    }
    
    protected void fetchBikes() {
        
        String sql = "SELECT * FROM bicycle";
        try (
            Statement stmt = db.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                
                String ID = rs.getString("bicycle_id");
                String model = rs.getString("model");
                String type = rs.getString("type");
                String status = rs.getString("status");
                String price = rs.getString("price_per_hour");
                String[] temp = {ID, model, type, status, price};
                sb.add(temp);
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Fetch failed: " + ex.getMessage());
        }
    }

    protected void addSampleBikes(){

    }
}
