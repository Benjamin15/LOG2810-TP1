package GUI.Dessin;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import Graph.Sommet;

@SuppressWarnings("serial")
public class SommetGUI extends JPanel {

	private int x;
	private int y; 
	private Sommet sommet;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
		this.setLocation(x, y);
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
		this.setLocation(x, y);
	}
	public Sommet getSommet() {
		return sommet;
	}
	public void setSommet(Sommet sommet) {
		this.sommet = sommet;
	}
	
	public SommetGUI(int x, int y, Sommet sommet)
	{
		this.x = x;
		this.y = y;
		this.sommet = sommet;
		this.setLocation(x, y);
		this.setSize(100, 100);
		this.setVisible(true);
	}
	public void dessiner(Graphics g)
	{
		if (sommet.getType().equals("pokemon"))
			g.setColor(Color.red);
		else if (sommet.getType().equals("pokestop"))
			g.setColor(Color.blue);
		else
			g.setColor(Color.yellow);
	    g.drawOval(x, y, this.getWidth(), this.getHeight());
	    g.setColor(Color.BLACK);
	    g.drawString(sommet.getId(), x + getHeight()/2, y + getWidth()/2);
	}
}
