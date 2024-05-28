package com.saurav;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class RoomInfo extends JFrame implements ActionListener {

    JTable t1;
    JButton b1,b2;

    RoomInfo(){
        t1 = new JTable();
        t1.setBounds(0,30,500,470);
        add(t1);

        JLabel j1 = new JLabel("Room Number");
        j1.setBounds(0,5,100,20);
        add(j1);

        JLabel j2 = new JLabel("Available");
        j2.setBounds(100,5,70,20);
        add(j2);


        JLabel j4 = new JLabel("Cleaning Status");
        j4.setBounds(200,5,100,20);
        add(j4);

        JLabel j5 = new JLabel("Price");
        j5.setBounds(300,5,70,20);
        add(j5);


        JLabel j7 = new JLabel("Bed Type");
        j7.setBounds(400,5,100,20);
        add(j7);



        b2 = new JButton("Back");
        b2.setBounds(170,500,120,30);
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);

        try {
            Conn c = new Conn();

            String str = "select * from addroom";
            ResultSet r = c.s.executeQuery(str);

            t1.setModel(DbUtils.resultSetToTableModel(r));

        }catch (Exception ea){
            System.out.println(ea);
        }

        ImageIcon im = new ImageIcon(ClassLoader.getSystemResource("com/icon/room.jpg"));
        Image im2 = im.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
        ImageIcon im3 = new ImageIcon(im2);
        JLabel im4 = new JLabel(im3);
        im4.setBounds(500,0,600,600);
        add(im4);

        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setBounds(170,100,1050,600);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
         if(e.getSource()==b2){
            new Reception();
            this.setVisible(false);
        }
    }
}

