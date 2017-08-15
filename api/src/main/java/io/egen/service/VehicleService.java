package io.egen.service;

import io.egen.entity.Vehicle;

import java.util.List;

public interface VehicleService {

    List<Vehicle> findAll();
    Vehicle findOne(String vin);
    Vehicle create(Vehicle vel);
    Vehicle update(String vin, Vehicle vel);
    void delete(String vin);


}
