package Inheritence;

public class SmartHome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Device lamp = new Device("D001", "ON");

	        // Create a thermostat
	        Thermostat thermostat = new Thermostat("T001", "OFF", 22.5);

	        // Display status of each device
	        System.out.println("Lamp Status:");
	        lamp.displayStatus();

	        System.out.println("\nThermostat Status:");
	        thermostat.displayStatus();
	}

}
