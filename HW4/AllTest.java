import java.util.Scanner;

public class AllTest {

	/**
	 * Test method for recursions 
	 */
	public static void testRecursions() {
		Recursions x=new Recursions();
		int []Array={8,1,3,10,0};
		System.out.println("Now we will test all recursion functions");
		System.out.println("Firstly, we will test ReversingString.We send the Gebze Teknik Üniversitesi Zafer Altay as an input, we will get the reverse version of the input as output.");		
		x.ReversingString("Gebze Teknik Üniversitesi Zafer Altay",0);
		System.out.println("\n\nNow we test IsElfish functtion.We will test with 2 words that is  elfish and is not.(Zafer and Waffle)");
		int y=x.IsElfish("Zafer","elf",0);
		if(y==1) {
			System.out.println("Zafer is elfish");
		}
		else
			System.out.println("Zafer is not elfish");
		
		int yy=x.IsElfish("Waffle","elf",0);
		if(yy==1) {
			System.out.println("Waffle is elfish");
		}
		else
			System.out.println("Waffle is not elfish");
		
		
		System.out.println("\n\nNow we will test selectionSort fuction.We will send starter index,starter index+1,stater index for min index and array(8,1,3,10,0)");
		x.SelectionSort(Array,0,1,0);
		System.out.println("After that we print my sorting array output must be 0,1,3,8,10");
		for(int i=0;i<5;i++) {
			System.out.printf("%d ",Array[i]);
		}
		System.out.println("\n\nNow we test evaluate postfix");	
		String str="23 44 3 1 8 * + - +";
		System.out.println("We create 23 44 3 1 8 * + - +  string,my function evaluate it.(It must be return 56).Output :"+x.evaluatePostFix(str, 0));
		
		
		
		System.out.println("\nNow we test evaluate prefix.We use split because of learning index num");
		String str2="- + 8 / 6 3 2";
		String []myss=str2.split("\\s+");
		System.out.println("We create - + 8 / 6 3 2  string,my function evaluate it.(It must be return 8).Output :"+x.evaluatePreFix(str2, myss.length-1));				
	}
	
	
	/**
	 * Test method foor deque
	 */
	public static void testMydeque() {
		System.out.println("Now we start testing for MyDeque");
		System.out.println("We start by creating object of type MyDeque");
		MyDeque<Integer> myd=new MyDeque<>();
		System.out.println("Now we will test the addLast,add and addFirst methods.We will add 0,1,2 using them");
		System.out.println("We will check these with peekFirst,peekLast,element and getLast methods");
		myd.addFirst(1);										
		myd.addFirst(0);											
		myd.addLast(2);																	
		
		System.out.println("Now we testing peekFirst method ,output must be 0,output :"+myd.peekFirst());
		System.out.println("Now we testing peekLast method ,output must be 2,output :"+myd.peekLast());
		System.out.println("Now we testing element method ,output must be 0,output :"+myd.element());							
		System.out.println("Now we testing getFirst method ,output must be 0,output :"+myd.getFirst());
		System.out.println("Now we testing getLast method ,output must be 2,output\n:"+myd.getLast());							
		
		System.out.println("Now we testing offer method ,we will try add 3 after that control it using peekLast");
		myd.offer(3);
		System.out.println("Now we testing offer method ,output must be 3,output :"+myd.peekLast());
		
		System.out.println("\nNow we testing offerLast method ,we will try add 4 after that control it using peekLast");
		myd.offerLast(4);
		System.out.println("Now we testing offer method ,output :"+myd.peekLast());
		
		System.out.println("\nNow we testing offerFirst method ,we will try add -1 and -2 after that control it using peekFisrt");
		myd.offerFirst(-1);
		myd.offerFirst(-2);
		System.out.println("Now we testing offerFirst method ,output must be -2,output :"+myd.peekFirst());
	
		System.out.println("\nNow we will test poolFirst ,poll and pop methods and control it using peekFirst,output must be 0");
		myd.pollFirst();
		myd.pop();
		System.out.println("Now we testing pollFirst method after that control fisrt element,output :"+myd.peekFirst()); 			
		
		System.out.println("\nNow we will test poolLast method and control it using peekLast,output must be 3");
		myd.pollLast();
		System.out.println("Now we testing pollLast method after that control last element,output  :"+myd.peekLast());
		
		System.out.println("\nNow we will test removeFirst method and control it using peekFirst,output must be 1");
		myd.removeFirst();
		System.out.println("Now we testing removeFirst method after that control fisrt element,output :"+myd.peekFirst());
		
		System.out.println("\nNow we will test removeLast method and control it using peekLast,output must be 2");
		myd.removeLast();
		System.out.println("Now we testing removeLast method after that control fisrt element,output :"+myd.peekLast());
		
		
		System.out.println("\nWe will test addFirst again but this time we will add a removed item.--->(0)");
		myd.addFirst(0);
		System.out.println("Now we test it using peekFirst output must be 0,Output :"+myd.peekFirst());
		
		System.out.println("\nWe will test addLast and push again but this time we will add a removed item.--->(3 and 4)");
		myd.addLast(3);
		myd.push(4);
		System.out.println("Now we test it using peekLast output must be 4,Output :"+myd.peekFirst());
		
		System.out.println("\nNow we test iterator using hasnext and next methods of iterator but first we will ad some numbers(5,6,7)");
		
		myd.addLast(5);
		myd.addLast(6);myd.addLast(7);
		
		System.out.println("\nNow we testing iterator.Using the iterator we write nums from the front to rear.(Output must be 0-1-2-3-4-5-6-7)");
		
		MyDeque<Integer>.MyIterator iter=(MyDeque<Integer>.MyIterator) myd.iterator();
		   while(iter.hasNext()) {
			  System.out.printf("%d ",iter.next());
		   }
		System.out.println("For the test we will write 3 in the last row and remove with removeLasttOccurance");
		myd.offerLast(3);
		myd.removeFirstOccurrence(3);
		
		
		System.out.println("\nNow we test descendingiterator(Output must be 3 7 6 5 4 2 1) :");
		MyDeque<Integer>.MyIterator iter2=(MyDeque<Integer>.MyIterator) myd.descendingIterator();
		   while(iter2.hasNext()) {
		     	System.out.printf("%d ",iter2.next());
		    }
		   
		System.out.println("\nNow we testing size method.Output must be 8");
		System.out.println("Output"+myd.size());
	}
	
	
	public static void main(String []args) {
		
		int x=0;
		Scanner scan=new Scanner(System.in);
		System.out.println("Which you want to test \n1-)Recursions\n2-)Deque");
		x=scan.nextInt();
		if(x==1) {
			testRecursions();
		}
		else if(x==2) {
			testMydeque();
		}

		
		}
	
}
