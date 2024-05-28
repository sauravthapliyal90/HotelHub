package com.saurav;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployee extends JFrame implements ActionListener {

    JTextField t1,t2,t3,t4,t5;
    JRadioButton r1,r2;
    JComboBox c1;
    JButton b1,b2;

    AddEmployee(){
    JLabel name = new JLabel("NAME");
    name.setFont(new Font("Tahoma",Font.PLAIN,17));
    name.setBounds(60,30,120,30);
    add(name);

    t1 = new JTextField();
    t1.setBounds(200,30,150,30);
    add(t1);

    JLabel age = new JLabel("AGE");
    age.setFont(new Font("Tahoma",Font.PLAIN,17));
    age.setBounds(60,80,120,30);
    add(age);

    t2 = new JTextField();
    t2.setBounds(200,80,150,30);
    add(t2);

    JLabel gender = new JLabel("GENDER");
    gender.setFont(new Font("Tahoma",Font.PLAIN,17));
    gender.setBounds(60,130,120,30);
    add(gender);

    r1 = new JRadioButton("Male");
    r1.setFont(new Font("Tahon",Font.PLAIN,13));
    r1.setBounds(200,130,70,30);
    r1.setBackground(Color.WHITE);
    add(r1);

    r2 = new JRadioButton("Female");
    r2.setFont(new Font("Tahon",Font.PLAIN,13));
    r2.setBounds(270,130,70,30);
    r2.setBackground(Color.WHITE);
    add(r2);

    ButtonGroup bg = new ButtonGroup();
    bg.add(r2);
    bg.add(r1);


    JLabel job = new JLabel("DEPARTMENT");
    job.setFont(new Font("Tahoma",Font.PLAIN,17));
    job.setBounds(60,180,120,30);
    add(job);

    String st[] = {"Front Desk Clerks","Housekeeper","Kitchen Staff","Room Service","Waiter","Manager"};
    c1 = new JComboBox(st);
    c1.setBackground(Color.WHITE);
    c1.setBounds(200,180,150,30);
    add(c1);

    JLabel salary = new JLabel("SALARY");
    salary.setFont(new Font("Tahoma",Font.PLAIN,17));
    salary.setBounds(60,230,120,30);
    add(salary);

    t3 = new JTextField();
    t3.setBounds(200,230,150,30);
    add(t3);

    JLabel phone = new JLabel("PHONE");
    phone.setFont(new Font("Tahoma",Font.PLAIN,17));
    phone.setBounds(60,280,120,30);
    add(phone);

   t4 = new JTextField();
   t4.setBounds(200,280,150,30);
   add(t4);

   JLabel email = new JLabel("EMAIL");
   email.setFont(new Font("Tahoma",Font.PLAIN,17));
   email.setBounds(60,330,120,30);
   add(email);

   t5 = new JTextField();
   t5.setBounds(200,330,150,30);
   add(t5);


        getContentPane().setBackground(Color.WHITE);

   ImageIcon im1 = new ImageIcon(ClassLoader.getSystemResource("com/icon/employee.png"));
   Image i2 = im1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
   ImageIcon i3 = new ImageIcon(i2);
   JLabel li = new JLabel(i3);
   li.setBounds(420,140,200,200);
   add(li);


   JLabel j1 = new JLabel("ADD EMPLOYEE DETAILS");
   j1.setForeground(Color.BLUE);
   j1.setBounds(400,30,250,20);
    j1.setFont(new Font("Tahoma", Font.PLAIN,20));
   add(j1);

   b1 = new JButton("Submit");
   b1.setBackground(Color.BLACK);
   b1.setForeground(Color.WHITE);
   b1.setBounds(200,380,150,40);
   b1.addActionListener(this);
   add(b1);



        setLayout(null);
    setBounds(370,160,700,500);
    setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String name = t1.getText();
        String age  = t2.getText();
        String salary  = t3.getText();
        String phone  = t4.getText();
        String email  = t5.getText();


        String gender = null;
       if(r1.isSelected()){
           gender = "Male";
       }
       else if(r2.isSelected()){
           gender = "Female";
       }

       String job = (String) c1.getSelectedItem();

       Conn c = new Conn();

       String str = "INSERT INTO add_emp VALUES ('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"')";
       try{
           c.s.executeUpdate(str);
           JOptionPane.showMessageDialog(null,"New Employee Added");
           this.setVisible(false);

       }catch(Exception e){
           System.out.println(e);
       }
    }

}
