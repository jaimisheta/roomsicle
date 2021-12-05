package controllertest;

import controller.ControllerProperties;
import controller.getloggedinuser.GetLoggedInUserController;
import controller.getloggedinuser.IGetLoggedInUserController;
import database.ConfigProperties;
import database.DatabaseQueryProperties;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GetLoggedInUserControllerTest {

	@BeforeClass
	public static void init() {
		ControllerProperties.loadControllerPropertiesFile();
		DatabaseQueryProperties.loadDatabaseQueryPropertiesFile();
		ConfigProperties.loadConfigPropertiesFile();
	}

	@Test
	public void testGetLoggedInUser() {	
		IGetLoggedInUserController loggedInUser = new GetLoggedInUserController();
		assertEquals(loggedInUser.getLoggedInUser().getUserId(),"rikin@gmail.com");     
	}

}
