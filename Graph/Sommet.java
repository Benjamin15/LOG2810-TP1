package Graph;

import java.util.ArrayList;

public class Sommet {
	

	String id;
	String type;
	int gain;
	ArrayList<Arc> listArc;
	
	public Sommet()
	{
		id = "";
		type = "";
		gain = 0;
		listArc = null;
	}
	public Sommet(String id, String type, int gain) {
		this.id = id;
		this.type = type;
		this.gain = gain;
		listArc = null;
	}

	public Sommet(String id, String type, int gain, ArrayList<Arc> listArc) {
		this.id = id;
		this.type = type;
		this.gain = gain;
		this.listArc = listArc;
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