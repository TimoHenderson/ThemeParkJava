package stalls;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IceCreamStallTest {

    IceCreamStall iceCreamStall;

    @Before
    public void setUp() {
        iceCreamStall = new IceCreamStall("Dream Cones", 3, "Vanilla Ice", ParkingSpot.A4);
    }

    @Test
    public void hasName() {
        assertEquals("Dream Cones", iceCreamStall.getName());
    }

    @Test
    public void hasOwner() {
        assertEquals("Vanilla Ice", iceCreamStall.getOwnerName());
    }

    @Test
    public void hasParkingSpot() {
        assertEquals(ParkingSpot.A4, iceCreamStall.getParkingSpot());
    }
}
