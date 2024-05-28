package com.saurav;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class AddCustomer extends JFrame implements ActionListener {

    JTextField t1,t2,t3,t4,t5;
    JButton b1,b2;
    JComboBox c1;
    Choice c2 ;
    JRadioButton r1,r2;

    AddCustomer(){
       JLabel l1 = new JLabel("NEW CUSTOMER FORM");
       l1.setBounds(100,20,300,30);
       l1.setForeground(Color.BLUE);
       l1.setFont(new Font("Tahoma",Font.PLAIN,20));
       add(l1);

       JLabel l2 = new JLabel("ID");
       l2.setBounds(35,80,100,20);
       add(l2);

       c1 = new JComboBox(new String[]{"Passport","Voter-id card","Aadhar card"});
       c1.setBounds(200,80,150,20);
       c1.setBackground(Color.WHITE);
       add(c1);

        JLabel l3 = new JLabel("Number");
        l3.setBounds(35,120,100,20);
        add(l3);

        t1 = new JTextField();
        t1.setBounds(200,120,150,20);
        add(t1);

        JLabel l4 = new JLabel("Name");
        l4.setBounds(35,160,100,20);
        add(l4);

        t2 = new JTextField();
        t2.setBounds(200,160,150,20);
        add(t2);


        JLabel l5 = new JLabel("Gender");
        l5.setBounds(35,200,100,20);
        add(l5);

        r1 =new JRadioButton("Male");
        r1.setBackground(Color.WHITE);
        r1.setBounds(200,200,60,25);
        add(r1);

        r2 =new JRadioButton("Female");
        r2.setBackground(Color.WHITE);
        r2.setBounds(270,200,70,25);
        add(r2);

        JLabel l6 = new JLabel("Country");
        l6.setBounds(35,240,100,20);
        add(l6);


        t3 = new JTextField();
        t3.setBounds(200,240,150,20);
        add(t3);

        JLabel l7 = new JLabel("Allocated Room Number");
        l7.setBounds(35,280,150,20);
        add(l7);

        c2 = new Choice();
        try{
            Conn c = new Conn();
            String str ="SELECT * FROM addroom where available ='Available'";
            ResultSet r = c.s.executeQuery(str);
            while(r.next()){
                c2.add(r.getString("roomno"));
            }

        }catch(Exception e){
            System.out.println(e);
        }

        c2.setBounds(200,280,150,25);
        add(c2);

        JLabel l8 = new JLabel("Check-in Time");
        l8.setBounds(35,320,100,20);
        add(l8);

        Date dt = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

        // Format the date and time portions as strings
        String formattedDate = dateFormat.format(dt);
        String formattedTime = timeFormat.format(dt);

        t4 = new JTextField(formattedTime+" "+formattedDate);
        t4.setBounds(200,320,150,20);
        add(t4);


        JLabel l9 = new JLabel("Deposit");
        l9.setBounds(35,360,100,20);
        add(l9);

        t5 = new JTextField();
        t5.setBounds(200,360,150,20);
        add(t5);

        b1= new JButton("Add Customer");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(35,400,150,30);
        b1.addActionListener(this);
        add(b1);

        b2= new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(200,400,150,30);
        b2.addActionListener(this);
        add(b2);

        getContentPane().setBackground(Color.WHITE);

        ImageIcon im = new ImageIcon(ClassLoader.getSystemResource("com/icon/customer.png"));
        Image i2 = im.getImage().getScaledInstance(330,300,Image.SCALE_DEFAULT);
        ImageIcon im2 = new ImageIcon(i2);
        JLabel j1 = new JLabel(im2);
        j1.setBounds(370,50,400,330);
        add(j1);



        setLayout(null);
        setBounds(310,140,800,500);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){

        if(e.getSource()==b1){
           String id = (String)c1.getSelectedItem();
           String number = t1.getText();
           String name = t2.getText();
           String gender = null;
            if(r1.isSelected()){
                gender= "Male";
            }
            else if(r2.isSelected()){
                gender = "Female";
            }
           String country = t3.getText();
           String room = c2.getSelectedItem();
           String status = t4.getText();
           String deposit = t5.getText();

           Conn c = new Conn();

           String str = "insert into addcustomer values ('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+status+"','"+deposit+"')";
           String str2 = "update addroom set available ='Occupied' where roomno = '"+room+"'";
           try{
               c.s.executeUpdate(str);
               c.s.executeUpdate(str2);
               JOptionPane.showMessageDialog(null,"Customer Added");
               this.setVisible(false);
               new Reception();
           }catch (Exception ea){
               System.out.println(ea);
           }

        }else if(e.getSource()==b2){
          new Reception();
          this.setVisible(false);
        }
    }
}
