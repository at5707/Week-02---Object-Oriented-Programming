class Employee{
    protected String name;
    protected int id;
    protected double salary;
    public Employee(String name,int id,double salary){
        this.name=name;
        this.id=id;
        this.salary=salary;
    }
    public void displayDetails(){
        System.out.println("ID: "+id+", Name: "+name+", Salary: $"+salary);
    }
}
class Manager extends Employee{
    private int teamSize;
    public Manager(String name,int id,double salary,int teamSize){
        super(name,id,salary);
        this.teamSize=teamSize;
    }
    @Override
    public void displayDetails(){
        super.displayDetails();
        System.out.println("Role: Manager, Team Size: "+teamSize);
    }
}
class Developer extends Employee{
    private String programmingLanguage;
    public Developer(String name,int id,double salary,String university){
        super(name,id,salary);
        this.programmingLanguage=programmingLanguage;
    }
    @Override
    public void displayDetails(){
        super.displayDetails();
        System.out.println("Role: Developer, Programming Language: "+programmingLanguage);
    }
}
public class EmployeeHierarchy{
    public static void main(String[] args){
        Employee manager = new Manager("Alice Johnson", 101, 75000, 10);
        Employee developer = new Developer("Bob Smith", 102, 60000, "Java");
        Employee intern = new Intern("Charlie Brown", 103, 20000, "MIT");
        System.out.println("Employee Details:\n");
        manager.displayDetails();
        System.out.println();
        developer.displayDetails();
        System.out.println();
        intern.displayDetails();
    }
}