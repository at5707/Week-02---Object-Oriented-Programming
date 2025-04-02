abstract class Employee{
    private int employeeId;
    private String name;
    private double baseSalary;
    public Employee(int employeeId,String name,double baseSalary){
        this.employeeId=employeeId;
        this.name=name;
        this.baseSalary=baseSalary;
    }
    public int getEmployeeId(){
        return employeeId;
    }
    public String getName(){
        return name;
    }
    public double getBaseSalary(){
        return baseSalary;
    }
    public abstract double calculateSalary();
    public void displayDetails(){
        System.out.println("Employee ID: "+employeeId);
        System.out.println("Name: "+name);
        System.out.println("Salary: "+calculateSalary());
    }
}
interface Department{
    void assignDepartment(String departmentName);
    String getDepartmentDetails();
}
class FullTimeEmployee extends Employee implements Department{
    private String department;
    public FullTimeEmployee(int employeeId,String name,double baseSalary){
        super(employeeId, name, baseSalary);
    }
    @Override
    public double calculateSalary(){
        return getBaseSalary();
    }
    @Override
    public void assignDepartment(String departmentName){
        this.department=departmentName;
    }
    @Override
    public String getDepartmentDetails(){
        return "Department: "+department;
    }
}
class PartTimeEmployee extends Employee implements Department{
    private int hoursWorked;
    private double hourlyRate;
    private String department;
    public PartTimeEmployee(int employeeId,String name,double hourlyRate,int hoursWorked){
        super(employeeId,name,0);
        this.hourlyRate=hourlyRate;
        this.hoursWorked=hoursWorked;
    }
    @Override
    public double calculateSalary(){
        return hourlyRate*hoursWorked;
    }
    @Override
    public void assignDepartment(String departmentName){
        this.department=departmentName;
    }
    @Override
    public String getDepartmentDetails(){
        return "Department: "+department;
    }
}
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Employee emp1=new FullTimeEmployee(101, "Alice", 50000);
        Employee emp2=new PartTimeEmployee(102, "Bob", 200, 20);
        ((Department) emp1).assignDepartment("HR");
        ((Department) emp2).assignDepartment("IT");
        System.out.println("Employee Details: ");
        emp1.displayDetails();
        System.out.println(((Department) emp1).getDepartmentDetails());
        System.out.println();
        emp2.displayDetails();
        System.out.println(((Department) emp2).getDepartmentDetails());
    }
}