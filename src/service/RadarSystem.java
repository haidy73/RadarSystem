package service;

import dataReader.RadarDataReader;
import java.util.ArrayList;
import java.util.HashMap;
import model.Fine;
import model.RadarData;
import model.Vehicle;
import model.Violation;

public class RadarSystem {
    final private HashMap<String, Vehicle> finedVehicles;
    final private RadarDataReader radarDataReader;
    final private ViolationHandler violationHandler;

    public RadarSystem(RadarDataReader radarDataReader, ViolationHandler violationHandler) {
        this.finedVehicles = new HashMap<>();
        this.radarDataReader = radarDataReader;
        this.violationHandler = violationHandler;
    }

    public void processRadarData(String radarDataFilePath) {
        ArrayList<RadarData> radarData = radarDataReader.readRadarData(radarDataFilePath);
        for (RadarData data : radarData) {
            try {
                Fine fine = violationHandler.generateFine(data);
                Vehicle vehicle = data.getVehicle();

                if (finedVehicles.containsKey(vehicle.getPlateNum())) {
                    vehicle = finedVehicles.get(vehicle.getPlateNum());
                    vehicle.addFine(fine);
                } else {
                    vehicle.addFine(fine);
                    finedVehicles.put(vehicle.getPlateNum(), vehicle);
                }
                
            } catch (IllegalArgumentException e) {
                System.err.println("Error processing radar data: " + e.getMessage());
            }
        }

        printRadarProcessedData();
        System.out.println("Radar data processing completed successfully.\n");
    }

    private void printRadarProcessedData() {
        for (Vehicle vehicle : finedVehicles.values()) {
            for (Fine fine : vehicle.getFines()) {
                fine.printFine();
            }
        }
    }

    public void getAllFines() {
        
        System.out.println("--------------------------------------------------\n");
        for (Vehicle vehicle : finedVehicles.values()) {
            System.out.println("Vehicle Plate Number: " + vehicle.getPlateNum());
            Integer totalFines = 0;
            for (Fine fine : vehicle.getFines()) {
                totalFines += fine.getTotalFine();
            }
            System.out.println("Total Fines: " + totalFines + " EGP");
        }
    }

    public void getAllViolationsCount() {
        HashMap<String, Integer> violationCount = new HashMap<>();
        for (Vehicle vehicle : finedVehicles.values()) {
            for (Fine fine : vehicle.getFines()) {
                for (Violation violation : fine.getViolations()) {
                    violationCount.put(violation.getType(), violationCount.getOrDefault(violation.getType(), 0) + 1);
                }
            }
        }

        System.out.println("--------------------------------------------------");
        System.out.println("Violation Counts:");
        for (String violationType : violationCount.keySet()) {
            System.out.println(" - " + violationType + ": " + violationCount.get(violationType));
        }
    }

    public void showMenu() {
        System.out.println("--------------------------------------------------");
        System.out.println("Radar System Menu:");
        System.out.println("1. Get All Fines for Vehicles");
        System.out.println("2. Get All Violations Count");
        System.out.println("3. Exit");
    }



    


}