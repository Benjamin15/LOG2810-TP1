package GUI;

import java.awt.Graphics;

import javax.swing.JPanel;

import GUI.Dessin.SommetGUI;
import Graph.Arc;
import Graph.Graph;
import Graph.Sommet;

@SuppressWarnings("serial")
public class DessinGraph extends JPanel{

	private Graph graph;
	
	
	
	  public DessinGraph(Graph graph) {
		super();
		this.graph = graph;
	}



	public void paintComponent(Graphics g){
		dessinSommet(g);
	}   
	private void dessinSommet(Graphics g)
	{
		Sommet debut = graph.getListSommet().get(0);
	    int x = 0;
	    int y = this.getHeight()/3;
	    SommetGUI dessinSommet = new SommetGUI(x,y, debut);
	    dessinSommet.dessiner(g);
		for (Arc arc : debut.getListArc())
		{
			x += arc.getDistance()*4 + 100;
		    SommetGUI dessinSommets = new SommetGUI(x,y, arc.getDestination());
		    dessinSommets.dessiner(g);
		}
	}
}
