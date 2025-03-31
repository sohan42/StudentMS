/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studentms;

import javax.swing.JFrame;
/**
 *
 * @author Sohan
 */
class MyFrame extends JFrame{
     void load(){
        setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }
} 

public class Main {
    public static void main(String[] args) {
//        MyFrame m = new MyFrame();
//        m.load();
//        Components c = new Components(m); 
        StudentInsert si = new StudentInsert();
        si.init();
        si.components();
    }
    
}
