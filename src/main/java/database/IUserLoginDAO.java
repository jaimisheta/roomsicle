package database;

import java.util.Map;

public interface IUserLoginDAO {
     Map<String, String> getUserLoginAndPassword(String query);
     Map<String, String> getSurveyTaken(String query);
}
