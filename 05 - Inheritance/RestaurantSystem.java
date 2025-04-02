class Person{
    protected String name;
    protected int id;
    public Person(String name,int id){
        this.name=name;
        this.id=id;
    }
    public void displayDetails(){
        System.out.println("ID: "+id+", Name: "+name);
    }
}
interface Worker{
    void performDuties();
}
class Chef extends Person implements Worker{
    private String speciality;
    public Chef(String name,int id,String speciality){
        super(name,id);
        this.speciality=speciality;
    }
    @Override
    public void performDuties(){
        System.out.println("Preparing Dishes. Speciality: "+speciality);
    }
}
class Waiter extends Person implements Worker{
    private int tableCount;
    public Waiter(String name,int id,int tableCount){
        super(name,id);
        this.tableCount=tableCount;
    }
    @Override
    public void performDuties(){
        System.out.println("Serving customers at "+tableCount+" tables.");
    }
}
public class RestaurantSystem{
    public static void main(String[] args){
        Chef chef = new Chef("Gordon Ramsay", 101, "Italian Cuisine");
        Waiter waiter = new Waiter("John Doe", 202, 5);

        System.out.println("\n--- Chef Details ---");
        chef.displayDetails();
        chef.performDuties();

        System.out.println("\n--- Waiter Details ---");
        waiter.displayDetails();
        waiter.performDuties();
    }
}