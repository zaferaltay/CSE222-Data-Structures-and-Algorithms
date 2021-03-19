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
		return 2;
	}
	
	/**
	 *toString method for TransporttaionPersonnel
	 */
	public String toString(){
			return String.format("Name : %s", name);
		}
	TransportationPersonnel(String name,int num){
		this.name=name;
		this.num=num;
	}
	TransportationPersonnel(String name){
		this.name=name;
		this.num=0;
	}
	TransportationPersonnel(int num){
		this.name="xxxx";
		this.num=num;
	}
	TransportationPersonnel(){
		this.name="xxx";
		this.num=0;
	}
}
