package stalls;

import behaviours.IReviewed;

public abstract class Stall implements IReviewed {

    private String name;

    private int rating;
    private String ownerName;
    private ParkingSpot parkingSpot;

    public Stall(String name, int rating, String ownerName, ParkingSpot parkingSpot) {
        this.name = name;
        this.rating = rating;
        this.ownerName = ownerName;
        this.parkingSpot = parkingSpot;
    }

    @Override
    public int getRating() {
        return rating;
    }

    public String getName() {
        return name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }
}
