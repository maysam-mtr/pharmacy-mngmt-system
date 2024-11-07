
/**
 * Object Oriented Programming Project
 * Current File: OverTheCounter.java
 * Purpose: To create OverTheCounter object using superclass Medicine
 * Methods: All methods from Medicine class are inherited
 *          Additional methods:
 *          setter of minimum age
 *          getter of minimum age
 *          override method toString: returns a predefined message
 *          constructors: creates an object of the OverTheCounter class
 */

package project1;

/**
 *
 * The class OverTheCounter is an extension of the Medicine class that adds more
 * details about the Medicine object
 * 
 * 
 * 
 */

public class OverTheCounter extends Medicine {
    
    private int minAge = 18;   //Minimum age for the medicine

    /**
     * argumentative constructor OverTheCounterthat creates an instance of the
     * Medicine class by calling setName, setComposition, and setDose methods
     * from its parent class 
     * 
     * @param name
     * @param composition
     * @param dose
     * @param minAge 
     */
    public OverTheCounter(String name, String composition, int dose, int minAge)
    {
        super(name, composition, dose);
        this.minAge = minAge;
    }

    /**
     * argumentative constructor Prescription that creates an instance of the
     * Medicine class by calling setName, setComposition, setDose, setPrice,
     * and setQuantity methods from its parent class
     * 
     * @param name
     * @param composition
     * @param dose
     * @param price
     * @param quantity
     * @param minAge 
     */
    public OverTheCounter(String name, String composition, int dose, 
                          double price, int quantity, int minAge) {
        super(name, composition, dose, price, quantity);
        this.minAge = minAge;
    }

    
    /**
     * ...non-argumentative method getMinAge
     * @return minimum age 
     */
    public int getMinAge() {
        return minAge;
    }

    /**
     * ...method setMinAge sets the minimum age to the taken value
     * @param minAge 
     */
    public void setMinAge(int minAge) {
        if (minAge >= 0)
           this.minAge = minAge;
    }
    
    @Override
    /**
     * ...non-argumentative method toSttring
     * @return a predefined message
     */
    public String toString() {
      String s = "Over the Counter: \n" 
                 + super.toString() 
                 + "\n\tminimum age: " + minAge;
      
      return s;
    }
}
