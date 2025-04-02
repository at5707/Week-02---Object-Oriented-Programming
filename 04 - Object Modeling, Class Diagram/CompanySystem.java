import java.util.ArrayList;
import java.util.List;
class Employee{
	private String name;
	private String position;
	public Employee(String name,String position){
		this.name=name;
		this.position=position;
	}
	@Override
	public String toString(){
		return "Employee{Name='" + name + "', Position='" + position + "'}";
		}
}
class Department{
	private String name;
	private List<Employee> employees;
	public Department(String name){
		this.name=name;
		this.employees=new ArrayList<>();
	}
	public void addEmployee(String name,String position){
		employees.add(new Employee(name,position));
	}
	public void displayEmployees() {
        System.out.println("Department: " + name);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
class Company {
    private String name;
    private List<Department> departments;

    public Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public void displayDepartments() {
        System.out.println("Company: " + name);
        for (Department department : departments) {
            department.displayEmployees();
        }
    }
}
public class CompanySystem{
	public static void main(String[] args){
		Company company = new Company("TechCorp");
		Department hr = new Department("Human Resources");
        Department it = new Department("IT");
		hr.addEmployee("Alice", "HR Manager");
        hr.addEmployee("Bob", "Recruiter");
        it.addEmployee("Charlie", "Software Engineer");
        it.addEmployee("David", "System Administrator");
		company.addDepartment(hr);
        company.addDepartment(it);
		company.displayDepartments();
	}
}