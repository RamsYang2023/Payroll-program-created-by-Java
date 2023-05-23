

import java.io.File;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PayRoll {
	
	private String fileName;
	static PayRecord[] payRecords;
	static Employee[] employees;
	private static Status empStatus;
	
	
	
	private static  double totalNetPay;
	private  static double avgNetPay;
	
	static int n;
	
	
	public static void payRoll(String fileName, int n) throws FileNotFoundException, ParseException{
				     
                payRecords = new PayRecord[n+3]; //initial PayRecord array
                employees = new Employee[n+3];  //initial Employees array
                
                readFromFile(fileName); //read data from the file
                
                writeToFile(); //write the data into the "PayRecord.txt".
                              		
	}
	
	//read from the file method
	public static void readFromFile(String fileName) throws FileNotFoundException, ParseException {
		
		// read the initial data from PayRoll file to create the full 
		 // pay records with gross pay, taxes, and net pay, and then store it in PayRecord.txt file
			
	    File file = new File(fileName);
	    
	    // Create a Scanner for the file
	    Scanner sc = new Scanner(file);
	    
	    // Read data from a file, the data fields are separated by ',' 
	    // Change the Scanner default delimiter to ','
	    
	    sc.useDelimiter(",|\r\n"); 
	    
	    
	   // Start reading data from file using while loop
	 
	    while (sc.hasNext()) {
	    
		   String name = sc.next();
		   	
		   if (name.equals("employee")) {                //decide it is employee info or pay record
		   int eID = Integer.parseInt(sc.next().trim());
		   String fName = sc.next().trim();
		   String lName = sc.next().trim();
		   String statusStr = sc.next().trim();
		   
		   
		  if(statusStr.equals("FULLTIME"))
			   empStatus = Status.FullTime;
		   else if(statusStr.equals("HOURLY"))
			   empStatus = Status.Hourly;
			   
		   String street = sc.next().trim();
		   int houseNum = Integer.parseInt(sc.next().trim());
		   String city = sc.next().trim();
		   String state = sc.next().trim();
		   int zipCode = Integer.parseInt(sc.next().trim());
		   		   
		   createEmployeeBtnClick(eID, empStatus, fName, lName, street, houseNum, city, state, zipCode);	//add employee data into its array	   		   
		 }//end if
		   
		   else if (name.equals("payRecord")) {
			   int rID = Integer.parseInt(sc.next().trim());
			   int eIDSec = Integer.parseInt(sc.next().trim());
			   String str1 = sc.next().trim();
			   
			   if(str1.contains("m")) {
				   str1 = str1.replace("<m>", "");
				   double monthIncome = Double.parseDouble(str1);
				   				   
				   String str2 = sc.next().trim();
				   str2 = str2.replace("<n>", "");
				   int numMonth = Integer.parseInt(str2);
				   				   
				   int pID = Integer.parseInt(sc.next().trim());
				   				   
				   DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
				   Date startDate = dateFormat.parse(sc.next().trim());
				   Date endDate = dateFormat.parse(sc.next().trim());
				   
				   createPayRecordBtnClick(rID, pID, startDate, endDate, monthIncome, numMonth);  //add pay record data into its array
				   UserGUI.textArea.append(payRecords[PayRecord.getNoOfRecords()-1].toString() +"\n"); // since the pay record array invoke employee info array, this toString including both info from employee and payrecord.
			   }
			   else if(str1.contains("h")) {
				   str1 = str1.replace("<h>", "");
				   double hours = Double.parseDouble(str1);
				   				   
				   String str2 = sc.next().trim();
				   str2 = str2.replace("<r>", "");
				   double hourRate = Double.parseDouble(str2);
				   int pID = Integer.parseInt(sc.next().trim());
				   				   
				   DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
				   Date startDate = dateFormat.parse(sc.next().trim());
				   Date endDate = dateFormat.parse(sc.next().trim());
				   				   
				   createPayRecordBtnClick(rID, pID, startDate, endDate, hours, hourRate); // The same as above
				   UserGUI.textArea.append(payRecords[PayRecord.getNoOfRecords()-1].toString()+"\n");
			   }
			   			
		    }
		   	   		  
	   }// end while
		
	    
		// Close the file
	    sc.close();
	    JOptionPane.showMessageDialog(null, "Completed Reading Data to File \"inputWaterBill.txt\"");
	     // display message the program done reading data
	    totalNetPay(); 
	    avgNetPay(); 
	     
	  }// end read methods
   
	
   //write to file method   
   public static void writeToFile() throws FileNotFoundException{
		
		// write employees' pay records to the PayRecord.txt file, it should add employee pay record to the current file data
	   // Create a File object
			File file = new File("PayRecord.txt");
		    
	        // Create a PrintWriter object
		    PrintWriter write = new PrintWriter(file);
			
	        // Prepare the program output to be stored in a file
			String out = "";
				       
	        // To Complete
	        // Write a for loop to read the customer data using the toString method
			for (int i = 0; i < PayRecord.getNoOfRecords(); i++)
	      	       
	      	       out += "\n" + payRecords[i].toString();
			
		    // Write formatted output to the file
		    write.print(out);
		    		   

		    // Close the file
		    write.close();
		    
		    		
	} 
   
   
   //add employee info into employee array
	public static void createEmployeeBtnClick(int eID, Status empStatus, String fName, String lName, String street, int houseNum, String city, String state, int zipCode ){
				 
		employees[Employee.getNoOfEmployees()] = new Employee(eID,  empStatus, fName, lName, new Address(street, houseNum, city, state, zipCode));
		
			
	}
	
 
	public static void createPayRecordBtnClick(int rID, int pID, Date startDate, Date endDate, double payFactor1, double payFactor2){
		
		// creates a new PayRecord for an Employee object and add it to  the payRecords array, you need to pass parameters to this method
		
		payRecords[PayRecord.getNoOfRecords()] = new PayRecord(rID, employees[PayRecord.getNoOfRecords()], new PayPeriod(pID, startDate, endDate), payFactor1, payFactor2);
		
	}
	
	
   public static void createRecordBntClick(int rID, int pID, Date startDate, Date endDate, double payFactor1, int payFactor2){
		
		// creates a new PayRecord for an Employee object and add it to  the payRecords array, you need to pass parameters to this method
	   
		payRecords[PayRecord.getNoOfRecords()] = new PayRecord(rID, employees[PayRecord.getNoOfRecords()], new PayPeriod(pID, startDate, endDate), payFactor1, payFactor2);
		
	}
	
   	
   //display all information for each enter from the prompt window in TextArea
    public static void displayPayRecord(){
		
		// it shows all payroll records for all currently added employee and the total net pay and average net pay in the GUI text area
    	// at should append data to text area, it must not overwrite data in the GUI text area
    	    	String output = "";
      	    	
    		 output = "\n" + payRecords[PayRecord.getNoOfRecords()-1].toString();
    		 
    		     		 
    		 UserGUI.textArea.append(output);
    }			

  //compute and display total net pay to TextArea 
    public static void totalNetPay(){
		
	  	// returns the average of the total net pay of all added employees
    	totalNetPay = 0;
    	
    	for (int i = 0; i < PayRecord.getNoOfRecords(); i++) 
    		totalNetPay += payRecords[i].netPay();
   
    	UserGUI.textArea.append("\nTotal net pay is $" + String.format("%.2f", totalNetPay));
    	
}
   //compute and display average net pay to TextArea 
   public static void avgNetPay(){
		
	    
	   avgNetPay = totalNetPay / PayRecord.getNoOfRecords();
		  	
	   
	   UserGUI.textArea.append("\nAverage net pay is $" + String.format("%.2f", avgNetPay) +"\n");
		
	}
    	

}
