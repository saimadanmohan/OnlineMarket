package osp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;

public class Products extends JFrame {
 
public	static Products obj;
boolean	flags[]=new boolean[33];

	public static void main()
	{

		obj=new Products();
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.setSize(new Dimension(1366,768));
		obj.setVisible(true);
		init(obj);
	}
	public static void main(String args[])
	{
		main();
	}
	private static final long serialVersionUID = -5897268039244126279L;
	static JPanel mainpane1=new JPanel();
	String str="Connecting People ";
	static JPanel toppane1=new JPanel();

	static JPanel leftpane1=new JPanel()
	{
	/*	public void paintComponent(Graphics g)
        {
            g.drawImage(img.getImage(),0,0,200,500,null);
        }*/
	};
	static JPanel total1=new JPanel();
	static JPanel rightpane1=new JPanel();
	static ImageIcon img=new ImageIcon("biskate.jpg");

	
	ImageIcon frames[] = { new ImageIcon(this.getClass().getResource("s1.jpg")),
			 new ImageIcon(this.getClass().getResource("s2.jpg")),
			 new ImageIcon(this.getClass().getResource("s3.jpg")),
		};
	int time=2;	
	boolean flag=true;
	JLabel god;
	JButton proceed;
	class MyThread extends Thread
	{
		MyThread()
		{
			this.start();
		}
		public void run()
		{
			while(flag){
				if(time==frames.length)
				time=0;
			god=new JLabel(frames[time]);
			proceed=new JButton("proceed");
			rightpane1.removeAll();
	
			rightpane1.add(god);
			rightpane1.add(proceed);
			god.setBounds(0, 62, 375, 375);
			proceed.setBounds(50,450,160,20);
			proceed.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e) {
					
					final Bus objx=new Bus();
					objx.main(flags);	
				}
				
			});
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
	
	class MyThread1 extends Thread
	{
		MyThread1()
		{
			this.start();
		}
		public void run()
		{
			while(flag){

				 str=str.charAt(str.length()-1)+str.substring(0,str.length()-1);
				 x1.setText(str);
				 //System.out.println(str);
			try
			{
				sleep(200);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			}
		}
		
	}
	
	private static void initialise() {
		total1.setPreferredSize(new Dimension(1366,650));
		     leftpane1.setPreferredSize(new Dimension(200,500));
		     rightpane1.setPreferredSize(new Dimension(266,500));
		    // mainpane1.setPreferredSize(new Dimension(1900,1500));
		     mainpane1.setLayout(new GridLayout(0,4,10,10));
		     toppane1.setPreferredSize(new Dimension(1366,150));
		 	 total1.setLayout(new BorderLayout());
		     leftpane1.setBackground(Color.WHITE);   
		     mainpane1.setBackground(Color.WHITE);
		     toppane1.setBackground(Color.WHITE);
		     rightpane1.setBackground(Color.BLUE);
		    rightpane1.setLayout(null);
		  
		  toppane1.setLayout(null);  
		    toppane1.add(x1);
		    x1.setBounds(0, 0, 150, 10);
		    total1.add(leftpane1,BorderLayout.WEST);
				total1.add(rightpane1,BorderLayout.EAST);
				// rightpane1.revalidate();
				   	
				JScrollPane scroll=new JScrollPane(mainpane1,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
				//scroll.setPreferredSize(new Dimension(900,500));
				//scroll.getViewport().add(mainpane1);
				total1.add(scroll,BorderLayout.CENTER);
		
				total1.add(toppane1,BorderLayout.NORTH);
				obj.add(total1);
				
	}
	
	
public static JCheckBox arr1[];
BufferedImage image;
JLabel look=new JLabel(img);

public static void redefine(int r1,int r2,int i,int j,int grid1,int grid2) 
{
	arr1[r1].setVisible(false);
	arr1[r2].setVisible(false);
	prox.setVisible(true);
	
	int val=3;
	for(int p=i;p<=j;p++)
	    {
		// arr1[val]=new JCheckBox();
	     arr1[val].setText(s[p]);
	     arr1[val].setVisible(true);
	     leftpane1.add(arr1[val++]);
	    
	    }
	 mainpane1.removeAll();
	 addgrid(grid1,grid2);
     obj.revalidate();
}

public static void undefine(int s1,int s2) 
{
	arr1[s1].setVisible(true);
	arr1[s2].setVisible(true);
	prox.setVisible(false);
	 for(int i=3;i<=7;i++)
	     arr1[i].setVisible(false);
	 mainpane1.removeAll();
		addgrid(0,32);
	obj.revalidate();
	    
}





//final
final static String []s={"LumiaSeries","Asha Series","Accessories","Rs. 5001 - Rs. 10000","Rs.10001 - Rs. 20000","Rs. 20000 - Rs. 30000",
		"Rs. 30001 - Rs. 40000",
		"Rs. 3001 - Rs. 4000","Rs. 4001 - Rs. 5000","Rs. 5001 - Rs. 6000","Rs. 6001 - Rs. 7000",
		
		"Rs. 1000 and Below","Rs. 1001 - Rs. 2000","Rs. 2001 - Rs. 3000","Rs. 3001 - Rs. 4000",
		"Rs. 4001 - Rs. 5000"
        };
final static JLabel prox= new JLabel("Choose price range");
//final
public static Products This;
static JLabel x1=new JLabel("Connecting People ");
public static void init(Products obj2)
{
	
	dbms();
	initialise();
	obj2.new MyThread();
	obj2.new MyThread1();
	
        // this.setSize(1366,650);
         This = obj2;
		
	    arr1=new JCheckBox[8];
	    
	    JLabel dip=new JLabel("Mobiles&Accessories");
	    dip.setFont(new Font("Serif",Font.BOLD,16));
	    leftpane1.add(dip);
	    int i=0;
	    for(;i<3;i++)
	    {
	     arr1[i]=new JCheckBox(s[i]);
	     arr1[i].setBackground(Color.YELLOW);
	     leftpane1.add(arr1[i]);
	    }

	    leftpane1.add(prox);
	    
	    prox.setVisible(false);
	    
	    for(i=3;i<=7;i++)
	    {
	    	arr1[i]=new JCheckBox();
	    	arr1[i].setBackground(Color.YELLOW);
	    } 
	    addgrid(0,32);
	   System.out.println("laka");
	    //  arr1[i].setSelected(true);
		obj2.revalidate();
	    arr1[0].addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
			if(arr1[0].isSelected())
			{		
				redefine(1,2,3,6,0,11);
				// action(0,3,6);
				obj.revalidate();
			//System.out.println("instant");
			//r
			ActionListener[] a1 = arr1[3].getActionListeners();
			for(int i=0;i<a1.length;i++)
			arr1[3].removeActionListener(a1[i]);
			
			ActionListener[] a2 = arr1[4].getActionListeners();
			for(int i=0;i<a2.length;i++)
			arr1[4].removeActionListener(a2[i]);
			
			ActionListener[] a3 = arr1[5].getActionListeners();
			for(int i=0;i<a3.length;i++)
			arr1[5].removeActionListener(a3[i]);
			
			ActionListener[] a4 = arr1[6].getActionListeners();
			for(int i=0;i<a4.length;i++)
			arr1[6].removeActionListener(a4[i]);
		
			ActionListener[] a5 = arr1[7].getActionListeners();
			for(int i=0;i<a5.length;i++)
			arr1[7].removeActionListener(a5[i]);
			
			
			
			
		       	 arr1[3].addActionListener(obj.new Handler1(3,0,1,This,0,11,3,6));
				 arr1[4].addActionListener(obj.new Handler1(4,2,8,This,0,11,3,6));
				 arr1[5].addActionListener(obj.new Handler1(5,9,9,This,0,11,3,6));
				 arr1[6].addActionListener(obj.new Handler1(6,10,11,This,0,11,3,6));
			}
			else{
				
				undefine(2,1);
			}
			}

		
		});	
     arr1[1].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			if(arr1[1].isSelected())
			{
				redefine(0,2,7,10,12,19);
				obj.revalidate();
				ActionListener[] a1 = arr1[3].getActionListeners();
				for(int i=0;i<a1.length;i++)
				arr1[3].removeActionListener(a1[i]);
				
				ActionListener[] a2 = arr1[4].getActionListeners();
				for(int i=0;i<a2.length;i++)
				arr1[4].removeActionListener(a2[i]);
				
				ActionListener[] a3 = arr1[5].getActionListeners();
				for(int i=0;i<a3.length;i++)
				arr1[5].removeActionListener(a3[i]);
				
				ActionListener[] a4 = arr1[6].getActionListeners();
				for(int i=0;i<a4.length;i++)
				arr1[6].removeActionListener(a4[i]);
				
				
				ActionListener[] a5 = arr1[7].getActionListeners();
				for(int i=0;i<a5.length;i++)
				arr1[7].removeActionListener(a5[i]);
				
				
				
				
				arr1[3].addActionListener(obj.new Handler1(3,12,13,This,12,19,3,6));
				 arr1[4].addActionListener(obj.new Handler1(4,14,16,This,12,19,3,6));
				 arr1[5].addActionListener(obj.new Handler1(5,17,18,This,12,19,3,6));
				 arr1[6].addActionListener(obj.new Handler1(6,19,19,This,12,19,3,6));
				
				
				
				//	addgrid(10,17);
			//	 action(11,3,6);
			}
			else{
					undefine(0,2);
			}
			}
		});
	    
     arr1[2].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			if(arr1[2].isSelected())
			{
				redefine(0,1,11,15,20,32);
				obj.revalidate();
			//r
				//r
				ActionListener[] a1 = arr1[3].getActionListeners();
				for(int i=0;i<a1.length;i++)
				arr1[3].removeActionListener(a1[i]);
				
				ActionListener[] a2 = arr1[4].getActionListeners();
				for(int i=0;i<a2.length;i++)
				arr1[4].removeActionListener(a2[i]);
				
				ActionListener[] a3 = arr1[5].getActionListeners();
				for(int i=0;i<a3.length;i++)
				arr1[5].removeActionListener(a3[i]);
				
				ActionListener[] a4 = arr1[6].getActionListeners();
				for(int i=0;i<a4.length;i++)
				arr1[6].removeActionListener(a4[i]);
				
				ActionListener[] a5 = arr1[7].getActionListeners();
				for(int i=0;i<a5.length;i++)
				arr1[7].removeActionListener(a5[i]);
				
				//
				
				//
				
				
				arr1[3].addActionListener(obj.new Handler1(3,21,22,This,21,32,3,7));
				 arr1[4].addActionListener(obj.new Handler1(4,23,25,This,21,32,3,7));
				 arr1[5].addActionListener(obj.new Handler1(5,26,27,This,21,32,3,7));
				 arr1[6].addActionListener(obj.new Handler1(6,28,30,This,21,32,3,7));
				 arr1[7].addActionListener(obj.new Handler1(7,31,32,This,21,32,3,7));
					
				 // action(19,3,7);
			//	addgrid(18,30);
			}
			else	{
				undefine(0,1);
				
			}
			}
		});
	}
static Connection c=null;

private static void dbms() {
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
		
		Statement s=null;
      try {
			s=c.createStatement();
			System.out.println("successful");
		} catch (SQLException e1) 
		{
			// TODO Auto-generated catch block
   //	    s.executeUpdate("INSERT INTO USERS (FNAME, LNAME,CTACT,PASSW) VALUES ('a','b','123','k')");

			e1.printStackTrace();
		}
}


//images don't touch

//
JButton buy[]=new JButton[33];
JLabel photo[]=new JLabel[33];
JLabel price[]=new JLabel[33];
JLabel pname[]=new JLabel[33];


class mypanel extends JPanel
{
	ImageIcon imgp[]={
			new ImageIcon(getClass().getResource("510.jpg")),
			new ImageIcon(getClass().getResource("520.jpg")),
			new ImageIcon(getClass().getResource("710.jpg")),
			new ImageIcon(getClass().getResource("610.jpg")),
			new ImageIcon(getClass().getResource("900.jpg")),
			new ImageIcon(getClass().getResource("620.jpg")),
			new ImageIcon(getClass().getResource("720.jpg")),
			new ImageIcon(getClass().getResource("820.jpg")),
			new ImageIcon(getClass().getResource("800.jpg")),
			new ImageIcon(getClass().getResource("920.jpg")),
			new ImageIcon(getClass().getResource("925.jpg")),
			new ImageIcon(getClass().getResource("1020.jpg")),

			new ImageIcon(getClass().getResource("asha205.jpg")),
			new ImageIcon(getClass().getResource("asha306.jpg")),
			new ImageIcon(getClass().getResource("asha501.jpg")),
			new ImageIcon(getClass().getResource("asha210.jpg")),
			new ImageIcon(getClass().getResource("asha309.jpg")),
			new ImageIcon(getClass().getResource("asha308.jpg")),
			new ImageIcon(getClass().getResource("asha310.jpg")),
			new ImageIcon(getClass().getResource("asha311.jpg")),

			new ImageIcon(getClass().getResource("BlueSet.jpg")),
			new ImageIcon(getClass().getResource("reactionBset.jpg")),
			new ImageIcon(getClass().getResource("BluetoothHset.jpg")),
			new ImageIcon(getClass().getResource("820W-LessCharge.jpg")),
			new ImageIcon(getClass().getResource("BlueStereoSet.jpg")),
			new ImageIcon(getClass().getResource("ColoudPop.jpg")),
			new ImageIcon(getClass().getResource("USBCharger.jpg")),
			new ImageIcon(getClass().getResource("HardRese.jpg")),
			new ImageIcon(getClass().getResource("StereoBset.jpg")),
			new ImageIcon(getClass().getResource("BStereoSet.jpg")),
			new ImageIcon(getClass().getResource("ColoudKnock.jpg")),
			new ImageIcon(getClass().getResource("W-CarCharge.jpg")),
			new ImageIcon(getClass().getResource("ColoudBoom.jpg")),
			};

	private static final long serialVersionUID = 1L; 
	mypanel(int i)
	{
		this.setBackground(Color.BLUE);
		this.setLayout(null);
			buy[i]=new JButton("Add to Cart");
			
			photo[i]=new JLabel(imgp[i]);
			photo[i].setBounds(40,10,200,200);
			
			
		
			final int x=i;
			buy[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
			      obj.flags[x]=true;		
				}
			});
		//	set[i].setIcon(img[i]);
		
			
			String query="select name,cost from products where name like '%"+(imgp[i].toString().substring(49,imgp[i].toString().length()-4))+"%'";
			
			Statement stmt=null;
			try {
				stmt=c.createStatement();
			//	System.out.println("successful");
				ResultSet rs=stmt.executeQuery(query);
				while(rs.next())
				{
					pname[i]=new JLabel(rs.getString(1));	
					price[i]=new JLabel("price  :"+rs.getString(2));
					price[i].setForeground(Color.WHITE);
				}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
         //	    s.executeUpdate("INSERT INTO USERS (FNAME, LNAME,CTACT,PASSW) VALUES ('a','b','123','k')");

				e1.printStackTrace();
			}
			//System.out.println((imgp[i].toString().substring(49,imgp[i].toString().length()-4)));
			add(photo[i]);
			
			pname[i].setBounds(110,220,120,20);
			
			add(pname[i]);
			
			
			buy[i].setBounds(60,240,160,20);
			add(buy[i]);
			price[i].setBounds(110,260,120,20);
			add(price[i]);
	
		setPreferredSize(new Dimension(290,280));
	}
		
}

public static void addgrid(int x1,int y1)
{
	
  for(int x=x1;x<=y1;x++)
  {
	  obj.mainpane1.add(obj.new mypanel(x));
  }
  
	
}
public class Handler1 extends Products implements ActionListener {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
int i;
int j;
int k;
Products objj;
 int f1,f2;
int b1,b2;

public  Handler1(int i,int j,int k,Products obj,int f1,int f2,int b1,int b2)
{
	this.i=i;
	this.j=j;
	this.k=k;
	objj=obj;
	this.f1=f1;
	this.f2=f2;
	this.b1=b1;
	this.b2=b2;
}
	
	public void actionPerformed(ActionEvent e) {
	
		if(objj.arr1[i].isSelected())
		{
			objj.mainpane1.removeAll();
			objj.addgrid(j,k);
			 for(int x=b1;x<=b2;x++)
			 {
				 if(x==i)
					 continue;
				 else
					 objj.arr1[x].setVisible(false);
			 }
			 objj.revalidate();
		}
		else
		{
			objj.mainpane1.removeAll();
			 for(int x=b1;x<=b2;x++)
			 {
 			 objj.arr1[x].setVisible(true);
			 }
			 
			 objj.addgrid(f1,f2);
			 objj.revalidate();
		}
	}

}

}
