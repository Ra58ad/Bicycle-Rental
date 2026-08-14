package com.ra58ad.bicyclerentalsystem;

import java.awt.GridBagConstraints;
import javax.swing.JFrame;


public abstract class BRWindow extends JFrame {
    protected static DBConnection db = DBConnection.getInstance();
    protected static GridBagConstraints gb = new GridBagConstraints();
    
    protected void setTitle() {
        super.setTitle("Bicycle Rental System");
    }
    
    abstract void display();

    protected void setScreen(){
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
