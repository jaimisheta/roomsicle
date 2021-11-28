package database;

import models.OwnerSurveyModel;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class OwnerSurveyDAO {

    DatabaseConnection databaseConnection = DatabaseConnection.getDatabaseConnectionObject();
    Connection connection;
    Statement statement;

    public void insertOwnerSurveyDetails(OwnerSurveyModel ownerSurveyModel) {
        String query;
        String ownerID;
        String address;
        int numberOfBedrooms;
        boolean isUtilitiesProvided;
        int numberOfVacancies;
        int dalDistance;
        int groceryStoreDistance;
        int theaterDistance;
        int downtownDistance;

        ownerID = ownerSurveyModel.getOwnerID();
        address = ownerSurveyModel.getAddress();
        numberOfBedrooms = ownerSurveyModel.getNumberOfBedrooms();
        isUtilitiesProvided = ownerSurveyModel.isUtilitiesProvided();
        numberOfVacancies = ownerSurveyModel.getNumberOfVacancies();
        dalDistance = ownerSurveyModel.getDalhousieDistance();
        groceryStoreDistance = ownerSurveyModel.getGroceryStoreDistance();
        theaterDistance = ownerSurveyModel.getTheaterDistance();
        downtownDistance = ownerSurveyModel.getDowntownDistance();
        try {
            connection = databaseConnection.getConnectionObject();
            statement = connection.createStatement();

            query = DatabaseQueryProperties.getDatabaseQueryPropertyValue("owner.survey.insert.survey.details.query")
                    .replace("propertyDetailsTableName", DatabaseQueryProperties.getDatabaseQueryPropertyValue("owner.survey.property.details.table.name"))
                    .replace("ownerID", ownerID).replace("propertyAddress", address)
                    .replace("numberOfBedrooms", String.valueOf(numberOfBedrooms))
                    .replace("isUtilitiesProvided", String.valueOf(isUtilitiesProvided))
                    .replace("numberOfVacancies", String.valueOf(numberOfVacancies))
                    .replace("dalDistance", String.valueOf(dalDistance))
                    .replace("groceryStoreDistance", String.valueOf(groceryStoreDistance))
                    .replace("downtownDistance", String.valueOf(downtownDistance))
                    .replace("theaterDistance", String.valueOf(theaterDistance))
                    .replace("propertyPrice", DatabaseQueryProperties.getDatabaseQueryPropertyValue("owner.survey.property.price"))
                    .replace("propertyStatus", DatabaseQueryProperties.getDatabaseQueryPropertyValue("owner.survey.property.status"));

            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
