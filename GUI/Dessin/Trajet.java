package GUI.Dessin;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import Graph.Sommet;

@SuppressWarnings("serial")
/**
 * Class Permettant de dessiner les trajets sous forme de graph.
 * @author benjamin
 *
 */
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
	
	/**
	 * Methode permettant de dessiner le graph à l'écran
	 * @param g
	 */
	public void dessiner(Graphics g)
	{
		if (sommets != null)
		{
			int x = 0;
			int y = 300;
			int i = 0;
			boolean retour = false;
			for (Sommet sommet : sommets)
			{
				SommetGUI sommetGui = new SommetGUI(x, y, sommet);
				flecheHorizontal(retour, x, y, g, i);
				sommetGui.dessiner(g);
				if (++i % 7 == 0)
				{
					y += 200;
					x = (retour) ? -200 : x + 200;
					flecheVertical(retour, x, y, g, i);
					retour = (retour) ? false : true;
				}
				x = (!retour) ? x + 200 : x - 200;
			}
		}
	}
	
	/**
	 * Methode permettant de dessiner une fleche allant vert la droite
	 * @param g
	 * @param x
	 * @param y
	 */
	public void flecheDroite(Graphics g, int x, int y)
	{
		g.drawLine(x+100, y+50, x+200, y+50);
		g.drawLine(x+170, y+30, x+200, y+50);
		g.drawLine(x+170, y+70, x+200, y+50);
	}
	
	
	/**
	 * Methode permettant de dessiner un fleche allant vers la gauche
	 * @param g
	 * @param x
	 * @param y
	 */
	public void flecheGauche(Graphics g, int x, int y)
	{
		g.drawLine(x-100, y+50, x, y+50);
		g.drawLine(x-70, y+30, x-100, y+50);
		g.drawLine(x-70, y+70, x-100, y+50);
	}

	/**
	 * Methode permettant de dessiner une fleche allant vers le bas.
	 * @param g
	 * @param x
	 * @param y
	 */
	public void flecheBas(Graphics g, int x, int y)
	{
		g.drawLine(x-150, y-100, x-150, y);
		g.drawLine(x-180, y-30, x-150, y);
		g.drawLine(x-120, y-30, x-150, y);
	}
	
	/**
	 * Methode permettant de dessiner les fleches verticales
	 * @param retour
	 * @param x
	 * @param y
	 * @param g
	 * @param i
	 */
	public void flecheVertical(boolean retour, int x, int y, Graphics g, int i)
	{
		if (i < sommets.size() - 1)
		{
			if (retour)
				flecheBas(g, x+400, y);
			else
				flecheBas(g, x, y);
		}
	}
	
	/**
	 * Methode permettant d'afficher les fleches horizontales
	 * @param retour
	 * @param x
	 * @param y
	 * @param g
	 * @param i
	 */
	public void flecheHorizontal(boolean retour, int x, int y, Graphics g, int i)
	{
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
	}
}
