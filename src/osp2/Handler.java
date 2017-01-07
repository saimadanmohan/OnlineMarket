package osp2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Handler implements ActionListener {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
int i;
int j;
int k;
Products objj;
static int f1,f2;
static int b1,b2;

public  Handler(int i,int j,int k,Products obj,int f1,int f2,int b1,int b2)
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
	
		if(objj.arr[i].isSelected())
		{
			objj.mainpane.removeAll();
			objj.addgrid(j,k);
			 for(int x=b1;x<=b2;x++)
			 {
				 if(x==i)
					 continue;
				 else
					 objj.arr[x].setVisible(false);
			 }
			 objj.revalidate();
		}
		else
		{
			objj.mainpane.removeAll();
			 for(int x=b1;x<=b2;x++)
			 {
 			 objj.arr[x].setVisible(true);
			 }
			 
			 objj.addgrid(f1,f2);
			 objj.revalidate();
		}
	}

}
