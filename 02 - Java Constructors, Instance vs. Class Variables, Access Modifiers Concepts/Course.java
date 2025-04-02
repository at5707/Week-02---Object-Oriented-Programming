class Course{
	private static String instituteName="Default Institute";
	private String courseName;
	private int duration;
	private double fee;
	public Course(String courseName,int duration,double fee){
		this.courseName=courseName;
		this.duration=duration;
		this.fee=fee;
	}
	public void displayCourseDetails(){
		System.out.println("Institute Name: "+instituteName);
		System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " months");
        System.out.println("Fee: $" + String.format("%.2f", fee));
	}
	public static void updateInstituteName(String newInstituteName){
		instituteName=newInstituteName;
	}
	public static void main(String[] args){
		Course.updateInstituteName("Tech Academy");
		Course c1=new Course("Java Programming",6,499.99);
		Course c2=new Course("Data Science",12,999.99);
		c1.displayCourseDetails();
		System.out.println();
		c2.displayCourseDetails();
	}
}