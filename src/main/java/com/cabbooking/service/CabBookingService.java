package com.cabbooking.service;

import com.cabbooking.model.Driver;
import com.cabbooking.model.User;

import java.util.List;

public interface CabBookingService {
    void addUser(final String name, final String gender, final int age);
    User getUser(final String username);
    void addDriver(final String name, final String gender, final String vehicleDetails, final int[] currentLocation);
    List<Driver> findRide(final String username, final int[] source, final int[] destination);
    void chooseRide(final String username, final String driverName);
}
