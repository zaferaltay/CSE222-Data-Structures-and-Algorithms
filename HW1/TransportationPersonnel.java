import java.util.Scanner;

/**
 * @author zafer
 * This class keeps transportation personnel information and does some operations
 *
 */
public class TransportationPersonnel extends AbstractUsers {
	
	Scanner scan=new Scanner(System.in);
	/**
	 * This method take tracking number and returns it for changing cargo status.
	 * @return tracking number
	 */
	public int changeCargoStatus() {
		System.out.println("Please enter tracking number");
		return scan.nextInt();
	}
}
