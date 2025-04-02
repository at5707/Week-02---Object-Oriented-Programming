class Vehicle{
	private static double registrationFee=5000.0;
	private final String registrationNumber;
	private String ownerName;
	private String vehicleType;
	public Vehicle(String ownerName,String vehicleType,String registrationNumber){
		this.ownerName=ownerName;
		this.vehicleType=vehicleType;
		this.registrationNumber=registrationNumber;
	}
	public static void updateRegistrationFee(double newFee){
		registrationFee=newFee;
	}
	public void displayVehicleDetails(){
		if(this instanceof Vehicle){
			System.out.println("Owner Name: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Registration Fee: $" + registrationFee);
		}else{
			System.out.println("Invalid vehicle object.");
		}
	}
	public static void main(String[] args){
        Vehicle vehicle1 = new Vehicle("John Doe", "Car", "ABC1234");
        Vehicle vehicle2 = new Vehicle("Jane Smith", "Motorcycle", "XYZ5678");
		vehicle1.displayVehicleDetails();
        System.out.println();
        vehicle2.displayVehicleDetails();
		Vehicle.updateRegistrationFee(6000.0);
        System.out.println("\nUpdated Registration Fee:");
		vehicle1.displayVehicleDetails();
        System.out.println();
        vehicle2.displayVehicleDetails();
	}
}