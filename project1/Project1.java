

/** 
 * Object Oriented Programming Project
 * Current File: Project1.java
 * Purpose: To implement class Pharmacy, superclass Medicine, and subclasses 
 *          Prescription and OverTheCounter
 * Methods: menu(): displays a menu and inputs the user's choice
 *          Other methods created in Pharmacy and Medicine class were were used
 */

package project1;

import java.util.Scanner;

/** 
 * 
 * The class Project1 calls the class Pharmacy and class Medicine 
 * and its subclasses to obtain specific information
 * 
 * 
 */

public class Project1 {
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        /* myPharma stores required information about the pharmacy */
        Pharmacy myPharma = new Pharmacy("myPharma");
        
        System.out.println("Welcome to \" myPharma \" pharmacy system.");
        System.out.println("---------------------------------------"
                + "----------");
        
        while (true) { 
            /* Display and get choice from menu using menu() method */
            System.out.println("Choose one of the following options: ");
            int choice = menu();
             
            switch (choice){
                case 1: 
                    /* variables that will be used to enter information 
                       into the pharmacy */
                    int minAge, dose = 0, quantity = 0;
                    double price = 0;
                    char type;
                    String name, composition, doctorSpecialization;
                    
                    /* Choose the type of medicine */
                    System.out.print("Choose O or o for over the counter "
                                     + "medicine and p or P for prescription "
                                     + "medicine: ");
                    type = input.next().charAt(0);
                    
                    /* check if the input is invalid */
                    if (type != 'p' && type != 'P' && type != 'o' 
                            && type != 'O') {
                        System.out.println("Invalid Input!");
                        break;
                    }
                        
                    /* Input the general required info */
                    System.out.print("name: ");
                    name = input.next();
                        
                    System.out.print("composition: ");
                    composition = input.next();
                        
                    System.out.print("dose: ");
                    dose = input.nextInt();
                              
                    System.out.print("quantity: ");
                    quantity = input.nextInt();
                        
                    System.out.print("price: ");
                    price = input.nextDouble();
                        
                    /* If the mididce is over the counter, input its minimum 
                       age */
                    if (type == 'o' || type == 'O') {
                        System.out.print("Enter the minimum Age"
                                         + " for this medicine: ");
                        minAge = input.nextInt();
                        
                        /* create overTheCounter medicine with taken
                        information */
                        OverTheCounter o = new OverTheCounter(name, composition,
                                                 dose, price, quantity, minAge);
                        
                        /* add the medicine to the pharmacy */
                        myPharma.addMedicine(o);
                        
                        /* if medicine requires prescription, input the docotor
                           specialization */
                    } else if (type == 'p' || type == 'P') {
                        System.out.print("Enter the doctor specialization"
                                         + " for this medicine: ");
                        doctorSpecialization = input.next();
                        
                        /* Create Prescription medicine with taken information*/
                        Prescription p = new Prescription(name, composition,
                                   dose, price, quantity, doctorSpecialization);
                        
                        /* add the medicine to the pharmacy */
                        myPharma.addMedicine(p);
                    }
                        
                    System.out.println("-------------------------------"
                                       + "------------------");  
                    break;
                        
                /* Search for a medicine by name */
                case 2: 
                    System.out.println("Enter the name of the medicine "
                                       + "to be found: ");
                    name = input.next();
                        
                    /* call searchByName method from class Pharmacy */
                    int[] names = myPharma.searcByName(name);
                    
                    /* Print how many medicines are found */
                    System.out.println(names.length + ((names.length > 1)?
                                       " medicines" : " medicine") + " found");
                        
                    /* Print information about the found medicines */
                    Medicine[] m1 = myPharma.getMedicines();
                    for(int i = 0; i < names.length; i++) {
                        System.out.println((i+1) + "- " + m1[names[i]]);
                    }
                        
                    System.out.println("-----------------------------------"
                                       + "--------------");
                    break;
                
                /* Search for a medicine by composition */
                case 3: 
                    System.out.println("Enter the composition to be found: ");
                    composition = input.next();
                        
                    /* call searchByComposition method from class Pharmacy */
                    int[] compositions =
                            myPharma.searchByComposition(composition);
                    
                    /* print how many medicines are found */
                    System.out.println(compositions.length 
                                       + ((compositions.length > 1)? 
                                       " medicines" : " medicine") + " found");
                        
                    /* print informationn about the found medicines */
                    Medicine[] m2 = myPharma.getMedicines();
                    for (int i = 0; i < compositions.length; i++) {
                        System.out.println((i+1) + "- " + m2[compositions[i]]);
                    }
                        
                    System.out.println("----------------------------------"
                                       + "---------------");
                    break;
                
                /* Sell medicine */
                case 4: 
                    /* Input required information from the user */
                    System.out.print("Enter the name of the medicine: ");
                    name = input.next();
                    System.out.print("Enter the dose: ");
                    dose = input.nextInt();
                    System.out.print("Enter the quantity: ");
                    quantity = input.nextInt();
                        
                    /* call sellMedicine method from class Pharmacy */
                    myPharma.sellMedicine(name, dose, quantity);
                        
                    System.out.println("----------------------------------"
                                       + "---------------");
                    break;
                
                /* Restock Medicine */
                case 5: 
                     /* Input required information from the user */
                    System.out.print("Enter the name of the medicine: ");
                    name = input.next();
                    System.out.print("Enter the dose: ");
                    dose = input.nextInt();
                    System.out.print("Enter the quantity: ");
                    quantity = input.nextInt();
                        
                    /* call restock method from class Pharmacy and check if it
                       succeeded */
                    if (myPharma.restock(name, dose, quantity)) {
                        System.out.println("Restock successful");
                    } else {
                        System.out.println("Restock Failed! "
                                           + "Medicine not found");
                    }
                        
                    System.out.println("-------------------------------"
                                       + "------------------");
                    break;
                
                /* Display all medicines */
                case 6: 
                    /* get all medicines in class Pharmacy in an array*/
                    Medicine[] m3 = myPharma.getMedicines();
                    
                    /* print information about all the medicines */
                    for (int i = 0; i < myPharma.getNumberOfMedicines(); i++){
                        System.out.println("Medicine " + (i+1) + ": " 
                                           + m3[i].toString());
                        System.out.println("----");
                   }
                        
                    System.out.println("--------------------------------"
                                       + "-----------------");
                    break;
                
                 /* Display Pharmacy information */
                case 7: 
                    System.out.println(myPharma);
                    System.out.println("-------------------------------"
                                       + "------------------");
                    break;
                      
                /* Exit Program */
                case 8:
                    System.exit(0);
                    break;
                
                default: break;
            }
        }
        
    }
    
    /**
     * ...non-argumentative method menu()
     * @return user's choice
     */
    public static int menu(){
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("1- Add a new medicine"
                         + "\n2- Search for a medicine by name" 
                         + "\n3- Search for a medicine by composition" 
                         + "\n4- Sell a medicine" 
                         + "\n5- Restock a medicine" 
                         + "\n6- Dsplay all medicines" 
                         + "\n7- Display information" 
                         + "\n8- Exit");
        
        System.out.print("Enter your choice (between 1 and 8): ");
        
        return input.nextInt();
    }
    
}
