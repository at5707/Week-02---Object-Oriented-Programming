import java.util.ArrayList;
import java.util.List;
class Course {
    private String name;
    private List<Student> students;

    public Course(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void enrollStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
            student.enrollInCourse(this); 
        }
    }

    public void displayStudents() {
        System.out.println("Course: " + name + " - Enrolled Students:");
        for (Student student : students) {
            System.out.println(student.getName());
        }
    }
}
class Student {
    private String name;
    private List<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void enrollInCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            course.enrollStudent(this); 
        }
    }

    public void displayCourses() {
        System.out.println("Student: " + name + " - Enrolled Courses:");
        for (Course course : courses) {
            System.out.println(course.getName());
        }
    }
}
class School {
    private String name;
    private List<Student> students;

    public School(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayStudents() {
        System.out.println("School: " + name + " - Students:");
        for (Student student : students) {
            System.out.println(student.getName());
        }
    }
}
public class SchoolSystem {
    public static void main(String[] args) {
        School school = new School("Greenwood High");
        Student alice = new Student("Alice");
        Student bob = new Student("Bob");
        Course math = new Course("Mathematics");
        Course science = new Course("Science");
        alice.enrollInCourse(math);
        bob.enrollInCourse(math);
        alice.enrollInCourse(science);
        school.addStudent(alice);
        school.addStudent(bob);
        school.displayStudents();
        alice.displayCourses();
        bob.displayCourses();
        math.displayStudents();
        science.displayStudents();
    }
}
