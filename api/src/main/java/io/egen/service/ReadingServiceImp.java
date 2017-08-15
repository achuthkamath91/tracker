package io.egen.service;

import io.egen.Exceptions.ResourceNotFoundException;
import io.egen.entity.Reading;
import io.egen.repository.ReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReadingServiceImp implements ReadingService {

    @Autowired
    @Qualifier("reading")
    ReadingRepository readrepository;

    @Transactional(readOnly = true)
    public List<Reading> findAll() {
        return readrepository.findAll();
    }

    @Transactional(readOnly = true)
    public Reading findOne(String vin) {
        Reading existing =  readrepository.findOne(vin);
        if (existing == null) {
            throw new ResourceNotFoundException("Reading with vin " + vin + " doesn't exist.");
        }
        return existing;
    }

    @Transactional
    public Reading create(Reading vel) {
        Reading existing =  readrepository.findOne(vel.getVin());
        if (existing == null) {
            return readrepository.create(vel);
        }else{
            return readrepository.update(vel);
        }
    }

    @Transactional
    public Reading update(String vin,Reading vel) {
        Reading existing =  readrepository.findOne(vin);
        if (existing == null) {
            throw new ResourceNotFoundException("Reading with vin " + vel.getVin() + " doesn't exist.");
        }
        return readrepository.update(vel);
    }

    @Transactional
    public void delete(String vin) {
        Reading existing =  readrepository.findOne(vin);
        if (existing == null) {
            throw new ResourceNotFoundException("Reading with vin " + vin + " doesn't exist.");
        }
        readrepository.delete(existing);
    }


}
