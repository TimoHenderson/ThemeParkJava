package stalls;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CandyflossStallTest {

    CandyflossStall candyflossStall;

    @Before
    public void setUp() {
        candyflossStall = new CandyflossStall("Candy Land", 2, "Harry Belafonte", ParkingSpot.A1);
    }

    @Test
    public void hasName() {
        assertEquals("Candy Land", candyflossStall.getName());
    }

    @Test
    public void hasOwner() {
        assertEquals("Harry Belafonte", candyflossStall.getOwnerName());
    }

    @Test
    public void hasParkingSpot() {
        assertEquals(ParkingSpot.A1, candyflossStall.getParkingSpot());
    }
}
