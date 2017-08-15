package io.egen.repository;

import io.egen.entity.Reading;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository("Reading")
public class ReadingRepositoryImp implements ReadingRepository{

    @PersistenceContext
    private EntityManager entityManager;

    public List<Reading> findAll() {
        TypedQuery<Reading> query = entityManager.createNamedQuery("Reading.findAll", Reading.class);
        return query.getResultList();
    }

    public Reading findOne(String vin) {
        TypedQuery<Reading> query = entityManager.createNamedQuery("Reading.findbyId",Reading.class);
        query.setParameter("paramVin", vin);
        List<Reading> resultList = query.getResultList();
        if (resultList != null && resultList.size() == 1) {
            return resultList.get(0);
        } else {
            return null;
        }
    }

    public Reading create(Reading vel) {
        entityManager.persist(vel);
        return vel;
    }

    public Reading update(Reading vel) {
        return entityManager.merge(vel);
    }

    public void delete(Reading vel) {
        entityManager.remove(vel);
    }
}
