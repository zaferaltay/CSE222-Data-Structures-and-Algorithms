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
	     System.out.println("Please enter the tracking number");
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
}