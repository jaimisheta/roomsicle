package controller.verifications;

import Exception.PasswordNotMatchException;
import commandline.CommandLineInputProperties;
import controller.clicommentlist.IMakeCLICommentListController;
import controller.ClassInitializer;

public class PasswordVerifierController implements IPasswordVerifierController {
     public void PasswordVerifierController( String password,String confirmPassword) throws PasswordNotMatchException {
      IMakeCLICommentListController iMakeCLICommentListController= ClassInitializer.initializer().getIMakeCLICommentListController();
       if (password.equals(confirmPassword)){
           iMakeCLICommentListController.MakeCLICommentListController("registration.password.match.message");
       }else {
           throw new PasswordNotMatchException(CommandLineInputProperties.getCommandLineInputPropertyValue("registration.password.do.not.match.message"));
       }
    }

    public String PasswordVerifierValidatorController(String password, String confirmPassword) {
        String message;
        IMakeCLICommentListController iMakeCLICommentListController= ClassInitializer.initializer().getIMakeCLICommentListController();
        if (password.equals(confirmPassword)){
            message=iMakeCLICommentListController.MakeCLICommentListController("registration.password.match.message").toString();
        }else {
            message=iMakeCLICommentListController.MakeCLICommentListController("registration.password.do.not.match.message").toString();
        }
        return message;
    }
}
