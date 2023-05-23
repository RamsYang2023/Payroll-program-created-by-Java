//       Spring Session 2022
//     Program Assignment PP03
//            CIS611
//      GANG YANG  & Erik Eitel
//           04-01-2022


import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class UserGUI extends JPanel implements ActionListener {
	  //declare fields
	  JLabel lbleID, lblfName, lbllName, lbllStatus;
	  JTextField IDTextfield, fNameTextfield, lNameTextfield;
	  JRadioButton fullTimebtn, hoursbtn;
	  
	  //Employee address
	  JLabel lblStreet, lblHouseNum, lblCity, lblState, lblZipCode;
	  JTextField streetTextfield, houseNumTextfield, cityTextfield, stateTextfield, zipCodeTextfield;
	  JButton addEmployeebtn;
	  
	  //Pay period
	  JLabel lblpID, lblStartDate, lblEndDate;
	  JTextField pIDTextfield, startDateTextfield, endDateTextfield;
	  
	  //Pay record
	  JLabel lblrID, lblMonthIncome, lblNumMonth, lblHours, lblPayRate;
	  JTextField rIDTextfield, monthIncomeTextfield, numMonthTextfield, hoursTextfield, payRateTextfield;
	  JButton addRecordbtn;
	  
	  //display area
	  static JTextArea textArea;
	  JScrollPane scrollPane;
      JButton closebtn;
	 
	  PayRoll payRoll;
	  private static Status statusStr;
	  
	  public UserGUI() throws FileNotFoundException, ParseException {
		  
          // prompt the user to input the number of pay records
		  int n;
		  
		  while(true) {
				try {
					
					n = Integer.parseInt(JOptionPane.showInputDialog("Enter Number of employees"));
					
					if (n <= 0)
						throw new Exception();
					
				    break;
				
				} catch (Exception ex){
						JOptionPane.showMessageDialog(null, "Catch: Invalid Input, Try Again!");
						
					}// end catch
				}// while	
		   // is the number of pay records for employees
		
                // payRoll = new PayRoll(fileName, n);
		  
		  initGUI(); //invoke iniGUI
		    
		  doTheLayout(); //invoke layout design
		  
		  PayRoll.payRoll("PayRoll.txt", n); //invoke the class PayRoll.java
		    
		  	      		  	       
	 
	  } // end of constructor

	  private void initGUI(){
	      // Employee panel
		  lbleID = new JLabel("Employee ID: ", JLabel.RIGHT);
		  lblfName = new JLabel("First Name:", JLabel.RIGHT);
		  lbllName = new JLabel("Last Name: ", JLabel.RIGHT);
		  lbllStatus = new JLabel("Employee Status: ", JLabel.RIGHT);
		  
		  IDTextfield = new JTextField(4);
		  fNameTextfield = new JTextField(15);
		  lNameTextfield = new JTextField(15);
		  
		  fullTimebtn = new JRadioButton("Full Time", true);
		  hoursbtn = new JRadioButton("Part Time");
		  
		  //Employee address
		  lblStreet = new JLabel("Street: ", JLabel.RIGHT);
		  lblHouseNum = new JLabel("House/Apartment Number", JLabel.RIGHT);
		  lblCity = new JLabel("City: ", JLabel.RIGHT);
		  lblState = new JLabel("State: ", JLabel.RIGHT);
		  lblZipCode = new JLabel("Zip Code: ", JLabel.RIGHT);
		  
		  streetTextfield = new JTextField(30);
		  houseNumTextfield = new JTextField(10);
		  cityTextfield = new JTextField(12);
		  stateTextfield = new JTextField(12);
		  zipCodeTextfield = new JTextField(12);
		  
		  addEmployeebtn = new JButton("Add Employee");
		  addEmployeebtn.addActionListener(this);
		    
		  
		  //Pay period
		  lblpID = new JLabel("Period ID: ", JLabel.RIGHT);
		  lblStartDate = new JLabel("Start Date: ", JLabel.RIGHT);
		  lblEndDate = new JLabel("End Date: ", JLabel.RIGHT);
		  
		  pIDTextfield = new JTextField(4);
	      startDateTextfield = new JTextField(15);
		  endDateTextfield = new JTextField(15);
		  
		  //Pay record
		  lblrID = new JLabel("Pay ID", JLabel.RIGHT);
		  lblMonthIncome = new JLabel("Option 1 - FULL TIME    Monthly Income: ", JLabel.RIGHT);
		  lblNumMonth = new JLabel("Number of Month: ", JLabel.RIGHT);
		  lblHours = new JLabel("Option 2 - PART TIME    Pay Hours: ", JLabel.RIGHT);
		  lblPayRate = new JLabel("Pay Rate: ", JLabel.RIGHT);
		  
		  rIDTextfield = new JTextField(4);
		  monthIncomeTextfield = new JTextField(12);
		  numMonthTextfield = new JTextField(12);
		  hoursTextfield = new JTextField(12);
		  payRateTextfield = new JTextField(12);
		  
		  addRecordbtn = new JButton("Add Pay Record");
		  addRecordbtn.addActionListener(this);
		  
		  //TextArea
		  textArea = new JTextArea(100, 100);
	      textArea.setEditable(false);
	      textArea.setVisible(true);
	      
	      scrollPane = new JScrollPane(textArea);
	      
	      closebtn = new JButton("Close");
	      closebtn.addActionListener(this);
	      
	      
		  
	  }// end of creating objects method

	  private void doTheLayout(){
          //Panel for employee info
		  JPanel employeePanel = new JPanel(new GridLayout(2, 1, 20, 5));
		  JPanel subEmployeePanelA = new JPanel();
		  JPanel subEmployeePanelB = new JPanel();
	  	
		  //Group radio buttons.  		  
		  ButtonGroup group = new ButtonGroup();
		  group.add(fullTimebtn);
		  group.add(hoursbtn);
		  
		  //sub panel for Employee info  
		  subEmployeePanelA.add(lbleID);
		  subEmployeePanelA.add(IDTextfield);
		  subEmployeePanelA.add(lblfName);
		  subEmployeePanelA.add(fNameTextfield);
		  subEmployeePanelA.add(lbllName);
		  subEmployeePanelA.add(lNameTextfield);
		  subEmployeePanelB.add(lbllStatus);
		  subEmployeePanelB.add(fullTimebtn);
		  subEmployeePanelB.add(hoursbtn);
		  
		  employeePanel.add(subEmployeePanelA,"North");
		  employeePanel.add(subEmployeePanelB,"Center");
		  employeePanel.setBorder(new TitledBorder("Employee: "));
		  
		  //Panel for Employee address
		  JPanel addressPanel = new JPanel(new GridLayout(3, 1, 20, 5));
		  JPanel subAddressPanelA = new JPanel();
		  JPanel subAddressPanelB = new JPanel();
		  JPanel subAddressPanelC = new JPanel();
		  
		  //sub panel for Employee address
		  subAddressPanelA.add(lblStreet);
		  subAddressPanelA.add(streetTextfield);
		  subAddressPanelA.add(lblHouseNum);
		  subAddressPanelA.add(houseNumTextfield);
		  subAddressPanelB.add(lblCity);
		  subAddressPanelB.add(cityTextfield);
		  subAddressPanelB.add(lblState);
		  subAddressPanelB.add(stateTextfield);
		  subAddressPanelB.add(lblZipCode);
		  subAddressPanelB.add(zipCodeTextfield);
		  subAddressPanelC.add(addEmployeebtn);
		  
		  //Add subpanels to address panel.
		  addressPanel.add(subAddressPanelA, "North");
		  addressPanel.add(subAddressPanelB, "Center");
		  addressPanel.add(subAddressPanelC, "South");
		  addressPanel.setBorder(new TitledBorder("Employee Address: "));
		  
		  //Combine employee info and address panel into one panel as top
		  JPanel topPanel = new JPanel(new GridLayout(2, 1, 20, 10));
		  
		  topPanel.add(employeePanel, "North");
		  topPanel.add(addressPanel, "Center");
		  
		  //Period panel
		  JPanel periodPanel = new JPanel();
		  
		  periodPanel.add(lblpID);
		  periodPanel.add(pIDTextfield);
		  periodPanel.add(lblStartDate);
		  periodPanel.add(startDateTextfield);
		  periodPanel.add(lblEndDate);
		  periodPanel.add(endDateTextfield);
		  periodPanel.setBorder(new TitledBorder("Pay Period: "));
		  
		  //Sub panels to record panel.
		  JPanel recordPanel = new JPanel(new GridLayout(3, 1, 20, 5));
		  JPanel subRecordPanelA = new JPanel();
		  JPanel subRecordPanelB = new JPanel();
		  JPanel subRecordPanelC = new JPanel();
		  
		  subRecordPanelA.add(lblMonthIncome);
		  subRecordPanelA.add(monthIncomeTextfield);
		  subRecordPanelA.add(lblNumMonth);
		  subRecordPanelA.add(numMonthTextfield);
		  subRecordPanelB.add(lblrID);
		  subRecordPanelB.add(rIDTextfield);
		  subRecordPanelB.add(lblHours);
		  subRecordPanelB.add(hoursTextfield);
		  subRecordPanelB.add(lblPayRate);
		  subRecordPanelB.add(payRateTextfield);
		  subRecordPanelC.add(addRecordbtn);
		  subRecordPanelC.add(closebtn);
		  
		  //hide the hours and rate inputs text fields when select Full Time radio button, otherwise, hide Monthly income and number of months		  		  
		  fullTimebtn.addItemListener(new ItemListener() {
			 
		  public void itemStateChanged(ItemEvent event) {
			  
			  			 
			        int state = event.getStateChange();
			        if (state == ItemEvent.SELECTED) {
			 
			        	monthIncomeTextfield.setVisible(true);
						numMonthTextfield.setVisible(true);
				  		 
				  		hoursTextfield.setVisible(false);
				  		payRateTextfield.setVisible(false);
			 
			        } 
			        
			        else if (state == ItemEvent.DESELECTED) {
			 
			        	monthIncomeTextfield.setVisible(false);
						numMonthTextfield.setVisible(false);
						
						hoursTextfield.setVisible(true);
				  		payRateTextfield.setVisible(true);
			 
			        }
			    }
			});//To hide the input TextArea by switching the Radio buttons.
		  
			  					  
		  recordPanel.add(subRecordPanelA, "North");
		  recordPanel.add(subRecordPanelB, "Center");
		  recordPanel.add(subRecordPanelC, "South");
		  recordPanel.setBorder(new TitledBorder("Pay Record: "));
		  
		  //combine period panel and record panel into one panel as center one
		  JPanel centerPanel = new JPanel(new GridLayout(2, 1, 20, 10));
		  
		  centerPanel.add(periodPanel, "North");
		  centerPanel.add(recordPanel, "Center");
		  
		  //TextArea panel
		  JPanel textAreaPanel = new JPanel(new GridLayout(1, 1, 20, 10));
		  
		  textAreaPanel.add(scrollPane);
		  textAreaPanel.setBorder(new TitledBorder("Current Employee Record and Stat(total and average net pays): "));
		  
		  //Add panels to frame
	      setLayout( new GridLayout(3, 1, 5, 5));
	      add(topPanel);
	      add(centerPanel);
	      add(textAreaPanel);
	     
	      

	  }// end of Layout method

	 
	  public void actionPerformed(ActionEvent e) {
		    // use if statement to call proper methods to process user events
			// To Complete
			if(e.getSource() == this.closebtn)
				System.exit(0);
			
			//Set action when hit add employee button
			else if(e.getSource() == this.addEmployeebtn) {
				
				try {
					
					if(Employee.getNoOfEmployees() == PayRoll.employees.length) //Test the employee array is full or not
							throw new Exception();
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "The employee database is full, no more entry");
						return;				
					}
				
				
				addEmployee();
						
				}
			
			//Set action when hit add pay record button.
			else if(e.getSource() == this.addRecordbtn) {
			
			//Test the array is full or not
               try {
					
					if(PayRecord.getNoOfRecords() == PayRoll.payRecords.length) //Test the pay record array is full or not
							throw new Exception();
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "The pay record database is full, no more entry");
						return;				
					}
               
				try {
					addRecord(); //add pay record array
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				PayRoll.displayPayRecord();//display pay record string into textArea
				
				try {
					PayRoll.writeToFile();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				PayRoll.totalNetPay(); //display total net pay into textArea
				
				PayRoll.avgNetPay(); ////display average net pay into textArea
			}
			    
	  }
	  
	  //Method for add employee when hit add employee button
	  void addEmployee() {
		  int eID = 0, houseNum, zipCode;
		  String fName = "";
		  String lName = "";
		  String street = "", city ="", state = "";
		  
		  //input eID
		  try {
				
			eID = Integer.parseInt(this.IDTextfield.getText().trim());
				if (eID <= 0)
					throw new Exception();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this.IDTextfield, "Invalid Employee ID");
				this.IDTextfield.setText("");
				return;				
			}// end try-catch
		  
		  		  
		  //input first Name
		  if(this.fNameTextfield.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(this.fNameTextfield, "Invalid Fisrt Name");
				this.fNameTextfield.setText("");
				return;				
			} //end if
			fName = this.fNameTextfield.getText().trim();
						
			//input last Name
	      if(this.lNameTextfield.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(this.lNameTextfield, "Invalid Last Name");
				this.lNameTextfield.setText("");
				return;				
			} //end if
			lName = this.lNameTextfield.getText().trim();
						
			//Get Status
			if(fullTimebtn.isSelected())
				statusStr = Status.FullTime;
			else
				statusStr = Status.Hourly;
						
			//Get street name
			if(this.streetTextfield.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(this.streetTextfield, "Invalid Street Input");
				this.streetTextfield.setText("");
				return;				
			} //end if
			street = this.streetTextfield.getText().trim();
						
			//Get house/apartment number
			try {
			houseNum = Integer.parseInt(this.houseNumTextfield.getText().trim());
			if (houseNum <= 0)
				throw new Exception();
		        } catch (Exception ex) {
			JOptionPane.showMessageDialog(this.houseNumTextfield, "Invalid House/Apartment Number input");
			this.houseNumTextfield.setText("");
			return;				
		   }// end try
						
			//get City Name
			if(this.cityTextfield.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(this.cityTextfield, "Invalid City Input");
				this.cityTextfield.setText("");
				return;				
			} //end if
			city = this.cityTextfield.getText().trim();
						
			//get State name
			if(this.stateTextfield.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(this.stateTextfield, "Invalid State Input");
				this.stateTextfield.setText("");
				return;				
			} //end if
			state = this.stateTextfield.getText().trim();
						
			//get Zip code
			try {
				zipCode = Integer.parseInt(this.zipCodeTextfield.getText().trim());
				if (zipCode <= 0)
					throw new Exception();
			        } catch (Exception ex) {
				JOptionPane.showMessageDialog(this.zipCodeTextfield, "Invalid Zip code input");
				this.zipCodeTextfield.setText("");
				return;				
			   }// end try
							
			PayRoll.createEmployeeBtnClick(eID, statusStr, fName, lName, street, houseNum, city, state, zipCode);//add data into the array
			
			//Clean out the input data
			IDTextfield.setText("");
			fNameTextfield.setText("");
			lNameTextfield.setText("");
			streetTextfield.setText("");
			houseNumTextfield.setText("");
			cityTextfield.setText("");
			stateTextfield.setText("");
			zipCodeTextfield.setText("");
			
		 
		 }// end of addEmployee
	  
	//Method for add pay record when hit add pay record button
	  void addRecord() throws FileNotFoundException{
		  int pID, rID, numbleOfMonth;
		  double monthIncome, hours, hourRate;
		  Date startDate = null, endDate = null;
		  
		  //Get period ID
		  try {
				
				pID = Integer.parseInt(this.pIDTextfield.getText().trim());
					if (pID <= 0)
						throw new Exception();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(this.pIDTextfield, "Invalid Pay ID");
					this.pIDTextfield.setText("");
					return;				
				}// end try
		  		  
		  //Get Start Date
		  if(this.startDateTextfield.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(this.startDateTextfield, "Invalid Start Date Input");
				this.startDateTextfield.setText("");
				return;				
			} //end if
		 DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		    try {
				startDate = dateFormat.parse(this.startDateTextfield.getText().trim());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
						
		//Get End Date	
			if(this.endDateTextfield.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(this.endDateTextfield, "Invalid End Date Input");
				this.endDateTextfield.setText("");
				return;				
			} //end if
		    try {
				endDate = dateFormat.parse(this.endDateTextfield.getText().trim());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    long diff = Math.abs(startDate.getTime() - endDate.getTime());
		    long dayDiff = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		    
		    //get record ID
		    try {
				
				rID = Integer.parseInt(this.rIDTextfield.getText().trim());
					if (rID <= 0)
						throw new Exception();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(this.rIDTextfield, "Invalid Employee ID");
					this.rIDTextfield.setText("");
					return;				
				}// end try-catch
			  
		//Get data input for full time				
		if(fullTimebtn.isSelected()) {
		   //Get Month Income
           try {
				
				monthIncome = Double.parseDouble(this.monthIncomeTextfield.getText().trim());
					if (monthIncome <= 0)
						throw new Exception();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(this.monthIncomeTextfield, "Invalid Month Income");
					this.monthIncomeTextfield.setText("");
					return;				
				}// end try
		  		  
		  //Get number of Months
		  try {
				
				numbleOfMonth = Integer.parseInt(this.numMonthTextfield.getText().trim());
				int periodDays = numbleOfMonth * 30;
					if (periodDays > dayDiff)   // judge if the number of months input is over the period.
						throw new Exception();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(this.numMonthTextfield, "Invalid pay month number which is overed the period");
					this.numMonthTextfield.setText("");
					return;				
				}// end try
		  		  
		  PayRoll.createPayRecordBtnClick(rID, pID, startDate, endDate, monthIncome, numbleOfMonth);//add data inot pay record array
		  
		  
		  //Clean out the input values
		  pIDTextfield.setText("");
		  startDateTextfield.setText("");
		  endDateTextfield.setText("");
		  monthIncomeTextfield.setText("");
		  numMonthTextfield.setText("");
			
		}//end of if
		
		//get data input for part time
		else {
			
			//get pay hours
	           try {
					
					hours = Double.parseDouble(this.hoursTextfield.getText().trim());
						if (hours < 0)
							throw new Exception();
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(this.hoursTextfield, "Invalid Pay hours");
						this.hoursTextfield.setText("");
						return;				
					}// end try
			 			  
			//get pay rate
			  try {
					
					hourRate = Double.parseDouble(this.payRateTextfield.getText().trim());
						if (hourRate < 0)
							throw new Exception();
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(this.payRateTextfield, "Invalid Pay rate");
						this.payRateTextfield.setText("");
						return;				
					}// end try
			  			  
			  PayRoll.createPayRecordBtnClick(rID, pID, startDate, endDate, hours, hourRate);
			  
			  //Clean out the input values
			  pIDTextfield.setText("");
			  rIDTextfield.setText("");
			  startDateTextfield.setText("");
			  endDateTextfield.setText("");
			  hoursTextfield.setText("");
			  payRateTextfield.setText("");
			
		    }//end of else if
		
		   PayRoll.writeToFile();
	  }
	  
	  
   //main class to launch the program
	public static void main(String[] args) throws FileNotFoundException, ParseException {
	   JFrame frame = new JFrame("Pay Roll Calculator");
        
        frame.add(new UserGUI());
        frame.pack();
        frame.setSize(700, 900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

	}

}
