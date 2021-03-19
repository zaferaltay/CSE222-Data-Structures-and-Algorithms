import java.util.AbstractList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;




/**
 * @author zafer
 *The Class that creating linked list from arrays
 * @param <E>
 */
public class LinkedArrayList<E> extends AbstractList<E> implements List<E>{
    public Node<E> head;
    public Node<E> tail;
	public int size=0;
	public static final int MAX_ARRAY_CAPACITY=3;
	
	
	/**
	 * @author zafer
	 *
	 * The class that connecting and storing lists
	 * @param <E> type of elemnts
	 * 
	 */
	@SuppressWarnings("hiding")
	private static class Node<E> {
		private Node<E> next;
		private Node<E> prev;
		@SuppressWarnings("unchecked")
		private E []data=(E[])new Object[MAX_ARRAY_CAPACITY];
		private int nextelement=0;


		/**
		 * A one paramater constructor
		 * @param dataitem is added to data array
		 */
		private Node (E dataitem) {
			data[nextelement]=dataitem;
			nextelement++;
			next=null;
			prev=null;
		}
		
	}
	
	/**
	 * My listIterator class
	 * @author zafer
	 *
	 */
	public class Listiterator implements ListIterator<E>{
		private Node<E> nextItem;
		private Node<E> lastItem;
		private int nextItemCounter;
		private int lastItemCounter;
		
		
		/**
		 * Start at any position iterator constructor
		 * @param i is initial index of the iterator
		 */
		public Listiterator(int i) {
			if(i<0 || i>size) {
				throw new IndexOutOfBoundsException("Invalid index"+i);
			}
			if(i==size) {
				nextItem=tail;
				nextItemCounter=0;
			}
			else {
				nextItem=head;
	    		while(i>=nextItem.nextelement) {
	    			i-=nextItem.nextelement;
	    			nextItem=nextItem.next;
	    		}
	    		nextItemCounter=i;
			}
		}
		
		/**
		 * No parameter iterator constructor
		 */
		public Listiterator() {
			nextItem=head;
			nextItemCounter=0;	
		}

		
		/**
		 *Returns true if this list iterator has more elements when traversing the list in the forward direction. (In other words, returns true if next() would return an element rather than throwing an exception.)
		 */
		public boolean hasNext(){
			if(nextItem==null && nextItemCounter==0) {
				return false;
			}
				return true;	
		}

		/**
		 *Returns the next element in the list and advances the cursor position. This method may be called repeatedly to iterate through the list, or intermixed with calls to previous() to go back and forth. (Note that alternating calls to next and previous will return the same element repeatedly.)
		 */
		public E next() {
			if(!hasNext()){
				throw new NoSuchElementException();
			}
			lastItem=nextItem;
			lastItemCounter=nextItemCounter;
			nextItemCounter++;
			if(nextItemCounter==nextItem.nextelement) {
				nextItem=nextItem.next;
				nextItemCounter=0;
			}			

			return lastItem.data[lastItemCounter];
			
		}
		
		
		/**
		 *Returns true if this list iterator has more elements when traversing the list in the reverse direction. (In other words, returns true if previous() would return an element rather than throwing an exception.)
		 */
		public boolean hasPrevious(){
			if((size!=0 && nextItem==null) || nextItem.prev!=null) {
				return true;
			}
			return false;
		}
		/**
		 *Returns the previous element in the list and moves the cursor position backwards. This method may be called repeatedly to iterate through the list backwards, or intermixed with calls to next() to go back and forth. (Note that alternating calls to next and previous will return the same element repeatedly.)
		 */
		public E previous(){	
			if(!hasPrevious()) {
				throw new NoSuchElementException();
			}
			if(nextItem==null) {
				nextItem=tail;
				nextItemCounter=tail.nextelement-1;
			}
			else {
				if(nextItemCounter>0){
					nextItemCounter--;
				}
				else {
					nextItem=nextItem.prev;
					nextItemCounter=nextItem.nextelement-1;
				}
			}
			lastItem=nextItem;
			lastItemCounter=nextItemCounter;
			return lastItem.data[lastItemCounter];
			
			
		}
		/**
		 *Adds before next item. Depending on the state of the array it will add, it can open new node or delete node.
		 */
		public void add (E obj){
			if(head==null){
				Node<E> newNode=new Node<>(obj);
				head=newNode;
				tail=newNode;
				
			}
			else if(nextItem==null){
				Node<E> newNode=new Node<>(obj);
				newNode.prev=tail;
				tail.next=newNode;
				tail=newNode;
			
				
			}
			else if(nextItem==head){
				Node<E> newNode=new Node<>(obj);
				newNode.next=head;
				head.prev=newNode;
				head=newNode;
			
			}
		 	else {
		 		
		 		 if(nextItemCounter==0) {
		 			 Node<E> temp=nextItem.prev;
		 			 if(temp.nextelement<MAX_ARRAY_CAPACITY) {
		 				 temp.data[temp.nextelement]=obj;
		 				 temp.nextelement=temp.nextelement+1;
		 				 
		 			 }
		 			 else {
		 				 Node<E> newNode=new Node<>(obj);
						 newNode.next=nextItem;
						 newNode.prev=nextItem.prev;
						 nextItem.prev.next=newNode;
						 nextItem.prev=newNode;	
				
		 			 }
		 		 }
		 		
		 		 else if(nextItemCounter==MAX_ARRAY_CAPACITY-1) {
		 			 E temp=nextItem.data[nextItemCounter];
		 			 nextItem.data[nextItemCounter]=obj;
		 			 nextItemCounter=0;
	 				 Node<E> newNode=new Node<>(temp);
					 newNode.next=nextItem.next;
					 newNode.prev=nextItem;
					 nextItem.next.prev=newNode;
					 nextItem.next=newNode;	
					 nextItem=nextItem.next;
				
		 		 }
		 		 else{
		 			 if(nextItem.nextelement==MAX_ARRAY_CAPACITY) {
			 			 E temp=nextItem.data[nextItem.nextelement-1];
		 				 Node<E> newNode=new Node<>(temp);
						 newNode.next=nextItem.next;
						 newNode.prev=nextItem;
						 nextItem.next.prev=newNode;
						 nextItem.next=newNode;	
								 			 
			 			 for(int i=nextItem.nextelement-1;i>=nextItemCounter;i--){
			 				 nextItem.data[i]=nextItem.data[i-1];
			 			 }
			 			 nextItem.data[nextItemCounter]=obj;
			 			 nextItemCounter++;
			 			 
		 			 }
		 			 
		 			 else { 
		 				 		for(int i=nextItem.nextelement;i>nextItemCounter;i--){
		 				 				nextItem.data[i]=nextItem.data[i-1];
		 				 			}
		 				 			nextItem.data[nextItemCounter]=obj;
		 				 			nextItemCounter++;
		 				 			nextItem.nextelement=nextItem.nextelement+1;
		 			 		}
		 			 }
			}
			lastItem=null;
			lastItemCounter=MAX_ARRAY_CAPACITY;
			size++;
		}
		
		/**
		 *Returns the index of the element that would be returned by a subsequent call to next(). (Returns list size if the list iterator is at the end of the list.)
		 */
		public int nextIndex(){
			Node<E> temp=head;
			int i=0;
			if(nextItem==null && size!=0) {
				return size;
			}
			while(temp!=nextItem) {
				i+=temp.nextelement;
				temp=temp.next;
			}
			i+=nextItemCounter;
			return i;
		}
		/**
		 *Returns the index of the element that would be returned by a subsequent call to previous(). (Returns -1 if the list iterator is at the beginning of the list.)
		 */
		public int previousIndex() {
			Node<E> temp=head;
			int i=0;
			if(nextItem==head && nextItemCounter==0) {
				return -1;
			}
			while(temp!=nextItem) {
				i+=temp.nextelement;
				temp=temp.next;
			}
			i+=nextItemCounter-1;
			return i;
		}
		/**
		 *If the last operation is next or previous, it will delete and return the last item.This method can shift element or delete node depending on the situation
		 */
		public void remove(){
			if(lastItem==null) {
				throw new IllegalArgumentException();
			}
			else if(nextItem==null){
				if(lastItemCounter==0) {
					tail=lastItem.prev;
					tail.next=null;
				}
				nextItem.prev.nextelement--;
			}
			else if(lastItem==head && head.nextelement==1){
				head=head.next;
				head.prev=null;
				lastItem.next=null;
				nextItem=head;
			}
			else {
				if(lastItemCounter==0 && lastItem.nextelement==1) {
				  lastItem.prev.next=nextItem;
				  lastItem.next.prev=lastItem.prev;
			    }
				else{
					for(int i=lastItemCounter;i<lastItem.nextelement-1;i++) {
						lastItem.data[i]=lastItem.data[i+1];
					}
					lastItem.nextelement=lastItem.nextelement-1;
					nextItemCounter--;
				}
			}
			lastItem=null;
			lastItemCounter=MAX_ARRAY_CAPACITY;
			size--;
		  
		}
		
		/**
		 *If the last operation is next or previous, it will set the data of last item
		 */
		public void set(E obj){
			if(lastItem==null) {
				throw new IllegalStateException();
			}
			lastItem.data[lastItemCounter]=obj;      
		}


	}
	
	
	/**
	 * The method creates iterator
	 * @param x is initial pozition of iterator
	 * @return iterator
	 */
	public Listiterator listiterator(int x){
		int i=0;
		Listiterator iter = listiterator();
		while(i<x) {
			i++;
			iter.next();
		}
		return iter;	
	}
	/**
	 * The method creates iterator that points head
	 * @return iterator
	 */
	public Listiterator listiterator() {
		Listiterator iter=new Listiterator();
		return iter;
	}
	/**
	 * The method adds the obj head of the list
	 * @param obj is added the head
	 */
	public void AddFirst(E obj) {
		Node<E> newNode=new Node<>(obj);
		newNode.next=head;
		head.prev=newNode;
		head=newNode;
		size++;
	}
	/**
	 *The method adds the obj last of the list
	 */
	public boolean add(E obj) {	
		if(head==null) {
			head=new Node<>(obj);
			tail=head;
		}
		else {
			Node<E> temp=tail;
			if(temp.nextelement==MAX_ARRAY_CAPACITY) {
				temp.next=new Node<>(obj);
				temp.next.prev=temp;
				tail=temp.next;
			}
			else {
				temp.data[temp.nextelement]=obj;
				temp.nextelement=temp.nextelement+1;
			}
		}
		size++;
		return true;
	}

    /**
     *Adds the object to the specified index. If index smaller tha 0 or bigger than size,method throws exception.
     *It can add node, slide element or launch excepiton according to the situations.
     *
     */
    @Override
    public void add(int index,E obj) {					
    	if(index<0 || index>size )
    		throw new IndexOutOfBoundsException(Integer.toString(index));
    	if(index==0) {
    		AddFirst(obj);
    	}
    	else if(index==size) {
    		add(obj);
    	}
    	else {
    		Node<E> temp=head;
 
         		while(index>temp.nextelement || index>=MAX_ARRAY_CAPACITY) {
    	     		index-=temp.nextelement;
    		    	temp=temp.next;
    		       }
         		
    		if(temp.nextelement<MAX_ARRAY_CAPACITY){
	 			 for(int i=temp.nextelement;i>index;i--){
	 				 temp.data[i]=temp.data[i-1];
	 			 }
	 			 temp.data[index]=obj;
	 			 temp.nextelement=temp.nextelement+1;
    		}
    		else if(temp.nextelement==MAX_ARRAY_CAPACITY) {
    			
	 			 E tempp=temp.data[temp.nextelement-1];
				 Node<E> newNode=new Node<>(tempp);
				 newNode.next=temp.next;
				 newNode.prev=temp;
				 temp.next.prev=newNode;
				 temp.next=newNode;	
						 			 
	 			 for(int i=temp.nextelement-1;i>index;i--){
	 				 temp.data[i]=temp.data[i-1];
	 			 }
	 			 temp.data[index]=obj;
	 			
	 			 
    		}
    		size++;
    	}
    	
    }
    
   // @Override
    /**
     *Changes the item at the specified index and returns the old value
     */
    public E set(int index,E obj) {
		Node<E> temp=head;
		E a;
		
		while(index>=temp.nextelement) {
			index-=temp.nextelement;
			temp=temp.next;
		}
		  a=temp.data[index];
		  temp.data[index]=obj;
		return a;
    }
    
    /**
     *Remove the item at specified position and return it.
     *It can shift the remaining elements or delete the node according to the situations.
     */
    @Override
    public E remove(int index) {
    	
		Node<E> temp=head;
		E a;
		while(index>temp.nextelement) {
			index-=temp.nextelement;
			temp=temp.next;
		}
		a=temp.data[index];
		 if(temp.nextelement==1) {
			 temp.next.prev=temp.prev;
			 temp.prev.next=temp.next;
		 }
		 else {
				for(int i=index;i<temp.nextelement-1;i++) {
					temp.data[i]=temp.data[i+1];
				}
				temp.nextelement=temp.nextelement-1;
		 }
		
		size--;
		return a;
    }
    
	
	/**
	 * Return the element at specified position
	 */
	public E get(int index) {
		int x=0;
		Listiterator li=listiterator();
		if(index<0 || index>size) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		
		while(x<index) {
			li.next();
			x++;
		}
		return li.next();

	}

	/**
	 *Return the size of list
	 */
	@Override	
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	/**
	 *Removes the same element as obj when it first occur
	 */
	@SuppressWarnings("unchecked")
	public boolean remove(Object o) {
		Listiterator iter=listiterator();
		while(iter.hasNext()) {
			if(iter.next()==(E)o){
				iter.remove();
				return true;
			}
		}
		
		return false;
	}

	/**
	 *Returns the index of obj
	 */
	@SuppressWarnings("unchecked")
	public int indexOf(Object o) {
		int total=0;
		Listiterator iter=listiterator();
		while(iter.hasNext()) {
			if(iter.next()==(E)o){
				return total;
			}
			total++;
		}
		
		return -1;
	}

	/**
	 *Returns true if the object exists in the list
	 */
	@SuppressWarnings("unchecked")
	public boolean contains(Object o) {
		Listiterator iter=listiterator();
		while(iter.hasNext()) {
			if(iter.next()==(E)o){
				return true;
			}
		}
		
		return false;
	}

	@SuppressWarnings("unchecked")
	public int lastIndexOf(Object o) {
		Listiterator iter=listiterator();
		int last = 0;
		int x=0;
		while(iter.hasNext()) {
			if(iter.next()==(E)o){
				last=x;
			}
			x++;
		}
		if(last>0)return last; return -1;
	}
	
	/**
	 *Returns true if list is empty
	 */
	public boolean isEmpty()
	{
		if (head==null) return true;return false;
	}
	/**
	 * The methods filled the arrays for PFA
	 * @param first is element of first node first index 
	 * @param second is element of first node second index 
	 * @param third is element of second node first index 
	 * @param fourth is element of third node first index 
	 * @param fifth is element of first node second index 
	 */
	public void filledPartially(E first,E second,E third,E fourth,E fifth) {
		head =new Node<>(first);
		tail=head;
		add(second);
		size++;
		head.next=new Node<>(third);
		head.next.prev=head;
		size++;
		head.next.next=new Node<>(fourth);
		head.next.next.prev=head.next;
		tail=head.next.next;
		add(fifth);
		size++;
	}
	/**
	 *toStirng method of LAL
	 */
	public String toString(){
		Listiterator it=new Listiterator();
		for(int i=0;i<size;i++) {
			System.out.printf("%d ",it.next());
		}
		return String.format("%s",'.');
		
	}
	
}
