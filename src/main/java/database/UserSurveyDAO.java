package database;

import models.UserSurveyModel;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UserSurveyDAO {

	DatabaseConnection databaseConnection = DatabaseConnection.getDatabaseConnectionObject();
	Connection connection = databaseConnection.getConnectionObject();
	Statement statement;

	public void insertUserPersonalDetails(UserSurveyModel userSurveyModel) {
		String query;
		String userId;
		String userGender;
		String userFoodHabits;
		String userSmokingHabits;
		String userAlcoholHabits;
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

			query = DatabaseQueryProperties.getDatabaseQueryPropertyValue("user.survey.insert.user.personal.details.query")
					.replace("userPersonalDetailsTableName", DatabaseQueryProperties.getDatabaseQueryPropertyValue("user.survey.user.personal.details.table.name"))
					.replace("userId", userId).replace("userGender", userGender)
					.replace("userFoodHabits", userFoodHabits)
					.replace("userSmokingHabits", userSmokingHabits)
					.replace("userAlcoholHabits", userAlcoholHabits)
					.replace("userBudget", String.valueOf(userBudget))
					.replace("userDalDistance", String.valueOf(userDalDistance));

			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertRoommatePreferenceDetails(UserSurveyModel userSurveyModel) {
		String query;
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

			query = DatabaseQueryProperties.getDatabaseQueryPropertyValue("user.survey.insert.roommate.preference.details.query")
					.replace("roommatePreferenceDetailsTableName", DatabaseQueryProperties.getDatabaseQueryPropertyValue("user.survey.roommate.preference.details.table.name"))
					.replace("userId", userId).replace("roommateGender", roommateGender)
					.replace("roommateFoodHabits", roommateFoodHabits)
					.replace("roommateSmokingHabits", roommateSmokingHabits)
					.replace("roommateAlcoholHabits", roommateAlcoholHabits);

			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
