import java.util.ArrayList;
import java.util.Scanner;


/**
 * @author zafer
 * This class stores an array containing its branches.
 */
public class CargoCompany implements CCInterface {
	
	private int counterBranch=0;
	protected 	ArrayList<Branch> branchh=new ArrayList<Branch>();	
	String name;
	int num;
	Scanner scan=new Scanner(System.in);
	
	/**
	 * @param obj is returned by the addBranch method of the Admin class
	 * Adds the object to list.
	 */
	public void addBranch(Branch obj){
		int flag=0;
		
		for(int i=0;i<counterBranch;i++) {
			if(obj.branchName.equals(branchh.get(i).branchName)) {
				flag=1;
				System.out.println("Not Valid Branch Name");
			}
			if(obj.getBranchNumber()==branchh.get(i).getBranchNumber()) {
				System.out.println("Not Valid Branch Number");
				flag=1;
			}
		}
		if(flag==0) {
			branchh.add(obj);
		}
	   	counterBranch++;
	}
	
	/**
	 * @param numm is returned by the removeBranch method of the Admin class
	 *  Finds branch number and removes branch if avaliable
	 */
	
	public void removeBranch(int numm){
		int counter=0;
		for(int i=0;i<counterBranch;i++){
			if(numm==branchh.get(i).getBranchNumber()) {
				branchh.remove(i);
				counterBranch--;
				break;
			}
			counter++;
		}
		if (counter==counterBranch) {
			System.out.println("Not valid branch num");
		}
	}
	/**
	 * @param obj is returned by the addBranchEmployee method of the Admin class
	 * Adds the object to list.
	 */
	public void addBranchEmployee(BranchEmployee obj){
		int chc,chc2=0;
		int flag=0;
		System.out.println("Enter the number of the branch you want to add");
		chc=scan.nextInt();
		for(int i=0;i<counterBranch;i++) {
			if(chc==branchh.get(i).getBranchNumber()) {
				chc2=i;
				flag=1;
			}
		}
		if(flag==1)
		branchh.get(chc2).addBranchEmployee(obj);
		else
			System.out.println("Not valid branch num");
	}
	/**
	 * @param num is returned by the removeBranchEmployee method of the Admin class
	 * Finds branch employee number and removes branch employee if avaliable
	 */
	public void removeBranchEmployee(int num){
		for(int i=0;i<counterBranch;i++) {
			branchh.get(i).removeBranchEmployee(num);
		}
	}
	/**
	 * @param obj  is returned by the addTranspotationPersonnel method of the Admin class
	 * Adds the object to array if array list.
	 */
	public void addTransportationPersonnel(TransportationPersonnel obj) {
		int chc,chc2=0;
		int flag=0;
		System.out.println("Enter the number of the branch you want to add");
		chc=scan.nextInt();
		for(int i=0;i<counterBranch;i++) {
			if(chc==branchh.get(i).getBranchNumber()) {
				chc2=i;
				flag=1;
			}
		}
		if(flag==1)
		branchh.get(chc2).addTransportationPersonnel(obj);
		else
			System.out.println("Not Valid Branch Num");
	}
	/**
	 * @param num is returned by the removeBranchEmployee method of the Admin class
	 * Finds branch employee number and removes TransportationPersonnel if avaliable
	 */
	public void removeTransportationPersonnel(int num) {
		for(int i=0;i<counterBranch;i++) {
			branchh.get(i).removeTransportationPersonnel(num);
		}
	}
	/**
	 * @return counter of branch
	 */
	public int getCounterBranch() {
		return counterBranch;
	}

	/**
	 *toString method for CargoCompany
	 */
	public String toString(){
	  for(int i=0;i<counterBranch;i++) {System.out.printf("%d. Branch : %s",i+1,branchh.get(i).getBranchName());}
		return "";
	}

}
