package io.egen.repository;

import io.egen.entity.Vehicle;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class VehicleRepositoryImp implements VehicleRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Vehicle> findAll() {
        TypedQuery<Vehicle> query = entityManager.createNamedQuery("Vehicle.findAll", Vehicle.class);
        return query.getResultList();
    }

    public Vehicle findOne(String vin) {
        TypedQuery<Vehicle> query = entityManager.createNamedQuery("Vehicle.findbyId",Vehicle.class);
        query.setParameter("paramVin", vin);
        List<Vehicle> resultList = query.getResultList();
        if (resultList != null && resultList.size() == 1) {
            return resultList.get(0);
        } else {
            return null;
        }
    }

    public Vehicle create(Vehicle vel) {
        entityManager.persist(vel);
        return vel;
    }

    public Vehicle update(Vehicle vel) {
        return entityManager.merge(vel);
    }

    public void delete(Vehicle vel) {
        entityManager.remove(vel);
    }
}
