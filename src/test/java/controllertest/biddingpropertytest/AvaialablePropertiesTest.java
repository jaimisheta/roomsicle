package controllertest.biddingpropertytest;

import controller.ClassInitializer;
import controller.propertybidding.IAvailableProperties;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AvaialablePropertiesTest {

    @Test
    public void testAvailableProperties(){
        IAvailableProperties availableProperties = ClassInitializer.initializer().getAvailableProperties();
        availableProperties.displayProperties();
        assertEquals(availableProperties.getValidation(),true);
    }

    @Test
    public void testAvailablePropertiesTwo(){
        IAvailableProperties availableProperties = ClassInitializer.initializer().getAvailableProperties();
        assertEquals(availableProperties.getValidation(),false);
    }

}
