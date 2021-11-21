package database;

import models.OwnerSurveyModel;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class OwnerSurveyDAO {
    DatabaseConnection databaseConnection = new DatabaseConnection();
    Connection connection;
    Statement statement;

    public void insertOwnerSurveyDetails(OwnerSurveyModel ownerSurveyModel) {
        String query;
        String propertyDetailsTableName = "property_details";
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
        boolean propertyStatus = true;

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

            query = "insert into " + propertyDetailsTableName + " (owner_id,address,number_of_bedroom,utilities," +
                    "number_of_vacancies,dal_distance_min,dal_distance_max,grocery_distance_min," +
                    "grocery_distance_max,theater_distance_min,theater_distance_max," +
                    "downtown_distance_min,downtown_distance_max,price,property_status)" +
                    "values ('" + ownerID + "','" + address + "'," + numberOfBedrooms + "," +
                    "" + isUtilitiesProvided + "," + numberOfVacancies + "," + dalDistanceMin + "," + dalDistanceMax + "," +
                    "" + groceryStoreDistanceMin + "," + groceryStoreDistanceMax + "," + theaterDistanceMin + "," +
                    "" + theaterDistanceMax + "," + downtownDistanceMin + "," + downtownDistanceMax + ",'2000'," + propertyStatus + ")";

            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
