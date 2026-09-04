package com.ra58ad.bicyclerentalsystem;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import com.ra58ad.bicyclerentalsystem.Customer.PaymentRecord;
import com.ra58ad.bicyclerentalsystem.Customer.RentedBike;

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
            gb.gridwidth = 3;
            gb.gridx = 1;
            gb.gridy = 1;
            gb.fill = GridBagConstraints.HORIZONTAL;
            menuPanel.add(mb, gb);
            this.add(menuPanel, BorderLayout.NORTH);

            JPanel mainPanel1 = new JPanel();
            mainPanel1.setBackground(Color.CYAN);
            mainPanel1.setLayout(new GridBagLayout());

            

            JPanel leftPanel = new JPanel();
            ImageIcon icon = new ImageIcon("images/img_1.png");
            Image img = icon.getImage();
            Image scaledImg = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImg);
            JLabel l1 = new JLabel(scaledIcon);
            leftPanel.add(l1);

            this.add(leftPanel, BorderLayout.WEST);

            JScrollPane scPanel = new JScrollPane(mainPanel1);
            this.add(scPanel, BorderLayout.EAST);
            fetchBikes();



            mainPanel = new JPanel(new CardLayout());
            bikesOfferedPanel = new JPanel(new GridLayout(1, 2, 10, 10));
            bikesOfferedPanel.setBackground(Color.BLACK);
            bikesRentedPanel = new JPanel();
            bikesRentedPanel.setBackground(Color.BLACK);
            paymentPanel = new JPanel();
            paymentPanel.setBackground(Color.BLACK);


            bikesOffered = new JButton("Bikes Offered");
            bikesOffered.setBackground(Color.DARK_GRAY);

            bikesRented = new JButton("Bikes Rented");
            bikesRented.setBackground(Color.DARK_GRAY);

            payment = new JButton("Payment");
            payment.setBackground(Color.DARK_GRAY);

            JPanel buttonPanel = new JPanel(new FlowLayout());
            buttonPanel.add(bikesOffered);
            buttonPanel.add(bikesRented);
            buttonPanel.add(payment);

            addSampleBikes();

            mainPanel.add(bikesOfferedPanel);
            mainPanel.add(bikesRentedPanel);
            mainPanel.add(paymentPanel);


            this.add(buttonPanel, BorderLayout.SOUTH);
            this.add(mainPanel);

            ActionListener listener = new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    CardLayout cl = (CardLayout) mainPanel.getLayout();
                    if (e.getSource() == bikesOffered) {
                        bikesOffered.setBackground(Color.BLUE);
                        bikesRented.setBackground(Color.DARK_GRAY);
                        payment.setBackground(Color.DARK_GRAY);
                        // staffView.setBackground(Color.DARK_GRAY);
                        cl.show(mainPanel, "BikesOffered");

                    }else if (e.getSource() == bikesRented) {

                        bikesRented.setBackground(Color.BLUE);
                        bikesOffered.setBackground(Color.DARK_GRAY);
                        payment.setBackground(Color.DARK_GRAY);
                        // staffView.setBackground(Color.DARK_GRAY);
                        cl.show(mainPanel, "BikesRented");

                    } else if (e.getSource() == payment) {

                        bikesOffered.setBackground(Color.DARK_GRAY);
                        bikesRented.setBackground(Color.DARK_GRAY);
                        payment.setBackground(Color.BLUE);
                        // staffView.setBackground(Color.DARK_GRAY);
                        cl.show(mainPanel, "Payment");
                    }
                }
            };
            bikesOffered.addActionListener(listener);
            bikesRented.addActionListener(listener);
            payment.addActionListener(listener);

            setScreen();
    }

    private void addSampleBikes() {


        for (String[] bike : sb) {
            Random ran = new Random();
            String ranImg = "/" + imgList[ran.nextInt(5)];
            JLabel bikeLabel = new JLabel(new ImageIcon(getClass().getResource(ranImg)));
            bikeLabel.setText("<html>Price: " + bike[4]);
            bikeLabel.setForeground(Color.WHITE);
            bikeLabel.setHorizontalTextPosition(SwingConstants.CENTER);
            bikeLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
            bikeLabel.setHorizontalAlignment(SwingConstants.CENTER);
            bikeLabel.setVerticalAlignment(SwingConstants.CENTER);

            bikeLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    setVisible(false);
                    new Login();
                }
            });

            bikesOfferedPanel.add(bikeLabel);
        }
    }

}



    







