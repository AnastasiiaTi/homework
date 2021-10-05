package lessons.homework1;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Lesson1 {
    
    public static void main(String[] args) throws IOException {
        printLineOfNumbers();
        printLineWithChanges();
        System.out.println();
        average();
        System.out.println(createString());
        String strToRemoveSpaces = "    Good morning! What a     nice   day!      ";
        String blanksRemoved = removeSpacesFromString(strToRemoveSpaces);
        System.out.println(blanksRemoved);

        String theString = "";

        File file = new File("/Users/nastyatitova/Downloads/task6.txt");
        Scanner scanner = new Scanner(file);
        theString = scanner.nextLine();
        int amountOfColumns = theString.length();
        int amountOfLines = 0;

        while (scanner.hasNextLine()) {
            theString = theString + scanner.nextLine();
            amountOfLines++;
        }

        char arrayNeeded[][] = new char[amountOfLines][amountOfColumns];
        for (int i = 0; i < arrayNeeded.length; i++) {
            for (int j = 0; j < arrayNeeded[i].length; j++) {
                arrayNeeded[i][j] = theString.charAt(i * amountOfColumns + j);
            }
        }

        for (int i = 0; i < arrayNeeded.length; i++) {
            String tmp = "";
            for (int j = 0; j < arrayNeeded[i].length; j++) {
                tmp += arrayNeeded[i][j];
            }
            System.out.println(tmp);
        }

        System.out.println();
        for (int i = 0; i < arrayNeeded.length; i++) {
            for (int j = 0; j < arrayNeeded[i].length; j++) {
                System.out.print(arrayNeeded[i][j]);
            }
            System.out.println();
        }
        boolean result = findTheWord(arrayNeeded, "cat");
        System.out.println(result);

    }

    public static void printLineOfNumbers() {
        for (int i = 1; i <= 100; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void printLineWithChanges() {
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0) {
                System.out.print("Hello ");
            } else if (i % 5 == 0) {
                System.out.print("World ");
            } else if (i % 3 == 0 && i % 5 == 0) {
                System.out.print("HelloWorld ");
            } else {
                System.out.print(i + " ");
            }
        }
    }

    public static void average() {
        double arrayOfNumbers[] = new double[10];
        double sumOfNumbers = 0;
        for (int i = 0; i < 10; i++) {
            arrayOfNumbers[i] = (int) (Math.random() * 11) + 10;
            System.out.println(arrayOfNumbers[i]);
            sumOfNumbers = sumOfNumbers + arrayOfNumbers[i];
        }
        double averageValue = sumOfNumbers / arrayOfNumbers.length;
        System.out.println(averageValue);
    }

    public static String createString() {
        String result = "";
        for (int i = 1; i <= 30; i++) {
            result += "(" + i + ")";
        }
        return result;
    }

    public static String removeSpacesFromString(String blanksToBeRemoved) {
        blanksToBeRemoved = blanksToBeRemoved.trim().replaceAll("\\s{2,}", " ");
        return blanksToBeRemoved;
    }

    public static boolean findTheWord(char[][] arrayToFindTheWord, String word) {
        int inWordCounter = 0;

        for (int i = 0; i < arrayToFindTheWord.length; i++) {
            if (inWordCounter == word.length()) {
                break;
            }
            for (int j = 0; j < arrayToFindTheWord[i].length; j++) {
                if (inWordCounter == word.length()) {
                    break;
                }
                if (arrayToFindTheWord[i][j] == word.charAt(inWordCounter)) {
                    inWordCounter++;
                } else {
                    inWordCounter = 0;
                }
            }
        }

        if (inWordCounter == 0) {
            return false;
        } else {
            return true;
        }
    }

}


