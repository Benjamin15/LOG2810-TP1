package Graph;

import java.util.ArrayList;

public class Graph {

	private ArrayList<Sommet> listSommet;

	public Graph() {
		listSommet = null;
	}
	
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
	 * permet de lire les graph a l'écran
	 */
	
	public void lireGraph()
	{
		
	}
	
	/**
	 * Permet de voir le plus court chemin. Affiche des données en sortie
	 * 
	 * @param debut
	 * @param gainVoulu
	 */
	public void plusCourtChemin(Sommet debut, int gainVoulu)
	{
		double taux = 0;
		int gainObtenu = 0;
		Sommet temp = null;
		Sommet sommetCourant = debut;
		Arc tempArc = null;
		int distanceParcouru = 0;
		while (gainObtenu < gainVoulu)
		{
			for (Arc arc: sommetCourant.getListArc())
			{
				if (taux <  arc.getDestination().getGain() / arc.getDistance())
				{
					temp = arc.getDestination();
					tempArc = arc;
					taux = temp.getGain() / arc.getDistance();
				}
			}
			sommetCourant = temp;
			taux = 0;
			gainObtenu += sommetCourant.getGain();
			distanceParcouru += tempArc.getDistance();
			System.out.println("gainActuel :"+ gainObtenu);
			System.out.println("distance Parcouru :"+ distanceParcouru);
		}
	}
	
	/**
	 * Permet de voir le plus grand gain à une distance max en partant d'un arc. Doit afficher les valeurs en sorties.
	 * 
	 * @param debut
	 * @param distanceMax
	 */
	public void plusGrandGain(Sommet debut, int distanceMax)
	{
		
	}
}
