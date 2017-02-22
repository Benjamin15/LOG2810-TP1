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
	 * permet de lire les graph a l'�cran
	 */

	public void lireGraph()
	{
		for (Sommet sommet : listSommet)
		{
			System.out.println(sommet.ToString());
		}
	}

	/**
	 * Permet de voir le plus court chemin. Affiche des donn�es en sortie
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
	 * Permet de mettre � jour la distance avant de r�active les sommets que nous avons d�j� travers�.
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
	 * Permet de voir le plus grand gain � une distance max en partant d'un arc. Doit afficher les valeurs en sorties.
	 *
	 * @param debut
	 * @param distanceMax
	 */
	public void plusGrandGain(Sommet debut, int distanceMax)
	{
		int distanceParcouru = 0;				//J'utilise les memes noms de varialbes que toi Benjamin et le meme type d'algorithme en fait :D
		Sommet sommetCourant = debut;
		int gainObtenu = 0;
		ArrayList<Sommet> cheminChoisi = new ArrayList<Sommet>();
		double tauxMax = 0;
		Sommet sommetTemp = null;
		Arc arcTemp = null;

		while(distanceParcouru < distanceMax){
			for(Arc arc: sommetCourant.getListArc()){		//On cherche le meilleur voisin
				if(tauxMax < arc.getDestination().getGain() / arc.getDistance() && arc.getDestination().isActive() && distanceParcouru + arc.getDestination().getDistance() < distanceMax){
					sommetTemp = arc.getDestination();
					arcTemp = arc;
					tauxMax = sommetTemp.getGain() / arc.getDestination().getDistance();
				}
			}
			sommetCourant = sommetTemp;
			cheminChoisi.add(sommetCourant);
			tauxMax = 0;
			distanceParcouru += arcTemp.getDistance();
			gainObtenu += sommetCourant.getGain();
			majDistance(cheminChoisi, arcTemp.getDistance());
			sommetCourant.desactiver();

		}
		System.out.println("Le meilleur moyen de rentabiliser " + distanceMax + "kms est de prendre ce chemin : ");
		for (Sommet sommet : cheminChoisi) {
			System.out.print(sommet);
			System.out.print("; ");
		}
		System.out.println("Au cours de ce chemin  vous aurez obtenu un gain total de : " + gainObtenu);
	}
}
