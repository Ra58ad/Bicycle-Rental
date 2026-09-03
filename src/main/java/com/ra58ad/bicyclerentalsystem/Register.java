package com.ra58ad.bicyclerentalsystem;

import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.*;


public class Register extends AuthWindow {
    JLabel l1, l2, l3, l4;
    JTextField t1, t2, t3, t4;
    JTextArea ta;
    JPasswordField pa;
    JButton b1, b2, regb, forb;
    JPanel p1, p2;

    
    public void display()  {

        setTitle("Bicycle Rental Register");
        Insets in = new Insets(0,0,0,0);

        p1 = new JPanel();
        p1.setLayout(new GridBagLayout());
        GridBagConstraints gb = new GridBagConstraints();
        GridBagConstraints bc = new GridBagConstraints();

        l3 = new JLabel("Sign Up");
        l3.setFont(new Font("Serif", Font.BOLD, 25));
        l3.setForeground(Color.decode("#A85307"));
        bc.gridx = 1;
        bc.gridy = 0;
        bc.gridheight = 1;
        bc.gridwidth = 1;
        bc.weightx = 0.5;
        bc.weighty = 0.1;
        in.set(0, 0, 30,50);
        bc.insets = in;
        bc.anchor = GridBagConstraints.PAGE_START;
        p1.add(l3, bc);

        Font fo = new Font("Times New Roman", Font.PLAIN, 20);

        l1 = new JLabel("Email: ");
        l1.setFont(fo);
        l1.setForeground(Color.decode("#A85307"));
        gb.gridx = 0;
        gb.gridy = 2;
        gb.gridheight = 1;
        gb.gridwidth = 1;
        //gb.weightx = 0.01;
        gb.weighty = 0.1;
        in.set(0,0,0,0);
        gb.insets = in;
        gb.ipadx = 0;
        gb.ipady = 0;
        p1.add(l1,gb);

        t1 = new JTextField();
        gb.gridx = 0;
        gb.gridy = 3;
        //gb.gridheight = 1;
        gb.gridwidth = 3;
        gb.weighty = 0;
        gb.ipadx = 400;
        in.set(10,0,10,0);
        gb.insets = in;
        //gb.weightx = 0.5;
        //gb.weighty = 0.1;
        p1.add(t1,gb);

        l2 = new JLabel("Password: ");
        l2.setForeground(Color.decode("#A85307"));
        l2.setFont(fo);
        gb.gridx = 0;
        gb.gridy = 4;
        //gb.gridheight = 1;
        gb.gridwidth = 1;
        in.set(0,0,0,0);
        gb.insets = in;
        gb.weighty = 0.1;
        gb.ipadx = 0;
        //gb.weightx = 0.5;
        //gb.weighty = 0.1;
        p1.add(l2,gb);

        pa = new JPasswordField();
        gb.gridx = 0;
        gb.gridy = 5;
        //gb.gridheight = 1;
        gb.gridwidth = 3;
        gb.ipadx = 400;
        //gb.weightx = 0.5;
        //gb.weighty = 0.1;
        p1.add(pa,gb);

        l3 = new JLabel("Name: ");
        l3.setFont(fo);
        l3.setForeground(Color.decode("#A85307"));
        gb.gridx = 0;
        gb.gridy = 6;
        gb.gridheight = 1;
        gb.gridwidth = 1;
        //gb.weightx = 0.01;
        gb.weighty = 0.1;
        in.set(0,0,0,0);
        gb.insets = in;
        gb.ipadx = 0;
        gb.ipady = 0;
        p1.add(l3,gb);

        t3 = new JTextField();
        gb.gridx = 0;
        gb.gridy = 7;
        //gb.gridheight = 1;
        gb.gridwidth = 3;
        gb.weighty = 0;
        gb.ipadx = 400;
        in.set(10,0,10,0);
        gb.insets = in;
        //gb.weightx = 0.5;
        //gb.weighty = 0.1;
        p1.add(t3,gb);

        l4 = new JLabel("Phone number: ");
        l4.setForeground(Color.decode("#A85307"));
        l4.setFont(fo);
        gb.gridx = 0;
        gb.gridy = 8;
        gb.gridheight = 1;
        gb.gridwidth = 1;
        in.set(0,0,0,0);
        gb.insets = in;
        gb.weighty = 0.1;
        gb.ipadx = 0;
        gb.ipady = 0;
        //gb.weightx = 0.5;
        //gb.weighty = 0.1;
        p1.add(l4,gb);

        t4 = new JTextField();
        gb.gridx = 0;
        gb.gridy = 9;
        //gb.gridheight = 1;
        gb.gridwidth = 3;
        gb.ipadx = 400;
        in.set(10,0,10,0);
        gb.insets = in;
        //gb.weightx = 0.5;
        //gb.weighty = 0.1;
        p1.add(t4,gb);

        

        regb = new JButton("Login");
        regb.setBackground(Color.decode("#010D1A"));
        regb.setForeground(Color.CYAN);
        regb.setFont(fo);
        regb.setBorder(BorderFactory.createEmptyBorder());
        gb.gridx = 0;
        gb.gridy = 10;
        gb.gridheight = 1;
        gb.gridwidth = 2;
        gb.ipady = 0;
        gb.ipadx = 100;
        gb.weightx = 0.1;
        gb.weighty = 0;
        in.set(10,0,10,0);
        gb.insets = in;
        

        //forb = new JButton("Forgot password");

        p2 = new JPanel();
        b1 = new JButton("OK");
        b1.addActionListener(e -> {
        
            String email = t1.getText();
            String password = new String(pa.getPassword());
            String name = t3.getText();
            String phone = t4.getText();
            register(name, email, phone, password);
            JOptionPane.showMessageDialog(this, "Registered successfully!");
            
            dispose();
            new Customer().display();
        });

        b1.setSize(60, 30);
        p2.add(b1);

        b2 = new JButton("Cancel");
        b2.addActionListener(e -> {
            dispose();
            new Welcome().display();
        });
        b2.setSize(60, 30);
        p2.add(b2);

        regb.addActionListener(e -> {
            dispose();
            new Login().display();
        });
        p1.add(regb, gb);

        p1.setOpaque(false);
        p2.setOpaque(false);
        add(p1);
        add(p2, BorderLayout.SOUTH);
        setResizable(false);
        getContentPane().setBackground(Color.decode("#010D1A"));
        setScreen();
        
    }

    private void register(String name, String email, String phone, String password){
        String sql = "INSERT INTO renter (full_name, email, phone, password, registered_at) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = db.getConnection().prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, phone);
            stmt.setString(4, password);
            stmt.setDate(5, java.sql.Date.valueOf(LocalDate.now()));
            stmt.executeUpdate();
        } catch (SQLException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Insert failed: " + ex.getMessage());
        }
    }
    }





