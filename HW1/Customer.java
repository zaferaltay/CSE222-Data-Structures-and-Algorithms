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
		System.out.println("Please enter tracking number");
			return scan.nextInt();
	}

	public int getTrackingNum() {
		return trackingNum;
	}

	public void setTrackingNum(int trackingNum) {
		this.trackingNum = trackingNum;
	}
	
}
