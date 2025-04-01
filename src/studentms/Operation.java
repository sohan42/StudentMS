/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentms;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.sql.*;
/**
 *
 * @author Sohan
 */
public class Operation extends JFrame{
    JLabel s,lRo, lNa, lAd, lGe, lPh, lEm;
    JTextField search,tRo, tNa, tAd, tPh, tEm;
    JComboBox cGe;
    JButton sBtn,update,delete,back;
    
    Connection c = Database.connect();
    Statement st =null;
    
    Operation(){
        setSize(380,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
    void init(){
        Color bg = new Color(7,74,102);
        Color fg = new Color(230,231,240);
        Font font = new Font("Calibri",1,16);
        
        JPanel p = new JPanel();
        p.setSize(380,600);
        p.setBackground(bg);
        p.setLayout(null);
        add(p);
        
        s = new JLabel("Search by Id");
        s.setForeground(fg);
        s.setFont(font);
        s.setBounds(20,30,100,20);
        p.add(s);
        
        search = new JTextField();
        search.setBounds(130,30,60,25);
        p.add(search);
        
        sBtn = new JButton("Search");
        sBtn.setBounds(210, 30, 80, 25);
        sBtn.setFont(font);
        p.add(sBtn);
        
        lRo = new JLabel("Roll no: ");
        lRo.setForeground(fg);
        lRo.setFont(font);
        lRo.setBounds(20, 70, 100, 20);
        p.add(lRo);
        
        tRo = new JTextField();
        tRo.setBounds(20, 100, 200, 25);
        p.add(tRo);
        
        lNa = new JLabel("Name: ");
        lNa.setForeground(fg);
        lNa.setFont(font);
        lNa.setBounds(20, 140, 100, 20);
        p.add(lNa);
        
        tNa = new JTextField();
        tNa.setBounds(20, 170, 100, 25);
        p.add(tNa);
        
        lAd = new JLabel("Address: ");
        lAd.setForeground(fg);
        lAd.setFont(font);
        lAd.setBounds(20, 210, 100, 20);
        p.add(lAd);
        
        tAd = new JTextField();
        tAd.setBounds(20, 240, 200, 25);
        p.add(tAd);
        
        lGe = new JLabel("Gender: ");
        lGe.setForeground(fg);
        lGe.setFont(font);
        lGe.setBounds(20, 280, 100, 20);
        p.add(lGe);
        
        String[] items = {"Male" , "Female", "Transgender"};
        cGe = new JComboBox<>(items);
        cGe.setBounds(20, 310, 100, 20);
        p.add(cGe);
        
        lPh = new JLabel("Phone no: ");
        lPh.setForeground(fg);
        lPh.setFont(font);
        lPh.setBounds(20, 350, 100, 20);
        p.add(lPh);
        
        tPh = new JTextField();
        tPh.setBounds(20, 380, 200, 25);
        p.add(tPh);
        
        lEm = new JLabel("Email: ");
        lEm.setForeground(fg);
        lEm.setFont(font);
        lEm.setBounds(20, 420, 200, 20);
        p.add(lEm);
        
        tEm = new JTextField();
        tEm.setBounds(20, 450, 200, 25);
        p.add(tEm);
        
        update = new JButton("Update");
        update.setFont(font);
        update.setBounds(20,500,100,30);
        p.add(update);
        
        delete = new JButton("Delete");
        delete.setFont(font);
        delete.setBounds(140,500,80,30);
        p.add(delete);
        
        back = new JButton("Back");
        back.setFont(font);
        back.setBounds(240,500,80,30);
        p.add(back);
        
        setVisible(true);
    }
}
