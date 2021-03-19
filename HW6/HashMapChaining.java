
public class HashMapChaining<K extends Comparable<K>,V extends Comparable<V>> implements KWHashMap<K,V> {
	
	private static class Entry<K extends Comparable<K>, V extends Comparable<V>> implements Comparable<Entry<K , V>> {
		 private final K key;
		 private V value;


		 public Entry(K key, V value) {
			 this.key = key;
			 this.value = value;
			 }
		 public K getKey(){
			 return key;
			 }
		 public V getValue(){
			 return value;
			 }
		 public V setValue(V val) {
			 V oldVal = value;
			 value = val;
			 return oldVal;
			 }

		/**
		 *compares key values
		 */
		@Override
		public int compareTo(Entry<K, V> o) {
			return key.compareTo(o.getKey());
		}
		 
		 
	}

	 private BinarySearchTree<Entry<K,V>>[] table;
	 private static int START_CAPACITY = 101;
	 private double LOAD_THRESHOLD = 3.00;
	 private int numKeys;
	
	 
	 
	 
	 
	/**
	 * Creates bst array.
	 */
	public HashMapChaining() {
	    	table = (BinarySearchTree<Entry<K,V>> []) new BinarySearchTree[START_CAPACITY];    
	    	}

	
	
	/**
	 *Finds the index of the key. Creates an entry object with the same key. Searches for objects in the tree that have matching keys.
	 */
	@Override
	public V get(Object key) {
	    int index = key.hashCode() % table.length;
	    if (index < 0)
	    	index += table.length;
	    if (table[index] == null)
	    	return null; 
	    else {
	    	Entry<K,V> temp=table[index].find(new Entry((K)key,""));
	    	if(temp!=null)
	    	return temp.getValue();
	    }
	    return null;

	}


	/**
	 *all indexes is null, it returns true.Otherwise it return false
	 */
	@Override
	public boolean isEmpty() {
		for(int i=0;i<table.length;i++) {
			if(table[i]!=null) {
				return false;
			}
		}
		return true;
	}


	
	/**
	 *Creates an item of the entry type.If the index to be loaded is empty, it creates a new tree. If not, it adds to the existing tree.
	 */
	@Override
	public V put(K key, V value) {
		Entry<K,V> tempp;
	    int index = key.hashCode() % table.length;
	    if (index < 0)
	    	index += table.length;
	    
	    if (table[index] == null) {
	    	Entry<K,V> tempEntry=new Entry<>(key,value);
	    	BinarySearchTree<Entry<K,V>> bttemp=new BinarySearchTree<>();	    	
	    	table[index]=bttemp;
	    	table[index].add(tempEntry);
	    	numKeys++;
	    }
	    else {
	    	Entry<K,V> tempEntry=new Entry<>(key,value);
	    	tempp=table[index].add(tempEntry);
	    	numKeys++;
	    	if(tempp!=null)
	    	  return tempp.getValue();
	    	
	    }
	    	
	    if (numKeys > (LOAD_THRESHOLD * table.length)) {
	    	rehash();
	    }	
		return null;
	}
	/**
	 * Creates a new hash that is twice the size of the previous hash.
	 * Copies old data to new.
	 */
	private void rehash() {
		BinarySearchTree<Entry<K,V>>[] oldtable=table;
		START_CAPACITY=START_CAPACITY*2+1;
		table = (BinarySearchTree<Entry<K,V>> []) new BinarySearchTree[START_CAPACITY];
		for(int i=0;i<oldtable.length;i++) {
			table[i]=oldtable[i];
		}
	}

	/**
	 *Finds the entered key value. And removes it from the hash.
	 */
	@Override
	public V remove(Object key) {
	    int index = key.hashCode() % table.length;
	    if (index < 0)
	    	index += table.length;
	    if (table[index] == null)
	    	return null; 
	    else{
	    	Entry<K,V> temp=table[index].delete(new Entry((K)key,""));
	    	numKeys--;
	    	if(table[index].root==null) {
	    		table[index]=null;
	    	}
	    	if(temp!=null) {
		    	return temp.getValue();
	    	} 	    	
	    }	
		return null;
	}

	/**
	 *Returns size
	 */
	@Override
	public int size() {
		return numKeys;
		
	}
	
	
}
