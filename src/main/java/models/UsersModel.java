package models;

public class UsersModel {
	private String emailId; //following camel casing structure
	private String firstName;
	private String lastName;
	private String contactNumber;
	private String password;
	private Integer surveyTaken;
	private String type;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getSurveyTaken() {
		return surveyTaken;
	}

	public void setSurveyTaken(Integer surveyTaken) {
		this.surveyTaken = surveyTaken;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}