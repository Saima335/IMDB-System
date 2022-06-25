/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongo_semester_project;

import java.awt.Color;
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

/**
 *
 * @author chaud
 */

public class main_menu extends JFrame
{
    JButton b1,b2,b3,b4,b5,b6,b7;
    JFrame frame;
    JLabel l1;
    main_menu()
    {
        setBackground(Color.BLUE); 
        setLayout(null); 
        setSize(1000,800); 
        l1=new JLabel(); 
        l1.setBounds(0,0,1600,800); 
        ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("Images/MOVIES 3.jpg")); 
        Image i3=ic.getImage().getScaledInstance(1600, 800, Image.SCALE_DEFAULT); 
        ImageIcon icc3=new ImageIcon(i3); 
        l1.setIcon(icc3); 
        add(l1); 
        l1.setLayout(null); 
        b1=new JButton("SEARCH MOVIES"); 
        b1.setBounds(600,100,300,50); 
        b1.setForeground(Color.ORANGE); 
        b1.setBackground(Color.BLACK); 
        b1.setFont(new Font("serif",Font.ITALIC,20)); 
        b2=new JButton("SORT MOVIES RECORD"); 
        b2.setBounds(600,250,300,50); 
        b2.setForeground(Color.ORANGE); 
        b2.setBackground(Color.BLACK); 
        b2.setFont(new Font("serif",Font.ITALIC,20)); 
        b3=new JButton("SHOW MOVIES COMMENTS"); 
        b3.setBounds(600,400,300,50); 
        b3.setForeground(Color.ORANGE); 
        b3.setBackground(Color.BLACK); 
        b3.setFont(new Font("serif",Font.ITALIC,20)); 
        
        b4=new JButton("HOME"); 
        b4.setBounds(600,550,300,50); 
        b4.setForeground(Color.ORANGE); 
        b4.setBackground(Color.BLACK); 
        b4.setFont(new Font("serif",Font.ITALIC,20)); 
       
        
       
       
        MyActionListener m=new MyActionListener(); 
        b1.addActionListener(m); 
        b2.addActionListener(m); 
        b3.addActionListener(m); 
        b4.addActionListener(m); 
        //b5.addActionListener(m); 
           // b7.addActionListener(m); 
        l1.add(b1); 
        l1.add(b2); 
        l1.add(b3); 
        l1.add(b4); 
        //l1.add(b5);
        setVisible(true); 
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
    }
    public class MyActionListener implements ActionListener
    {
      public void actionPerformed(ActionEvent ae)
      {
         if(ae.getActionCommand()=="SEARCH MOVIES")
         {
             dispose();
             search d= new search();
         }
         if(ae.getActionCommand()=="SORT MOVIES RECORD")
         {
             dispose();
             sort a= new sort();
         }
         if(ae.getActionCommand()=="SHOW MOVIES COMMENTS")
         {
             dispose();
             comments f= new comments();
         }
         
         if(ae.getActionCommand()=="HOME")
         {
             dispose();
             admin_page c= new admin_page();
         }
      }
    }
}
