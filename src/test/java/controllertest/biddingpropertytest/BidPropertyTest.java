package controllertest.biddingpropertytest;

import controller.propertybidding.BidProperty;
import controller.propertybidding.IBidProperty;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BidPropertyTest {

    @Test
    public void testBidProperty(){
        IBidProperty asker = mock(BidProperty.class);
        when(asker.getValidation()).thenReturn(true);
        assertEquals(asker.getValidation(),true);
    }

    @Test
    public void testBidProperty2(){
        IBidProperty asker = mock(BidProperty.class);
        when(asker.getValidation()).thenReturn(false);
        assertEquals(asker.getValidation(),false);
    }
}
