package controllertest.filterroommatetest;

import controller.ClassInitializer;
import controller.filterroommates.IFilterRoommates;
import controller.filterroommates.IFilterRoommatesDisplayController;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilterRoommatesDisplayControllerTest {
    
    @Test
    public void testFilterRoommatesDisplay() {
        IFilterRoommatesDisplayController filterRoommatesDisplayController;
        filterRoommatesDisplayController = ClassInitializer.initializer().getFilterRoommatesDisplayController();
        assertEquals(filterRoommatesDisplayController.getValidation(),false);
    }
}
