package PaqGroupINameAgustin;

public class Container {
    private boolean isFree;
    private String idNumber;
    private String weight;
    private String countryOfOrigin;
    private boolean hasBeenInspected;
    private int priorityLevel;
    private String contentDescription;
    private String companyThatSendsTheContainer;
    private String companyThatReceivesTheContainer;
    private Container(boolean isFree) {
        this.isFree=isFree;
    }
    public Container(boolean isFree,
                 String idNumber,
                 String weight,
                 String countryOfOrigin,
                 boolean hasBeenInspected,
                 int priorityLevel,
                 String contentDescription,
                 String companyThatSendsTheContainer,
                 String companyThatReceivesTheContainer){
        this.isFree=isFree;
        this.idNumber=idNumber;
        this.weight=weight;
        this.countryOfOrigin=countryOfOrigin;
        this.hasBeenInspected=hasBeenInspected;
        this.priorityLevel=priorityLevel;
        this.contentDescription=contentDescription;
        this.companyThatSendsTheContainer=companyThatSendsTheContainer;
        this.companyThatReceivesTheContainer=companyThatReceivesTheContainer;
    }
    @Override
    public String toString() {
        return "Container ID: " + idNumber + " | Weight: " + weight + " | Country of Origin: "
                + countryOfOrigin + " | Inspected: " + hasBeenInspected + " | Priority: "
                + priorityLevel + " | Content Description: " + contentDescription
                + " | Sending Company: " + companyThatSendsTheContainer + " | Receiving Company: "
                + companyThatReceivesTheContainer;
    }
    //GETTERS
    public String getCountryOfOrigin() {
        return this.countryOfOrigin;
    }
    public String getIdNumber() {
        return this.idNumber;
    }
    public String getWeight() {
        return this.weight;
    }
    public boolean getHasBeenInspected() {
        return this.hasBeenInspected;
    }
    public int getPriorityLevel() {
        return this.priorityLevel;
    }
    public String getContentDescription() {
        return this.contentDescription;
    }
    public  String getCompanyThatSendsTheContainer() {
        return this.companyThatSendsTheContainer;
    }
    public String getCompanyThatReceivesTheContainer() {
        return this.companyThatReceivesTheContainer;
    }
    //SETTERS
    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin=countryOfOrigin;
    }
    public  void setIdNumber(String idNumber) {
        this.idNumber=idNumber;
    }
    public  void setWeight(String weight) {
        this.weight=weight;
    }
    public  void setHasBeenInspected(boolean hasBeenInspected) {
        this.hasBeenInspected=hasBeenInspected;
    }
    public  void setPriorityLevel(int priorityLevel) {
        this.priorityLevel=priorityLevel;
    }
    public  void setContentDescription(String contentDescription) {
        this.contentDescription=contentDescription;
    }
    public void setCompanyThatSendsTheContainer(String companyThatSendsTheContainer) {
        this.companyThatSendsTheContainer=companyThatSendsTheContainer;
    }
    public  void setCompanyThatReceivesTheContainer(String companyThatReceivesTheContainer) {
        this.companyThatReceivesTheContainer=companyThatReceivesTheContainer;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public boolean isHasBeenInspected() {
        return hasBeenInspected;
    }

    public boolean equals(Container obj) {
        return this.isFree== obj.isFree&&
                this.hasBeenInspected== obj.hasBeenInspected&&
                this.priorityLevel==obj.priorityLevel&&
                this.contentDescription.equals(obj.contentDescription)&&
                this.companyThatReceivesTheContainer.equals(obj.companyThatReceivesTheContainer)&&
                this.companyThatSendsTheContainer.equals(obj.companyThatSendsTheContainer)&&
                this.countryOfOrigin.equals(obj.countryOfOrigin)&&
                this.weight.equals(obj.weight)&&
                this.idNumber.equals(obj.idNumber);
    }
}
