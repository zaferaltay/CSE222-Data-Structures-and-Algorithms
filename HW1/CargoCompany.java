import java.util.Scanner;


/**
 * @author zafer
 * This class stores an array containing its branches.
 */
public class CargoCompany {
	
	private int brMax=20;
	private int counterBranch=0;
	protected Branch []branchh=new Branch[brMax];
	String name;
	int num;
	Scanner scan=new Scanner(System.in);
	
	/**
	 * @param obj is returned by the addBranch method of the Admin class
	 * Adds the object to array if array fills up, it opens new array and uses it.
	 */
	public void addBranch(Branch obj){
		branchh[counterBranch]=obj;
	   	counterBranch++;
		 if(counterBranch==brMax) {
		 	brMax*=2;
		 	Branch []branchh2=new Branch[brMax];
		 	for(int i=0;i<counterBranch;i++) {
		 		branchh2[i]=branchh[i];
		 	}
		 	branchh=branchh2;
		 }
	}
	
	/**
	 * @param numm is returned by the removeBranch method of the Admin class
	 *  Finds branch number and removes branch
	 */
	
	public void removeBranch(int numm){
		for(int i=0;i<counterBranch;i++){
			if(numm==branchh[i].getBranchNumber()) {
				num=i;
			}
		}
		for(int j=num;j<brMax-1;j++) {
			branchh[j]=branchh[j+1];
		}
		counterBranch--;
	}
	/**
	 * @param obj is returned by the addBranchEmployee method of the Admin class
	 * Adds the object to array if array fills up, it opens new array and uses it.
	 */
	public void addBranchEmployee(BranchEmployee obj){
		int chc,chc2=0;
		System.out.println("Enter the number of the branch you want to add");
		chc=scan.nextInt();
		for(int i=0;i<counterBranch;i++) {
			if(chc==branchh[i].getBranchNumber()) {
				chc2=i;
			}
		}
		branchh[chc2].addBranchEmployee(obj);
	}
	/**
	 * @param num is returned by the removeBranchEmployee method of the Admin class
	 * Finds branch employee number and removes branch employee
	 */
	public void removeBranchEmployee(int num){
		for(int i=0;i<counterBranch;i++) {
			branchh[i].removeBranchEmployee(num);
		}
	}
	/**
	 * @param obj  is returned by the addTranspotationPersonnel method of the Admin class
	 * Adds the object to array if array fills up, it opens new array and uses it.
	 */
	public void addTranspotationPersonnel(TransportationPersonnel obj) {
		int chc,chc2=0;
		System.out.println("Enter the number of the branch you want to add");
		chc=scan.nextInt();
		for(int i=0;i<counterBranch;i++) {
			if(chc==branchh[i].getBranchNumber()) {
				chc2=i;
			}
		}
		branchh[chc2].addTransportationPersonnel(obj);
	}
	/**
	 * @param num is returned by the removeBranchEmployee method of the Admin class
	 * Finds branch employee number and removes TransportationPersonnel
	 */
	public void removeTransportationPersonnel(int num) {
		for(int i=0;i<counterBranch;i++) {
			branchh[i].removeTransportationPersonnel(num);
		}
	}
	/**
	 * @return counter of branch
	 */
	public int getCounterBranch() {
		return counterBranch;
	}



}
