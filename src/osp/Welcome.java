package osp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Welcome extends JFrame
{
 static Welcome obj;
	public static void main(String args[])
	{
		obj=new Welcome();
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.setSize(new Dimension(1366,650));
		obj.setVisible(true);
		Welcome(obj);
	}
	static JButton arr[];
	private static final long serialVersionUID = 1L;
	static JPanel mainpane=new JPanel();
	static JPanel toppane=new JPanel();
	static JPanel leftpane=new JPanel()
	{

		public void paintComponent(Graphics g)
		{
			
			leftpane.setBackground(Color.ORANGE);
			
			ImageIcon frames =  new ImageIcon(this.getClass().getResource("left.jpg"));
			ImageIcon frames1 =  new ImageIcon(this.getClass().getResource("left1.jpg"));
			ImageIcon frames2 =  new ImageIcon(this.getClass().getResource("connect.jpg"));
			
			g.drawImage(frames.getImage(),10,10,null);
			g.drawImage(frames1.getImage(),10,220,null);
			g.drawImage(frames2.getImage(),0,430,null);
					   
		}

	};
	static JPanel total=new JPanel();
	static JPanel topleft=new JPanel()
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void paintComponent(Graphics g)
		{
			ImageIcon frames =  new ImageIcon(this.getClass().getResource("banner.jpg"));
				g.drawImage(frames.getImage(),0,0,null);
		}
	}
	;

	//regarding right pane
	static JPanel r1=new JPanel()
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void paintComponent(Graphics g)
		{
			ImageIcon frames =  new ImageIcon(this.getClass().getResource("sky.jpeg"));
			g.drawImage(frames.getImage(),0,0,null);
		}
	}
	;
	static JPanel r2=new JPanel()
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void paintComponent(Graphics g)
		{
			ImageIcon frames =  new ImageIcon(this.getClass().getResource("green.jpg"));
			g.drawImage(frames.getImage(),0,0,null);
		}
	}
	;
	static JLabel name1=new JLabel("FirstName");
	
	static JLabel name2=new JLabel("LastName");
	static JLabel phone=new JLabel("MobileNo");
	static JLabel pass1=new JLabel("Password");

	//login
	static JLabel p=new JLabel(" new user");
	static JLabel sign=new JLabel(" signin");
	
	static JLabel id =new JLabel("LoginID");
	static JLabel pass=new JLabel("Password");
	
	static JTextField idx=new JTextField("");
	static JPasswordField passx=new JPasswordField("",85);
	
	static JTextField mno=new JTextField("");
	static JTextField name1a=new JTextField("");
	static JTextField name2a=new JTextField("");
	
	static JPasswordField pass1a=new JPasswordField("",85);
	
	//Statement s = null;

ImageIcon frames[] = { new ImageIcon(this.getClass().getResource("dive.jpg")),
		 new ImageIcon(this.getClass().getResource("geo.jpg")),
		 new ImageIcon(this.getClass().getResource("start1.jpg")),
		 new ImageIcon(this.getClass().getResource("beauty.jpg")),
new ImageIcon(this.getClass().getResource("super.jpg"))};
int time=2;	
	//JLabel god=new JLabel(frames[time]);
    JLabel god;
	
	static JButton login=new JButton("Login");
	static JButton register=new JButton("Register");

	
	static Statement s = null;
	static Connection c = null;
boolean flag=true;
	class MyThread extends Thread
	{
		MyThread()
		{
			this.start();
		}
		public void run()
		{
			while(flag){
				System.out.println("jo:"+time);
				
				if(time==frames.length)
				time=0;
			god=new JLabel(frames[time]);
			//god.setIcon(frames[time]);
			mainpane.removeAll();
			mainpane.revalidate();
			mainpane.add(god);
			mainpane.revalidate();
			
	//ter(doRun);
			time++;
			try
			{
				sleep(2000);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			}
		}
		
	}
	static Welcome This ;
	
	public static void Welcome (Welcome obj2)
	{
	 // this.setSize(1366,650);
	 // god.setBounds(0,0,900,650);
	  obj2.new MyThread();
	  //Thread t=new Thread(th);
	  This=obj2;
	  //swing
	  
		   name1.setForeground(Color.WHITE);
	  name2.setForeground(Color.WHITE);
	  phone.setForeground(Color.WHITE);
	  pass1.setForeground(Color.WHITE);
	  p.setForeground(Color.WHITE);
		  System.out.println("-------- Oracle JDBC Connection Testing ------");
		  
			try {

				Class.forName("oracle.jdbc.driver.OracleDriver");

			} catch (ClassNotFoundException e) {

				System.out.println("Where is your Oracle JDBC Driver?");
				e.printStackTrace();
				return;

			}

			System.out.println("Oracle JDBC Driver Registered!");

			
			try {

				c = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:sysdba", "system",
						"sreerama");

			} catch (SQLException e) {

				System.out.println("Connection Failed! Check output console");
				e.printStackTrace();
				return;

			}

			if (c != null) {
				System.out.println("You made it, take control your database now!");
			} else {
				System.out.println("Failed to make connection!");
			}
		
			
			//execute update
			
			
			//Connection c = null;
	        
	        try {
				s=c.createStatement();
				System.out.println("successful");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
         //	    s.executeUpdate("INSERT INTO USERS (FNAME, LNAME,CTACT,PASSW) VALUES ('a','b','123','k')");

				e1.printStackTrace();
			}
	  	 register.addActionListener(new ActionListener() {

			  @Override
			public void actionPerformed(ActionEvent ae) {
	             fun();			
			}

	 
			private void fun() {
				try {
				s.executeQuery("INSERT INTO USERS (FNAME, LNAME,MOBILE,PASSWORD) VALUES ('"+name1a.getText()+"','"+name2a.getText()+"','"+Double.parseDouble(mno.getText())+"','"+pass1a.getEchoChar()+"')");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
			}
		});

	        toppane.setLayout(new BorderLayout());
	     total.setPreferredSize(new Dimension(1366,650));
	     leftpane.setPreferredSize(new Dimension(200,500));
	     topleft.setPreferredSize(new Dimension(1200,150));
	     r1.setPreferredSize(new Dimension(166,150));
	     r2.setPreferredSize(new Dimension(266,1216));
	     leftpane.setLayout(null);
	    r1.setLayout(new GridLayout(0,1));
	     
	     r2.setLayout(null);
	     mainpane.setPreferredSize(new Dimension(900,500));
	     toppane.setPreferredSize(new Dimension(1366,150));
	 	 total.setLayout(new BorderLayout());
	 	 topleft.setLayout(new BorderLayout());
	     leftpane.setBackground(Color.WHITE);   
	     mainpane.setBackground(Color.BLUE);
	     toppane.setBackground(Color.blue);
	     mainpane.setLayout(new FlowLayout());
	     
	     arr=new JButton[5];
		  String []s={"Asha Series","Lumia","Accesories","Everything at once","ContactUs"};
	     for(int i=0;i<5;i++)
	     {
	    	 arr[i]=new JButton(s[i]);
             

final int x=i; 
	    	 arr[i].addActionListener(new ActionListener()
	    	 {

				@Override
				public void actionPerformed(ActionEvent arg0)
				{
					Products obj=new Products();
				  obj.main();
					obj.validate();
				}
	    		 
	    	 }
	    			 );
	         //leftpane.add(arr[i]);
	     }
	  
	 	 	
	        p.setBounds(0,0,150,20);
		 	id.setBounds(20,0,150,20);
		 	idx.setBounds(40,0,150,20);
		 	pass.setBounds(60,0,150,20);
		 	passx.setBounds(80,0,150,20);
		 	login.setBounds(100,0,150,20);
		
		 	sign.setBounds(0,10,100,20);
		 	name1.setBounds(20,50,100,20);
		 	name1a.setBounds(120,50,100,20);
		 	name2.setBounds(20,90,100,20);
		 	name2a.setBounds(120,90,100,20);
		 	phone.setBounds(20,130,100,20);
		 	mno.setBounds(120,130,100,20);
		 	pass1.setBounds(20,170,100,20);
		 	pass1a.setBounds(120,170,100,20);
		 	register.setBounds(60,210,100,20);
		
	     
	     
	     r1.add(sign);
	     r1.add(id);
	     r1.add(idx);
	     r1.add(pass);
	     r1.add(passx);
	     r1.add(login);
	     r2.add(p);
	     r2.add(name1);
	     r2.add(name1a);
	     r2.add(name2);
	     r2.add(name2a);
	     r2.add(phone);
	     r2.add(mno);
	     r2.add(pass1);
	     r2.add(pass1a);
	 	 r2.add(register);
	     
	 	
	 	sign.setBounds(20,10,100,20);
	 	name1.setBounds(20,50,100,20);
	 	name1a.setBounds(120,50,100,20);
	 	name2.setBounds(20,90,100,20);
	 	name2a.setBounds(120,90,100,20);
	 	phone.setBounds(20,130,100,20);
	 	mno.setBounds(120,130,100,20);
	 	pass1.setBounds(20,170,100,20);
	 	pass1a.setBounds(120,170,100,20);
	 	register.setBounds(60,210,100,20);
	
	 	 
	 	 
	 	 
	 	 // p.setBounds(x, y, width, height)
	 	 
	    toppane.add(topleft,BorderLayout.WEST);
	    toppane.add(r1,BorderLayout.EAST);
	    // topleft.add(r2);
		
		total.add(leftpane,BorderLayout.WEST);
		total.add(r2,BorderLayout.EAST);
		total.add(mainpane,BorderLayout.CENTER);
		total.add(toppane,BorderLayout.NORTH);
		
		obj2.add(total);

	  
	  	 login.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent ae) {
				 Statement stmt=null;   
					
				try {
					 	stmt=c.createStatement();
				//	stmt.executeUpdate("INSERT INTO USERS (FNAME, LNAME,MOBILE,PASSWORD) VALUES ('"+name1a.getText()+"','"+name2a.getText()+"','"+Double.parseDouble(mno.getText())+"','"+pass1a.getEchoChar()+"')");
				System.out.println(passx.getPassword());
					 	ResultSet rs=stmt.executeQuery("select mobile from users where  password='"+passx.getEchoChar()+"' and mobile='"+idx.getText()+"'");
				while(rs.next())
				{
					System.out.println(rs.getString(1));
					System.out.println("vaymaba");
					Products obj=new Products();
					obj.main();	
					
				}
				 
				 System.out.println("hello");
				// boolean rs=s.execute("select * from users where fname='a' and passw='k'");
				 //if(rs)
					 
				 
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
          }

			
		});

	  
	  
	}
		  
}
