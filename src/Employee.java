

public class Employee extends Person{
	
	private int eID;
    private Status empStatus;
    private static int noOfEmployees = 0;
    
    // 1- The Employee class extends superclass Person
    // 2- add the subclass Employee constructor that calls the supper Person class constructor, you should provide input data for all parent class data fields
   Employee() {
	   super();
	   this.eID = 0;
	   this.empStatus = null;
	   noOfEmployees++;
   }
   
   public Employee(int eID, Status empStatus, String fName, String lName, Address address) {
	   super(fName, lName, address);
	   this.eID = eID;
	   this.empStatus = empStatus;
	   noOfEmployees++;
   }

   // 3- add setters/getters methods
     public int geteID() {
     	return eID;
     }

     public void seteID(int eID) {
    	 this.eID = eID;
     }

     public Status getEmpStatus() {
    	 return empStatus;
     }
     
     
     public void setEmpStatus(Status empStatus) {
    	 this.empStatus = empStatus;
     }
         
   public static int getNoOfEmployees() {
		return noOfEmployees;
	}

	
	// 4- add override toString() method that overrides toString() in the superclass Person 
     public String toString() {
    	 return "Employee Id = " + eID + ", " + "Status = " + empStatus +", " + super.toString() + "\n";
     }
	
}
