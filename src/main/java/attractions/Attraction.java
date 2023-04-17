package attractions;

import behaviours.IReviewed;

public abstract class Attraction implements IReviewed {
    private final String name;
    private final int rating;
    private int visitCount;

    public Attraction(String name, int rating) {
        this.name = name;
        this.rating = rating;
        this.visitCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public int getVisitCount() {
        return visitCount;
    }

    public void visit() {
        visitCount += 1;
    }
}
