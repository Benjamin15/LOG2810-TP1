package Graph;

import java.util.ArrayList;

public class Graph {

	ArrayList<Sommet> listSommet;

	public Graph(ArrayList<Sommet> listSommet) {
		this.listSommet = listSommet;
	}

	public ArrayList<Sommet> getListSommet() {
		return listSommet;
	}

	public void setListArc(ArrayList<Sommet> listSommet) {
		this.listSommet = listSommet;
	}
	
	/**
	 * Permet de remplir les objets afin de remplir le graph. Rempli l'arrayList avec tous les arcs.
	 */
	public void creerGraph()
	{
		
	}
	
	/**
	 * permet de lire les graph a l'�cran
	 */
	
	public void lireGraph()
	{
		
	}
	
	/**
	 * Permet de voir le plus court chemin. Affiche des donn�es en sortie
	 * 
	 * @param debut
	 * @param gainVoulu
	 */
	public void plusCourtChemin(Arc debut, int gainVoulu)
	{
		
	}
	
	/**
	 * Permet de voir le plus grand gain � une distance max en partant d'un arc. Doit afficher les valeurs en sorties.
	 * 
	 * @param debut
	 * @param distanceMax
	 */
	public void plusGrandGain(Arc debut, int distanceMax)
	{
		
	}
}
