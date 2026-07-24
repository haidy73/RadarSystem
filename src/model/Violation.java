package model;

public class Violation {
    private String type;
    private String description;
    private Integer fineAmount;
    
    public Violation() {}

    public String getType() { return type; }
    public String getDescription() { return description; }
    public Integer getFineAmount() { return fineAmount; }   
    
    public void setType(String type) { this.type = type; }          
    public void setDescription(String description) { this.description = description; }
    public void setFineAmount(Integer fineAmount) { this.fineAmount = fineAmount; }
}
