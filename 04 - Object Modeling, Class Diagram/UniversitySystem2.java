import java.util.ArrayList;
import java.util.List;
class Course{
    private String name;
    private Professor professor;
    private List<Student> students;
	public Course(String name){
		this.name=name;
		this.students=new ArrayList<>();
	}
	public String getName(){
		return name;
	}
	public void assignProfessor(Professor professor){
		this.professor=professor;
	}
	public void enrollStudent(Student student){
		if(!students.contains(student)){
			students.add(student);
			student.enrollCourse(this);
		}
	}
	public void displayCourseDetails(){
		System.out.println("Course: "+name);
		if(professor!=null){
			System.out.println("Taught by: "+professor.getName());
		}
		System.out.println("Enrolled Students:");
		for(Student student:students){
			System.out.println(student.getName());
		}
	}
}
class Professor{
	private String name;
	private List<Course> courses;
	public Professor(String name){
		this.name=name;
		this.courses=new ArrayList<>();
	}
	public String getName(){
		return name;
	}
	public void teachCourse(Course course){
		if(!courses.contains(course)){
			courses.add(course);
			course.assignProfessor(this);
		}
	}
	public void displayCourses(){
		System.out.println("Professor "+name+" teaches:");
		for(Course course:courses){
			System.out.println(course.getName());
		}
	}
}
class Student{
	private String name;
	private List<Course> courses;
	public Student(String name){
		this.name=name;
		this.courses=new ArrayList<>();
	}
	public String getName(){
		return name;
	}
	public void enrollCourse(Course course){
		if(!courses.contains(course)){
			courses.add(course);
		}
	}
	public void displayCourses(){
		System.out.println("Student "+name+" is enrolled in:");
		for(Course course:courses){
			System.out.println(course.getName());
		}
	}
}
public class UniversitySystem2{
	public static void main(String[] args){
		Professor drSmith = new Professor("Dr. Smith");
        Professor drJones = new Professor("Dr. Jones");
		Course math = new Course("Mathematics");
        Course science = new Course("Science");
		drSmith.teachCourse(math);
        drJones.teachCourse(science);
		Student alice = new Student("Alice");
        Student bob = new Student("Bob");
		math.enrollStudent(alice);
        science.enrollStudent(alice);
        science.enrollStudent(bob);
		math.displayCourseDetails();
        science.displayCourseDetails();
        drSmith.displayCourses();
        drJones.displayCourses();
        alice.displayCourses();
        bob.displayCourses();
	}
}