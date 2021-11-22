package database;

import models.UserSurveyModel;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UserSurveyDAO {
    DatabaseConnection databaseConnection = new DatabaseConnection();
    Connection connection = databaseConnection.getConnectionObject();
    Statement statement;

    public void insertUserPersonalDetails(UserSurveyModel userSurveyModel) {
        String query;
        String userPersonalDetailsTableName = "user_personal_details";
        String userId;
        String userGender;
        String userFoodHabits;
        int userSmokingHabits;
        int userAlcoholHabits;
        int userBudget;
        int userDalDistance;

        userId = userSurveyModel.getUserId();
        userGender = userSurveyModel.getUserGender();
        userFoodHabits = userSurveyModel.getUserFoodHabits();
        userSmokingHabits = userSurveyModel.getUserSmokingHabits();
        userAlcoholHabits = userSurveyModel.getUserAlcoholHabits();
        userBudget = userSurveyModel.getUserBudget();
        userDalDistance = userSurveyModel.getUserDalDistance();
        try {
            statement = connection.createStatement();

            query = "insert into " + userPersonalDetailsTableName + " (email_id, gender, food_habits, smoke, alcohol, budget, dal_distance)" +
                    "values ('" + userId + "','" + userGender + "','" + userFoodHabits + "'," +
                    "'" + userSmokingHabits + "','" + userAlcoholHabits + "','" + userBudget + "','" + userDalDistance + "')";

            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertRoommatePreferenceDetails(UserSurveyModel userSurveyModel) {
        String query;
        String roommatePreferenceDetailsTableName = "user_preferences";
        String userId;
        String roommateGender;
        String roommateFoodHabits;
        String roommateSmokingHabits;
        String roommateAlcoholHabits;

        userId = userSurveyModel.getUserId();
        roommateGender = userSurveyModel.getRoommateGender();
        roommateFoodHabits = userSurveyModel.getRoommateFoodHabits();
        roommateSmokingHabits = userSurveyModel.getRoommateSmokingHabits();
        roommateAlcoholHabits = userSurveyModel.getRoommateAlcoholHabits();
        try {
            statement = connection.createStatement();

            query = "insert into " + roommatePreferenceDetailsTableName + " (user_id, roommate_gender, roommate_food_habits, roommate_smoke, roommate_alcohol)" +
                    "values ('" + userId + "','" + roommateGender + "','" + roommateFoodHabits + "'," +
                    "'" + roommateSmokingHabits + "','" + roommateAlcoholHabits + "')";

            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
