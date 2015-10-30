package com.company;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Write a program to count the number of words in given sentence. Use any non-letter character as word separator.
 *
 * Write a program to find how many times a word appears in given text. The text is given at the first input line.
 * The target word is given at the second input line. The output is an integer number. Please ignore the character
 * casing. Consider that any non-letter character is a word separator. Examples:
 */
public class CountTheWords {

    public static void main(String[] args) {
        Scanner scatman = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("COUNT ALL WORDS\n");
        System.out.print("Input some form of text and press Enter twice: ");

        StringBuilder textBuilder = new StringBuilder();

        String currentLine;
        while ((currentLine = scatman.nextLine()).length() > 0) {
            textBuilder.append(currentLine);
        }

        String text = textBuilder.toString();
        long wordsCount = countAllWords(text, "[^A-Za-z]");

        System.out.printf("Words count: %d", wordsCount);

        System.out.println("\n\nCOUNT SPECIFIC WORDS\n  ");
        System.out.print("Enter a specific word to count appearances: ");
        String word = scatman.next();

        int appearances = countWordAppearances(text, word);
        System.out.printf("Word appearances: %d", appearances);

        System.out.println("\n\nCOUNT SUBSTRING OCCURRENCES\n");
        System.out.println("Enter a specific substring to count occurrences: ");
        String subStr = scatman.next();

        int occurrences = countWordAppearances(text, subStr, true, false);
        System.out.printf("Substring occurrences: %d", occurrences);
    }

    private static int countWordAppearances(String text, String word) {
        return countWordAppearances(text, word, false, false);
    }

    private static int countWordAppearances(
            String text, String word, boolean isSubstring, boolean isCaseSensitive) {
        int casing = isCaseSensitive ? 0 : Pattern.CASE_INSENSITIVE;
        word = isSubstring ? word : "\\b" + word + "\\b";

        Pattern p = Pattern.compile(word, casing);
        Matcher macho = p.matcher(text);

        List<String> matches = new ArrayList<>();
        while (macho.find()) {
            matches.add(macho.group());
        }

        return matches.size();
    }

    private static long countAllWords(String text, String splitPattern) {
        String[] words = text.split(splitPattern, 0);
        long count = Arrays.stream(words)
                .filter(w -> !w.equals(""))
                .count();

        return count;
    }
}
