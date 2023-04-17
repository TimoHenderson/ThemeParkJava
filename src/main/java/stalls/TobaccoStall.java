package stalls;

import behaviours.ISecurity;
import people.Visitor;

public class TobaccoStall extends Stall implements ISecurity {

    public TobaccoStall(String name, int rating, String ownerName, ParkingSpot parkingSpot) {
        super(name, rating, ownerName, parkingSpot);
    }

    @Override
    public boolean isAllowedTo(Visitor visitor) {
        return visitor.getAge() >= 18;
    }
}
