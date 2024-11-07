

/**
 * Object Oriented Programming Project
 * Current File: Medicine.java
 * Purpose: To Create Medicine objects
 * Methods: setters: set data fields values
 *          getters: return values
 *          equals: compares the object to the taken object
 *          toString: returns a predefined message
 *          constructors: creates an object of the Medicine class
 */

package project1;

/**
 * The Medicine class contains data fields, methods, and constructors that
 * allows the creation of Medicine objects
 * 
 */

public class Medicine {
    
    private String name;         // name of medication
    private String composition;  // compositions of medicine
    private int dose = 1000;     // dose of medication
    private double price = 10;   // price of medication
    private int quantity = 0;    // quantity of medicine
    
   
    /**
     * ...argumentative constructor that calls another constructor to set values
     * 
     * @param name
     * @param composition
     * @param dose
     */
    public Medicine(String name, String composition, int dose) {
        this(name, composition, dose, 10, 0);
    }

    /**
     * argumentative constructor that calls the setters to assign specific 
     * values to the data fields taken as parameters
     * 
     * @param name
     * @param composition
     * @param dose
     * @param price
     * @param quantity
     */
    public Medicine(String name, String composition, int dose, 
                    double price, int quantity) {
        name.toLowerCase();
        composition.toLowerCase();
        
        setName(name);
        setComposition(composition);
        setDose(dose);
        setPrice(price);
        setQuantity(quantity);
    }

    /**
     * ...non-argumentative method getName
     * @return a String representing name
     */
    public String getName() {
        return name;
    }

    /**
     * ...non-argumentative method getComposition
     * @return a String representing composition
     */
    public String getComposition() {
        return composition;
    }

    /**
     * ...non-argumentative method getDose
     * @return an int value representing dose
     */
    public int getDose() {
        return dose;
    }

    /**
     * ...non-argumentative method getPrice
     * @return a double value representing price
     */
    public double getPrice() {
        return price;
    }

    /**
     * ...non-argumentative method getQuantity
     * @return an int value representing quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * ...sets the medicine name to taken String(name)
     * @param name 
     */
    public void setName(String name) {
        name.toLowerCase();
        this.name = name;
    }

    /**
     * ...sets the composition to taken String (composition)
     * @param composition 
     */
    public void setComposition(String composition) {
        composition.toLowerCase();
        this.composition = composition;
    }

    /**
     * ...sets the dose to taken int value
     * @param dose 
     */
    public void setDose(int dose) {
        if (dose > 0)
           this.dose = dose;
    }

    /**
     * ...sets the price to taken double value 
     * @param price 
     */
    public void setPrice(double price) {
        if (price > 0)
           this.price = price;
    }

    /**
     * ...sets the quantity to take int value
     * @param quantity 
     */
    public void setQuantity(int quantity) {
        if (quantity > 0)
           this.quantity = quantity;
    }
    
    /**
     * ... method equals compares two medicine objects
     * @param medicine
     * @return true or false based on the result
     */
    public boolean equals(Medicine medicine) {  
        if (this.name.equals(medicine.name) 
                && this.composition.equals(medicine.composition) 
                && this.dose == medicine.dose && this.price == medicine.price 
                && this.quantity == medicine.quantity){
            return true;
        }
        else
            return false;
    }
    
    @Override
    /**
     * ...non-argumentative method toSttring
     * @return a predefined message
     */
    public String toString() {
        String s = "\tname: " + name 
                   + "\n\tcomposition: " + composition 
                   + "\n\tdose: " + dose + "mg" 
                   + "\n\tprice: " + price 
                   + "\n\tquantity: " + quantity;
        
       return s;
    }
}
