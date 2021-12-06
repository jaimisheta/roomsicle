package controller.userlogin;

import controller.ClassInitializer;
import controller.userhomepage.IUserHomePageController;
import database.IUserLoginDAO;

import static controller.userregistration.UserRegistrationConstants.ONESTRING;
import static controller.userregistration.UserRegistrationConstants.ZEROSTRING;

public class CheckSurveyTaken implements ICheckSurveyTaken {

    public void CheckSurveyTaken(String email){
        String getUserData;
        String survey;
        IUserHomePageController iUserHomePageController=ClassInitializer.initializer().getIUserHomePageController();
        IUserLoginController iUserLoginController=ClassInitializer.initializer().getUserLoginController();
        IUserLoginDAO iUserLoginDAO= ClassInitializer.initializer().getIUserLoginDAO();
        getUserData=iUserLoginController.CheckCreds();
        survey=iUserLoginDAO.getSurveyTaken(getUserData).get(email);
        if (survey.equals(ONESTRING)){
            iUserHomePageController.showUserHomePageController();
        }
        else if (survey.equals(ZEROSTRING)){
            //Yet to initialize;
        }
    }
}
