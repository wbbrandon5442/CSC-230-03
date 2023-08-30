package question.pkg4;
import java.util.Random;
import java.util.Scanner;
/*
Name: William Brandon
Class: CSC 230-03
Date: 8-21-2023
*/
/*
This program prompts the user to enter number of rows (m) and column (n) of a 
2-D array where m, n ≥ 4. The array is filled with random lower case
letters (from ’a’ to ’z’).
Now, extend your program by writing a method to test whether this 2-D array has four
consecutive letters (’d’, ’e’, ’f’,’g’/ ’z’, ’a’, ’b’, ’c’/ ’x’, ’y’, ’z’, ’a’ are a few examples) either
horizontally-left to right, vertically-top to bottom or diagonally-down(two directions).
 */
/**
 * Class for Question 4
 * @author William Brandon
 */
public class Question4 {
    public static Scanner keyboard = new Scanner(System.in); 
    
    public static void main(String[] args) {
        int numOfRows = getRows();
        int numOfColumns = getColumns(); 
        char[][] newArray = generateArrayOfCharacters(numOfRows, numOfColumns);
        
        if (hasMultipleLetters(newArray)) {
            System.out.println("This array contains four consecutive letters.");
        } 
        else {
            System.out.println("This array does not contain four consecutive letters.");
        }
        
    }
    
    public static int getRows() {
        System.out.println("Enter in the number of rows: ");
        int numOfRows = keyboard.nextInt();
        return numOfRows;
    }
    
    public static int getColumns() {
        int numOfColumns;
        System.out.println("Enter in the number of columns: ");
        numOfColumns = keyboard.nextInt();
        return numOfColumns;
    }
    
    public static char[][] generateArrayOfCharacters(int numOfRows, int numOfColumns) {
        String abc = "abcdefghijklmnopqrstuvwxyz"; // generates string for alphabet
        Random r = new Random();
        int SIZE = abc.length();
        
        while (numOfRows < 4 || numOfColumns < 4) {
            System.out.println("Error row and column size too small. Input again.");
            System.out.println("Enter in the number of rows: ");
            numOfRows = keyboard.nextInt();
            System.out.println("Enter in the number of columns: ");
            numOfColumns = keyboard.nextInt();
        }   
        char[][] newArray = new char[numOfRows][numOfColumns];
        System.out.println("Number of rows " + newArray.length);
        System.out.println("Number of columns " + newArray[0].length);
        
        for (int i = 0; i < newArray.length; i++) {
            for (int j = 0; j < newArray[0].length; j++) {
                newArray[i][j] = abc.charAt(r.nextInt(SIZE));
            } 
        }
        for (int i = 0; i < newArray.length; i++) {
            for (int j = 0; j < newArray[0].length; j++) {
                System.out.print(newArray[i][j] + " ");
            } 
            System.out.println();
        }
        return newArray;
    }
    
    /* This method returns a boolean value based on detecting a sequence of
    letters in chronological order. */
        public static boolean hasMultipleLetters(char[][] newArray) {
        for (int i = 0; i < newArray.length; i++) {
            for (int j = 0; j < newArray[0].length; j++) {
                if (checkHorizontal(newArray, i, j) || checkHorizontal(newArray, i, j) || checkDiagonal(newArray, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
    /* This method checks for a horizontal sequence of letters alphabetically */
    public static boolean checkHorizontal(char[][] newArray, int row, int col) {
        for (int i = 0; i < newArray.length; i++) {
            int sequence = 0; 
            for (int j = 0; j < newArray[i].length -4; j++) {
                for (int k = 1; k <= 4; k++) {
                if (newArray[i][j] == (newArray[i][j + k] + 1)) {
                    sequence++;
                    if (sequence == 4) return true;
                } else {
                    sequence = 0;
                }
              }
            }
        }
        return false;
    }
    
    /* This method checks for a vertical sequence of letters alphabetically */
    
    public static boolean checkVertical(char[][] newArray, int row, int col) {
        for (int j = 0; j < newArray[0].length; j++) {
            int sequence = 0; 
            for (int i = 0; i < newArray.length - 4; i++) {
               for (int k = 1; k <= 4; k++) {
                if (newArray[i][j] == (newArray[i + k][j] + 1)) {
                    sequence++;
                    if (sequence == 4) return true;
                } else {
                    sequence = 0;
                }
              }
            }
        }
        return false;
    }

    /* This method checks for a diagonal sequence of letters alphabetically starting from the right side */
    
     public static boolean checkDiagonalRight(char[][] newArray, int row, int col){
            for (int i = 3; i < newArray.length - 4; i++) {
            int sequence = 0; 
                for (int j = 0; j < newArray[0].length - 4; j++) {
               for (int k = 1; k <= 4; k++) {
                if (newArray[i][j] == (newArray[i + k][j + k] + 1)) {
                    sequence++;
                    if (sequence == 4) return true;
                } else {
                    sequence = 0;
                }
              }
            }
        }
        return false;  
    }

    /* This method checks for a diagonal sequence of letters alphabetically starting from the left side */
     public static boolean checkDiagonalLeft(char[][] newArray, int row, int col){
            for (int i = newArray.length - 4; i > 3; i--) {
            int sequence = 0; 
                for (int j = newArray[0].length - 4; j > 0; j--) {
               for (int k = 1; k <= 4; k++) {
                if (newArray[i][j] == (newArray[i + k][j + k] + 1)) {
                    sequence++;
                    if (sequence == 4) return true;
                } else {
                    sequence = 0;
                }
              }
            }
        }
        return false;  
    }
    
    
    
}
