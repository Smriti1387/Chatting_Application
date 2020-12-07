package Application;
import javax.swing.*;
import javax.swing.Timer;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.awt.event.*;
import java.util.*;
import java.net.*;
import java.io.*;
import java.awt.*;
import javax.swing.border.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.plaf.*;
import javax.swing.plaf.ScrollBarUI;
import javax.swing.plaf.basic.*;
import java.text.*;

public class Server implements ActionListener{
	
	//static JPanel a1;
    static JFrame f1 = new JFrame();
	JPanel panel1;
	TextField tf1;
	JButton b1;
	
	static Box vertical =Box.createVerticalBox();
	
	static JPanel p1;
	boolean typing;
	static ServerSocket skt;
	static Socket s;
	static DataInputStream din;
	static DataOutputStream dout;
	
	Server(){
	f1.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	
	 panel1=new JPanel();
     panel1.setLayout(null);
	 panel1.setBackground(new Color(7,94,84));
	 panel1.setBounds(0,0,450,70);
	 f1.add(panel1);
	 
	 
	 ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("back.jpg"));
	 Image i2=i1.getImage().getScaledInstance(30,30,Image.SCALE_AREA_AVERAGING);
	 ImageIcon i3=new ImageIcon(i2);
	 JLabel l1=new JLabel(i3);
	 l1.setBounds(5,17,30,30);
	 panel1.add(l1);
	 
	 l1.addMouseListener(new MouseAdapter(){
		 public void mouseClicked(MouseEvent me) {
			 System.exit(0);
		 }
	 });
	 
	 ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("bhavika.jpg"));
	 Image i5=i4.getImage().getScaledInstance(30,35,Image.SCALE_AREA_AVERAGING);
	 ImageIcon i6=new ImageIcon(i5);
	 JLabel l2=new JLabel(i6);
	 l2.setBounds(40,5,60,60);
	 panel1.add(l2);
	 
	 ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("vedio.jpg"));
	 Image i8=i7.getImage().getScaledInstance(40,30,Image.SCALE_AREA_AVERAGING);
	 ImageIcon i9=new ImageIcon(i8);
	 JLabel l6=new JLabel(i9);
	 l6.setBounds(290,20,40,35);
	 panel1.add(l6);
	 
	 ImageIcon i10=new ImageIcon(ClassLoader.getSystemResource("call.jpg"));
	 Image i11=i10.getImage().getScaledInstance(40,30,Image.SCALE_AREA_AVERAGING);
	 ImageIcon i12=new ImageIcon(i11);
	 JLabel l7=new JLabel(i12);
	 l7.setBounds(350,20,40,30);
	 panel1.add(l7);
	 
	 ImageIcon i13=new ImageIcon(ClassLoader.getSystemResource("setting.jpg"));
	 Image i14=i13.getImage().getScaledInstance(20,25,Image.SCALE_AREA_AVERAGING);
	 ImageIcon i15=new ImageIcon(i14);
	 JLabel l8=new JLabel(i15);
	 l8.setBounds(410,23,20,25);
	 panel1.add(l8);
	 
	 JLabel l3=new JLabel("Bhavika");
	 l3.setFont(new Font("SAN_SERIF",Font.BOLD,18));
	 l3.setForeground(Color.WHITE);
	 l3.setBounds(110,15,100,28);
	 panel1.add(l3);
	 

     JLabel l4 = new JLabel("Active Now");
     l4.setFont(new Font("SAN_SERIF", Font.PLAIN, 10));
     l4.setForeground(Color.WHITE);
     l4.setBounds(110, 35, 100, 20);
     panel1.add(l4);
     
     
     
     Timer t = new Timer(1, new ActionListener(){
         public void actionPerformed(ActionEvent ae){
             if(!typing){
                 l4.setText("Active Now");
             }
         }
     });
     
     t.setInitialDelay(2000); //2 milisecond (initial delay)
     
     

     /*JLabel l5 = new JLabel();
     l5.setForeground(Color.WHITE);
     l5.setBounds(0, 0, 1, 1);
     add(l5);*/
     
     tf1=new TextField();
     tf1.setBounds(5,655,310,40);
     tf1.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
     f1.add(tf1);
     
     
     tf1.addKeyListener(new KeyAdapter() {
    	 public void keyPressed(KeyEvent ke) {
    		 l4.setText("typing...");
    		 t.stop();
    		 typing=true;
    	 }
    	 public void keyReleased(KeyEvent ke)
    	 {
    		 typing=false;
    		 if(!t.isRunning()) {
    			 t.start();
    		 }
    	 }
     });
     
    b1=new JButton("Send");
    b1.setBounds(320, 655, 120, 40);
    b1.setBackground(new Color(7,94,84));
    b1.setForeground(Color.WHITE);
    b1.setFont(new Font("SAN_SERIF",Font.PLAIN,18));
    b1.addActionListener(this);
    f1.add(b1);
	 
    p1=new JPanel();
    //p1.setBounds(2,73,446,578);
    p1.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
   // p1.setLayout(null);
   // f1.add(p1);
    
    
    JScrollPane scroll=new JScrollPane(p1);
    scroll.setBounds(2,73,446,578);
    scroll.setBorder(BorderFactory.createEmptyBorder());
    
    
    
    
    ScrollBarUI ui=new BasicScrollBarUI() {                                //abstract class for scrollbar operations
    protected JButton createDecreaseButton(int orientation) {
    	JButton button =super.createDecreaseButton(orientation);
    	button.setBackground(new Color(7,94,84));
    	button.setForeground(Color.WHITE);
    	this.thumbColor=new Color(7,94,84);
    	 
    	return button;
    }
    protected JButton createIncreaseButton(int orientation) {
    	JButton button =super.createIncreaseButton(orientation);
    	button.setBackground(new Color(7,94,84));
    	button.setForeground(Color.WHITE);
    	this.thumbColor=new Color(7,94,84);
    	return button;
    }
    };
    
    
    scroll.getVerticalScrollBar().setUI(ui);
    f1.add(scroll);
    
     
    
    
    
    
   //BasicScrollBarUI is child class of ScrollBarUI class  
    f1.getContentPane().setBackground(Color.WHITE);
	f1.setSize(450,700);
	f1.setLocation(100,100);
	f1.setLayout(null);
	f1.setUndecorated(true);
	f1.setVisible(true); //should b at the end because it has to display the changes 
}
 
 
 @Override
public void actionPerformed(ActionEvent ae) {
	try {
	 String out=tf1.getText();
	 
	 Send_Text_To_File(out);
	 
	 
	 JPanel p2=formatLabel(out);
	 
	 p1.setLayout(new BorderLayout());
	 JPanel right=new JPanel(new BorderLayout());
	 right.add(p2,BorderLayout.LINE_END);
	 vertical.add(right);
	 vertical.add(Box.createVerticalStrut(15)); //vertical space between meseges
	 
	 p1.add(vertical,BorderLayout.PAGE_START);
	 
	 //p1.add(p2);
	dout.writeUTF(out);
	tf1.setText(" ");
	}catch(Exception e) {
		System.out.println(e);
	}
}
 
 
 
 
 
 public void Send_Text_To_File(String message)throws FileNotFoundException {
	
	 try (
	FileWriter f=new FileWriter("chat.txt");	 //if file does not exist it create it otherwise deal with that only
	 PrintWriter p=new PrintWriter(new BufferedWriter(f));){
	 p.println("Bhavika : "+message);
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
	
}

 
 
 
 

public static JPanel formatLabel(String out) {
	 JPanel p3=new JPanel();
	 p3.setLayout(new BoxLayout(p3,BoxLayout.Y_AXIS));
	 
//use html so that when the max width is achived the mesg breaks automatically to nxt line
	 
	 JLabel l1=new JLabel("<html><p style = \"width : 150px\">"+out+"</p></html>");
	 
	 
	 l1.setBackground(new Color(31,211,102));
	 l1.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
	 l1.setOpaque(true);
	 l1.setBorder(new EmptyBorder(15,15,15,50));
	 
	 Calendar cal=Calendar.getInstance();
	 SimpleDateFormat sdf=new SimpleDateFormat("HH:mm");
	 
	 JLabel l2=new JLabel();
	 l2.setText(sdf.format(cal.getTime()));
	 
	 
	 p3.add(l1); 
	 p3.add(l2);
	 return p3;
 }
 
 
public static void main(String[] args) {
	new Server().f1.setVisible(true);
	String msginput="";
	try {
		skt=new ServerSocket(6002);    //port no. not being used by any other app.
		while(true) {
		s=skt.accept();
		din=new DataInputStream(s.getInputStream());
		dout=new DataOutputStream(s.getOutputStream());
		while(true) {
	    msginput = din.readUTF();
	    JPanel p2=formatLabel(msginput);
	    
	    JPanel left=new JPanel(new BorderLayout());
	    left.add(p2,BorderLayout.LINE_START);
	    vertical.add(left);
	    f1.validate();   //to show panel
	    
		}
		}
		
	}catch(Exception e) {
		
	}
	
}


}
