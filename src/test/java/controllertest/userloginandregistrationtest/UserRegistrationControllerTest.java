package controllertest.userloginandregistrationtest;

import junit.framework.TestCase;
import models.UsersModel;
import org.junit.Assert;
import org.junit.Test;

public class UserRegistrationControllerTest extends TestCase {
    UsersModel usersModel=new UsersModel();

    @Test
    public void testSetFirstName() {
        usersModel.setFirstName("hardik");
        Assert.assertSame("hardik",usersModel.getFirstName());
    }

    @Test
    public void testSetLastName() {
        usersModel.setLastName("mesvania");
        Assert.assertSame("mesvania",usersModel.getLastName());
    }

    @Test
    public void testSetContact() {
        usersModel.setContactNumber(1234567890);
        Assert.assertEquals(1234567890,usersModel.getContactNumber());
    }

    @Test
    public void testSetEmail() {
        usersModel.setEmailId("hardik123@gmail.com");
        Assert.assertSame("hardik123@gmail.com",usersModel.getEmailId());
    }

    @Test
    public void testSetPassword() {
        usersModel.setPassword("hardik");
        Assert.assertSame("hardik",usersModel.getPassword());
    }
}