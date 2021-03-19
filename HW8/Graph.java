import java.util.Iterator;

/**
 * @author zafer
 *
 *Graph Interface
 */
public interface Graph {

	 int getNumV();
	 boolean isDirected();
	 boolean isEdge(int source, int dest);
	 void insert(Edge edge);
	 Edge getEdge(int source, int dest);
	 Iterator<Edge> edgeIterator(int source);
}
