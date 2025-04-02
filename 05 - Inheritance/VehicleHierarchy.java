class Vehicle{
    protected int maxSpeed;
    protected String fuelType;
    public Vehicle(int maxSpeed,String fuelType){
        this.maxSpeed=maxSpeed;
        this.fuelType=fuelType;
    }
    public void displayInfo(){
        System.out.println("Max Speed: "+maxSpeed+" km/h, Fuel Type: "+fuelType);
    }
}
class Car extends Vehicle{
    private int seatCapacity;
    public Car(int maxSpeed,String fuelType,int seatCapacity){
        super(maxSpeed,fuelType);
        this.seatCapacity=seatCapacity;
    }
    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Vehicle Type: Car, Seat Capacity: "+seatCapacity);
    }
}
class Truck extends Vehicle{
    private double loadCapacity;
    public Truck(int maxSpeed,String fuelType,double loadCapacity){
        super(maxSpeed,fuelType);
        this.loadCapacity=loadCapacity;
    }
    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Vehicle Type: Truck, Load Capacity: "+loadCapacity+" tons");
    }
}
class Motorcycle extends Vehicle{
    private boolean hasSideCar;
    public Motorcycle(int maxSpeed,String fuelType,boolean hasSideCar){
        super(maxSpeed,fuelType);
        this.hasSideCar=hasSideCar;
    }
    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Vehicle Type: Motorcycle, Has Sidecar: "+(hasSideCar?"Yes":"No"));
    }
}
public class VehicleHierarchy{
    public static void main(String[] args){
        Vehicle[] vehicles=new Vehicle[3];
        vehicles[0]=new Car(200,"Petrol",5);
        vehicles[1]=new Truck(120,"Diesel",10);
        vehicles[2]=new Motorcycle(180,"Petrol",false);
        System.out.println("Vehicle Details:\n");
        for(Vehicle vehicle:vehicles){
            vehicle.displayInfo();
            System.out.println();
        }
    }
}