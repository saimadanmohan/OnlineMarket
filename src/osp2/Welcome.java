package osp2;

import java.applet.Applet;
import java.applet.AppletContext;
import java.applet.AppletStub;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.Color;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/*
<applet code="Welcome.class"width="1366"height="650"/>
*/
public class Welcome extends Applet implements MouseListener,MouseMotionListener ,AppletStub
{

	
//final ImageIcon[] frames = { new ImageIcon(this.getClass().getResource("E:\\agarwal\\MYproject\\life.jpg"))};

	JButton arr[];
	private static final long serialVersionUID = 1L;
	JPanel mainpane=new JPanel();
	JPanel toppane=new JPanel();
	JPanel leftpane=new JPanel();
	JPanel total=new JPanel();
	JPanel topleft=new JPanel()
	{
		public void paintComponent(Graphics g)
		{
			ImageIcon frames =  new ImageIcon(this.getClass().getResource("banner.jpg"));
				g.drawImage(frames.getImage(),0,0,null);
		}
	}
	;

	//regarding right pane
	JPanel r1=new JPanel()
	{
		public void paintComponent(Graphics g)
		{
			ImageIcon frames =  new ImageIcon(this.getClass().getResource("sky.jpeg"));
			g.drawImage(frames.getImage(),0,0,null);
		}
	}
	;
	JPanel r2=new JPanel()
	{
		public void paintComponent(Graphics g)
		{
			ImageIcon frames =  new ImageIcon(this.getClass().getResource("green.jpg"));
			g.drawImage(frames.getImage(),0,0,null);
		}
	}
	;
	
	
	
	
	
	JLabel name1=new JLabel("FirstName");
	
	JLabel name2=new JLabel("LastName");
	JLabel phone=new JLabel("MobileNo");
	JLabel pass1=new JLabel("Password");

	//login
	JLabel p=new JLabel(" new user");
	JLabel sign=new JLabel(" signin");
	
	JLabel id =new JLabel("LoginID");
	JLabel pass=new JLabel("Password");
	
	JTextField idx=new JTextField("enter");
	JPasswordField passx=new JPasswordField("enter here",85);
	
	JTextField mno=new JTextField("enter");
	JTextField name1a=new JTextField("enter");
	JTextField name2a=new JTextField("enter");
	
	JPasswordField pass1a=new JPasswordField("enter here",85);
	
	//Statement s = null;

ImageIcon frames[] = { new ImageIcon(this.getClass().getResource("dive.jpg")),
		 new ImageIcon(this.getClass().getResource("geo.jpg")),
		 new ImageIcon(this.getClass().getResource("start1.jpg")),
		 new ImageIcon(this.getClass().getResource("beauty.jpg")),
new ImageIcon(this.getClass().getResource("super.jpg"))};
int time=2;	
	//JLabel god=new JLabel(frames[time]);
    JLabel god;
	
	JButton login=new JButton("Login");
	JButton register=new JButton("Register");

	
	Statement s = null;
	Connection c = null;
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
	Applet This ;
	
	public void init ()
	{
	  this.setSize(1366,650);
	 // god.setBounds(0,0,900,650);
	  new MyThread();
	  //Thread t=new Thread(th);
	  This=this;
	  //swing
	  
	 /* SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run() {
			
				int time=0;
				try
			{

					if(time==3)
						time=0;
						god=new JLabel(frames[time]);
							time++;
							Thread.sleep(1000);
		
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
			
		});
	  */
	  
	  
	  //
	   name1.setForeground(Color.WHITE);
	  name2.setForeground(Color.WHITE);
	  phone.setForeground(Color.WHITE);
	  pass1.setForeground(Color.WHITE);
	  p.setForeground(Color.WHITE);
	//  pass.setForeground(Color.WHITE);
	  
	  //dbms
		//connection
	//  mainpane.add(god);
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
	  	  addMouseListener(this);
		  addMouseMotionListener(this);
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
	     leftpane.setLayout(new GridLayout(0,1));
	    r1.setLayout(new GridLayout(0,1));
	    // r2.setLayout(new GridLayout(0,1));
	     
	     r2.setLayout(null);
	     mainpane.setPreferredSize(new Dimension(900,500));
	     toppane.setPreferredSize(new Dimension(1366,150));
	 	 total.setLayout(new BorderLayout());
	 	 topleft.setLayout(new BorderLayout());
	     leftpane.setBackground(Color.WHITE);   
	     mainpane.setBackground(Color.BLUE);
	     toppane.setBackground(Color.blue);
	     mainpane.setLayout(new FlowLayout());
	   //  topleft.setBackground(Color.magenta);
	 //    topleft.setLayout(null);
	    //form
	     
	     arr=new JButton[5];
		  String []s={"Asha Series","Lumia","Accesories","Deals","ContactUs"};
	     for(int i=0;i<5;i++)
	     {
	    	 arr[i]=new JButton(s[i]);
	    	 arr[i].addActionListener(new ActionListener()
	    	 {

				@Override
				public void actionPerformed(ActionEvent arg0)
				{
					/*
					 Products secondApplet = (Products)getAppletContext().getApplet("osp.Products");
				        if (secondApplet != null) {
				            secondApplet.init();
				            secondApplet.start();
				        }
				        else {
				            System.out.println("Not Running\n");
				        }
					Panel container = new Panel();
					container.setLayout(new GridLayout(1,0));
					container.add(secondApplet); //Display Applet
					add(container);

					secondApplet.init();
					secondApplet.start();

					//button.setVisible(false);

					*/
					 try {
						 
						    //sleep for 5 seconds , for demo
						  //  threadABC.sleep(5000);
						// flag=false;
						    Class applet2 = Class.forName("osp.Products");
						    Applet appletToLoad = (Applet)applet2.newInstance();
						    appletToLoad.setStub((AppletStub)This);
						   // This.setVisible(false);
						    setLayout(new GridLayout(0,1));
						    add(appletToLoad);
						    appletToLoad.init();
						    appletToLoad.start();
					 
						  }catch (Exception e) {
						    System.out.println(e);
						  }
					 validate();
				}
	    		 
	    	 }
	    			 );
	         leftpane.add(arr[i]);
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
		
		add(total);

	  
	  	 login.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent ae) {
				 Statement stmt=null;   
					
				try {
					 	stmt=c.createStatement();
				//	stmt.executeUpdate("INSERT INTO USERS (FNAME, LNAME,MOBILE,PASSWORD) VALUES ('"+name1a.getText()+"','"+name2a.getText()+"','"+Double.parseDouble(mno.getText())+"','"+pass1a.getEchoChar()+"')");
				System.out.println(passx.getPassword());
					 	ResultSet rs=stmt.executeQuery("select mobile from users where  password="+passx.getEchoChar()+"");
				while(rs.next())
				{
					System.out.println(rs.getString(1));
					JOptionPane.showMessageDialog(null, "thop");
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
		public void mouseClicked(MouseEvent arg0) 
		{
	     
		}
	public void mouseEntered(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	float x,y;
/*	public void paint(Graphics g)
	{
	//	g.drawImage(frames.getImage(),200,800,null);
	//	g.drawString("hello"+x+y, (int)x,(int)y);
	}*/
	public void mouseMoved(MouseEvent e) {
		x=e.getX();
		y=e.getY();
	
	//name1.setText(x+" "+y);
		//repaint();
	}
	@Override
	public void appletResize(int width, int height) {
		 resize( width, height );
		
	}
  
}
