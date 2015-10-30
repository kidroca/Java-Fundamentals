package com.company.Dragons;

        import java.util.ArrayList;
        import java.util.List;

/**
 * Created by kidroca on 28.10.2015 ?..
 */
public class Egg {

    private final static int READY_AGE = 2;

    private Dragon parent;

    private boolean hatched;

    private int age;

    public Egg() {
        this.hatched = false;
        this.age = 0;
    }

    public Egg(Dragon parent) {
        this();
        this.setParent(parent);
    }

    public List<Dragon> hatch(int yearFertilityLevel) {
        if (this.isReady()) {
            List<Dragon> hatchlings = new ArrayList<>();

            for (int i = 0; i < yearFertilityLevel; i++) {
                hatchlings.add(new Dragon(this.parent));
            }

            this.setHatched(true);

            if (yearFertilityLevel < 1) {
                return null;
            } else {
                return hatchlings;
            }
        } else {
            return null;
        }
    }

    public void setParent(Dragon parent) {
        this.parent = parent;
    }

    public boolean isHatched() {
        return this.hatched;
    }

    public boolean isReady() {
        return this.age == READY_AGE;
    }

    public void setHatched(boolean hatched) {
        this.hatched = hatched;
    }

    public void ageUp() {
        if (!this.isHatched()) {
            this.age++;
        }
    }
}
