package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.Fine;
import model.RadarData;
import model.Vehicle;
import model.Violation;

public class ViolationHandler {
    final private Map<String, Integer> predefinedViolations;  
    
    public ViolationHandler() {
        this.predefinedViolations = new HashMap<>();
        
        // Add some predefined violations
        predefinedViolations.put("SPEEDING", 100);
        predefinedViolations.put("USING_PHONE", 200);
        predefinedViolations.put("NO_SEATBELT", 50);
        predefinedViolations.put("RED_LIGHT", 120);
    }
    
    public void addViolation(String type, Integer fine) {
        predefinedViolations.put(type, fine);
    }

    public Fine generateFine(RadarData radarData) {
        
        String radarId = radarData.getRadarId();
        String location = radarData.getLocation();
        String timestamp = radarData.getTimeStamp();
        Vehicle vehicle = radarData.getVehicle();
        ArrayList<Violation> violations = radarData.getViolations();

        Integer totalFine = 0;
        for (Violation violation : violations) {
            if (!predefinedViolations.containsKey(violation.getType())) {
                throw new IllegalArgumentException("Violation type " + violation.getType() + " is not predefined.");
            } else {
                violation.setFineAmount(predefinedViolations.get(violation.getType()));
                totalFine += predefinedViolations.get(violation.getType());
            }
        }

        return new Fine(radarId, location, timestamp, vehicle, totalFine, violations);
    }

}