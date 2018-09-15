/**
   Name: Nicholas Richardson
   Date: 9/25/2016
   Course/Section: IT 206.DL1
   Assignment: Programming Assignment 2
   
   Description:
   
   This program is a payroll application used to track 
   hourly employees. The purpose of this program is to have
   the user create employees with a specific name, ID, hourly pay,
   number of hours worked, and their status as a senior or not.
   The name and ID Number of the employee must be provided, at
   a minimum. Senior employees will receive an additional $206.26
   added to their paycheck. All inputs will be validated.
   After each employee's information is entered, an employee report
   will be displayed to the user, with the information they entered
   for the employee, including the paycheck amount.
   
   The user will input the following for each employee:
   1. Name
   2. ID
   3. Hourly pay
   4. Number of hours worked
   5. Employee senior status
   
   The user will be able to enter more employees until they wish to stop.
   After they are done entering employees, a report will display to the user
   displaying:
   
   1. Number of employees entered
   2. Total amount paid to all employees
   3. A thank you message
  */

import javax.swing.JOptionPane;

public class Company{
   public static void main(String[] args){
   /**
      Processes employees until the user indicates
      that they are done entering employees.
     */
   
      String enterAnotherEmployee = "y";
      do {
         Employee anEmployee = addEmployee();
         anEmployee.calculatePayCheck();
         anEmployee.calculateTotal();
         JOptionPane.showMessageDialog(null, anEmployee.toString());
         enterAnotherEmployee = JOptionPane.showInputDialog("Enter another employee? Enter y or n: ");
      }while (enterAnotherEmployee.equalsIgnoreCase("y"));
      
      printReport(Employee.getTotal(), Employee.getNumEmployees());
    }
    
    /**
       Creates an object anEmployee and continually prompts the user for the
       employee name, ID, hourly pay, number of hours, and senior status until
       they wish to stop.
       
       @return the Employee class with the information for the anEmployee object
       that was created and populated within the method
    */
    
    private static Employee addEmployee() {
       Employee anEmployee = new Employee();
       
       //Input for the employee name
       anEmployee.setEmpName(JOptionPane.showInputDialog("Please enter the name of the employee: "));
       
       int empID;
       double hourlyPay;
       double numHours;
       String senior = "";
       
       
       /**
          Continually will prompt the user to enter the employee ID for the specified employee
          until valid input is entered (no strings). Error message will be presented if invalid.
       */
       
       do{
         try{
             empID= Integer.parseInt(JOptionPane.showInputDialog("Please enter the ID number of " + anEmployee.getEmpName()+ ":"));
            }catch(NumberFormatException e){
             empID=-1;
            }
            if(!anEmployee.setEmpID(empID)){
               JOptionPane.showMessageDialog(null, "Error: Please enter a valid employee ID number for "+ anEmployee.getEmpName());
              }
        }while(!anEmployee.setEmpID(empID));
       
       /**
          Continually prompts the user to enter the hourly pay for the employee.
          If invalid input is entered, an error message will be displayed (no negative
          numbers).
       */
          
       do{
         try{
              /**
                 If the employee does not have an hourly pay
                 specified, it will default to a value set in the Employee
                 class.
              */
              hourlyPay = Double.parseDouble(JOptionPane.showInputDialog("Please enter the hourly pay rate for " + anEmployee.getEmpName() + ": \nIf " + anEmployee.getEmpName() +
              "'s hourly pay is unknown, type 0 for the default."));
            }catch(NumberFormatException e){
              hourlyPay= -1.0;
            }
            if(!anEmployee.setHourlyPay(hourlyPay)){
               JOptionPane.showMessageDialog(null, "Error: Please enter a valid hourly pay rate: ");
              }
        }while(!anEmployee.setHourlyPay(hourlyPay));
        
       /** 
          Continually prompts the user to enter the number of hours the employee worked.
          Will display an error message if invalid input is entered (no negative numbers).
        */
       
       do{
         try{
              numHours = Double.parseDouble(JOptionPane.showInputDialog("Please enter the number of hours worked by " + anEmployee.getEmpName() + ": "));
            }catch(NumberFormatException e){
               numHours= -1.0;
            }
            if(!anEmployee.setNumHours(numHours)){
               JOptionPane.showMessageDialog(null, "Error: Please enter a valid number of hours worked by " + anEmployee.getEmpName());
              }
        }while(!anEmployee.setNumHours(numHours));
        
       /**
          Continually prompts the user to enter the senior status of the employee
          until it is either 'y' for yes, or 'n' for no. 
        */
       do{
            senior = JOptionPane.showInputDialog("Please enter y or n if " + anEmployee.getEmpName() + " is a senior employee: ");
            if (!anEmployee.setSeniorYesOrNo(senior)){
               JOptionPane.showMessageDialog(null, "Error: please enter y or n");
            }
       }while(!anEmployee.setSeniorYesOrNo(senior));
           
       return anEmployee;
    }
    
    /**
       Prints the company report to the user, displaying the 
       number of employees, amount paid to employees in total,
       and a thank you message to the user.
       
       @param total the total amount of money the company must pay to their employees
       @param numEmployees the total number of employees created
       
    
       @return the company report with the number of employees, total amount paid to
       employees, and a thank you message, shown after the user is done entering employees
       
      */
    private static void printReport(double total, int numEmployees) {
      JOptionPane.showMessageDialog(null, " Company Report" + "\n\n Number of Employees: " + numEmployees +
       "\n Total amount paid to employees: " + String.format("$%.2f",total)
        + "\n\n Thank you for using this program!!");
    }
   }