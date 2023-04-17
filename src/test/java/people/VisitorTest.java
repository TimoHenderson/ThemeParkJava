package people;

import attractions.Dodgems;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VisitorTest {

    Visitor visitor;

    @Before
    public void before() {
        visitor = new Visitor(14, 1.2, 40.0);
    }

    @Test
    public void hasAge() {
        assertEquals(14, visitor.getAge());
    }

    @Test
    public void hasHeight() {
        assertEquals(1.2, visitor.getHeight(), 0.1);
    }

    @Test
    public void hasMoney() {
        assertEquals(40.0, visitor.getMoney(), 0.1);
    }

    @Test
    public void hasVisitedAttractions() {
        assertEquals(0, visitor.getNumAttractionsVisited());
    }

    @Test
    public void canVisitAttraction() {
        Dodgems dodgems = new Dodgems("Dodgee", 3);
        visitor.visit(dodgems);
        assertEquals(1, visitor.getNumAttractionsVisited());
    }
}
