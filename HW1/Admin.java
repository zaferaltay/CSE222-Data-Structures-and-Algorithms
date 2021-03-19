import java.util.Scanner;

/**
 * @author zafer
 *	This class is doing the operations of the administrator user
 *
 */

public class Admin extends AbstractUsers {
	
	Scanner scan=new Scanner(System.in);
	
	
	/**
	 * This method creates a branch class object and returns it for adding object array
	 * @return Branch object
	 */
	public Branch addBranch(){
		Branch obj=new Branch();
		System.out.println("Please enter branch name");
		obj.setBranchName(scan.next());
		System.out.println("Please enter branch number");
		obj.setBranchNumber(scan.nextInt());
		return obj;		
	}	
	/**
	 *  This method take a branch number and return it.
	 * @return branch num
	 */
	public int removeBranch(){
		System.out.println("Please enter the branch num");
		return scan.nextInt();
	}
	/**
	 * This method creates a branch employee object and returns it for adding object array
	 * @return branch employee object
	 */
	public BranchEmployee addBranchEmployee(){
		BranchEmployee obj = new BranchEmployee();
		System.out.println("Please enter branch employee name");
		obj.setName(scan.next());
		System.out.println("Please enter the branch employee num");
		obj.setNum(scan.nextInt());		
		return obj;
	}	
	/**
	 * This method take a branch employee number and return it.
	 * @return branch employee number
	 */
	public int removeBranchEmployee(){						
		System.out.println("Please enter the branch employee num");
		return scan.nextInt();
	}
	/**
	 *  This method creates a transportation personnel  object and returns it for adding object array
	 * @return transportation personnel object
	 */
	public TransportationPersonnel addTranspotationPersonnel(){
		TransportationPersonnel obj=new TransportationPersonnel();
		System.out.println("Please enter transportation personal name");
		obj.setName(scan.next());
		System.out.println("Please enter the transportation personal num");
		obj.setNum(scan.nextInt());	
		return obj;
	}
	/**
	 * This method take a trasnportation personnel number and return it.
	 * @return personal number
	 */
	public int removeTransportationPersonnel() {
		System.out.println("Please enter the personnel num");
		return scan.nextInt();
	}
}
