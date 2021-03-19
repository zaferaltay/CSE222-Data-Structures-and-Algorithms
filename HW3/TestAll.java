import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class TestAll {       

	/**
	 * Tests all method for q1
	 */
	public static void testQ1() {
		LinkedArrayList<Integer> ll =new LinkedArrayList<>();
		System.out.println("First we create an LinkedArrayList object that contains integer");
		ll.filledPartially(0,1,4,5,6);
		System.out.println("To make PFA,we added two elements to the first node,one elemnt to second node and two elements to third node");
		System.out.println("And now we will use toString method for print the elements");
		ll.toString();
		System.out.println("\nNow we will use add(int x) method for add elements to last index.We will add two elements because of we test method that if array filled, add method create new node that is tail");
		ll.add(7);
		ll.add(8);
		ll.toString();
		System.out.println("\nWe added and printed them");
		System.out.println("And now we test add(int,E) method.We will complete the missing index with adding 2,3 and 9");
		ll.add(2,2);
		ll.add(3,3);
		ll.add(4,9);
		System.out.println( "When adding to missing index, we also tested that we created a new node or shifted when the node was full.");
		System.out.println("And we will print the list");
		ll.toString();
		System.out.println("\nWe will remove 9 using remove(int index) method and print");
		ll.remove(4);
		ll.toString();
		System.out.println("\nNow We will add 99 and set 99 to -1 using addFirst and  set method and print");
		ll.AddFirst(99);
		ll.toString();
		System.out.println("");
		ll.set(0,-1);
		ll.toString();
		System.out.println("Now we will control the get method.We get a element that at the 5th index (it must be 4)");
		System.out.printf("%d th index = %d\n",5,ll.get(5));
		System.out.println("Now we test the size method.It must be 10");
		System.out.printf("Size = %d",ll.size());
		System.out.println("Now we test indexOf method for true (5 must be in 6th index) and false(29 no indexed so it must return -1)");
		System.out.printf("%d is in %d th index\n",5,ll.indexOf(5));
		System.out.printf("%d is in %d th index\n",29,ll.indexOf(29));
		System.out.println("Now we check lastIndexOf method we try for 8.It mus be return 9");
		System.out.printf("%d was last time occurs in %d th index\n",8,ll.lastIndexOf(8));
		System.out.println("We tested all methods of LinkedArrayList class now we will test Linkediterator class \n");
		System.out.println("First of all we create iterator at 4th indexes");
		LinkedArrayList<Integer>.Listiterator iter=ll.listiterator(4);
		System.out.println("Now we check nextIndex and previousIndex method ,first we will use next method 2 times and previous method 2 times(Output must be 4-5-4-3)");

		System.out.printf("%d-",iter.nextIndex());iter.next();System.out.printf("%d-",iter.nextIndex());
		System.out.printf("%d-",iter.previousIndex());iter.previous();System.out.printf("%d\n",iter.previousIndex());
		System.out.println("Now we will try add method of iterator so ý will use nexttt method after added 99 after that I use next mehod after added 98");
		iter.add(98);
		iter.next();
		iter.add(99);
		iter.next();
		
		System.out.println("We check the add method results,test next and hasnext method of iterator.We will create new iterator at head of the list and we will go to the tail(Output must be -1 0 1 2 98 3 99 4 5 6 7 8)");
		LinkedArrayList<Integer>.Listiterator iter2=ll.listiterator();
	    	while(iter2.hasNext()) {
			   System.out.printf("%d ",iter2.next());
		      }
		System.out.println("\nNow we try it for previous");

		while(iter2.hasPrevious()) {
			System.out.printf("%d ",iter2.previous());
		}
		System.out.println("\nOur last element is -1 now we try remove it using remove method of iterator after that we use next meethod three times output must be 0 1 2 ");
		
		iter2.remove();
		System.out.printf("%d %d %d \n",iter2.next(),iter2.next(),iter2.next());
		System.out.println("Last of all we tried set method for convert from 2 to 99 after that we will go from head to tail for check it.(Output must be 0 1 100 98 3 99 4 5 6 7 8)");
		iter2.set(100);
		iter2=ll.listiterator();
		
    	while(iter2.hasNext()) {
		   System.out.printf("%d ",iter2.next());
	      }
		
	}
	
	/**
	 * tests all methods of q2 and write logFile
	 * @throws IOException
	 */
	public static void testQ2() throws IOException {
	

		
		    Logger logger = Logger.getLogger("MyLog");  
	        FileHandler fh;  
		    String FILENAME = "161044063.log"; 
		    BufferedWriter bw = null;
		    FileWriter fw = null;
		    try {
		        fh = new FileHandler("161044063.log");  
		        logger.addHandler(fh);
		        SimpleFormatter formatter = new SimpleFormatter();  
		        fh.setFormatter(formatter);  
		        logger.info("CSE 222 HW3 LOG FILE");
		        fw = new FileWriter(FILENAME, true);
		        bw = new BufferedWriter(fw);
		        
				List<Character> obj=new ArrayList<>();	
				SimpleTextEditor text=new SimpleTextEditor(obj);
				List<Character> obj2;
		        
				bw.write("Now we test all methods and measures the execution time for array list after that we test and measures them for linkedlist");
				bw.write("\nFirstly, we will create an onject of arraylist\n");
				bw.write("Now we check readFromFileNormal method after that we will print the text\n");
				text.readFromFileNormal();
				obj2=text.getTextEditor();
				for(int i=0;i<obj2.size();i++) {
					bw.write(obj2.get(i));
				}
				bw.write("\nNow we add the string to test using addNormal method(5. index to ZAFER ALTAY) and print the new text\n");
				text.addNormal(5, "ZAFER ALTAY");
				obj2=text.getTextEditor();
				for(int i=0;i<obj2.size();i++) {
					bw.write(obj2.get(i));
				}							
				bw.write("\nNow we find the string in text normally.We search to FER AL in text it must be return 7\n");
				int x=text.findNormal("FER AL");
				bw.write("FER AL starting to ");bw.write(Integer.toString(x));bw.write(" th index\n");
				
				bw.write("We will print the new text after replace all A character to C using replacesNormal(Output must be CCCCCZCFER CLTCYCCC)\n");
				text.replacesNormal('A','C');
				obj2=text.getTextEditor();
				for(int i=0;i<obj2.size();i++) {
					bw.write(obj2.get(i));
				}
				
				bw.write("\n\nWe finished normal methods and we will try iterator methods for all with another txt file");			
				bw.write("Now we check readFromFileIterator method after that we will print the text\n");
				obj=new ArrayList<>();	
				text=new SimpleTextEditor(obj);
				text.path="def.txt";
				text.readFromFileIterator();
				obj2=text.getTextEditor();
				for(int i=0;i<obj2.size();i++) {
					bw.write(obj2.get(i));
				}
				bw.write("\nNow we add the string to test using addNormal method(5. index to ZAFER ALTAY) and print the new text\n");
				text.addIterator(5, "ZAFER ALTAY");
				obj2=text.getTextEditor();
				for(int i=0;i<obj2.size();i++) {
					bw.write(obj2.get(i));
				}											
				bw.write("\nNow we find the string in text normally.We search to FER AL in text it must be return 7\n");
				bw.write("FER AL starting to ");bw.write(Integer.toString(text.findNormal("FER AL")));bw.write(" th index\n");				
				bw.write("We will print the new text after replace all A character to C using replacesNormal\n");
				bw.write("(Output must be BBBBBZAFER ALTAYBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB)\n\n");
				text.replacesIterator('A','C');
				obj2=text.getTextEditor();
				for(int i=0;i<obj2.size();i++) {
					bw.write(obj2.get(i));
				}				
				
				bw.write("\n\nWe finished the all test.Now we try measuring the total time for all methods that without print comment and output.");			
				
				//-------------------NORMAL MET. TIME FOR ARRAY LIST-------------------	
				bw.write("Firstly we will try normal methods for exec. time\n");
				obj=new ArrayList<>();	
				text=new SimpleTextEditor(obj);
				obj2=text.getTextEditor();
				long startTime = System.nanoTime();	
				   text.readFromFileNormal();
				   text.addNormal(5, "ZAFER ALTAY");
				   text.findNormal("FER AL");
				   text.replacesNormal('A','C');
				long endTime = System.nanoTime();	
				long timeElapsed = endTime - startTime;
				bw.write("Normal methods Execution time in nanoseconds for ArrayList  : "); bw.write(Long.toString(timeElapsed));
				bw.write("\nNormal methods Execution time in milliseconds for ArrayList : 0.");  bw.write(Long.toString (timeElapsed / 100000));
				
		  //--------------------Iterator methods time for ARRAYLIST-------------------------------		
				bw.write("\n\nSecond we will try ýterator methods for exec. time\n");
				obj=new ArrayList<>();	
				text=new SimpleTextEditor(obj);
				obj2=text.getTextEditor();
				long startTime2 = System.nanoTime();	
				   text.readFromFileIterator();
				   text.addIterator(5, "ZAFER ALTAY");
				   text.findIterator("FER AL");
				   text.replacesIterator('A','C');
				long endTime2 = System.nanoTime();	
				long timeElapsed2 = endTime2 - startTime2;
				bw.write("Iterator methods Execution time in nanoseconds for ArrayList  : "); bw.write(Long.toString(timeElapsed2));
				bw.write("\nIterator methods Execution time in milliseconds for ArrayList : 0."); bw.write(Long.toString(timeElapsed2 / 100000));
		//-----------------Normal Method for LinkedList----------------------------------------
				bw.write("\n\nThird we will try normal methods for exec. time\n");
				obj=new LinkedList<>();	
				text=new SimpleTextEditor(obj);
				obj2=text.getTextEditor();
				long startTime3 = System.nanoTime();	
				   text.readFromFileNormal();
				   text.addNormal(5, "ZAFER ALTAY");
				   text.findNormal("FER AL");
				   text.replacesNormal('A','C');
				   long endTime3 = System.nanoTime();	
				   long timeElapsed3 = endTime3 - startTime3;
					bw.write("Normal methods Execution time in nanoseconds for LinkedList  : "); bw.write(Long.toString(timeElapsed3));
					bw.write("\nNormal methods Execution time in milliseconds for LinkedList : 0.");  bw.write(Long.toString(timeElapsed3 / 100000));
				
				
		//------------------Iterator method for LinkedList----------------------------------------------		
				obj=new LinkedList<>();	
				text=new SimpleTextEditor(obj);
				bw.write("\n\nFourth we will try ýterator methods for exec. time\n");
				obj2=text.getTextEditor();
				long startTime4 = System.nanoTime();	
				   text.readFromFileIterator();
				   text.addIterator(5, "ZAFER ALTAY");
				   text.findIterator("FER AL");
				   text.replacesIterator('A','C');
				   long endTime4 = System.nanoTime();	
				   long timeElapsed4 = endTime4 - startTime4;
   				   bw.write("Iterator methods Execution time in nanoseconds for LinkedList  : "); bw.write(Long.toString(timeElapsed4));
				   bw.write("\nIterator methods Execution time in milliseconds for LinkedList : 0."); bw.write(Long.toString(timeElapsed4 / 100000));
				
				
		//----------------------------Daha büyük boyutlu  dosya------------------------------
		//-------------------NORMAL MET. TIME FOR ARRAY LIST-------------------	
				bw.write("\n\nFifth we will try normal methods for exec. time for other txt");
				obj=new ArrayList<>();	
				text=new SimpleTextEditor(obj);
				text.path="def.txt";
				obj2=text.getTextEditor();
				long startTime5 = System.nanoTime();	
				   text.readFromFileNormal();
				   text.addNormal(5, "ZAFER ALTAY");
				   text.findNormal("FER AL");
				   text.replacesNormal('A','C');
				long endTime5 = System.nanoTime();	
				long timeElapsed5 = endTime5 - startTime5;
				bw.write("Normal methods Execution time in nanoseconds for ArrayList  : "); bw.write(Long.toString(timeElapsed5));
				bw.write("\nNormal methods Execution time in milliseconds for ArrayList : 0.");  bw.write(Long.toString (timeElapsed5 / 100000));
				
		  //--------------------Iterator methods time for ARRAYLIST-------------------------------		
				bw.write("\n\nSixth we will try ýterator methods for exec. time");
				obj=new ArrayList<>();	
				text=new SimpleTextEditor(obj);
				text.path="def.txt";
				obj2=text.getTextEditor();
				long startTime6 = System.nanoTime();	
				   text.readFromFileIterator();
				   text.addIterator(5, "ZAFER ALTAY");
				   text.findIterator("FER AL");
				   text.replacesIterator('A','C');
				long endTime6 = System.nanoTime();	
				long timeElapsed6 = endTime6 - startTime6;
				bw.write("Iterator methods Execution time in nanoseconds for ArrayList  : "); bw.write(Long.toString(timeElapsed6));
				bw.write("\nIterator methods Execution time in milliseconds for ArrayList : 0."); bw.write(Long.toString(timeElapsed6 / 100000));
		//-----------------Normal Method for LinkedList----------------------------------------
				bw.write("\n\nSeventh we will try normal methods for exec. time");
				obj=new LinkedList<>();	
				text=new SimpleTextEditor(obj);
				text.path="def.txt";
				obj2=text.getTextEditor();
				long startTime7 = System.nanoTime();	
				   text.readFromFileNormal();
				   text.addNormal(5, "ZAFER ALTAY");
				   text.findNormal("FER AL");
				   text.replacesNormal('A','C');
				   long endTime7 = System.nanoTime();	
				   long timeElapsed7 = endTime7 - startTime7;
					bw.write("Normal methods Execution time in nanoseconds for LinkedList  : "); bw.write(Long.toString (timeElapsed7));
					bw.write("\nNormal methods Execution time in milliseconds for LinkedList : 0.");  bw.write(Long.toString (timeElapsed7 / 100000));
				
				
		//------------------Iterator method for LinkedList----------------------------------------------		
				obj=new LinkedList<>();	
				text=new SimpleTextEditor(obj);
				text.path="def.txt";
				bw.write("\n\nEighth we will try ýterator methods for exec. time");
				obj2=text.getTextEditor();
				long startTime8 = System.nanoTime();	
				   text.readFromFileIterator();
				   text.addIterator(5, "ZAFER ALTAY");
				   text.findIterator("FER AL");
				   text.replacesIterator('A','C');
				   long endTime8 = System.nanoTime();	
				   long timeElapsed8 = endTime8 - startTime8;
   				   bw.write("Iterator methods Execution time in nanoseconds for LinkedList  : "); bw.write(Long.toString(timeElapsed8));
				   bw.write("\nIterator methods Execution time in milliseconds for LinkedList : 0."); bw.write(Long.toString(timeElapsed8 / 100000));					
				
				
				
				
				
				
				
				
				
				
				
				
			
		        
		    } catch (IOException e) {
		        e.printStackTrace();
		    } catch (SecurityException e) {  
		        e.printStackTrace();  
		    }finally {
		        try {
		            if (bw != null)
		                bw.close();
		            if (fw != null)
		                fw.close();
		        } catch (IOException ex) {
		            ex.printStackTrace();
		        }
		    }
		
		
		
		
		
		
		
		
		
	/*	
		
		List<Character> obj=new ArrayList<>();	
		SimpleTextEditor text=new SimpleTextEditor(obj);
		List<Character> obj2;
		System.out.println("Now we test all methods and measures the execution time for array list after that we test and measures them for linkedlist");
		System.out.println("Firstly, we will create an onject of arraylist");
            //---------------------NORMAL TEST-----------
			System.out.println("Now we check readFromFileNormal method after that we will print the text");
			text.readFromFileNormal();
			obj2=text.getTextEditor();
			for(int i=0;i<obj2.size();i++) {
				System.out.printf("%c ",obj2.get(i));
			}
			System.out.println("\nNow we add the string to test using addNormal method(5. index to ZAFER ALTAY) and print the new text");
			text.addNormal(5, "ZAFER ALTAY");
			obj2=text.getTextEditor();
			for(int i=0;i<obj2.size();i++) {
				System.out.printf("%c ",obj2.get(i));
			}
			System.out.println("\nNow we find the string in text normally.We search to FER AL in text it must be return 7");
			System.out.printf("FER AL starting to %d th index\n",text.findNormal("FER AL"));	
/* output düzenle		System.out.println("We will print the new text after replace all A character to C using replacesNormal(Output must be xxxx)");
			text.replacesNormal('A','C');
			obj2=text.getTextEditor();
			for(int i=0;i<obj2.size();i++) {
				System.out.printf("%c ",obj2.get(i));
			}
		//-------------------------------------	Iterator test---------------------------	
			System.out.println("\nWe finished normal methods and we will try iterator methods for all");			
			System.out.println("Now we check readFromFileIterator method after that we will print the text");
			obj=new ArrayList<>();	
			text=new SimpleTextEditor(obj);
			text.path="def.txt";
			text.readFromFileIterator();
			obj2=text.getTextEditor();
			for(int i=0;i<obj2.size();i++) {
				System.out.printf("%c ",obj2.get(i));
			}
			System.out.println("\nNow we add the string to test using addIterator method(5. index to ZAFER ALTAY) and print the new text");
			text.addIterator(5, "ZAFER ALTAY");
			obj2=text.getTextEditor();
			for(int i=0;i<obj2.size();i++) {
				System.out.printf("%c ",obj2.get(i));
			}
			System.out.println("\nNow we find the string in text using findIterator.We search to FER AL in text it must be return 7");
			System.out.printf("FER AL starting to %d th index\n",text.findIterator("FER AL"));	
/* output düzenle		System.out.println("We will print the new text after replace all A character to C using replacesIterator(Output must be xxxx)");
			text.replacesIterator('A','C');
			obj2=text.getTextEditor();
			for(int i=0;i<obj2.size();i++) {
				System.out.printf("%c ",obj2.get(i));
			}	
			
			
			
			
	//--------------MEASURÝNG EXECUTION TIME-----------------------------------------------------
		System.out.println("\nWe finished the all test.Now we try measuring the total time for all methods that without print comment and output.");
	//-------------------NORMAL MET. TIME FOR ARRAY LIST-------------------	
		System.out.println("Firstly we will try normal methods for exec. time");
		obj=new ArrayList<>();	
		text=new SimpleTextEditor(obj);
		obj2=text.getTextEditor();
		long startTime = System.nanoTime();	
		   text.readFromFileNormal();
		   text.addNormal(5, "ZAFER ALTAY");
		   text.findNormal("FER AL");
		   text.replacesNormal('A','C');
		long endTime = System.nanoTime();	
		long timeElapsed = endTime - startTime;
		System.out.println("Normal methods Execution time in nanoseconds for ArrayList  : " + timeElapsed);
		System.out.println("Normal methods Execution time in milliseconds for ArrayList : 0." + timeElapsed / 100000);
		
  //--------------------Iterator methods time for ARRAYLIST-------------------------------		
		System.out.println("Second we will try ýterator methods for exec. time");
		obj=new ArrayList<>();	
		text=new SimpleTextEditor(obj);
		obj2=text.getTextEditor();
		long startTime2 = System.nanoTime();	
		   text.readFromFileIterator();
		   text.addIterator(5, "ZAFER ALTAY");
		   text.findIterator("FER AL");
		   text.replacesIterator('A','C');
		long endTime2 = System.nanoTime();	
		long timeElapsed2 = endTime2 - startTime2;
		System.out.println("Iterator methods Execution time in nanoseconds for ArrayList  : " + timeElapsed2);
		System.out.println("Iterator methods Execution time in milliseconds for ArrayList : 0." + timeElapsed2 / 100000);
//-----------------Normal Method for LinkedList----------------------------------------
		System.out.println("Third we will try normal methods for exec. time");
		obj=new LinkedList<>();	
		text=new SimpleTextEditor(obj);
		obj2=text.getTextEditor();
		long startTime3 = System.nanoTime();	
		   text.readFromFileNormal();
		   text.addNormal(5, "ZAFER ALTAY");
		   text.findNormal("FER AL");
		   text.replacesNormal('A','C');
		   long endTime3 = System.nanoTime();	
		   long timeElapsed3 = endTime3 - startTime3;
		System.out.println("Normal methods Execution time in nanoseconds for LinkedList  : " + timeElapsed3);
		System.out.println("Normal methods Execution time in milliseconds for LinkedList : 0." + timeElapsed3 / 100000);
		
		
//------------------Iterator method for LinkedList----------------------------------------------		
		obj=new LinkedList<>();	
		text=new SimpleTextEditor(obj);
		System.out.println("Fourth we will try ýterator methods for exec. time");
		obj2=text.getTextEditor();
		long startTime4 = System.nanoTime();	
		   text.readFromFileIterator();
		   text.addIterator(5, "ZAFER ALTAY");
		   text.findIterator("FER AL");
		   text.replacesIterator('A','C');
		   long endTime4 = System.nanoTime();	
		   long timeElapsed4 = endTime4 - startTime4;
		System.out.println("Iterator methods Execution time in nanoseconds for LinkedList  : " + timeElapsed4);
		System.out.println("Iterator methods Execution time in milliseconds for LinkedList : 0." + timeElapsed4 / 100000);
		
		
//----------------------------Daha büyük boyutlu  dosya------------------------------
//-------------------NORMAL MET. TIME FOR ARRAY LIST-------------------	
		System.out.println("Firstly we will try normal methods for exec. time");
		obj=new ArrayList<>();	
		text=new SimpleTextEditor(obj);
		text.path="def.txt";
		obj2=text.getTextEditor();
		long startTime5 = System.nanoTime();	
		   text.readFromFileNormal();
		   text.addNormal(5, "ZAFER ALTAY");
		   text.findNormal("FER AL");
		   text.replacesNormal('A','C');
		long endTime5 = System.nanoTime();	
		long timeElapsed5 = endTime5 - startTime5;
		System.out.println("Normal methods Execution time in nanoseconds for ArrayList  : " + timeElapsed5);
		System.out.println("Normal methods Execution time in milliseconds for ArrayList : 0." + timeElapsed5 / 100000);
		
  //--------------------Iterator methods time for ARRAYLIST-------------------------------		
		System.out.println("Second we will try ýterator methods for exec. time");
		obj=new ArrayList<>();	
		text=new SimpleTextEditor(obj);
		text.path="def.txt";
		obj2=text.getTextEditor();
		long startTime6 = System.nanoTime();	
		   text.readFromFileIterator();
		   text.addIterator(5, "ZAFER ALTAY");
		   text.findIterator("FER AL");
		   text.replacesIterator('A','C');
		long endTime6 = System.nanoTime();	
		long timeElapsed6 = endTime6 - startTime6;
		System.out.println("Iterator methods Execution time in nanoseconds for ArrayList  : " + timeElapsed6);
		System.out.println("Iterator methods Execution time in milliseconds for ArrayList : 0." + timeElapsed6 / 100000);
//-----------------Normal Method for LinkedList----------------------------------------
		System.out.println("Third we will try normal methods for exec. time");
		obj=new LinkedList<>();	
		text=new SimpleTextEditor(obj);
		text.path="def.txt";
		obj2=text.getTextEditor();
		long startTime7 = System.nanoTime();	
		   text.readFromFileNormal();
		   text.addNormal(5, "ZAFER ALTAY");
		   text.findNormal("FER AL");
		   text.replacesNormal('A','C');
		   long endTime7 = System.nanoTime();	
		   long timeElapsed7 = endTime7 - startTime7;
		System.out.println("Normal methods Execution time in nanoseconds for LinkedList  : " + timeElapsed7);
		System.out.println("Normal methods Execution time in milliseconds for LinkedList : 0." + timeElapsed7 / 100000);
		
		
//------------------Iterator method for LinkedList----------------------------------------------		
		obj=new LinkedList<>();	
		text=new SimpleTextEditor(obj);
		text.path="def.txt";
		System.out.println("Fourth we will try ýterator methods for exec. time");
		obj2=text.getTextEditor();
		long startTime8 = System.nanoTime();	
		   text.readFromFileIterator();
		   text.addIterator(5, "ZAFER ALTAY");
		   text.findIterator("FER AL");
		   text.replacesIterator('A','C');
		   long endTime8 = System.nanoTime();	
		   long timeElapsed8 = endTime8 - startTime8;
		System.out.println("Iterator methods Execution time in nanoseconds for LinkedList  : " + timeElapsed8);
		System.out.println("Iterator methods Execution time in milliseconds for LinkedList : 0." + timeElapsed8 / 100000);		
		
		
		
		
		
		*/
		
		
		
		
		
	}
	public static void main(String args[]) throws IOException{  //setten sonra prev hata verdi kontrol et.  NextIndex PreviousIndex düzelt
		
	System.out.println("Which one do you want to test? \n1)LinkedArrayList\n2)SimpleTestEditor");
	
	Scanner scan=new Scanner(System.in);
	int x=scan.nextInt();
	if(x==1) {
		try {
			testQ1();
		} catch ( NoSuchElementException e) {
	        e.printStackTrace();
	    } catch (IllegalStateException e) {  
	        e.printStackTrace();  
	    }
	}
	else testQ2();
	
		
		
			
	}
}
