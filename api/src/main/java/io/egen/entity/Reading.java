package io.egen.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name ="Reading.findAll",query="SELECT red FROM Reading red"),
        @NamedQuery(name ="Reading.findbyId",query="SELECT red FROM Reading red WHERE red.vin =:paramVin")
})
public class Reading {

    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private String vin;
    private String latitude;
    private String longitude;
    private String timestamp;
    private String fuelVolume;
    private String speed;
    private String engineHp;
    private String checkEngineLightOn;
    private String engineCoolantLow;
    private String cruiseControlOn;
    private String engineRpm;
    private List<String> tires;


    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getFuelVolume() {
        return fuelVolume;
    }

    public void setFuelVolume(String fuelVolume) {
        this.fuelVolume = fuelVolume;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getEngineHp() {
        return engineHp;
    }

    public void setEngineHp(String engineHp) {
        this.engineHp = engineHp;
    }

    public String getCheckEngineLightOn() {
        return checkEngineLightOn;
    }

    public void setCheckEngineLightOn(String checkEngineLightOn) {
        this.checkEngineLightOn = checkEngineLightOn;
    }

    public String getEngineCoolantLow() {
        return engineCoolantLow;
    }

    public void setEngineCoolantLow(String engineCoolantLow) {
        this.engineCoolantLow = engineCoolantLow;
    }

    public String getCruiseControlOn() {
        return cruiseControlOn;
    }

    public void setCruiseControlOn(String cruiseControlOn) {
        this.cruiseControlOn = cruiseControlOn;
    }

    public String getEngineRpm() {
        return engineRpm;
    }

    public void setEngineRpm(String engineRpm) {
        this.engineRpm = engineRpm;
    }

    public List<String> getTires() {
        return tires;
    }

    public void setTires(List<String> tires) {
        this.tires = tires;
    }

    @Override
    public String toString() {
        return "Reading{" +
                "vin='" + vin + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", fuelVolume='" + fuelVolume + '\'' +
                ", speed='" + speed + '\'' +
                ", engineHp='" + engineHp + '\'' +
                ", checkEngineLightOn='" + checkEngineLightOn + '\'' +
                ", engineCoolantLow='" + engineCoolantLow + '\'' +
                ", cruiseControlOn='" + cruiseControlOn + '\'' +
                ", engineRpm='" + engineRpm + '\'' +
                ", tires=" + tires +
                '}';
    }
}
