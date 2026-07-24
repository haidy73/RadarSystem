import dataReader.JsonRadarDataReader;
import dataReader.RadarDataReader;
import java.util.Scanner;
import service.RadarSystem;
import service.ViolationHandler;

public class App {
    public static void main(String[] args) throws Exception {
        RadarDataReader reader = new JsonRadarDataReader();
        ViolationHandler violationHandler = new ViolationHandler();
        
        // Create the radar system
        RadarSystem radarSystem = new RadarSystem(reader, violationHandler);
        
        // Process the radar data file
        String filePath = "data/radarData.json";
        radarSystem.processRadarData(filePath);
        

        radarSystem.showMenu();

        try (Scanner scanner = new java.util.Scanner(System.in)) {
            boolean exit = false;
            while (!exit) {
                System.out.print("Enter your choice (1-3): ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> radarSystem.getAllFines();
                    case 2 -> radarSystem.getAllViolationsCount();
                    case 3 -> {
                        exit = true;
                        System.out.println("Exiting the program.");
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            }
            
        } catch (Exception e) {
            
        }
    }
}
