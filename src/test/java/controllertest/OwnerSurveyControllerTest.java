package controllertest;

import controller.OwnerSurveyController;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class OwnerSurveyControllerTest {

    OwnerSurveyController ownerSurveyController = Mockito.mock(OwnerSurveyController.class);

    @Test
    public void testGetPropertyAddressFromOwner() {
        String result;
        Mockito.when(ownerSurveyController.getPropertyAddressFromOwner()).thenReturn("address1");
        result = ownerSurveyController.getPropertyAddressFromOwner();
        Assert.assertEquals(result, "address1");
    }

    @Test
    public void testGetNumberOfBedroomsFromOwner() {
        int result;
        Mockito.when(ownerSurveyController.getNumberOfBedroomsFromOwner()).thenReturn(7);
        result = ownerSurveyController.getNumberOfBedroomsFromOwner();
        Assert.assertEquals(result, 7);
    }

    @Test
    public void testGetNumberOfVacanciesFromOwner() {
        int result;
        Mockito.when(ownerSurveyController.getNumberOfVacanciesFromOwner()).thenReturn(4);
        result = ownerSurveyController.getNumberOfVacanciesFromOwner();
        Assert.assertEquals(result, 4);
    }

    @Test
    public void testGetUtilitiesConfirmationFromOwnerWhenAvailable() {
        boolean result;
        Mockito.when(ownerSurveyController.getUtilitiesConfirmationFromOwner()).thenReturn(true);
        result = ownerSurveyController.getUtilitiesConfirmationFromOwner();
        Assert.assertEquals(result, true);
    }

    @Test
    public void testGetUtilitiesConfirmationFromOwnerWhenNotAvailable() {
        boolean result;
        Mockito.when(ownerSurveyController.getUtilitiesConfirmationFromOwner()).thenReturn(false);
        result = ownerSurveyController.getUtilitiesConfirmationFromOwner();
        Assert.assertEquals(result, false);
    }

    @Test
    public void testGetDalhousieUniversityDistanceInputFromOwner() {
        int result;
        Mockito.when(ownerSurveyController.getDalhousieUniversityDistanceInputFromOwner()).thenReturn(1);
        result = ownerSurveyController.getDalhousieUniversityDistanceInputFromOwner();
        Assert.assertEquals(result, 1);
    }

    @Test
    public void testGetGroceryStoreDistanceInputFromOwner() {
        int result;
        Mockito.when(ownerSurveyController.getGroceryStoreDistanceInputFromOwner()).thenReturn(3);
        result = ownerSurveyController.getGroceryStoreDistanceInputFromOwner();
        Assert.assertEquals(result, 3);
    }

    @Test
    public void testGetTheaterDistanceInputFromOwner() {
        int result;
        Mockito.when(ownerSurveyController.getTheaterDistanceInputFromOwner()).thenReturn(23);
        result = ownerSurveyController.getTheaterDistanceInputFromOwner();
        Assert.assertEquals(result, 23);
    }

    @Test
    public void testGetDowntownDistanceInputFromOwner() {
        int result;
        Mockito.when(ownerSurveyController.getDowntownDistanceInputFromOwner()).thenReturn(7);
        result = ownerSurveyController.getDowntownDistanceInputFromOwner();
        Assert.assertEquals(result, 7);
    }
}
