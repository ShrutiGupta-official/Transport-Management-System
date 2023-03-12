package com.cts.driver.Service;

import java.util.List;

import com.cts.driver.Entity.DriverEntity;


public interface DriverService {

    public List<DriverEntity> getAllDrivers();

    public DriverEntity addDriver(DriverEntity d);

    public void deleteDriver(String srNo);

    public List<DriverEntity> getDriversByVehicleTypeSedan();

    public List<DriverEntity> getDriversByVehicleTypeSUV();

    public List<DriverEntity> getDriversByVehicleTypeVan();
}
