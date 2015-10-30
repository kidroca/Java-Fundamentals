package com.company;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Write a program that reads two lists of letters l1 and l2 and combines them: appends all letters c
 * from l2 to the end of l1, but only when c does not appear in l1. Print the obtained combined list.
 * All lists are given as sequence of letters separated by a single space, each at a separate line.
 * Use ArrayList<Character> of chars to keep the input and output lists.
 */
public class CombineLettersLists {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter character for the first list: ");
        List<Character> listA = toCharList(input.nextLine().toCharArray());

        System.out.print("Enter character for the second list: ");
        List<Character> listB = toCharList(input.nextLine().toCharArray());

        listA.addAll(listB.stream()
                .filter(c -> !listA.contains(c))
                .collect(Collectors.toList()));

        System.out.print("Result: ");
        listA.forEach(c -> System.out.printf("%c ", c));
    }

    private static List<Character> toCharList(char[] charArray) {
        List<Character> list = new ArrayList<>();
        for (char c : charArray) {
            if (c != ' '){
                list.add(c);
            }
        }

        return list;
    }
}
