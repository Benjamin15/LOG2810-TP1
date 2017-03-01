package Graph;

/**
 * Class Pair, qui contient une pair d'element, similaire à celle existant en C++
 *
 * @param <F>
 * @param <S>
 */
public class Pair<F, S> {
 
	public F first;
    public S second;
    
    public Pair(F first, S second) {
 		this.first = first;
 		this.second = second;
 	}
    public Pair()
    {
    	first = null;
    	second = null;
    }
}
