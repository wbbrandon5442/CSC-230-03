package question_01;
import java.util.Scanner;
import java.util.Random;
/*
Name: William Brandon
Class: CSC 230-03
Date: 9-8-2023
*/

/*
Goal: Convert the pseudo code of the insertion sort given on page 7 of
“Asymptotic Analysis” lecture notes in to Java code. Show that your method works using
few test cases. You can create a test method and put all your test cases in there, and call
it in the main method.
Note: The goal of this question is to learn how to convert your pseudo code version of the
algorithm in to Java code.
*/
/**
 * Class for Question #1
 * @author William Brandon
 */
public class Question_01 {
    public static Scanner keyboard = new Scanner(System.in);
    public static Random rand = new Random();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numOfElements = getNumOfElements();
        int[] newArray = generateArray(numOfElements);
        
        System.out.println("Before insertion sort: ");
        displayArray(newArray);
        
        System.out.println(); 
        
        int [] sortedArray = insertionSort(newArray); //sorting array using insertion sort  
        System.out.println("After insertion sort");
        displayArray(sortedArray); 
        
        keyboard.close();
    }
    
    /**
     * Method returns the input for the number of elements in an array
     * Throws illegal argument if a negative integer is entered
     * @return numOfElements
     */
    public static int getNumOfElements() {
        System.out.println("Enter the number of elements in the array: ");  
        int numOfElements = keyboard.nextInt();
        if (numOfElements <= 0) {
            throw new IllegalArgumentException("Error: number must be greater than 0");
        }  
        System.out.println(); 
        return numOfElements; 
    }
    
    /**
     * @param numOfElements
     * Method generates an array of random numbers
     * @return newArray
     */
    public static int[] generateArray(int numOfElements) {
         int[] newArray = new int[numOfElements];
         for (int i = 0; i < numOfElements; i++) {
                int randomNumber = rand.nextInt(1000); 
                newArray[i] = randomNumber; 
            } 
        return newArray;
        }
    
    /**
     * Method displays an Array using an enhanced for loop
     * @param newArray
     */
    public static void displayArray(int[] newArray) {
        for(int i: newArray){  
            System.out.print(i+" ");  
        }  
        System.out.println();
    }
    
    /**
     * Method uses insertion sort to sort an Array
     * @param newArray
     * @return newArray 
     */
    public static int[] insertionSort(int[] newArray){  
        for (int j = 1; j < newArray.length; ++j)  {  
            int key = newArray[j]; // Insert arr[j] into the sorted sequence arr[1... j - 1]
            int i = j - 1; // 'i' will serve as the element right before j
            while (i >= 0 && newArray[i] > key) {
                newArray[i + 1] = newArray[i];
                i -= 1; // decrements 'i' by 1
            }
            newArray[i + 1] = key;
            }
        return newArray; 
        } 
    
}
