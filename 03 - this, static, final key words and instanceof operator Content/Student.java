class Student{
	private static String universityName="Global University";
	private static int totalStudents=0;
	private final int rollNumber;
	private String name;
	private char grade;
	public Student(String name,int rollNumber,char grade){
		this.name=name;
		this.rollNumber=rollNumber;
		this.grade=grade;
		totalStudents++;
	}
	public static void displayTotalStudents(){
		System.out.println("Total Students Enrolled: "+totalStudents);
	}
	public void displayStudentDetails(){
		if(this instanceof Student){
			System.out.println("University: "+universityName);
			System.out.println("Roll Number: "+rollNumber);
			System.out.println("Name: "+name);
			System.out.println("Grade: "+grade);
		}else{
			System.out.println("Invalid student object.");
		}
	}
	public void updateGrade(char newGrade) {
        if (this instanceof Student) {
            this.grade = newGrade;
            System.out.println("Grade updated successfully for " + name);
        } else {
            System.out.println("Invalid student object. Cannot update grade.");
        }
    }
	public static void main(String[] args){
		Student stu1 = new Student("Alice Brown", 101, 'A');
        Student stu2 = new Student("Bob White", 102, 'B');
		stu1.displayStudentDetails();
        System.out.println();
        stu2.displayStudentDetails();
		stu2.updateGrade('A');
        System.out.println();
        stu2.displayStudentDetails();
		Student.displayTotalStudents();
	}
}