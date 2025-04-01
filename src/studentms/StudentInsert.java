/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentms;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
/**
 
 * @author Sohan
 */
public class StudentInsert extends JFrame{
    JPanel jp;
    JLabel lRo, lNa, lAd, lGe, lPh, lEm;
    JTextField tRo, tNa, tAd, tPh, tEm;
    JComboBox cGe;
    JButton submit, operation, display;
    
    Connection c = Database.connect();
    Statement st = null;
    
    Color bg = new Color(7,74,102);
    Color fg = new Color(230,231,240);
    Font font = new Font("Calibri",1,16);
    
    void init(){
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
    void components(){
        jp = new JPanel();
        jp.setBackground(bg);
        jp.setSize(400,400);
        jp.setLayout(null);
        add(jp);
        
        lRo = new JLabel("Roll no: ");
        lRo.setForeground(fg);
        lRo.setFont(font);
        lRo.setBounds(10, 10, 100, 20);
        jp.add(lRo);
        
        tRo = new JTextField();
        tRo.setBounds(120, 10, 160, 20);
        jp.add(tRo);
        
        lNa = new JLabel("Name: ");
        lNa.setForeground(fg);
        lNa.setFont(font);
        lNa.setBounds(10, 60, 100, 20);
        jp.add(lNa);
        
        tNa = new JTextField();
        tNa.setBounds(120, 60, 160, 20);
        jp.add(tNa);
        
        lAd = new JLabel("Address: ");
        lAd.setForeground(fg);
        lAd.setFont(font);
        lAd.setBounds(10, 110, 100, 20);
        jp.add(lAd);
        
        tAd = new JTextField();
        tAd.setBounds(120, 110, 160, 20);
        jp.add(tAd);
        
        lGe = new JLabel("Gender: ");
        lGe.setForeground(fg);
        lGe.setFont(font);
        lGe.setBounds(10, 160, 100, 20);
        jp.add(lGe);
        
        String[] items = {"Male" , "Female", "Transgender"};
        cGe = new JComboBox<>(items);
        cGe.setBounds(120, 160, 120, 20);
        jp.add(cGe);
        
        lPh = new JLabel("Phone no: ");
        lPh.setForeground(fg);
        lPh.setFont(font);
        lPh.setBounds(10, 210, 100, 20);
        jp.add(lPh);
        
        tPh = new JTextField();
        tPh.setBounds(120, 210, 160, 20);
        jp.add(tPh);
        
        lEm = new JLabel("Email: ");
        lEm.setForeground(fg);
        lEm.setFont(font);
        lEm.setBounds(10, 260, 100, 20);
        jp.add(lEm);
        
        tEm = new JTextField();
        tEm.setBounds(120, 260, 160, 20);
        jp.add(tEm);
        
        submit = new JButton("Submit");
        submit.setBounds(10, 310, 80, 25);
        jp.add(submit);
        
        display = new JButton("Display");
        display.setBounds(110, 310, 80, 25);
        jp.add(display);
        
        operation = new JButton("Operation");
        operation.setBounds(210, 310, 100, 25);
        jp.add(operation);
        
        display.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                View v = new View();
                v.loadData();
            }
        });
        
        submit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               submitPerformed(e);
            }
        });
        
        operation.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Operation op = new Operation();
                op.init();
            }
        });
        setVisible(true);
    }
    
    void submitPerformed(ActionEvent e){
        try {
            String na,ad,g,ph,em;
            int roll;
            st = c.createStatement();
            if(("".equals(tRo.getText()))&&("".equals(tNa.getText()))&&("".equals(tAd.getText()))&&("".equals(tPh.getText()))&&("".equals(tEm.getText()))){
                JOptionPane.showMessageDialog(new JFrame(), "Fill all the details","Dialog",JOptionPane.ERROR_MESSAGE);
            }
            else{
                na = tNa.getText();
                ad = tAd.getText();
                g = (String)cGe.getSelectedItem();
                ph = tPh.getText();
                em = tEm.getText();
                roll = Integer.parseInt(tRo.getText());
                
                String query = "INSERT INTO student (sroll,sname,saddress,sgender,sphone,semail) VALUES ('"+roll+"','"+na+"','"+ad+"','"+g+"','"+ph+"','"+em+"')";
                
                st.executeUpdate(query);
                JOptionPane.showMessageDialog(rootPane,"Successfully Registered!","Dialog",JOptionPane.OK_OPTION);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
