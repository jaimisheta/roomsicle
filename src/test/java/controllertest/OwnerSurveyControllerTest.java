package controllertest;

import commandline.RoomsicleCLI;
import controller.OwnerSurveyController;
import database.DatabaseConnection;
import database.OwnerSurveyDAO;
import models.OwnerSurveyModel;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.InputMismatchException;

public class OwnerSurveyControllerTest {

    OwnerSurveyController ownerSurveyController = Mockito.mock(OwnerSurveyController.class);
    RoomsicleCLI roomsicleCLI = Mockito.mock(RoomsicleCLI.class);

    @Test
    public void testSetPropertyAddress() {
        Mockito.doNothing().when(ownerSurveyController).setPropertyAddress();
        ownerSurveyController.setPropertyAddress();
        Mockito.verify(ownerSurveyController, Mockito.times(1)).setPropertyAddress();
    }

//    @Test
//    public void testSetNumberOfBedrooms() {
//        Mockito.doNothing().when(ownerSurveyController).setNumberOfBedrooms();
//        ownerSurveyController.setNumberOfBedrooms();
//        Mockito.verify(ownerSurveyController, Mockito.times(1)).setNumberOfBedrooms();
//    }

//    @Test
//    public void testSetNumberOfBedrooms() {
//        RoomsicleCLI roomsicleCLI = new RoomsicleCLI();
//        boolean thrown = true;
//        Mockito.when(roomsicleCLI.getNumberResponse()).thenReturn(8);
//        //ownerSurveyController.setNumberOfBedrooms();
//        try{
//            ownerSurveyController.setNumberOfBedrooms();
//        } catch (InputMismatchException e) {
//            thrown = true;
//        }
//        Assert.assertTrue(thrown);
//
//        //Mockito.verify(ownerSurveyController, Mockito.times(1)).setNumberOfBedrooms();

    //        OwnerSurveyController osc = new OwnerSurveyController();
//        RoomsicleCLI roomsicleCLI = new RoomsicleCLI();
//        Mockito.when(roomsicleCLI.getNumberResponse()).thenReturn(5);
//        osc.getBedroom();
//        //Mockito.when(osc.getBedroom()).thenReturn(8).thenReturn(5);
//        osc.setBedroom(osc.getBedroom());
//        //Mockito.verify(ownerSurveyController, Mockito.times(2)).getBedroom();
//        Mockito.verify(ownerSurveyController).setBedroom(5);
//    }

/*
    @Test
    public void testSetNumberOfBedrooms() {
        Mockito.doNothing().when(ownerSurveyController).setAndGetNumberOfBedrooms();
        OwnerSurveyModel ownerSurveyModel = new OwnerSurveyModel();
        InputStream sysInBackup = System.in;
        //ByteArrayInputStream in = new ByteArrayInputStream(byte(5));
        InputStream inputStream = new InputStream() {
            @Override
            public int read() throws IOException {
                return 5;
            }
        };
        System.setIn(inputStream);
        OwnerSurveyController ownerSurveyController = new OwnerSurveyController();
        ownerSurveyController.setNumberOfBedrooms();
        Assert.assertEquals(5,ownerSurveyModel.getNumberOfBedrooms());
    }
*/

//    @Test
//    public void testsetBedroom() {
//        OwnerSurveyDAO ownerSurveyDAO = Mockito.mock(OwnerSurveyDAO.class);
//        OwnerSurveyController osc = new OwnerSurveyController(ownerSurveyDAO);
////        osc.setBedroom(5);
//        Assertions.assertEquals(5,osc.getOwnerSurveyModel().getNumberOfBedrooms());
//    }

    @Test
    public void testValidateBedroomInput(){
        OwnerSurveyController osc=new OwnerSurveyController();
        osc.validateAndSetOwnerBedroomInput(5);
        Assertions.assertEquals(5,osc.getOwnerSurveyModel().getNumberOfBedrooms());
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
