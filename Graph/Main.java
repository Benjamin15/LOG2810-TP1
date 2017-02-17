package Graph;


import GUI.Menu;

public class Main {

	public static void main(String[] args) {
		creerMenu();
		Test test = new Test();
		Graph graph = test.creerGraph();
		graph.lireGraph();
	}

	public static void creerMenu()
	{
		Menu menu = new Menu();
		menu.lancer();
	}
}
