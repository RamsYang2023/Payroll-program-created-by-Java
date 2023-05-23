

import java.util.Date;


public class PayPeriod {
	
	private int pID;
    private Date pStartDate, pEndDate;
	    
 // 1- add the class constructor
    PayPeriod() {
    	
    	pID = 0;
    	this.pStartDate = null;
    	this.pEndDate = null;
    }
    
    public PayPeriod(int ID, Date pStartDate, Date pEndDate) {
    	this.pID = ID;
    	this.pStartDate = pStartDate;
    	this.pEndDate = pEndDate;
    }

 //  the setters/getters methods
	public int getpID() {
		return pID;
	}

	public void setpID(int pID) {
		this.pID = pID;
	}

	public Date getpStartDate() {
		return pStartDate;
	}

	public void setpStartDate(Date pStartDate) {
		this.pStartDate = pStartDate;
	}

	public Date getpEndDate() {
		return pEndDate;
	}

	public void setpEndDate(Date pEndDate) {
		this.pEndDate = pEndDate;
	}
   
	// override method toString() 
	public String toString() {
		return "Pay ID = " + pID + ", " + "Pay start date: " + pStartDate + ", " + "Pay end date: " + pEndDate + ", ";
	}
       

	
}
