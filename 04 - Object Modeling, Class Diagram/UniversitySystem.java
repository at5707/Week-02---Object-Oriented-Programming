import java.util.ArrayList;
import java.util.List;
class Faculty {
    private String name;
    private String specialization;

    public Faculty(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "Faculty{Name='" + name + "', Specialization='" + specialization + "'}";
    }
}
class Department {
    private String name;
    private List<Faculty> facultyMembers;

    public Department(String name) {
        this.name = name;
        this.facultyMembers = new ArrayList<>();
    }

    public void addFaculty(Faculty faculty) {
        facultyMembers.add(faculty);
    }

    public void displayFaculty() {
        System.out.println("Department: " + name + " - Faculty Members:");
        for (Faculty faculty : facultyMembers) {
            System.out.println(faculty);
        }
    }

    public String getName() {
        return name;
    }
}
class University {
    private String name;
    private List<Department> departments;

    public University(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public void displayDepartments() {
        System.out.println("University: " + name + " - Departments:");
        for (Department department : departments) {
            System.out.println(department.getName());
        }
    }
}
public class UniversitySystem {
    public static void main(String[] args) {
        Faculty profSmith = new Faculty("Dr. Smith", "Computer Science");
        Faculty profJohnson = new Faculty("Dr. Johnson", "Mathematics");
        University university = new University("Tech University");
        Department csDepartment = new Department("Computer Science");
        Department mathDepartment = new Department("Mathematics");
        csDepartment.addFaculty(profSmith);
        mathDepartment.addFaculty(profJohnson);
        university.addDepartment(csDepartment);
        university.addDepartment(mathDepartment);
        university.displayDepartments();
        csDepartment.displayFaculty();
        mathDepartment.displayFaculty();
    }
}
