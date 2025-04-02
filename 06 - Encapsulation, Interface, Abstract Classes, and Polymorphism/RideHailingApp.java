import java.util.*;
abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    
    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }
    
    public String getVehicleId() {
        return vehicleId;
    }
    
    public String getDriverName() {
        return driverName;
    }
    
    public double getRatePerKm() {
        return ratePerKm;
    }
    
    public abstract double calculateFare(double distance);
    
    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate per Km: " + ratePerKm);
    }
}
interface GPS {
    void getCurrentLocation();
    void updateLocation(String newLocation);
}
class Car extends Vehicle implements GPS {
    private String currentLocation;
    
    public Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = "Unknown";
    }
    
    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }
    
    @Override
    public void getCurrentLocation() {
        System.out.println("Car Location: " + currentLocation);
    }
    
    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
        System.out.println("Car location updated to: " + newLocation);
    }
}
class Bike extends Vehicle implements GPS {
    private String currentLocation;
    
    public Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = "Unknown";
    }
    
    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }
    
    @Override
    public void getCurrentLocation() {
        System.out.println("Bike Location: " + currentLocation);
    }
    
    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
        System.out.println("Bike location updated to: " + newLocation);
    }
}
class Auto extends Vehicle {
    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }
    
    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }
}
public class RideHailingApp {
    public static void main(String[] args) {
        List<Vehicle> rides = new ArrayList<>();
        rides.add(new Car("C101", "John Doe", 12.5));
        rides.add(new Bike("B202", "Emma Watson", 8.0));
        rides.add(new Auto("A303", "Robert Brown", 10.0));
        
        double distance = 15.0; // Example distance in km

        for (Vehicle ride : rides) {
            ride.getVehicleDetails();
            System.out.println("Fare for " + distance + " km: " + ride.calculateFare(distance));

            if (ride instanceof GPS) {
                GPS gpsVehicle = (GPS) ride;
                gpsVehicle.getCurrentLocation();
                gpsVehicle.updateLocation("Downtown");
            }
            System.out.println("------------------------------");
        }
    }
}
