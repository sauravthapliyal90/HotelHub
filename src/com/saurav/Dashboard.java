package com.saurav;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Dashboard extends JFrame implements ActionListener {
    JMenuBar mb;
    JMenu m1,m2;
    JMenuItem i1,i2,i3,i4;

    Dashboard(){
     mb =new JMenuBar();
     add(mb);

     m1 = new JMenu("HOTEL MANAGEMENT");
     m1.setForeground(Color.BLACK);
     mb.add(m1);

     m2 = new JMenu("ADMIN");
     m2.setForeground(Color.BLACK);
     mb.add(m2);

     i1 = new JMenuItem("RECEPTION");
     i1.addActionListener(this);
     m1.add(i1);

     i2 = new JMenuItem("ADD EMPLOYEE");
     i2.addActionListener(this);
     m2.add(i2);

     i3 = new JMenuItem("ADD ROOM");
     i3.addActionListener(this);
     m2.add(i3);
//
//     i4 = new JMenuItem("ADD DRIVERS");
//     i4.addActionListener(this);
//     m2.add(i4);

     mb.setBounds(0,0,1950,30);

     ImageIcon im = new ImageIcon(ClassLoader.getSystemResource("com/icon/hotel.jpg"));
     Image im3 = im.getImage().getScaledInstance(1365,730,Image.SCALE_DEFAULT);
     ImageIcon im4 = new ImageIcon(im3);
     JLabel im2= new JLabel(im4);
     im2.setBounds(0,0,1365,730);
     add(im2);


     JLabel j6 = new JLabel("WELCOME TO HOTEL MANAGEMENT SYSTEM");
     j6.setBounds(350,35,800,100);
     j6.setForeground(Color.WHITE);
     j6.setFont(new Font("Tahoma",Font.PLAIN,35));
     im2.add(j6);

     setBounds(0,0,1370,730);
        setLayout(null);
     setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
          if(ae.getActionCommand().equals("RECEPTION")){
          new Reception().setVisible(true);
            }
          else if(ae.getActionCommand().equals("ADD EMPLOYEE")){
              new AddEmployee().setVisible(true);
            }
          else if(ae.getActionCommand().equals("ADD ROOM")){
              new AddRoom().setVisible(true);
          }
    }

}
