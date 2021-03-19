import java.util.AbstractCollection;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class MyDeque<E> extends AbstractCollection<E> implements Deque<E> {

	/**
	 * @author zafer
	 *	Node class
	 * @param <E> is gneric type
	 */
	private static class Node<E>{
		E data;
		Node<E> next;
		Node<E> prev;
		
		Node(E item){
			data=item;
			next=null;
			prev=null;
		}
		Node(E item,Node<E> ref){
			data=item;
			next=ref;
		}
	}
	
	
	/**
	 * @author zafer
	 *Iterator class
	 */
	public class MyIterator implements Iterator<E>{
		Node<E> nextItem;
		boolean descending;
		
		/**
		 *Returns true if this iterator has more elements
		 */
		@Override
		public boolean hasNext() {  
			if(nextItem !=null) return true;		
		 	return false; 	  
		}
		/**
		 *Returns the next element in the list and advances the cursor position
		 */
		@Override
		public E next() {
			if(hasNext()) {
				  E temp=nextItem.data;
				  if(!descending) nextItem=nextItem.next;				
				  else nextItem=nextItem.prev;
				  return temp;
			}
			return null;

		}
		/**
		 * Specifies the type of the iterator.
		 * @param desc  is true if it is not descending is normal
		 */
		MyIterator(boolean desc){
			descending=desc;
			if(!descending) {
				nextItem=front;
			}
			else {
				nextItem=rear;
			}
		}
		
	}
	 private Node<E> front;
	 private Node<E> rear;
	 private Node<E> removedHead;
	 private Node<E> removedTail;	 
	 private int size=0;
	
	/**
	 *Inserts item at the front of deque.Throws an exception if the item could not be inserted.
	 */
	@Override
	public void addFirst(E arg0) {
	 try {
		 if(size==0) {                             //size 0 ken de olabilir removed
			front=new Node<>(arg0);
			rear=front;
		}
		else {
			Node<E> temp=removedHead;
			while(temp!=null) {
				if(temp.data==arg0) {
					front.prev=temp;
					if(temp.prev!=null) {
					      temp.prev.next=temp.next;
					if(temp.next!=null)
						temp.next.prev=temp.prev;
					}
					else {
						removedHead=removedHead.next;
					}
					
					temp.next=front;
					temp.prev=null;
					front=front.prev;
					break;
				}
				temp=temp.next;
			}
			if(temp==null)
			 front=new Node<>(arg0,front);
			 front.next.prev=front;
		}
		size++;
	 }catch(Exception e) {
		 System.out.println("It is not inserted");
	 }
	}

	/**
	 *Inserts item at the rear of deque.Throws an exception if the item could not be inserted.
	 */
	

	@Override
	public void addLast(E arg0) {
	 try {
		 if(size==0) {

			front=new Node<>(arg0);
			rear=front;
		}
		else {
			Node<E> temp=removedHead;
			while(temp!=null) {
				if(temp.data==arg0) {
					rear.next=temp;
					if(temp.next!=null) {
						temp.next.prev=temp.prev;
					}
					if(temp.prev!=null) {
						temp.prev.next=temp.next;
					}
					else {
						removedHead=removedHead.next;
					}
					temp.prev=rear;
					rear=rear.next;
					rear.next=null;
					break;
				}
				temp=temp.next;
			}
			if(temp==null) {
				rear.next=new Node<>(arg0);
				rear.next.prev=rear;
				rear=rear.next;			
			}
		}
		size++;
	}catch(Exception e){
		System.out.println("It is not inserted");
	   }
	}

	/**
	 * Returns a n iterator to the elements of this deque in reverse sequential order
	 */
	@Override
	public Iterator<E> descendingIterator() {
		Iterator<E> iter=new MyIterator(true);
		return iter;
	}

	/**
	 *Returns the entry at the front of the deque without removing it.If deque is empty throw NoSuchElementException
	 */
	
	@Override
	public E element() {
		E temp=peek();
		if(temp==null) throw new NoSuchElementException();
		return temp;
	}

	/**
	 *Returns the entry at the front of the deque without removing it.If deque is empty throw NoSuchElementException
	 */
	
	@Override
	public E getFirst() {
		return element();
	}

	/**
	 *Returns the entry at the rear of the deque without removing it.If deque is empty throw NoSuchElementException
	 */
	
	@Override
	public E getLast() {
		E temp=peekLast();
		if(temp==null) throw new NoSuchElementException();
		return temp;
	}

	
	/**
	 *Inserts item at the front of the deque.Returns true if successful,returns false if the item could not be inserted
	 */
	@Override
	public boolean offer(E arg0) {
		try {
			addLast(arg0);
		}catch(Exception e) {
			return false;
		}
		return true;
	}

	/**
	 *Inserts item at the front of the deque.Returns true if successful,returns false if the item could not be inserted
	 */
	@Override
	public boolean offerFirst(E arg0) {
		
		try {
			addFirst(arg0);
		}catch(Exception e) {
			return false;
		}
		return true;
	}

	/**
	 *Inserts item at the rear of the deque.Returns true if successful,returns false if the item could not be inserted
	 */
	@Override
	public boolean offerLast(E arg0) {
	  return offer(arg0);
	}

	/**
	 *Returns the item at the front of deque without removing it,returns null if deque is empty
	 */
	@Override
	public E peek() {
		if(front==null) return null;
		return front.data;
	}

	/**
	 *Returns the item at the front of deque without removing it,returns null if deque is empty
	 */
	@Override
	public E peekFirst() {
		return peek();
	}

	/**
	 *Returns the item at the rear of deque without removing it,returns null if deque is empty
	 */
	@Override
	public E peekLast() {
		if(front==null) return null;
		return rear.data;
	}

	

	/**
	 *Removes the entry at the front of deque and returns it,returns null if deque is empty 
	 */
	@Override
	public E poll() {
		if(front==null)return null;
		if(removedHead==null) {
			removedHead=front;
			removedTail=front;
		}
		else {
			removedTail.next=front;
			front.prev=removedTail;
			removedTail=removedTail.next;
		}
		E temp=front.data;
		front.next.prev=null;
		front=front.next;
		removedTail.next=null;
		size--;
		
		return temp;
	}

	/**
	 *Removes the entry at the front of deque and returns it,returns null if deque is empty
	 */
	@Override
	public E pollFirst() {
		return poll();
	}

	/**
	 *Removes the entry at the rear of deque and returns it,returns null if deque is empty
	 */
	@Override
	public E pollLast() {
		if(front==null)return null;
		E temp=rear.data;
		if(removedHead==null) {
			removedHead=rear;
			removedTail=rear;
			rear=rear.prev;
			rear.next=null;
			removedTail.prev=null;
		}
		else {
			removedTail.next=rear;
			if(rear.prev!=null)
				rear=rear.prev;
			else {
				front=rear=null;
			}
			removedTail.next.prev=removedTail;
			removedTail=removedTail.next;
		}
		rear.next=null;
		removedTail.next=null;
		size--;
		return temp;
	}

	/**
	 *Removes the entry at the front of deque and returns it,returns null if deque is empty
	 */
	@Override
	public E pop() {
		return poll();
		
	}

	/**
	 *Inserts item at the rear of the deque.
	 */
	@Override
	public void push(E arg0) {
		offerLast(arg0);
		
	}

	/**
	 *Removes the entry at the front of the deque and returns it if the deque is not empty.If deque is empty,throws a NoSuchElementException
	 */
	@Override
	public E remove() {
		E temp=poll();
		if(temp==null) throw new NoSuchElementException();	
		return temp;
	}

	/**
	 *Removes the entry at the front of the deque and returns it if the deque is not empty.If deque is empty,throws a NoSuchElementException
	 */
	@Override
	public E removeFirst() {
		// TODO Auto-generated method stub
		return remove();
	}

	/**
	 *Removes the first occurance of item in the deque.Returns true if the item was removed.
	 */
	@Override
	public boolean removeFirstOccurrence(Object arg0) {
		
		Node<E> temp=front;
		while(temp!=null) {
			if((E)arg0==temp.data) {
				if(temp.next!=null)
				   temp.next.prev=temp.prev;
				if(temp.prev!=null)
				   temp.prev.next=temp.next;
				removedTail.next=temp;
				temp.prev=removedTail;
				temp.next=null;
				removedTail=removedTail.next;
				size--;
				return true;
			}
			temp=temp.next;
		}
		
		return false;
	}

	/**
	 *Removes the entry at the rear of the deque and returns it if the deque is not empty.If deque is empty,throws a NoSuchElementException
	 */
	@Override
	public E removeLast() {
		E temp=pollLast();
		if(temp==null) throw new NoSuchElementException();	
		return temp;
		
	}

	/**
	 *Removes the last occurance of item in the deque.Returns true if the item was removed.
	 */
	@Override
	public boolean removeLastOccurrence(Object arg0) {
		Node<E> temp=rear;
		while(temp!=null) {
			if((E)arg0==temp.data) {
				if(temp.next!=null)
				  temp.next.prev=temp.prev;
				if(temp.prev!=null)
				 temp.prev.next=temp.next;
				removedTail.next=temp;
				temp.prev=removedTail;
				temp.next=null;
				removedTail=removedTail.next;
				size--;
				return true;
			}
			temp=temp.prev;
		}
		
		return false;
	}

	/**
	 * Returns a n iterator to the elements of this deque in proper sequence
	 */
	@Override
	public Iterator<E> iterator() {
		Iterator<E> iter=new MyIterator(false);
		return iter;
	}

	/**
	 *It returns size
	 */
	@Override
	public int size() {
		return size;
	}

}
