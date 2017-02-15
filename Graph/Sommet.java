package Graph;

import java.util.ArrayList;

public class Sommet {
	

	String id;
	String type;
	int gain;
	boolean actif;
	ArrayList<Arc> listArc;
	
	public Sommet()
	{
		id = "";
		type = "";
		gain = 0;
		actif = true;
		listArc = null;
	}
	public Sommet(String id, String type, int gain) {
		this.id = id;
		this.type = type;
		this.gain = gain;
		actif = true;
		listArc = null;
	}

	public Sommet(String id, String type, int gain, ArrayList<Arc> listArc) {
		this.id = id;
		this.type = type;
		this.gain = gain;
		actif = true;
		this.listArc = listArc;
	}
	
	public boolean isActif() {
		return actif;
	}
	public void setActif(boolean actif) {
		this.actif = actif;
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
}
