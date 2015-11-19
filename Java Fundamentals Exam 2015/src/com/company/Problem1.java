package com.company;

import java.util.Scanner;

/**
 * Created by kidroca on 15.11.2015 ?..
 */
public class Problem1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int totalPeople = Integer.parseInt(scan.nextLine());
        int totalLines = Integer.parseInt(scan.nextLine());

        int bedsNeeded = totalPeople,
                mealsNeedeed = totalPeople;

        for (int i = 0; i < totalLines; i++) {
            String[] tokens = scan.nextLine().split("\\s+");

            int count = Integer.parseInt(tokens[1]);

            switch (tokens[0]) {
                case "tents":
                    int tentBeds = getBedsFromTents(count, tokens[2]);
                    bedsNeeded -= tentBeds;
                    break;
                case "rooms":
                    int roomBeds = getBedsFromRooms(count, tokens[2]);
                    bedsNeeded -= roomBeds;
                    break;
                case "food":
                    int food = calcFood(count, tokens[2]);
                    mealsNeedeed -= food;
                    break;
            }
        }

        if (bedsNeeded <= 0) {
            System.out.printf("Everyone is happy and sleeping well. Beds left: %d\n", Math.abs(bedsNeeded));
        } else {
            System.out.printf("Some people are freezing cold. Beds needed: %d\n", bedsNeeded);
        }

        if (mealsNeedeed <= 0) {
            System.out.printf("Nobody left hungry. Meals left: %d\n", Math.abs(mealsNeedeed));
        } else {
            System.out.printf("People are starving. Meals needed: %d", mealsNeedeed);
        }
    }

    private static int calcFood(int count, String food) {
        if (food.equals("musaka")) return count * 2;

        return 0;
    }

    private static int getBedsFromRooms(int count, String type) {
        if (type.equals("single")) return count;
        if (type.equals("double")) return count * 2;

        return count * 3;
    }

    private static int getBedsFromTents(int count, String type) {
        if (type.equals("firstClass")) {
            return count  * 3;
        } else{
            return count * 2;
        }
    }
}
