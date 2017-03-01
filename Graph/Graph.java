package Graph;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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
		// On complete la liste des sommets
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
        
        for (String token : lines.get(1).split(";")) { // {"Sommet, Destination, Distance"}
        	
        	String[] infos = token.split(","); // {"Sommet", "Destination", "Distance"}
        	
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
        	
        	ArrayList<Arc> listArc = new ArrayList<Arc>();
        	
        	/*if(index == lines.get(1).split(";").length - 1){ // Si le sommet est a1 (Cas particulier index out of range)
	            listArc.add(new Arc(distances.get(lines.get(1).split(";").length - 1), destinations.get(lines.get(1).split(";").length - 1)));
	            listSommet.get(14).setListArc(listArc);
	            index++;
        	}*/
        	
        	//if (index < lines.get(1).split(";").length - 1) {
	        	while (sommet.equals(sommets.get(index)) && !fin) {
	        		
		        	//listArc.add(new Arc(distances.get(index), destinations.get(index)));
		        	sommet.getListArc().add(new Arc (distances.get(index), destinations.get(index)));
		        	destinations.get(index).getListArc().add(new Arc(distances.get(index), sommet));
		        	if (index + 1 < lines.get(1).split(";").length)
		        		index++; // MAX = 120
		        	else 
		        		fin = true;
		        	
	        	}
	        	
	        	//sommet.setListArc(listArc);
	        	
        	//}
        } 
     // creer le graph a partir de la liste de sommet 
        this.setListSommet(listSommet);
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
	public ArrayList<Sommet> plusCourtChemin(Sommet debut, int gainVoulu)
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
		return cheminChoisi;
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
	public ArrayList<Sommet> plusGrandGain(Sommet debut, int distanceMax)
	{
		int distanceParcouru = 0;				//J'utilise les memes noms de varialbes que toi Benjamin et le meme type d'algorithme en fait :D
		Sommet sommetCourant = debut;
		int gainObtenu = 0;
		ArrayList<Sommet> cheminChoisi = new ArrayList<Sommet>();
		double tauxMax = 0;
		Sommet sommetTemp = null;
		Arc arcTemp = null;

		while(distanceParcouru < distanceMax)
		{
			if (sommetCourant.getListArc() != null)
			{
				for(Arc arc: sommetCourant.getListArc()){		//On cherche le meilleur voisin
					//if(tauxMax < arc.getDestination().getGain() / arc.getDistance() && arc.getDestination().isActive() && distanceParcouru + arc.getDestination().getDistance() < distanceMax){
					if(tauxMax < arc.getDestination().getGain() / arc.getDistance() && arc.getDestination().isActive() && distanceParcouru + arc.getDistance() < distanceMax){ // update by ben, je sais pas si c'est ce que tu voulais
					sommetTemp = arc.getDestination();
						arcTemp = arc;
						//tauxMax = sommetTemp.getGain() / arc.getDestination().getDistance();
						tauxMax = sommetTemp.getGain() / arc.getDistance(); // update by ben, je sais pas si c'est ce que tu voulais
					}
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
			if (sommet != null)
			{
				System.out.print(sommet.getId());
				System.out.print("; ");
			}
		}
		System.out.println("Au cours de ce chemin  vous aurez obtenu un gain total de : " + gainObtenu);
		reactiver();
		return cheminChoisi;
	}
	
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
	private void reactiver()
	{
		for (Sommet sommet : listSommet)
		{
			sommet.activer();
		}
	}
}
