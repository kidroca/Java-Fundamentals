package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kidroca on 15.11.2015 ?..
 */
public class Problem2 {

    static Pattern pattern = Pattern.compile("([A-Z][a-z]+).*?([A-Z][a-z]*?[A-Z]).*?([\\d]+)L");

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner scando = new Scanner(System.in);

        int litersUnitlNow = 0;

        String line;
        while(!(line = scando.nextLine()).equals("OK KoftiShans")) {
            int lineLitters = processNextLine(line);
            litersUnitlNow += lineLitters;
        }

        System.out.print(sb.toString());
        System.out.printf("%.3f softuni liters", (double)litersUnitlNow * 0.001);
    }

    private static int processNextLine(String line) {
        int totalLitters = 0;

        Matcher gMatcher = pattern.matcher(line);

        while (gMatcher.find()) {

            String guest = gMatcher.group(1);
            String alcohol = gMatcher.group(2);

            int litters = Integer.parseInt(gMatcher.group(3));
            totalLitters += litters;

            sb.append(String.format("%s brought %d liters of %s!\n", guest, litters, alcohol.toLowerCase()));
        }

        return totalLitters;
    }
}