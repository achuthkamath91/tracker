package io.egen.service;

import io.egen.entity.Reading;
import io.egen.entity.Vehicle;

import java.util.List;

public interface ReadingService {

    List<Reading> findAll();
    Reading findOne(String vin);
    Reading create(Reading red);
    Reading update(String vin, Reading red);
    void delete(String vin);
}
