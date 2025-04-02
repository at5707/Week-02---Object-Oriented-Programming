class Vehicle{
    protected String model;
    protected int maxSpeed;
    public Vehicle(String model,int maxSpeed){
        this.model=model;
        this.maxSpeed=maxSpeed;
    }
    public void displayDetails(){
        System.out.println("Model: "+model+", Max Speed: "+maxSpeed+" km/h");
    }
}
interface Refuelable{
    void refuel();
}
class ElectricVehicle extends Vehicle{
    private int batteryCapacity;
    public ElectricVehicle(String model,int maxSpeed,int batteryCapacity){
        super(model,maxSpeed);
        this.batteryCapacity=batteryCapacity;
    }
    @Override
        public void displayDetails(){
            super.displayDetails();
            System.out.println("Battery Capacity: "+batteryCapacity+" kWh");
        }
    public void charge(){
        System.out.println(model+" is charging. Battery capacity: "+batteryCapacity+" kWh.");
    }
}
class PetrolVehicle extends Vehicle implements Refuelable{
    private int fuelCapacity;
    public PetrolVehicle(String model,int maxSpeed,int fuelCapacity){
        super(model,maxSpeed);
        this.fuelCapacity=fuelCapacity;
    }
    @Override
    public void displayDetails(){
        super.displayDetails();
        System.out.println("Fuel Capacity: "+fuelCapacity+" liters");
    }
    @Override
    public void refuel(){
        System.out.println(model+" is refueling. Fuel capacity: "+fuelCapacity+" litres.");
    }
}
public class VehicleSystem{
    public static void main(String[] args){
        ElectricVehicle ev = new ElectricVehicle("Tesla Model 3", 200, 75);
        PetrolVehicle pv = new PetrolVehicle("Ford Mustang", 250, 60);

        System.out.println("\n--- Electric Vehicle Details ---");
        ev.displayDetails();
        ev.charge();

        System.out.println("\n--- Petrol Vehicle Details ---");
        pv.displayDetails();
        pv.refuel();
    }
}