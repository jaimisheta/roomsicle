package database;

import models.UserSurveyModel;

public interface IUserSurveyDAO {

    void insertUserPersonalDetails(UserSurveyModel userSurveyModel);

    void insertRoommatePreferenceDetails(UserSurveyModel userSurveyModel);

    void updateSurveyTakenStatus(UserSurveyModel userSurveyModel);

}
