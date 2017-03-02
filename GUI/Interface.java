package GUI;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.JFrame;

import GUI.Dessin.Trajet;
import Graph.Graph;

@SuppressWarnings("serial")
public class Interface extends JFrame implements WindowListener {


	private Menu menu;
	private DessinGraph tableau;
	private Graph graph;
	private Trajet trajet;
	
	public Interface() throws HeadlessException {
		super();
		setTitle("Pokemon GO");
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
	}
	
   /**
    * Methode permettant de démarer l'interface graphique
    * @throws IOException
    */
	public  void lancer() throws IOException
	{
		graph = new Graph();
		graph.creerGraph();
		trajet = new Trajet();
		tableau = new DessinGraph(graph.getDonnee(), graph.getIdSommet());
		menu = new Menu(graph, tableau, trajet);
		trajet.setVisible(false);
		add(menu);
		add(tableau,  BorderLayout.NORTH);
		add(trajet);
		setVisible(true);
	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	public void windowActivated(WindowEvent e) { }
	public void windowClosed(WindowEvent e) { }
	public void windowDeactivated(WindowEvent e) { }
	public void windowDeiconified(WindowEvent e) { }
	public void windowIconified(WindowEvent e) { }
	public void windowOpened(WindowEvent e) { }

}
