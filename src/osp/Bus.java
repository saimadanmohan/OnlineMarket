package osp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import osp.Products.mypanel;

public class Bus extends JFrame
{
	static JPanel leftpane;
	static JPanel rightpane=new JPanel()
	{
  ImageIcon img= new ImageIcon(getClass().getResource("final.jpg"));
		public void paintComponent(Graphics g)
		{
			g.drawImage(img.getImage(),0,0,null);
		}
	};
	static JPanel total;
	static JLabel order=new JLabel();
   static Bus obj;
public static void main(String args[])
{
	main(new boolean[33]);
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


static JLabel email=new JLabel("Email");
static JLabel mobile=new JLabel("Mobile");
static JLabel address=new JLabel("Address");
static JLabel pincode=new JLabel("Pincode");


static JTextField emailx=new JTextField(25);
static JTextField mobilex=new JTextField(10);
static JTextField addressx=new JTextField(50);
static JTextField pincodex=new JTextField(10);



static JLabel orderd=new JLabel();

static JLabel deliver=new JLabel();

static JLabel bill=new JLabel();
static JButton place =new JButton("Place Order");

static boolean flagis[]=new boolean[33];
private static double returnprice()
{
	
	/*for(int i=0;i<33;i++)
		System.out.print(flagis[i]+" ");
	*/
	
	
	String imgp[]={
			"510.jpg",
			"520.jpg",
			"710.jpg",
			"610.jpg",
			"900.jpg",
			"620.jpg",
			"720.jpg",
			"820.jpg",
			"800.jpg",
			"920.jpg",
			"925.jpg",
			"1020.jpg",

			"asha205.jpg",
			"asha306.jpg",
			"asha501.jpg",
			"asha210.jpg",
			"asha309.jpg",
			"asha308.jpg",
			"asha310.jpg",
			"asha311.jpg",

			"BlueSet.jpg",
			"reactionBset.jpg",
			"BluetoothHset.jpg",
			"820W-LessCharge.jpg",
			"BlueStereoSet.jpg",
			"ColoudPop.jpg",
			"USBCharger.jpg",
			"HardRese.jpg",
			"StereoBset.jpg",
			"BStereoSet.jpg",
			"ColoudKnock.jpg",
			"W-CarCharge.jpg",
			"ColoudBoom.jpg",
			};

	int i=0;
	double total=0;
	while(i<33)
	{
		if(obj.flagis[i])
		{
			System.out.println("der"+i);
			Statement s=null;
			try
			{
				s=c.createStatement();
				ResultSet rs=s.executeQuery("select cost from products where name like '%"+imgp[i].substring(0,imgp[i].length()-4)+"%'");
               while(rs.next())
               {
            	   System.out.println("workingeeeeeeeeeeeeee");
            	  total+=Double.parseDouble(rs.getString(1)); 
               }
               s.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		i++;
	}
	System.out.println("total"+total);
return total;
}	

public static void main(boolean flags[])
{
	dbms();
	flagis=flags;
	obj=new Bus();
	obj.setSize(1366,768);
	obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	total=new JPanel();
	total.setLayout(new BorderLayout());
	total.setPreferredSize(new Dimension(1366,650));
	leftpane=new JPanel();
	
	
//order.setIcon(obj.imgp[select]);
	rightpane.setLayout(null);
	
	
	Font myfont = new Font("Serif", Font.ITALIC | Font.BOLD, 12);
	
	mobile.setForeground(Color.WHITE);
	email.setForeground(Color.WHITE);
	address.setForeground(Color.WHITE);
	pincode.setForeground(Color.WHITE);
	
	mobile.setFont(myfont);
	email.setFont(myfont);
	address.setFont(myfont);
	pincode.setFont(myfont);
	
	rightpane.add(mobile);
	rightpane.add(mobilex);
	
	
	rightpane.add(email);
	rightpane.add(emailx);
	
	
	rightpane.add(address);
	rightpane.add(addressx);
	
	
	rightpane.add(pincode);
	rightpane.add(pincodex);
	
	rightpane.add(place);
	
	mobile.setBounds(150, 150, 50, 20);
	mobilex.setBounds(220, 150, 100, 20);
	email.setBounds(150, 190, 50, 20);
	emailx.setBounds(220, 190, 150, 20);
	address.setBounds(150, 230, 50, 20);
	addressx.setBounds(220, 230, 250, 20);
	pincode.setBounds(150, 270, 50, 20);
	pincodex.setBounds(220, 270, 100, 20);
	place.setBounds(200, 320, 120, 20);
	
	place.setFont(myfont);
	place.setBackground(Color.gray);
	
	rightpane.setPreferredSize(new Dimension(683,650));
	leftpane.add(order);
	leftpane.setBackground(Color.BLUE);
	rightpane.setBackground(Color.GREEN);

	
	place.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
		
			Statement s=null;
		      try {
					s=c.createStatement();
					System.out.println("successful");
				    
					
				double value=returnprice();	
					
				//System.out.println("select to_char(sysdate,'dd-mon-yyyy') from dual");
								
				ResultSet rs=s.executeQuery("select sysdate from dual");
				String d1=null,d2=null;
				while(rs.next())
				    {
				     d1=rs.getString(1);
				    }
				rs=s.executeQuery("select sysdate+2 from dual");
				
					while(rs.next())
				    {
				     d2=rs.getString(1);
				    }
				  System.out.println("INSERT INTO DELIVERY (EMAIL,MOBILE,ADDRESS,PINCODE,TOTAL,ORDERS,DELIVERI) VALUES ('"+emailx.getText()+"','"+Long.parseLong(mobilex.getText())+"','"+addressx.getText()+"','"+Long.parseLong(pincodex.getText())+"','"+(int)value+"','"+d1+"','"+d2+"')");
					s.executeQuery("INSERT INTO DELIVERY (EMAIL,MOBILE,ADDRESS,PINCODE,TOTAL,ORDERS,DELIVERI) VALUES ('"+emailx.getText()+"','"+Long.parseLong(mobilex.getText())+"','"+addressx.getText()+"','"+Long.parseLong(pincodex.getText())+"','"+(int)value+"','"+d1+"','"+d2+"')");

					JOptionPane.showMessageDialog(null,"order placed"+total);
					s.close();
		      } catch (SQLException e1) 
				{
					// TODO Auto-generated catch block
					
		        
					e1.printStackTrace();
				}
		}

		});
	
	
	addgrid(0,33,flags);
	
	
	JScrollPane scroll=new JScrollPane(leftpane,ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	
	total.add(scroll);
	total.add(rightpane,BorderLayout.EAST);
	obj.add(total);
	obj.revalidate();	
	obj.setVisible(true);
	

	
}

class mypanel extends JPanel
{

	JLabel photo[]=new JLabel[33];
	JLabel price[]=new JLabel[33];
	JLabel pname[]=new JLabel[33];
	JButton del[]=new JButton[33];

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
		setBorder(new LineBorder(Color.WHITE, 5, true));
		this.setBackground(Color.BLUE);
		this.setLayout(null);
		
		photo[i]=new JLabel(imgp[i]);
		photo[i].setBounds(40,25,200,200);
			
			
		
			final int x=i;
		
			
			String query="select name,cost from products where name like '%"+(imgp[i].toString().substring(49,imgp[i].toString().length()-4))+"%'";
			
			Statement stmt=null;
			try {
				stmt=c.createStatement();
			//	System.out.println("successful");
				ResultSet rs=stmt.executeQuery(query);
				while(rs.next())
				{
					del[i]=new JButton("remove");
					pname[i]=new JLabel(rs.getString(1));	
					pname[i].setForeground(Color.WHITE);
					
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
			
			pname[i].setBounds(100,235,120,20);
			
			add(pname[i]);
			
			
			price[i].setBounds(90,255,120,20);
			add(price[i]);
		
			del[i].setBounds(90,285,120,20);
			add(del[i]);
			final int xi=i;
			del[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
				 reset(xi);	
				}

				
			});
			
		setPreferredSize(new Dimension(310,325));
	}
	
}
private void reset(int x) {
	flagis[x]=false;
	obj.setVisible(false);
	obj.main(flagis);
//	
	//leftpane.removeAll();
	//addgrid(0,33,flagis);
//	System.out.println("hurray");
	//leftpane.revalidate();
	
}
public static void addgrid(int x1,int y1, boolean[] flags)
{
	
  for(int x=x1;x<y1;x++)
  {
	 if(flags[x])
	 {
		 obj.leftpane.add(obj.new mypanel(x));
		 System.out.println("removed"+x);
	 }
	}
  
	
}

}