package com.cabbooking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Driver {
    private final String name;
    private final String gender;
    private String vehicleDetails;
    private boolean available;
    private int[] currentLocation;

    public Driver(String name, String gender, String vehicleDetails, int[] currentLocation) {
        this.name = name;
        this.gender = gender;
        this.vehicleDetails = vehicleDetails;
        this.currentLocation = currentLocation;
        this.available = true;
    }
}
