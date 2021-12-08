package controller.usersurvey;

import models.UserSurveyModel;

public interface IUserSurvey {

    void getValue(UserSurveyModel userSurveyModel);

    boolean validateValue(UserSurveyModel userSurveyModel);

    void setValue(UserSurveyModel userSurveyModel);
}
