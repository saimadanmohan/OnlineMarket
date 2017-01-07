package osp2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;

public class Products extends JApplet implements MouseMotionListener,MouseListener{
 
	private static final long serialVersionUID = -5897268039244126279L;
	JPanel mainpane=new JPanel();
	String str="Connecting People ";
	JPanel toppane=new JPanel()
	/*{
		private static final long serialVersionUID = 1L;

			public void paint(Graphics g)
	        {
				 System.out.println(str);
				 g.drawString(str,str.length(),10);
						 str=str.charAt(str.length()-1)+str.substring(0,str.length()-1);
	        }
		
		}*/;
	JPanel leftpane=new JPanel()
	{
		public void paintComponent(Graphics g)
        {
            g.drawImage(img.getImage(),0,0,200,500,null);
        }
	};
	JPanel total=new JPanel();
	JPanel rightpane=new JPanel();
	ImageIcon img=new ImageIcon(getClass().getResource("biskate.jpg"));

	
	ImageIcon frames[] = { new ImageIcon(this.getClass().getResource("s1.jpg")),
			 new ImageIcon(this.getClass().getResource("s2.jpg")),
			 new ImageIcon(this.getClass().getResource("s3.jpg")),
		};
	int time=2;	
	boolean flag=true;
	JLabel god;
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
			rightpane.removeAll();
	
			rightpane.add(god);
			god.setBounds(0, 62, 375, 375);
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
				 System.out.println(str);
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
	
	private void initialise() {
		total.setPreferredSize(new Dimension(1366,650));
		     leftpane.setPreferredSize(new Dimension(200,500));
		     rightpane.setPreferredSize(new Dimension(266,500));
		    // mainpane.setPreferredSize(new Dimension(1900,1500));
		     mainpane.setLayout(new GridLayout(0,4,10,10));
		     toppane.setPreferredSize(new Dimension(1366,150));
		 	 total.setLayout(new BorderLayout());
		     leftpane.setBackground(Color.WHITE);   
		     mainpane.setBackground(Color.WHITE);
		     toppane.setBackground(Color.WHITE);
		     rightpane.setBackground(Color.BLUE);
		    rightpane.setLayout(null);
		  
		  toppane.setLayout(null);  
		    toppane.add(x1);
		    x1.setBounds(0, 0, 150, 10);
		    total.add(leftpane,BorderLayout.WEST);
				total.add(rightpane,BorderLayout.EAST);
				// rightpane.revalidate();
				   	
				JScrollPane scroll=new JScrollPane(mainpane,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
				//scroll.setPreferredSize(new Dimension(900,500));
				//scroll.getViewport().add(mainpane);
				total.add(scroll,BorderLayout.CENTER);
		
				total.add(toppane,BorderLayout.NORTH);
				add(total);
				
	}
	
	
public JCheckBox arr[];
BufferedImage image;
JLabel look=new JLabel(img);

public void redefine(int r1,int r2,int i,int j,int grid1,int grid2) 
{
	arr[r1].setVisible(false);
	arr[r2].setVisible(false);
	prox.setVisible(true);
	
	int val=3;
	final int use=i;
	 for(int p=i;p<=j;p++)
	    {
		// arr[val]=new JCheckBox();
	     arr[val].setText(s[p]);
	     arr[val].setVisible(true);
	     leftpane.add(arr[val++]);
	    
	    }
	 mainpane.removeAll();
	 addgrid(grid1,grid2);
     revalidate();
}

public void undefine(int s1,int s2) 
{
	arr[s1].setVisible(true);
	arr[s2].setVisible(true);
	prox.setVisible(false);
	 for(int i=3;i<=7;i++)
	     arr[i].setVisible(false);
	 mainpane.removeAll();
		addgrid(0,imgp.length-1);
	 revalidate();
	    
}





//final
final String []s={"LumiaSeries","Asha Series","Accessories","Rs. 5001 - Rs. 10000","Rs.10001 - Rs. 20000","Rs. 20000 - Rs. 30000",
		"Rs. 30001 - Rs. 40000",
		"Rs. 3001 - Rs. 4000","Rs. 4001 - Rs. 5000","Rs. 5001 - Rs. 6000","Rs. 6001 - Rs. 7000",
		
		"Rs. 1000 and Below","Rs. 1001 - Rs. 2000","Rs. 2001 - Rs. 3000","Rs. 3001 - Rs. 4000",
		"Rs. 4001 - Rs. 5000"
        };
final JLabel prox= new JLabel("Choose price range");
//final
public Products This;
JLabel x1=new JLabel("Connecting People ");
public void init()
{
	
	dbms();
	initialise();
	new MyThread();
	new MyThread1();
	
         this.setSize(1366,650);
         addMouseMotionListener(this);
         This = this;
		
	    arr=new JCheckBox[8];
	    
	    JLabel dip=new JLabel("Mobiles&Accessories");
	    dip.setFont(new Font("Serif",Font.BOLD,16));
	    leftpane.add(dip);
	    int i=0;
	    for(;i<3;i++)
	    {
	     arr[i]=new JCheckBox(s[i]);
	     arr[i].setBackground(Color.YELLOW);
	     leftpane.add(arr[i]);
	    }

	    leftpane.add(prox);
	    
	    prox.setVisible(false);
	    
	    for(i=3;i<=7;i++)
	    {
	    	arr[i]=new JCheckBox();
	    	arr[i].setBackground(Color.YELLOW);
	    } 
	    addgrid(0,imgp.length-1);
	    arr[0].addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
			if(arr[0].isSelected())
			{		
				redefine(1,2,3,6,0,11);
				// action(0,3,6);
				revalidate();
			System.out.println("instant");
			//r
			ActionListener[] a1 = arr[3].getActionListeners();
			for(int i=0;i<a1.length;i++)
			arr[3].removeActionListener(a1[i]);
			
			ActionListener[] a2 = arr[4].getActionListeners();
			for(int i=0;i<a2.length;i++)
			arr[4].removeActionListener(a2[i]);
			
			ActionListener[] a3 = arr[5].getActionListeners();
			for(int i=0;i<a3.length;i++)
			arr[5].removeActionListener(a3[i]);
			
			ActionListener[] a4 = arr[6].getActionListeners();
			for(int i=0;i<a4.length;i++)
			arr[6].removeActionListener(a4[i]);
		
			ActionListener[] a5 = arr[7].getActionListeners();
			for(int i=0;i<a5.length;i++)
			arr[7].removeActionListener(a5[i]);
			
			
			
			
		       	arr[3].addActionListener(new Handler(3,0,1,This,0,11,3,6));
				 arr[4].addActionListener(new Handler(4,2,8,This,0,11,3,6));
				 arr[5].addActionListener(new Handler(5,9,9,This,0,11,3,6));
				 arr[6].addActionListener(new Handler(6,10,11,This,0,11,3,6));
			}
			else{
				
				undefine(2,1);
			}
			}

		
		});	
     arr[1].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			if(arr[1].isSelected())
			{
				redefine(0,2,7,10,12,19);
				revalidate();
				ActionListener[] a1 = arr[3].getActionListeners();
				for(int i=0;i<a1.length;i++)
				arr[3].removeActionListener(a1[i]);
				
				ActionListener[] a2 = arr[4].getActionListeners();
				for(int i=0;i<a2.length;i++)
				arr[4].removeActionListener(a2[i]);
				
				ActionListener[] a3 = arr[5].getActionListeners();
				for(int i=0;i<a3.length;i++)
				arr[5].removeActionListener(a3[i]);
				
				ActionListener[] a4 = arr[6].getActionListeners();
				for(int i=0;i<a4.length;i++)
				arr[6].removeActionListener(a4[i]);
				
				
				ActionListener[] a5 = arr[7].getActionListeners();
				for(int i=0;i<a5.length;i++)
				arr[7].removeActionListener(a5[i]);
				
				
				
				
				arr[3].addActionListener(new Handler(3,12,13,This,12,19,3,6));
				 arr[4].addActionListener(new Handler(4,14,16,This,12,19,3,6));
				 arr[5].addActionListener(new Handler(5,17,18,This,12,19,3,6));
				 arr[6].addActionListener(new Handler(6,19,19,This,12,19,3,6));
				
				
				
				//	addgrid(10,17);
			//	 action(11,3,6);
			}
			else{
					undefine(0,2);
			}
			}
		});
	    
     arr[2].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			if(arr[2].isSelected())
			{
				redefine(0,1,11,15,20,32);
				revalidate();
			//r
				//r
				ActionListener[] a1 = arr[3].getActionListeners();
				for(int i=0;i<a1.length;i++)
				arr[3].removeActionListener(a1[i]);
				
				ActionListener[] a2 = arr[4].getActionListeners();
				for(int i=0;i<a2.length;i++)
				arr[4].removeActionListener(a2[i]);
				
				ActionListener[] a3 = arr[5].getActionListeners();
				for(int i=0;i<a3.length;i++)
				arr[5].removeActionListener(a3[i]);
				
				ActionListener[] a4 = arr[6].getActionListeners();
				for(int i=0;i<a4.length;i++)
				arr[6].removeActionListener(a4[i]);
				
				ActionListener[] a5 = arr[7].getActionListeners();
				for(int i=0;i<a5.length;i++)
				arr[7].removeActionListener(a5[i]);
				
				//
				
				//
				
				
				arr[3].addActionListener(new Handler(3,21,22,This,21,32,3,7));
				 arr[4].addActionListener(new Handler(4,23,25,This,21,32,3,7));
				 arr[5].addActionListener(new Handler(5,26,27,This,21,32,3,7));
				 arr[6].addActionListener(new Handler(6,28,30,This,21,32,3,7));
				 arr[7].addActionListener(new Handler(7,31,32,This,21,32,3,7));
					
				 // action(19,3,7);
			//	addgrid(18,30);
			}
			else	{
				undefine(0,1);
				
			}
			}
		});
	}
Connection c=null;

private void dbms() {
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

//
JButton buy[]=new JButton[33];
JLabel photo[]=new JLabel[33];
JLabel price[]=new JLabel[33];
JLabel pname[]=new JLabel[33];

class mypanel extends JPanel
{
	private static final long serialVersionUID = 1L; 
	mypanel(int i)
	{
		this.setBackground(Color.BLUE);
		this.setLayout(null);
			buy[i]=new JButton("buy");
			
			photo[i]=new JLabel(imgp[i]);
			photo[i].setBounds(40,10,200,200);
			
			
			
			final int x=i;
			buy[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new Bus().new middle(x,This);
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
			
			
			buy[i].setBounds(80,240,120,20);
			add(buy[i]);
			price[i].setBounds(110,260,120,20);
			add(price[i]);
	
		setPreferredSize(new Dimension(290,280));
	}
		
}

public void addgrid(int x1,int y1)
{
	
  for(int x=x1;x<=y1;x++)
  {
	  mainpane.add(new mypanel(x));
  }
  
	
}
@Override
public void mouseDragged(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

double x,y;
public void mouseMoved(MouseEvent e) {
	x=e.getX();
	y=e.getY();
//	arr[2].setText(x+" "+y);
//name1.setText(x+" "+y);	
}
@Override
public void mouseClicked(MouseEvent e) {
	x=e.getX();
	y=e.getY();
//	arr[2].setText(x+" "+y);
}
@Override
public void mouseEntered(MouseEvent arg0) {
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
@Override
public void mouseReleased(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

}
