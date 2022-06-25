/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongo_semester_project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class admin_page extends JFrame
{
    JLabel l1,l2,l3;
    JTextField t1,t2,t3;
    JButton b1,b2;
    admin_page()
    {
        setBackground(Color.BLUE); 
        setLayout(null); 
        setSize(1000,800); 
        l1=new JLabel(); 
        l1.setBounds(0,0,1600,800); 
        ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("Images/MOVIES 1.jpg")); 
        Image i3=ic.getImage().getScaledInstance(1600, 800, Image.SCALE_DEFAULT); 
        ImageIcon icc3=new ImageIcon(i3); 
        l1.setIcon(icc3); 
        add(l1); 
        l1.setLayout(null); 
        l2= new JLabel("ENTER ADMIN USERNAME");
        l2.setBounds(300,200,500,40);
        l2.setBackground(Color.black);
        l2.setForeground(Color.orange);
        l2.setFont(new Font("serif",Font.BOLD,20));
        t2= new JTextField(20);
        t2.setBounds(600,200,500,30);
        t2.setForeground(Color.black);
        t2.setBackground(Color.WHITE);
        l3= new JLabel("ENTER ADMIN PASSWORD");
        l3.setBounds(300,300,500,40);
        l3.setBackground(Color.black);
        l3.setForeground(Color.orange);
        l3.setFont(new Font("serif",Font.BOLD,20));
        t3= new JTextField(20);
        t3.setBounds(600,300,500,30);
        t3.setForeground(Color.black);
        t3.setBackground(Color.WHITE);
        b1=new JButton("SUBMIT"); 
        b1.setBounds(700,500,200,30); 
        b1.setForeground(Color.ORANGE); 
        b1.setBackground(Color.BLACK); 
        b1.setFont(new Font("serif",Font.ITALIC,20)); 
        b2=new JButton("EXIT"); 
        b2.setBounds(400,500,200,30); 
        b2.setForeground(Color.ORANGE); 
        b2.setBackground(Color.BLACK); 
        b2.setFont(new Font("serif",Font.ITALIC,20)); 
        
        MyActionListener m=new MyActionListener(); 
        b1.addActionListener(m); 
        b2.addActionListener(m); 
        l1.add(l2);
        l1.add(t2);
        l1.add(l3);
        l1.add(t3);
        l1.add(b1); 
        l1.add(b2); 
        
        setVisible(true); 
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
    public class MyActionListener implements ActionListener
    {
      public void actionPerformed(ActionEvent ae)
      {
        
         if(ae.getActionCommand()=="SUBMIT")
         {
             if(t2.getText().isEmpty() || t3.getText().isEmpty())
             {
                 JOptionPane.showMessageDialog(null, "PLEASE FIRST FILL ALL TEXT FILEDS");
             }
             else
             {
                 if(t2.getText().equals("nimra") && t3.getText().equals("xyz123"))
                 {
                    JOptionPane.showMessageDialog(null,"VALID ACCESS");
                     dispose();
                     main_menu m= new main_menu();
                 }
                 else
                 {
                     JOptionPane.showMessageDialog(null,"INVALID ACCESS");
                     dispose();
                     //search_movies m= new search_movies();
                 }
             }
         }    
         if(ae.getActionCommand()=="EXIT")
         {
             dispose();
             
         }
      }
    }
    
}

