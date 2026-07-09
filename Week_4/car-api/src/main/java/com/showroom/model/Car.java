package com.showroom.model;

import jakarta.persistence.*;

@Entity
@Table(name = "showroom_cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //automaticaly generate unique primary key 
    private long id;

    private String brand;
    private String modelName;
    private String segment; //suv sedan hatchback
    private double price; 

    public Car() {}

    // Overloaded Constructor
    public Car(String brand, String modelName, String segment, double price) {
        this.brand = brand;
        this.modelName = modelName;
        this.segment = segment;
        this.price = price;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getModelName() { return modelName; }
    public void setModelName(String modelName) { this.modelName = modelName; }

    public String getSegment() { return segment; }
    public void setSegment(String segment) { this.segment = segment; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

}
