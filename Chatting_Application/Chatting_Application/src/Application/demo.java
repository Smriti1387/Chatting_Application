/*
 Socket Programming ::: For communication between different applications 
 */




package Application;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;
import javax.swing.border.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.text.*;

public class demo extends JFrame  implements ActionListener{
	JPanel panel;
	JTextArea a;
	JLabel label;
	
 demo(){
	 //JFrame f= new JFrame("Panel Example");    
     panel=new JPanel();  
     panel.setBounds(0,0,450,70);    
     panel.setBackground(new Color(7,94,84));  
     add(panel);
   
    ImageIcon icon=new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\Chatting_Application\\src\\Application\\icons");
    label=new JLabel("Bhavika",icon,JLabel.CENTER);
    panel.add(label);
	 
	
     
    getContentPane().setBackground(Color.RED);
    setSize(450,700);    
    setLayout(null);   
    //setUndecorated(true);
    setVisible(true);    
     }  

private ImageIcon createImage(String string) {
	// TODO Auto-generated method stub
	return null;
}

public static void main(String[] args) {
	new demo();
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}


}