import java.util.Scanner;

/**
 * @author zafer
 *	This class has main method and test method
 */
public class AutomationSystem {
	/**
	 * This method is a test method
	 */
	public static void AllTest(){
		System.out.println("Welcome to Test Scenerio for my Cargo Company.");
		System.out.println("I will try to explain results of choice");
		System.out.println("Firstly we create CargoCompany object and admin");
		Admin admin1=new Admin();
		CargoCompany cc =new CargoCompany();
		System.out.println("Now we create 3 branch for my company");
		System.out.println("1.Branch name is Gebze and branch num is 82");
		Branch br1=new Branch();
		br1.setBranchName("Gebze");
		br1.setBranchNumber(82);
		cc.addBranch(br1);
		System.out.println("2.Branch name is Darýca and branch num is 83");
		Branch br2=new Branch();
		br2.setBranchName("Darýca");
		br2.setBranchNumber(83);
		cc.addBranch(br2);
		System.out.println("3.Branch name is Cayirova and num is 84.We create this branch for testing to remove branch command.");
		Branch br3=new Branch();
		br3.setBranchName("Cayirova");
		br3.setBranchNumber(84);
		cc.addBranch(br3);
		System.out.println("Now we list to branch");
		
		
		for(int t=0;t<cc.getCounterBranch();t++) {
			System.out.printf("%d --- %s\n",cc.branchh[t].getBranchNumber(),cc.branchh[t].getBranchName());
		}
		
		System.out.println("And now we try remove branch(Cayirova) and ý will list again all branch");
		cc.removeBranch(84);
		
		for(int t=0;t<cc.getCounterBranch();t++) {
			System.out.printf("%d --- %s\n",cc.branchh[t].getBranchNumber(),cc.branchh[t].getBranchName());
		}
		
		
		System.out.println("Now we test add branches employee so we create branches employee object");
		System.out.println("1. Ahmet Yilmaz and  branch num is 1 and his branch is gebze");
		
		BranchEmployee ahmet=new BranchEmployee();
		ahmet.setName("Ahmet Yilmaz");
		ahmet.setNum(1);
		cc.branchh[0].addBranchEmployee(ahmet);
		System.out.println("Secondly Hasan Arkýn in Darýca and his num 45");
		
		BranchEmployee hasan=new BranchEmployee();
		hasan.setName("Hasan Arkýn");hasan.setNum(45);
		cc.branchh[1].addBranchEmployee(hasan);
		System.out.println("Also we create Ali Ihsan(13) in gebze and Fatma Gunes (5) in darica");
		
		BranchEmployee ali=new BranchEmployee();
		ali.setName("Ali Ihsan");
		ali.setNum(13);
		cc.branchh[0].addBranchEmployee(ali);
		
		BranchEmployee fatma=new BranchEmployee();
		fatma.setName("Fatma Gunes");fatma.setNum(5);
		cc.branchh[1].addBranchEmployee(fatma);
		
		System.out.println("Now we listed all Branches Employee for testing AddBranchesEmployee Command");
		 
		for(int i=0;i<cc.getCounterBranch();i++) {
			for(int j=0;j<cc.branchh[i].getCounterBranchEmployee();j++) {
				System.out.printf("name= %s no= %d\n",cc.branchh[i].bEmployee[j].getName(),cc.branchh[i].bEmployee[j].getNum());
			}
		}
		
		System.out.println("And now we try removeBranchEmployee command and we list again.(Hasan Arkýn 45)");
		cc.removeBranchEmployee(45);
		
		for(int i=0;i<cc.getCounterBranch();i++) {
			for(int j=0;j<cc.branchh[i].getCounterBranchEmployee();j++) {
				System.out.printf("name= %s no= %d\n",cc.branchh[i].bEmployee[j].getName(),cc.branchh[i].bEmployee[j].getNum());
			}
		}
		
		System.out.println("Now we will test addTp and remove Tp commands for admin");
		System.out.println("We create 4 tp and list all.\n");
		
		TransportationPersonnel ayse =new TransportationPersonnel();
		ayse.setName("Ayse Bal");ayse.setNum(4);
		cc.branchh[0].addTransportationPersonnel(ayse);
		
		TransportationPersonnel mehmet =new TransportationPersonnel();
		mehmet.setName("Mehmet Turk");mehmet.setNum(51);
		cc.branchh[0].addTransportationPersonnel(mehmet);
		
		TransportationPersonnel uraz =new TransportationPersonnel();
		uraz.setName("Uraz Alp");uraz.setNum(23);
		cc.branchh[1].addTransportationPersonnel(uraz);
		
		TransportationPersonnel will =new TransportationPersonnel();
		will.setName("Will Grick");will.setNum(62);
		cc.branchh[1].addTransportationPersonnel(will);
		
		for(int k=0;k<cc.getCounterBranch();k++) {
			for(int l=0;l<cc.branchh[k].getCounterTransportationPersonnel();l++) {
				System.out.printf("name %s no %d\n",cc.branchh[k].tPersonnel[l].getName(),cc.branchh[k].tPersonnel[l].getNum());
			}			
		}
		
		System.out.println("And we remove uraz and list again for remove tp command");
		
		cc.removeTransportationPersonnel(23);
		
		for(int k=0;k<cc.getCounterBranch();k++) {
			for(int l=0;l<cc.branchh[k].getCounterTransportationPersonnel();l++) {
				System.out.printf("name %s no %d\n",cc.branchh[k].tPersonnel[l].getName(),cc.branchh[k].tPersonnel[l].getNum());
			}			
		}
		
		System.out.println("\nYes we finished all commands for administrator and now we try branch employe commands\n");
		System.out.println("Firstly we will try add and remove customer.");
		System.out.println("We create 3 customer Cengiz Söyücü(88),Hakan Tosun(17),Ozan Ayhan(95)");
		
		Customer cengiz=new Customer();
		cengiz.setName("Cengiz Söyüncü");cengiz.setNum(88);cengiz.setTrackingNum(87);
		Cargo c1=new Cargo();
		c1.setSenderName(cengiz.getName());
		c1.setRecieverName("xxxx");
		c1.setTrackingNumber(cengiz.getTrackingNum());
		c1.setCurrentStatus(0);
		cc.branchh[0].addCargo(c1);
		cc.branchh[0].addCustomer(cengiz);
		
		Customer hakan=new Customer();
		hakan.setName("Hakan Tosun");hakan.setNum(17);hakan.setTrackingNum(16);
		Cargo c2=new Cargo();
		c2.setSenderName(hakan.getName());
		c2.setRecieverName("xxxx");
		c2.setTrackingNumber(hakan.getTrackingNum());
		c2.setCurrentStatus(0);
		cc.branchh[0].addCargo(c2);
		cc.branchh[0].addCustomer(hakan);
		
		Customer ozan=new Customer();
		ozan.setName("Ozan Ayhan");ozan.setNum(95);ozan.setTrackingNum(94);
		Cargo c3=new Cargo();
		c3.setSenderName(ozan.getName());
		c3.setRecieverName("xxxx");
		c3.setTrackingNumber(ozan.getTrackingNum());
		c3.setCurrentStatus(0);
		cc.branchh[1].addCargo(c3);
		cc.branchh[1].addCustomer(ozan);
		
		System.out.println("Now we listed all customers and all cargos");
		System.out.println("Cargos:");
		for(int i=0;i<2;i++) {
		  for(int k=0;k<cc.branchh[i].getCounterCargoNumber();k++) {
			  System.out.printf("Tracking num: %d -> from %s to %s \n",cc.branchh[i].cargos[k].getTrackingNumber(),cc.branchh[i].cargos[k].getSenderName(),cc.branchh[i].cargos[k].getRecieverName());
		  }
		}
		System.out.println("Customerss");
		
		for(int i=0;i<2;i++) {
			  for(int k=0;k<cc.branchh[i].getCounterCustomer();k++) {
				  System.out.printf("Tracking num: %d -> name: %s\n",cc.branchh[i].customers[k].getTrackingNum(),cc.branchh[i].customers[k].getName());
			  }
			}
		
		
		System.out.println("\n Now we test remove customer(Ozan Ayhan) and listed");
		cc.branchh[1].removeCustomer(95);
		
		for(int i=0;i<2;i++) {
			  for(int k=0;k<cc.branchh[i].getCounterCargoNumber();k++) {
				  System.out.printf("Tracking num: %d -> from %s to %s\n",cc.branchh[i].cargos[k].getTrackingNumber(),cc.branchh[i].cargos[k].getSenderName(),cc.branchh[i].cargos[k].getRecieverName());
			  }
			}
		System.out.println("Customerss\n");
		for(int i=0;i<2;i++) {
			  for(int k=0;k<cc.branchh[i].getCounterCustomer();k++) {
				  System.out.printf("Tracking num: %d -> name: %s\n",cc.branchh[i].customers[k].getTrackingNum(),cc.branchh[i].customers[k].getName());
			  }
			}
		
		System.out.println("Now we test for Customer and Transportation Personnal");
		System.out.println("Firstly we control cargos status like customer(Hakans cargo)");
		
		for(int i=0;i<cc.getCounterBranch();i++) {
			for(int j=0;j<cc.branchh[i].getCounterCargoNumber();j++) {
					if(16==cc.branchh[i].cargos[j].getTrackingNumber()) {
						cc.branchh[i].controlCargo(j);
					}
			}
		}
		System.out.println("Our test was end.");
		
	}
	
	/**
	 * Main method
	 * @param args
	 */
	public static void main(String []args) {
		int secim;
		Scanner scan=new Scanner(System.in);
		System.out.println("Please select your Cargo Company similation\n 1-)Test Automaticly\n 2-)Interactive Test");
		secim=scan.nextInt();
		if(secim==1) {
			AllTest();
		}
		else {
			
		
		int choice,branchPersonalid,branchNum,sc;
		int trackingNum;
		CargoCompany cc=new CargoCompany();
		Admin admin1 =new Admin();

		
		do {
			System.out.println("Welcome the Cargo company automation system");
			System.out.println("Please choose your input method");
			System.out.println("1-)Admin \n2-)Branch Employee\n3-)Transportation Personal\n4-)Customer\n5-)Exit");
			sc=scan.nextInt();
		switch(sc) {
			case 1:		
				System.out.println("Please select operation that you want");
				System.out.println("1-)Add Branches\n2-)Remove Branches\n3-)Add Branches Employee\n4-)Remove Branches Employee \n5-)Add Transportation Personnel\n6-)Remove Transportation Personnel\n7-)List Branches Employee\n8-)List Transportation Personal");
				choice=scan.nextInt();
				if(choice==1) {
					cc.addBranch(admin1.addBranch());
				}
				else if(choice==2) {
					for(int t=0;t<cc.getCounterBranch();t++) {
						System.out.printf("%d --- %s\n",cc.branchh[t].getBranchNumber(),cc.branchh[t].getBranchName());
					}
					cc.removeBranch(admin1.removeBranch());
				}
				else if(choice==3) {
					for(int t=0;t<cc.getCounterBranch();t++) {
						System.out.printf("%d --- %s\n",cc.branchh[t].getBranchNumber(),cc.branchh[t].getBranchName());
					}
					cc.addBranchEmployee(admin1.addBranchEmployee());
				}
				else if(choice==4) {
					for(int t=0;t<cc.getCounterBranch();t++) {
						System.out.printf("%d --- %s\n",cc.branchh[t].getBranchNumber(),cc.branchh[t].getBranchName());
					}
					cc.removeBranchEmployee(admin1.removeBranchEmployee());
				}
				else if(choice==5) {
					for(int t=0;t<cc.getCounterBranch();t++) {
						System.out.printf("%d --- %s\n",cc.branchh[t].getBranchNumber(),cc.branchh[t].getBranchName());
					}
					cc.addTranspotationPersonnel(admin1.addTranspotationPersonnel());
				}
				else if(choice==6) {
					for(int t=0;t<cc.getCounterBranch();t++) {
						System.out.printf("%d --- %s\n",cc.branchh[t].getBranchNumber(),cc.branchh[t].getBranchName());
					}
					cc.removeTransportationPersonnel(admin1.removeTransportationPersonnel());
				}
				else if(choice==7) {
					for(int i=0;i<cc.getCounterBranch();i++) {
						for(int j=0;j<cc.branchh[i].getCounterBranchEmployee();j++) {
							System.out.printf("name= %s no= %d\n",cc.branchh[i].bEmployee[j].getName(),cc.branchh[i].bEmployee[j].getNum());
						}
					}
				}
				else if(choice==8){
					for(int k=0;k<cc.getCounterBranch();k++) {
						for(int l=0;l<cc.branchh[k].getCounterTransportationPersonnel();l++) {
							System.out.printf("name %s no %d\n",cc.branchh[k].tPersonnel[l].getName(),cc.branchh[k].tPersonnel[l].getNum());
						}			
					}
				}
				break;
			case 2:
				for(int t=0;t<cc.getCounterBranch();t++) {
					System.out.printf("%d --- %s\n",cc.branchh[t].getBranchNumber(),cc.branchh[t].getBranchName());
				}
				  System.out.println("Please enter the your branch number and your branch employe num");
				  System.out.printf("Branch Num=");
				  branchNum=scan.nextInt();
				  System.out.printf("Branch personal num=");
				  branchPersonalid=scan.nextInt();
				for(int i=0;i<cc.getCounterBranch();i++) {
					if(cc.branchh[i].getBranchNumber()==branchNum) {
						for(int j=0;j<cc.branchh[i].getCounterBranchEmployee();j++) {
							if(cc.branchh[i].bEmployee[j].getNum()==branchPersonalid) {
								 System.out.println("Please select operation that you want");
								 System.out.println("1-)Add Customer\n2-)Remove Customer\n3-)Change cargo status\n4-)List cargos");
								 choice=scan.nextInt();
								switch(choice) {
									case 1:
											cc.branchh[i].addCustomer(cc.branchh[i].bEmployee[j].addCustomer());
											break;
									case 2:
											cc.branchh[i].removeCustomer(cc.branchh[i].bEmployee[j].removeCustomer());
											break;
									case 3:
											cc.branchh[i].changeCargoStatus(cc.branchh[i].bEmployee[j].changeCargoStatus());
											break;
									case 4:
											for(int k=0;k<cc.branchh[i].getCounterCargoNumber();k++) {
												System.out.printf("Tracking num: %d -> from %s to %s ",cc.branchh[i].cargos[k].getTrackingNumber(),cc.branchh[i].cargos[k].getSenderName(),cc.branchh[i].cargos[k].getRecieverName());
											}
								}
							}
							else {
								System.out.println("Please control your ýd or branch num after try again");
							}
						}
					}
					else {
						System.out.println("Please control your ýd or branch num after try again");
					}
				}
				break;
			case 3:
			    	for(int t=0;t<cc.getCounterBranch();t++) {
				    	System.out.printf("%d --- %s\n",cc.branchh[t].getBranchNumber(),cc.branchh[t].getBranchName());
				     }
				  System.out.println("Please enter the your branch number and yourTransportation Personal num");
				  System.out.printf("Branch Num=");
				  branchNum=scan.nextInt();
				  System.out.printf("Transportation personal num=");
				  branchPersonalid=scan.nextInt();

					for(int i=0;i<cc.getCounterBranch();i++) {
						if(cc.branchh[i].getBranchNumber()==branchNum) {
							for(int j=0;j<cc.branchh[i].getCounterTransportationPersonnel();j++) {
								if(cc.branchh[i].tPersonnel[j].getNum()==branchPersonalid) {
									 System.out.println("Please select operation that you want");
									 System.out.println("1-)Change cargo status");
									 choice=scan.nextInt();
									switch(choice) {
										case 1:
											cc.branchh[i].changeCargoStatus(cc.branchh[i].tPersonnel[j].changeCargoStatus());
									}
								}
								else {
									System.out.println("Please control your ýd or branch num after try again");
									break;
								}
							}
						}
						else {
							System.out.println("Please control your ýd or branch num after try again");
							break;
						}
					}
				  break;
			case 4:
					System.out.println("Please enter tracking num");
					trackingNum=scan.nextInt();
					for(int i=0;i<cc.getCounterBranch();i++) {
						for(int j=0;j<cc.branchh[i].getCounterCargoNumber();j++) {
								if(trackingNum==cc.branchh[i].cargos[j].getTrackingNumber()) {
									cc.branchh[i].controlCargo(j);
								}
						}
					}
				break;
			case 5:
					System.out.println("The program will terminated");
				break;
					
		}
		
		}while(sc!=5);
		
		
	}
	
	
	}
	
}
