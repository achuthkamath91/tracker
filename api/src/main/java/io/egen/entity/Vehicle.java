package io.egen.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@NamedQueries({
        @NamedQuery(name ="Vehicle.findAll",query="SELECT vel FROM Vehicle vel"),
        @NamedQuery(name ="Vehicle.findbyId",query="SELECT vel FROM Vehicle vel WHERE vel.vin =:paramVin")
})
public class Vehicle {

    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private String vin;
    private String make;
    private String model;
    private String year;
    private String redlineRpm;
    private String maxFuelVolume;
    private String lastServiceDate;

    public Vehicle(){
        this.vin  = UUID.randomUUID().toString();
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRedlineRpm() {
        return redlineRpm;
    }

    public void setRedlineRpm(String redlineRpm) {
        this.redlineRpm = redlineRpm;
    }

    public String getMaxFuelVolume() {
        return maxFuelVolume;
    }

    public void setMaxFuelVolume(String maxFuelVolume) {
        this.maxFuelVolume = maxFuelVolume;
    }

    public String getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(String lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }
}
