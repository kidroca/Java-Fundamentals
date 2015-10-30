package com.company;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Write a program to extract all email addresses from given text. The text comes at the first input line.
 * Print the emails in the output, each at a separate line.
 * Emails are considered to be in format <user>@<host>, where:
        <user> is a sequence of letters and digits, where '.', '-' and '_' can appear between them.
        Examples of valid users: "stephan", "mike03", "s.johnson", "st_steward", "softuni-bulgaria",
        "12345". Examples of invalid users: ''--123", ".....", "nakov_-", "_steve", ".info".

        <host> is a sequence of at least two words, separated by dots '.'. Each word is sequence of
        letters and can have hyphens '-' between the letters. Examples of hosts: "softuni.bg",
        "software-university.com", "intoprogramming.info", "mail.softuni.org". Examples of invalid hosts:
        "helloworld", ".unknown.soft.", "invalid-host-", "invalid-".

        Example of valid emails: info@softuni-bulgaria.org, kiki@hotmail.co.uk, no-reply@github.com,
        s.peterson@mail.uu.net, info-bg@software-university.software.academy.
 */
public class ExtractEmails {

    public static void main(String[] args) {
        Scanner ultraScaner = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("Enter text containing emails or just hit enter for the predefined test: ");
        String text = ultraScaner.nextLine();
        if (text.isEmpty()) {
            text = readTestFile("emails.txt");
        }

        List<String> emails = extractAllEmails(text);

        System.out.println("Extracted emails:");
        emails.forEach(x -> System.out.printf("\t\t\t%s\n", x));
    }

    private static String readTestFile(String path) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(path), Charset.defaultCharset());
            return String.join("\n", lines);
        } catch (IOException e) {
            return null;
        }
    }

    private static List<String> extractAllEmails(String text) {
        List<String> extracted = new ArrayList<>();

        Pattern p = Pattern
            .compile("(?<=[ ]|^)[A-Za-z0-9][\\w.\\-]+?(?<![^\\w])@(?=[A-Za-z\\-]+\\.[A-Za-z\\-]+)[^\\d\\s]+(?=\\b)");

        Matcher matcher = p.matcher(text);
        while (matcher.find()) {
            extracted.add(matcher.group());
        }

        return extracted;
    }
}
