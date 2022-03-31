package com.mycompany.inclass;

/**
 *
 * @author Grant
 */
public class MyClass {
    private String firstName;
    private String lastName;
    
    public MyClass(){

    }
    
    public MyClass(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    
    public void setFirstName(String name){
        this.firstName = name;
    }
    
    public void setLastName(String name){
        this.lastName = name;
    }
    
    public String getFirstName(){
        return this.firstName;
    }
    
    public String getLastName(){
        return this.lastName;
    }
}
