package com.saurav;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class ManagerInfo extends JFrame implements ActionListener {

    JTable t1;
    JButton b1,b2;

    ManagerInfo(){
        t1 = new JTable();
        t1.setBounds(0,30,970,470);
        add(t1);

        JLabel j1 = new JLabel("Name");
        j1.setBounds(40,5,70,20);
        add(j1);

        JLabel j2 = new JLabel("Age");
        j2.setBounds(200,5,70,20);
        add(j2);

        JLabel j3 = new JLabel("Gender");
        j3.setBounds(325,5,70,20);
        add(j3);

        JLabel j4 = new JLabel("Department");
        j4.setBounds(450,5,70,20);
        add(j4);

        JLabel j5 = new JLabel("Salary");
        j5.setBounds(605,5,70,20);
        add(j5);

        JLabel j6 = new JLabel("Phone");
        j6.setBounds(740,5,70,20);
        add(j6);

        JLabel j7 = new JLabel("Email");
        j7.setBounds(870,5,70,20);
        add(j7);


        b2 = new JButton("Back");
        b2.setBounds(450,500,120,30);
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);

        try {
            Conn c = new Conn();

            String str = "select * from add_emp where job = 'manager'";
            ResultSet r = c.s.executeQuery(str);

            t1.setModel(DbUtils.resultSetToTableModel(r));

        }catch (Exception ea){
            System.out.println(ea);
        }

        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setBounds(230,140,970,580);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b1){

        }else if(e.getSource()==b2){
            new Reception();
            this.setVisible(false);
        }
    }
}
