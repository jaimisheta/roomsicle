package controller.verifications;

import Exception.PasswordNotMatchException;

public interface IPasswordVerifierController {
    void PasswordVerifierController( String password,String confirmPassword) throws PasswordNotMatchException;
}
