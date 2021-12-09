//package controllertest.bestfitroommatetest;
//
//import controller.ClassInitializer;
//import controller.bestfitroommates.IBestFitRoommateController;
//import controller.bestfitroommates.IBestFitRoommatesDisplayController;
//import org.junit.Test;
//
//import static org.junit.Assert.assertEquals;
//
//public class BestFitRoommateDisplayControllerTest {
//
//    @Test
//    public void testBestFitRoommateDisplayController(){
//        IBestFitRoommatesDisplayController bestFitRoommatesDisplayController;
//        IBestFitRoommateController bestFitRoommateController;
//
//        bestFitRoommateController = ClassInitializer.initializer().getBestFitRoommateController();
//        bestFitRoommatesDisplayController = ClassInitializer.initializer().getBestFitRoommatesDisplayController();
//        bestFitRoommatesDisplayController.getBestFits(bestFitRoommateController);
//
//        assertEquals(bestFitRoommatesDisplayController.getValidation(),true);
//    }
//
//}
