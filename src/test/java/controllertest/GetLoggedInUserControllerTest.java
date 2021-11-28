package controllertest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import controller.BestFitRoommateController;
import controller.GetLoggedInUserController;
import controller.IGetLoggedInUserController;

public class GetLoggedInUserControllerTest {

	@Test
	public void testGetLoggedInUser() {	
		IGetLoggedInUserController loggedInUser = new GetLoggedInUserController();
		assertEquals(loggedInUser.getLoggedInUser().getUserId(),"rikin@gmail.com");     
	}

}
