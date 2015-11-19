package com.company;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Problem4 {

    private static HashMap<String, Project> projectMap = new HashMap<>();
    private static Pattern mainPat = // Pattern.compile("(?<=\\[\")[^\"]+");
            Pattern.compile("\\{\"Project\": \\[\"(?<name>.+)\"\\], \"Type\": \\[\"(?<type>.+)\"\\], \"Message\": \\[\"(?<message>.+)\"]}");

    public static void main(String[] args) {
        readInput();

        List<Project> projects = projectMap.values().stream().collect(Collectors.toList());
        Collections.sort(projects);

        StringBuilder sb = new StringBuilder();

        for (Project project : projects) {
            if (project.getErrorCount() > 0) {
                sb.append(project.toString());
                sb.append("\n");
            }
        }

        if (sb.length() >= 2) {
            sb.delete(sb.length() - 2, sb.length());
        }

        System.out.println(sb.toString());
        // System.out.println("svyrshi");
    }

    private static void readInput() {
        Scanner scanducan = new Scanner(System.in);
       // {\"Project\": [\"Project1\"], \"Type\": [\"Critical\"], \"Message\": [\"File not found\"]}";

        String jstring;
        while (!(jstring = scanducan.nextLine()).equals("END")) {
            Matcher macho = mainPat.matcher(jstring);

            if(macho.find()) {
                List<String> parts = new ArrayList<>();

                parts.add(macho.group("name"));
                parts.add(macho.group("type"));
                parts.add(macho.group("message"));

                addError(parts);
            }
        }
    }

    private static void addError(List<String> parts) {
        String projectName = parts.get(0);
        ErrorType type = ErrorType.valueOf(parts.get(1));
        String message = parts.get(2);

        Project project;
        if (projectMap.containsKey(projectName)) {
            project = projectMap.get(projectName);
        } else {
            project = new Project(projectName);
            projectMap.put(projectName, project);
        }

        AppError currentError = new AppError(message, type, project);
        project.addError(currentError);
    }
}

class Project implements Comparable<Project> {

    public String name;
    public List<AppError> critical;
    public List<AppError> warning;

    public Project(String name) {
        this.name = name;
        this.critical = new ArrayList<>();
        this.warning = new ArrayList<>();
    }

    @Override
    public String toString() {
            //        ProjectName:
            //        Total Errors: {total number of errors}
            //        Critical: {total number of critical critical}
            //        Warnings: {total number of warnings}
            //        Critical Messages:
            //        --->{message of critical error No. 1}
            //        --->{message of critical error No.2}
            //        ...
            //        Warning Messages:
            //        --->{message of warning No. 1}
            //        --->{message of warning No. 2}
            //        ...
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s:\n", this.name))
                .append(String.format("Total Errors: %d\n", this.getErrorCount()))
                .append(String.format("Critical: %d\n", this.critical.size()))
                .append(String.format("Warnings: %d\n", this.warning.size()))
                .append("Critical Messages:\n");

        if (this.critical.size() > 0) {
            Collections.sort(this.critical);

            for (AppError c : this.critical) {
                sb.append(String.format("--->%s\n", c.message));
            }
        } else {
            sb.append("--->None\n");
        }

        sb.append("Warning Messages:\n");

        if (this.warning.size() > 0) {
            Collections.sort(this.warning);

            for (AppError w : this.warning) {
                sb.append(String.format("--->%s\n", w.message));
            }
        } else {
            sb.append("--->None\n");
        }

        return sb.toString();
    }

    @Override
    public int compareTo(Project o) {
        int errors = this.getErrorCount();
        int otherErorrs = o.getErrorCount();

        if (errors != otherErorrs) {
            return otherErorrs - errors;
        } else {
            return this.name.compareTo(o.name);
        }
    }

    public void addError(AppError err) {
        if (err.type == ErrorType.Critical) {
            this.critical.add(err);
        } else {
            this.warning.add(err);
        }
    }

    public int getErrorCount() {
        return this.critical.size() + this.warning.size();
    }
}

class AppError implements Comparable<AppError> {

    public String message;
    public ErrorType type;
    public Project project;

    public AppError(String message, ErrorType type, Project project) {
        this.message = message;
        this.type = type;
        this.project = project;
    }

    @Override
    public int compareTo(AppError other) {
        int lengthCompare = this.message.length() - other.message.length();
        if (lengthCompare != 0) {
            return lengthCompare;
        } else {
            return this.message.compareTo(other.message);
        }
    }
}

enum ErrorType {
    Warning,
    Critical
}