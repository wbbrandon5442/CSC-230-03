package question02;
import java.util.Scanner;
/*
Name: William Brandon
Class: CSC 230-03
Date: 8-21-2023
*/

/*
Goal: Write a method that takes a non negative integer and returns the sum
of digits. For example, if 42339 is passed as the parameter, the method should return 21.
Note: Use a paper and pencil to figure out the algorithm. Exploit integer division and
remainder operator. Do not convert the integer into a string and convert each character
to a number. That answer will not be accepted
*/
public class Question02 {

    public static void main(String[] args) {
        Scanner k = new Scanner(System.in); 
        int testNumber;
        System.out.println("Enter in a number less than a million: ");
        testNumber = k.nextInt();
        
        //Problem, repetitive code. I would have to create a method for each power of 10
        
        if (testNumber > 10000) {
            System.out.print("Each digit summed up equals ");
            System.out.println(fiveDigits(testNumber)); 
         }
    }
    
    public static int fiveDigits(int testNumber) {
        int digitFive = Math.floorDiv(testNumber, 10000);
            int digitFour = Math.floorDiv(testNumber, 1000) - (digitFive * 10);
            int digitThree = Math.floorDiv(testNumber, 100) - (digitFive * 100) - (digitFour * 10);
            int digitTwo = Math.floorDiv(testNumber, 10) - (digitFive * 1000) - (digitFour * 100) - (digitThree * 10);
            int digitOne = Math.floorDiv(testNumber, 1) - (digitFive * 10000) - (digitFour * 1000) - (digitThree * 100) - (digitTwo * 10);
            return digitFive + digitFour + digitThree + digitTwo + digitOne;  
    }
    
}
