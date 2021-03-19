

public class KWHashMapOpenAdressing<K,V> {
	private static class Entry<K, V> {
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
		 		 
	}
	
	
	 private Entry<K, V>[] table;
	 private static final int START_CAPACITY = 101;

	 private double LOAD_THRESHOLD = 0.75;
	 private int numKeys;
	 private int numDeletes;
	 private final Entry<K, V> DELETED = new Entry<>(null, null);
	 
	 public KWHashMapOpenAdressing() { 
	    table = new Entry[START_CAPACITY];     
	    }

	 /**
	  *  Finds either the target key or the first empty slot in the    search chain using linear probing
	 * @param key The key of the target object
	 * @return The position of the target or the first empty slot if            the target is not in the table. 
	 */
	private int find(Object key) {    // Calculate the starting index.
		 int i=0;
		 int hash2=11-11%key.hashCode();
		 int index = key.hashCode() % table.length+i*hash2;    
		 if (index < 0)        
			 index += table.length;
	    while ((table[index] != null)&& (!key.equals(table[index].getKey()))) {
	    		i++;
		    index=index+i*hash2;             
		   if (index >= table.length)            
			    index %=table.length;    // Wrap around.    
		      }   
	      return index; 
		 }
	 
	 
	 /**
	  *   @param key The key being sought   
	  *   @return the value associated with this key if found; otherwise, null 
	 * 
	 * 
	 */
	public V get(Object key) { 
		 int index = find(key);
		 if (table[index] != null)
			 return table[index].getValue();
		 else
			 return null;
	 }
	 
	 /**
	 *  This keyvalue pair is inserted in the table and numKeys is incremented. If the key is already in the table, its value is changed to the argument          
	 *  value and numKeys is not changed. If the LOAD_THRESHOLD          
	 *  is exceeded, the table is expanded. 
	 * @param key  The key of item being inserted 
	 * @param value The value for this key
	 * @return  Old value associated with this key if found;otherwise, null 
	 */
	public V put(K key, V value)  { 
		 int index = find(key);
		  if (table[index] == null) {
			  table[index] = new Entry<>(key, value);
			  numKeys++;
			  double loadFactor = (double) (numKeys + numDeletes) / table.length;
			  if (loadFactor > LOAD_THRESHOLD)
				  rehash();
			  return null; 
		  }
		  V oldVal = table[index].getValue();    
		  table[index].setValue(value);
		  return oldVal; 
	 }
	
	 /**
	  *  The size of the table is doubled and is an odd integer. 
	 *  Each nondeleted entry from the original table is reinserted into the expanded table
	 *   The value of numKeys is reset to the number of items actually inserted; numDeletes is reset to 0. 
	 */
	private void rehash() {    
		 Entry<K, V>[] oldTable = table;    
		 table = new Entry[2 * oldTable.length + 1];
		 numKeys = 0;    
		 numDeletes = 0;
		 for (int i = 0; i < oldTable.length; i++) {
			 if ((oldTable[i] != null) && (oldTable[i] != DELETED)) {
				 
				 put(oldTable[i].getKey(), oldTable[i].getValue());
				 }
			 } 
			 }
		
	 /**
	  * Removes key matching item.Returns the value of an item that it has removed, or null if it is not
	 * @param key The key of the item to be removed
	 * @return 
	 */
	public V remove(Object key) {
		int index=find(key);
		if(table[index]==null)
			return null;
		
		V oldVal=table[index].getValue();
		table[index]=DELETED;
		numKeys++;
		numDeletes--;
		return oldVal;
		
		
	 }
	 
	 
	 
		 }



	 

