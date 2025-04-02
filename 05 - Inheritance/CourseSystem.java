class Course{
    protected String courseName;
    protected int duration;
    public Course(String courseName,int duration){
        this.courseName=courseName;
        this.duration=duration;
    }
    public void displayCourseDetails(){
        System.out.println("Course Name: "+courseName);
        System.out.println("Duration: "+duration+" weeks");
    }
}
class OnlineCourse extends Course{
    protected String platform;
    protected boolean isRecorded;
    public OnlineCourse(String courseName,int duration,String platform,boolean isRecorded){
        super(courseName,duration);
        this.platform=platform;
        this.isRecorded=isRecorded;
    }
    @Override
    public void displayCourseDetails(){
        super.displayCourseDetails();
        System.out.println("Plarform: "+platform);
        System.out.println("Recorded: "+(isRecorded?"Yes":"No"));
    }
}
class PaidOnlineCourse extends OnlineCourse{
    private double fee;
    private double discount;
    public PaidOnlineCourse(String courseName,int duration,String platform,boolean isRecorded,double fee,double discount){
        super(courseName,duration,platform,isRecorded);
        this.fee=fee;
        this.discount=discount;
    }
    public double calculateDiscountedFee(){
        return fee-(fee*discount/100);
    }
    @Override
    public void displayCourseDetails(){
        super.displayCourseDetails();
        System.out.println("Fee: $"+fee);
        System.out.println("Discount: "+discount+"%");
        System.out.println("Final Price After Discount: $"+calculateDiscountedFee());
    }
}
public class CourseSystem {
    public static void main(String[] args){
        Course basicCourse = new Course("Introduction to Programming", 4);
        OnlineCourse onlineCourse = new OnlineCourse("Java Basics", 6, "Udemy", true);
        PaidOnlineCourse paidCourse = new PaidOnlineCourse("Advanced Machine Learning", 8, "Coursera", true, 199.99, 20);
        System.out.println("Basic Course Details:\n");
        basicCourse.displayCourseDetails();
        System.out.println("\n------------------------\n");
        System.out.println("Online Course Details:\n");
        onlineCourse.displayCourseDetails();
        System.out.println("\n------------------------\n");
        System.out.println("Paid Online Course Details:\n");
        paidCourse.displayCourseDetails();
    }
}
