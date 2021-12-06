package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import static controller.filterroommates.FilterRoommatesInputConstants.ONE;
import static controller.ownersurvey.OwnerSurveyConstants.SIX;
import static controller.usersurvey.UserSurveyConstants.FIVE;

public class UserLoginDAO implements IUserLoginDAO{
    DatabaseConnection databaseConnection = DatabaseConnection.getDatabaseConnectionObject();
    Connection connection = databaseConnection.getConnectionObject();
    Statement statement;
    ResultSet getCredentials;

    public Map<String, String> getUserLoginAndPassword(String query){
        HashMap<String, String> getCredential = new HashMap<String, String>();
        try{
             statement = connection.createStatement();
             getCredentials=statement.executeQuery(query);
            while(getCredentials.next())
            {
                getCredential.put(getCredentials.getString(ONE),getCredentials.getString(FIVE));
            }
    }catch (Exception e){
            e.printStackTrace();
        }
        return getCredential;
    }

    public Map<String, String> getSurveyTaken(String query){
        HashMap<String, String> getCredential = new HashMap<String, String>();
        try{
            statement = connection.createStatement();
            getCredentials=statement.executeQuery(query);
            while(getCredentials.next())
            {
                getCredential.put(getCredentials.getString(ONE),getCredentials.getString(SIX));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return getCredential;
    }
}
