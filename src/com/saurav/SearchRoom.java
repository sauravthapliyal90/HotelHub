package com.saurav;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class SearchRoom extends JFrame implements ActionListener {

    JTable t1;
    JButton b1,b2;
    JComboBox bedType;
    JCheckBox available;

    SearchRoom(){

        JLabel text = new JLabel("Search For Room");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(400, 30,200,30);
        add(text);

        JLabel lblbed = new JLabel("Bed Type");
        lblbed.setBounds(50,100,100,20);
        add(lblbed);

        bedType = new JComboBox(new String[]{"Single Bed","Double Bed"});
        bedType.setBounds(150,100,150,25);
        bedType.setBackground(Color.WHITE);
        add(bedType);

        available = new JCheckBox("Only display Available");
        available.setBounds(650,100,150,25);
        available.setBackground(Color.white);
        add(available);

        t1 = new JTable();
        t1.setBounds(0,200,1000,300);
        add(t1);

        JLabel j1 = new JLabel("Room Number");
        j1.setBounds(50,160,100,20);
        add(j1);

        JLabel j2 = new JLabel("Available");
        j2.setBounds(270,160,70,20);
        add(j2);


        JLabel j4 = new JLabel("Cleaning Status");
        j4.setBounds(450,160,100,20);
        add(j4);

        JLabel j5 = new JLabel("Price");
        j5.setBounds(670,160,70,20);
        add(j5);


        JLabel j7 = new JLabel("Bed Type");
        j7.setBounds(870,160,100,20);
        add(j7);


        b1 = new JButton("Submit");
        b1.setBounds(300,520,120,30);
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);

        b2 = new JButton("Back");
        b2.setBounds(500,520,120,30);
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);




        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setBounds(170,100,1000,600);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b1){
            try {
                Conn c = new Conn();

                String str1 = "Select * from addroom where bed = '"+bedType.getSelectedItem()+"'";
                String str2 =  "Select * from addroom where available = 'Available' AND bed = '"+bedType.getSelectedItem()+"'";

                ResultSet r;

                if(available.isSelected()){
                     r = c.s.executeQuery(str2);
                }else{
                     r = c.s.executeQuery(str1);
                }


                t1.setModel(DbUtils.resultSetToTableModel(r));

            }catch (Exception ea){
                System.out.println(ea);
            }
        }
        else if(e.getSource()==b2){
            new Reception();
            this.setVisible(false);
        }
    }

}

