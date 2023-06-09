

public class PayRecord {
	
	private int rID;
    private Employee employee;
    private PayPeriod payPeriod;
    private TaxIncome payTax;
    
    
    private double payHours;
    private double payRate;
    
    private double montlyIncome;
    private int numMonths;
    
    private static int noOfRecords;
    
       
    
    public static final int REG_HOURS = 40;
    public static final double OT_RATE = 1.25;
    
    // pay record constructor for hourly employee
    public PayRecord(int id, Employee e, PayPeriod period, double hours, double rate){
    	
    	this.rID = id;
    	this.employee = e;
    	this.payPeriod = period;
    	this.payHours = hours;
    	this.payRate = rate;
    	this.montlyIncome = 0;
    	this.numMonths = 0;
    	this.payTax = new TaxIncome();
    	noOfRecords++;
  
    }
    
    // pay record constructor for full time employee
    public PayRecord(int id, Employee e, PayPeriod period, double mIncome, int mNum){
 	
 	this.rID = id;
 	this.employee = e;
 	this.payPeriod = period;
 	this.payHours = 0;
 	this.payRate = 0;
 	this.montlyIncome = mIncome;
 	this.numMonths = mNum;
 	this.payTax = new TaxIncome();
 	noOfRecords++;

 }


  // add setters and getters methods
    public int getrID() {
		return rID;
	}

	public void setrID(int rID) {
		this.rID = rID;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public PayPeriod getPayPeriod() {
		return payPeriod;
	}

	public void setPayPeriod(PayPeriod payPeriod) {
		this.payPeriod = payPeriod;
	}

	public TaxIncome getPayTax() {
		return payTax;
	}

	public void setPayTax(TaxIncome payTax) {
		this.payTax = payTax;
	}

	public double getPayHours() {
		return payHours;
	}

	public void setPayHours(double payHours) {
		this.payHours = payHours;
	}

	public double getPayRate() {
		return payRate;
	}

	public void setPayRate(double payRate) {
		this.payRate = payRate;
	}

	public double getMontlyIncome() {
		return montlyIncome;
	}

	public void setMontlyIncome(double montlyIncome) {
		this.montlyIncome = montlyIncome;
	}

	public int getNumMonths() {
		return numMonths;
	}

	public void setNumMonths(int numMonths) {
		this.numMonths = numMonths;
	}
	
	public static int getNoOfRecords() {
		return noOfRecords;
	}    
	
		
	// override method toString()
	

	public String toString() {
		return  employee.toString() + "Record ID = " + rID +", " + payPeriod.toString() + "Gross pay: " + "$" + String.format("%.2f", grossPay()) 
		+ ", Net pay: " + "$" + String.format("%.2f", netPay()) +"\n";
		
	}
  
    
    // complete the code to compute the gross pay for the employee based on the employee status
	public double grossPay(){
		if(this.numMonths == 0)
		    return this.payHours * this.payRate;
		
		else
			return this.montlyIncome * this.numMonths;
	}
    
  

	// complete the code in this method to compute the net pay of the employee after taxes (state and federal)
     public double netPay(){
		  return grossPay()-payTax.compIncomeTax(grossPay());
  }

	 

}
