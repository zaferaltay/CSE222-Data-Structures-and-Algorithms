import java.util.Arrays;
import java.util.Random;

public class KWSkipList<E extends Comparable<E>> {
    
	 /**
	 * @author zafer
	 *
	 * @param <E>
	 *  SLNode contains information such as array elements, links, and the number of elements it holds.
	 */
	private static class SLNode<E> {  
		 SLNode<E>[] links;
		 E []data;
		 int max;
		 int min;
		 int level;
		 int size=0;
       SLNode(int max,int min,int level,E item) {     
            links = (SLNode<E>[]) new SLNode[level];    
            data= (E[]) new Comparable[max];
            data[size]=item;
            size++;
            this.max=max;
            this.min=min;
            this.level=level;
           }  
       SLNode(int max,int min,int level){
    	   links = (SLNode<E>[]) new SLNode[level];  
           this.max=max;
           this.min=min;
           this.level=level;
       }
       /**
     * @param item is item to be added
     * @return null or added item
     * Adds and sorts the item it gets to the directory where the data elements are located.
     */
    public E add(E item){
    	  int flag=0;
    	   if(data[0]==null) {
    		   data[0]=item;
    	   }

    	   for(int i=0;i<size;i++) {
    		   if(((Comparable<E>)item).compareTo(data[i])<0) {
    			   flag=1;
    			   if(size==max) {
    				   size--;
    			   }
    			   for(int j=size;j>i;j--) {
    				   data[j]=data[j-1];
    			   }
    			   data[i]=item;
    			   size++;
    			   return data[i];
    		   }else if(((Comparable<E>)item).compareTo(data[i])==0) {
    			   return null;
    		   }
    	   }
    	   if(flag==0) {
 
    		   data[size]=item;
    		   size++;
    	   }
    	   
    	   return null;
    	   
       }
       /**
     * Increment size by 1.
     */
    public void incrementSize() {
    	   size++;
       }
       /**
     * Decrement size by 1.
     */
    public void decrementSize() {
    	   size--;
       }
       /**
     * @return elements number of node
     */
    public int getSize() {
    	   return size;
       }
	 }
	 
		public SLNode<E> head;
		/**
		 * Size of the skip list
		 */
		private int size;
		/**
		 * The maximum level of the skip-list
		 */
		private int maxLevel;
		/**
		 * Smallest power of 2 that is greater than the current skip-list size
		 */
		private int maxCap;
		/**
		 * Natural log of 2
		 */
		static final double LOG2 = Math.log(2.0);
		/**
		 * Minimum possible integer value for the head
		 */
		static final int MIN = Integer.MIN_VALUE;
		/**
		 * Random number generator
		 */
		private Random rand = new Random();
		int max,min;
	 
	 /**
	 * @param max is Node's handle maximum number of elements
	 * @param min is Node's handle minimum number of elements
	 */
	KWSkipList(int max,int min){
		this.max=max;
		this.min=min;
		size = 0;
		maxLevel = 1;
		maxCap = computeMaxCap(maxLevel);
		head = new SLNode<>(max,min,maxLevel);
	 }
	 private int computeMaxCap(int level){
			return (int) Math.pow(2, level) - 1;
		}
	 private int logRandom() {  
		 int r = rand.nextInt(maxLevel);
		 int k = (int) (Math.log(r + 1) / LOG2);
		 if (k > maxLevel - 1) {        
			 k = maxLevel - 1; 
		 }    
		 return maxLevel - k;
		}
	 
	 
	 /**
	 * @param item is item to add.
	 * The method that adds if the node of the item to be added is smaller than the maximum number of elements, and sends it to the split method if it is the maximum number of elements.
	 */
	public void add(E item) {
		
		 SLNode<E>[] pred = search(item);
			
		 if(pred[0].equals(head)) {		 
			 if(pred[0].links[0]==null) {
				 SLNode<E> tmpp=new SLNode<>(max,min,logRandom(),item);
				 for(int i=0;i<tmpp.links.length;i++) {
					 tmpp.links[i]=pred[0].links[i];
					 pred[0].links[i]=tmpp;
				 }
				
			 }
			 else if(pred[0].links[0].getSize()<max) {
				 pred[0].links[0].add(item);
			 }
			 else {
				 size++;			 
					if(size > maxCap){
						maxLevel++;
						maxCap = computeMaxCap(maxLevel);
						head.links = Arrays.copyOf(head.links, maxLevel);
						pred = Arrays.copyOf(pred, maxLevel);
						pred[maxLevel - 1] = head;
					}			
					
				 split(pred[0].links[0],item,pred);
			 }
			 return ;
		 } 

		 if(pred[0].getSize()<max) {
			 pred[0].add(item);
		 }
		 else if(pred[0].getSize()==max) {
			 size++;			 
				if(size > maxCap){
					maxLevel++;
					maxCap = computeMaxCap(maxLevel);
					head.links = Arrays.copyOf(head.links, maxLevel);
					pred = Arrays.copyOf(pred, maxLevel);
					pred[maxLevel - 1] = head;
				}			
				
			 split(pred[0],item,pred);
		 }

	 
	 }
	 /**
	 * @param node node to be added
	 * @param item item to be added
	 * @param pred is pred
	 * 
	 * The method that adds a new node to the list by adding the item it receives to the node and dividing it into two parts sequentially.Details in the report
	 */
	private void split(SLNode<E> node,E item,SLNode<E>[] pred) {
		 E temp,tempItem;int counter=0;
		 int level=logRandom();
		 if(item.compareTo(node.data[node.getSize()-1])<0){
			temp=node.data[node.getSize()-1];
			node.add(item);
			SLNode<E> tempNode=new SLNode<>(max,min,level,temp);
			 for(int i=(node.getSize()/2)+1;i<node.getSize();i++){
				 tempNode.add(node.data[i]);
				 counter++;
			 }
			 for(int i=0;i<counter;i++) {
				 node.decrementSize();
			 }

			 
			 
			 if(node.level<tempNode.level) {
				 for(int i=0;i<node.level;i++) {
					 tempNode.links[i]=node.links[i];
					 node.links[i]=tempNode;
				 }
				 for(int i=node.level;i<tempNode.level;i++) {
					 tempNode.links[i]=pred[i].links[i];
					 pred[i].links[i]=tempNode;
				 }
			 }
			 else {
				 for(int i=0;i<tempNode.level;i++) {
					 tempNode.links[i]=node.links[i];
					 node.links[i]=tempNode;
				 }
			 }
		 }
		 else {
			 temp=item;
			 SLNode<E> tempNode=new SLNode<>(max,min,level,temp);
			 if(node.level<tempNode.level) {
				 for(int i=0;i<node.level;i++) {
					 tempNode.links[i]=node.links[i];
					 node.links[i]=tempNode;
				 }
				 for(int i=node.level;i<tempNode.level;i++) {
					 tempNode.links[i]=pred[i].links[i];
					 pred[i].links[i]=tempNode;
				 }
			 }
			 else {
				 for(int i=0;i<tempNode.level;i++) {
					 tempNode.links[i]=node.links[i];
					 node.links[i]=tempNode;
				 }
			 }
		 }
		 
		 


	 }

	 /**
	 * @param target is the searcched item
	 * @return pred
	 * Returns an array that is the reference to the nodes holding the elements smaller than item but largest elements of the searched element for each level.
	 */
	private SLNode<E>[] search (E target) {
		 SLNode<E>[] pred = (SLNode<E>[]) new SLNode[maxLevel];
		 SLNode<E> current = head;
		 for (int i = current.links.length-1; i >= 0; i--) {
			 while (current.links[i] != null && current.links[i].data[0].compareTo(target) < 0) {
				 current = current.links[i]; 
			 }
			 pred[i] = current; 
		 }
		 return pred;
	 }
	 
	 /**
	 * @param target is the searched item
	 * @return null or target
	 * It returns null if there is no element that sends the searched element to the search method and creates the pred.
	 * returns the target  if any.
	 */
	public E find(E target) {
		 SLNode<E>[] pred = search(target);
		 for(int i=0;i<pred[0].links[0].getSize();i++) {
			 if (pred[0].links[0] != null &&  pred[0].links[0].data[i].compareTo(target) == 0) {
				 return pred[0].links[0].data[i];
			 }
		 }       
			 return null; 
			
	 }
	 
	 public String toString() {
		 SLNode<E> temp=head.links[0];
		 int counter=0;
		 while(temp!=null) {
			 counter++;
			 for(int i=0;i<temp.getSize();i++) {
				 System.out.println(temp.data[i]+"  in"+counter+"th Node"+" and the node has"+temp.getSize()+" elements");
			 }
			 temp=temp.links[0];
		 }
		 return "";
	 }

	 
	 /**
	 * @param item is the searched item
	 * @return true if the item is removed, false if it is not.
	 * Finds the node to be deleted with search.If the number of elements of the node is not minimum, it scrolls to the item to be deleted.
	 * If it is the minimum, it takes the smallest element of the next node  and adds the node that falls below the minimum
	 */
	public boolean remove(E item) {
			SLNode<E>[] pred = search(item);
			int flag=0;
			if(pred[0].links[0]==null) {
				
				if(pred[0].getSize()==1) {
					pred[0]=null;
				}else
				{
					for(int i=0;i<pred[0].getSize();i++) {
						if (item.compareTo(pred[0].data[i])==0) {
	                        flag=1;	
	                        for(int j=i;j<pred[0].getSize()-1;j++) {
	                        	pred[0].data[j]=pred[0].data[j+1];							
	                        }
	                        pred[0].decrementSize();
	                        
					}
					}	
				}

				return true;
			}
				
			if(pred[0].links[0]!=null) {
				for(int i=0;i<pred[0].links[0].links.length;i++) {
					if(item.compareTo(pred[i].links[i].data[0])==0) {
						pred[i]=pred[i].links[i];
					}
				}				
			}



			
			if(pred[0].equals(head)) {
					return false;		
			}
			else {
				for(int i=0;i<pred[0].getSize();i++) {
					if (item.compareTo(pred[0].data[i])==0) {
                        flag=1;	
                        for(int j=i;j<pred[0].getSize()-1;j++) {
                        	pred[0].data[j]=pred[0].data[j+1];
                        }
                        pred[0].decrementSize();
                        break;
					}
				}
				if(flag==0) {
					return false;
				}
				if(pred[0].getSize()<min)
				    remove(pred[0]);
			}
			
			
			return true;
			
	 }
	 /**
	 * @param node
	 * Run recursively for get elements from the next node.
	 * If the number of members of the node it receives is minimum, it works again.
	 */
	private void remove(SLNode node) {
		
	   if(node.links[0].links[0]==null) {
			SLNode<E> temp=node.links[0];
			for(int i=0;i<node.links.length;i++) {
					node.links[i]=node.links[i].links[i];
					size--;
				}
			for(int i=0;i<temp.getSize();i++) {
				add(temp.data[i]);
			}
		}
	   else {
		  for(int i=node.getSize();i<min;i++) {
			   node.add(node.links[0].data[i]);
			 for(int j=0;j<node.links[0].getSize()-1;j++) {   
				 node.links[0].data[j]=node.links[0].data[j+1];
			 }
			 node.links[0].decrementSize();
		   }
		   if(node.links[0].getSize()<min) {
			 remove(node.links[0]);
		    }
	     }

	 } 


}

	

