package com.saurav;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class CustomerInfo extends JFrame implements ActionListener {

    JTable t1;
    JButton b2;

    CustomerInfo(){
        t1 = new JTable();
        t1.setBounds(0,30,970,470);
        add(t1);

        JLabel j1 = new JLabel("ID");
        j1.setBounds(50,5,70,20);
        add(j1);

        JLabel j2 = new JLabel("Number");
        j2.setBounds(160,5,70,20);
        add(j2);

        JLabel j3 = new JLabel("Name");
        j3.setBounds(290,5,70,20);
        add(j3);

        JLabel j4 = new JLabel("Gender");
        j4.setBounds(400,5,70,20);
        add(j4);

        JLabel j5 = new JLabel("Country");
        j5.setBounds(520,5,70,20);
        add(j5);

        JLabel j6 = new JLabel("Room");
        j6.setBounds(650,5,70,20);
        add(j6);

        JLabel j7 = new JLabel("Check In");
        j7.setBounds(760,5,70,20);
        add(j7);

        JLabel j8 = new JLabel("Deposit");
        j8.setBounds(880,5,70,20);
        add(j8);




        b2 = new JButton("Back");
        b2.setBounds(450,500,120,30);
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);

        getContentPane().setBackground(Color.WHITE);

        try {
            Conn c = new Conn();

            String str = "select * from addcustomer";
            ResultSet r = c.s.executeQuery(str);

            t1.setModel(DbUtils.resultSetToTableModel(r));

        }catch (Exception ea){

        }

        setLayout(null);
        setBounds(230,140,970,580);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
         if(e.getSource()==b2){
            new Reception();
            this.setVisible(false);
        }
    }
}
