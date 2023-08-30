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
        int m = getRows();
        int n = getColumns(); 
        char[][] newArray = generateArrayOfCharacters(m, n);
        
        if (hasConsecutiveLetters(newArray)) {
            System.out.println("This array contains four letters in alphabetic sequence.");
        } 
        else {
            System.out.println("This array does not contain four consecutive letters.");
        }
        
    }
    
    /**
     * method gets the input for m (numofRows) and throws an illegal argument
     * if the number of rows is less than 4
     * @return numOfRows
     */
    public static int getRows() {
        System.out.println("Enter in the number of rows: ");
        int numOfRows = keyboard.nextInt();
        if (numOfRows < 4) {
            throw new IllegalArgumentException("Error number of rows must be 4 or more");
        }   
        return numOfRows;
    }
    
    /**
     * method gets the input for n (numofColumns) and throws an illegal argument
     * if the number of columns is less than 4
     * @return numOfColumns
     */
    public static int getColumns() {
        int numOfColumns;
        System.out.println("Enter in the number of columns: ");
        numOfColumns = keyboard.nextInt();
        if (numOfColumns < 4) {
            throw new IllegalArgumentException("Error number of columns must be 4 or more");
        }   
        return numOfColumns;
    }
    
    /**
     * @param numOfRows
     * @param numOfColumns 
     * Method calculates and prints the area under the arc of a circle in a 
     * quadrant using the radius and summing up the area of rectangles. 
     * @return newArray
     */
    public static char[][] generateArrayOfCharacters(int numOfRows, int numOfColumns) {
        String abc = "abcdefghijklmnopqrstuvwxyz"; // generates string for alphabet
        Random r = new Random();
        int SIZE = abc.length();
        
        if (numOfRows < 4 || numOfColumns < 4) {
            throw new IllegalArgumentException("Error m and n must be greater than 4");
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
    
    /**
     * @param newArray
     * Method tests for a sequence of letters such as
     * 'a,b,c,d' or 'h,i,j, k' 
     * @return true or false
     */
        public static boolean hasConsecutiveLetters(char[][] newArray) {
                int rows = newArray.length - 1; 
                int columns = newArray[0].length - 1; 
                if (checkHorizontal(newArray, rows, columns) || checkHorizontal(newArray, rows, columns) 
                        || checkTopLeft(newArray, rows, columns) || checkBottomRight(newArray, rows, columns) 
                        || checkTopRight(newArray, rows, columns) || checkTopRight(newArray, rows, columns)) {
                    return true;
                }
        return false;
    }
   /**
     * @param newArray
     * @param rows
     * @param columns
     * Method tests for a sequence of letters in the
     * horizontal direction
     * @return true or false
     */
    public static boolean checkHorizontal(char[][] newArray, int rows, int columns) {
        for (int i = 0; i < rows; i++) {
            int sequence = 0; 
            for (int j = 0; j < columns -4; j++) {
                for (int k = 1; k <= 4; k++) {
                if (newArray[i][j] == ((newArray[i][j + k] + k)) % 26) {
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
    
     /**
     * @param newArray
     * @param row
     * @param col
     * Method tests for a sequence of letters in the
     * vertical direction
     * @return true or false
     */
    
    public static boolean checkVertical(char[][] newArray, int row, int col) {
        for (int j = 0; j < col; j++) {
            int sequence = 0; 
            for (int i = 0; i < row - 4; i++) {
               for (int k = 1; k <= 4; k++) {
                if (newArray[i][j] == ((newArray[i + k][j] + k)) % 26) {
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

     /**
     * @param newArray
     * @param row
     * @param col
     * Method tests for a sequence of letters in the
     * diagonal direction
     * @return true or false
     */
    
     public static boolean checkTopLeft(char[][] newArray, int row, int col){
            for (int i = 0; i < row - 3; i++) {
            int sequence = 0; 
                for (int j = 0; j < col - 3; j++) {
               for (int k = 1; k <= 4; k++) {
                if (newArray[i][j] == ((newArray[i + k][j + k] + 1)) % 26) {
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
       /**
     * @param newArray
     * @param row
     * @param col
     * Method tests for a sequence of letters in the
     * diagonal direction
     * @return true or false
     */
     public static boolean checkBottomRight(char[][] newArray, int row, int col){
            for (int i = row; i > 4; i--) {
            int sequence = 0; 
                for (int j = col; j > 4; j--) {
               for (int k = 1; k <= 4; k++) {
                if (newArray[i][j] == ((newArray[i - k][j - k] - 1)) % 26) {
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
     
      /**
     * @param newArray
     * @param row
     * @param col
     * Method tests for a sequence of letters in the
     * diagonal direction
     * @return true or false
     */
     public static boolean checkTopRight(char[][] newArray, int row, int col){
           for (int j = col; j > 4; j--) {
           int sequence = 0; 
              for (int i = 0; i > row - 4; i++) {
              for (int k = 1; k <= 4; k++) {
                if (newArray[i][j] == ((newArray[i + k][j - k] + 1) % 26)) {
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
    
       /**
     * @param newArray
     * @param row
     * @param col
     * Method tests for a sequence of letters in the
     * diagonal direction
     * @return true or false
     */
    public static boolean checkBottomLeft(char[][] newArray, int row, int col){
            for (int i = row; i > 4; i--) {
            int sequence = 0; 
               for (int j = 0; j < col - 4; j++) {
               for (int k = 1; k <= 4; k++) {
                if (newArray[i][j] == ((newArray[i - k][j + k] + 1) % 26)) {
                    sequence++;
                    if (sequence == 4)  return true; 
                } else {
                    sequence = 0;
                }
              }
            }
        }
        return false;  
    }
     
    
    
    
}
