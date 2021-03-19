import java.util.Scanner;

public class FileSystemTree {
	private String[] FILEORDIRECTORY= {"file","directory"};
	private boolean[] DECISIONTYPE= {true,false};

	/**
	 * @author zafer
	 *The inner class that holds the type of node, name, child and siblings
	 *
	 */
	protected class Node{
		
		protected boolean isfile;
		protected String name;
		protected Node child=null;
		protected Node siblings=null;
		
		

		public Node(String item,String type) {
			
			if(type.matches(FILEORDIRECTORY[0])) {
				isfile=DECISIONTYPE[0];
			}else {
				isfile=DECISIONTYPE[1];
			}
			name=item;
		}
		
		public String toString() {
			return name;
		}
		
	}
	
	private Node root;
	private int controller=0;
	
	/**
	 * The constructor that created the root directory
	 * @param rootName is directory name
	 */
	public FileSystemTree(String rootName) {
		root=new Node(rootName,"directory");
	}
	/**
	 * The method that finds the node given in the path.Advances to the correct node, comparing root names each '/' before
	 * @param root
	 * @param path is given path
	 * @return correct node
	 */
	private Node correctChild(Node root,String path){
		Node temp=root;
		Node temp2=root;
		String []name=path.split("/");
		StringBuilder correct=new StringBuilder();
		
		for(int i=0;i<name.length-1;i++) {
			correct.append(name[i]);
			if(i!=name.length-2) {
				correct.append("/");
			}
		}
		
		while(temp!=null) {
			if(temp.name.matches(correct.toString())) {
				return temp;
			}
			if(temp2.siblings!=null) {
				temp2=temp2.siblings;
				if(temp2!=null && temp2.name.matches(correct.toString())) {
					return temp2;
				}
			}
			else {
				temp2=temp.child;
				temp=temp.child;
			}
		}
		
		return null;
	}
	
	/**
	 * It tries to add children to the given node. If the child is not null, it calls to addSiblings method.
	 * @param localRoot
	 * @param nameOfItem
	 * @param itemType is file or directory
	 */
	private void addChildOrSiblings(Node localRoot,String nameOfItem,String itemType){
		if(localRoot.isfile==DECISIONTYPE[0]) {
			System.out.println("You can not add child into a file");
			return ;
		}
		
		if (localRoot.child==null) {
			localRoot.child=new Node(nameOfItem,itemType);
		}else {
			addSibling(localRoot.child,nameOfItem,itemType);
		}
		
	}
	/**if the  siblings of node is not empty it will work again for the  node siblings.
	 * if the siblings of node is null,it creates new node
	 * @param localRoot
	 * @param nameOfItem
	 * @param itemType
	 */
	private void addSibling(Node localRoot,String nameOfItem,String itemType){
		if(localRoot.siblings!=null) {
			addSibling(localRoot.siblings,nameOfItem,itemType);
		}else {
			localRoot.siblings=new Node(nameOfItem,itemType);
			
		}
	}
	
	/**
	 * uses auxiliary methods to attach directory to the given path
	 * @param directoryName is path
	 */
	public void addDir(String directoryName){
		Node temp=correctChild(root,directoryName);
		
		if(temp!=null)
		     addChildOrSiblings(temp,directoryName,"directory");
		else
			System.out.println("You entered invalid path   "+directoryName);
		
	}
	/**
	 * uses auxiliary methods to attach files to the given path
	 * @param fileName is path
	 */
	public void addFile(String fileName){
		Node temp=correctChild(root,fileName);
		
		if(temp!=null)
		    addChildOrSiblings(temp,fileName,"file");
		else
			System.out.println("You entered invalid path  "+fileName);
	}

	/**
	 * Starter function of printfFileSytem
	 */
	public void printFileSystem() {
		printFileSystem(root,0);
	}
	/**
	 * It first writes the name of the node it is on, then works again for child and siblings respectively
	 * @param root
	 * @param num is counter of spaces
	 */
	private void printFileSystem(Node root,int num) {
		for(int i=0;i<num;i++) {
			System.out.printf("    ");
		}
		if(root==null) {
			System.out.println("");
		}
		else {
			System.out.printf("->");
			System.out.println(root.name+"\n");
			printFileSystem(root.child,num+1);
			printFileSystem(root.siblings,num);
		}
		
	}
	
	/**
	 * Starter function of search
	 * @param searchingFile
	 */
	public void search(String searchingFile) {
		Node temp=root;
		search(temp,searchingFile);
	}
	/**
	 * 
	 * Calls first for the name of the knot and then for children and siblings in order.If names contain string, prints the path to the screen
	 * @param temp
	 * @param find
	 */
	private void search(Node temp,String find) {
		if(temp!=null) {
			String []names=temp.toString().split("/");		
			if(names[names.length-1].contains(find)) {
				if(temp.isfile)
				     System.out.println(FILEORDIRECTORY[0]+"-->"+temp.toString());
				
				else
					 System.out.println(FILEORDIRECTORY[1]+"-->"+temp.toString());
			}			
		}
		if(temp==null) {
			
		}
		else {
			search(temp.child,find);
			search(temp.siblings,find);
		}
	}
	
    /**
     * If the root directory is want to be deleted, it will be deleted.
     * If not, calls the private remove function
     * @param removeItem
     */
    public void remove(String removeItem) {
    	controller=0;
		if(root.toString().matches(removeItem)) {
			root=null;
			return;
		}
		root.child=remove(root.child,removeItem); 
		if(controller==0) {
			System.out.println("The item is not found");
		}
    }
    /**
     * It breaks the given path and proceeds until it find the correct node.
     * Until it finds the right node, it works again for the child and then the siblings
     * If the child is not null, it asks for approval 
     * Then deletes
     * @param temp
     * @param find is wanted name of node
     * @return removed node
     */
    private Node remove(Node temp,String find){
    	if(temp==null) {
    		return null;
    	}else {
    		String []names=temp.toString().split("/");
    		    if(names[names.length-1].matches(find)) {
    			     if(temp.child!=null) {
    			        	controller=1;
    				           System.out.println("The Item has child,Do you still want to remove?\n1-)Yes\n2-)No");
    				           Scanner scan=new Scanner(System.in);
    				            int x=scan.nextInt();
    				             if(x==1){
    					             return temp.siblings;
    				               }else {
    					             return temp;
    				                }
    			          }else{
    			        	 return temp.siblings; 
    			          }
    		       }else {
    			       temp.child=remove(temp.child,find);
    			       temp.siblings=remove(temp.siblings,find);	
    		           }	
    	    }
		return temp;
    	
    
     }
    
}
