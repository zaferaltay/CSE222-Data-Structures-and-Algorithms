import java.util.Scanner;

/**
 * @author zafer
 *	This class keeps branch employee information and does some operations
 */
public class BranchEmployee extends AbstractUsers {

	Scanner scan=new Scanner(System.in);
	
	 /**
	 * @return tracking number of cargos
	 */
	public int changeCargoStatus(){
		 System.out.println("Please select cargo status \n0-> is in branch\n1->package has left from branch \n2->package has delivered");
		 return  scan.nextInt(); 
	 }
	 /**
	  * This method creates and returns the Customer class object for adding array
	 * @return customer Object
	 */
	public Customer addCustomer(){
		 Customer obj =new Customer();
		 System.out.println("Please enter customer name");
		 obj.setName(scan.next());
		 System.out.println("Please enter customer id");
		 obj.setNum(scan.nextInt());
		 System.out.println("Please enter tracking num");
		 obj.setTrackingNum(scan.nextInt());
		 return obj;
	 }
	 /**
	  * This method take a customer id and return it.
	 * @return customer id
	 */
	public int removeCustomer() {
		 System.out.println("Please enter the customer id");
		 return scan.nextInt();
	 }
	 /**
	  * This method creates and returns the cargo object for adding array
	 * @return cargo object
	 */
	public Cargo addCargo(){
	
		 Cargo obj = new Cargo();
		 System.out.println("Please enter tracking num");
		 obj.setTrackingNumber(scan.nextInt());
		 System.out.println("Please enter reciever name");
		 obj.setRecieverName(scan.next());
		 System.out.println("Please enter sender name");
		 obj.setSenderName(scan.next());
		 System.out.println("Please enter current status(0-1-2)");
		 obj.setCurrentStatus(scan.nextInt());
		 return obj;
		
	
	 }
	/**
	 *toString Method for BranchEmployee
	 */
	public String toString(){
		return String.format("Name : %s", name);
	}
	/**
	 * Two parameter constructor
	 * @param name is the new object name
	 * @param num is the new object name
	 */
	BranchEmployee(String name,int num){
		this.name=name;
		this.num=num;
	}
	/**
	 * One parameter constructor takes name.
	 * @param name is new BE name
	 */
	BranchEmployee(String name){
		this.name=name;
		System.out.println("Please enter branch employee num");
		this.num=scan.nextInt();
	}
	/**
	 * One parameter constructor takes num
	 * @param num is new BE num
	 */
	BranchEmployee(int num){
		System.out.println("Please enter branch employee name");
		this.name=scan.next();
		this.num=num;
	}
	/**
	 * NoPramater Constructor
	 */
	BranchEmployee(){
		System.out.println("Please enter branch employee name");		
		this.name=scan.next();
		System.out.println("Please enter branch employee num");		
		this.num=scan.nextInt();
	}

}