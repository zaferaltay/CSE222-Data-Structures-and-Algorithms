import java.util.Scanner;

/**
 * @author zafer
 *	This class keep employees,customer and shipments informations in arrays and does some operation
 */
public class Branch {
	
  private int bMax=20,cMax=20,tMax=20,cuMax=20;
  protected String branchName;
  protected int branchNumber;
  public int counterTransportationPersonnel=0;
  public int counterBranchEmployee=0;
  public int counterCargoNumber=0;
  public int counterCustomer=0;
  protected BranchEmployee []bEmployee=new BranchEmployee[bMax];
  protected TransportationPersonnel []tPersonnel= new TransportationPersonnel[tMax];
  protected Cargo []cargos= new Cargo[cMax];
  protected Customer []customers =new Customer[cuMax];
  
  int status,bcount,ccount,tcount,flag=0;
  Scanner scan=new Scanner(System.in);
 
  /**
   * The method tells shipments status to us
 * @param x  is returned by the controlCargo method of the customer class
 */
public void controlCargo(int x) {

			  if(cargos[x].getCurrentStatus()==0) {
				  System.out.println("Your package is in branch yet");
			  }
			  else if(cargos[x].getCurrentStatus()==1) {
				  System.out.println("Your package has left the branch");
			  }
			  else if(cargos[x].getCurrentStatus()==2) {
				  System.out.println("Package delivered");
			  }
	
  }
  /**
   * Adds the object to array if array fills up, it opens new array and uses it.
 * @param obj  is returned by the addCargo method of the BranchEmployee class
 * 
 */
public void addCargo(Cargo obj){
	  cargos[counterCargoNumber++]=obj;
	  if(counterCargoNumber==cMax){
		  cMax*=2;
		  Cargo []cargos2=new Cargo[bMax];
		  for(int i=0;i<counterCargoNumber;i++) {
			  cargos2[i]=cargos[i];
		  }
		  cargos=cargos2;
	  }
	  
  }
  /**
   * This method changes cargo status
 * @param tNumber is returned by the changeCargoStatus method of the BE and TP class
 */
public void changeCargoStatus(int tNumber){
	 for(int i=0;i<counterCargoNumber;i++){
		 if(cargos[i].getTrackingNumber()==tNumber) {
			 System.out.println("Please select cargo status \n0-> is in branch\n1->package has left from branch \n2->package has delivered");
			 status=scan.nextInt();
		 }
	 }
  }
  /**
 * @param obj is returned by the addBranchEmployee method of admin class
 * Adds the object to array if array fills up, it opens new array and uses it.
 */
public void addBranchEmployee(BranchEmployee obj) {
	  bEmployee[counterBranchEmployee++]=obj;
	  if(counterBranchEmployee==bMax){
		  bMax*=2;
		  BranchEmployee []bEmployee2=new BranchEmployee[bMax];
		  for(int i=0;i<counterBranchEmployee;i++) {
			  bEmployee2[i]=bEmployee[i];
		  }
		  bEmployee=bEmployee2;
	  }
  }
 
  /**
 * @param beNum is returned by the removeBranchEmployee method of admin class
 * Finds branch employee number and removes branch
 */
public void removeBranchEmployee(int beNum){
	  for(int i=0;i<counterBranchEmployee;i++){
		  if(beNum==bEmployee[i].getNum()){
			  bcount=i;
			  flag=1;
		  }
	  }
	  if(flag==1) {
	  for(int j=bcount;j<bMax-1;j++) {
		  bEmployee[j]=bEmployee[j+1];
	  }
	  counterBranchEmployee--;
	  flag=0;
	  }
  }
  
  /**
 * @param obj is returned by the addTransportationPersonnel method of admin class
 * Adds the object to array if array fills up, it opens new array and uses it.
 */
public void addTransportationPersonnel(TransportationPersonnel obj) {
	  tPersonnel[counterTransportationPersonnel++]=obj;
	  if(counterTransportationPersonnel==tMax){
		  tMax*=2;
		  TransportationPersonnel []tPersonnel2=new TransportationPersonnel[bMax];
		  for(int i=0;i<counterTransportationPersonnel;i++) {
			  tPersonnel2[i]=tPersonnel[i];
		  }
		  tPersonnel=tPersonnel2;
	  }
  }
  /**
 * @param teNum is returned by the removeBranchEmployee method of admin class
 * Finds transportation personnel number and removes branch
 */
public void removeTransportationPersonnel(int teNum){
	  for(int i=0;i<counterTransportationPersonnel;i++){
		  if(teNum==tPersonnel[i].getNum()){
			  tcount=i;
			  flag=1;
		  }
	  }
	  if(flag==1) {
	   for(int j=tcount;j<tMax-1;j++) {
		  tPersonnel[j]=tPersonnel[j+1];
	  }
	  counterTransportationPersonnel--;
      flag=0;
	  }
  }
  public String getBranchName() {
	return branchName;
  }
  public void setBranchName(String branchName) {
	this.branchName = branchName;
  }
  public int getBranchNumber() {
	return branchNumber;
  }
  public void setBranchNumber(int branchNumber) {
	this.branchNumber = branchNumber;
  }
  public int getCounterBranchEmployee() {
	return counterBranchEmployee;
  }

  /**
 * @param obj is returned by the addCustomer method of BranchEmployee class
 * Adds the object to array if array fills up, it opens new array and uses it.
 * 
 */
public void addCustomer(Customer obj){
	  customers[counterCustomer++]=obj;
	  if(counterCustomer==cuMax) {
		  cuMax*=2;
		  Customer []customers2=new Customer[cuMax];
		  for(int i=0;i<cuMax;i++) {
			  customers2[i]=customers[i];
		  }
		  customers=customers2;
		  Cargo obj2=new Cargo();
		  obj2.setRecieverName(obj.getName());
		  obj2.setSenderName(scan.next());
		  obj2.setTrackingNumber(obj.getTrackingNum());
		  obj2.setCurrentStatus(0);
		  addCargo(obj2);
	  }
	  
	  
  }
  /**
 * @param cid is returned by the removeBranchEmployee method of customer class
 * Finds transportation personnel number and removes branch
 * 
 */
public void removeCustomer(int cid){
	  for(int i=0;i<counterCustomer;i++) {
		  if(cid==customers[i].getNum()) {
			  ccount=i;
			  flag=1;
		  }
	  }
	  if(flag==1) {
		  for(int j=ccount;j<counterCustomer;j++) {
			  customers[j]=customers[j+1];
		  }
		  counterCustomer--;
		  flag=0;
	  }
	  
  }
  public int getCounterTransportationPersonnel() {
	return counterTransportationPersonnel;
  }
  public int getCounterCargoNumber() {
	return counterCargoNumber;
 }
 public int getCounterCustomer() {
 	return counterCustomer;
 }


 
 
  
  
}
