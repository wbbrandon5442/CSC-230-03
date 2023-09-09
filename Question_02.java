package question_02;
import java.util.Scanner;
import java.util.Random; 
/*
Name: William Brandon
Class: CSC 230-03
Date: 9-8-2023
*/

/*
Goal: As we know Java arrays are not dynamically expandable at run time.
Write a Java program to read unlimited number of integers from console (each is separated
by the carriage return-i.e. your “enter key”), store them in an array of integers and print
them. Program should terminate after you input a zero. You may need to have the
following methods in your program.
*/
/**
 * Class for Question #2
 * @author William Brandon
 */
public class Question_02 {
    public static Scanner keyboard = new Scanner(System.in);
    public static Random rand = new Random();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int newArray [] = getInts(); 
        for(int i: newArray){  
            System.out.print(i+" ");  
        }  
        System.out.println();
        System.out.println("Final array size is: " + newArray.length);
    }
    
    /**
     * adds elements to an array and reads
     * an unlimited number of integers for an array
     * @return finalArray
     */
    public static int[] getInts() {
        int[] myArray = new int[2];
        int newSize = myArray.length; 
        String userInput = " ";
        int i = 1; //Setting i = 1 instead of 0 so it can keep pace with the Array.length
        int numberInput = 1;
        System.out.println("Press 'enter' to add an element [enter 0 to terminate program]: "); 
        userInput = keyboard.nextLine(); 
        
        while (numberInput != 0) {
        
        int randomNumber = rand.nextInt(1000); 
        myArray[i - 1] = randomNumber; //Because i starts with the value 1 I need to subtract by 1 for the first index of 0 
            if (i == myArray.length) {
                myArray = resize(myArray, newSize); 
                newSize = myArray.length; 
            }
        System.out.println("Press 'enter' to add an element [enter 0 to terminate program]: ");
        userInput = keyboard.nextLine(); 
        if (userInput.matches("0")) {
            numberInput = 0; // if userInput equals the string of "0" it converts that into the Integer 0 activating the sentinal value for exiting the loop
            ++i;
            break;
        }
        while (userInput != "") {
            System.out.println("Error must press 'enter' to add element."); // User is stuck in a loop until they comply with the message
            userInput = keyboard.nextLine();
        }
        ++i;
        }
        
        int finalArraySize = i -1; //
        int[] finalArray = new int[finalArraySize]; //The final Array Size is the last increment of i - 1
            for (int j = 0; j < finalArraySize; j++) {
                finalArray[j] = myArray[j];
            }
        
        return finalArray;  
    }
    
    /**
     * @param newArray
     * @param newSize
     * resizes the array before the inputs are able to go out of bounds
     * @return newArray
     */
    private static int[] resize(int[] newArray, int newSize) {
         int [] resizedArray = new int[newSize * 2];
         for (int i = 0; i < newArray.length; ++i) {
             resizedArray[i] = newArray[i];
         } 
         newArray = resizedArray; 
         System.out.println("New array size equals " + newArray.length); 
         System.out.println();
         return newArray; 
        }
    }
    

