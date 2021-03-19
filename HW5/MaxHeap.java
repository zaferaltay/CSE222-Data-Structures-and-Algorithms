import java.util.ArrayList;

/**
 * @author zafer
 *Our special maximum heap class key number of ages
 * @param <E>
 */
public class MaxHeap<E extends Comparable<E>>{

	private ArrayList<E> theData=new ArrayList<>();
	private MyComparator<E> comparator=new MyComparator<>();
	private int indexof;
	
	/**
	 * Checks if the item you want to add already exists.Increases the ageNum, if any.It then carries it up if necessary by comparing it with the parent.
	 * If the item is not in the list , it adds to the end
	 * @param item
	 */
	public void add(E item) {
		int child;
		int parent;
		if(find(item)!=null) {
			if(item instanceof AgeData) {
				((AgeData) find(item)).increaseAgeNum();
				child=indexof;
				parent=(child-1)/2;
				
			}else return;
		}else {
			theData.add(item);
			child=theData.size()-1;
		    parent=(child-1)/2;
		}
		
		while(parent>=0) {
			if(compare(theData.get(parent),theData.get(child))<0 ){
				swap(parent,child);
				child=parent;
				parent=(child-1)/2;
			}
			else {
				break;
			}
		}
	}
	/**
	 * Replaces elements in two indexes it takes
	 * @param parent is index of parent
	 * @param child is index of child
	 */
	private void swap(int parent,int child) {
		E temp=theData.get(parent);
		theData.set(parent, theData.get(child));
		theData.set(child, temp);
	}
	/**
	 * It compares the parameter it receives with the age of all elements.Returns the correct element, if any.If element is not listed, null returns
	 * @param item is want to be find
	 * @return wanted element
	 */
	public E find(E item) {
		if(item instanceof AgeData){
			for(int i=0;i<theData.size();i++) {
				if(((AgeData)item).getAge()==((AgeData)theData.get(i)).getAge()) {
					indexof=i;
					return theData.get(i);
				}
			}
			indexof=-1;
		}else {
			indexof=theData.indexOf(item);
		}
		if(indexof==-1) {
			return null;
		}
		return theData.get(indexof);
	}
	
	/**
	 * It compares the age of the elements in the list with the parameter it takes.Adds To total, ageNum of element  if parameter is greater
	 * @param item is compared age
	 * @return total younger than
	 */
	public int youngerThan(int item) {
		int total=0;
		for(int i=0;i<theData.size();i++) {
			if(item > ((AgeData)theData.get(i)).getAge()) {
				total+=((AgeData)theData.get(i)).getAgeNum();
			}
		}
		
		return total;
	}
	/**It compares the age of the elements in the list with the parameter it takes.Adds To total, ageNum of element  if parameter is less
	 * @param item is compared age
	 * @return total older than
	 */
	public int olderThan(int item) {
		int total=0;
		for(int i=0;i<theData.size();i++) {
			if(item < ((AgeData)theData.get(i)).getAge()) {
				total+=((AgeData)theData.get(i)).getAgeNum();
			}
		}
		
		return total;		
	}
	
	/**
	 * If the ageNUM of the item to be deleted is 1, it deletes the element and rearranges the list.
	 * If it is greater than 1, it decreases its number by one and rearranges the list.
	 * @param item
	 * @return
	 */
	public E remove(E item) {
		int parent;
		int maxChild,leftChild,rightChild;
		if(find(item)!=null){
			E temp=theData.get(indexof);
			if(((AgeData)temp).getAgeNum()>1) {
				((AgeData)theData.get(indexof)).decreaseAgeNum();
				
			}else {
				if(theData.size()==1) {
					theData.remove(0);
					return temp;
				}
				if(indexof!=theData.size()-1)
				 theData.set(indexof,theData.remove(theData.size()-1));
				else
					theData.remove(theData.size()-1);
			}
				parent=indexof;
				while(true) {
				  leftChild=(parent*2)+1;
				  if(leftChild>=theData.size()){
					  break;
				  }
				  rightChild=leftChild+1;
				  maxChild=leftChild;
				  if(rightChild<theData.size() &&compare(theData.get(rightChild),theData.get(leftChild))>0) {
					  maxChild=rightChild;
				  }
				  
				  if(compare(theData.get(parent),theData.get(maxChild))<0) {
					
					  swap(parent,maxChild);
					  parent=maxChild;
					  
				  }else {
					  break;
				  }
				}
				return temp;	
			}
		
		
		return null;
	}
	
	/**
	 * Uses the comparator class's compare method
	 * @param x1
	 * @param x2
	 * @return
	 */
	public int compare(E x1,E x2) {
		return comparator.compare(x1, x2);
	}
	
	/**
	 *Calls the auxiliary class to print the list on the screen
	 */
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		toString(sb);
		return sb.toString();
	}
	/**
	 * Scans the entire list and adds it to the string
	 * @param sb
	 */
	private void toString(StringBuilder sb) {
		for(int i=0;i<theData.size();i++) {
			sb.append(theData.get(i).toString());
			sb.append("\n");

		}
	}
	
}
