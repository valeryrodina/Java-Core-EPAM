package homework_2.random_chars_table;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class RandomCharsTable {

    private static void randomCharsTable(int lengthOfTable, int widthOfTable, String strategy) {

        char[][] randomCharsTable = new char[lengthOfTable][widthOfTable];

        int minRand = 'A';
        int maxRand = 'Z';
        for (int i = 0; i < lengthOfTable; i++) {
            for (int j = 0; j < widthOfTable; j++) {
                randomCharsTable[i][j] = (char) ((int) (Math.random() * (maxRand - minRand + 1) + minRand));
                System.out.print(" | " + randomCharsTable[i][j] + " |");
            }
            System.out.println();
        }

        if ("even".equals(strategy.toLowerCase())) {
            System.out.print("Even letters: ");
        }

        if ("odd".equals(strategy.toLowerCase())) {
            System.out.print("Odd letters: ");
        }

        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < lengthOfTable; i++) {
            for (int j = 0; j < widthOfTable; j++) {
                int codeOfChar = randomCharsTable[i][j];
                if ("even".equals(strategy.toLowerCase())) {
                    if (codeOfChar % 2 == 0) {
                        stringBuffer.append(" ").append((char) codeOfChar).append(" ,");
                    }
                }

                if ("odd".equals(strategy.toLowerCase())) {
                    if (codeOfChar % 2 != 0) {
                        stringBuffer.append(" ").append((char) codeOfChar).append(" ,");
                    }
                }
            }
        }

        stringBuffer.deleteCharAt(stringBuffer.length() - 1);

        System.out.print(stringBuffer);
    }

    public void run() {
        System.out.println("Please type size of a table: 2 numbers and strategy - even or odd:");
        String inputData = readData();
        try (Scanner inputDataSeparate = new Scanner(inputData)) {
            int lengthOfTable = inputDataSeparate.nextInt();
            int widthOfTable = inputDataSeparate.nextInt();
            String strategy = inputDataSeparate.next();
            if (!"even".equalsIgnoreCase(strategy) && !"odd".equalsIgnoreCase(strategy)) {
                System.out.println("Please type a correct strategy: even or odd");
                return;
            }
            randomCharsTable(lengthOfTable, widthOfTable, strategy);
        } catch (NegativeArraySizeException | NoSuchElementException e) {
            System.out.println("You typed negative numbers or strategy/numbers are not added");
        }
    }

    private String readData() {
        String inputData;
        try (Scanner scanner = new Scanner(System.in)) {
            inputData = scanner.nextLine();
        } catch (InputMismatchException e) {
            return "Please follow to the correct format: 2 positive numbers + even/odd word";
        }
        return inputData;
    }
}