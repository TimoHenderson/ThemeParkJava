import attractions.*;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.*;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {
    ThemePark themePark;

    ArrayList<Attraction> attractions;
    ArrayList<Stall> stalls;

    @Before
    public void setUp() {
        attractions = new ArrayList<>();
        attractions.add(new Dodgems("Dodgems", 2));
        attractions.add(new Park("Swingies", 1));
        attractions.add(new Playground("KidLand", 4));
        attractions.add(new RollerCoaster("The Dragon", 5));

        stalls = new ArrayList<>();
        stalls.add(new CandyflossStall("Candy Land", 2, "Harry Belafonte", ParkingSpot.A1));
        stalls.add(new IceCreamStall("Dream Cones", 3, "Vanilla Ice", ParkingSpot.A4));
        stalls.add(new TobaccoStall("Jacks Drum", 5, "Jack Jarvis", ParkingSpot.B1));

        themePark = new ThemePark(attractions, stalls);
    }

    @Test
    public void hasAttractions() {
        assertEquals(4, themePark.getNumAttractions());
    }

    @Test
    public void hasStalls() {
        assertEquals(3, themePark.getNumStalls());
    }

    @Test
    public void canGetAllReviewed() {
        assertEquals(7, themePark.getAllReviewed().size());
    }

    @Test
    public void canAddVisit() {
        Visitor visitor = new Visitor(20, 180, 45.00);
        Attraction attraction = attractions.get(0);
        themePark.visit(visitor, attraction);
        assertEquals(1, visitor.getNumAttractionsVisited());
        assertEquals(1, attraction.getVisitCount());
    }

    @Test
    public void canGetAllReviews() {
        HashMap<String, Integer> expectedReviews = new HashMap<>();
        expectedReviews.put("Dodgems", 2);
        expectedReviews.put("Swingies", 1);
        expectedReviews.put("KidLand", 4);
        expectedReviews.put("The Dragon", 5);
        expectedReviews.put("Candy Land", 2);
        expectedReviews.put("Dream Cones", 3);
        expectedReviews.put("Jacks Drum", 5);

        assertEquals(expectedReviews, themePark.getReviews());
    }

    @Test
    public void canGetAllowedRidesUnder12() {
        Visitor child = new Visitor(11, 124, 10);
        assertEquals(3, themePark.getAllowedFor(child).size());
    }

    @Test
    public void canGetAllowedRidesOver12Under145() {
        Visitor child = new Visitor(13, 124, 10);
        assertEquals(3, themePark.getAllowedFor(child).size());
    }

    @Test
    public void canGetAllowedRidesOver12Over145() {
        Visitor child = new Visitor(13, 146, 10);
        assertEquals(4, themePark.getAllowedFor(child).size());
    }

    @Test
    public void canGetAllowedRidesOver15Over145() {
        Visitor child = new Visitor(16, 146, 10);
        assertEquals(3, themePark.getAllowedFor(child).size());
    }


}
