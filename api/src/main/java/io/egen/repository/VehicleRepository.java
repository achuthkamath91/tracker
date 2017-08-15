package io.egen.repository;

import io.egen.entity.Vehicle;

import java.util.List;

public interface VehicleRepository {

    List<Vehicle> findAll();
    Vehicle findOne(String vin);
    Vehicle create(Vehicle vel);
    Vehicle update(Vehicle vel);
    void delete(Vehicle vel);

}
