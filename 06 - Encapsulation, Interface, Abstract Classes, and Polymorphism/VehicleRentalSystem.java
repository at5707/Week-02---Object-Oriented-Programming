import java.util.*;
abstract class Vehicle{
    private String vehicleNumber;
    private String type;
    private double rentalRate;
    public Vehicle(String vehicleNumber,String type,double rentalRate){
        this.vehicleNumber=vehicleNumber;
        this.type=type;
        this.rentalRate=rentalRate;
    }
    public String getVehicleNumber(){
        return vehicleNumber;
    }
    public String getType(){
        return type;
    }
    public double getRentalRate(){
        return rentalRate;
    }
    public void setRentalRate(double rentalRate){
        this.rentalRate=rentalRate;
    }
    public abstract double calculateRentalCost(int days);
    public void displayDetails(){
        System.out.println("Vehicle Number: "+vehicleNumber);
        System.out.println("Type: "+type);
        System.out.println("Rental Rate per Day: "+rentalRate);
    }
}
interface Insurable{
    double calculateInsurance();
    String getInsuranceDetails();
}
class Car extends Vehicle implements Insurable{
    private double insuranceRate=0.02;
    public Car(String vehicleNumber,double rentalRate){
        super(vehicleNumber, "Car", rentalRate);
    }
    @Override
    public double calculateRentalCost(int days){
        return getRentalRate()*days;
    }
    @Override
    public double calculateInsurance(){
        return calculateRentalCost(1)*insuranceRate;
    }
    @Override
    public String getInsuranceDetails(){
        return "Insurance Rate: "+(insuranceRate*100)+"% per day";
    }
}
class Bike extends Vehicle{
    private double discount=0.10;
    public Bike(String vehicleNumber,double rentalRate){
        super(vehicleNumber, "Bike", rentalRate);
    }
    @Override
    public double calculateRentalCost(int days){
        double totalCost=getRentalRate()*days;
        if(days>3){
            totalCost-=totalCost*discount;
        }
        return totalCost;
    }
}
class Truck extends Vehicle implements Insurable{
    private double insuranceRate=0.05;
    public Truck(String vehicleNumber,double rentalRate){
        super(vehicleNumber, "Truck", rentalRate);
    }
    @Override
    public double calculateRentalCost(int days){
        return getRentalRate()*days;
    }
    @Override
    public double calculateInsurance(){
        return calculateRentalCost(1)*insuranceRate;
    }
    @Override
    public String getInsuranceDetails(){
        return "Insurance Rate: "+(insuranceRate*100)+"% per day";
    }
}
public class VehicleRentalSystem {
    public static void main(String[] args) {
        List<Vehicle> vehicles=new ArrayList<>();
        vehicles.add(new Car("CAR123", 1000));
        vehicles.add(new Bike("BIKE456", 300));
        vehicles.add(new Truck("TRUCK789", 5000));
        int rentalDays=5;
        for(Vehicle vehicle:vehicles){
            vehicle.displayDetails();
            double rentalCost=vehicle.calculateRentalCost(rentalDays);
            System.out.println("Rental Cost for "+rentalDays+" days: "+rentalCost);
            if(vehicle instanceof Insurable){
                Insurable insurableVehicle=(Insurable) vehicle;
                double insuranceCost=insurableVehicle.calculateInsurance()*rentalDays;
                System.out.println(insurableVehicle.getInsuranceDetails());
                System.out.println("Insurance Cost for "+rentalDays+" days: "+insuranceCost);
            }
            System.out.println("---------------------");
        }
    }
}
