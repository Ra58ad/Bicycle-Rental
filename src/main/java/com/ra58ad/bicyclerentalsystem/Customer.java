package com.ra58ad.bicyclerentalsystem;

import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.function.Consumer;
import java.sql.*;

public class Customer extends CustomerWindow {

    
    private JButton bikesOffered, bikesRented, payment, staffView;
    private JPanel mainPanel, bikesRentedPanel, paymentPanel, staffPanel;
    private ArrayList<RentedBike> rentedBikes = new ArrayList<>();
    private ArrayList<PaymentRecord> paymentRecords = new ArrayList<>();
    
    public void display() {
        setTitle();

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

        // addSampleBikes();

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
                } else if (e.getSource() == bikesRented) {
                    bikesRented.setBackground(Color.BLUE);
                    bikesOffered.setBackground(Color.DARK_GRAY);
                    payment.setBackground(Color.DARK_GRAY);
                    staffView.setBackground(Color.DARK_GRAY);
                    showRentedBikes();
                    cl.show(mainPanel, "BikesRented");
                } else if (e.getSource() == payment) {
                    payment.setBackground(Color.BLUE);
                    bikesOffered.setBackground(Color.DARK_GRAY);
                    bikesRented.setBackground(Color.DARK_GRAY);
                    staffView.setBackground(Color.DARK_GRAY);
                    showPaymentRecords();
                    cl.show(mainPanel, "Payment");
                }
            }
        };

        // Consumer<JLabel> rent = (JLabel l) -> {
        //     openRentingPage(ranImg, bike[4]);
        // };
        
        // addSampleBikes(rent);
            
        bikesOffered.addActionListener(listener);
        bikesRented.addActionListener(listener);
        payment.addActionListener(listener);

        setScreen();
    }


    private void openRentingPage(String resourcePath, String price) {
        JFrame rentingFrame = new JFrame("Rent Bike");
        rentingFrame.setSize(400, 500);
        rentingFrame.setLocationRelativeTo(null);
        JPanel rentingPanel = new JPanel();
        rentingPanel.setLayout(new BoxLayout(rentingPanel, BoxLayout.Y_AXIS));
        rentingPanel.setBackground(Color.LIGHT_GRAY);

        java.net.URL imgURL = getClass().getResource(resourcePath);
        if (imgURL == null) {
            System.err.println("Couldn't find file: " + resourcePath);
            return;
        }

        ImageIcon icon = new ImageIcon(imgURL);
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImg);

        JLabel bikeImageLabel = new JLabel(scaledIcon);
        bikeImageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        rentingPanel.add(bikeImageLabel);

        JLabel priceLabel = new JLabel("Price: " + price);
        priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        rentingPanel.add(priceLabel);


        JPanel durationPanel = new JPanel(new FlowLayout());
        durationPanel.add(new JLabel("Start Date:"));
        JTextField startDateField = new JTextField(10);
        durationPanel.add(startDateField);
        durationPanel.add(new JLabel("Return Date:"));
        JTextField returnDateField = new JTextField(10);
        durationPanel.add(returnDateField);
        rentingPanel.add(durationPanel);

        JPanel paymentPanel = new JPanel();
        paymentPanel.setLayout(new BoxLayout(paymentPanel, BoxLayout.Y_AXIS));

        JLabel paymentLabel = new JLabel("Choose Payment Method:");
        paymentLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        paymentPanel.add(paymentLabel);

        JRadioButton teleBirr = new JRadioButton("Telebirr");
        JRadioButton mobileBanking = new JRadioButton("Mobile Banking");

        ButtonGroup paymentGroup = new ButtonGroup();
        paymentGroup.add(teleBirr);
        paymentGroup.add(mobileBanking);

        paymentPanel.add(teleBirr);
        paymentPanel.add(mobileBanking);
        rentingPanel.add(paymentPanel);

        JButton rentButton = new JButton("Rent Now");
        rentButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        rentingPanel.add(rentButton);

        rentButton.addActionListener(e -> {
            String startDate = startDateField.getText().trim();
            String returnDate = returnDateField.getText().trim();
            if (startDate.isEmpty() || returnDate.isEmpty() || (!teleBirr.isSelected() && !mobileBanking.isSelected())) {
                JOptionPane.showMessageDialog(rentingFrame, "Please fill all fields and select payment method");
                return;
            }
            rentedBikes.add(new RentedBike("", price, startDate, returnDate));
            paymentRecords.add(new PaymentRecord(price, false));
            JOptionPane.showMessageDialog(rentingFrame, "Bike rented successfully!");
            rentingFrame.dispose();
        });

        rentingFrame.add(rentingPanel);
        

        rentingFrame.setVisible(true);
    }

    private void showRentedBikes() {
        bikesRentedPanel.removeAll();
        for (RentedBike rb : rentedBikes) {
            String info = "<html>Bike: " + rb.price + "<br>From: " + rb.startDate + "<br>To: " + rb.returnDate + "</html>";
            JLabel label = new JLabel(info);
            label.setForeground(Color.WHITE);
            bikesRentedPanel.add(label);
        }
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private void showPaymentRecords() {
        paymentPanel.removeAll();
        for (PaymentRecord pr : paymentRecords) {
            String info = "<html>Amount: " + pr.amount + "<br>Due: " + (pr.isPaid ? "No" : "Yes") + "</html>";
            JLabel label = new JLabel(info);
            label.setForeground(Color.WHITE);
            paymentPanel.add(label);
        }
        mainPanel.revalidate();
        mainPanel.repaint();
    }
    
    

    class Bike {
        String imagePath;
        String price;
        String accessories;

        Bike(String imagePath, String price, String accessories) {
            this.imagePath = imagePath;
            this.price = price;
            this.accessories = accessories;
        }
    }

    class RentedBike {
        String imagePath;
        String price;
        String startDate;
        String returnDate;

        RentedBike(String imagePath, String price, String startDate, String returnDate) {
            this.imagePath = imagePath;
            this.price = price;
            this.startDate = startDate;
            this.returnDate = returnDate;
        }
    }

    class PaymentRecord {
        String amount;
        boolean isPaid;

        PaymentRecord(String amount, boolean isPaid) {
            this.amount = amount;
            this.isPaid = isPaid;
        }
    }
}

