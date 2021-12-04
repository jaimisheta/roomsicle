package models;

public class SystemGeneratedPropertiesModel {

    private String ownerEmailId;
    private String firstName;
    private String lastName;
    private String address;
    private long contactNumber;
    private int rent;
    private int dalhousieDistance;

    public String getOwnerEmailId() {
        return ownerEmailId;
    }

    public void setOwnerEmailId(String ownerEmailId) {
        this.ownerEmailId = ownerEmailId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public int getDalhousieDistance() {
        return dalhousieDistance;
    }

    public void setDalhousieDistance(int dalhousieDistance) {
        this.dalhousieDistance = dalhousieDistance;
    }
}
