package controller.userhomepage;

import controller.clicommentlist.IMakeCLICommentListController;
import controller.ClassInitializer;

public class UserHomePageController implements IUserHomePageController {
    public void showUserHomePageController() {
        IMakeCLICommentListController iMakeCLICommentListController= ClassInitializer.initializer().getIMakeCLICommentListController();
        iMakeCLICommentListController.MakeCLICommentListController("welcomepage.add.message"
                , "user.home.page.main.message", "welcomepage.add.message"
                ,"user.home.page.option.message","user.home.page.my.profile.option.message",
                "user.home.page.my.best.git.option.message","user.home.page.filter.roommate.option.message",
                "user.home.page.system.suggested.properties.option.message","user.home.page.system.checkout.properties.option.message",
                "user.home.page.expense.management.option.message","user.home.page.logout.option.message"
        );
  }
}

