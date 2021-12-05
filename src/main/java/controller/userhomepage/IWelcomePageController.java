package controller.userhomepage;

import Exception.EmailException;
import Exception.InvalidInputException;
import Exception.PasswordNotMatchException;

public interface IWelcomePageController {
     void  showWelcomePage();
     void UserSelection() throws InvalidInputException, EmailException, PasswordNotMatchException;
}
