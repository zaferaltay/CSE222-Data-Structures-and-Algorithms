import java.util.Iterator;
import java.util.LinkedList;

public class Sorting {

     //-------------------------SELECTION SORT---------------------------------------	

	public static void selectionSort(Comparable[] table) {
		int n=table.length;
		for(int fill=0;fill<table.length-1;fill++) {
			int posMin=fill;
			for(int i=fill+1;i<table.length;i++) {
				if(table[posMin].compareTo(table[i])>0) {
					posMin=i;
				}
			}
			Comparable x=table[fill];
			table[fill]=table[posMin];
			table[posMin]=table[fill];		
		}
	}
     //-----------------------------BUBBLE SORT-------------------------------------
	 public static<T extends Comparable<T>> void bubbleSort(T[] table){
		int pass=1;
		boolean exchanges=false;
		do {
			exchanges=false;
			for(int i=0;i<table.length-pass;i++) {
				if(table[i].compareTo(table[i+1])>0) {
					T temp=table[i+1];
					table[i+1]=table[i];
					table[i]=temp;
					exchanges=true;
				}
			}
			pass++;
		}while(exchanges);
		
	}
	
	 //---------------------------------------INSERTION SORT--------------------------------------------------
	 public static <T extends Comparable<T>> void insetionSort(T[] table) {  
		  for (int nextPos = 1; nextPos < table.length; nextPos++) {            
			  // Invariant: table[0 . . . nextPos - 1] is sorted.           
			  // Insert element at position nextPos            
			  // in the sorted subarray.            
			  insert(table, nextPos);
			  }
		  }
	  
	 private static <T extends Comparable<T>> void insert(T[] table,int nextPos) {
		 T nextVal = table[nextPos];		// Element to insert.
	        while (nextPos > 0 && nextVal.compareTo(table[nextPos-1]) < 0) {            
		        table[nextPos] = table[nextPos-1];             // Shift down.            
		         nextPos--;           		 // Check next smaller element.        
		     }        							// Insert nextVal at nextPos.
	        table[nextPos] = nextVal;   
	       } 
	 
	 
	 //-------------------------------SHELL SORT-------------------------------------------------------------------
	 public static <T extends Comparable<T>> void shellSort(T[] table) {        // Gap between adjacent elements.
		 int gap = table.length / 2;
		 while (gap > 0) {
			 for (int nextPos = gap; nextPos < table.length; nextPos++) {                // Insert element at nextPos in its subarray.
				 insert(table, nextPos, gap);           
				 }  // End for.
			 		// Reset gap for next pass.
			if (gap == 2) {
					gap = 1;
				} else {
					gap = (int) (gap / 2.2);
		}
		} // End while.   
	} // End sort
	
	 private static <T extends Comparable<T>> void insert(T[] table,int nextPos, int gap) {
		 T nextVal = table[nextPos];
		 while ((nextPos > gap - 1) && (nextVal.compareTo(table [nextPos - gap]) < 0)) { 	 
			 table[nextPos] = table[nextPos-gap];    
			 nextPos -= gap;
		 }
	        table[nextPos] = nextVal; 
	 }
	
	 //----------------------------MERGE SORT---------------------------------------------------------------
	 
	 public static <T extends Comparable<T>> void mergeSort(T[] table) {
		 if (table.length > 1) {      
			 int halfSize = table.length / 2; 
	            T[] leftTable = (T[]) new Comparable[halfSize];
	            T[] rightTable = (T[]) new Comparable[table.length - halfSize];
	            System.arraycopy(table, 0, leftTable, 0, halfSize);
	            System.arraycopy(table, halfSize, rightTable, 0,table.length - halfSize);
	             mergeSort(leftTable);            
	             mergeSort(rightTable);
	             merge(table, leftTable, rightTable);
		 }
		 
	 }
	 private static <T extends Comparable<T>> void merge(T[] outputSequence, T[] leftSequence,T[] rightSequence) { 
		 int i = 0;   int j = 0;  int k = 0; 
		 while (i < leftSequence.length && j < rightSequence.length) { 
			 if (leftSequence[i].compareTo(rightSequence[j]) < 0) { 
				 outputSequence[k++] = leftSequence[i++];
			 }else {
				  outputSequence[k++] = rightSequence[j++];
			 }
		 }
		 
		 while (i < leftSequence.length) { 
			 outputSequence[k++] = leftSequence[i++]; 
		 }
		 while (j < rightSequence.length) {        
		    	outputSequence[k++] = rightSequence[j++];    
		 }
		 
	 }

	 //----------------------------HEAP SORT----------------------------------------------
	 public static <T extends Comparable<T>> void heapSort(T[] table) {        
		 buildHeap(table);        
		 shrinkHeap(table);    
		 }
	 
	 private static <T extends Comparable<T>> void buildHeap(T[] table) { 
		 int n = 1; 
		 while (n < table.length) {
			 n++; 
			 int child = n-1;            
			 int parent = (child-1) / 2; 
			 while (parent >= 0 && table[parent].compareTo(table[child]) < 0) {
				 swap(table, parent, child);                
				 child = parent;                
				 parent = (child - 1) / 2; 
			 }
		 }
	 }
	 
	 private static <T extends Comparable<T>> void shrinkHeap(T[] table) { 
		 int n = table.length;
		
		 while (n > 0) {
	          n--;            
	          swap(table, 0, n);
	          int parent = 0; 
	          while (true) {
	        	int  leftChild = 2 * parent + 1;
	        	  if (leftChild >= n) {
	        		  break;       // No more children. 
	        		  }                
	          
	          int rightChild = leftChild + 1;                // Find the larger of the two children.                
	          int maxChild = leftChild;
	          if (rightChild < n && table[leftChild].compareTo(table[rightChild]) < 0) {
	        	  maxChild = rightChild; 
	          }
	          if (table[parent].compareTo(table[maxChild]) < 0) {                    // Swap the parent and child.                    
	        	  swap(table, parent, maxChild);                    // Continue at the child level.                    
	        	  parent = maxChild;                
	        	  } else {   // Heap property is restored.                    
	        		  break; // Exit the loop.                
	        		  }
	          }
		 } 
		 }
	 
	 private static <T extends Comparable<T>> void swap(T[] table, int i, int j) {
	    	T temp = table[i];        
	    	table[i] = table[j];        
	    	table[j] = temp;    
	    	}

     //------------------------------QUICK SORT----------------------------------------------
	 public static <T extends Comparable<T>> void quickSort(T[] table) {         
		 quickSort(table, 0, table.length - 1);   
	 }
	 private static <T extends Comparable<T>> void quickSort(T[] table,int first, int last) {
		 if (first < last) {  // There is data to be sorted.            
		 // Partition the table.            
		 int pivIndex = partition(table, first, last);            // Sort the left half.           
		 quickSort(table, first, pivIndex - 1);            // Sort the right half.            
		 quickSort(table, pivIndex + 1, last);       
		 }    
	 }
	 private static <T extends Comparable<T>> int partition(T[] table,int first, int last) {
		 sort3(table, first, last);
		 swap(table, first, (first + last) / 2);
		   T pivot = table[first];    
		   int up = first;
		   int down =last;
		   do {
			   while ((up < last) && (pivot.compareTo(table[up]) >= 0)) {
				   up++;        
			   }
			   while (pivot.compareTo(table[down]) < 0) {            
				   down--;
			   }
			   if (up < down) {
				   swap(table, up, down); 
			   }
		   } while (up < down); 
		   
		   swap(table, first, down); 
		   return down;
		   
	 }
	 private static <T extends Comparable<T>> void sort3(T[] table,int first, int last) {   
		int middle = (first + last) / 2;    
	    if (table[middle].compareTo(table[first]) < 0) {  
	    	swap(table, first, middle); 
	    	}      
	    if (table[last].compareTo(table[middle]) < 0) {
		    swap(table, middle, last);
		    }     
	    if (table[middle].compareTo(table[first]) < 0) {
		    swap(table, first, middle);
		    }   
	
	 }
	 
	//-------------------------------MyMerge---------------------------------------------------
	 
	 /**
	  * I used linkedlist functions instead of index elements in the book.
	  * All other features are the same as the book
	 * @param <T>
	 * @param table
	 */
	public static<T extends Comparable<T>> void myMergeSort(LinkedList<T> table) {
		 if(table.size()>1) {
			 int i=0;
			 int halfSize=table.size()/2;
			 LinkedList<T> leftList=new LinkedList<>();
			 LinkedList<T> rightList=new LinkedList<T>();
			 Iterator<T> iter=table.iterator();
			 while(iter.hasNext()) {
				 if(i<halfSize) {
					 leftList.add(iter.next());
				 }
				 else {
					rightList.add(iter.next()); 
				 }
				 i++;
			 }

			 myMergeSort(leftList);
			 myMergeSort(rightList);
			 merge(table,leftList,rightList);

		 }
		 
	 }
	 private static <T extends Comparable<T>> void merge(LinkedList<T> outputSequence, LinkedList<T> leftSequence,LinkedList<T> rightSequence) {
		 
		 int i = 0;   int j = 0;  int k = 0; 
		 while (i < leftSequence.size() && j < rightSequence.size()) { 
			 if (leftSequence.get(i).compareTo(rightSequence.get(j)) < 0) { 
				 outputSequence.set(k,leftSequence.get(i));i++;k++;
			 }else {
				  outputSequence.set(k, rightSequence.get(j));k++;j++;
			 }
		 }
		 
		 while (i < leftSequence.size()) { 
			 outputSequence.set(k,leftSequence.get(i));i++;k++; 
		 }
		 while (j < rightSequence.size()) {        
			  outputSequence.set(k, rightSequence.get(j));k++;j++;
		 }
		 
		 
	 }

	//------------------------------My Quick--------------------------------------------------
	 /**
	  * 	  * I used linkedlist functions instead of index elements in the book.
	  * All other features are the same as the book
	 * @param <T>
	 * @param table
	 */
	public static <T extends Comparable<T>> void myQuickSort(LinkedList<T> table) {         
		 quickSort(table, 0, table.size() - 1);   
	 } 
	 private static <T extends Comparable<T>> void quickSort(LinkedList<T> table,int first, int last) {
		 if (first < last) {  // There is data to be sorted.            
		 // Partition the table.            
		 int pivIndex = partition(table, first, last);            // Sort the left half.           
		 quickSort(table, first, pivIndex - 1);            // Sort the right half.            
		 quickSort(table, pivIndex + 1, last);       
		 }    
	 }
	 private static <T extends Comparable<T>> int partition(LinkedList<T> table,int first, int last) {
		 sort3(table, first, last);
		 swap(table, first, (first + last) / 2);
		   T pivot = table.get(first);    
		   int up = first;
		   int down =last;
		   do {
			   while ((up < last) && (pivot.compareTo(table.get(up)) >= 0)) {
				   up++;        
			   }
			   while (pivot.compareTo(table.get(down)) < 0) {            
				   down--;
			   }
			   if (up < down) {
				   swap(table, up, down); 
			   }
		   } while (up < down); 
		   
		   swap(table, first, down); 
		   return down;
		   
	 }
	 private static <T extends Comparable<T>> void sort3(LinkedList<T> table,int first, int last) {   
		int middle = (first + last) / 2;    
	    if (table.get(middle).compareTo(table.get(first)) < 0) {  
	    	swap(table, first, middle); 
	    	}      
	    if (table.get(last).compareTo(table.get(middle))< 0) {
		    swap(table, middle, last);
		    }     
	    if (table.get(middle).compareTo(table.get(first)) < 0) {
		    swap(table, first, middle);
		    }   
	
	 }
	 private static <T extends Comparable<T>> void swap(LinkedList<T> table, int i, int j) {
	    	T temp = table.get(i);        
	    	table.set(i,table.get(j));
	    	table.set(j,temp);
	    	}


}

