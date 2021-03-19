import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListSet;

public class AllTests {
	public static void test2() {
		KWSkipList<Integer> sl=new KWSkipList<>(3,1);
		
		System.out.println("First I set a skipList with a maximum of 3 and a minimum of 1 ");
		System.out.println("Now, we add elements in an unordered manner, these will be in the middle of the list, between and to the beginning.(T01)");
		
		
		sl.add(new Integer(40));
		sl.add(new Integer(30));
		sl.add(new Integer(20));
		sl.add(new Integer(50));
		sl.add(new Integer(90));
		sl.add(new Integer(60));
		System.out.println("Now we print them on the screen\n");
		sl.toString();
		System.out.println("\nWe add a few more elements to see the change of node numbers(T02)");
		sl.add(new Integer(1));
		sl.add(new Integer(11));
		sl.add(new Integer(18));
		sl.add(new Integer(16));
		sl.add(new Integer(111));
		sl.add(new Integer(123));
		sl.toString();
		System.out.println("\n\n");
		System.out.println("Now I test whether the same element is added or not(T03)");
		sl.add(new Integer(40));
		sl.toString();
		System.out.println("\n\n");
		
		
		
		System.out.println("\nNow we will delete a few elements,so the node numbers will also change(T04)\n");
		sl.remove(new Integer(123));
		sl.remove(new Integer(16));
		sl.remove(new Integer(50));
		sl.remove(new Integer(30));
		sl.remove(new Integer(11));
		
		sl.toString();	
	}

	public static void test3() {
		BinarySearchTree<Integer> bst= new BinarySearchTree<>();
		KWSkipList<Integer> kwsl=new KWSkipList<>(5,1);
		RedBlackTree<Integer> rbt=new RedBlackTree<>();
		SkipList<Integer> bksl=new SkipList<>();
		ConcurrentSkipListSet<Integer> csls =new ConcurrentSkipListSet<>();
		TreeSet<Integer> rbj=new TreeSet<>();
		Random r=new Random();
		
		

	for(int p=0;p<10;p++) {
		System.out.println("\n");
		long start=System.currentTimeMillis();
		for(int i=0;i<80000;i++) {
			csls.add(new Integer(r.nextInt()));
		}
		long end=System.currentTimeMillis();
		long gecenSüre = end - start;
		double saniye = (double)gecenSüre/1000; 
				
		System.out.println("full ekleme  "+saniye);
		
		Integer eklenenarray[] =new Integer[10];
		for(int i=0;i<10;i++) {
			eklenenarray[i]=new Integer(r.nextInt());
		}
		
		long start2=System.nanoTime();
		for(int i=0;i<10;i++) {
			csls.add(eklenenarray[i]);
		}
		long end2=System.nanoTime();
		long gecenSüre2 = end2 - start2;
		double saniye2 = (double)gecenSüre2/1000; 
				
		System.out.println("10 ekleme "+saniye2);
		
		long start3=System.nanoTime();
		for(int i=0;i<10;i++) {
			csls.remove(eklenenarray[i]);
		}
		long end3=System.nanoTime();
		long gecenSüre3 = end3 - start3;
		double saniye3 = (double)gecenSüre3/1000; 
				
		System.out.println("10 silme "+saniye3);
		
	}
	}
	
	
	public static void test4() {
		Scanner scan=new Scanner(System.in);
		Scanner scan2=new Scanner(System.in);
		String PASSWORD="ZAF2016";
		String name; 
		System.out.println("Which tree do you want try\n1-)Red Black Tree\n2-)Binary Search Tree\n3-)Avl Tree");
		int tree=scan.nextInt();
		if(tree!=1 && tree!=2 && tree!=3) {
			System.out.println("Invalid choice");
		}
		SoftwareStore sw=new SoftwareStore(tree);
		
		
		
		System.out.println("Which way would you like to login");
		System.out.println("1-)Admin\n2-)Customer\n");
		int login=scan.nextInt();
		if(login==1) {
			System.out.println("Please enter the password");
			Scanner scan3=new Scanner(System.in);
			String password=scan3.next();
			if(password.equals(PASSWORD)){
				
				int menus;
				do {
					System.out.println("Which one do you want");
					System.out.println("1-)Add Program\n2-)Delete program\n3-)Update Information\n4-)Search Program by name\n5-)Exit");
					Scanner scan4=new Scanner(System.in);
					menus=scan4.nextInt();
					if(menus==1) {
						System.out.println("What is the program name");
						name=scan2.nextLine();
						sw.add(name);
					}
					else if(menus==2) {
						System.out.println(sw.toString());
						System.out.println("Which one do you to delete");
						name=scan2.nextLine();
						sw.remover(name);
					}
					else if(menus==3) {
						sw.updateInformation();
					}
					else if(menus==4) {
						System.out.println("Please enter program name");
						name=scan2.nextLine();
						sw.finder(name);
					}
					else if(menus!=5) {
						System.out.println("Invalid choice try again");
					}
				}while(menus!=5);
				
			}
			else {
				System.out.println("Invalid password");
			}
			
			
			
		}
		else if(login==2) {

			int x; 
			
			do {
				System.out.println("Which one do you want");
				System.out.println("1-)Search program by name\n2-)Exit");
				Scanner scan4=new Scanner(System.in);
				x=scan4.nextInt();
				if(x==1) {
						System.out.println("Please enter program name");
						name=scan2.nextLine();
						sw.finder(name);		
				}
				else if(x!=2) {
					System.out.println("Invalid choice try again");
				}
			}while(x!=2);

			
		}
		else {
			System.out.println("Invalid choice");
		}
		
		

		
		
		
	}
	
	public static void test4driver() {
		SoftwareStore sw=new SoftwareStore(2);
		System.out.println("First we created a new store");
		System.out.println("I write the whole tree on the screen to check the packages we created automatically(T0)");
		System.out.println(sw.toString());
		System.out.println("Now, by testing the deletion method, I remove photoshop6.2 from the programs.(T1)");
		sw.remover("Adobe Photoshop 6.2");
		System.out.println("I test again to see the results.");
		System.out.println(sw.toString());
		System.out.println("Now I'm testing the adding method(T2)");
		sw.add("My Program");
		System.out.println("I'm testing to see it added");
		System.out.println(sw.toString());
		System.out.println("Now I'm testing the search method(T3)");
		sw.finder("Norton 4.5");
		System.out.println("We are testing the information update method now");
		System.out.println("First, we change the price of one of the programs and test its new version.(T4)");
		sw.updateInformation();
		
		System.out.println("Now we are looking at the latest version of a program that we have increased quantity(T5)");
		sw.updateInformation();
		
		System.out.println("Now we are drastically reducing the number of programs(T6)");
		sw.updateInformation();
	
		
	}
	
	public static void main(String[] args) {
		
		//test4driver();
		//test4();
		//test3();
		test2();
		
	}

}