package model;

import java.util.ArrayList;

public class RadarData {
    private String radarId;
    private String location;
    private Vehicle vehicle;
    private String timestamp;
    private ArrayList<Violation> violations;

    public RadarData() { }

    public String getRadarId() { return radarId; }
    public String getLocation() { return location; }
    public Vehicle getVehicle() { return vehicle; }
    public String getTimeStamp() { return timestamp; }
    public ArrayList<Violation> getViolations() { return violations; }   
    
    public void setRadarId(String radarId) { this.radarId = radarId; }
    public void setLocation(String location) { this.location = location; }
    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }
    public void setViolations(ArrayList<Violation> violations) { this.violations = violations; }
    
}
