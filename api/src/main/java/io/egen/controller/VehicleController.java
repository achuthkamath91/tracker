package io.egen.controller;

import io.egen.entity.Vehicle;
import io.egen.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value="/vehicles")
@CrossOrigin(origins = "http://mocker.egen.io")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Vehicle> findAll() {
        return vehicleService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{vin}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Vehicle findOne(@PathVariable("vin") String vid) {
        return vehicleService.findOne(vid);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Vehicle create(@RequestBody Vehicle vel) {
        return vehicleService.create(vel);
    }

    @RequestMapping(method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Vehicle update(@PathVariable("vin") String vId, @RequestBody Vehicle vel) {
//        if (vel != null) {
//            console.debug(vel);
//        }
        return vehicleService.update(vId, vel);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{vin}")
    public void delete(@PathVariable("vin") String vId) {
        vehicleService.delete(vId);
    }

    @RequestMapping(method = RequestMethod.OPTIONS)
    public void commonOptions(HttpServletResponse theHttpServletResponse) {
        theHttpServletResponse.addHeader("Access-Control-Allow-Headers", "origin, content-type, accept, x-requested-with");
        theHttpServletResponse.addHeader("Access-Control-Max-Age", "60"); // seconds to cache preflight request --> less OPTIONS traffic
        theHttpServletResponse.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, OPTIONS");
        theHttpServletResponse.addHeader("Access-Control-Allow-Origin", "*");
    }

}
