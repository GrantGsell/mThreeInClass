package com.mycompany.inclass;

/**
 *
 * @author Grant
 */
public class Car {
    private double mpg;
    private int tankSize;
    private String plateNumber;
    private int modelYear;
    
    public Car(){
        
    }
    
    public void setMpg(double mpg){
        this.mpg = mpg;        
    }
    
    public void setTankSize(int size){
        this.tankSize = size;    
    }
    
    public void setPlateNumber(String licencePlate){
        this.plateNumber = licencePlate;
    }
    
    public void setModelYear(int year){
        this.modelYear = year;
    }
    
    public double getMpg(){
        return this.mpg;
    }
    
    public int getGasTankSize(){
        return this.tankSize;
    }
    
    public String getLicencePlate(){
        return this.plateNumber;
    }
    
    public int getModelYear(){
        return this.modelYear;
    }
}
