package models;

public class OwnerSurveyModel {
    private int propertyID;
    private String ownerID;
    private String address;
    private int numberOfBedrooms;
    private boolean isUtilitiesProvided;
    private int numberOfVacancies;
    private int dalhousieDistance;
    private int groceryStoreDistance;
    private int downtownDistance;
    private int theaterDistance;

    public OwnerSurveyModel() {
    }

    public OwnerSurveyModel(int numberOfBedrooms) {
        this.numberOfBedrooms = numberOfBedrooms;
    }

    public OwnerSurveyModel(boolean isUtilitiesProvided) {
        this.isUtilitiesProvided = isUtilitiesProvided;
    }

    public OwnerSurveyModel(int dalhousieDistance, int groceryStoreDistance, int downtownDistance, int theaterDistance) {
        this.dalhousieDistance = dalhousieDistance;
        this.groceryStoreDistance = groceryStoreDistance;
        this.downtownDistance = downtownDistance;
        this.theaterDistance = theaterDistance;
    }

    public String getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    public void setNumberOfBedrooms(int numberOfBedrooms) {
        this.numberOfBedrooms = numberOfBedrooms;
    }

    public boolean isUtilitiesProvided() {
        return isUtilitiesProvided;
    }

    public void setUtilitiesProvided(boolean utilitiesProvided) {
        isUtilitiesProvided = utilitiesProvided;
    }

    public int getNumberOfVacancies() {
        return numberOfVacancies;
    }

    public void setNumberOfVacancies(int numberOfVacancies) {
        this.numberOfVacancies = numberOfVacancies;
    }

    public int getDalhousieDistance() {
        return dalhousieDistance;
    }

    public void setDalhousieDistance(int dalhousieDistance) {
        this.dalhousieDistance = dalhousieDistance;
    }

    public int getGroceryStoreDistance() {
        return groceryStoreDistance;
    }

    public void setGroceryStoreDistance(int groceryStoreDistance) {
        this.groceryStoreDistance = groceryStoreDistance;
    }

    public int getDowntownDistance() {
        return downtownDistance;
    }

    public void setDowntownDistance(int downtownDistance) {
        this.downtownDistance = downtownDistance;
    }

    public int getTheaterDistance() {
        return theaterDistance;
    }

    public void setTheaterDistance(int theaterDistance) {
        this.theaterDistance = theaterDistance;
    }

    public int getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(int propertyID) {
        this.propertyID = propertyID;
    }
}