package io.egen.controller;

import io.egen.entity.Reading;
import io.egen.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/readings")
@CrossOrigin(origins = "http://mocker.egen.io")
public class ReadingController {

    @Autowired
    ReadingService readingService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Reading> findAll() {
        return readingService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{vin}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Reading findOne(@PathVariable("vin") String vid) {
        return readingService.findOne(vid);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Reading create(@RequestBody Reading vel) {
        return readingService.create(vel);
    }

    @RequestMapping(method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Reading update(@PathVariable("vin") String vId, @RequestBody Reading vel) {
//        if (vel != null) {
//            console.debug(vel);
//        }
        return readingService.update(vId, vel);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{vin}")
    public void delete(@PathVariable("vin") String vId) {
        readingService.delete(vId);
    }

}
