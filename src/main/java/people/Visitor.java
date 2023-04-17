package people;

import attractions.Attraction;

import java.util.ArrayList;

public class Visitor {

    private final int age;
    private final double height;
    private final double money;

    private final ArrayList<Attraction> attractionsVisited = new ArrayList<>();

    public Visitor(int age, double height, double money) {
        this.age = age;
        this.height = height;
        this.money = money;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    public double getMoney() {
        return money;
    }

    public int getNumAttractionsVisited() {
        return attractionsVisited.size();
    }

    public void visit(Attraction attraction) {
        attractionsVisited.add(attraction);
    }
}
