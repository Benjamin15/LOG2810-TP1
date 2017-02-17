package GUI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;

import Graph.Graph;
import Graph.Test;

@SuppressWarnings("serial")
public class Interface extends JFrame implements WindowListener {


	private Menu menu;
	private DessinGraph dessin;
	private Graph graph;

	
	public Interface() throws HeadlessException {
		super();
		this.setTitle("Pokemon GO");
		this.setSize(1000, 1000);
	}
   
	public  void lancer()
	{
		Test test = new Test();
		graph = test.creerGraph();
		menu = new Menu(graph, test);
		dessin = new DessinGraph(graph);
		this.add(menu);
		this.add(dessin);
		this.setVisible(true);
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
