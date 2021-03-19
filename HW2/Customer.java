import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * @author zafer
 *This class keeps and sharing customer information
 */
public class Customer extends AbstractUsers {

	Scanner scan=new Scanner(System.in);
	private int trackingNum;
	
	/**
	 * This method take tracking number and return for controls shipment status
	 * @return tracking number
	 */
	public int controlCargo() {
		int x = 0;
		System.out.println("Please enter tracking number");
			x=scan.nextInt();
			return x;
	}

	public int getTrackingNum() {
		return trackingNum;
	}

	public void setTrackingNum(int trackingNum) {
		this.trackingNum = trackingNum;
	}
	/**
	 *toString method for Customer
	 */
	public String toString(){
		return String.format("Name : %s", name);
	}
	Customer(String name,int num){
		this.name=name;
		this.num=num;
	}
	Customer(String name){
		this.name=name;
		System.out.println("Please enter branch employee num");
		this.num=scan.nextInt();
	}
	Customer(int num){
		System.out.println("Please enter branch employee name");
		this.name=scan.next();
		this.num=num;
	}
	Customer(){
		System.out.println("Please enter customer name");		
		this.name=scan.next();
		System.out.println("Please enter customer num");		
		this.num=scan.nextInt();
	}
}
