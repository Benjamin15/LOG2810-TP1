package GUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import GUI.Dessin.Trajet;
import Graph.Graph;

@SuppressWarnings("serial")
public class Menu extends JPanel{

	private JButton majCarte;
	private JButton cheminPlusCourt;
	private JButton cheminGrandGain;
	private JButton quitter;
	@SuppressWarnings("unused")
	private Graph graph;
	public Menu(Graph graph, JPanel panel, Trajet trajet)
	{
		this.graph = graph;
		setLayout(new FlowLayout());
	    this.setSize(500, 100);
	              
	    initBouton(graph, panel, trajet);
	}
	private void initBouton(Graph graph, JPanel tableau, Trajet trajet)
	{
		majCarte = new JButton("Mise à jour de la carte");
		majCarte.setLocation(0, 0);
		majCarte.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					graph.creerGraph();
					tableau.setVisible(true);
					trajet.setVisible(false);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				graph.lireGraph();
			}
			
		});
		add(majCarte);
		cheminPlusCourt = new JButton("Trouver le chemin le plus court");
		cheminPlusCourt.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String gain = JOptionPane.showInputDialog("Veuillez écrire le gain que vous souhaitez atteindre");
				gain = (gain == null) ? "" : gain;
				if (gain.matches("[0-9]*") && !gain.equals(""))
				{
					tableau.setVisible(false);
					trajet.removeAll();
					trajet.setSommets(graph.plusCourtChemin(graph.getListSommet().get(0), Integer.parseInt(gain)));
					trajet.update(trajet.getGraphics());
					trajet.setVisible(true);
				}
			}
			
		});
		add(cheminPlusCourt);
		cheminGrandGain = new JButton("Chemin ayant le plus grand gain");
		cheminGrandGain.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String distance = JOptionPane.showInputDialog("Veuillez écrire la distance que vous souhaitez atteindre (en metre)");
				distance = (distance == null) ? "" : distance;
				if (distance.matches("[0-9]*") && !distance.equals(""))
				{
					tableau.setVisible(false);
					trajet.removeAll();
					trajet.setSommets(graph.plusGrandGain(graph.getListSommet().get(0), Integer.parseInt(distance)));
					trajet.update(trajet.getGraphics());
					trajet.setVisible(true);
				}
			}
			
		});
		add(cheminGrandGain);
		quitter = new JButton("Quitter");
		quitter.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
			
		});
		add(quitter);
	}
}
