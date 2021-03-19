import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author zafer
 *	This class keep employees,customer and shipments informations in arrays and does some operation
 */
public class Branch implements CCInterface {
	
  
  public int testInter;	
  protected String branchName;
  protected int branchNumber;
  public int counterCargoNumber=0;

  
  
  protected ArrayList<AbstractUsers> personel=new ArrayList<AbstractUsers>();
  protected ArrayList<Cargo> cargos=new ArrayList<Cargo>();
  
  int status,bcount,ccount,tcount,flag=0;
  Scanner scan=new Scanner(System.in);
 
  /**
   * The method tells shipments status to us
 * @param x  is returned by the controlCargo method of the customer class
 */
public void controlCargo(int x) {
			
			do {
			  if(cargos.get(x).getCurrentStatus()==0) {
				  System.out.println("Your package is in branch yet");
			  }
			  else if(cargos.get(x).getCurrentStatus()==1) {
				  System.out.println("Your package has left the branch");
			  }
			  else if(cargos.get(x).getCurrentStatus()==2) {
				  System.out.println("Package delivered");
			  }
			  else
				  x=scan.nextInt();
			  }while(x<2);
		
  }
  /**
   * Adds the object to list.
 * @param obj  is returned by the addCargo method of the BranchEmployee class
 * 
 */
public void addCargo(Cargo obj){
	int fla=1; 
	for(int i=0;i<cargos.size();i++) {
		  if(obj.getTrackingNumber()==cargos.get(i).getTrackingNumber()) {
			  fla=0;
			  System.out.println("Not Vlid Tracking Number try again");
		  }
	  }
	  if(fla==1) {
			cargos.add(obj);
			  counterCargoNumber++; 
	  }
	
  }
  /**
   * This method changes cargo status
 * @param tNumber is returned by the changeCargoStatus method of the BE and TP class
 */
public void changeCargoStatus(int tNumber,int status){
	int flaggg=0;
	
	for(int i=0;i<counterCargoNumber;i++){
		 if(cargos.get(i).getTrackingNumber()==tNumber) {
			 this.status=status;
			 flaggg=1;
		 }
	 }
	if(flaggg==0)
		System.out.println("Not valid tracking number");
  }
  /**
 * @param obj is returned by the addBranchEmployee method of admin class
 * Adds the object to list.
 */
public void addBranchEmployee(BranchEmployee obj) {
	 int flagg=0;   
	 for(int i=0;i<personel.size();i++) {
	    	if(obj.getNum()==personel.get(i).getNum()) {
	    		System.out.println("Not Valid B.E Number try again");
	    		flagg=1;
	    	}
	    }
		if(flagg==0)
	    	personel.add(obj);
  }
 
  /**
 * @param beNum is returned by the removeBranchEmployee method of admin class
 * Finds branch employee number if available and removes branch
 */
public void removeBranchEmployee(int beNum){
	  for(int i=0;i<personel.size();i++){
		  if(personel.get(i) instanceof BranchEmployee) {
		    if(beNum==personel.get(i).getNum()){
			   bcount=i;
			   flag=1;
		     }
	    }
	  }
	  if(flag==1) {
		personel.remove(bcount); 
	    flag=0;
	  }
	  else {
		  System.out.println("Not valid BE number");
	  }
  }
  
  /**
 * @param obj is returned by the addTransportationPersonnel method of admin class
 * Adds the object to list.
 */
public void addTransportationPersonnel(TransportationPersonnel obj) {
	 int flagg=0;   
	 for(int i=0;i<personel.size();i++) {
	    	if(obj.getNum()==personel.get(i).getNum()) {
	    		System.out.println("Not Valid T.P Number try again");
	    		flagg=1;
	    	}
	    }
		if(flagg==0)
	    	personel.add(obj);
  }
  /**
 * @param teNum is returned by the removeBranchEmployee method of admin class
 * Finds transportation personnel number if available and removes branch
 */
public void removeTransportationPersonnel(int teNum){
	  for(int i=0;i<personel.size();i++){
		 if(personel.get(i) instanceof TransportationPersonnel) {
			  if(teNum==personel.get(i).getNum()){
				  tcount=i;
				  flag=1;
			  }	 
		 }
	  }
	  if(flag==1) {
	    personel.remove(tcount); 
        flag=0;
	  }
	  else {
		  System.out.println("Not Valid TP Number");
	  }
  }
  public String getBranchName() {
	return branchName;
  }
  public void setBranchName(String branchName){
	  
	  this.branchName = branchName;
  }
  public int getBranchNumber() {
	return branchNumber;
  }
  public void setBranchNumber(int branchNumber) {
	this.branchNumber = branchNumber;
  }

  /**
 * @param obj is returned by the addCustomer method of BranchEmployee class
 * Adds the object to list.
 * 
 */
public void addCustomer(Customer obj){
	
		personel.add(obj);

	 Cargo obj2=new Cargo();
	 obj2.setRecieverName(obj.getName());
	   if(testInter==0) {
			  System.out.println("Please enter sender name");
			  obj2.setSenderName(scan.next());		   
	   }
	   else {
		   obj2.setSenderName("xxx");
	   }
	  obj2.setTrackingNumber(obj.getTrackingNum());
	  obj2.setCurrentStatus(0);
	  this.addCargo(obj2);  
  }
/**
 * @param cid is returned by the removeBranchEmployee method of customer class
 * Finds transportation personnel number if available and removes branch
 * 
 */
public void removeCustomer(int cid){
	  for(int i=0;i<personel.size();i++) {
		 if(personel.get(i) instanceof Customer) {
			  if(cid==personel.get(i).getNum()) {
				  ccount=i;
				  flag=1;
			  }			 
		 }
	  }
	  if(flag==1) {
		  personel.remove(ccount);
		  flag=0;
	  }
	  else {
		  System.out.println("Not valid Customer Id");
	  }
	  
  }

  public int getCounterCargoNumber() {
	return counterCargoNumber;
 }

public void setTestInter(int testInter) {
	this.testInter = testInter;
}
 
 
 public int getPersonalNum() {
	 
	 return personel.size();
 }
  
 /**
 * toString method for branch
 */
public String toString(){
	 System.out.printf("Branch Name: %s\nBranch Number: %d\n",branchName,branchNumber);
	 for(int i=0;i<personel.size();i++) {
		 if(personel.get(i) instanceof BranchEmployee) {
			 System.out.printf("Branch Employee Name : %s Branch Employe Num : %d\n",personel.get(i).getName(),personel.get(i).getNum());
		 }
	 }
	 
	 for(int i=0;i<personel.size();i++) {
         if(personel.get(i) instanceof TransportationPersonnel) {
		     System.out.printf("Transportation Personnel Name : %s Transportation Personnel Num : %d\n",personel.get(i).getName(),personel.get(i).getNum());
	    }
     }
	 for(int i=0;i<personel.size();i++) {
         if(personel.get(i) instanceof Customer) {
		     System.out.printf("Customer Name : %s",personel.get(i).getName());
	    }
     } 
	 
	 return String.format("");
 }
 
	/**
	 * Two parameter Constructor
	 * @param name is object name
	 * @param num is object num
	 */
	Branch(String name,int num){
		this.branchName=name;
		this.branchNumber=num;
	}
	/**
	 * One parameter constructor takes name.
	 * @param name is new branch name
	 */
	Branch(String name){
		this.branchName=name;
		System.out.println("Please enter a branch num");
		this.branchNumber=scan.nextInt();
	}
	/**
	 * One parameter constructor takes num.
	 * @param num is new branch num
	 */
	Branch(int num){
		System.out.println("Please enter a branch name");
		this.branchName=scan.next();
		this.branchNumber=num;
	}
	/**
	 * No parameter consructor.
	 */
	Branch(){
		System.out.println("Please enter a branch name");
		this.branchName=scan.next();
		System.out.println("Please enter a branch num");
		this.branchNumber=scan.nextInt();

	}
 
}
