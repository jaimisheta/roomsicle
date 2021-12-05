package database;

import models.PropertyDetailsModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PropertyDetailsDAO {

    DatabaseConnection databaseConnection = DatabaseConnection.getDatabaseConnectionObject();
    Connection connection;
    Statement statement;

    public ArrayList<PropertyDetailsModel> getPropertyDetails() {

        ArrayList<PropertyDetailsModel> listOfAllPropertyDetails = new ArrayList<PropertyDetailsModel>();
        String query = DatabaseQueryProperties.getDatabaseQueryPropertyValue("property.details.query");

        try(Connection conn = databaseConnection.getConnectionObject();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
        ) {
            while(rs.next()){
                PropertyDetailsModel propertyDetails = new PropertyDetailsModel();
                propertyDetails.setPropertyId(rs.getString(1));
                propertyDetails.setOwnerId(rs.getString(2));
                propertyDetails.setPropertyPrice(rs.getInt(11));
                listOfAllPropertyDetails.add(propertyDetails);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return listOfAllPropertyDetails;
    }

}