package controllertest;

import controller.OwnerSurveyController;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class OwnerSurveyControllerTest {

    OwnerSurveyController ownerSurveyController = Mockito.mock(OwnerSurveyController.class);

    @Test
    public void testSetPropertyAddress() {
        Mockito.doNothing().when(ownerSurveyController).setPropertyAddress();
        ownerSurveyController.setPropertyAddress();
        Mockito.verify(ownerSurveyController, Mockito.times(1)).setPropertyAddress();
    }

    @Test
    public void testSetNumberOfBedrooms() {
        Mockito.doNothing().when(ownerSurveyController).setNumberOfBedrooms();
        ownerSurveyController.setNumberOfBedrooms();
        Mockito.verify(ownerSurveyController, Mockito.times(1)).setNumberOfBedrooms();
    }

    @Test
    public void testSetNumberOfVacancies() {
        Mockito.doNothing().when(ownerSurveyController).setNumberOfVacancies();
        ownerSurveyController.setNumberOfVacancies();
        Mockito.verify(ownerSurveyController, Mockito.times(1)).setNumberOfVacancies();
    }

    @Test
    public void testSetUtilitiesConfirmation() {
        Mockito.doNothing().when(ownerSurveyController).setUtilitiesConfirmation();
        ownerSurveyController.setUtilitiesConfirmation();
        Mockito.verify(ownerSurveyController, Mockito.times(1)).setUtilitiesConfirmation();
    }

    @Test
    public void testSetDalhousieUniversityDistance() {
        Mockito.doNothing().when(ownerSurveyController).setDalhousieUniversityDistance();
        ownerSurveyController.setDalhousieUniversityDistance();
        Mockito.verify(ownerSurveyController, Mockito.times(1)).setDalhousieUniversityDistance();
    }

    @Test
    public void testSetGroceryStoreDistance() {
        Mockito.doNothing().when(ownerSurveyController).setGroceryStoreDistance();
        ownerSurveyController.setGroceryStoreDistance();
        Mockito.verify(ownerSurveyController, Mockito.times(1)).setGroceryStoreDistance();
    }

    @Test
    public void testSetTheaterDistance() {
        Mockito.doNothing().when(ownerSurveyController).setTheaterDistance();
        ownerSurveyController.setTheaterDistance();
        Mockito.verify(ownerSurveyController, Mockito.times(1)).setTheaterDistance();
    }

    @Test
    public void testSetDowntownDistance() {
        Mockito.doNothing().when(ownerSurveyController).setDowntownDistance();
        ownerSurveyController.setDowntownDistance();
        Mockito.verify(ownerSurveyController, Mockito.times(1)).setDowntownDistance();
    }
}
