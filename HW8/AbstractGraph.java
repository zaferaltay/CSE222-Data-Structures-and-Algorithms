import java.util.*;
import java.io.*;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Abstract base class for graphs. A graph is a set of vertices
 * and a set of edges. Vertices are represented by integers from 0 to n - 1.
 * Edges are ordered pairs of vertices.
 * @author Jacob / Koffman & Wolfgang
 *
 */
public abstract class AbstractGraph implements Graph {
	
	//Data Fields
	
	/**
	 * Number of vertices
	 */
	private int numV;
	/**
	 * Flag to indicate whether this is a directed graph
	 */
	private boolean directed;
	/**
	 * Comma delimiter string parsing in graphs
	 */


	
	//Constructor
	
	/**
	 * Construct a graph with the specified number of vertices. 
	 * The boolean directed indicates whether or not this is a directed graph
	 * @param numV The number of vertices
	 * @param directed The directed flag
	 */
	public AbstractGraph(int numV, boolean directed){
		this.numV = numV;
		this.directed = directed;
	}
	
	
	//Methods

	public int getNumV() {
		return numV;
	}

	public boolean isDirected() {
		return directed;
	}

	public void insert(Edge e) {
		// Completed in non abstract implementations
	}

	public boolean isEdge(int source, int dest) {
		//completed in non abstract implementations
		return false;
	}

	public Edge getEdge(int source, int dest) {
		//completed in non abstract implementations
		return null;
	}

	public Iterator<Edge> edgeIterator(int source) {
		//completed in non abstract implementations
		return null;
	}
	

	

	
//---------------------------------------------------------------------------------------------------------------------------------------------------------
}