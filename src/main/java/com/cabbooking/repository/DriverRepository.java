package com.cabbooking.repository;

import com.cabbooking.model.Driver;

import java.util.List;

public interface DriverRepository {
    void save(Driver driver);
    List<Driver> getAvailableDrivers(final int[] source, final int[] destination);
}
