package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import database.DatabaseConnection;


public class UsersModel {
	private String emailId; //following camel casing structure 
    private String firstName;
    private String lastName;
    private int contactNumber;
    private String password;
    private int surveyTaken;
    private String type;

	public Map<String, String> getUserCreds() {
			HashMap<String, String> creds = new HashMap<String, String>();
			DatabaseConnection conn=new DatabaseConnection();
			
	        Connection connection = null;
	        Statement selectStmt = null;
	        try
	        {
	        	connection=conn.getConnectionObject();
	            selectStmt = connection.createStatement();
	            ResultSet rs = selectStmt.executeQuery("SELECT email_id,password FROM users");
	            while(rs.next())
	            {
	            	creds.put(rs.getString(1),rs.getString(2));    
	            }
	        } 
	        catch (Exception e) {
	            e.printStackTrace();
	        }finally {
	            try {
	                selectStmt.close();
	                connection.close();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
			return creds ;
		}

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
	public int getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(int contactNumber) {
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
	public void setSurveyTaken(int surveyTaken) {
		this.surveyTaken = surveyTaken;
	}

	public void setUserSelection(String userSelection) {
		
		this.type = type;
	}
	
public String getUserSelection(String userSelection) {
		
	   return  type;
	}

@Override
public String toString() {
	return "UsersModel [emailId=" + emailId + ", firstName=" + firstName + ", lastName=" + lastName + ", contactNumber="
			+ contactNumber + ", password=" + password + ", surveyTaken=" + surveyTaken + ", type=" + type + "]";
}


public void roomSeeker(int userSelectionInt) {
	Connection connection = null;
    Statement selectStmt = null;
    String users;
    DatabaseConnection conn=new DatabaseConnection();
    try
    {
    	connection=conn.getConnectionObject();
        selectStmt = connection.createStatement();
        if (userSelectionInt==1) {
        	 users="users";
        }else {
        	 users="owners";
        }
        String sql = "INSERT INTO " + users + "(first_name, email_id, contact_number, password) VALUES ('"+firstName+"','"+emailId +"'," +contactNumber+ ",'"+ password+"')";
        selectStmt.executeUpdate(sql);
    } 
    catch (Exception e) {
        e.printStackTrace();
    }finally {
        try {
        	selectStmt.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	}

//public void owner() {
//	Connection connection = null;
//    Statement selectStmt = null;
//    DatabaseConnection conn=new DatabaseConnection();
//    try
//    {
//    	connection=conn.getConnectionObject();
//    	selectStmt = conn.createStatement();
//    	String sql = "INSERT INTO owners (first_name, email_id, contact_number, password) VALUES ('"+firstName+"','"+emailId +"'," +contactNumber+ ",'"+ password+"')";
//        System.out.println(sql);
//    	selectStmt.executeUpdate(sql);
//    } 
//    catch (Exception e) {
//        e.printStackTrace();
//    }finally {
//        try {
//        	selectStmt.close();
//            connection.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//	}

	

	
	
	   
}
