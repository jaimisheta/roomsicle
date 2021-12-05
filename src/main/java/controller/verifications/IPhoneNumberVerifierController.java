package controller.verifications;

import Exception.PhoneNumberException;

public interface IPhoneNumberVerifierController {
    void PhoneNumberVerifierController(long contact) throws PhoneNumberException;
}
