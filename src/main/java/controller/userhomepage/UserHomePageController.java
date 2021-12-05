package controller.userhomepage;

import commandline.IRoomsicleCLI;
import controller.clicommentlist.IMakeCLICommentListController;
import controller.ClassInitializer;
import controller.userprofile.IUserProfile;
import controller.userprofile.UserProfile;

public class UserHomePageController implements IUserHomePageController {
    public void showUserHomePageController() {
        int userInput;
        IMakeCLICommentListController iMakeCLICommentListController= ClassInitializer.initializer().getIMakeCLICommentListController();
        IRoomsicleCLI iRoomsicleCLI=ClassInitializer.initializer().getIroomsicleCLI();
        IWelcomePageController iWelcomePageController= ClassInitializer.initializer().getIWelcomePageController();
        IUserProfile iUserProfile=ClassInitializer.initializer().getiUserProfile();
        iMakeCLICommentListController.MakeCLICommentListController("welcomepage.add.message"
                , "user.home.page.main.message", "welcomepage.add.message"
                ,"user.home.page.option.message","user.home.page.my.profile.option.message",
                "user.home.page.my.best.git.option.message","user.home.page.filter.roommate.option.message",
                "user.home.page.system.suggested.properties.option.message","user.home.page.system.checkout.properties.option.message",
                "user.home.page.expense.management.option.message","user.home.page.logout.option.message"
        );
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

