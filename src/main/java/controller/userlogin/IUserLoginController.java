package controller.userlogin;

import Exception.EmailException;
import Exception.PasswordNotMatchException;


public interface IUserLoginController {
    void UserLoginController() throws  EmailException, PasswordNotMatchException;
    void Login() throws PasswordNotMatchException;
    String CheckCreds();

    void giveCreds() throws  EmailException, PasswordNotMatchException;
}
