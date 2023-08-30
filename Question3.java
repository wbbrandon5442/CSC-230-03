package question3;
import java.util.Scanner;
import java.lang.Math;
/*
Name: William Brandon
Class: CSC 230-03
Date: 8-21-2023
*/

/*
Goal: In Calculus before you learn how to solve for an Integral you will learn
how to approximate areas under a curve or line by breaking up the area into small
rectangles using delta x [(b - a) / n] and plugging in the incrementing values of
delta x from 'b' to 'a' into the curve's function. This program visualizes a circle in a 
quadrant and approximates the area under one of those quadrants using rectangles 
and the equation of a circle centered at origin (x^2 + y^2 = radius^2). After finding
the area of one quadrant, that area is multiplied by four to get the approximated area
of the circle. 
*/

/**
 * Class for Question 3
 * @author William Brandon
 */
public class Question3 {
    public static Scanner keyboard = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double radius = getRadius();
        int numOfRectangles = getRectangles(); 
        calcCircleQuadrant(radius, numOfRectangles);
        circleArea(radius);
    }
    
    /**
     * method gets the input for radius
     * @return radius
     */
    public static double getRadius() {
        System.out.println("Enter in the radius  ");
        double radius = keyboard.nextDouble(); 
        if (radius <= 0) {
            throw new IllegalArgumentException("Error radius must be greater than 0");
        }
        return radius;
    }
    
     /**
     * method gets the input for number of rectangles
     * @return rectangles
     */
    public static int getRectangles() {
        System.out.println("Enter in number of rectangles  ");
        int rectangles = keyboard.nextInt(); 
        if (rectangles <= 0) {
            throw new IllegalArgumentException("Error rectangles must be greater than 0");
        }
        return rectangles;
    }
    
    /* This method calculates the area in a Quadrant*/
    public static void calcCircleQuadrant(double radius, int numOfRectangles) {
        double delta = radius / (double)numOfRectangles; // delta for area approximations is (b - a) / n
        double area = 0;
        int i; 
        for (i = 0; i < numOfRectangles; ++i) {
            double base = i * delta; 
            double height = Math.sqrt(radius * radius - base * base); // y = sqrt(radius^2 - x^2)
            area += delta * height; //Sums up the area of all rectangles
        }
        System.out.println("Approximate area: " + area * 4 + " using "
        + numOfRectangles + " rectangles");
    }
    /* This method calculates area using the traditional formula of pi multiplied
    * by the square of the radius
    */
    public static void circleArea(double radius) {
        System.out.println("Area using formula of a circle (pi * r^2): " + Math.PI * Math.pow(radius,2));
    }
    
}
