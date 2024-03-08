package com.cabbooking.repository;

import com.cabbooking.model.Driver;
import com.cabbooking.utils.Constants;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DriverRepositoryImpl implements DriverRepository {
    private final List<Driver> drivers = new ArrayList<>();
@   Override
    public void save(final Driver driver) {
        drivers.add(driver);
    }

    @Override
    public List<Driver> getAvailableDrivers(final int[] source, final int[] destination) {
        final List<Driver> availableDrivers = new ArrayList<>();
        for (Driver driver : drivers) {
            if (driver.isAvailable() && isWithinDistance(driver.getCurrentLocation(), source, destination)) {
                availableDrivers.add(driver);
            }
        }
        return availableDrivers;
    }

    private boolean isWithinDistance(final int[] driverLocation, final int[] source, final int[] destination) {
        double distance = Math.sqrt(Math.pow(driverLocation[0] - source[0], 2) +
                Math.pow(driverLocation[1] - source[1], 2));
        return distance <= Constants.MAX_DISTANCE_LIMIT;
    }
}
