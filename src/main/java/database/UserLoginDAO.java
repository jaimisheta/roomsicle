package database;

import models.UsersModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserLoginDAO {
    DatabaseConnection databaseConnection = DatabaseConnection.getDatabaseConnectionObject();
    Connection connection = databaseConnection.getConnectionObject();
    Statement statement;
    ResultSet getCredentials;

    public Map<String, String> getUserLoginAndPassword() throws SQLException {
        HashMap<String, String> getCredential = new HashMap<String, String>();
        String query;
        try{
             statement = connection.createStatement();
             query=DatabaseQueryProperties.getDatabaseQueryPropertyValue("user.login.email.password.query");
             getCredentials=statement.executeQuery(query);
            while(getCredentials.next())
            {
                getCredential.put(getCredentials.getString(1),getCredentials.getString(2));
            }

    }catch (Exception e){
            e.printStackTrace();
        }

        return getCredential;
    }
}
