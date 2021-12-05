package controller.verifications;
import Exception.EmailException;

public interface IEmailVerifierController {
    void UserEmailAlreadyRegistered(String emailId, String userData) throws EmailException;
    void EmailDoesnotExists(String emailId,String userData) throws EmailException;
}
