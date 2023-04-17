import attractions.Attraction;
import behaviours.IReviewed;
import behaviours.ISecurity;
import people.Visitor;
import stalls.Stall;

import java.util.ArrayList;
import java.util.HashMap;

public class ThemePark {
    ArrayList<Attraction> attractions;
    ArrayList<Stall> stalls;

    public ThemePark(ArrayList<Attraction> attractions, ArrayList<Stall> stalls) {
        this.attractions = attractions;
        this.stalls = stalls;
    }

    public int getNumAttractions() {
        return attractions.size();
    }

    public int getNumStalls() {
        return stalls.size();
    }

    public ArrayList<IReviewed> getAllReviewed() {
        ArrayList<IReviewed> reviewed = new ArrayList<>();
        reviewed.addAll(attractions);
        reviewed.addAll(stalls);
        return reviewed;
    }

    public void visit(Visitor visitor, Attraction attraction) {
        visitor.visit(attraction);
        attraction.visit();
    }

    public HashMap<String, Integer> getReviews() {
        HashMap<String, Integer> reviews = new HashMap<>();
        for (IReviewed reviewed : getAllReviewed()) {
            reviews.put(reviewed.getName(), reviewed.getRating());
        }
        return reviews;
    }

    public ArrayList<IReviewed> getAllowedFor(Visitor visitor) {
        ArrayList<IReviewed> allowed = new ArrayList<>();
        for (Attraction attraction : attractions) {
            if (attraction instanceof ISecurity) {
                if (((ISecurity) attraction).isAllowedTo(visitor)) {
                    allowed.add(attraction);
                }
            } else {
                allowed.add(attraction);
            }
        }
        return allowed;
    }
}
