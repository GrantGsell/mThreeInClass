package com.mycompany.inclass;

/**
 *
 * @author Grant
 */
public class InClass_3_31 {
    
    
    public static void main(String []args){
        // Create car object
        Car bmw = new Car();
        
        // Set car fields
        bmw.setMpg(17.5);
        bmw.setPlateNumber("a4n28icaza");
        bmw.setModelYear(2002);
        bmw.setTankSize(18);
        
        // Create book object
        Book book = new Book();
        book.setName("Dune");
        book.setAuthor("Frank Herbert");
        book.setNumPages(479);
        book.setPrice(11.99);
        
        // Create output string
        String output = String.format("\nOn the side of the road there was a \n"
                + "broken down car. The car was a %d %s with the licence plate \n"
                + "%s. Inside the car was a copy of %s by %s that cost %.2f.", 
                bmw.getModelYear(), "bmw", bmw.getLicencePlate(), book.getName()
                , book.getAuthor(), book.getPrice());
        
        // Display the output
        System.out.print(output);
        
        
    }
}
