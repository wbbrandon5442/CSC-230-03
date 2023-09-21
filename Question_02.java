package question_.pkg02;

/*
*Name: William Brandon
*Class: CSC 230-03
*Date: 9-17-2023
*Assignment #3
*/

/*
*Goal: Write a method to return the “second maximum” of an integer array.
*You should start with pseudo code.
*/
/**
 * Class for Question #2
 * @author William Brandon
 */

public class Question_02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         int [] a1 = {1}; //test case for array with 1 element
        int [] a2 = {1, 1}; //test case for array with 2 of the same elements
        int [] a3 = {1, 1, 1, 1, 1, 1, 1}; // test case for array where every element is the same
        int [] a4 = {2, 1};
        int [] a5 = {3, 2, 1}; //test case for descending order
        int [] a6 = {1, 2, 3}; //test case for ascending order
        int [] a7 = {1, 2, 3, 4, 1, 10};
        int [] a8 = {14, 12, 8, 3, 2, 9, 6, 17}; //test case where first index is second max and last index is the max
        int [] a9 = {24, 13, 19, 7, 2, 6, 16, 3}; //test case where first index is the max
        int [] a10 = {10, 11, 11, 11, 11, 11, 11, 11}; //test case where first index is second max and the following elements are the max
        int [] a11 = {31, 13, 17, 24, 18, 13, 29}; //test case where first index is max and last index is second max
        //int secondMax;
        
            try {
                System.out.println(secondMax(a1));
           } catch (Exception e) {
               System.out.println(e.toString()); //testing first array for array size less than 2
           }
       
           try {
               System.out.println(secondMax(a2));
           } catch (Exception e) {
                System.out.println(e.toString()); //testing second array for same elements
           }
           
           try {
               System.out.println(secondMax(a3)); //testing third array for same elements
           } catch (Exception e) {
                System.out.println(e.toString());
           }
           
        System.out.println("Second Max Element of Array a4: " + secondMax(a4));
        
        System.out.println("Second Max Element of Array a5: " + secondMax(a5));
        
        System.out.println("Second Max Element of Array a6: " + secondMax(a6));
        
        System.out.println("Second Max Element of Array a7: " + secondMax(a7));
        
        System.out.println("Second Max Element of Array a8: " + secondMax(a8));
        
        System.out.println("Second Max Element of Array a9: " + secondMax(a9));
        
        System.out.println("Second Max Element of Array a10: " + secondMax(a10));
        
        System.out.println("Second Max Element of Array a11: " + secondMax(a11));
    }
    
    public static int secondMax(int[] newArray) {
        int maxElement = newArray[0]; //Initializing maxElement to first index
        int secondMax = newArray[newArray.length - 1]; //Initializing secondMax to the last index
        int sameNumber = 1; //same number counts the number of matches in the array and must equal the array length for argument to be thrown
        if (newArray.length < 2) {
            throw new IllegalArgumentException("No second max for arrays of size less than 2!!!"); //Throws argument when array is less than 2
        }
        for (int i = 0; i < newArray.length; ++i) {
            if (newArray[i] > maxElement) {
                secondMax = maxElement; //sets secondMax to previous max
                maxElement = newArray[i]; //sets maxElement to new max
            }
            else if (newArray[i] > secondMax && newArray[i] != maxElement) {
                secondMax = newArray[i]; //element must not equal maxElement and be greater than previous second max for statement to initialize
            }
           
            if ((i + 1) < newArray.length) {
            if (newArray[i + 1] == newArray[i]) {
                sameNumber++; //counts the number of elements that are the same
                if (sameNumber == newArray.length) {
                    throw new IllegalArgumentException(" The array has the same elements. No second maximum!!!!!"); //throws argument if all elements are the same
                }
            }
            }
        }
        
        return secondMax;
    }
}
