import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/**
 * @author zafer
 *
 * @param <E>
 * Graph class that holds edges using Doubly Linked list
 * 
 */
public class LinkedListGraph<E> extends AbstractGraph {
	
	/**
	 * @author zafer
	 *
	 * @param <E>
	 *  this class kept links, one edge object, row and column for linked list.
	 */
	protected class Node<E>{
		E edge;
		int row;
		int column;
		int num;
		private Node rprev;
		private Node cprev;
		private Node rnext;
		private Node cnext;
		
		
		E getEdge() {
			return edge;
		}
		
		Node (int num){
			rnext=null;
			cnext=null;	
			rprev=null;
			cprev=null;
			row=-1;
			column=-1;
			this.num=num;
		}
		Node(int row,int column,E edge){
			this.row=row;
			this.column=column;
			
			this.edge=edge;
		}
		
	}
	
	
	Node head;
	private static double UNWEIGHTED_EDGE = 1.0;

	/**
	 * Construct a graph with the specified number of vertices and directionality
	 * @param numV The number of vertices
	 * @param directed The directionality flag
	 */
	@SuppressWarnings("unchecked")
	public LinkedListGraph(int numV, boolean directed) {
		super(numV, directed);
		head=new Node(-1);	
		Node temp=head;
		for(int i=0;i<=numV;i++){
			temp.rnext=new Node(i);
			temp.rnext.rprev=temp;
			temp=temp.rnext;
		}
		temp=head;
		for(int i=0;i<=numV;i++){
			temp.cnext=new Node(i);
			temp.cnext.cprev=temp;
			temp=temp.cnext;
		}
		
	}
	/**
	 *Checks whether there is an edge with given values
	 */
	@Override
	public boolean isEdge(int source, int dest){
		Node temp=head;
		for(int i=0;i<=2;i++) {
			temp=temp.rnext;
			
		}
		while(temp.cnext!=null) {
			if(temp.column==dest) {
				return true;
			}
			temp=temp.cnext;
			
		}
		return false;
		
	}
	/**
	 *It created a node according to the source and destination of the edge 
	 *It took as a parameter and proceeded to the relevant numbers in the nodes representing the vertexes and connected them
	 */
	@Override
	public void insert(Edge edge){
		int row=edge.getSource();
		int column=edge.getDest();
		Node temp=head;
		for(int i=0;i<=row;i++) {
			temp=temp.rnext;
		}
		
		while(temp.cnext != null && temp.cnext.column<column) {
			temp=temp.cnext;
		}
		if(temp.cnext!=null) {
			 Node temp2=new Node(row,column,edge);
			 temp2.cnext=temp.cnext;
			 if(!super.isDirected()) {
				  temp.cnext.cprev=temp2;
				  temp2.cprev=temp;
			 }
			   
			 temp.cnext=temp2;
		}else{
			temp.cnext=new Node(row,column,edge);
			 if(!super.isDirected())
			    temp.cnext.cprev=temp;
			
		}
		
		temp=head;
		
		for(int i=0;i<=column;i++) {
			temp=temp.cnext;
		}
		while(temp.rnext != null && temp.rnext.row<row) {
			temp=temp.rnext;
		}
		if(temp.rnext!=null) {
			 Node temp2=new Node(row,column,edge);
			 temp2.rnext=temp.rnext;
			 if(!super.isDirected()) {
				 temp.rnext.rprev=temp2;
				 temp2.rprev=temp;
			 }

			 temp.rnext=temp2;
		}else{
			temp.rnext=new Node(row,column,edge);
			 if(!super.isDirected())
			   temp.rnext.rprev=temp;
			
		}
		
	}
	
	/**
	 * ​It reached the location specified by parameters using rnext and cnext and returned the edge of that noded, if any. 
	 */
	public Edge getEdge(int source, int dest){
		
		Node temp=head;
		for(int i=0;i<=source;i++) {
			temp=temp.rnext;
		}
		while(temp.cnext!=null && temp.cnext.column<dest) {
			temp=temp.cnext;
		}
		if(temp.cnext!=null && temp.cnext.column==dest) {
			return (Edge) temp.cnext.getEdge();
		}
		
		return null;
	}
	
	/**
	 *ToString method for edges
	 */
	public String toString(){
		StringBuilder sb = new StringBuilder();
		Node temp=head.cnext;
		Node temp2=temp;
		for(int i=0; i < super.getNumV(); i++){
			sb.append("Edge " + i + "-->\n");
			while(temp2.rnext!=null){
				sb.append("\tedge: " +"Source: "+((Edge)temp2.rnext.getEdge()).getSource()+", Destination "+((Edge)temp2.rnext.getEdge()).getDest()+ ", Weight: " + ((Edge)temp2.rnext.getEdge()).getWeight() + "\n");
				temp2=temp2.rnext;
			}
			temp=temp.cnext;
			temp2=temp;
		}
		return sb.toString();
	}
	
	/**
	 *It returns vertex num
	 */
	@Override
	public int getNumV() {
		
		return super.getNumV();
	}

	
	/**
	 * @param source 
	 * @param dest
	 * @return deleted edge or null
	 * 
	 * ​Using rnext and cnext, It reached the location specified by the parameters and removed the node if any
	 */
	public Edge deleteEdge(int source,int dest) {
		Node temp=head;
		Node deletingEdge;
		for(int i=0;i<=source;i++) {
			temp=temp.rnext;
		}
		while(temp.cnext!=null && temp.cnext.column<dest) {
			temp=temp.cnext;
		}
		if(temp.cnext!=null && temp.cnext.column==dest) {
			deletingEdge= temp.cnext;
		}
		else {
			return null;
		}
		
			temp.cnext=deletingEdge.cnext;
			  if(!super.isDirected())
			    temp.cprev=deletingEdge.cprev;
			temp=head;
			
			
		for(int i=0;i<=dest;i++) {
				temp=temp.cnext;
		}	
		while(temp.rnext!=null && temp.rnext.row<source){
				temp=temp.rnext;
		}
		if(temp.rnext!=null && temp.rnext.column==dest){
			deletingEdge= temp.rnext;
		}
		else {
			return null;
		}
		
		temp.rnext=deletingEdge.rnext;
		 if(!super.isDirected())
		    temp.rprev=deletingEdge.rprev;
		
		return (Edge) deletingEdge.getEdge();
		
	}
	
	
	/**
	 * @author zafer
	 *
	 * @param <E>
	 * Inner iterator class that ı created
	 */
	public class KWIterator<E> implements Iterator{

		Node temp;
		@Override
		public boolean hasNext() {
			if(temp.cnext!=null) {
				return true;
			}
			return false;
		}

		@Override
		public Object next() {
			
			if(!hasNext())
			    return null;
			else {
				Node temp2;
				temp2=temp.cnext;
				temp=temp.cnext;
				return temp2.getEdge();
			}
		}
		
		public KWIterator(int source) {
			temp=head;
			while(true) {
				if(temp.num != source) {
					temp=temp.rnext;
				}
				else {
					break;
				}
			}
			
		}
		
	}
	
	
	
	@Override
	public Iterator<Edge> edgeIterator(int source) {
		KWIterator myIter=new KWIterator(source);
		return myIter;
	}

	//----------------------------------------SEARCH METHODS-----------------------------------------------------------
	
	/**
	 * @param start index
	 * @return parent array
	 * 
	 * Using BreadthFirstSearch algorihtm,it finds shortest path
	 */
	public int[] breadthFirstSearch(int start){
		Queue<Integer> theQueue = new LinkedList<Integer>();
		//Declare array parent and initialize its elements to -1
		int[] parent = new int[getNumV()];
		for(int i = 0; i <getNumV(); i++){
			parent[i] = -1;
		}
		//Declare array identified and initialize its elements to false
		boolean[] identified = new boolean[getNumV()];
		/* Mark the start vertex as identified and insert it into the queue */
		identified[start] = true;
		theQueue.offer(start);
		
		/* Perform breadth-first search until done */
		while(!theQueue.isEmpty()){	
			int current = theQueue.remove();
			Node temp=head;
			for(int i=0;i<=current;i++) {
				temp=temp.rnext;
			}
				
			while(temp.cnext!=null){
				Edge edge = (Edge) temp.cnext.getEdge();
				int neighbor = edge.getDest();
				
				if(!identified[neighbor]){
				
					identified[neighbor] = true;
				
					theQueue.offer(neighbor);
					
					parent[neighbor] = current;
				}
				temp=temp.cnext;
			}
			temp=head;
		
		}
		return parent;
	}
	
	//-----------------------------------------------------------------------------------------------------------------
	
	
	/**
	 * @param num
	 * deletes the vertex in the order given in the parameter
	 */
	public void deleteVertex(int num){
		Node temp=head;
		Node temp2;
		for(int i=0;i<num;i++) {
			temp=temp.rnext;
		}
		temp.rnext=temp.rnext.rnext;
		int x=0;
		temp=head;
		while(temp.cnext!=null) {
			temp2=temp.cnext;
			while(temp2.rnext != null && temp2.rnext.row<num) {
				temp2=temp2.rnext;
			}
			if(temp2.rnext!= null && temp2.rnext.row==num)
			  temp2.rnext=temp2.rnext.rnext;
			temp=temp.cnext;
		}
		
	}
	/**
	 * @param numId 
	 * adds the vertex that id of vertex numId
	 */
	public void addVertex(int numId) {
		Node temp=head;
		while(temp.rnext!=null) {
			temp=temp.rnext;
		}
		temp.rnext=new Node(numId);
		temp=head;
		while(temp.cnext!=null) {
			temp=temp.cnext;
		}
		temp.cnext=new Node(numId);
		
	}

	
	
	public void iterdene() {
		Iterator iter=edgeIterator(1);
		while(iter.hasNext()) {
			Edge temp=(Edge) iter.next();
			if(temp!=null)
			System.out.println("Source Dest Weight ---> " +temp.getSource()+" "+temp.getDest()+" "+temp.getWeight());
		}
		 
	}
	
	
}
