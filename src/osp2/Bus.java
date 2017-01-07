package osp2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Bus extends JApplet
{
	JPanel leftpane;
	JPanel rightpane;
	JPanel total;
	JLabel order=new JLabel();
  
public void init()
{
	this.setSize(1366,650);
	
total=new JPanel();
total.setLayout(new BorderLayout());
total.setPreferredSize(new Dimension(1366,650));
leftpane=new JPanel();
rightpane=new JPanel();
//order.setIcon(obj.imgp[select]);
leftpane.setPreferredSize(new Dimension(683,650));
rightpane.setPreferredSize(new Dimension(683,650));
leftpane.add(order);
leftpane.setBackground(Color.BLUE);
rightpane.setBackground(Color.GREEN);

total.add(leftpane,BorderLayout.WEST);
total.add(rightpane,BorderLayout.EAST);
add(total);
revalidate();	
	
}

public class middle
{
	public middle(int x,Products p)
	{
		System.out.println(x);
		leftpane.removeAll();
		order.setIcon(p.imgp[x]);
		
		leftpane.add(order);
		revalidate();
	}
}
}
