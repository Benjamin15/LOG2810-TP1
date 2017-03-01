package GUI.Dessin;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import Graph.Sommet;

@SuppressWarnings("serial")
public class Trajet extends JPanel{
	ArrayList<Sommet> sommets;


	public Trajet()
	{
		sommets = null;
	}
	
	public Trajet(ArrayList<Sommet> sommets) {
		super();
		this.sommets = sommets;
	}
	public ArrayList<Sommet> getSommets() {
		return sommets;
	}

	public void setSommets(ArrayList<Sommet> sommets) {
		this.sommets = sommets;
	}
	
	public void paintComponent(Graphics g){
		dessiner(g);
	}   
	
	public void dessiner(Graphics g)
	{
		if (sommets != null)
		{
			int x = 0;
			int y = 200;
			int i = 0;
			boolean retour = false;
			for (Sommet sommet : sommets)
			{
				SommetGUI sommetGui = new SommetGUI(x, y, sommet);
				if ( (i + 1) % 7 != 0)
				{
					if (i < sommets.size() - 1)
					{
						if (!retour)
							flecheDroite(g, x, y);
						else if (retour)
							flecheGauche(g, x, y);
					}
				}
				sommetGui.dessiner(g);
				if (++i % 7 == 0)
				{
					y += 200;
					x = (retour) ? -200 : x + 200;
					if (i < sommets.size() - 1)
					{
						if (retour)
							flecheBas(g, x+400, y);
						else
							flecheBas(g, x, y);
					}
					retour = (retour) ? false : true;
				}
				x = (!retour) ? x + 200 : x - 200;
			}
		}
	}
	public void flecheDroite(Graphics g, int x, int y)
	{
		g.drawLine(x+100, y+50, x+200, y+50);
		g.drawLine(x+170, y+30, x+200, y+50);
		g.drawLine(x+170, y+70, x+200, y+50);
	}
	
	public void flecheGauche(Graphics g, int x, int y)
	{
		g.drawLine(x-100, y+50, x, y+50);
		g.drawLine(x-70, y+30, x-100, y+50);
		g.drawLine(x-70, y+70, x-100, y+50);
	}
	public void flecheBas(Graphics g, int x, int y)
	{
		g.drawLine(x-150, y-100, x-150, y);
		g.drawLine(x-180, y-30, x-150, y);
		g.drawLine(x-120, y-30, x-150, y);
	}
}
