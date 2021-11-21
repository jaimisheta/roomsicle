package models;

public class OwnerSurveyModel {
    private String ownerID;
    private String address;
    private int numberOfBedrooms;
    private boolean isUtilitiesProvided;
    private int numberOfVacancies;
    private int dalDistanceMin;
    private int dalDistanceMax;
    private int groceryStoreDistanceMin;
    private int groceryStoreDistanceMax;
    private int theaterDistanceMin;
    private int theaterDistanceMax;
    private int downtownDistanceMin;
    private int downtownDistanceMax;
    private int propertyPrice;
    private boolean propertyStatus;

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

    public int getDalDistanceMin() {
        return dalDistanceMin;
    }

    public void setDalDistanceMin(int dalDistanceMin) {
        this.dalDistanceMin = dalDistanceMin;
    }

    public int getDalDistanceMax() {
        return dalDistanceMax;
    }

    public void setDalDistanceMax(int dalDistanceMax) {
        this.dalDistanceMax = dalDistanceMax;
    }

    public int getGroceryStoreDistanceMin() {
        return groceryStoreDistanceMin;
    }

    public void setGroceryStoreDistanceMin(int groceryStoreDistanceMin) {
        this.groceryStoreDistanceMin = groceryStoreDistanceMin;
    }

    public int getGroceryStoreDistanceMax() {
        return groceryStoreDistanceMax;
    }

    public void setGroceryStoreDistanceMax(int groceryStoreDistanceMax) {
        this.groceryStoreDistanceMax = groceryStoreDistanceMax;
    }

    public int getTheaterDistanceMin() {
        return theaterDistanceMin;
    }

    public void setTheaterDistanceMin(int theaterDistanceMin) {
        this.theaterDistanceMin = theaterDistanceMin;
    }

    public int getTheaterDistanceMax() {
        return theaterDistanceMax;
    }

    public void setTheaterDistanceMax(int theaterDistanceMax) {
        this.theaterDistanceMax = theaterDistanceMax;
    }

    public int getDowntownDistanceMin() {
        return downtownDistanceMin;
    }

    public void setDowntownDistanceMin(int downtownDistanceMin) {
        this.downtownDistanceMin = downtownDistanceMin;
    }

    public int getDowntownDistanceMax() {
        return downtownDistanceMax;
    }

    public void setDowntownDistanceMax(int downtownDistanceMax) {
        this.downtownDistanceMax = downtownDistanceMax;
    }

    public int getPropertyPrice() {
        return propertyPrice;
    }

    public void setPropertyPrice(int propertyPrice) {
        this.propertyPrice = propertyPrice;
    }

    public boolean isPropertyStatus() {
        return propertyStatus;
    }

    public void setPropertyStatus(boolean propertyStatus) {
        this.propertyStatus = propertyStatus;
    }
}
