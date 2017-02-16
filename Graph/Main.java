package Graph;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		graphTest();
	}

	private static void graphTest()
	{
		Sommet debut = new Sommet("0", "type", 0); 
		Sommet sommet1 = new Sommet("1", "type", 20);		
		Sommet sommet2 = new Sommet("2", "type", 30);
		Sommet sommet3 = new Sommet("3", "type", 40);
		Sommet sommet4 = new Sommet("4", "type", 50);
		
		
		// Arc du sommet 1
		Arc arc1 = new Arc(10, sommet2);
		Arc arc2 = new Arc(25, sommet3);
		Arc arc3 = new Arc(20, sommet4);
		ArrayList<Arc> arcSommet1 = new ArrayList<Arc>();
		arcSommet1.add(arc1);
		arcSommet1.add(arc2);
		arcSommet1.add(arc3);
		sommet1.setListArc(arcSommet1);
		
		
		// Arc du sommet 2
		Arc arc4 = new Arc(10, sommet1);
		Arc arc5= new Arc(20, sommet3);
		Arc arc6 = new Arc(25, sommet4);
		
		ArrayList<Arc> arcSommet2 = new ArrayList<Arc>();
		arcSommet2.add(arc4);
		arcSommet2.add(arc5);
		arcSommet2.add(arc6);
		sommet2.setListArc(arcSommet2);
		
		// Arc du sommet 3
		Arc arc7 = new Arc(25, sommet1);
		Arc arc8 = new Arc(20, sommet2);
		Arc arc9 = new Arc(10, sommet4);
		
		ArrayList<Arc> arcSommet3 = new ArrayList<Arc>();
		arcSommet3.add(arc7);
		arcSommet3.add(arc8);
		arcSommet3.add(arc9);
		sommet3.setListArc(arcSommet3);
		
		// Arc du sommet 4
		Arc arc10 = new Arc(20, sommet1);
		Arc arc11 = new Arc(25, sommet2);
		Arc arc12 = new Arc(10, sommet3);
		
		ArrayList<Arc> arcSommet4 = new ArrayList<Arc>();
		arcSommet4.add(arc10);
		arcSommet4.add(arc11);
		arcSommet4.add(arc12);
		sommet4.setListArc(arcSommet4);
		
		
		
		//Creation des liens du début
		
		Arc arc13 = new Arc(5, sommet1);
		Arc arc14 = new Arc(5, sommet2);
		Arc arc15 = new Arc(15, sommet3);
		Arc arc16 = new Arc(15, sommet4);
		
		ArrayList<Arc> arcDebut = new ArrayList<Arc>();
		arcDebut.add(arc13);
		arcDebut.add(arc14);
		arcDebut.add(arc15);
		arcDebut.add(arc16);
		debut.setListArc(arcDebut);
		
		// creation de la collection de sommet
		
		ArrayList<Sommet> listSommet = new ArrayList<Sommet>();
		listSommet.add(sommet1);
		listSommet.add(sommet2);
		listSommet.add(sommet3);
		listSommet.add(sommet4);
		
		// Creation du graph
		Graph graph = new Graph(listSommet);
		graph.plusCourtChemin(debut, 100);
	}
}
