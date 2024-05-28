package com.saurav;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckOut extends JFrame implements ActionListener {
    Choice  customer;
    JLabel lblroomnumber, lblcheckintime,lblCheckOutTime;
    JButton b1,b2;
    CheckOut(){
     getContentPane().setBackground(Color.WHITE);
     setLayout(null);

     JLabel text = new JLabel("Check-Out");
     text.setForeground(Color.blue);
     text.setFont(new Font("tahoma",Font.PLAIN,20));
     text.setBounds(100,20,100,30);
     add(text);

     JLabel lblid = new JLabel("Customer-id");
     lblid.setBounds(30,80,100,30);
     add(lblid);

        customer = new Choice();

        customer.setBounds(150,80,150,25);
        add(customer);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("com/icon/tick.png"));
        Image img2 = img.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon im3 = new ImageIcon(img2);
        JLabel jl1 = new JLabel(im3);
        jl1.setBounds(310,80,20,20);
        add(jl1);

        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(30,130,100,30);
        add(lblroom);

         lblroomnumber = new JLabel();
        lblroomnumber.setBounds(150,130,100,30);
        add(lblroomnumber);

        JLabel lblcheckin = new JLabel("Check-In Time");
        lblcheckin.setBounds(30,180,100,30);
        add(lblcheckin);

         lblcheckintime = new JLabel();
        lblcheckintime.setBounds(150,180,200,30);
        add(lblcheckintime);

        JLabel lblCheckOut = new JLabel("Check-Out Time");
        lblCheckOut.setBounds(30,230,100,30);
        add(lblCheckOut);


        Date dt = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

        // Format the date and time portions as strings
        String formattedDate = dateFormat.format(dt);
        String formattedTime = timeFormat.format(dt);


        lblCheckOutTime = new JLabel(formattedTime+" "+formattedDate);
        lblCheckOutTime.setBounds(150,230,200,30);
        add(lblCheckOutTime);

        b1 = new JButton("Check-Out");
        b1.setBackground(Color.black);
        b1.setForeground(Color.WHITE);
        b1.setBounds(30,280,120,30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setBackground(Color.black);
        b2.setForeground(Color.WHITE);
        b2.setBounds(170,280,120,30);
        b2.addActionListener(this);
        add(b2);

        ImageIcon im = new ImageIcon(ClassLoader.getSystemResource("com/icon/sixth.jpg"));
        Image im2 = im.getImage().getScaledInstance(400,250,Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(im2);
        JLabel jl = new JLabel(img3);
        jl.setBounds(350,50,400,250);
        add(jl);

        try{
            Conn c = new Conn();

            ResultSet r = c.s.executeQuery("select * from addcustomer");
            while(r.next()){

                lblroomnumber.setText(r.getString("room"));
                lblcheckintime.setText(r.getString("status"));
                customer.add(r.getString("number"));

            }

        }catch (Exception ea){
            System.out.println(ea);
        }

     setBounds(300,200,800,400);
     setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){

            String q1 = "delete from addcustomer where number = '"+customer.getSelectedItem()+"'";
            String q2 = "update addroom set available = 'Available' where roomno = '"+lblroomnumber.getText()+"'";
            try{
                Conn c = new Conn();
                c.s.executeUpdate(q1);
                c.s.executeUpdate(q2);

                JOptionPane.showMessageDialog(null,"Check-Out Done");
                this.setVisible(false);
                new Reception();
            }catch (Exception ea){
                System.out.println(ea);
            }
        }else if(e.getSource()==b2){
            this.setVisible(false);
            new Reception();
        }
    }

}
