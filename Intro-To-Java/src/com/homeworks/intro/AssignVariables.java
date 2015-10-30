package com.homeworks.intro;

/**
 * Find suitable types for variables.
 * You are given the following types: byte, short, int, long, char, boolean, float, double, and String.
 * Assign the following values to them false, “Palo Alto, CA”, 32767, 2000000000, 0.1234567891011, 0.5f,
 * 919827112351L, 127, ‘c’. Try to assign 32768 to short and see what happens.
 **/
public class AssignVariables {

    public static void main(String[] args) {

        boolean homeworkCompleted = false;

        String location = "Palo Alto, CA";

        short someShort = 32767;

        int someInt = 2000000000;

        double doubleTrouble = 0.1234567891011;

        float floatBoat = 0.5f;

        long sixtyFourBitIneger = 919827112351L;

        byte iBite = 127;

        char charcoal = 'c';

        // short answerToEverithing = 32768;
        // Incompatible Type, turns out there isn't ushort in java or any other unsigned type for that matter
    }
}
