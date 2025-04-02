/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentms;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Sohan
 */
public class Components {
    MyFrame m;
    JPanel jp;
    JLabel un,up;
    JTextField tf;
    JPasswordField pf;
    JButton btn;
    
    Connection c = Database.connect();
    Statement st = null;
    
    Color bg = new Color(7,74,102);
    Color fg = new Color(230,231,240);
    Font font = new Font("Calibri",1,16);
    
    Components(MyFrame m){
        this.m = m;
        jp = new JPanel(); //panel
        jp.setSize(400, 300);
        jp.setBackground(bg);
        jp.setLayout(null);
        m.add(jp);
        
        un = new JLabel("User Name: "); //label username
        un.setFont(font);
        un.setForeground(fg);
        un.setBounds(20,60,100,20);
        jp.add(un);
        
        up = new JLabel("Password: "); //label password
        up.setFont(font);
        up.setForeground(fg);
        up.setBounds(20,120,100,20);
        jp.add(up);
        
        tf = new JTextField();
        tf.setBounds(120, 60, 140, 20);
        jp.add(tf);
        
        pf = new JPasswordField();
        pf.setBounds(120, 120, 140, 20);
        jp.add(pf);
        
        btn = new JButton("Submit");
        btn.setFont(font);
        btn.setBounds(120, 160, 100, 25);
        jp.add(btn);
        
        btn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               loginPerformed(e); 
            }
        });
        
        m.setVisible(true);
    }
    
    private void loginPerformed(ActionEvent e){
        try {
            st = c.createStatement();
            String u = tf.getText();
            String p = pf.getText();
            
            String query = "SELECT* FROM login WHERE username = '"+u+"' and password = '"+p+"' ";
            ResultSet rs = st.executeQuery(query);
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Login Successfull!");
                m.dispose();
                StudentInsert si = new StudentInsert();
                si.init();
                si.components();
            }
            else{
                JOptionPane.showMessageDialog(null, "Enter Valid Username/Password");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }
}
