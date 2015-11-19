package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by kidroca on 15.11.2015 ?..
 */
public class Problem3 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] dimensions = scan.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]),
                cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = buildMatrix(rows, cols);

        int commandsCount = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < commandsCount; i++) {
            String[] command = scan.nextLine().split("\\s+");
            executeCommand(command, matrix);
        }

       //printMatrix(matrix);

        startSwapAction(matrix);
    }

    private static void startSwapAction(int[][] matrix) {
        int position = 1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == position) {
                    System.out.println("No swap required");
                } else {
                    int[] index = findIndex(matrix, i, position);
                    if (index != null) {
                        swapValues(matrix, i, j, index[0], index[1]);
                        System.out.println();
                    }
                }

                position++;

                //printMatrix(matrix);
            }
        }
    }

    private static void swapValues(int[][] matrix, int i, int j, int i2, int j2) {
        System.out.printf("Swap (%d, %d) with (%d, %d)", i, j, i2, j2);
        int temp = matrix[i][j];
        matrix[i][j] = matrix[i2][j2];
        matrix[i2][j2] = temp;
    }

    private static int[] findIndex(int[][] matrix, int i, int position) {
        for (int j = i; j < matrix.length; j++) {
            for (int k = 0; k < matrix[j].length; k++) {
                if (matrix[j][k] == position) {
                    return new int[] {j, k};
                }
            }
        }

        return null;
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%d ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void executeCommand(String[] command, int[][] matrix) {
        int rowCol = Integer.parseInt(command[0]);
        int turns = Integer.parseInt(command[2]);
        switch (command[1]) {
            case "up":
                moveRow(matrix, rowCol, turns, -1);
            break;
            case "down":
                moveRow(matrix, rowCol, turns, +1);
                break;
            case "left":
                moveCol(matrix, rowCol, turns, -1);
                break;
            case "right":
                moveCol(matrix, rowCol, turns, +1);
                break;
        }
    }

    private static void moveRow(int[][] matrix, int col, int turns, int operation) {
        turns %= matrix.length;
        if (turns == 0) return;

        int next;

        if (operation > 0) {
            next = turns;
            ascendingRowSwap(matrix, col, next);
        } else {
            next = matrix.length - turns - 1;
            descendingRowSwap(matrix, col, next);
        }
    }

    private static void descendingRowSwap(int[][] matrix, int col, int next) {
        Queue<Integer> arangement = new LinkedList<>();
        for (int i = matrix.length - 1; i >= 0; i--) {
            arangement.add(matrix[i][col]);
        }

        int count = matrix.length;

        while (count > 0) {
            if (!isWithinRange(next, matrix.length)) {
                next = matrix.length - 1;
            }

            matrix[next][col] = arangement.poll();
            count--;
            next -= 1;
        }
    }

    private static void ascendingRowSwap(int[][] matrix, int col, int next) {
        Queue<Integer> arangement = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            arangement.add(matrix[i][col]);
        }

        int count = matrix.length;

        while (count > 0) {
            if (!isWithinRange(next, matrix.length)) {
                next = 0;
            }

            matrix[next][col] = arangement.poll();
            count--;
            next += 1;
        }
    }

    private static boolean isWithinRange(int next, int length) {
        return 0 <= next && next < length;
    }

    private static void moveCol(int[][] matrix, int row, int turns, int operation) {
        turns %= matrix[0].length;

        int next;

        if (operation > 0) {
            next = turns;
            ascendingColSwap(matrix, row, next);
        } else {
            next = matrix[row].length - turns - 1;
            descendingColSwap(matrix, row, next);
        }
    }

    private static void descendingColSwap(int[][] matrix, int row, int next) {
        Queue<Integer> arangement = new LinkedList<>();
        for (int i = matrix[row].length - 1; i >= 0; i--) {
            arangement.add(matrix[row][i]);
        }

        int count = matrix[row].length;

        while (count > 0) {
            if (!isWithinRange(next, matrix[row].length)) {
                next = matrix[row].length - 1;
            }

            matrix[row][next] = arangement.poll();
            count--;
            next -= 1;
        }
    }

    private static void ascendingColSwap(int[][] matrix, int row, int next) {
        Queue<Integer> arangement = new LinkedList<>();
        for (int i = 0; i < matrix[row].length; i++) {
            arangement.add(matrix[row][i]);
        }

        int count = matrix[row].length;

        while (count > 0) {
            if (!isWithinRange(next, matrix[row].length)) {
                next = 0;
            }

            matrix[row][next] = arangement.poll();
            count--;
            next += 1;
        }
    }

    private static int[][] buildMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][];

        int counter = 1;
        for (int i = 0; i < rows; i++) {
            matrix[i] = new int[cols];
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = counter++;
            }
        }

        return matrix;
    }
}
