package question_03;
import java.util.Scanner;


/*
Name: William Brandon
Class: CSC 230-03
Date: 9-9-2023
*/

/*
* Goal: Create a boolean array with all elements intialized to true. Once the algorithm
* is done, all array elements with prime indices will remain true while other array elements
* will eventually be set to false. Obviously elements of indices 0 and 1 in this exercise should
* be set to false manually as they are not primers. 
*/
/**
 * Class for Question #2
 * @author William Brandon
 */
public class Question_03 {
    public static Scanner keyboard = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean newArray [] = generateBooleanArray(); 
        boolean primeNumberArray [] = primeNumberArray(newArray);
        // Manually setting indexes 0 and 1 to false as they are not prime numbers
        primeNumberArray[0] = false; 
        primeNumberArray[1] = false;
        for (int i = 0; i < newArray.length; i++) {
            if (primeNumberArray[i] == true) {
                System.out.println(i + " is a prime number ");
            }
        }
    }
    
    /**
     * This array generates a boolean array where every index is set to false
     * @return myArray
     */
    public static boolean[] generateBooleanArray() {
        System.out.println("Enter in the size of the array: ");
        int n = keyboard.nextInt(); //Input for size of the array
        int sizeOfArray = n; // Can comment the above two statements out and set the size manually if you want
        boolean[] myArray = new boolean[sizeOfArray];
        for (int i = 0; i < sizeOfArray; i++) { 
            myArray[i] = true; //Setting every index between 0 and the size of the array to true
        }
        return myArray; 
    }
    
    /**
     * @param newArray
     * This array sets the prime number indexes to false
     * @return newArray
     */
    public static boolean[] primeNumberArray(boolean [] newArray) {
        for (int i = 2; i < newArray.length; i++) {
            for (int j = 2; j < newArray.length; j++) {
                if (i *j >= newArray.length) {
                    //This condition is set to avoid indexes that would otherwise be out of bounds
                }
                else {
                newArray[i * j] = false; // Sets non-prime number to false
                //System.out.println("Array " + i * j + " is not a prime number.");
                }
            }
    }
        return newArray;
    }
}
