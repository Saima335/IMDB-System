/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongo_semester_project;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author chaud
 */
public class comments extends JFrame
{
    JLabel l1,l;
    JTextField t1;
    JButton b1, b2;
    comments()
    {
       setBackground(Color.BLUE); 
        setLayout(null); 
        setSize(1000,800); 
        l=new JLabel(); 
        l.setBounds(0,0,1600,800); 
        ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("Images/MOVIES 5.jpg")); 
        Image i3=ic.getImage().getScaledInstance(1600, 800, Image.SCALE_DEFAULT); 
        ImageIcon icc3=new ImageIcon(i3); 
        l.setIcon(icc3); 
        add(l); 
        l.setLayout(null); 
        l1= new JLabel("ENTER MOVIE TITLE WHOSE COMENTS YOU WANT TO SEE");
        l1.setBounds(40,200,700,40);
        l1.setBackground(Color.BLACK);
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("serif",Font.BOLD,20));
        t1= new JTextField(20);
        t1.setBounds(800,200,500,30);
        t1.setForeground(Color.orange);
        t1.setBackground(Color.WHITE);
        
        b1=new JButton("SHOW COMMENTS"); 
        b1.setBounds(600,500,400,50); 
        b1.setForeground(Color.ORANGE); 
        b1.setBackground(Color.BLACK); 
        b1.setFont(new Font("serif",Font.ITALIC,20)); 
        b2=new JButton("HOME"); 
        b2.setBounds(600,600,400,50); 
        b2.setForeground(Color.ORANGE); 
        b2.setBackground(Color.BLACK); 
        b2.setFont(new Font("serif",Font.ITALIC,20)); 
        
        MyActionListener m=new MyActionListener(); 
        b1.addActionListener(m); 
        b2.addActionListener(m); 
        l.add(l1);
        l.add(t1);
       
        l.add(b1); 
        l.add(b2); 
        
        setVisible(true); 
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public class MyActionListener implements ActionListener
    {
      public void actionPerformed(ActionEvent ae)
      {
          MongoClient mongoclient= null;
         try {
           mongoclient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
         } catch (UnknownHostException unknownHostException) {
          unknownHostException.printStackTrace();
         }
         DB mydb=mongoclient.getDB("testdb");
         DBCollection test_collection= mydb.getCollection("movies");

         //String way_search= (String) searchby.getItemAt(searchby.getSelectedIndex());
         String query_based="";
         if(ae.getActionCommand()=="SHOW COMMENTS")
         {
             if(t1.getText().isEmpty())
             {
                 JOptionPane.showMessageDialog(null,"PLEASE FRST FILL THE TEXT FIELDS");  
             }
             else
             {
                   if(comments_backend.movie_id(t1.getText())!=" ")
                   {
                       if(comments_backend.comments(comments_backend.movie_id(t1.getText()))!=" ")
                       {
                           JOptionPane.showMessageDialog(null,"THAT MOVIE DON'T HAS ANY COMMENTS"); 
                           
                           dispose();
                           main_menu p= new main_menu();
                       }
                       else
                       {
                           JOptionPane.showMessageDialog(null,comments_backend.comments(comments_backend.movie_id(t1.getText())));
                       }
                   }
                   else
                   {
                            JOptionPane.showMessageDialog(null,"THAT MOVIE ID DONT EXIST"); 
                           dispose();
                           main_menu p= new main_menu();
                   }
                
             }
         
      }
         if(ae.getActionCommand()=="HOME")
         {
             dispose();
             main_menu c= new main_menu();
         }
    } 
}
}

