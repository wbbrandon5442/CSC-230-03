package question_.pkg01;

/**
 *
 * @author William Brandon
 * This class defines the attributes of a cat
 */
public class Cat {
    private String name;
    private String dob;
    private Color color; 
    private boolean status;
    private int distanceFromHome; 
    
    //setters
    public void setName(String name) {
        this.name = name; // 'this' eliminates the confusion between class attributes and parameters with the same name
    }

    public void setDob(String dob) {
        this.dob = dob; //Date of Birth
    }

    public void setColor(Color color) {
        this.color = color; //enum of color
    }

    public void setStatus(boolean status) {
        this.status = status; //status is either true for awake or false for sleeping
    }

    public void setDistanceFromHome(int distanceFromHome) {
        this.distanceFromHome = distanceFromHome; //an integer distance from home
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }
    
    /**
     * @return dob
     */
    public String getDob() {
        return dob;
    }
    /**
     * @return color
     */
    public Color getColor() {
        return color;
    }
    /**
     * prints Awake when status is true
     * and Sleeping when status is false.
     */
    public void isStatus() {
        if (status == true) {
            System.out.println("Awake");
        }
        else if (status == false) {
            System.out.println("Sleeping");
        }
    }
    /**
     * @return distanceFromHome
     */
    public int getDistanceFromHome() {
        return distanceFromHome;
    }
    
    
}
