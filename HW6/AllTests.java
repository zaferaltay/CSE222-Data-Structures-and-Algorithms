import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

/**
 * @author zafer
 * 
 *All classes are tested.The comment line can be checked by unchecking it in main.
 */
public class AllTests {

	public static void testMyMerge() {
		LinkedList<Integer> ll=new LinkedList<>();
		Random r =new Random(); 
		
		
		for(int i=0;i<180000;i++) {								//R olan
			ll.add(new Integer(r.nextInt(250000)));
		}
		
			/*for(int i=0;i<10000;i++) {
				ll.add(new Integer(i));
			}*/
		
		long start=System.currentTimeMillis();
		Sorting.myMergeSort(ll);
		long end=System.currentTimeMillis();
		long gecenSüre = end - start;
		double saniye = (double)gecenSüre/1000; 
				
		System.out.println(saniye);
				
	}

	public static void testMyQuick() {
		LinkedList<Integer> ll=new LinkedList<>();
		Random r =new Random(); 
		
		for(int l=0;l<1;l++) {
			  for(int i=0;i<180000;i++) {								//R olan
					 ll.add(new Integer(r.nextInt(250000)));
				   }
				long start=System.currentTimeMillis();
				Sorting.myQuickSort(ll);
				long end=System.currentTimeMillis();
				long gecenSüre = end - start;
				double saniye = (double)gecenSüre/1000; 
						
				System.out.println(l+".si  "+saniye);
		}
		/*  for(int i=0;i<150000;i++) {								//R olan
			 ll.add(new Integer(r.nextInt(250000)));
		   }
		
			/*for(int i=0;i<150000;i++) {
				ll.add(new Integer(i));
			}*/
		
		/*long start=System.currentTimeMillis();
		Sorting.myQuickSort(ll);
		long end=System.currentTimeMillis();
		long gecenSüre = end - start;
		double saniye = (double)gecenSüre/1000; 
				
		System.out.println(saniye);*/
	}
	
	public static void testQuickSort() {
		Integer []myArray=new Integer[180000];
		Random r =new Random(); 
		
		
		for(int i=0;i<180000;i++) {								//R olan
			myArray[i]=new Integer(r.nextInt(750000));
		}
		
			/*for(int i=0;i<150000;i++) {
				ll.add(new Integer(i));
			}*/
		
		long start=System.currentTimeMillis();
		Sorting.quickSort(myArray);
		long end=System.currentTimeMillis();
		long gecenSüre = end - start;
		double saniye = (double)gecenSüre/1000; 
				
		System.out.println(saniye);
	}
	
	
	public static void testHeapSort() {
		Integer []myArray=new Integer[180000];
		Random r =new Random(); 
		
		
		for(int j=0;j<7;j++) {
			for(int i=0;i<180000;i++) {								//R olan
				myArray[i]=new Integer(r.nextInt(750000));
			}
			long start=System.currentTimeMillis();
			Sorting.heapSort(myArray);
			long end=System.currentTimeMillis();
			long gecenSüre = end - start;
			double saniye = (double)gecenSüre/1000; 
					
			System.out.println(j+" "+saniye);
		}
		
			/*for(int i=0;i<150000;i++) {
				ll.add(new Integer(i));
			}*/
		
	
	}
	
	
	public static void testBubbleSort() {
		Integer []myArray=new Integer[10000];
		Random r =new Random(); 
		
		
		for(int i=0;i<10000;i++) {								//R olan
			myArray[i]=new Integer(r.nextInt());
		}
		
			/*for(int i=0;i<150000;i++) {
				myArray[i]=new Integer(i);
			}*/
		
		long start=System.currentTimeMillis();
		Sorting.bubbleSort(myArray);
		long end=System.currentTimeMillis();
		long gecenSüre = end - start;
		double saniye = (double)gecenSüre/1000; 
				
		System.out.println(saniye);
	}

	public static void testShellSort() {
		Integer []myArray=new Integer[180000];
		Random r =new Random(); 
		
		
		for(int i=0;i<180000;i++) {								//R olan
			myArray[i]=new Integer(r.nextInt(750000));
		}
		
			/*for(int i=0;i<150000;i++) {
				ll.add(new Integer(i));
			}*/
		
		long start=System.currentTimeMillis();
		Sorting.shellSort(myArray);
		long end=System.currentTimeMillis();
		long gecenSüre = end - start;
		double saniye = (double)gecenSüre/1000; 
				
		System.out.println(saniye);
	}

	public static void testInsertionSort() {
		Integer []myArray=new Integer[180000];
		Random r =new Random(); 
		
		
		for(int i=0;i<180000;i++) {								//R olan
			myArray[i]=new Integer(r.nextInt(750000));
		}
		
			/*for(int i=0;i<150000;i++) {
				ll.add(new Integer(i));
			}*/
		
		long start=System.currentTimeMillis();
		Sorting.insetionSort(myArray);
		long end=System.currentTimeMillis();
		long gecenSüre = end - start;
		double saniye = (double)gecenSüre/1000; 
				
		System.out.println(saniye);
	}

	public static void testMergeSort() {
		Integer []myArray=new Integer[180000];
		Random r =new Random(); 
		
		for(int j=0;j<7;j++) {
			for(int i=0;i<180000;i++) {								//R olan
				myArray[i]=new Integer(r.nextInt(750000));
			}
			long start=System.currentTimeMillis();
			Sorting.mergeSort(myArray);
			long end=System.currentTimeMillis();
			long gecenSüre = end - start;
			double saniye = (double)gecenSüre/1000; 
					
			System.out.println(j+" "+saniye);
		}

		
			/*for(int i=0;i<150000;i++) {
				ll.add(new Integer(i));
			}*/
		


	}
	
	
	public static void testSelectionSort() {
		Integer []myArray=new Integer[180000];
		Random r =new Random(); 
		
	for(int j=0;j<5;j++) {
		for(int i=0;i<180000;i++) {								//R olan
			myArray[i]=new Integer(r.nextInt(750000));
		}
		
		long start=System.currentTimeMillis();
		Sorting.selectionSort(myArray);
		long end=System.currentTimeMillis();
		long gecenSüre = end - start;
		double saniye = (double)gecenSüre/1000; 
				
		System.out.println(j+" "+saniye);
	}
		/*for(int i=0;i<180000;i++) {								//R olan
			myArray[i]=new Integer(r.nextInt(750000));
		}*/
		
			/*for(int i=0;i<150000;i++) {
				ll.add(new Integer(i));
			}*/

	}
	
	public static void testLAS() {
		String PASSWORD="ZA2016";
		LibraryAutomationSystem a=new LibraryAutomationSystem();
		String autName;
		String bookName;
		int corridor;
		int shelf;
		int choice;
		String pword;
		Scanner scan = new Scanner(System.in);
		System.out.println("Please select test mode\n1-)Manually Test\n2-)Driver Code");
		choice=scan.nextInt();
		
		
		  if(choice==1) {
			System.out.println("Please select your enterance type\n1-)Admin\n2-)Guest");
			choice=scan.nextInt();
			 if(choice==1) {
				  System.out.printf("Please enter the password : ");
				  pword=scan.next(); 
				 if(pword.equals(PASSWORD)) {
						
						System.out.println("\nWelcome to Library Automation Sysytem");
						do {
							System.out.println("What do you want");
							System.out.println("1-)Add Book\n2-)Delete Book\n3-)Search Book\n4-)Search Author\n5-)Update Informations\n6-)Print All Books information\n7-)Exit");
							choice=scan.nextInt();
							
							if(choice==1) {
								System.out.println("Please enter a Author Name");
								autName=scan.next();
								System.out.println("\nPlease enter a Book Name");
								bookName=scan.next();
								System.out.println("\nPlease enter the corridor num and shelf num");
								corridor=scan.nextInt();
								shelf=scan.nextInt();
								a.addBook(autName, bookName, corridor, shelf);
							}
							else if (choice==2) {
								System.out.println("Please enter a Author Name");
								autName=scan.next();
								System.out.println("\nPlease enter a Book Name");
								bookName=scan.next();
								a.deleteBook(autName, bookName);
							}
							else if(choice==3) {
								System.out.println("\nPlease enter a Book Name");
								bookName=scan.next();
								a.searchingBook(bookName);
							}
							else if(choice==4) {
								System.out.println("Please enter a Author Name");
								autName=scan.next();
								a.searchingAuthor(autName);
							}
							else if(choice==5) {
								System.out.println("Please enter a Author Name");
								autName=scan.next();
								System.out.println("\nPlease enter a Book Name");
								bookName=scan.next();
								a.updateInformation(autName, bookName);
							}
							else if(choice==6) {
								a.print();
							}
							else if(choice==7) {
								break;
							}
							else {
								System.out.println("Invalid choice");
							}
							
							
						}while(choice!=7);		
						
					}else {
						System.out.println("Wrong password please try again");
					}
			 }
			 else if(choice==2) {
				System.out.println("\n Welcome to Library Automation Sysytem");
				do {
					System.out.println("What do you want");
					System.out.println("1-)Search Book\n2-)Search Author\n3-)Exit");
					choice=scan.nextInt();
					if(choice==1) {
						System.out.println("\nPlease enter a Book Name");
						bookName=scan.next();
						a.searchingBook(bookName);						
					}
					else if(choice==2) {
						System.out.println("Please enter a Author Name");
						autName=scan.next();
						a.searchingAuthor(autName);
					}
					else if(choice==3) {
						break;
					}
					else {
						System.out.println("Invalid select");
					}
				}while(choice!=3);

			 }
			
		}
		  	  
		  else {
			  		  
			  System.out.println("Welcome to Library Automation Sysytem");
			  System.out.println("First ,I creating an object for our test");
			  LibraryAutomationSystem driver=new LibraryAutomationSystem();
			  System.out.println("Since we will test all the methods, we assume that it is entered with a password.");
			  System.out.println("We are now testing the addBook and print method. First, we will add the book using the add method, then we will display it with the print method.");
			  a.addBook("Halit Ziya Usakligil","Aþk-ý Memnu",2,5);
			  System.out.println("We put the book on the 2nd corridor and on the 5th shelf. We will print the book's information using the print function.");
			  System.out.println("The part before the dot sign gives the information of the corridor and shelf\n");
			  a.print();
			  System.out.println("Now we are testing to see what happens if there is more than one of the same book,For this we are adding again from the same book");
			  a.addBook("Halit Ziya Usakligil","Aþk-ý Memnu",2,6);
			  System.out.println("Corridor and Shelf information must be c2s5 and c2s6\n");
			  a.print();
			  System.out.println("Let's test the situation of having different books");
			  System.out.println("Using addBook method ,i adding another book");
			  a.addBook("R.Mahmut Ekrem","Araba Sevdasi",3,4);
			  System.out.println("Now i'm printing all\n");
			  a.print();
			  System.out.println("I add a lot of books for better testing");
			  a.addBook("Tolstoy","Anna Karaninna",2,5);
			  a.addBook("Edip Adivar","Atesten Gomlek",3,3);
			  a.addBook("Sait Faik Abasýyanýk","Seçme Hikayeler",4,1);
			  a.addBook("Kemal Atatürk","Nutuk",1,1);
			  a.addBook("Victor Hugo","Sefiller",4,1);
			  a.addBook("Ýskender Pala","OD",5,5);
			  System.out.println("TESTING T05");
			  a.deleteBook("Ali","BBBBB");
			  System.out.println("TESTING T04");
			  a.deleteBook("Tolstoy","Anna Karaninna");
			  System.out.println("TESTING T06");
			  a.searchingAuthor("Ýskender Pala");
			  System.out.println("TESTING T07");
			  a.searchingBook("Nutuk");
			  System.out.println("TESTING T08");
			  a.updateInformation("Ýskender Pala","OD");
			  a.searchingBook("OD");
		  }
			
	}
	
	public static void hashMapChaining() {
		HashMapChaining<String,String> hmc=new HashMapChaining<>();
		
		System.out.println("First of all I add a value and check it with get method");
		hmc.put("a1","Ali");
		System.out.println(hmc.get("a1"));
		System.out.println("When the mod operation is done, I add 3 element with a key that will have the same index.");	
		hmc.put("a125","Ayse");
		hmc.put("a322","Alihan");
		hmc.put("4164","Burak");
		System.out.println("I controlled all, sequently");
		System.out.println(hmc.get("a125"));
		System.out.println(hmc.get("a322"));
		System.out.println(hmc.get("4164"));
		System.out.println("I am adding a new item with the same key.");
		hmc.put("4164","Not burak is changed");
		System.out.println("Then I check the change");
		System.out.println(hmc.get("4164"));
		System.out.println("I add a few different elements");
		hmc.put("b2","Bülent");
		hmc.put("c1","Cvedet");
		hmc.put("c2","Can");
		System.out.println("Now ý trying remove method");
		System.out.println(hmc.remove("c2"));
		System.out.println(hmc.remove("adfa"));
		System.out.println("Now I'm checking the key I removed");
		System.out.println(hmc.get("c2"));
		
		
	}
	
	
	public static void hashComparison() {
		
		HashMapChaining<Integer,String> hmc=new HashMapChaining<>();
		HashMapChaining<Integer,String> hmo=new HashMapChaining<>();
		
		
		long start=System.currentTimeMillis();				//1.st   x add,x get    x= 10k,40k,75k,100k,150k,180k
		for(int i=0;i<180000;i++) {
			hmc.put(new Integer(i), "aaa");
		}
		for(int i=0;i<180000;i++) {
			
			hmc.get(new Integer(i));
		}


		long end=System.currentTimeMillis();
		long gecenSüre = end - start;
		double saniye = (double)gecenSüre/1000; 
		System.out.println("hmc 1  "+saniye);
		
		long start2=System.currentTimeMillis();				//1.st   x add,x get    x= 10k,40k,75k,100k,150k,180k
		for(int i=0;i<180000;i++) {
			hmo.put(new Integer(i), "aaa");
		}
		for(int i=0;i<180000;i++) {
			
			hmo.get(new Integer(i));
		}

		long end2=System.currentTimeMillis();
		long gecenSüre2 = end2 - start2;
		double saniye2 = (double)gecenSüre2/1000; 
		System.out.println("hmo 1  "+saniye2);
		
	}
	
	
	public static void main(String []args) {
		
		//testMyQuick();   +
		//testMyMerge();    +
		//testQuickSort();   +
		//testShellSort();   +
		//testMergeSort();   +
		//testBubbleSort();   +
		//testInsertionSort();	+
		//testSelectionSort();	+
		//testHeapSort();		
		//testLAS();
		//hashMapChaining();	
		//hashComparison();
		

		
	}
}
