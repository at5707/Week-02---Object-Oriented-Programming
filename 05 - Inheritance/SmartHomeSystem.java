class Device{
    protected String deviceId;
    protected boolean status;
    public Device(String deviceId,boolean status){
        this.deviceId=deviceId;
        this.status=status;
    }
    public void turnOn(){
        status=true;
    }
    public void turnOff(){
        status=false;
    }
    public void displayStatus(){
        System.out.println("Device ID: "+deviceId);
        System.out.println("Status: "+(status?"ON":"OFF"));
    }
}
class Thermostat extends Device{
    private double temperatureSetting;
    public Thermostat(String deviceId,boolean status,double temperatureSetting){
        super(deviceId,status);
        this.temperatureSetting=temperatureSetting;
    }
    public void setTemperature(double temperature){
        this.temperatureSetting=temperature;
    }
    @Override
    public void displayStatus(){
        super.displayStatus();
        System.out.println("Temperature Setting: "+temperatureSetting+"C");
    }
}
public class SmartHomeSystem{
    public static void main(String[] args){
        Device genericDevice = new Device("D001", true);
        Thermostat thermostat = new Thermostat("T100", true, 22.5);
        System.out.println("Generic Device Status:");
        genericDevice.displayStatus();
        System.out.println();

        System.out.println("Thermostat Status:");
        thermostat.displayStatus();
        thermostat.turnOff();
        thermostat.setTemperature(18.0);
        System.out.println("\nAfter adjustments:");
        thermostat.displayStatus();
    }
}
