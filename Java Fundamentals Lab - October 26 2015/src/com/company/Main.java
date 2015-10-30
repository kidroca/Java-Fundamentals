package com.company;

import com.company.Dragons.Dragon;
import com.company.Dragons.Egg;

import java.io.PrintStream;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner dScaner = new Scanner(System.in).useLocale(Locale.US);

        int dragonsCount = Integer.parseInt(dScaner.nextLine());

        List<Dragon> theFirstDragonsOfThisDragonAgeNameCannotBeShorter = new ArrayList<>();

        for (int i = 0; i < dragonsCount; i++) {
            int eggsCount = Integer.parseInt(dScaner.nextLine());
            List<Egg> eggs = new ArrayList<>();

            for (int j = 0; j < eggsCount; j++) {
                eggs.add(new Egg());
            }

            Dragon dragon = new Dragon(eggs);
            theFirstDragonsOfThisDragonAgeNameCannotBeShorter.add(dragon);
        }

        int numberOfYears = Integer.parseInt(dScaner.nextLine());

        for (int i = 0; i < numberOfYears; i++) {
            String fertilityLevel = dScaner.nextLine();
            int yearFertility;

            switch (fertilityLevel.toLowerCase()) {
                case "bad": yearFertility = 0;
                    break;
                case "normal": yearFertility = 1;
                    break;
                case "good": yearFertility = 2;
                    break;
                default: throw new IllegalArgumentException(
                        "Unexpected parameter '" + fertilityLevel + "' for year fertility");
            }

            for (Dragon dragoman : theFirstDragonsOfThisDragonAgeNameCannotBeShorter) {
                passYearCycle(dragoman, yearFertility);
            }
        }

        List<Dragon> allAliveDragons = getAllAliveDragons(theFirstDragonsOfThisDragonAgeNameCannotBeShorter);

        printDragonarchy(allAliveDragons, System.out);
    }

    private static void printDragonarchy(List<Dragon> allAliveDragons, PrintStream out) {
        for (Dragon dragan : allAliveDragons) {
            StringBuilder sb = new StringBuilder();
            getDragonFamilyTree(sb, "", dragan);
            System.out.println(sb.toString());
        }
    }

    private static void getDragonFamilyTree(StringBuilder sb, String prepend, Dragon dragan) {
        if (dragan != null) {
            sb.insert(0, dragan.toString());

            if (dragan.getParent() == null) {
                sb.insert(0, prepend);
            } else {
                prepend += "  ";
                sb.insert(0, "/");
                getDragonFamilyTree(sb, prepend, dragan.getParent());
            }
        }
    }

    private static List<Dragon> getAllAliveDragons(List<Dragon> theFirstDragonsOfThisDragonAgeNameCannotBeShorter) {
        List<Dragon> allDragonsAlive = new ArrayList<>();

        for (Dragon dragon : theFirstDragonsOfThisDragonAgeNameCannotBeShorter) {
            if (dragon.isAlive()) {
                allDragonsAlive.add(dragon);
            }

            getAliveDragons(dragon, allDragonsAlive);
        }

        return allDragonsAlive;
    }

    private static void getAliveDragons(Dragon dragon, List<Dragon> allDragonsAlive) {
        for (Dragon child : dragon.getChildren()) {
            if (child.isAlive()) {
                allDragonsAlive.add(child);
            }

            getAliveDragons(child, allDragonsAlive);
        }
    }

    private static void passYearCycle(Dragon dragon, int yearFertility) {
        if (dragon.getChildren().size() > 0) {
            dragon.getChildren().forEach(d -> passYearCycle(d, yearFertility));
        }

        dragon.ageUp();
        dragon.hatchEggs(yearFertility);
        dragon.layEgg();
    }
}
