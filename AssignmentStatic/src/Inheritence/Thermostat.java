package Inheritence;

public class Thermostat extends Device {
	private double tempSetting;
	
	public Thermostat(String deviceId , String status , double tempSetting) {
		super(deviceId , status);
		this.tempSetting = tempSetting;
	}
	public void displayStatus() {
        super.displayStatus();  
        System.out.println("Temperature Setting: " + tempSetting + "°C");
    }
	
	 public double getTemperatureSetting() {
	        return tempSetting;
	    }

	    public void setTemperatureSetting(double tempSetting) {
	        this.tempSetting = tempSetting;
	    }
}
