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
		for (Sommet sommet : listSommet)
		{
			System.out.println(sommet.ToString());
		}
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
		ArrayList<Sommet> cheminChoisi = new ArrayList<Sommet>();
		while (gainObtenu < gainVoulu)
		{
			for (Arc arc: sommetCourant.getListArc())
			{
				if (taux <  arc.getDestination().getGain() / arc.getDistance() && arc.getDestination().isActive())
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
			majDistance(cheminChoisi, tempArc.getDistance());
			cheminChoisi.add(sommetCourant);
			sommetCourant.desactiver();
			System.out.println("gainActuel :"+ gainObtenu);
			System.out.println("distance Parcouru :"+ distanceParcouru);
		}
	}
	
	/**
	 * Permet de mettre à jour la distance avant de réactive les sommets que nous avons déjà traversé.
	 * @param cheminChoisi
	 * @param distance
	 */
	public void majDistance(ArrayList<Sommet> cheminChoisi, int distance)
	{
		for (Sommet sommet : cheminChoisi)
		{
			sommet.diminuerDistance(distance);
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
