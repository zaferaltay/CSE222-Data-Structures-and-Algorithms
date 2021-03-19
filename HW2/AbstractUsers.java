import java.util.Scanner;

/**
 * @author zafer
 *	This class is abstract class for users keeps name and number
 */
public abstract class AbstractUsers {
	protected String name;
	protected int num;
	Scanner scan=new Scanner(System.in);

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	/**
	 * 	This Function for inheritance classes if they want to use they need to override
	 * @return  a pointless number
	 */
	public int getTrackingNum(){
		return -999;
	}
	/**
	 * This Function for inheritance classes if they want to use they need to override
	 * @return any object
	 */
	protected  Customer addCustomer() {
		return new Customer();
	}
	/**
	 * This Function for inheritance classes if they want to use they need to override
	 * @return a pointless number
	 */
	protected  int removeCustomer() {
		return -999;
	}
	/**
	 *  In this method you determine the cargo status
	 * @return the status
	 */
	protected int changeCargoStatus() {
		 System.out.println("Please select cargo status \n0-> is in branch\n1->package has left from branch \n2->package has delivered");
		 return  scan.nextInt(); 
	}	
}
