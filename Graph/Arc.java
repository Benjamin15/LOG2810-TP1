package Graph;

/**
 * 
 * Class arc Representant le lien entre deux noeuds.
 *
 */
public class Arc {
	
	private int distance;
	private Sommet destination;
	
	public Arc()
	{
		this.distance = 0; // distance en mètre
		this.destination = null;
	}
	public Arc(int distance, Sommet destination) {
		this.distance = distance;
		this.destination = destination;
	}
	
	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public Sommet getDestination() {
		return destination;
	}

	public void setDestination(Sommet destination) {
		this.destination = destination;
	}
}
