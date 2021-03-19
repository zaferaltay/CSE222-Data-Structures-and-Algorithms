
/**
 * @author zafer
 *
 * @param <E>
 */
public interface SearchTree<E extends Comparable<E>> {
	public boolean add(E item);
	public E find(E item);
	public E delete(E item);
	public E remove(E item);
}
