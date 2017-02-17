package GUI;

import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DessinGraph extends JPanel{

	
	
	  public void paintComponent(Graphics g){
		    int x1 = this.getWidth()/8;
		    int y1 = this.getHeight()/8;
		    g.drawOval(x1, y1, this.getWidth()/4, this.getHeight()/4);
		  }   
}
