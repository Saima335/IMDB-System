/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongo_semester_project;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import java.awt.Color;
import java.awt.Font;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBList;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import com.mongodb.*;
import java.awt.BorderLayout;
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
//import static javafx.scene.Cursor.cursor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author chaud
 */
public class sort extends JFrame {

    JButton b1, b2, b3, b4, b5, b6, b7;
    JFrame frame;
    JLabel l1, l2;
    JTextField t1;

    sort() {
        setBackground(Color.BLUE);
        setLayout(null);
        setSize(1000, 800);
        l1 = new JLabel();
        l1.setBounds(0, 0, 1600, 800);
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("Images/MOVIES 2.jpg"));
        Image i3 = ic.getImage().getScaledInstance(1600, 800, Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        l1.setIcon(icc3);
        add(l1);
        l1.setLayout(null);
        l2 = new JLabel("ENTER TEXT");
        l2.setBounds(400, 100, 500, 40);
        l2.setBackground(Color.black);
        l2.setForeground(Color.orange);
        l2.setFont(new Font("serif", Font.BOLD, 20));
        t1 = new JTextField(20);
        t1.setBounds(600, 100, 300, 30);
        t1.setForeground(Color.black);
        t1.setBackground(Color.WHITE);
        b1 = new JButton("SORT MOVIES RECORD ON THE BASE OF IMDB RATING");
        b1.setBounds(500, 200, 600, 50);
        b1.setForeground(Color.ORANGE);
        b1.setBackground(Color.BLACK);
        b1.setFont(new Font("serif", Font.ITALIC, 20));
        b2 = new JButton("SORT MOVIES RECORD ON THE BASE OF NUMBERS OF AWARDS WIN");
        b2.setBounds(500, 300, 600, 50);
        b2.setForeground(Color.ORANGE);
        b2.setBackground(Color.BLACK);
        b2.setFont(new Font("serif", Font.ITALIC, 20));
        b3 = new JButton("SORT MOVIES RECORD ON THE BASE OF YEAR");
        b3.setBounds(500, 400, 600, 50);
        b3.setForeground(Color.ORANGE);
        b3.setBackground(Color.BLACK);
        b3.setFont(new Font("serif", Font.ITALIC, 20));

        b4 = new JButton("SORT MOVIES RECORD ON THE BASE OF RUNTIME");
        b4.setBounds(500, 500, 600, 50);
        b4.setForeground(Color.ORANGE);
        b4.setBackground(Color.BLACK);
        b4.setFont(new Font("serif", Font.ITALIC, 20));

        b5 = new JButton("SORT MOVIES RECORD ON THE BASE OF VOTES");
        b5.setBounds(500, 600, 600, 50);
        b5.setForeground(Color.ORANGE);
        b5.setBackground(Color.BLACK);
        b5.setFont(new Font("serif", Font.ITALIC, 20));

        b6 = new JButton("HOME");
        b6.setBounds(500, 700, 600, 50);
        b6.setForeground(Color.ORANGE);
        b6.setBackground(Color.BLACK);
        b6.setFont(new Font("serif", Font.ITALIC, 20));

        MyActionListener m = new MyActionListener();
        b1.addActionListener(m);
        b2.addActionListener(m);
        b3.addActionListener(m);
        b4.addActionListener(m);
        b5.addActionListener(m);
        b6.addActionListener(m);
        
        l1.add(b1);
        l1.add(b2);
        l1.add(b3);
        l1.add(b4);
        l1.add(b5);
        l1.add(b6);
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public class MyActionListener implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            String value = t1.getText();
            MongoClient mongoclient = null;
            try {
                mongoclient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
                DB mydb = mongoclient.getDB("testdb");
                DBCollection mycollection = mydb.getCollection("movies");
                BasicDBObject query = new BasicDBObject("title", value);
                DBCursor cursor1 = mycollection.find(query);
                if (!cursor1.hasNext()) {

                    display(cursor1);
                    JOptionPane.showMessageDialog(null, "Movie doestnot exist");

                }
                //String query = "";
                if (ae.getActionCommand() == "SORT MOVIES RECORD ON THE BASE OF IMDB RATING") {
                    dispose();
                    BasicDBObject sorting = null;
                   
                    sorting = new BasicDBObject("imdb.rating", 1);
                    DBCursor cursor = mycollection.find().sort(sorting);
                    JOptionPane.showMessageDialog(null, "sorted with rating");
                    display(cursor);

                    search d = new search();
                }
                if (ae.getActionCommand() == "SORT MOVIES RECORD ON THE BASE OF NUMBERS OF AWARDS WIN") {
                    BasicDBObject sorting = null;
                    sorting = new BasicDBObject("awards.wins", 1);
                    DBCursor cursor = mycollection.find().sort(sorting);
                    JOptionPane.showMessageDialog(null, "sorted with number of awrads");
                    display(cursor);
                }
                if (ae.getActionCommand() == "SORT MOVIES RECORD ON THE BASE OF YEAR") {
                    BasicDBObject sorting = null;
                    sorting = new BasicDBObject("year", 1);
                    DBCursor cursor = mycollection.find().sort(sorting);
                    JOptionPane.showMessageDialog(null, "sorted with year");
                    display(cursor);
                }
                if (ae.getActionCommand() == "SORT MOVIES RECORD ON THE BASE OF RUNTIME") {
                    BasicDBObject sorting = null;
                    sorting = new BasicDBObject("runtime", 1);
                    DBCursor cursor = mycollection.find().sort(sorting);
                    JOptionPane.showMessageDialog(null, "sorted with runtime");
                    display(cursor);
                }
                if (ae.getActionCommand() == "SORT MOVIES RECORD ON THE BASE OF VOTES") {
                    BasicDBObject sorting = null;
                    sorting = new BasicDBObject("imdb.votes", 1);
                    DBCursor cursor = mycollection.find().sort(sorting);
                    JOptionPane.showMessageDialog(null, "sorted with votes");
                    display(cursor);
                }

                if (ae.getActionCommand() == "HOME") {
                    dispose();
                    main_menu c = new main_menu();
                }
            } catch (UnknownHostException unknownHostException) {
                unknownHostException.printStackTrace();
            }

        }
    }

    public void display(DBCursor cursor) {
        JFrame m = new JFrame();
        DefaultTableModel model;
        model = new DefaultTableModel();
        JTable jTabel1 = new JTable(model);
//jScrollPane1.setViewportView(jTable1);
        model.addColumn("MOVIE TITLE");
        model.addColumn("MOVIE YEAR");
        model.addColumn("MOVIE RUNTIME");
        model.addColumn("MOVIE PLOT");
        model.addColumn("MOVIE TYPE");
        model.addColumn("MOVIE DIRECTOR");
        model.addColumn("MOVIE IMDB");
        model.addColumn("MOVIE RATING");
        model.addColumn("MOVIE VOTES");
        model.addColumn("MOVIE COUNTRIES");
        model.addColumn("MOVIE GENRES");

    while (cursor.hasNext() ) 
    {
        DBObject document = cursor.next();
        Object Title = document.get("title");
        Object Year = document.get("year");
        Object Runtime = document.get("runtime");
        Object Plot = document.get("plot") + "\n\n";
        Object Type = document.get("type");
        Object Directors = document.get("directors");
        DBObject imbdV = (DBObject) document.get("imdb");
        Object IMBDRating = imbdV.get("rating");
        Object Votes = imbdV.get("votes");
        Object Countries = document.get("countries");
        Object Genres = document.get("genres");
        Object tbData[] = {Title, Year, Runtime, Plot, Type, Directors, IMBDRating, Votes, Countries, Genres};
        model.addRow(tbData);

    }
    m.setLayout(null);
    jTabel1.setBounds(50, 50, 5000,5000);
    m.setSize(1500, 1500);
    m.add(jTabel1);
    m.setVisible(true);

}

}
