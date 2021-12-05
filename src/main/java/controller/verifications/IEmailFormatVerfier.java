package controller.verifications;
import Exception.EmailException;

public interface IEmailFormatVerfier{
        void EmailFormatVerifier(String email) throws EmailException;
        boolean ValidEmailFormatVerifier(String email) ;
    }


