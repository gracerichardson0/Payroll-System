 public class Employee{
   private String empName;
   private int empID;
   private double hourlyPay;
   private double numHours;
   private String seniorYesOrNo;
   private double paycheck;
   private static int numEmployees;
   private static double total;
   
 /*
   Increments numEmployees each time that
   the constructor is instantiated
 */
 public Employee(){
   ++numEmployees;
 }

 public Employee(String empName, int empID ){
   this.empName=empName;
   this.empID=empID;
 }

 public Employee(String empName, int empID, double hourlyPay, double numHours, String seniorYesOrNo, double paycheck){
   this.empName=empName;
   this.empID=empID;
   this.hourlyPay=hourlyPay;
   this.numHours=numHours;
   this.seniorYesOrNo=seniorYesOrNo;
   
 }



 public String getEmpName(){return empName;}

 public int getEmpID(){return empID;}

 public double getHourlyPay(){return hourlyPay;}

 public double getNumHours(){return numHours;}

 public String getSeniorYesOrNo(){return seniorYesOrNo;}

 public double getPaycheck(){ return paycheck;}

 public static int getNumEmployees(){ return numEmployees; }
 
 public static double getTotal(){ return total; } 
 
 
 public void setEmpName(String empName){
   this.empName=empName;  
 }

 /**
   Validating mutator that checks the employee ID number
   to make sure it is a positive integer (greater than 0)
   If so, it returns a true value. Otherwise, false.
   
   @param empID the employee ID
   
   @return a boolean value of true or false is returned
 */
 public boolean setEmpID(int empID){
   if(empID>0){
      this.empID=empID;
      return true;
   }else{
      return false;    
   }
 }
 /**
   Validates to ensure that the hourly pay is greater
   than zero, and will return true if so. 
   If a negative number is entered, the method
   will return false. If the user enters 0, the value of
   the hourly pay will be a default value of 12.63.
   
   @param hourlyPay the hourly pay that the employee has
   
   @return the boolean value of true or false is returned
 */
 public boolean setHourlyPay(double hourlyPay){
   if(hourlyPay>0){
      this.hourlyPay=hourlyPay;
      return true;
   }else if(hourlyPay==0){
      this.hourlyPay=12.63;
      return true;
   }else if(hourlyPay<0){
      return false;
   }else{
      return false;
   }
 }


 /**
   Validates to check if the number of hours entered is greater than
   zero, which will return true. If the number of hours entered is not
   positive, the method will return false.
   
   @param numHours the number of hours the employee worked
   
   @return the boolean value of true or false is returned
 */
 public boolean setNumHours(double numHours){
   if(numHours>0.0){
      this.numHours=numHours;
      return true;
   }else{
      return false;
   }
 }

 /**
   Validates to check if the value entered for seniorYesOrNo is equal
   to Y or N. If the input is equal to either value, the method will
   return true. Else, it will return false.
   
   @param seniorYesOrNo the string which holds the employee's senior status
   
   @return boolean value of true or false is returned
 */
 public boolean setSeniorYesOrNo(String seniorYesOrNo){
   if(seniorYesOrNo.equalsIgnoreCase("y")){
      this.seniorYesOrNo ="y";
      return true;
   }else if(seniorYesOrNo.equalsIgnoreCase("n")){
       this.seniorYesOrNo= "n";
      return true;
   }else{
      return false;
   }
 }

 /**
   Calculates the paycheck that the employee has.
   If the employee works more than 40 hours, they will
   not receive any overtime pay in addition. If the employee
   is a senior, they will receive an extra $206.26 bonus to
   their paycheck.
   
   @return paycheck the paycheck for the employee is returned
   
 */
 public double calculatePayCheck() {
      if(getNumHours()>40.0){
         this.paycheck = (this.getHourlyPay() * 40);
         
      }else{
         this.paycheck = (this.getHourlyPay() * this.getNumHours());
      }
      
      if(this.seniorYesOrNo.equalsIgnoreCase("y")){
         this.paycheck = (this.getHourlyPay() * this.getNumHours() + 206.26);
      }
      
      if(this.getHourlyPay()==12.63){
         this.paycheck = (12.63 * this.getNumHours());
      }
      
      return paycheck; 
     }
 /**
   Calculates the total amount of money that the company
   must pay out to their employees, increments each employee's
   paycheck to the total amount.
   
  */
 public void calculateTotal() {
      this.total +=paycheck;
 }

 /**
   Returns a string representation of the object and holds all
   information about the employee.
   
   @return the employee's information and paycheck amount
 
 */
 public String toString(){
   return " Employee Report "+ "\n\n Employee Name: "+  this.getEmpName() + "\n Employee ID: "+ this.getEmpID()+ 
    "\n Pay Rate: $"+ this.getHourlyPay() + "\n Hours Worked: " + this.getNumHours() + "\n Senior: " + this.getSeniorYesOrNo()
    + "\n Paycheck Amount: " + String.format("$%.2f", this.getPaycheck());
   }
 }