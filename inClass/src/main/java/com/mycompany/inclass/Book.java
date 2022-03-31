package com.mycompany.inclass;

/**
 *
 * @author Grant
 */
public class Book {
    // Book Class fields
    private String name;
    private String author;
    private int numPages;
    private double price;
    
    // Constructor
    public Book(){
        
    }
    
    // Set field methods
    public void setName(String bookName){
        this.name = bookName;
    }
    
    public void setAuthor(String authorName){
        this.author = authorName;
    }
    
    public void setNumPages(int pages){
        this.numPages = pages;
    }
    
    public void setPrice(double price){
        this.price = price;
    }
    
    // Get object field methods
    public String getName(){
        return this.name;
    }
    
    public String getAuthor(){
        return this.author;
    }
    
    public int getNumberOfPages(){
        return this.numPages;
    }
    
    public double getPrice(){
        return this.price;
    }
}
