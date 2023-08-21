package question01;
import java.util.Scanner;
/*
Name: William Brandon
Class: CSC 230-03
Date: 8-21-2023
*/

/*Goal: Write a method to print all pairs of positive integers, (i, j), such that
0 < i < j < n and (i3 + 2ij + 1)/(ij + 3) is an integer. Here n is an integer and n > 2.
Note: Your method should take n as a parameter and print all valid pairs as (i, j). Show
the pairs corresponding to n = 100 as a test case. */

public class Question01 {

    /**
     * Question-1
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner k = new Scanner(System.in); 
        int n;
        System.out.println("Enter in a parameter for n: ");
        n = k.nextInt();
        allPairsOfIntegers(n); 
        
        
        
    }
    /* This method calculates the whole number pairs
       for the algebra equation (i3 + 2ij + 1)/(ij + 3)
       such that 0 < i < j < n 
       uses n as a parameter in a for loop
       prints the statement */
    
    public static void allPairsOfIntegers(int n) {
        int i;
        int j;
        double intSolution;
        for (i = 1; i <= n; ++i){
            for (j = 1; j <= n; ++j) {
                intSolution = ((Math.pow(i, 3) + 2*i*j + 1) / (i*j+3)); 
                    if (intSolution == (int)intSolution && (j > i)) {
                        System.out.println("(" + i + "," + j + ")"); 
                    }
                }
        }
        
    }
    
}
