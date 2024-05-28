package com.saurav;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener{
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;

    public Reception(){
        b1 = new JButton("New Customer Form");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(10,30,200,30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Room");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(10,78,200,30);
        b2.addActionListener(this);
        add(b2);


        b4 = new JButton("All Employee Info");
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.setBounds(10,126,200,30);
        b4.addActionListener(this);
        add(b4);

        b5= new JButton(" Customer Info");
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        b5.setBounds(10,174,200,30);
        b5.addActionListener(this);
        add(b5);

        b6 = new JButton("Manager Info");
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.WHITE);
        b6.setBounds(10,222,200,30);
        b6.addActionListener(this);
        add(b6);

        b7 = new JButton("Check Out");
        b7.setBackground(Color.BLACK);
        b7.setForeground(Color.WHITE);
        b7.setBounds(10,270,200,30);
        b7.addActionListener(this);
        add(b7);

        b8 = new JButton("Update Check Status");
        b8.setBackground(Color.BLACK);
        b8.setForeground(Color.WHITE);
        b8.setBounds(10,318,200,30);
        b8.addActionListener(this);
        add(b8);

        b9 = new JButton("Update Room Status");
        b9.setBackground(Color.BLACK);
        b9.setForeground(Color.WHITE);
        b9.setBounds(10,366,200,30);
        b9.addActionListener(this);
        add(b9);



        b11 = new JButton("Search Room");
        b11.setBackground(Color.BLACK);
        b11.setForeground(Color.WHITE);
        b11.setBounds(10,414,200,30);
        b11.addActionListener(this);
        add(b11);

        b12 = new JButton("Logout");
        b12.setBackground(Color.BLACK);
        b12.setForeground(Color.WHITE);
        b12.setBounds(10,462,200,30);
        b12.addActionListener(this);
        add(b12);

        getContentPane().setBackground(Color.WHITE);

        ImageIcon im = new ImageIcon(ClassLoader.getSystemResource("com/icon/reception.jpg"));
        Image im2 = im.getImage().getScaledInstance(500,470,Image.SCALE_DEFAULT);
        ImageIcon im3 = new ImageIcon(im2);
        JLabel j1 = new JLabel(im3);
        j1.setBounds(250,16,500,500);
        add(j1);

        setLayout(null);
        setBounds(320,140,800,570);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==b1){

           new AddCustomer();
           this.setVisible(false);

       }else if(e.getSource()==b2){

           new RoomInfo();
           this.setVisible(false);

       }else if(e.getSource()==b4){

           new EmployeeInfo();
           this.setVisible(false);

       }else if(e.getSource()==b5){

           new CustomerInfo();
           this.setVisible(false);

       }else if(e.getSource()==b6){

           new ManagerInfo().setVisible(true);
           this.setVisible(false);

       }else if(e.getSource()==b7){
           setVisible(false);
           new CheckOut();

       }else if(e.getSource()==b8){

           new UpdateCheck().setVisible(true);
           this.setVisible(false);

       }else if(e.getSource()==b9){

           new UpdateRoom().setVisible(true);
           this.setVisible(false);

       }else if(e.getSource()==b11){

          this.setVisible(false);
          new SearchRoom();
       }else if(e.getSource()==b12){

           setVisible(false);
           System.exit(0);
      }

    }
}
