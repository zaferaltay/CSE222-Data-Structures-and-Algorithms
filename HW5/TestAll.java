import java.util.Scanner;

/**
 * @author zafer
 *	Test class of all class
 */
public class TestAll {
	
	
	public static void testFileSystemTree() {
		
	
			System.out.println("First we create the root directory using the constructor.Root name is dir1");
			FileSystemTree fst=new FileSystemTree("dir1");
			System.out.println("We add a directory named dir2 into dir1(using addDir)");
			fst.addDir("dir1/dir2");
			System.out.println("And check it with printFileSytem method");
			fst.printFileSystem();
			System.out.println("Now we add a file named file2.txt into dir(Using addFile)");
			fst.addFile("dir1/dir2/file2.txt");
			System.out.println("Lets check it");
			fst.printFileSystem();
			System.out.println("Now we try add file into the file2.txt(Program should give us a warning message)");
			fst.addFile("dir1/dir2/file2.txt/hdns");
			System.out.println("Now we add directory and file into dir1 again(Using addDir,addFile)");
			fst.addDir("dir1/dir3");
			fst.addFile("dir1/file1.txt");
			System.out.println("Check it");
			fst.printFileSystem();
			System.out.println("We will add some directories and files for the tests");
			fst.addDir("dir1/dir2/dir4");
			fst.addFile("dir1/dir2/dir4/file4.txt");
			fst.addDir("dir1/dir3/dir5");
			fst.addDir("dir1/dir3/dir6");
			fst.addFile("dir1/dir3/file3.txt");
			System.out.println("We print the last version of the system");
			fst.printFileSystem();
			System.out.println("\n Now we will search name that containing 2 using search method.Program should print dir2 and file2");
			fst.search("2");
			System.out.println("\nNow we test remove method firstly we will remove file2 and after that we will remove dir4");
			System.out.println("The program should warn us because dir4 has subfiles,if it does,please select yes");
			fst.remove("dir4");
			System.out.println("Now we print filesystem at the last time for check");
			fst.printFileSystem();		
	
		
	}
	
	
	public static void testAgeSearchTree() {
		
		System.out.println("First of all, we create AgeSearchTree object");
		AgeSearchTree<AgeData> asg=new AgeSearchTree<>(new AgeData(10));
		System.out.println("And we add an item to our tree(Using add method)");
		asg.add(new AgeData(5));
		System.out.println("Now we print the previous results on the screen to test add and toString methods");
		System.out.println("Output should be 10(1)-5(1)-null-null-null");
		System.out.println(asg.toString());
		System.out.println("Now we will add two more elements, but one will be the same as the previous one.(70-10)");
		System.out.println("After adding 10 to 70 we will write on the screen");
		System.out.println("Output should be 10(2)-5(1)-null-null-70(1)-null-null");
		asg.add(new AgeData(70));
		asg.add(new AgeData(10));
		System.out.println("Now we print the tree");
		System.out.println(asg.toString());
		System.out.println("Now we will add a few more elements to test different methods(25(3 times)-20(2 times)-30-75(2 times)) ");
		asg.add(new AgeData(25));
		asg.add(new AgeData(25));
		asg.add(new AgeData(25));
		asg.add(new AgeData(20));
		asg.add(new AgeData(20));		
		asg.add(new AgeData(30));
		asg.add(new AgeData(75));
		asg.add(new AgeData(75));
		System.out.println("Now we print the tree");
		System.out.println("Output should be 10(2)-5(1)-null-null-70(1)-25(3)-20(2)-null-null-30(1)-null-null-75(2)-null-null");
		System.out.println(asg.toString());
		System.out.println("Now we test younger than and older than method");
		System.out.println("We will find the ones older than 20.Output should be 7");
		System.out.println("Output: "+asg.olderThan(20));
		System.out.println("Now we will find the ones younger than 45.Output should be 9");
		System.out.println("Output: "+asg.youngerThan(45));
		System.out.println("\n\n");
		System.out.println("Now we will test the remove method");
		System.out.println("We'll remove 10 first and then 70 first");
		System.out.println("AgeNum of 10 should decrease and 70 should be removed completely");
		System.out.println("We should replace 30 to 70 in order to prevent the tree structure from deteriorating");
		System.out.println("While doing this we should delete 70");
		System.out.println("Now we print tree.Output should be 10(1)-5(1)-null-null-30(1)-25(3)-20(2)-null-null-null-75(2)-null-null");
		asg.remove(new AgeData(10));
		asg.remove(new AgeData(70));
		System.out.println(asg.toString());		
	}

	
	public static void testExpressionTree() {
		System.out.println("First of all, we send a prefix expression to constructor.(+ + 10 * 5 15 20)");
		ExpressionTree<String> exp=new ExpressionTree<>("+ + 10 * 5 15 20");
		System.out.println("Now we print the expression that we sent earlier ,with toString that use preorder traverse.(Output should be + + 10 * 5 15 20)");
		System.out.println("Output: "+exp.toString());
		System.out.println("Now we print the expression that we sent earlier ,with toString2 that use postorder traverse.(Output should be 10 5 15 * + 20 + )");
		System.out.println("Output: "+exp.toString2());
		System.out.println("Now we will test the eval method and print the result on the screen.(Ouput should be 105)");
		System.out.println("Output: "+exp.eval()+"\n\n");
		
		
		System.out.println("Now, we send a postfix expression to constructor.(10 5 15 * + 20 +)");
		ExpressionTree<String> exp2=new ExpressionTree<>("10 5 15 * + 20 +");	
		System.out.println("Now we print the expression that we sent earlier ,with toString that use preorder traverse.(Output should be + 20 + * 15 5 10)");
		System.out.println("Output: "+exp2.toString());
		System.out.println("Now we print the expression that we sent earlier ,with toString2 that use postorder traverse.(Output should be 20 15 5 * 10 + + )");		
		System.out.println("Output: "+exp2.toString2());
		System.out.println("Now we will test the eval method and print the result on the screen.(Ouput should be 105)");
		System.out.println("Output: "+exp2.eval());
		
				
	}
	public static void testMaxHeap() {
		System.out.println("First of all we created an object");
		MaxHeap<AgeData> heap = new MaxHeap<AgeData>();
		System.out.println("Now we will add an element to test the add method (10)");
		heap.add(new AgeData(10)); 
		System.out.println("We print on the screen to see the result using toString method (Output should be 10-1)");
		System.out.println("Output:\n"+heap.toString());
		System.out.println("As we add elements, we add a few more elements to see the changing order.");
		heap.add(new AgeData(5));
		heap.add(new AgeData(70));
		heap.add(new AgeData(10));
		heap.add(new AgeData(50));
		System.out.println("Let's see what we've done so far Output should be 10(2) - 5(1)- 70(1) -50(1)");
		System.out.println("Output:\n"+heap.toString());
		System.out.println("Now we are adding something that will change the index");
		heap.add(new AgeData(5));heap.add(new AgeData(5));
		heap.add(new AgeData(70));heap.add(new AgeData(70));heap.add(new AgeData(70));heap.add(new AgeData(80));
		System.out.println("Let's test our new heap");
		System.out.println("5 must exceed 10,70 should be on top");
		System.out.println("So Output should be 70(4)-10(2)-5(3)-50(1)-80(1)");
		System.out.println("Output:\n"+heap.toString());
		
		System.out.println("Now we test remove method");
		System.out.println("We will delete some elements completely, while we will reduce other number and change their location");
		System.out.println("We will reduce 70 to 3 times and move it over, then delete it");
		heap.remove(new AgeData(70));heap.remove(new AgeData(70));heap.remove(new AgeData(70));
		System.out.println("Output should be 5(3)-10(2)-70(1)-50(1)-80(1)");
		System.out.println("Output:\n"+heap.toString());
		System.out.println("Now we try remove 70 completly");
		heap.remove(new AgeData(70));
		System.out.println("Output should be 5(3)-10(2)-80(1)-50(1)");
		System.out.println("Output:\n"+heap.toString());
		
		System.out.println("Now we test olderThan method for 18");
		System.out.println("Output should be 2");
		System.out.println("Output: "+heap.olderThan(18));
		System.out.println("\nNow we test youngerThan method for 18");
		System.out.println("Output should be 5");
		System.out.println("Output: "+heap.youngerThan(18));
		
		System.out.println("\nNow test find method.We try for 10");
		System.out.println("Output should be 10-2");
		AgeData temp=heap.find(new AgeData(10));
		System.out.println("Output: \n"+temp.getAge()+"-"+temp.getAgeNum());
		
	}
	
	
	public static void main(String[] args) { 
		
		Scanner scan=new Scanner(System.in);
		System.out.println("Which one would you like to test\n1)FileSytemTree\n2)ExpressionTree\n3)AgeSearchTree\n4)MaxHeap");
		int x=scan.nextInt();
		if(x==1) {
			testFileSystemTree();
		}
		else if(x==2) {
			testExpressionTree();
		}
		else if(x==3) {
			 testAgeSearchTree();
		}
		else if(x==4) {
			testMaxHeap();
		}else {
			System.out.println("Invalid input");
		}
	}
	
}
