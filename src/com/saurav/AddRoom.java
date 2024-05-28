package com.saurav;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRoom extends JFrame implements ActionListener {

    JTextField t1,t2;
    JComboBox c1,c2,c3;
    JButton b1,b2;

     AddRoom(){
        
        JLabel l1 = new JLabel("ADD ROOMS");
        l1.setFont(new Font("Taboma",Font.BOLD,16));
        l1.setBounds(150,20,100,20);
        add(l1);

        JLabel l2 = new JLabel("Room Number");
        l2.setFont(new Font("Taboma",Font.PLAIN,14));
        l2.setBounds(60,80,100,30);
        add(l2);

        t1 = new JTextField();
        t1.setBounds(200,80,150,30);
        add(t1);

         JLabel l3 = new JLabel("Available");
         l3.setFont(new Font("Taboma",Font.PLAIN,14));
         l3.setBounds(60,130,100,30);
         add(l3);

         c1 = new JComboBox(new String[]{"Available","Occupied"});
         c1.setBackground(Color.WHITE);
         c1.setBounds(200,130,150,30);
         add(c1);


         JLabel l4 = new JLabel("Cleaning Status");
         l4.setFont(new Font("Taboma",Font.PLAIN,14));
         l4.setBounds(60,180,100,30);
         add(l4);

         c2 = new JComboBox(new String[]{"Clean","Dirty"});
         c2.setBounds(200,180,150,30);
         c2.setBackground(Color.WHITE);
         add(c2);


         JLabel l5 = new JLabel("Price");
         l5.setFont(new Font("Taboma",Font.PLAIN,14));
         l5.setBounds(60,230,100,30);
         add(l5);

         t2 = new JTextField();
         t2.setBounds(200,230,150,30);
         add(t2);

         JLabel l6 = new JLabel("Bed Type");
         l6.setFont(new Font("Taboma",Font.PLAIN,14));
         l6.setBounds(60,280,100,30);
         add(l6);

         c3 = new JComboBox(new String[]{"Single Bed","Double Bed"});
         c3.setBackground(Color.WHITE);
         c3.setBounds(200,280,150,30);
         add(c3);

         b1 = new JButton("Add Room");
         b1.setBackground(Color.BLACK);
         b1.setForeground(Color.WHITE);
         b1.setBounds(60,350,130,30);
         b1.addActionListener(this);
         add(b1);

         b2 = new JButton("Cancel");
         b2.setBackground(Color.BLACK);
         b2.setForeground(Color.WHITE);
         b2.setBounds(220,350,130,30);
         add(b2);

         getContentPane().setBackground(Color.WHITE);

         ImageIcon im = new ImageIcon(ClassLoader.getSystemResource("com/icon/room.jpg"));
         Image im2 = im.getImage().getScaledInstance(450,380,Image.SCALE_DEFAULT);
         ImageIcon im3 = new ImageIcon(im2);
         JLabel l0 = new JLabel(im3);
         l0.setBounds(350,30,500,350);
         add(l0);

         setBounds(270,180,880,460);
        setLayout(null);
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){

            String roomNo = t1.getText();
            String available = (String) c1.getSelectedItem();
            String clean = (String)c2.getSelectedItem();
            String price = t2.getText();
            String bed = (String) c3.getSelectedItem();

            Conn c = new Conn();

            String str = "insert into addRoom values ('"+roomNo+"','"+available+"','"+clean+"','"+price+"','"+bed+"')";
            try{
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"ROOM ADDED");
                this.setVisible(false);
            }catch(Exception ea){

            }

        }
        else if(e.getSource()==b2){
            this.setVisible(false);
        }
    }
}
