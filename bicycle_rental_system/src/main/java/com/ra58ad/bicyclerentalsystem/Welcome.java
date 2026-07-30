package com.ra58ad.bicyclerentalsystem;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.sql.*;

import javax.imageio.*;
import javax.swing.*;

import com.ra58ad.bicyclerentalsystem.Customer.PaymentRecord;
import com.ra58ad.bicyclerentalsystem.Customer.RentedBike;
import com.ra58ad.bicyclerentalsystem.DBConnection;

import java.util.*;
import java.util.function.Consumer;

public class Welcome extends CustomerWindow{

        private JButton bikesOffered, bikesRented, payment, staffView;
        private JPanel mainPanel, bikesOfferedPanel, bikesRentedPanel, paymentPanel, staffPanel;
        private ArrayList<RentedBike> rentedBikes = new ArrayList<>();
        private ArrayList<PaymentRecord> paymentRecords = new ArrayList<>();

        public void display() {
            
            JPanel menuPanel = new JPanel();
            menuPanel.setBackground(Color.DARK_GRAY);
            menuPanel.setLayout(new GridBagLayout());

            JMenuBar mb = new JMenuBar();

            JMenu bikeMenu = new JMenu("Bikes");

            JMenu contactMenu = new JMenu("Contact");
            JMenuItem ad = new JMenuItem("Address");
            JMenuItem form = new JMenuItem("Contact form");
            contactMenu.add(ad);
            contactMenu.add(form);
            JMenu logMenu = new JMenu("Login");
            JMenu regMenu = new JMenu("Register");

            mb.add(bikeMenu);
            mb.add(contactMenu);
            mb.add(logMenu);
            mb.add(regMenu);
            gb.gridheight = 1;
            gb.gridwidth = 1;
            gb.gridx = 1;
            gb.gridy = 1;
            gb.fill = GridBagConstraints.HORIZONTAL;
            menuPanel.add(mb, gb);
            add(menuPanel, BorderLayout.NORTH);

            JPanel mainPanel1 = new JPanel();
            mainPanel1.setBackground(Color.CYAN);
            mainPanel1.setLayout(new GridBagLayout());

            

            JPanel leftPanel = new JPanel();
            ImageIcon icon = new ImageIcon("img_1.png");
            Image img = icon.getImage();
            Image scaledImg = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImg);
            JLabel l1 = new JLabel(scaledIcon);
            leftPanel.add(l1);

            add(leftPanel, BorderLayout.WEST);

            JScrollPane scPanel = new JScrollPane(mainPanel1);
            add(scPanel);

            fetchBikes();



        mainPanel = new JPanel(new CardLayout());
        bikesOfferedPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        bikesOfferedPanel.setBackground(Color.BLACK);
        bikesRentedPanel = new JPanel();
        bikesRentedPanel.setBackground(Color.BLACK);
        paymentPanel = new JPanel();
        paymentPanel.setBackground(Color.BLACK);


        bikesOffered = new JButton("Bikes Offered");
        bikesRented = new JButton("Bikes Rented");
        payment = new JButton("Payment");

        bikesOffered.setBackground(Color.DARK_GRAY);
        bikesRented.setBackground(Color.DARK_GRAY);
        payment.setBackground(Color.DARK_GRAY);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(bikesOffered);
        buttonPanel.add(bikesRented);
        buttonPanel.add(payment);

        Consumer<JLabel> login = (JLabel l) -> {
            setVisible(false);
            new Login();
        };
        
        addSampleBikes(login);

        mainPanel.add(bikesOfferedPanel, "BikesOffered");
        mainPanel.add(bikesRentedPanel, "BikesRented");
        mainPanel.add(paymentPanel, "Payment");


        add(buttonPanel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);

        ActionListener listener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) mainPanel.getLayout();
                if (e.getSource() == bikesOffered) {
                    bikesOffered.setBackground(Color.BLUE);
                    bikesRented.setBackground(Color.DARK_GRAY);
                    payment.setBackground(Color.DARK_GRAY);
                    staffView.setBackground(Color.DARK_GRAY);
                    cl.show(mainPanel, "BikesOffered");
            }
        }
        };
        bikesOffered.addActionListener(listener);
        bikesRented.addActionListener(listener);
        payment.addActionListener(listener);
    

        setScreen();
    }
}



    







