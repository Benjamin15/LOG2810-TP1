package Graph;


import GUI.Interface;

public class Main {

	public static void main(String[] args) {
		creerMenu();
		Test test = new Test();
		Graph graph = test.creerGraph();
		graph.lireGraph();
	}

	public static void creerMenu()
	{
		Interface menu = new Interface();
		menu.lancer();
	}
}
