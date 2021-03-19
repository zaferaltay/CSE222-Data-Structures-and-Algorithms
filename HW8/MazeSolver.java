import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;

/**
 * @author zafer
 * 
 * Class that solves the maze that it reads from the file
 */
public class MazeSolver {
	

	/**
	 * @author zafer
	 *The class that contains the features of vertex
	 */
	private class Vertex{
		private int row;
		private int column;
		private int id;
		public Vertex(int row,int column,int id) {
			this.row=row;
			this.column=column;
			this.id=id;
		}
		
		
	}
	
	private static final char r='r';
	private static final char l='l';
	private static final char u='u';
	private static final char d='d';
	
	private ArrayList<ArrayList<Character>> maze=new ArrayList<>();
	private ArrayList<Vertex> vertexes=new ArrayList<>();
	private ArrayList<Edge> edges=new ArrayList<>();
	private Double[][] weightedGraph;

	private static final int NO_PARENT = -1;
	
	/**
	 * @param input is file name without .txt
	 * @throws IOException
	 * It reads each character in the file and adds it to the maze. Then calls the auxiliary classes for the edge and vertex.
	 * 
	 */
	public void readFromFile(String input) throws IOException{
		File file = new File(input+".txt");
		BufferedReader reader = null;
		reader = new BufferedReader(new FileReader(file));
		
		String satir = reader.readLine();
		while(satir!=null) {
			ArrayList<Character> temp=new ArrayList<>();
			for(int i=0;i<satir.length();i++) {
				temp.add(new Character(satir.charAt(i)));
			}
			maze.add(temp);
			
			
			satir=reader.readLine();
		}
		
		setVertex();

		findEdges();

	}
	
	/**
	 * The class that looks at all the lines in the maze one by one and finds and saves the vertexes.
	 * if there is 1 or more than 3 times  0 around 0, it is vertex
	 */
	private void setVertex(){
		int count=0;
		int countVertex=0;
		for(int row=0;row<maze.size();row++) {
			for(int column=0;column<maze.get(row).size();column++) {
				if(maze.get(row).get(column).equals(new Character('1')))
					    continue;
				 if(row==0) {			// ROW ÝLK SIRAYSA
					if(column==0) {  // 0-0 ÝNDEXÝ COL
						vertexes.add(new Vertex(row,column,countVertex));
						countVertex++;
					}
					else if(column<maze.get(row).size()-1) { //0 ÝLE SON ARASI COL
						
							if(new Character('0').equals(maze.get(row).get(column-1))){
								count++;
							}
							if(new Character('0').equals(maze.get(row+1).get(column))){
								count++;
							}
							if(new Character('0').equals(maze.get(row).get(column+1))){
								count++;
							}

						if(count==1 || count==3) {
							vertexes.add(new Vertex(row,column,countVertex));
							countVertex++;
							
						}
						count=0;
						
						
					}
					else {  //SON COL
						if(new Character('0').equals(maze.get(row).get(column-1))){
							count++;
						}
						if(new Character('0').equals(maze.get(row+1).get(column))){
							count++;
						}
						if(count==1 || count==3) {
							vertexes.add(new Vertex(row,column,countVertex));
							countVertex++;
						}
						count=0;
						
					}
				}
				else if(row<maze.size()-1) {   //ROW ÝLK VE SONUN ARASINDAYSA
					
					if(column==0) {    //0. col
					
							if(new Character('0').equals(maze.get(row-1).get(column))){
								count++;
								//System.out.println("burda1 ve count :"+count);
							}
							if(new Character('0').equals(maze.get(row+1).get(column))){
								count++;//System.out.println("burda2 ve count :"+count);
							}
							if(new Character('0').equals(maze.get(row).get(column+1))){
								count++;//System.out.println("burda3 ve count :"+count);
							}

						if(count==1 || count==3) {
							//System.out.println("eklendi çünkü count "+ count);
							vertexes.add(new Vertex(row,column,countVertex));
							countVertex++;
							
						}
						count=0;

					}
					else if(column<maze.get(row).size()-1) { //0 ÝLE SON ARASI COL
						
							if(new Character('0').equals(maze.get(row).get(column-1))){
								count++;
							}
							if(new Character('0').equals(maze.get(row+1).get(column))){
								count++;
							}
							if(new Character('0').equals(maze.get(row).get(column+1))){
								count++;
							}
							if(new Character('0').equals(maze.get(row-1).get(column))){
								count++;
							}

					
						if(count==1 || count>=3) {
							vertexes.add(new Vertex(row,column,countVertex));
							countVertex++;
							
						}
						count=0;
				
					}
					else { //son col
						if(new Character('0').equals(maze.get(row).get(column-1))){
							count++;
						}
						if(new Character('0').equals(maze.get(row+1).get(column))){
							count++;
						}
						if(new Character('0').equals(maze.get(row-1).get(column))){
							count++;
						}
						if(count==1 || count==3) {
							vertexes.add(new Vertex(row,column,countVertex));
							countVertex++;
						}
						count=0;
						
					}
					
				}
				else {  //Row sonsa
					
					if(column==0) {
						if(new Character('0').equals(maze.get(row).get(column+1))){
							count++;
						}
						if(new Character('0').equals(maze.get(row-1).get(column))){
							count++;
						}
						if(count==1) {
							vertexes.add(new Vertex(row,column,countVertex));
							countVertex++;
						}
						count=0;
					}
					else if(column<maze.get(row).size()-1) {
						
					
							if(new Character('0').equals(maze.get(row).get(column+1))){
								count++;
							}
							if(new Character('0').equals(maze.get(row-1).get(column))){
								count++;
							}
							if(new Character('0').equals(maze.get(row).get(column-1))){
								count++;
							}
							if(count==1 || count==3) {
								vertexes.add(new Vertex(row,column,countVertex));
								countVertex++;
							}

						count=0;
									
					}
					else {
						vertexes.add(new Vertex(row,column,countVertex));
						countVertex++;
					}
					
					
				}
				
				
				
				
				
			}
		}
		
		
	}  //End setVertex

	/**
	 * @param row is row of vertex
	 * @param col is column of vertex
	 * @return -1 or vertex id if there is
	 * 
	 * vertex, which contains the row and col properties in vertexes, searches for its return, if any.
	 * if there is not,it returns -1
	 * 
	 */
	private int isVertex(int row,int col){
		for(int i=0;i<vertexes.size();i++) {
			if(vertexes.get(i).row==row &&vertexes.get(i).column==col) {
				return vertexes.get(i).id;
			}
		}
		return -1;
	}
	
	/**
	 * For each vertex, it follows the path with the 0's around it. 
	 * If there is an edge that has not been saved before, it saves it.
	 * It calculates its weight for each step it takes.Works for every vertex.
	 * It determines a forbidden direction and prevents the road from going past.
	 * So an edge is saved once
	 */
	private void findEdges(){
		
		int startRow,startCol,vertexId;
		char suspendedMove='x';
		char suspendedMove2='x';
		int vertexNum=0;
		while(vertexNum<vertexes.size()) {
			startRow=vertexes.get(vertexNum).row;
			startCol=vertexes.get(vertexNum).column;
			vertexId=vertexes.get(vertexNum).id;
			if( startCol+1<maze.get(startRow).size() && maze.get(startRow).get(startCol+1).equals(new Character('0')) &&  suspendedMove != r  ) {  //saða varsa sað içi
				double weighted=1.0;
				startCol++;
				suspendedMove2=l;
				while(maze.get(startRow).get(startCol).equals(new Character('0'))) {
					if(isVertex(startRow,startCol)!=-1) {
						int flag=0;
						for(int i=0;i<edges.size();i++) {
							if((edges.get(i).getSource()==vertexId && edges.get(i).getDest()==isVertex(startRow,startCol)) ||(edges.get(i).getSource()==isVertex(startRow,startCol) && edges.get(i).getDest()==vertexId)) {
								flag=1;
								break;
							}
						}
						if(flag==0) {
							edges.add(new Edge(vertexId,isVertex(startRow,startCol),weighted));
						}
						
						suspendedMove=r;
						break;
					}
					if(startCol+1<maze.get(startRow).size()  && maze.get(startRow).get(startCol+1).equals(new Character('0')) &&  suspendedMove2 != r) {//right
						startCol++;
						weighted=weighted+1.0;
						suspendedMove2=l;
					}
					else if(startCol-1>=0  && maze.get(startRow).get(startCol-1).equals(new Character('0')) &&  suspendedMove2 != l) {//left
						startCol--;
						weighted=weighted+1.0;
						suspendedMove2=r;
					}
					else if(startRow-1>=0  && maze.get(startRow-1).get(startCol).equals(new Character('0')) &&  suspendedMove2 != u) {
						startRow--;
						weighted=weighted+1.0;
						suspendedMove2=d;
					}
					else if(startRow<maze.size()  && maze.get(startRow+1).get(startCol).equals(new Character('0')) &&  suspendedMove2 != d) {
						startRow++;
						weighted=weighted+1.0;
						suspendedMove2=u;
					}
				}
			}
			startRow=vertexes.get(vertexNum).row;
			startCol=vertexes.get(vertexNum).column;
			vertexId=vertexes.get(vertexNum).id;
			if( startCol-1>=0 && maze.get(startRow).get(startCol-1).equals(new Character('0')) &&  suspendedMove != l) {  //sola varsa soldan bul
				startCol--;
				double weighted=1.0;
				suspendedMove2=r;
				while(maze.get(startRow).get(startCol).equals(new Character('0'))) {
					if(isVertex(startRow,startCol)!=-1) {
						int flag=0;
						for(int i=0;i<edges.size();i++) {
							if((edges.get(i).getSource()==vertexId && edges.get(i).getDest()==isVertex(startRow,startCol)) ||(edges.get(i).getSource()==isVertex(startRow,startCol) && edges.get(i).getDest()==vertexId)) {
								flag=1;
								break;
							}
						}
						if(flag==0) {
							edges.add(new Edge(vertexId,isVertex(startRow,startCol),weighted));
						}
						suspendedMove=l;
						break;
					}
					if(startCol+1<maze.get(startRow).size()  && maze.get(startRow).get(startCol+1).equals(new Character('0')) &&  suspendedMove2 != r) {//right
						startCol++;weighted=weighted+1.0;
						suspendedMove2=l;
					}
					else if(startCol-1>=0  && maze.get(startRow).get(startCol-1).equals(new Character('0')) &&  suspendedMove2 != l) {//left
						startCol--;weighted=weighted+1.0;
						suspendedMove2=r;
					}
					else if(startRow-1>=0  && maze.get(startRow-1).get(startCol).equals(new Character('0')) &&  suspendedMove2 != u) {
						startRow--;weighted=weighted+1.0;
						suspendedMove2=d;
					}
					else if(startRow+1<maze.size()  && maze.get(startRow+1).get(startCol).equals(new Character('0')) &&  suspendedMove2 != d) {
						startRow++;weighted=weighted+1.0;
						suspendedMove2=u;
					}
				}				
				
				
			}
			startRow=vertexes.get(vertexNum).row;
			startCol=vertexes.get(vertexNum).column;
			vertexId=vertexes.get(vertexNum).id;
			
			if( startRow-1>=0 && maze.get(startRow-1).get(startCol).equals(new Character('0')) &&  suspendedMove != u) { /// varsa up
				startRow--;double weighted=1.0;
				suspendedMove2=d;
				
				while(maze.get(startRow).get(startCol).equals(new Character('0'))) {
					if(isVertex(startRow,startCol)!=-1) {
						int flag=0;
						for(int i=0;i<edges.size();i++) {
							if((edges.get(i).getSource()==vertexId && edges.get(i).getDest()==isVertex(startRow,startCol)) ||(edges.get(i).getSource()==isVertex(startRow,startCol) && edges.get(i).getDest()==vertexId)) {
								flag=1;
								break;
							}
						}
						if(flag==0) {
							edges.add(new Edge(vertexId,isVertex(startRow,startCol),weighted));
						}
						suspendedMove=u;
						break;
					}
					if(startCol+1<maze.get(startRow).size()  && maze.get(startRow).get(startCol+1).equals(new Character('0')) &&  suspendedMove2 != r) {//right
						startCol++;weighted=weighted+1.0;
						suspendedMove2=l;
					}
					else if(startCol-1>=0  && maze.get(startRow).get(startCol-1).equals(new Character('0')) &&  suspendedMove2 != l) {//left
						startCol--;weighted=weighted+1.0;
						suspendedMove2=r;
					}
					else if(startRow-1>=0  && maze.get(startRow-1).get(startCol).equals(new Character('0')) &&  suspendedMove2 != u) {
						startRow--;weighted=weighted+1.0;
						suspendedMove2=d;
					}
					else if(startRow+1<maze.size() && maze.get(startRow+1).get(startCol).equals(new Character('0')) &&  suspendedMove2 != d) {
						startRow++;weighted=weighted+1.0;
						suspendedMove2=u;
					}
				}	
		
			}
			startRow=vertexes.get(vertexNum).row;
			startCol=vertexes.get(vertexNum).column;
			vertexId=vertexes.get(vertexNum).id;
			if( startRow+1<maze.size() && maze.get(startRow+1).get(startCol).equals(new Character('0')) &&  suspendedMove != d) {
				
				startRow++;double weighted=1.0;
				suspendedMove2=u;
				
				while(maze.get(startRow).get(startCol).equals(new Character('0'))) {
					if(isVertex(startRow,startCol)!=-1) {
						int flag=0;
						for(int i=0;i<edges.size();i++) {
							if((edges.get(i).getSource()==vertexId && edges.get(i).getDest()==isVertex(startRow,startCol)) ||(edges.get(i).getSource()==isVertex(startRow,startCol) && edges.get(i).getDest()==vertexId)) {
								flag=1;
								break;
							}
						}
						if(flag==0) {
							edges.add(new Edge(vertexId,isVertex(startRow,startCol),weighted));
						}
						suspendedMove=u;
						break;
					}
					if(startCol+1<maze.get(startRow).size()  && maze.get(startRow).get(startCol+1).equals(new Character('0')) &&  suspendedMove2 != r) {//right
						startCol++;weighted=weighted+1.0;
						suspendedMove2=l;
					}
					else if(startCol-1>=0  && maze.get(startRow).get(startCol-1).equals(new Character('0')) &&  suspendedMove2 != l) {//left
						startCol--;weighted=weighted+1.0;
						suspendedMove2=r;
					}
					else if(startRow-1>=0  && maze.get(startRow-1).get(startCol).equals(new Character('0')) &&  suspendedMove2 != u) {
						startRow--;weighted=weighted+1.0;
						suspendedMove2=d;
					}
					else if(startRow+1<maze.size()  && maze.get(startRow+1).get(startCol).equals(new Character('0')) &&  suspendedMove2 != d) {
						startRow++;weighted=weighted+1.0;
						suspendedMove2=u;
					}
				}
		
			}	
			
			vertexNum++;
		}

		fillWeightedGraph();
		
	}
	
	/**
	 * Fills the weighted graph according to the weight of the edges.
	 * It also takes into account the source and destinition of the edge.
	 * Makes symmetrically
	 */
	private void fillWeightedGraph() {
		weightedGraph=new Double[vertexes.size()+1][];
		for(int i=0;i<vertexes.size();i++) {
			weightedGraph[i]=new Double[vertexes.size()+1];
		}
		for(int i=0;i<vertexes.size();i++) {
			for(int j=0;j<vertexes.size();j++) {
				weightedGraph[i][j]=Double.POSITIVE_INFINITY;
			}
		}
		
		
		for(int i=0;i<edges.size();i++) {
			weightedGraph[edges.get(i).getSource()][edges.get(i).getDest()]=new Double(edges.get(i).getWeight());
			weightedGraph[edges.get(i).getDest()][edges.get(i).getSource()]=new Double(edges.get(i).getWeight());
		}
		
	}
	/**
	 * Shows information of edges
	 */
	public void printEdges() {
		for(int i=0;i<edges.size();i++) {
			System.out.println(i+".Edge sources: "+edges.get(i).getSource()+" Destination: "+edges.get(i).getDest()+" Weigth: "+edges.get(i).getWeight());
		}
	}
	/**
	 * shows information of vertexes
	 */
	public void printVertexes() {
		for(int i=0;i<vertexes.size();i++) {
			System.out.println("Vertex id: "+vertexes.get(i).id+" Row: "+vertexes.get(i).row +" Column: "+vertexes.get(i).column);
		}
	}
	/**
	 * Print the maze
	 */
	public void printMaze() {
		for(int i=0;i<maze.size();i++) {
			for(int j=0;j<maze.get(i).size();j++) {
				System.out.printf(maze.get(i).get(j).toString()+" ");
			}
			System.out.println(" ");
		}
	}
	/**
	 * It shows the weighted graph.
	 * if there are edges with positive infinity weight, it will not print it on the screen
	 */
	public void printGraph() {
		for(int i=0;i<vertexes.size();i++) {
			for(int j=0;j<vertexes.size();j++) {
				if(weightedGraph[i][j]==Double.POSITIVE_INFINITY) {
					System.out.printf("      ");
				}
				else {
					if(weightedGraph[i][j]<10.0) {
						System.out.printf(" ["+weightedGraph[i][j].toString()+"]");
					}else
					System.out.printf("["+weightedGraph[i][j].toString()+"]");
				}
				 
			}
			System.out.println("");
		}
	}

	
	/**
	 * @param currentVertex
	 * @param parents
	 * 
	 */
	private void showShortestPath(int currentVertex, int[] parents){ 
		if (currentVertex == NO_PARENT) 
		{ 
			return; 
		} 
		showShortestPath(parents[currentVertex], parents); 
		System.out.print(currentVertex + " "); 
	}
	
	
	/**
	 * Finds the shortest path using the Dijkstra algorithm.
	 */
	public void dijkstraForShortest() { 
		 int startVertex=0;
	     int nVertices = weightedGraph[0].length-1; 
	     double[] shortestDistances = new double[nVertices]; 
	     boolean[] added = new boolean[nVertices]; 
	     for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) { 
	         shortestDistances[vertexIndex] = Double.MAX_VALUE; 
	         added[vertexIndex] = false; 
	     } 

	     shortestDistances[startVertex] = 0; 
	     int[] parents = new int[nVertices]; 
	     parents[startVertex] = NO_PARENT; 
	    
	     for (int i = 1; i < nVertices; i++) 
	     { 
	         int nearestVertex = -1; 
	         double shortestDistance = Double.MAX_VALUE; 
	         for (int vertexIndex = 0;vertexIndex < nVertices;vertexIndex++) 
	         { 
	             if (!added[vertexIndex] && shortestDistances[vertexIndex] < shortestDistance)  
	             { 
	                 nearestVertex = vertexIndex; 
	                 shortestDistance = shortestDistances[vertexIndex]; 
	             } 
	         } 
	         added[nearestVertex] = true; 
	         for (int vertexIndex = 0;vertexIndex < nVertices; vertexIndex++)  
	         { 	
	        	 double edgeDistance=0;
	        	 if(weightedGraph[nearestVertex][vertexIndex]!=null)
	               edgeDistance = weightedGraph[nearestVertex][vertexIndex]; 
	               
	             if (edgeDistance > 0 && ((shortestDistance + edgeDistance) < shortestDistances[vertexIndex]))  
	             { 
	                 parents[vertexIndex] = nearestVertex; 
	                 shortestDistances[vertexIndex] = shortestDistance +  edgeDistance; 
	             } 
	         } 
	     } 
	     
			System.out.print("\n\nVertex\t\t\t\t Distance\tPath"); 
			int vid=vertexes.size()-1;
			System.out.print("\n" + startVertex + " -> "); 
			System.out.print(vid + " \t\t\t "); 
			System.out.print(shortestDistances[vid] + "\t\t"); 
			showShortestPath(vid, parents); 
	     
	 } 

	
}
