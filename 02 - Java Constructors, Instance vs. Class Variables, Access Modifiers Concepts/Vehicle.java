class Vehicle{
	private static double registrationFee=500.00;
	private String ownerName;
	private String vehicleType;
	public Vehicle(String ownerName,String vehicleType){
		this.ownerName=ownerName;
		this.vehicleType=vehicleType;
	}
	public void displayVehicleDetails(){
		System.out.println("Owner Name: "+ownerName);
		System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: $" + String.format("%.2f", registrationFee));
	}
	public static void updateRegistrationFee(double newFee){
		registrationFee=newFee;
	}
	public static void main(String[] args){
		Vehicle.updateRegistrationFee(600.00);
		Vehicle v1=new Vehicle("Alice","Car");
		Vehicle v2=new Vehicle("Bob","Motorcycle");
		v1.displayVehicleDetails();
		System.out.println();
		v2.displayVehicleDetails();
	}
}