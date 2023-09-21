package question_.pkg01;
import static question_.pkg01.Color.*;

/*
*Name: William Brandon
*Class: CSC 230-03
*Date: 9-17-2023
*Assignment #3
*/

/*
Goal: Create a public class to abstract a cat according to the following UML
diagram. Note the followings. Note that there are a lot of assumptions in this model (we
can even change the color of the cat!)
*/
/**
 * Class for Question #1
 * @author William Brandon
 */
public class Question_01 {

    
    public static void main(String[] args) {
        Cat Tom = new Cat(); //Creates the object Tom
        //Uses the class attributes for the object Tom
        Tom.setName("Tom"); //Name attribute for Object Tome
        Tom.setDob("11-26-2018"); //Date of Birth attribute for Object Tom
        Tom.setColor(ORANGE); //Color attribute for Object Tom
        Tom.setStatus(false); //Status attribute for Object Tom
        Tom.setDistanceFromHome(11); //Distance From Home attribute for Object Tom
        
        //Printing the attributes of the object Tom
        System.out.println(Tom.getName());
        System.out.println(Tom.getDob());
        System.out.println(Tom.getColor());
        Tom.isStatus(); //Can't print void methods
        System.out.println(Tom.getDistanceFromHome());
       
    }
    
}
