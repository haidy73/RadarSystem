package model;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Vehicle {
    private String plateNum;
    private String type;

    @JsonIgnoreProperties
    private ArrayList<Fine> fines;

    public Vehicle() { this.fines = new ArrayList<>(); }

    public Vehicle(String plateNum, String type) {
        this.plateNum = plateNum;
        this.type = type;
        this.fines = new ArrayList<>();
    }

    public String getPlateNum() { return plateNum; }
    public String getType() { return type; }
    public ArrayList<Fine> getFines() { return fines; }

    public void setPlateNum(String plateNum) { this.plateNum = plateNum; }
    public void setType(String type) { this.type = type; }

    public void addFine(Fine fine) { fines.add(fine); }

}
