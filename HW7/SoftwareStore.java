import java.util.Scanner;

/**
 * @author zafer
 *Class that works on all trees that implement the Search Tree interface, including the price, quantity, and name of applications.
 */
public class SoftwareStore implements SearchTree {
	
	/**
	 * @author zafer
	 * Node holding the price, quantity and name of 1 app
	 *
	 */
	private static class softwareProgram implements Comparable {
		String name;
		double price;
		int  quantity;
		softwareProgram(String name,double price,int quantity){
			this.name=name;
			this.price=price;
			this.quantity=quantity;
		}
		/**
		 *Compares the names of the applications
		 */
		@Override
		public int compareTo(Object arg0) {
			return name.compareTo(((softwareProgram)arg0).name);
		}

		public String toString() {
			return "App name: "+name + "\nPrice: "+new Double(price).toString()+" Dollars \nPiece:" +new Integer(quantity).toString()+" pieces in stock" ;
		}
	}
	
	SearchTree<softwareProgram> dataTree;
	Scanner scan=new Scanner(System.in);
	/**
	 * @param type type num of tree.
	 * Constructs a tree according to the number it receives.
	 * Creates automatic elements.
	 */
	SoftwareStore(int type){
		if(type==1) {
			dataTree= new RedBlackTree<>();
			
		}
		else if(type==2) {
			dataTree=new BinarySearchTree<>();
		}
		else if(type==3) {
			dataTree= new AVLTree<>();
		}
		
		softwareProgram temp=new softwareProgram("Adobe Photoshop 6.0",25.99,1);
		softwareProgram temp1=new softwareProgram("Adobe Photoshop 6.2",30,1);
		softwareProgram temp2=new softwareProgram("Norton 4.5",15.99,1);
		softwareProgram temp3=new softwareProgram("Norton 5.5",19.99,1);
		softwareProgram temp4=new softwareProgram("Adobe Flash 3.3",20,1);
		softwareProgram temp5=new softwareProgram("Adobe Flash 4.0",27.50,1);
		dataTree.add(temp);
		dataTree.add(temp1);
		dataTree.add(temp2);
		dataTree.add(temp3);
		dataTree.add(temp4);
		dataTree.add(temp5);
	}

	/**
	 *If the item to be added is in the tree, it increases the amount, otherwise it creates a new item and adds it to the tree.
	 */
	@Override
	public boolean add(Object item) {
		
		String a=(String)item;
		softwareProgram temp=dataTree.find(new softwareProgram(a,0 ,0));
		if(temp!=null) {
			((softwareProgram)temp).quantity++;
			return true;
		}else {
			System.out.println("Enter price");		
			double price=scan.nextDouble();
			System.out.println("How many do you want to add");
			int many=scan.nextInt();
			return dataTree.add(new softwareProgram(a,price ,many));
		}
	}

	/**
	 *Uses the method of the tree.
	 */
	@Override
	public boolean contains(Object target) {
	
		return dataTree.contains((softwareProgram)target);
	}

	/**
	 * Uses the method of the tree.
	 * If the tree's method returns null, it is not in the tree.
	 * Shows properties of the rotating object if not null.
	 *
	 */
	@Override
	public Object find(Object target) {	
		String a=(String)target;
		
		softwareProgram temp=((softwareProgram)dataTree.find(new softwareProgram(a,1,2)));
		if(temp==null) {
			System.out.println("The item is not in stock");
			return null;
		}
		else {
			System.out.println(temp.toString());
			return temp;
		}
	}

	/**
	 *Returns null if the object you are looking for is not in the tree, and reduces it by 1 if any.
	 *If its amount is 0, it completely removes it from the tree.
	 */
	@Override
	public boolean remove(Object target) {
		softwareProgram temp=dataTree.find((softwareProgram)target);
		if(temp!=null) {
			((softwareProgram)temp).quantity--;
			if(((softwareProgram)temp).quantity==0) {
				dataTree.remove((softwareProgram)temp);
			}
			return true;
		}else {
			return false;
		}
	}

	/**
	 * Lists the features that the manager can do and applies them according to the request of the admin.
	 */
	public void updateInformation(){
		System.out.println(dataTree.toString());
		System.out.println("Please enter a name");
		Scanner scan3=new Scanner(System.in);
		String a=scan3.nextLine();
		softwareProgram temp=dataTree.find(new softwareProgram(a,1,1));
		if(temp==null) {
			System.out.println("The program not in stock");
			return;
		}
		System.out.println("What do you want \n1-)Add in stock\n2-)Remove from stock\n3-)Sell\n4-)Update price");
		Scanner scan2=new Scanner(System.in);
		int choice=scan2.nextInt();
		if(choice==1) {
			System.out.println("How many do you want to add");
			int adder=scan2.nextInt();
			temp.quantity=temp.quantity+adder;
		}
		else if(choice==2) {
			System.out.println("How many do you want to remove");
			int adder=scan2.nextInt();
			temp.quantity=temp.quantity-adder;
			if(temp.quantity<=0) {
				System.out.println("The program removed from stock completely");
				dataTree.remove(new softwareProgram(a,0,0));
				return;
			}
		}
		else if(choice==3) {
			temp.quantity--;
		}
		else if(choice==4) {
			System.out.println("How much money new price of program");
			double neww=scan2.nextDouble();
			temp.price=neww;
		}
		else {
			System.out.println("Invalid choice");
		}
		
		System.out.println("Last status of program");
		System.out.println(temp.toString());
	}
	
	
	
	
	public String toString() {
		return dataTree.toString();
	}
	
	
	/**
	 * @param name is name of the wanted element
	 * Creates an object with this name for the Find method.
	 */
	public void finder(String name) {
		System.out.println(dataTree.find(new softwareProgram(name,1,2)));

	}
	/**
	 * @param name is name of the wanted element
	 * @return Returns whatever the remove method of the tree returns to.
	 * 
	 * Creates an object for the remove method
	 */
	public boolean remover(String name) {
		return remove(new softwareProgram(name,0,0));
	}
	
	
}
