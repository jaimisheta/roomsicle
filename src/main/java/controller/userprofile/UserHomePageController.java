package controller.userprofile;

import commandline.IRoomsicleCLI;
import controller.clicommentlist.IMakeCLICommentListController;
import controller.ClassInitializer;
import controller.ownerprofile.IOwnerProfile;
import controller.welcomepage.IWelcomePageController;
import controller.userlogin.IUserLoginController;

import static controller.filterroommates.FilterRoommatesInputConstants.ONE;
import static controller.filterroommates.FilterRoommatesInputConstants.TWO;
import static controller.welcomepage.WelcomePageController.userId;

public class UserHomePageController implements IUserHomePageController {
    public void showUserHomePageController() {
        int userInput;
        IUserLoginController userLoginController=ClassInitializer.initializer().getUserLoginController();
        IMakeCLICommentListController makeCLICommentListController= ClassInitializer.initializer().getIMakeCLICommentListController();
        IRoomsicleCLI roomsicleCLI=ClassInitializer.initializer().getRoomsicleCLI();
        IWelcomePageController welcomePageController= ClassInitializer.initializer().getIWelcomePageController();
        IUserProfile userProfile=ClassInitializer.initializer().getUserProfile();
        IOwnerProfile ownerProfile=ClassInitializer.initializer().getOwnerProfile();

        if(userId==ONE) {
            makeCLICommentListController.makeCLICommentListController("welcomepage.add.message"
                    , "user.home.page.main.message", "welcomepage.add.message"
                    , "user.home.page.option.message", "user.home.page.my.profile.option.message",
                    "user.home.page.my.best.git.option.message", "user.home.page.filter.roommate.option.message",
                    "user.home.page.system.suggested.properties.option.message", "user.home.page.system.checkout.properties.option.message",
                    "user.home.page.expense.management.option.message", "user.home.page.logout.option.message"
            );

        }

        else if(userId==TWO) {
            makeCLICommentListController.makeCLICommentListController("welcomepage.add.message"
                    , "user.home.page.main.message", "welcomepage.add.message"
                    , "user.home.page.option.message", "user.home.page.my.profile.option.message",
                    "user.home.page.logout.option.message"
            );

        }

        userInput=roomsicleCLI.getNumberResponse();

        switch (userInput) {
            case 1:
                if(userId==ONE) {
                    userProfile.userProfile();
                }
                else if(userId==TWO) {
                    ownerProfile.ownerProfile();
                }
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
                makeCLICommentListController.makeCLICommentListController("logged.out.successfully.message");
                welcomePageController.showWelcomePage();
        }
  }
}

