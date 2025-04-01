/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentms;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Sohan
 */
public class View extends JFrame{
    Connection c = Database.connect();
    Statement st= null;
    
    Font font = new Font("Calibri",1,16);
    public View(){
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
    public void loadData(){
        try {
            st = c.createStatement();
            DefaultTableModel model = new DefaultTableModel(new String[] {"Id","Roll no","Name","Address","Gender","Phone","Email"},0);
            JTable table = new JTable(model);
            JScrollPane sp = new JScrollPane(table);
            
            JButton b = new JButton("Back");
            b.setFont(font);
            
            JPanel p = new JPanel(new BorderLayout());
            p.add(sp, BorderLayout.CENTER);
            p.add(b, BorderLayout.SOUTH);
            
            String sql = "SELECT* FROM student";
            ResultSet rs = st.executeQuery(sql);
            
            String Id, ro, na, ad, ge, ph, em;
            while(rs.next()){
                Id = rs.getString("sid");
                ro = rs.getString("sroll");
                na = rs.getString("sname");
                ad = rs.getString("saddress");
                ge = rs.getString("sgender");
                ph = rs.getString("sphone");
                em = rs.getString("semail");
                model.addRow(new Object[]{Id,ro,na,ad,ge,ph,em});
            }
            
            add(p);
            
            b.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    StudentInsert SI = new StudentInsert();
                    SI.init();
                    SI.components();
                }            
            });
            
            setVisible(true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
