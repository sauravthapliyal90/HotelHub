package com.saurav;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateRoom extends JFrame implements ActionListener {

    Choice c1;
    JTextField t1,t2,t3;
    JButton b1,b2,b3;

    UpdateRoom(){

        JLabel j1 = new JLabel("Update Room Status");
        j1.setBounds(85,20,200,30);
        j1.setFont(new Font("tahoma",Font.PLAIN,20));
        j1.setForeground(Color.BLUE);
        add(j1);

        JLabel j2 = new JLabel("Guest ID");
        j2.setBounds(20,80,120,30);
        add(j2);

        c1 = new Choice();
        try{
            Conn c = new Conn();

            ResultSet r = c.s.executeQuery("select * from addcustomer");

            while (r.next()){
                c1.add(r.getString("number"));
            }

        }catch (Exception e){

        }
        c1.setBounds(200,80,150,25);
        add(c1);

        JLabel j3 = new JLabel("Room Number");
        j3.setBounds(20,130,120,30);
        add(j3);

        t1 = new JTextField();
        t1.setBounds(200,130,150,25);
        add(t1);

        JLabel j4 = new JLabel("Availability");
        j4.setBounds(20,180,120,30);
        add(j4);

        t2 = new JTextField();
        t2.setBounds(200,180,150,25);
        add(t2);

        JLabel j5 = new JLabel("Clean Status");
        j5.setBounds(20,230,120,30);
        add(j5);

        t3 = new JTextField();
        t3.setBounds(200,230,150,25);
        add(t3);

        b1 = new JButton("Check");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        b1.setBounds(120,300,120,30);
        add(b1);

        b2 = new JButton("Update");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        b2.setBounds(30,350,120,30);
        add(b2);

        b3 = new JButton("Back");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        b3.setBounds(210,350,120,30);
        add(b3);

        getContentPane().setBackground(Color.WHITE);

        ImageIcon im = new ImageIcon(ClassLoader.getSystemResource("com/icon/update.jpg"));
        Image im1 = im.getImage().getScaledInstance(500,400,Image.SCALE_DEFAULT);
        ImageIcon im2 = new ImageIcon(im1);
        JLabel l1 = new JLabel(im2);
        l1.setBounds(370,30,390,350);
        add(l1);

        setLayout(null);
        setBounds(310,150,800,440);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ea){

        if (ea.getSource()==b1){
            String room = null;
            String s1 = c1.getSelectedItem();
            Conn c = new Conn();
             try {
                 ResultSet r = c.s.executeQuery("select * from addcustomer where number = '" + s1 + "'");

                 while (r.next()){
                     t1.setText(r.getString("room"));
                     room = r.getString("room");
                 }
                 ResultSet r1 = c.s.executeQuery("select * from addroom where roomno = '" + room + "'");
                 while (r1.next()){
                     t2.setText(r1.getString("available"));
                     t3.setText(r1.getString("clean"));


                 }
             }catch (Exception e){}
        }else if(ea.getSource()==b2){

            try {
                Conn c= new Conn();
                String room = t1.getText();
                String available = t2.getText();
                String status = t3.getText();

                String str = "Update addroom set available = '"+available+"',clean = '"+status+"' where roomno = '"+room+"' ";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"Room is Updated");
                new Reception().setVisible(true);
                this.setVisible(false);

            }catch (Exception e){
                System.out.println(e);

            }


        }else if(ea.getSource()==b3){
            new Reception().setVisible(true);
            this.setVisible(false);

        }
    }
}
