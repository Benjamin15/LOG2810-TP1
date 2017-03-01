package GUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import GUI.Dessin.Trajet;
import Graph.Graph;
import Graph.Pair;
import Graph.Sommet;

@SuppressWarnings("serial")
public class Menu extends JPanel{

	private JButton majCarte;
	private JButton cheminPlusCourt;
	private JButton cheminGrandGain;
	private JButton quitter;
	private JButton vider;
	private JLabel description;
	private JLabel resultat;
	@SuppressWarnings("unused")
	private Graph graph;
	
	public Menu(Graph graph, JPanel panel, Trajet trajet)
	{
		this.graph = graph;
		setLayout(new FlowLayout());
	    this.setSize(500, 200);
	    description = new JLabel();
	    resultat = new JLabel();
	    initBouton(graph, panel, trajet);
	    add(description);
	    add(resultat);
	}
	/**
	 * Methode permettant d'initialiser les boutons
	 * @param graph
	 * @param tableau
	 * @param trajet
	 */
	private void initBouton(Graph graph, JPanel tableau, Trajet trajet)
	{

		initMajCarte(tableau, trajet);
		initCheminPlusCourt(tableau, trajet);
		initCheminGrandGain(tableau, trajet);
		initQuitter();
		initVider(trajet);
		
	}
	
	/**
	 * Methode permettant d'initialiser le bouton de mise à jour de la carte
	 * @param tableau
	 * @param trajet
	 */
	private void initMajCarte(JPanel tableau, Trajet trajet)
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
					resultat.setText("");
					description.setText("");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				graph.lireGraph();
			}
			
		});
		add(majCarte);
	}
	
	/**
	 * Methode Permettant d'initialiser le bouton permettant de calculer le plus court chemin
	 * @param tableau
	 * @param trajet
	 */
	private void initCheminPlusCourt(JPanel tableau, Trajet trajet)
	{
		cheminPlusCourt = new JButton("Trouver le chemin le plus court");
		cheminPlusCourt.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String gain = JOptionPane.showInputDialog("Veuillez écrire le gain que vous souhaitez atteindre");
				gain = (gain == null) ? "" : gain;
				if (gain.matches("[0-9]*") && !gain.equals(""))
				{
					Pair<ArrayList<Sommet>, Integer> pair =graph.plusCourtChemin(graph.getListSommet().get(0), Integer.parseInt(gain));
					tableau.setVisible(false);
					//trajet.setVisible(false);
					trajet.setSommets(pair.first);
					trajet.revalidate();
					description.setText("     gain rechercher : " + gain);
					resultat.setText("                             distance obtenu : " + pair.second );
					trajet.setVisible(true);/*trajet.repaint();*/
				}
			}
			
		});
		add(cheminPlusCourt);
	}
	
	
	/**
	 * Methode permettant d'initialiser le bouton qui permet de calculer le chemin ayant le plus grand gain.
	 * @param tableau
	 * @param trajet
	 */
	private void initCheminGrandGain(JPanel tableau, Trajet trajet)
	{
		cheminGrandGain = new JButton("Chemin ayant le plus grand gain");
		cheminGrandGain.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String distance = JOptionPane.showInputDialog("Veuillez écrire la distance que vous souhaitez atteindre (en metre)");
				distance = (distance == null) ? "" : distance;
				if (distance.matches("[0-9]*") && !distance.equals(""))
				{
					Pair<ArrayList<Sommet>, Integer> pair =graph.plusGrandGain(graph.getListSommet().get(0), Integer.parseInt(distance));
					description.setText("Distance a atteindre : " + distance);
					resultat.setText("                                         gain obtenu : " + pair.second);
					tableau.setVisible(false);
					trajet.setVisible(false);
					trajet.setSommets(pair.first);
					trajet.revalidate();
					trajet.repaint();
					trajet.setVisible(true);
				}
			}
			
		});
		add(cheminGrandGain);
	}
	
	/**
	 * Methode permettant d'initialiser le bouton quitter
	 */
	private void initQuitter()
	{
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
	
	/**
	 * Methode permettant d'initialiser le bouton permettant de vider l'écran
	 * @param trajet
	 */
	private void initVider(Trajet trajet)
	{
		vider = new JButton("vider");
		vider.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				trajet.setSommets(new ArrayList<Sommet>());
				trajet.setVisible(false);
				description.setText("");
				resultat.setText("");
			}
			
		});
		add(vider);
	}
}
