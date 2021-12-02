package database;

import models.OwnerSurveyModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OwnerSurveyDAO {

    DatabaseConnection databaseConnection = DatabaseConnection.getDatabaseConnectionObject();
    static final Logger logger = LogManager.getLogger(OwnerSurveyDAO.class);
    Connection connection;
    Statement statement;

    public void insertOwnerSurveyDetails(OwnerSurveyModel ownerSurveyModel) {
        String query;
        String getIdQuery;
        String ownerID;
        String address;
        int numberOfBedrooms;
        boolean isUtilitiesProvided;
        int numberOfVacancies;
        int dalDistance;
        int groceryStoreDistance;
        int theaterDistance;
        int downtownDistance;
        ResultSet resultSet;

        ownerID = ownerSurveyModel.getOwnerID();
        logger.info("ownerID: " + ownerID);
        address = ownerSurveyModel.getAddress();
        logger.info("address: " + address);
        numberOfBedrooms = ownerSurveyModel.getNumberOfBedrooms();
        logger.info("numberOfBedrooms: " + numberOfBedrooms);
        isUtilitiesProvided = ownerSurveyModel.isUtilitiesProvided();
        logger.info("isUtilitiesProvided: " + isUtilitiesProvided);
        numberOfVacancies = ownerSurveyModel.getNumberOfVacancies();
        logger.info("numberOfVacancies: " + numberOfVacancies);
        dalDistance = ownerSurveyModel.getDalhousieDistance();
        logger.info("dalDistance: " + dalDistance);
        groceryStoreDistance = ownerSurveyModel.getGroceryStoreDistance();
        logger.info("groceryStoreDistance: " + groceryStoreDistance);
        theaterDistance = ownerSurveyModel.getTheaterDistance();
        logger.info("theaterDistance: " + theaterDistance);
        downtownDistance = ownerSurveyModel.getDowntownDistance();
        logger.info("downtownDistance: " + downtownDistance);
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
                    .replace("propertyStatus", DatabaseQueryProperties.getDatabaseQueryPropertyValue("owner.survey.property.status"));

            logger.info("query: " + query);
            statement.executeUpdate(query);
            logger.info("query executed");
            getIdQuery = DatabaseQueryProperties.getDatabaseQueryPropertyValue("owner.survey.get.last.insert.id.query");
            resultSet = statement.executeQuery(getIdQuery);
            while (resultSet.next()) {
                ownerSurveyModel.setPropertyID(resultSet.getInt(Integer.parseInt(DatabaseQueryProperties.getDatabaseQueryPropertyValue("owner.survey.get.last.insert.id.column.index"))));
            }
            logger.info("Property Id set");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
