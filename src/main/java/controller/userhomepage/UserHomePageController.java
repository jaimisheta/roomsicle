package controller.userhomepage;

import commandline.IRoomsicleCLI;
import controller.clicommentlist.IMakeCLICommentListController;
import controller.ClassInitializer;
import controller.clicommentlist.MakeCLICommentListController;
import controller.userlogin.IUserLoginController;
import controller.userprofile.IUserProfile;
import controller.userprofile.UserProfile;

import static controller.filterroommates.FilterRoommatesInputConstants.ONE;
import static controller.filterroommates.FilterRoommatesInputConstants.TWO;

public class UserHomePageController implements IUserHomePageController {
    public void showUserHomePageController() {
        int userInput;
        IUserLoginController iUserLoginController=ClassInitializer.initializer().getUserLoginController();
        IMakeCLICommentListController iMakeCLICommentListController= ClassInitializer.initializer().getIMakeCLICommentListController();
        IRoomsicleCLI iRoomsicleCLI=ClassInitializer.initializer().getIroomsicleCLI();
        IWelcomePageController iWelcomePageController= ClassInitializer.initializer().getIWelcomePageController();
        IUserProfile iUserProfile=ClassInitializer.initializer().getiUserProfile();
        if(iUserLoginController.getUserID()==ONE) {
            iMakeCLICommentListController.MakeCLICommentListController("welcomepage.add.message"
                    , "user.home.page.main.message", "welcomepage.add.message"
                    , "user.home.page.option.message", "user.home.page.my.profile.option.message",
                    "user.home.page.my.best.git.option.message", "user.home.page.filter.roommate.option.message",
                    "user.home.page.system.suggested.properties.option.message", "user.home.page.system.checkout.properties.option.message",
                    "user.home.page.expense.management.option.message", "user.home.page.logout.option.message"
            );
        }
        if(iUserLoginController.getUserID()==TWO) {
            iMakeCLICommentListController.MakeCLICommentListController("welcomepage.add.message"
                    , "user.home.page.main.message", "welcomepage.add.message"
                    , "user.home.page.option.message", "user.home.page.my.profile.option.message",
                    "user.home.page.logout.option.message"
            );
        }
        userInput=iRoomsicleCLI.getNumberResponse();
        switch (userInput) {
            case 1:
                iUserProfile.userProfile();
                break;
            case 2:
                //Yet to integrate
            case 3:
                //Yet to integrate
            case 4:
                //Yet to integrate
            case 5:
                //Yet to integrate
            case 6:
                //Yet to integrate
            case 7:
                iMakeCLICommentListController.MakeCLICommentListController("logged.out.successfully.message");
                iWelcomePageController.showWelcomePage();
        }
  }
}

