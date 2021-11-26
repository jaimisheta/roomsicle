package database;

import models.UserSurveyModel;
import models.UsersModel;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UserRegistrationDAO {
    DatabaseConnection databaseConnection = DatabaseConnection.getDatabaseConnectionObject();
    Connection connection = databaseConnection.getConnectionObject();
    Statement statement;
    public void userRegistration(UsersModel usersModel){
        String query;
        String type;
        String emailId;
        String firstName;
        String lastName;
        String contactNumber;
        String password;
        Integer surveyTaken;

        type= usersModel.getType();
        emailId=usersModel.getEmailId();
        firstName=usersModel.getFirstName();
        lastName=usersModel.getLastName();
        contactNumber=usersModel.getContactNumber();
        password=usersModel.getPassword();
        surveyTaken=usersModel.getSurveyTaken();
        try {
            statement = connection.createStatement();

            query = DatabaseQueryProperties.getDatabaseQueryPropertyValue("user.registration.query")
                    .replace("users", type)
                    .replace("EmailId", emailId)
                    .replace("fName", firstName)
                    .replace("lName", lastName)
                    .replace("cno",  contactNumber)
                    .replace("password00", password)
                    .replace("suvtak", String.valueOf(surveyTaken));
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    }

