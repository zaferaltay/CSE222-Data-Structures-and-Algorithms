import java.io.IOException;
import java.util.Stack;

/**
 * @author zafer
 *Class with tests of 2nd and 3rd part
 */
public class TestAll {

	/**
	 * 
	 */
	public static void test2() {
		System.out.println("First we create an undirected list");
		LinkedListGraph<Edge> ll=new LinkedListGraph<>(5,false);
		
		System.out.println("We insert edge according to the sample in pdf   T0");
		ll.insert(new Edge(0,1));
		ll.insert(new Edge(0,3));
		ll.insert(new Edge(0,2));	
		ll.insert(new Edge(1,3));
		ll.insert(new Edge(1,2));	
		ll.insert(new Edge(2,4));	
		ll.insert(new Edge(3,1));
		ll.insert(new Edge(3,2));


		
		
		System.out.println(ll.toString());
		
		System.out.println("We test bfs and print the shortest path to the screen   T1");
		int[] parent = ll.breadthFirstSearch(0);
		Stack thePath = new Stack();
		int v = ll.getNumV()- 1;
		while(parent[v] != -1){
			thePath.push(new Integer(v));
			v = parent[v];
		}
		//Output the path.
		System.out.println("The shortest path is:");
		while(!thePath.empty()){
			System.out.println(thePath.pop());
		}
		
		
		System.out.println("We write an extra function and test the iterator to show that it works  T2");
		ll.iterdene();
		
		System.out.println("Now we test delete vertex and print other  T3");
		ll.deleteVertex(1);
		System.out.println(ll.toString());
	}
	
	/**
	 * 
	 */
	public static void test3() {
		System.out.println("First of all, we create an object.");
		MazeSolver mz=new MazeSolver();
		try {
			System.out.println("Now we are reading from the file for maze. (We need not add txt while writing the file name)");
			mz.readFromFile("abc");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		System.out.println("We print the maze on the screen to test reading  T0");
		mz.printMaze();
		
		System.out.println("\n\nNow we will show all vertexes.   T1");
		mz.printVertexes();
		
		System.out.println("\n\nNow we will display all the edges   T2");
		mz.printEdges();
		
		System.out.println("\n\nNow, by applying the dijkstra algorithm, we print the shortest path on the screen.   T3");
		
		mz.dijkstraForShortest();;
	}		
	
	public static void main(String[] args) {
		//test2();
		//test3();
	}

}

































