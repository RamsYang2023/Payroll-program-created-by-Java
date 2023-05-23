import java.util.Date;

public class TaxIncome implements Taxable {

	// this class implements the Taxable interface
	//  implement all the unimplemented abstract methods in the Taxable Interface, income tax is computed based on state and federal taxes   
	protected double federalTax;
	protected double stateTax;
	protected double totalTax;
	
	TaxIncome() {
		federalTax = 0;
		stateTax = 0;
		totalTax = 0;
	}
	
	public double compStateTax(double grossPay) {
		stateTax = grossPay * STATE_TAX;
		return stateTax;
	}
	
	public double compFederalTax(double grossPay) {
		federalTax = grossPay * FEDERAL_TAX;
		return federalTax;
	}
	
	public double compIncomeTax(double grossPay) {
		totalTax = compStateTax(grossPay) + compFederalTax(grossPay);
		return totalTax;
	}
	
}
