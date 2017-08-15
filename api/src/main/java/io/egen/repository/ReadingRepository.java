package io.egen.repository;

import io.egen.entity.Reading;

import java.util.List;

public interface ReadingRepository {
        List<Reading> findAll();
        Reading findOne(String vin);
        Reading create(Reading vel);
        Reading update(Reading vel);
        void delete(Reading vel);
}
