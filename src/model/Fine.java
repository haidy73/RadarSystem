package model;

import java.util.ArrayList;

public class Fine {
    final private String radarId;
    final private String location;
    final private String timestamp;
    final private Vehicle vehicle;
    final private Integer totalFine;
    final private ArrayList<Violation> violations;

    public Fine(String radarId, String location, String timestamp, Vehicle vehicle, Integer totalFine, ArrayList<Violation> violations) {
        this.radarId = radarId;
        this.location = location;
        this.timestamp = timestamp;
        this.vehicle = vehicle;
        this.totalFine = totalFine;
        this.violations = violations;
    }

    public String getRadarId() { return this.radarId; }
    public String getLocation() { return this.location; }
    public String getTimeStamp() { return this.timestamp; }
    public Vehicle getVehicle() { return this.vehicle; }
    public Integer getTotalFine() { return this.totalFine; }
    public ArrayList<Violation> getViolations() { return this.violations; }


    public void printFine() {
        
        System.out.println("===============================================================\n");
        System.out.println("Radar ID: " + this.radarId);
        System.out.println("Location: " + this.location);
        System.out.println("Timestamp: " + this.timestamp);
        System.out.println("Vehicle Plate Number: " + this.vehicle.getPlateNum());
        System.out.println("Vehicle Type: " + this.vehicle.getType());
        System.out.println("Total Fine: " + this.totalFine + " EGP");
        System.out.println("Violations:");
        for (Violation violation : this.violations) {
            System.out.println(" - Type: " + violation.getType() + ", Description: " + violation.getDescription() + " Price: " + violation.getFineAmount() + " EGP");
        }
    }
}
