package Graph;

import java.util.ArrayList;

public class Sommet {
	

	private String id;
	private String type;
	private int gain;
	private int distanceActif;
	private boolean active;
	private ArrayList<Arc> listArc;
	
	public Sommet()
	{
		id = "";
		type = "";
		gain = 0;
		distanceActif = 0;
		active = true;
		listArc = null;
	}
	public Sommet(String id, String type, int gain) {
		this.id = id;
		this.type = type;
		this.gain = gain;
		distanceActif = 0;
		active = true;
		listArc = null;
	}

	public Sommet(String id, String type, int gain, ArrayList<Arc> listArc) {
		this.id = id;
		this.type = type;
		this.gain = gain;
		distanceActif = 0;
		active = true;
		this.listArc = listArc;
	}
	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getDistanceActif() {
		return distanceActif;
	}
	public void setDistanceActif(int distanceActif) {
		this.distanceActif = distanceActif;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getGain() {
		return gain;
	}
	public void setGain(int gain) {
		this.gain = gain;
	}
	
	public ArrayList<Arc> getListArc() {
		return listArc;
	}
	public void setListArc(ArrayList<Arc> listArc) {
		this.listArc = listArc;
	}
	
	/**
	 * permet de desactiver un sommet
	 */
	public void desactiver()
	{
		if (type.equals("pokemon") && gain == 100)
			distanceActif = 500;
		else if (type.equals("pokemon") && gain == 40)
			distanceActif = 200;
		else if (type.equals("pokemon") && gain == 10)
			distanceActif = 100;
		else if (type.equals("pokestop"))
			distanceActif = 100;
		active = false;
	}
	
	/**
	 * permet de diminuer la distance necessaire à la réactivation d'un sommet. Les arenes ne peuvent pas être reactivé.
	 * @param distance
	 */
	public void diminuerDistance(int distance)
	{
		if (!type.equals("arene"))
		{
			distanceActif -= distance;
			distanceActif = (distanceActif < 0) ? 0 : distanceActif;
			active = (distanceActif == 0) ? true : false;
		}
	}
	
	public void activer()
	{
		distanceActif = 0;
		active = true;
	}
	public String ToString()
	{
		String resultat = "("+id+", "+type+ ", "+gain+", (";
		if (listArc != null)
		{
			for (Arc arc : listArc)
			{
				resultat += "("+ arc.getDestination().getId() + ", " + arc.getDistance() + "), ";
			}
		}
		else
			resultat = resultat.substring(0, resultat.length() - 2);
		resultat = resultat.substring(0, resultat.length() - 2);
		resultat += ")";
		return resultat;
	}
}
