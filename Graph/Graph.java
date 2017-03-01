package Graph;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Class Graph, qui represente toutes les données relative au graph. Il comporte des Sommets.
 *
 */
public class Graph {

	private ArrayList<Sommet> listSommet;

	public Graph() {
		listSommet = new ArrayList<Sommet>();
	}

	public Graph(ArrayList<Sommet> listSommet) {
		this.listSommet = listSommet;
	}

	public ArrayList<Sommet> getListSommet() {
		return listSommet;
	}

	public void setListSommet(ArrayList<Sommet> listSommet) {
		this.listSommet = listSommet;
	}

	/**
	 * Permet de remplir les objets afin de remplir le graph. Rempli l'arrayList avec tous les arcs.
	 * @throws IOException 
	 */
	public void creerGraph() throws IOException
	{
		String path = "data_pokemon.txt";
		ArrayList<Sommet> listSommet = new ArrayList<Sommet>();
		List<String> lines = Files.readAllLines(Paths.get(path));
        boolean fin= false;
        for (String token : lines.get(0).split(";")) {
        	String[] infos = token.split(",");
        	Sommet sommet = new Sommet();
        	sommet.setId(infos[0]);
        	sommet.setType(infos[1]);
        	sommet.setGain(Integer.parseInt(infos[2]));
        	listSommet.add(sommet);
        }
        ArrayList<Sommet> sommets = new ArrayList<Sommet>();
        ArrayList<Sommet> destinations = new ArrayList<Sommet>();
        ArrayList<Integer> distances = new ArrayList<Integer>();
        for (String token : lines.get(1).split(";")) {
        	String[] infos = token.split(",");
        	for(Sommet sommet : listSommet){
        		if (sommet.getId().equals(infos[0]))
        			sommets.add(sommet);
        	}
        	for(Sommet sommet : listSommet){
        		if (sommet.getId().equals(infos[1]))
        			destinations.add(sommet);
        	}
        	distances.add(Integer.parseInt(infos[2]));
        }
        Integer index = 0; 
        for (Sommet sommet : listSommet){
	        	while (sommet.equals(sommets.get(index)) && !fin) {
		        	sommet.getListArc().add(new Arc (distances.get(index), destinations.get(index)));
		        	destinations.get(index).getListArc().add(new Arc(distances.get(index), sommet));
		        	if (index + 1 < lines.get(1).split(";").length)
		        		index++;
		        	else 
		        		fin = true;
	        	}
        } 
        this.setListSommet(listSommet);
	}

	/**
	 * permet de lire les graph a l'ï¿½cran
	 */

	public void lireGraph()
	{
		for (Sommet sommet : listSommet)
		{
			System.out.println(sommet.toString());
		}
	}

	/**
	 * Permet de voir le plus court chemin. Affiche des donnï¿½es en sortie
	 *
	 * @param debut
	 * @param gainVoulu
	 */
	public Pair<ArrayList<Sommet>, Integer> plusCourtChemin(Sommet debut, int gainVoulu)
	{
		Pair<ArrayList<Sommet>, Integer> pair = new Pair<ArrayList<Sommet>, Integer>();
		double taux = 0;
		int gainObtenu = 0;
		Sommet temp = null;
		Sommet sommetCourant = debut;
		Arc tempArc = null;
		int distanceParcouru = 0;
		ArrayList<Sommet> cheminChoisi = new ArrayList<Sommet>();
		while (gainObtenu < gainVoulu)
		{
			if (sommetCourant.getListArc() != null)
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
		reactiver();
		pair.first = cheminChoisi;
		pair.second = distanceParcouru;
		return pair;
	}

	/**
	 * Permet de mettre ï¿½ jour la distance avant de rï¿½active les sommets que nous avons dï¿½jï¿½ traversï¿½.
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
	 * Permet de voir le plus grand gain ï¿½ une distance max en partant d'un arc. Doit afficher les valeurs en sorties.
	 *
	 * @param debut
	 * @param distanceMax
	 */
	public Pair<ArrayList<Sommet>, Integer> plusGrandGain(Sommet debut, int distanceMax)
	{
		Pair<ArrayList<Sommet>, Integer> pair = new Pair<ArrayList<Sommet>, Integer>();
		int distanceParcouru = 0;			
		Sommet sommetCourant = debut;
		ArrayList<Pair<Sommet, Arc>> cheminOuvert = new ArrayList<Pair<Sommet,Arc>>();
		int gainObtenu = 0;
		ArrayList<Sommet> cheminChoisi = new ArrayList<Sommet>();
		double tauxMax = 0;
		Sommet sommetTemp = null;
		Arc arcTemp = null;
		boolean fin = false;
		while(distanceParcouru < distanceMax && !fin)
		{
			if (sommetCourant.getListArc() != null)
			{
				for(Arc arc: sommetCourant.getListArc()){	
					if (arc.getDestination().isActive() && arc.getDistance() <= distanceMax)
						cheminOuvert.add(new Pair<Sommet, Arc> (sommetCourant, arc));
					if(tauxMax < arc.getDestination().getGain() / arc.getDistance() && arc.getDestination().isActive()
						&& distanceParcouru + arc.getDistance() < distanceMax)
						{
							sommetTemp = arc.getDestination();
							arcTemp = arc;
							tauxMax = sommetTemp.getGain() / arc.getDistance();
						}
				}
			}
			if (sommetCourant != sommetTemp)
			{
				sommetCourant = sommetTemp;
				cheminChoisi.add(sommetCourant);
				tauxMax = 0;
				distanceParcouru += arcTemp.getDistance();
				gainObtenu += sommetCourant.getGain();
				majDistance(cheminChoisi, arcTemp.getDistance());
				sommetCourant.desactiver();
			}
			else
			{
				tauxMax = 0;
				for (Pair<Sommet, Arc> chemin : cheminOuvert)
				{
					if (tauxMax < chemin.second.getDestination().getGain() / chemin.second.getDistance())
					{
						sommetTemp = chemin.second.getDestination();
						arcTemp = chemin.second;
						tauxMax = sommetTemp.getGain() / arcTemp.getDistance();
					}
				}
				fin = true;
			}
		}
		System.out.println("distance parcouru : " + distanceParcouru);
		affichageConsoleGrandGain(cheminChoisi, distanceMax, gainObtenu);
		reactiver();
		pair.first = cheminChoisi;
		pair.second = gainObtenu;
		return pair;
	}
	
	/**
	 * Methode permettant d'afficher le meilleur gain dans la console
	 * @param cheminChoisi
	 * @param distanceMax
	 * @param gainObtenu
	 */
	private void affichageConsoleGrandGain(ArrayList<Sommet> cheminChoisi, int distanceMax, int gainObtenu)
	{
		System.out.println("Le meilleur moyen de rentabiliser " + distanceMax + " metre est de prendre ce chemin : ");
		for (Sommet sommet : cheminChoisi) {
			if (sommet != null)
			{
				System.out.print(sommet.getId());
				System.out.print("; ");
			}
		}
		System.out.println("Au cours de ce chemin  vous aurez obtenu un gain total de : " + gainObtenu);
	}
	/**
	 * Methode permettant d'obtenir l'Id de tous les sommets
	 * @return
	 */
	public String[] getIdSommet()
	{
		String[] result = new String[listSommet.size() + 1];
		result[0] = " ";
		for (int i = 1; i < listSommet.size() + 1; i++)
		{
			result[i] = listSommet.get(i - 1).getId();
		}
		return result;
	}
	
	/**
	 * Methode permettant de renvoyer les données du graph à l'interface graphique.
	 * @return
	 */
	public Object[][] getDonnee()
	{
		Object[][] result = new Object[listSommet.size()][listSommet.get(0).getListArc().size() + 3];
		result[0][0] = listSommet.get(0).getId();
		result[0][1] = 0;
		int nbCaseNull = 0;
		for (int j = 0; j < listSommet.get(0).getListArc().size() ; j++)
		{
			result[0][j+2] = listSommet.get(0).getListArc().get(j).getDistance();
		}
		for (int i = 1; i < listSommet.size(); i++)
		{
			int j = 0;
			result[i][j++] = listSommet.get(i-1).getListArc().get(i-1).getDestination().getId();
			for (; j <= i ; j++)
			{
				result[i][j] = " ";
				nbCaseNull++;
			}
			result[i][j++] = 0;
			if (j < listSommet.get(0).getListArc().size() + 2)
			{
				for (; j < listSommet.get(i-1).getListArc().size() + 2; j++)
					result[i][j + i - nbCaseNull] = listSommet.get(i).getListArc().get(j - 2).getDistance();
			}
			nbCaseNull = 0;
		}
		return result;
	}
	
	/**
	 * Methode permettant de réactiver tous les sommets.
	 */
	private void reactiver()
	{
		for (Sommet sommet : listSommet)
		{
			sommet.activer();
		}
	}
}
