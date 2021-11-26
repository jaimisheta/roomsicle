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
        int dalDistanceMin;
        int dalDistanceMax;
        int groceryStoreDistanceMin;
        int groceryStoreDistanceMax;
        int theaterDistanceMin;
        int theaterDistanceMax;
        int downtownDistanceMin;
        int downtownDistanceMax;

        ownerID = ownerSurveyModel.getOwnerID();
        address = ownerSurveyModel.getAddress();
        numberOfBedrooms = ownerSurveyModel.getNumberOfBedrooms();
        isUtilitiesProvided = ownerSurveyModel.isUtilitiesProvided();
        numberOfVacancies = ownerSurveyModel.getNumberOfVacancies();
        dalDistanceMin = ownerSurveyModel.getDalDistanceMin();
        dalDistanceMax = ownerSurveyModel.getDalDistanceMax();
        groceryStoreDistanceMin = ownerSurveyModel.getGroceryStoreDistanceMin();
        groceryStoreDistanceMax = ownerSurveyModel.getGroceryStoreDistanceMax();
        theaterDistanceMin = ownerSurveyModel.getTheaterDistanceMin();
        theaterDistanceMax = ownerSurveyModel.getTheaterDistanceMax();
        downtownDistanceMin = ownerSurveyModel.getDowntownDistanceMin();
        downtownDistanceMax = ownerSurveyModel.getDowntownDistanceMax();
        try {
            connection = databaseConnection.getConnectionObject();
            statement = connection.createStatement();

            query = DatabaseQueryProperties.getDatabaseQueryPropertyValue("owner.survey.insert.survey.details.query")
                    .replace("propertyDetailsTableName", DatabaseQueryProperties.getDatabaseQueryPropertyValue("owner.survey.property.details.table.name"))
                    .replace("ownerID", ownerID).replace("propertyAddress", address)
                    .replace("numberOfBedrooms", String.valueOf(numberOfBedrooms))
                    .replace("isUtilitiesProvided", String.valueOf(isUtilitiesProvided))
                    .replace("numberOfVacancies", String.valueOf(numberOfVacancies))
                    .replace("dalDistanceMin", String.valueOf(dalDistanceMin))
                    .replace("dalDistanceMax", String.valueOf(dalDistanceMax))
                    .replace("groceryStoreDistanceMin", String.valueOf(groceryStoreDistanceMin))
                    .replace("groceryStoreDistanceMax", String.valueOf(groceryStoreDistanceMax))
                    .replace("theaterDistanceMin", String.valueOf(theaterDistanceMin))
                    .replace("theaterDistanceMax", String.valueOf(theaterDistanceMax))
                    .replace("downtownDistanceMin", String.valueOf(downtownDistanceMin))
                    .replace("downtownDistanceMax", String.valueOf(downtownDistanceMax))
                    .replace("propertyPrice", DatabaseQueryProperties.getDatabaseQueryPropertyValue("owner.survey.property.price"))
                    .replace("propertyStatus", DatabaseQueryProperties.getDatabaseQueryPropertyValue("owner.survey.property.status"));

            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
