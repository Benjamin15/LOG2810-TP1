package GUI;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import GUI.Dessin.SommetGUI;
import Graph.Arc;
import Graph.Graph;
import Graph.Sommet;

@SuppressWarnings("serial")
public class DessinGraph extends JPanel{

	private Graph graph;
	private ArrayList<SommetGUI> listSommetGUI;
	
	
	  public DessinGraph(Graph graph) {
		super();
		this.graph = graph;
		listSommetGUI = new ArrayList<SommetGUI>();
	}



	public void paintComponent(Graphics g){
		dessinSommet(g);
	}   
	private void dessinSommet(Graphics g)
	{
		calculerSommet();

		for (SommetGUI sommet : listSommetGUI)
		{
			sommet.dessiner(g);
		}
	}	
	
	private void calculerSommet()
	{		
		int x1 = getHeight()/8;
		int y1 = getWidth()/5*2;
		int x2 = x1 + 100 + graph.getListSommet().get(0).getListArc().get(0).getDistance() * 5;
		int y2 = y1;
		listSommetGUI.add(new SommetGUI(x1, y1, graph.getListSommet().get(0)));
		listSommetGUI.add(new SommetGUI(x2, y2, graph.getListSommet().get(3)));
		/*for(Arc arc : graph.getListSommet().get(0).getListArc())
		{
			
		}*/
	}
}
