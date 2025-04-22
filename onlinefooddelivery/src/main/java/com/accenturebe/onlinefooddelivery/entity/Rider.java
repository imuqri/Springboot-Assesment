package com.accenturebe.onlinefooddelivery.entity;

import jakarta.persistence.*;

@Entity
public class Rider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String vehicleType;
    private String vehicleNumber;
    private String location;

    // Constructors
    public Rider(String name, String vehicleType, String vehicleNumber, String location) {
        this.name = name;
        this.vehicleType = vehicleType;
        this.vehicleNumber = vehicleNumber;
        this.location = location;
    }
}
