import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class EmployeeManagement {
	
	static Scanner scanner=new Scanner(System.in);
	
	static ArrayList<Employee> list=new ArrayList<>();
	static ArrayList<Attendance> attendance=new ArrayList<>();
	
	static int num;
	
	static public void getMainPage() {
		int selection=0;
		try {
			 	selection=scanner.nextInt();
		}
		catch (Exception e) {
			System.out.println("Invalid Input,Please select the valid input");
		}
		
		switch(selection) {
			case 1:{
					registerEmployee();
					System.out.println();
					welcomeNote();
					break;
					}
			case 2:
					markAttendance();
					System.out.println();
					welcomeNote();
					break;
					
			case 3:
					checkPreviousDetails();
					System.out.println();
					welcomeNote();
					break;
			case 4:
					exit();
					break;
			default:
					System.out.println("Invalid Input,Please select the valid input");
					getMainPage();
					break;
		}			
		
	}
	
	private static void checkPreviousDetails() {
			System.out.println("Please enter a Employee Id to login");
		    String empId=scanner.next().toUpperCase();
			
		    if(isEmployeeExist(empId)) {
		    	for(Attendance a:attendance) {
		    		if(empId.equals(a.getEmpId())) {
		    			System.out.println(a.getDate());
		    		}
		    	}
		    }
		    else {
		    	System.out.println("You are not a registered User");
				System.out.println("Please select 1 if you wish to register");
				System.out.println("Please select 2 to exit ");
				
				if(scanner.nextInt()==1) {
					registerEmployee();
				}
				else if(scanner.nextInt()==2){
					exit();
				}
		    }
	}

	static public void welcomeNote() {
		System.out.println("Welcome to Accenture");
		System.out.println("Please select the options to proceed");
		System.out.println("----------------------------------------");
		System.out.println("1.Register an Employee");
		System.out.println("2.Mark the attendance");
		System.out.println("3.Check the Previous Attendance Details");
		System.out.println("4.Exit");
		getMainPage();
	}
	
	private static void exit() {
		System.out.println("Thanks for your time");
	}

	private static boolean isEmployeeExist(String empId) {
		
		boolean falg=false;
		
		for(Employee emp:list) {
			if(empId.equals(emp.getEmpId()))
			{
				falg=true;
			}
		}
		return falg;
	}
	
	private static void markAttendance() {
		System.out.println("Please enter a Employee Id to login");
		String empId=scanner.next().toUpperCase();	
		if(isEmployeeExist(empId)){
				Attendance attend=new Attendance();
				attend.setEmpId(empId);
				attend.setDate(new Date());
				attendance.add(attend);
				System.out.println("Your Attendance is marked successfully");
			}
			else {
				System.out.println("You are not a registered User");
				System.out.println("Please select 1 if you wish to register");
				System.out.println("Please select 2 to exit ");
				
				if(scanner.nextInt()==1) {
					registerEmployee();
				}
				else if(scanner.nextInt()==2){
					exit();
				}
			}
		exit();
}

	private static void registerEmployee() {
		Employee employee=new Employee();
		System.out.println("Enter your First Name");
		employee.setEmpFirstName(scanner.next());
		
		System.out.println("Enter your Last Name");
		employee.setEmpLastName(scanner.next());
		
		System.out.println("Enter your Employee Id");
		employee.setEmpId(scanner.next().toUpperCase());
		
		System.out.println("Enter your Phone Number");
		employee.setEmpNumber(scanner.nextLong());
		
		System.out.println("Enter your Email Address");
		employee.setEmpEmail(scanner.next());
		
		list.add(employee);
		
		System.out.println("You have registered successfully");
		
		exit();
	}
	
	public static void main(String[] args) {
		welcomeNote();
	}
}

class Attendance {

	private String empId;
	private Date date;
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}

class Employee {
		private String empFirstName;
		private String empLastName;
		private String empId;
		private long empNumber;
		private String empEmail;

		public String getEmpFirstName() {
			return empFirstName;
		}
		public void setEmpFirstName(String empFirstName) {
			this.empFirstName = empFirstName;
		}
		public String getEmpLastName() {
			return empLastName;
		}
		public void setEmpLastName(String empLastName) {
			this.empLastName = empLastName;
		}
		public long getEmpNumber() {
			return empNumber;
		}
		public void setEmpNumber(long empNumber) {
			this.empNumber = empNumber;
		}
		public String getEmpEmail() {
			return empEmail;
		}
		public void setEmpEmail(String empEmail) {
			this.empEmail = empEmail;
		}
		public String getEmpId() {
			return empId;
		}
		public void setEmpId(String empId) {
			this.empId = empId;
		}
		
		
}
