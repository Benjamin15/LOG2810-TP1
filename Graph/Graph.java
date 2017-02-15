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
	
	
}
