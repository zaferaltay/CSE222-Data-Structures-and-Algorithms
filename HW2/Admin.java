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
		obj.setTestInter(0);
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
	 * This method take a transportation personnel number and return it.
	 * @return personal number
	 */
	public int removeTransportationPersonnel() {
		System.out.println("Please enter the personnel num");
		return scan.nextInt();
	}

	protected int changeCargoStatus() {
		return -999;
	}
	
	/**
	 * Two parameter constructor
	 * @param name is the new object name
	 * @param num is the new object name
	 */
	Admin(String name,int num){
		this.name=name;
		this.num=num;
	}
	/**
	 * One parameter constructor takes name.(Object num will be 0 automatically)
	 * @param name is the new object name
	 */
	Admin(String name){
		this.name=name;
		this.num=0;
	}
	/**
	 * One parameter constructor takes num.(Object name will be xxxx automatically)
	 * @param num is the new object num
	 */
	Admin(int num){
		this.name="xxxx";
		this.num=num;
	}
	/**
	 * No Parameter Constructor.Object name will be xxxx and num will be 0 automatically
	 */
	Admin(){
		this.name="xxx";
		this.num=0;
	}
}
