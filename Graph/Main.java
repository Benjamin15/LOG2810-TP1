package Graph;


import java.io.IOException;

import GUI.Interface;

public class Main {

	public static void main(String[] args) {
		try {
			creerMenu();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Graph graph = new Graph();
		try {
			graph.creerGraph();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		graph.lireGraph();
	}

	public static void creerMenu() throws IOException
	{
		Interface menu = new Interface();
		menu.lancer();
	}
}
