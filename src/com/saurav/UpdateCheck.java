package com.saurav;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCheck extends JFrame implements ActionListener {

    JButton b1,b2,b3;
    Choice c1;
    JTextField t1,t2,t3,t4,t5;

    UpdateCheck(){

        JLabel l1 = new JLabel("Check-in Detail");
        l1.setFont(new Font("Tahamo",Font.PLAIN,20));
        l1.setForeground(Color.BLUE);
        l1.setBounds(90,30,200,30);
        add(l1);

        JLabel l2 = new JLabel("Customer-ID");
        l2.setBounds(30,80,100,20);
        add(l2);

        c1 = new Choice();
        try{
            Conn c = new Conn();

            ResultSet r = c.s.executeQuery("select * from addcustomer");
            while(r.next()){
                c1.add(r.getString("number"));

            }

        }catch (Exception e){}
        c1.setBounds(200,80,150,25);
        add(c1);

        JLabel l3 = new JLabel("Room Number");
        l3.setBounds(30,120,100,20);
        add(l3);

        t1 =new JTextField();
        t1.setBounds(200,120,150,25);
        add(t1);

        JLabel l4 = new JLabel("Name");
        l4.setBounds(30,160,100,20);
        add(l4);

        t2 =new JTextField();
        t2.setBounds(200,160,150,25);
        add(t2);

        JLabel l5 = new JLabel("Check-in Time");
        l5.setBounds(30,200,100,20);
        add(l5);

        t3 =new JTextField();
        t3.setBounds(200,200,150,25);
        add(t3);

        JLabel l6 = new JLabel("Amount Paid");
        l6.setBounds(30,240,100,20);
        add(l6);

        t4 =new JTextField();
        t4.setBounds(200,240,150,25);
        add(t4);

        JLabel l7 = new JLabel("Pending Amount");
        l7.setBounds(30,280,100,20);
        add(l7);

        t5 =new JTextField();
        t5.setBounds(200,280,150,25);
        add(t5);

        b1 = new JButton("Check");
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.addActionListener(this);
        b1.setBounds(30,340,100,30);
        add(b1);

        b2 = new JButton("Update");
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.addActionListener(this);
        b2.setBounds(150,340,100,30);
        add(b2);

        b3 = new JButton("Back");
        b3.setForeground(Color.WHITE);
        b3.setBackground(Color.BLACK);
        b3.addActionListener(this);
        b3.setBounds(270,340,100,30);
        add(b3);

        getContentPane().setBackground(Color.WHITE);

        ImageIcon im = new ImageIcon(ClassLoader.getSystemResource("com/icon/check-in-update.jpg"));
        JLabel j9 = new JLabel(im);
        j9.setBounds(390,30,420,340);
        add(j9);

        setLayout(null);
        setBounds(310,150,850,440);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==b1){

            try{
                String room = null;
                String deposit = null;
                int amount;
                String price = null;
                Conn c = new Conn();
                String id = c1.getSelectedItem();
                String str = "select * from addcustomer where number = '"+id+"'";

                ResultSet r = c.s.executeQuery(str);
                while(r.next()){
                    t1.setText(r.getString("room"));
                    t2.setText(r.getString("name"));
                    t3.setText(r.getString("status"));
                    t4.setText(r.getString("deposit"));
                    room = r.getString("room");
                    deposit = r.getString("deposit");


                }

                String str1 = "select * from addroom where roomno  = '"+room+"'";
                ResultSet r1 = c.s.executeQuery(str1);
                 while (r1.next()) {

                    price = r1.getString("price");
                    amount = Integer.parseInt(price) - Integer.parseInt(deposit);
                    t5.setText(Integer.toString(amount));
                 }
            }catch (Exception e){
                System.out.println(e);
            }

        }else if (ae.getSource()==b2){
            String number = c1.getSelectedItem();
            String room = t1.getText();
            String name = t2.getText();
            String checkInTime = t3.getText();
            String deposite = t4.getText();


            try {
                Conn c = new Conn();
                c.s.executeUpdate("Update addcustomer set room = '"+room+"', name = '"+name+"', status = '"+checkInTime+"', deposit='"+deposite+"' ");
                JOptionPane.showMessageDialog(null,"Data Updated Successfully");
                this.setVisible(false);
                new Reception();
            }catch (Exception e){
                System.out.println(e);
            }
        }else if (ae.getSource()==b3){

           this.setVisible(false);
           new Reception().setVisible(true);

        }

    }
}
