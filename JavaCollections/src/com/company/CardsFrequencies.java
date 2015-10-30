package com.company;

import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * We are given a sequence of N playing cards from a standard deck. The input consists of several
 * cards (face + suit), separated by a space. Write a program to calculate and print at the console
 * the frequency of each card face in format "card_face -> frequency". The frequency is calculated
 * by the formula appearances / N and is expressed in percentages with exactly 2 digits after the
 * decimal point. The card faces with their frequency should be printed in the order of the card
 * face's first appearance in the input. The same card can appear multiple times in the input, but
 * it's face should be listed only once in the output.
 */
public class CardsFrequencies {

    public static void main(String[] args) {
        Scanner unPerro = new Scanner(System.in);

        System.out.print("Enter some playing cards: ");
        String[] cards = unPerro.nextLine().split(" ");

        LinkedHashMap<String, Integer> faces = new LinkedHashMap<>();

        for (String card : cards) {
            String face = card.substring(0, card.length() - 1);
            if (!faces.containsKey(face)) {
                faces.put(face, 0);
            }

            faces.put(face, faces.get(face) + 1);
        }

        for (String s : faces.keySet()) {
            float appearances = (faces.get(s) / (float)cards.length) * 100;
            System.out.printf("%s -> %.2f%%\n", s, appearances);
        }
    }
}
