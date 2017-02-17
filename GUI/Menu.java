package GUI;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

import Graph.Graph;
import Graph.Test;

@SuppressWarnings("serial")
public class Menu extends Applet implements WindowListener {

	private Button majCarte;
	private Button cheminPlusCourt;
	private Button cheminGrandGain;
	private Button quitter;
	private TextField inputText;
	private Graph graph;
	private Menu applet;
	

   
	public  void lancer()
	{
		
		 applet = new Menu();
		initBouton();
		initTextField();
		Frame fenetre = new Frame("Graph Pokemon GO");
		fenetre.addWindowListener(applet);
		fenetre.add(applet, null);
		fenetre.setSize(1000, 1000);
		fenetre.setVisible(true);
		applet.init();
		applet.start();
	}

   
	private void initBouton()
	{
		Test test = new Test();
		graph = test.creerGraph();
		
		majCarte = new Button("Mise à jour de la carte");
		majCarte.setLocation(1000, 1000);
		majCarte.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				graph = test.creerGraph();
				graph.lireGraph();
			}
			
		});
		applet.add(majCarte);
		cheminPlusCourt = new Button("Trouver le chemin le plus court");
		cheminPlusCourt.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				graph.plusCourtChemin(graph.getListSommet().get(0), Integer.parseInt(inputText.getText()));
			}
			
		});
		applet.add(cheminPlusCourt);
		cheminGrandGain = new Button("Mise à jour de la carte");
		cheminGrandGain.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				test.plusGrandGain(graph.getListSommet().get(0), Integer.parseInt(inputText.getText()));
			}
			
		});
		applet.add(cheminGrandGain);
		quitter = new Button("Quitter");
		quitter.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
			
		});
		applet.add(quitter);
		
		
		
	}
   
	public void initTextField()
	{
		inputText = new TextField();
		inputText.setText("0");
		applet.add(inputText);
	}
	
	
	
	public void windowClosing(WindowEvent e) {
		System.exit(0);	// Ferme l'application si on clique sur la croix en haut à droite
	}
	public void windowActivated(WindowEvent e) { }
	public void windowClosed(WindowEvent e) { }
	public void windowDeactivated(WindowEvent e) { }
	public void windowDeiconified(WindowEvent e) { }
	public void windowIconified(WindowEvent e) { }
	public void windowOpened(WindowEvent e) { }

}
