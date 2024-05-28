package com.saurav;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public  class Main extends JFrame implements ActionListener {
 JLabel l1,l2;
 JTextField t1,t2;
 JPasswordField t3;
 JButton b1,b2;
    Main(){
        l1 = new JLabel("Username");
        l1.setBounds(40,40,100,30);
        add(l1);

        l2 = new JLabel("Password");
        l2.setBounds(40,90,100,30);
        add(l2);

        t1 = new JTextField();
        t1.setBounds(150,40,150,30);
        add(t1);

        t2 = new JPasswordField();
        t2.setBounds(150,90,150,30);
        add(t2);

        b1 = new JButton("Login");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(40,170,120,30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(180,170,120,30);
        b2.addActionListener(this);
        add(b2);

        getContentPane().setBackground(Color.WHITE);

        ImageIcon li = new ImageIcon(ClassLoader.getSystemResource("com/icon/ic.png"));
        Image il = li.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon il1 =new ImageIcon(il);
        JLabel l3 =new JLabel(il1);
        l3.setBounds(350,10,200,200);
        add(l3);


        setBounds(400,200,600,300);
    setLayout(null);
    setVisible(true);
   }
     public void actionPerformed(ActionEvent ae){
      if (ae.getSource()==b1){
          String usename = t1.getText();
          String pass = t2.getText();

           Conn c = new Conn();
       String str = "select * from login where username = '"+usename+"' and password ='"+pass+"'";
        try {
           ResultSet r =  c.s.executeQuery(str);

              if (r.next()){
              new Dashboard().setVisible(true);
              this.setVisible(false);
              }else{
              JOptionPane.showMessageDialog(null,"Invalid username and password");
              }

        }catch(Exception e){
            System.out.println("empty");
             }
      }
      else if(ae.getSource()==b2){
          System.exit(0);
         }
     }
      public static void main(String[] args) {

       new Main();

    }

}
