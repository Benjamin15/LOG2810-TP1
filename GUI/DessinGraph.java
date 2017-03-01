package GUI;


import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class DessinGraph extends JPanel{


	private JTable tableau;
	private Object[][] donnee;
	private String[] entete;
	 
	public DessinGraph() {
		super();
		tableau = null;
		donnee = null;
		entete = null;
	}
	
	public DessinGraph(Object[][] donnee, String[] entete) {
		super();
		this.donnee = donnee;
		this.entete = entete;
		tableau = new JTable(donnee, entete);
		tableau.setLocation(0, 300);
		setLayout(new FlowLayout(FlowLayout.CENTER));
		add(tableau);
	}
	public void afficherGraph()
	{
		tableau = new JTable(donnee, entete);
		add(tableau);
	}
  
	public JTable getTableau()
	{
		return tableau;
	}
	
	public Object[][] getDonnee() {
		return donnee;
	}

	public void setDonnee(Object[][] donnee) {
		this.donnee = donnee;
	}

	public String[] getEntete() {
		return entete;
	}

	public void setEntete(String[] entete) {
		this.entete = entete;
	}
}
