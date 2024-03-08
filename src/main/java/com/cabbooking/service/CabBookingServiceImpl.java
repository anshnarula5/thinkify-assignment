package com.cabbooking.service;

import com.cabbooking.model.Driver;
import com.cabbooking.model.User;
import com.cabbooking.repository.DriverRepositoryImpl;
import com.cabbooking.repository.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CabBookingServiceImpl implements CabBookingService {
    private final UserRepositoryImpl userRepositoryImpl;
    private final DriverRepositoryImpl driverRepositoryImpl;
    private final Map<String, Driver> driversMap;

    @Autowired
    public CabBookingServiceImpl(final UserRepositoryImpl userRepositoryImpl, final DriverRepositoryImpl driverRepositoryImpl) {
        this.userRepositoryImpl = userRepositoryImpl;
        this.driverRepositoryImpl = driverRepositoryImpl;
        this.driversMap = new HashMap<>();
    }
    @Override
    public void addUser(final String name, final String gender, final int age) {
        userRepositoryImpl.save(new User(name, gender, age));
    }

    @Override
    public User getUser(final String username) {
        final List<User> users = userRepositoryImpl.getAllUsers();
        for (User user : users) {
            if (user.getName().equals(username)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void addDriver(final String name, final String gender, final String vehicleDetails, final int[] currentLocation) {
        final Driver driver = new Driver(name, gender, vehicleDetails, currentLocation);
        driversMap.put(name, driver);
        driverRepositoryImpl.save(driver);
    }

    @Override
    public List<Driver> findRide(final String username, final int[] source, final int[] destination) {
        return driverRepositoryImpl.getAvailableDrivers(source, destination);
    }

    @Override
    public void chooseRide(final String username, final String driverName) {
        final User user = getUser(username);
        if (user == null) {
            throw new IllegalArgumentException("User not found: " + username);
        }
        final Driver driver = driversMap.get(driverName);
        if (driver == null) {
            throw new IllegalArgumentException("Driver not found: " + driverName);
        }
        user.setChosenRide(driverName);
        System.out.println(username + " has chosen ride with " + driverName);
    }
}
