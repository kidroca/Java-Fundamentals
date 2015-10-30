package com.company.Dragons;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by kidroca on 28.10.2015 ?..
 */
public class Dragon implements Comparable<Dragon> {

    public static final String DRAGON_GENERIC_NAME = "Dragon";

    private static final int LAYING_MIN_AGE = 3;

    private static final int LAYING_MAX_AGE = 4;

    private static final int AGE_THRESHOLD = 6;

    private static int NextDragonNumber = 1;

    private int id;

    private int age;

    private List<Egg> eggs;

    private Dragon parent;

    private List<Dragon> children;

    public Dragon() {
        this.id = NextDragonNumber++;
        this.age = 0;
        this.eggs = new ArrayList<Egg>();
        this.children = new ArrayList<Dragon>();
    }

    public Dragon(List<Egg> eggs) {
        this();
        this.eggs = eggs;

        this.eggs.forEach(egg -> egg.setParent(this));
    }

    public Dragon(Dragon parent) {
        this();
        this.parent = parent;
    }

    public Dragon getParent() {
        return this.parent;
    }

    public List<Dragon> getChildren() {
        return this.children;
    }

    public int getId() {
        return this.id;
    }

    public boolean isAlive() {
        return this.age < AGE_THRESHOLD;
    }

    @Override
    public int compareTo(Dragon dragon) {
        return this.id - dragon.getId();
    }

    @Override
    public String toString() {
        return DRAGON_GENERIC_NAME + "_" + this.id;
    }

    public void ageUp() {
        if (this.isAlive()) {
            this.age++;
        }

        this.eggs.forEach(e -> e.ageUp());
    }

    public Egg layEgg() {
        if (this.canLayEggs()) {
            Egg babyEgg = new Egg(this);
            this.eggs.add(babyEgg);

            return babyEgg;
        } else {
            return null;
        }
    }

    public List<Dragon> hatchEggs(int yearFertilityLevel) {
        if (this.eggs == null || !this.isAlive()) {
            return null;
        }

        List<Dragon> hatchlings = new ArrayList<>();

        for (Egg egg : this.eggs) {
            List<Dragon> babies = egg.hatch(yearFertilityLevel);

            if (babies != null) {
                hatchlings.addAll(babies);
            }
        }

        this.eggs = this.eggs.stream()
                .filter(egg -> !egg.isHatched())
                .collect(Collectors.toList());

        if (hatchlings.size() > 0) {
            this.children.addAll(hatchlings);
            return hatchlings;
        } else {
            return null;
        }
    }

    private boolean canLayEggs() {
        return LAYING_MIN_AGE <= this.age && this.age <= LAYING_MAX_AGE;
    }

}
