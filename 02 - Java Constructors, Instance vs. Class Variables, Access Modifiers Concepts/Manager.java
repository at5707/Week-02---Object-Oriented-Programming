class Employee{
	public int employeeID;
	protected String department;
	private double salary;
	public Employee(int employeeID,String department,double salary){
		this.employeeID=employeeID;
		this.department=department;
		this.salary=salary;
	}
	public double getSalary(){
		return salary;
	}
	public void setSalary(double salary){
		if(salary>=0){
			this.salary=salary;
		}else{
			System.out.println("Salary cannot be negative.");
		}
	}
	public void displayEmployeeDetails(){
		System.out.println("Employee ID: "+employeeID);
        System.out.println("Department: "+department);
        System.out.println("Salary: $"+String.format("%.2f", salary));
	}
}
class Manager extends Employee{
	private String teamName;
	public Manager(int employeeID,String department,double salary,String teamName){
		super(employeeID,department,salary);
		this.teamName=teamName;
	}
	public void displayManagerDetails(){
		System.out.println("Employee ID: "+employeeID);
		System.out.println("Department: "+department);
		System.out.println("Team Name: "+teamName);
	}
	public static void main(String[] args){
		Employee emp1=new Employee(101,"IT",50000);
		emp1.displayEmployeeDetails();
		emp1.setSalary(55000);
		System.out.println("Updated salary: $"+emp1.getSalary());
		System.out.println();
		Manager mgr1=new Manager(201,"HR",70000,"Recruitment");
		mgr1.displayManagerDetails();
	}
}