package io.egen.service;

import io.egen.Exceptions.ResourceNotFoundException;
import io.egen.entity.Vehicle;
import io.egen.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VehicleServiceImp implements VehicleService {

    @Autowired
    VehicleRepository repository;

    @Transactional(readOnly = true)
    public List<Vehicle> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Vehicle findOne(String vin) {
        Vehicle existing =  repository.findOne(vin);
        if (existing == null) {
            throw new ResourceNotFoundException("Vehicle with vin " + vin + " doesn't exist.");
        }
        return existing;
    }

    @Transactional
    public Vehicle create(Vehicle vel) {
        Vehicle existing =  repository.findOne(vel.getVin());
        if (existing == null) {
           return repository.create(vel);
        }else{
            return repository.update(vel);
        }
    }

    @Transactional
    public Vehicle update(String vin,Vehicle vel) {
        Vehicle existing =  repository.findOne(vin);
        if (existing == null) {
            throw new ResourceNotFoundException("Vehicle with vin " + vel.getVin() + " doesn't exist.");
        }
        return repository.update(vel);
    }

    @Transactional
    public void delete(String vin) {
        Vehicle existing =  repository.findOne(vin);
        if (existing == null) {
            throw new ResourceNotFoundException("Vehicle with vin " + vin + " doesn't exist.");
        }
        repository.delete(existing);
    }
}
