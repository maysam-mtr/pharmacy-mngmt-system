

/** 
 * Object Oriented Programming Project
 * Current File: Pharmacy.java
 * Purpose: To Create Pharmacy objects
 * Methods: addMedicine: adds a new medicine to the Pharmacy
 *          raisePrices: increases or decreases the prices of all medicines
 *          searchByName: searches for medicines by name
 *          searchByNameAndDose: searches for medicine by name and dose
 *          searchByComposition: searches for medicines by composition
 *          sellMedicine: sells a medicine by reducing its quantity        
 *          restock: restocks a medicine by increasing its quantity
 *          Getters: returns values of data fields except that of name
 *          Setters: sets the value of variables name and maxNumberOfMedicines
 *          toString: returns a predefined message
 *          constructors: creates an object of Pharmacy class
 */

package project1;

/**
 *
 * The class Pharmacy contains data fields, methods, and constructors that 
 * allow the creation of Pharmacy objects
 * 
 * 
 */

public class Pharmacy {
    
    private String name;    // name of the pharmacy
    /* array of medicines of type Medicine */
    private Medicine[] medicines = new Medicine[MaxNumberOfMedicines];
    /* quantity of over the counter medications */
    private int overTheCounterQuantity = 0;
    /* quantity of prescription medications */
    private int prescriptionQuantity = 0;
    /* total number of medications */
    private int numberOfMedicines = 0;   
    /* maximum number of medications & size of medicines arra */
    private static int MaxNumberOfMedicines = 100;  
    
    /**
     * ...argumentative constructor that calls setName method to assign 
     * specific name to Pharmacy object
     * @param name 
     */
    public Pharmacy(String name) {
        name.toLowerCase();
        setName(name);
    }
    
    /**
     * ...method addMedicine adds a taken medicine object to medicines array
     * @param newMedicine (new Medicine object to be added)
     */
    public void addMedicine(Medicine newMedicine) {
        boolean valid = true;
        
        /* check if the medicine already exists */
        for (int i = 0; i < numberOfMedicines; i++) {
            if (medicines[i].equals(newMedicine)) {
                System.out.println("The medicine entered already exists");
                valid = false;
                break;
            }
        }
        
        /* check if the array is full */
        if (valid) {
           if (numberOfMedicines == medicines.length) {
               System.out.println("Error! Maximum capacity reached, "
                                  + "Medicine could not be added");
               valid = false;
            }
        }
        
        /* add medicine if valid */
        if (valid) {
            medicines[numberOfMedicines] = newMedicine;
            numberOfMedicines++;
            
            if (newMedicine instanceof OverTheCounter) {
                overTheCounterQuantity++;
            }
            else if (newMedicine instanceof Prescription) {
                prescriptionQuantity++;
            }
            
            System.out.println("New medicine is added successfully");
        }
        
    }
    
    /**
     * ...method raisePrices raises or decreases prices of all medicines based 
     * on percentage taken
     * @param percentage (percentage of change in prices)
     */
    public void raisePrices(double percentage) {
        double newPrice;
        
        for (int i = 0; i < numberOfMedicines; i++){
            // if percentage is +ve, prices are increased, otherwise decreased
            newPrice = medicines[i].getPrice() * (1 + percentage/100);
            medicines[i].setPrice(newPrice);
        }
    } 
    
    /**
     * ...method searchName searches for medicines by name
     * @param name (name of medicine(s) to be found)
     * @return array of indices of medicines with name taken
     */
    public int[] searcByName(String name) {
        int[] temp = new int[numberOfMedicines];
        int j = 0; //size of the array that will be returned
        
        for (int i = 0; i < numberOfMedicines; i++) {
            if (medicines[i].getName().equals(name)) {
                temp[j] = i;
                j++;
            }
        }
        
        int[] indexes = new int[j];
        System.arraycopy(temp, 0, indexes, 0, j);
        
        return indexes;
    }
    
    
    /**
     * ...method searchByNameAndDose searches medicine by name and dose 
     * @param name (name of medicine to be found)
     * @param dose (dose of medicine to be found)
     * @return index of the medicine that matches the name and dose
     */
    public int searchByNameAndDose(String name, int dose) {
        for (int i = 0; i < numberOfMedicines; i++) {
            if (medicines[i].getName().equals(name) 
                    && medicines[i].getDose() == dose) {
                return i;
            }
        }
        
        return -1;
    }
    
    /**
     *...method searchByComposition searches medicines by a composition
     * @param composition (composition of the medicine to be found)
     * @return array of indices of medicines with composition taken
     */
    public int[] searchByComposition(String composition) {
        int[] temp = new int[numberOfMedicines];
        int j = 0;
        
        for (int i = 0; i < numberOfMedicines; i++) {
            if (medicines[i].getComposition().equals(composition)) {
                temp[j] = i;
                j++;
            }
        }
        
        int[] indexes = new int[j];
        System.arraycopy(temp, 0, indexes, 0, j);
        
        return indexes;
    }
    
    /**
     * ...method sellMedicine decreases a medicine's quantity by the taken value
     * @param name (name of the medicine)
     * @param dose (dose of the medicine)
     * @param quantity (quantity to be sold)
     */
    public void sellMedicine(String name, int dose, int quantity) {
        int index = searchByNameAndDose(name, dose);
        
        if (index == -1) { //if medicine not found
            System.out.println("Medicine not found");
        }
        // if medicine found and there is  enough quantity 
        else if (index != -1 && medicines[index].getQuantity() >= quantity) {
            int newQuantity = medicines[index].getQuantity() - quantity;
            medicines[index].setQuantity(newQuantity);
            System.out.println("Selling Successful!");
        }
        else {  
            System.out.println("Quantity of this medicine is insufficient");
        }
    }
    
    /**
     * ... method restock sets the medicine's quantity higher by the entered 
     * quantity
     * @param name (name of the medicine)
     * @param dose (dose of the medicine)
     * @param quantity (quantity to be restocked)
     * @return true if the restock was successful and false otherwise
     */
    public boolean restock(String name, int dose, int quantity) {
        int index = searchByNameAndDose(name, dose);
        if (index != -1) {
            int newQuantity = medicines[index].getQuantity() + quantity;
            medicines[index].setQuantity(newQuantity);
            return true;
        }
        else
            return false;
    }
    
    /**
     * ...non-argumentative method getMedicines
     * @return the array of medicines
     */
    public Medicine[] getMedicines() {
        return medicines;
    }

    /**
     * ...non-argumentative method getOverTheCounterQuantity
     * @return over the counter medicines quantity
     */
    public int getOverTheCounterQuantity() {
        return overTheCounterQuantity;
    }

    /**
     * ...non-argumentative method getPrescriptionQuantity
     * @return prescription medicines quantity
     */
    public int getPrescriptionQuantity() {
        return prescriptionQuantity;
    }

    /**
     * ...non-argumentative method getNumberOfMedicines
     * @return number of medicines in the pharmacy
     */
    public int getNumberOfMedicines() {
        return numberOfMedicines;
    }

    /**
     * ...non-argumentative method getMaxNumberOfMedicines
     * @return maximum number of medicines in the pharmacy
     */
    public static int getMaxNumberOfMedicines() {
        return MaxNumberOfMedicines;
    }

    /**
     * ... sets the pharmacy name to the taken String (name)
     * @param name 
     */
    public void setName(String name) {
        name.toLowerCase();
        this.name = name;
    }

    /**
     * ... sets the maximum number of medicines to the taken int value
     * @param MaxNumberOfMedicines 
     */
    public static void setMaxNumberOfMedicines(int MaxNumberOfMedicines) {
        if (MaxNumberOfMedicines > 0) {
           Pharmacy.MaxNumberOfMedicines = MaxNumberOfMedicines;
        }
    }
    
    @Override
    /**
     * ...non-argumentative method toSttring
     * @return a predefined message
     */
    public String toString(){
        String s = "Pharmacy: " + name
                   + "\nNumber of Medicines: " + numberOfMedicines
                   + "\nOver the counter quantity: " + overTheCounterQuantity 
                   + "\nPrescription Quantity: " + prescriptionQuantity;
        
        return s;
    }
}
