

/**
 * Object Oriented Programming Project
 * Current File: Prescription.java
 * Purpose: To create Prescription object using superclass Medicine
 * Methods: All methods from Medicine class are inherited
 *          Additional methods:
 *          setter of doctor specialization
 *          getter of doctor specialization
 *          override method toString: returns a predefined message
 *          constructors: creates an object of the Prescription class
 */

package project1;

/**
 *
 * The class Prescription is an extension of the Medicine class that adds more
 * details about the Medicine object
 * 
 */

public class Prescription extends Medicine {
    
    /* The specialization of the doctor that gave the prescription */
    private String doctorSpecialization;   

    /**
     * argumentative constructor Prescription that creates an instance of the
     * Medicine class by calling setName, setComposition, and setDose methods
     * from its parent class
     * 
     * @param name
     * @param composition
     * @param dose
     * @param doctorSpecialization
     */
    public Prescription(String name, String composition, int dose, 
                        String doctorSpecialization) {
        
        super(name, composition, dose);
        doctorSpecialization.toLowerCase();
        setDoctorSpecialization(doctorSpecialization);
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
     * @param doctorSpecialization
     */
    public Prescription(String name, String composition, int dose, double price,
                        int quantity, String doctorSpecialization) {
        
        super(name, composition, dose, price, quantity);
        doctorSpecialization.toLowerCase();
        setDoctorSpecialization(doctorSpecialization);
    }

    /**
     * ...non-argumentative method getDoctorSpecialization 
     * @return a String representing the doctor specialization
     */
    public String getDoctorSpecialization() {
        return doctorSpecialization;
    }

    /**
     * ...method setDoctorSpecialization sets the doctorSpecialization to the 
     * taken String
     * @param doctorSpecialization representing doctors specialization
     */
    public void setDoctorSpecialization(String doctorSpecialization) {
        doctorSpecialization.toLowerCase();
        this.doctorSpecialization = doctorSpecialization;
    }
    
    @Override
    /**
     * ...non-argumentative method toSttring
     * @return a predefined message
     */
    public String toString() {
        String s = "Prescription:\n" 
                   + super.toString() 
                   + "\n\tdoctor specialization: " + doctorSpecialization;
        
        return s;
    }
}
